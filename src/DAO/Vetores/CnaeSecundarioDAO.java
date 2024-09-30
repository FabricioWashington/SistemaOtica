package DAO.Vetores;

import DTO.Vetores.CnaeSecundarioDTO;
import DTO.Login.LoginDTO;
import DAO.Conexao.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CnaeSecundarioDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LoginDTO> lista = new ArrayList<>();

    public ResultSet ListarCNAEsecundario(CnaeSecundarioDTO objcnaeSecundariodto) {
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "SELECT * FROM cnae_secundario ORDER BY CNAE_Secundario";
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
