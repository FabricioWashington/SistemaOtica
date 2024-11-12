package DAO.Vetores;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.UnidadeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class VetorUnidade {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ArrayList<Integer> id = new ArrayList<>();
    private JComboBox<String> cbxUnidade;
    
    public VetorUnidade(JComboBox<String> cbxUnidade){
        this.cbxUnidade = cbxUnidade;
    }
    
    public void restaurarDadosCbxUnidade(){
        
        try {
            UnidadeDTO cadastroUnidadeDTO = new UnidadeDTO();
            rs = listarUnidade(cadastroUnidadeDTO);
            
            id.clear();
            cbxUnidade.removeAllItems();
            
            cbxUnidade.addItem("Selecione");
            
            while (rs.next()) {
                id.add(rs.getInt(1));
                cbxUnidade.addItem(rs.getString(2));
            }
            
        } catch (Exception erro) {
         JOptionPane.showMessageDialog(null, "Erro em Class VetorUnidade no metodo restaurarDadosCbxUnidade: " + erro);
        }
        
    }
    
 private ResultSet listarUnidade(UnidadeDTO cadastroUnidadeDTO){
     conn = new ConexaoDAO().conectaBD();
     String sql = "select * from unidade order by descricao";
     try {
         pstm = conn.prepareStatement(sql);
         return pstm.executeQuery();
         
     } catch (Exception e) {
         System.out.println(e.getMessage());
         return null;
     }
 }
 public ArrayList<Integer> getIdUnidade(){
     return id;
 }
    
}
