package DAO.Vetores;

import DTO.Vetores.CnaeDTO;
import DTO.Login.LoginDTO;
import DAO.Conexao.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CnaeDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LoginDTO> lista = new ArrayList<>();

    public ResultSet ListarCNAE(CnaeDTO objcnaedto) {
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "SELECT * FROM cnae ORDER BY CNAE_Principal";
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
