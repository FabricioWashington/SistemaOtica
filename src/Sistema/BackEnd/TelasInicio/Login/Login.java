package Sistema.BackEnd.TelasInicio.Login;

import DAO.Login.LoginDAO;
import DTO.Login.LoginDTO;
import Sistema.FrontEnd.TelasPrincipais.Telas.CadastroView;
import Sistema.FrontEnd.TelasPrincipais.Telas.HomeView;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    private boolean loginBemSucedido;
    private String LoginUsuario;
    private String LoginSenha;
    private int idTiposLogin;
    private int selectedIndex;
    private LoginDTO loginDTO;
    private LoginDAO loginDAO;
    private ResultSet rsLoginDAO;

    public Login() {
        this.loginDTO = new LoginDTO();
        this.loginDAO = new LoginDAO();
        this.loginBemSucedido = false;

    }

    public Login(String LoginUsuario, String LoginSenha, int idTiposLogin, JComboBox cbxTipoLogin) {
        this();
        this.LoginUsuario = LoginUsuario;
        this.LoginSenha = LoginSenha;
        this.idTiposLogin = idTiposLogin;
        this.selectedIndex = cbxTipoLogin.getSelectedIndex();
    }

    public void realizarLogin() {
        // Verifique se o índice selecionado é válido
        if (selectedIndex <= 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma opção de acesso válida");
            return;
        }

        loginDTO.setLogin_Usuario(LoginUsuario);
        loginDTO.setLogin_Senha(LoginSenha);
        loginDTO.setIdtipos_login(getIdTiposLogin());

        if (!loginDAO.verificarUsuarioCadastrado(loginDTO)) {
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
            return;
        }

        rsLoginDAO = loginDAO.autenticacaoLogin(loginDTO);

        try {
            if (rsLoginDAO.next()) {
                String nomeUsuario = rsLoginDAO.getString(2);
                String tipoAcesso = loginDAO.ListarTipo_LoginPorId(loginDTO);

                UsuarioLogado usuarioLogado = new UsuarioLogado(nomeUsuario, tipoAcesso);

                // Passar o objeto para todas as telas
                HomeView objhomeview = new HomeView(usuarioLogado);

                // Controle de Acesso
                if ("Funcionario".equals(tipoAcesso)) {
                    // modificar essa logica ou talvez excluir
                }

                objhomeview.setVisible(true);

                loginBemSucedido = true;

                // LOGICA TEMPORARIA PARA TESTE (HOMEVIEW)
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválida");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao processar o login: " + e.getMessage());
        }

    }


    public boolean isLoginBemSucedido() {
        return loginBemSucedido;
    }
    /**
     * @return the LoginUsuario
     */
    public String getLoginUsuario() {
        return LoginUsuario;
    }

    /**
     * @param LoginUsuario the LoginUsuario to set
     */
    public void setLoginUsuario(String LoginUsuario) {
        this.LoginUsuario = LoginUsuario;
    }

    /**
     * @return the LoginSenha
     */
    public String getLoginSenha() {
        return LoginSenha;
    }

    /**
     * @param LoginSenha the LoginSenha to set
     */
    public void setLoginSenha(String LoginSenha) {
        this.LoginSenha = LoginSenha;
    }

    /**
     * @return the selectedIndex
     */
    public int getSelectedIndex() {
        return selectedIndex;
    }

    /**
     * @param selectedIndex the selectedIndex to set
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return the idTiposLogin
     */
    public int getIdTiposLogin() {
        return idTiposLogin;
    }

    /**
     * @param idTiposLogin the idTiposLogin to set
     */
    public void setIdTiposLogin(int idTiposLogin) {
        this.idTiposLogin = idTiposLogin;
    }

}
