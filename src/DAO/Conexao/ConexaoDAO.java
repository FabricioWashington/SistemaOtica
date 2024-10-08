package DAO.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/sistema_otica?user=root&password=washingtontech";

    public static Connection conectaBD() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro em CONEXAODAO\n Verifique a conexão com o banco de dados\n" + e);
        }
        return conn;
    }

}
