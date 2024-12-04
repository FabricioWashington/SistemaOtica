package DAO.Vetores;

import DAO.Conexao.ConexaoDAO;
import DTO.Vetores.TipoPagamentoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class VetorTipoPagamento {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    private ArrayList<Integer> idPagamento = new ArrayList<>();
    private JComboBox<String> cbxTipoPagamento;
    
    public VetorTipoPagamento(JComboBox<String> cbxTipoPagamento){
        this.cbxTipoPagamento = cbxTipoPagamento;
    }
    
       public void restaurarDadosCbxTipoPagamento() {

        try {
            TipoPagamentoDTO tipoPagamento = new TipoPagamentoDTO();
            rs = ListarTipoPagamento(tipoPagamento);
            
            idPagamento.clear();
            cbxTipoPagamento.removeAllItems();
            
            cbxTipoPagamento.addItem("Selecione");
            while (rs.next()) {
                idPagamento.add(rs.getInt(1));
                cbxTipoPagamento.addItem(rs.getString(2));
            }


        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro em Class Vector no metodo restaurarDadosCbxTipoPagamento: " + erro);
        }
    }
    
        private ResultSet ListarTipoPagamento(TipoPagamentoDTO tipoPagamento) {
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "SELECT * FROM Tipo_Pagamento ORDER BY Tipo_Pagamento";
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
        
    public ArrayList<Integer> getIdPagamento(){
        return idPagamento;
    }
}
