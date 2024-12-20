package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.ClienteDTO;
import DTO.Crud.EmpresaDTO;
import DTO.Crud.PessoaFisicaDTO;
import DTO.Crud.PessoaJuridicaDTO;
import DTO.Contato_Endereco.ContatoDTO;
import DTO.Contato_Endereco.EnderecoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    public void cadastrarClientePJ(ClienteDTO cadastroClienteDTO, PessoaJuridicaDTO cadastroPessoaJuridicaDTO, EnderecoDTO cadastroEnderecodto, ContatoDTO cadastroContatodto) {
        conn = new ConexaoDAO().conectaBD();
        int idClientes = -1;
        int idContato = -1; // Valor padrão para indicar erro
        int idEndereco = -1;

        try {
            conn.setAutoCommit(false); // Desliga o modo de commit automático

            // Registrar o contato
            String sqlContato = "insert into contato (Email, idDDD, Telefone, Telefone2) values (?,?,?,?)";
            PreparedStatement pstmContato = conn.prepareStatement(sqlContato, Statement.RETURN_GENERATED_KEYS);
            pstmContato.setString(1, cadastroContatodto.getEmail());
            pstmContato.setInt(2, cadastroContatodto.getIdDDD());
            pstmContato.setString(3, cadastroContatodto.getTelefone());
            pstmContato.setString(4, cadastroContatodto.getTelefone2());
            pstmContato.executeUpdate(); // Use executeUpdate() para inserções

            // Recuperar o idContato gerado
            ResultSet rsContato = pstmContato.getGeneratedKeys();
            if (rsContato.next()) {
                idContato = rsContato.getInt(1);
            }

            // Registrar o endereço
            String sqlEndereco = "insert into endereco (Logradouro, Bairro, Numero, Complemento, CEP, UF, Municipio) values (?,?,?,?,?,?,?)";
            PreparedStatement pstmEndereco = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
            pstmEndereco.setString(1, cadastroEnderecodto.getLogradouro());
            pstmEndereco.setString(2, cadastroEnderecodto.getBairro());
            pstmEndereco.setString(3, cadastroEnderecodto.getNumero());
            pstmEndereco.setString(4, cadastroEnderecodto.getComplemento());
            pstmEndereco.setString(5, cadastroEnderecodto.getCEP());
            pstmEndereco.setString(6, cadastroEnderecodto.getUF());
            pstmEndereco.setString(7, cadastroEnderecodto.getMunicipio());
            pstmEndereco.executeUpdate(); // Use executeUpdate() para inserções

            // Recuperar o idEndereco gerado
            ResultSet rsEndereco = pstmEndereco.getGeneratedKeys();
            if (rsEndereco.next()) {
                idEndereco = rsEndereco.getInt(1);
            }

            // Registrar o cadastro do cliente
            String sqlCadastro = "insert into clientes (nome, idEndereco, idContato, Data_Cadastro, Data_Modificacao) values (?,?,?,?,?)";
            PreparedStatement pstmCadastro = conn.prepareStatement(sqlCadastro, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmCadastro.setString(1, cadastroClienteDTO.getNome());
            pstmCadastro.setInt(2, idEndereco); // Usar o ID gerado para o endereço
            pstmCadastro.setInt(3, idContato);  // Usar o ID gerado para o contato
            pstmCadastro.setTimestamp(4, new java.sql.Timestamp(cadastroClienteDTO.getDataCadastro().getTime()));
            pstmCadastro.setTimestamp(5, new java.sql.Timestamp(cadastroClienteDTO.getDataModificacao().getTime()));

            pstmCadastro.executeUpdate();

            // Obter o ID gerado automaticamente para o cliente
            ResultSet rsIdClientes = pstmCadastro.getGeneratedKeys();
            if (rsIdClientes.next()) {
                idClientes = rsIdClientes.getInt(1);
            }

            // Registrar o cadastro do cliente pj
            String sqlCadastroPj = "insert into pessoajuridica (nome_fantasia, cnpj, inscricao_estadual, inscricao_municipal, idCliente) values (?,?,?,?,?)";
            PreparedStatement pstmPj = conn.prepareStatement(sqlCadastroPj);
            pstmPj.setString(1, cadastroPessoaJuridicaDTO.getNomeFantasia());
            pstmPj.setString(2, cadastroPessoaJuridicaDTO.getCnpj());
            pstmPj.setString(3, cadastroPessoaJuridicaDTO.getInscricaoEstadual());
            pstmPj.setString(4, cadastroPessoaJuridicaDTO.getInscricaoMunicipal());
            pstmPj.setInt(5, idClientes);

            pstmPj.executeUpdate();

            conn.commit(); // Efetua o commit das transações

            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse cliente já foi cadastrado no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback(); // Em caso de erro, faz rollback para desfazer as alteraçõesclientes
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true); // Restaura o modo de commit automático
                conn.close(); // Fecha a conexão
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void cadastrarClientePF(ClienteDTO cadastroClienteDTO, PessoaFisicaDTO cadastroPessoaFisicaDTO, EnderecoDTO cadastroEnderecodto, ContatoDTO cadastroContatodto) {
        conn = new ConexaoDAO().conectaBD();
        int idClientes = -1;
        int idContato = -1; // Valor padrão para indicar erro
        int idEndereco = -1;

        try {
            conn.setAutoCommit(false); // Desliga o modo de commit automático

            // Registrar o contato
            String sqlContato = "insert into contato (Email, idDDD, Telefone, Telefone2) values (?,?,?,?)";
            PreparedStatement pstmContato = conn.prepareStatement(sqlContato, Statement.RETURN_GENERATED_KEYS);
            pstmContato.setString(1, cadastroContatodto.getEmail());
            pstmContato.setInt(2, cadastroContatodto.getIdDDD());
            pstmContato.setString(3, cadastroContatodto.getTelefone());
            pstmContato.setString(4, cadastroContatodto.getTelefone2());
            pstmContato.executeUpdate(); // Use executeUpdate() para inserções

            // Recuperar o idContato gerado
            ResultSet rsContato = pstmContato.getGeneratedKeys();
            if (rsContato.next()) {
                idContato = rsContato.getInt(1);
            }

            // Registrar o endereço
            String sqlEndereco = "insert into endereco (Logradouro, Bairro, Numero, Complemento, CEP, UF, Municipio) values (?,?,?,?,?,?,?)";
            PreparedStatement pstmEndereco = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
            pstmEndereco.setString(1, cadastroEnderecodto.getLogradouro());
            pstmEndereco.setString(2, cadastroEnderecodto.getBairro());
            pstmEndereco.setString(3, cadastroEnderecodto.getNumero());
            pstmEndereco.setString(4, cadastroEnderecodto.getComplemento());
            pstmEndereco.setString(5, cadastroEnderecodto.getCEP());
            pstmEndereco.setString(6, cadastroEnderecodto.getUF());
            pstmEndereco.setString(7, cadastroEnderecodto.getMunicipio());
            pstmEndereco.executeUpdate(); // Use executeUpdate() para inserções

            // Recuperar o idEndereco gerado
            ResultSet rsEndereco = pstmEndereco.getGeneratedKeys();
            if (rsEndereco.next()) {
                idEndereco = rsEndereco.getInt(1);
            }

            // Registrar o cadastro do cliente
            String sqlCadastro = "insert into clientes (nome, idEndereco, idContato, Data_Cadastro, Data_Modificacao) values (?,?,?,?,?)";
            PreparedStatement pstmCadastro = conn.prepareStatement(sqlCadastro, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmCadastro.setString(1, cadastroClienteDTO.getNome());
            pstmCadastro.setInt(2, idEndereco); // Usar o ID gerado para o endereço
            pstmCadastro.setInt(3, idContato);  // Usar o ID gerado para o contato
            pstmCadastro.setTimestamp(4, new java.sql.Timestamp(cadastroClienteDTO.getDataCadastro().getTime()));
            pstmCadastro.setTimestamp(5, new java.sql.Timestamp(cadastroClienteDTO.getDataModificacao().getTime()));

            pstmCadastro.executeUpdate();

            // Obter o ID gerado automaticamente para o cliente
            ResultSet rsIdClientes = pstmCadastro.getGeneratedKeys();
            if (rsIdClientes.next()) {
                idClientes = rsIdClientes.getInt(1);
            }

            // Registrar o cadastro do cliente pf
            String sqlCadastroPf = "insert into pessoafisica (cpf, idCliente) values (?,?)";
            PreparedStatement pstmPf = conn.prepareStatement(sqlCadastroPf);
            pstmPf.setString(1, cadastroPessoaFisicaDTO.getCpf());
            pstmPf.setInt(2, idClientes);

            pstmPf.executeUpdate();
            conn.commit(); // Efetua o commit das transações

            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse cliente já foi cadastrado no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showInputDialog(e);
            try {
                conn.rollback(); // Em caso de erro, faz rollback para desfazer as alteraçõesclientes
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true); // Restaura o modo de commit automático
                conn.close(); // Fecha a conexão
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> listaClientes = new ArrayList<>();
        conn = new ConexaoDAO().conectaBD();

        String sql = "SELECT "
                + "c.idClientes AS ID, "
                + "c.nome AS Nome, "
                + "CASE "
                + "    WHEN pf.cpf IS NOT NULL THEN 'Pessoa Física' "
                + "    WHEN pj.cnpj IS NOT NULL THEN 'Pessoa Jurídica' "
                + "END AS Tipo, "
                + "COALESCE(pf.cpf, pj.cnpj) AS 'CPF/CNPJ', "
                + "e.Bairro AS Endereco, "
                + "CONCAT(co.Telefone, ' / ', co.Telefone2) AS Contato, "
                + "c.Data_Cadastro AS 'Data Cadastro' "
                + "FROM clientes c "
                + "LEFT JOIN pessoafisica pf ON c.idClientes = pf.idCliente "
                + "LEFT JOIN pessoajuridica pj ON c.idClientes = pj.idCliente "
                + "LEFT JOIN endereco e ON c.idEndereco = e.idEndereco "
                + "LEFT JOIN contato co ON c.idContato = co.idContato";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setIdClientes(rs.getInt("ID"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setTipoCliente(rs.getString("Tipo"));
                cliente.setCpfCnpj(rs.getString("CPF/CNPJ"));
                cliente.setEndereco(rs.getString("Endereco"));
                cliente.setContato(rs.getString("Contato"));
                cliente.setDataCadastro(rs.getTimestamp("Data Cadastro"));

                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return listaClientes;
    }

    public boolean verificarCadastroPJ(EmpresaDTO objcadastroempresadto) {
        conn = new ConexaoDAO().conectaBD();
        boolean empresaCadastrada = false;

        try {
            String sqlVerificarEmpresa = "SELECT COUNT(*) FROM cadastro_empresa WHERE Cnpj = ?";
            PreparedStatement pstmVerificarEmpresa = conn.prepareStatement(sqlVerificarEmpresa);
            pstmVerificarEmpresa.setString(1, objcadastroempresadto.getCnpj());
            ResultSet rsVerificarEmpresa = pstmVerificarEmpresa.executeQuery();
            rsVerificarEmpresa.next();
            int countAdmin = rsVerificarEmpresa.getInt(1);

            if (countAdmin >= 1) {
                empresaCadastrada = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close(); // Fecha a conexão
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return empresaCadastrada;
    }

    public boolean verificarCadastroPF(PessoaFisicaDTO objcadastroPessoaFisica) {
        conn = new ConexaoDAO().conectaBD();
        boolean empresaCadastrada = false;

        try {
            String sqlVerificarEmpresa = "SELECT COUNT(*) FROM cadastro_cliente_fisico WHERE CPF = ?";
            PreparedStatement pstmVerificarEmpresa = conn.prepareStatement(sqlVerificarEmpresa);
//            pstmVerificarEmpresa.setString(1, objcadastroPessoaFisica.getCPF());
            ResultSet rsVerificarEmpresa = pstmVerificarEmpresa.executeQuery();
            rsVerificarEmpresa.next();
            int countAdmin = rsVerificarEmpresa.getInt(1);

            if (countAdmin >= 1) {
                empresaCadastrada = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close(); // Fecha a conexão
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return empresaCadastrada;
    }

    
    // Método para atualizar informações do cliente
    public void atualizarCliente(ClienteDTO clienteDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false); // Desliga o modo de commit automático

            String sqlAtualizar = "UPDATE clientes SET nome = ?, Data_Modificacao = ? WHERE idClientes = ?";
            PreparedStatement pstmAtualizar = conn.prepareStatement(sqlAtualizar);

            pstmAtualizar.setString(1, clienteDTO.getNome());
            pstmAtualizar.setTimestamp(2, new java.sql.Timestamp(clienteDTO.getDataModificacao().getTime()));
            pstmAtualizar.setInt(3, clienteDTO.getIdClientes());

            int rowsUpdated = pstmAtualizar.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                conn.commit(); // Confirma a transação
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado para atualizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Método para excluir um cliente
    public void excluirCliente(int idCliente) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            // SQL para excluir cliente
            String sqlExcluirCliente = "DELETE FROM clientes WHERE idClientes = ?";
            PreparedStatement pstmExcluir = conn.prepareStatement(sqlExcluirCliente);
            pstmExcluir.setInt(1, idCliente);

            int rowsDeleted = pstmExcluir.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                conn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado para exclusão.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    
 
    // Método para atualizar Pessoa Jurídica
    public void atualizarClientePJ(PessoaJuridicaDTO pessoaJuridicaDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            String sqlAtualizarPJ = "UPDATE pessoajuridica SET nome_fantasia = ?, cnpj = ?, inscricao_estadual = ?, inscricao_municipal = ? WHERE idCliente = ?";
            pstm = conn.prepareStatement(sqlAtualizarPJ);

            pstm.setString(1, pessoaJuridicaDTO.getNomeFantasia());
            pstm.setString(2, pessoaJuridicaDTO.getCnpj());
            pstm.setString(3, pessoaJuridicaDTO.getInscricaoEstadual());
            pstm.setString(4, pessoaJuridicaDTO.getInscricaoMunicipal());
            pstm.setInt(5, pessoaJuridicaDTO.getIdCliente());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Pessoa Jurídica atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                conn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma Pessoa Jurídica encontrada para atualização.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Pessoa Jurídica: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            fecharConexao();
        }
    }

    // Método para atualizar Pessoa Física
    public void atualizarClientePF(PessoaFisicaDTO pessoaFisicaDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            String sqlAtualizarPF = "UPDATE pessoafisica SET cpf = ? WHERE idCliente = ?";
            pstm = conn.prepareStatement(sqlAtualizarPF);

            pstm.setString(1, pessoaFisicaDTO.getCpf());
            pstm.setInt(2, pessoaFisicaDTO.getIdCliente());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Pessoa Física atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                conn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma Pessoa Física encontrada para atualização.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Pessoa Física: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            fecharConexao();
        }
    }

    // Método para excluir Pessoa Jurídica
    public void excluirClientePJ(int idCliente) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            String sqlExcluirPJ = "DELETE FROM pessoajuridica WHERE idCliente = ?";
            pstm = conn.prepareStatement(sqlExcluirPJ);
            pstm.setInt(1, idCliente);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Pessoa Jurídica excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                conn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma Pessoa Jurídica encontrada para exclusão.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Pessoa Jurídica: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            fecharConexao();
        }
    }

    // Método para excluir Pessoa Física
    public void excluirClientePF(int idCliente) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            String sqlExcluirPF = "DELETE FROM pessoafisica WHERE idCliente = ?";
            pstm = conn.prepareStatement(sqlExcluirPF);
            pstm.setInt(1, idCliente);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Pessoa Física excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                conn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma Pessoa Física encontrada para exclusão.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Pessoa Física: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            fecharConexao();
        }
    }

    // Método auxiliar para fechar conexão
    private void fecharConexao() {
        try {
            conn.setAutoCommit(true);
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}


