package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.UsuariosDAO;
import DAO.Conexao.ConexaoDAO;
import DTO.Crud.UsuariosDTO;
import DAO.Login.LoginDAO;
import DTO.Login.LoginDTO;
import Sistema.BackEnd.Validacoes;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Usuarios {

    // Atributos privados
    private String cpf;
    private String nomeCompleto;
    private String loginUsuario;
    private String loginSenha;
    private int idTipoLogin;
    private Date dataCadastro;
    private Date dataModificacao;
    private Validacoes validador;
    private UsuariosDAO cadastroUsuariosDAO;
    private LoginDAO cadastroLoginDAO;
    private UsuariosDTO cadastroUsuariosDTO;
    private LoginDTO loginDTO;
    private Connection conn;

    
    // Construtor padrão
    public Usuarios() {
        this.validador = new Validacoes();
        this.cadastroUsuariosDAO = new UsuariosDAO();
        this.cadastroLoginDAO = new LoginDAO();
        this.cadastroUsuariosDTO = new UsuariosDTO();
        this.loginDTO = new LoginDTO();
        obterDataAtual(); // Inicializa as datas de cadastro e modificação
    }

    // Construtor com parâmetros
    public Usuarios(String cpf, String nomeCompleto, String loginUsuario, String loginSenha, int idTipoLogin) {
        this(); // Chama o construtor padrão para inicializar o validador e DAO
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.loginUsuario = loginUsuario;
        this.loginSenha = loginSenha;
        this.idTipoLogin = idTipoLogin;
    }

    // Métodos Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getLoginSenha() {
        return loginSenha;
    }

    public void setLoginSenha(String loginSenha) {
        this.loginSenha = loginSenha;
    }

    public int getIdTipoLogin() {
        return idTipoLogin;
    }

    public void setIdTipoLogin(int idTipoLogin) {
        this.idTipoLogin = idTipoLogin;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }


    // Método para obter data e hora atuais
    public void obterDataAtual() {
        Calendar cal = Calendar.getInstance();
        this.dataCadastro = cal.getTime();
        this.dataModificacao = cal.getTime();
    }
    // Método para preencher atributos da classe com base nos campos de entrada
    public void preencherDados(JFormattedTextField txtCpf, JTextField txtNomeCompleto, JTextField txtLoginUsuario, JPasswordField txtLoginSenha, JComboBox<String> cbxTipoLogin) {
        this.cpf = txtCpf.getText().trim();
        this.nomeCompleto = txtNomeCompleto.getText().trim();
        this.loginUsuario = txtLoginUsuario.getText().trim();
        this.loginSenha = new String(txtLoginSenha.getPassword());
        int selectedIndex = cbxTipoLogin.getSelectedIndex();
        this.idTipoLogin = (selectedIndex > 0) ? selectedIndex : -1; // Ajustar o índice se necessário
    }

    // Método para realizar o cadastro
    public void cadastrar() {
        if (!validarCampos()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validador.validarCpf(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Formatar o CPF
        cpf = validador.formatarCpf(cpf);

        // Criar DTOs para cadastro
        cadastroUsuariosDTO.setCPF(cpf);
        cadastroUsuariosDTO.setNome_Completo(nomeCompleto);
        cadastroUsuariosDTO.setData_Cadastro(dataCadastro);
        cadastroUsuariosDTO.setData_Modificacao(dataModificacao);

        try {
            // Iniciar transação
            Connection conn = new ConexaoDAO().conectaBD();
            conn.setAutoCommit(false);  // Desativar commit automático

            // Chamar o método para cadastrar o usuário e obter o ID do usuário
            int idUsuario = cadastroUsuariosDAO.cadastrarUsuario(cadastroUsuariosDTO, conn);

            if (idUsuario > 0) {  // Verifica se o ID foi obtido
                // Criar o DTO de login
                loginDTO.setLogin_Usuario(loginUsuario);
                loginDTO.setLogin_Senha(loginSenha);
                loginDTO.setIdtipos_login(idTipoLogin);
                loginDTO.setIdUsuario(idUsuario);  // Definir o ID do usuário
                loginDTO.setCPF(cpf);  // O CPF também pode ser passado, mas o idUsuario é o mais importante
                loginDTO.setData_Cadastro(dataCadastro);
                loginDTO.setData_Modificacao(dataModificacao);

                // Chamar o método para cadastrar o login
                cadastroLoginDAO.cadastrarLogin(loginDTO, conn);  // Passar a mesma conexão

                // Confirmar a transação
                conn.commit();
                JOptionPane.showMessageDialog(null, "O cadastro foi realizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                conn.rollback();  // Fazer rollback se não conseguir obter o ID do usuário
                JOptionPane.showMessageDialog(null, "Erro ao obter o ID do usuário! -> VERIFICAR EM CadastroUsuarios", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar no banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();  // Fazer rollback em caso de erro
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);  // Restaurar commit automático
                    conn.close();  // Fechar conexão
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    // Método para validar os campos
    private boolean validarCampos() {
        return !cpf.isEmpty() && !nomeCompleto.isEmpty() && !loginUsuario.isEmpty() && !loginSenha.isEmpty() && idTipoLogin > 0;
    }

    // Método para limpar os campos de entrada do formulário
    public void limparCampos(JFormattedTextField txtCpf, JPasswordField txtLoginSenha, JTextField txtNomeCompleto, JComboBox<String> cbxTipoLogin, JTextField txtLoginUsuario) {
        txtCpf.setText("");
        txtLoginSenha.setText("");
        txtLoginUsuario.setText("");
        txtNomeCompleto.setText("");
        cbxTipoLogin.setSelectedIndex(0);
    }
}
