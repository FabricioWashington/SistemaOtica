package DAO.Vetores;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.CategoriaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class VetorCategoria {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ArrayList<Integer> idCategoria = new ArrayList<>();
    private JComboBox<String> cbxCategoria;

    public VetorCategoria(JComboBox<String> cbxCategoria) {
        this.cbxCategoria = cbxCategoria;
    }

    public void restaurarDadosCbxCategoria() {
        try {
            CategoriaDTO cadastroCategoriaDTO = new CategoriaDTO();
            rs = listarCategoria(cadastroCategoriaDTO);

            idCategoria.clear();
            cbxCategoria.removeAllItems();

            cbxCategoria.addItem("Selecione");

            while (rs.next()) {
                idCategoria.add(rs.getInt(1));
                cbxCategoria.addItem(rs.getString(2));
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro em Class VetorCategoria no metodo restaurarDadosCbxCategoria: " + erro);

        }
    }

    private ResultSet listarCategoria(CategoriaDTO cadastroUnidadeDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "select * from categoria order by Nome_Categoria";
        try {
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Integer> getCategoria() {
        return idCategoria;
    }

}
