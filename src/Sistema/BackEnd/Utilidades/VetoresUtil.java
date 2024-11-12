package Sistema.BackEnd.Utilidades;

import DAO.Vetores.CnaeDAO;
import DTO.Vetores.CnaeDTO;
import DTO.Contato_Endereco.ContatoDTO;
import DTO.Vetores.DDD_DTO;
import DAO.Login.LoginDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class VetoresUtil {

    Vector<Integer> idDDD = new Vector<Integer>();

    private void restaurarDadosComboBoxDDD(JComboBox cbxDDD) {

        try {
            DDD_DTO objddddto = new DDD_DTO();
            LoginDAO objlogindao = new LoginDAO();
            ResultSet rs = objlogindao.ListarDDD(objddddto);
            while (rs.next()) {

                idDDD.addElement(rs.getInt(1));
                cbxDDD.addItem(rs.getString(2));

            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro em restaurarcbxDDD " + erro);
        }
    }

    Vector<Integer> idContato = new Vector<Integer>();

    private void restaurarDadosdatabelaContatos() {
        try {
            ContatoDTO objcontatodto = new ContatoDTO();
            LoginDAO objlogindao = new LoginDAO();
            ResultSet rs = objlogindao.ListarContatos(objcontatodto);
            while (rs.next()) {
                idContato.addElement(rs.getInt(1));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "erro em restaurar dados da tabela contato" + erro);
        }
    }

    Vector<Integer> idCNAE = new Vector<Integer>();

    private void restaurardadosComboBoxCNAE(JComboBox cbxCNAE_Principal) {
        try {
            CnaeDTO objcnaedto = new CnaeDTO();
            CnaeDAO objcnaedao = new CnaeDAO();
            ResultSet rs = objcnaedao.ListarCNAE(objcnaedto);
            while (rs.next()) {
                idCNAE.addElement(rs.getInt(1));
                cbxCNAE_Principal.addItem(rs.getString(2));

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "erro em restaurar dados da cbx CNAE" + erro);
        }
    }
}
