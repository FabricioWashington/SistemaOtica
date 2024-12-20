package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.MarcaDAO;
import DTO.Crud.MarcaDTO;
import java.util.ArrayList;
import javax.swing.JTextField;

public class Marca {

    private String nomeMarca;
    private MarcaDTO cadastroMarcaDTO;
    private MarcaDAO cadastroMarcaDAO;

    public Marca() {
        this.cadastroMarcaDAO = new MarcaDAO();
        this.cadastroMarcaDTO = new MarcaDTO();
    }

    public Marca(String nomeMarca) {
        this();
        this.nomeMarca = nomeMarca;
    }

    public void cadastrar() {

        cadastroMarcaDTO.setNome_Marca(nomeMarca);

        cadastroMarcaDAO.cadastrarMarca(cadastroMarcaDTO);

    }

    public ArrayList<MarcaDTO> listar() {
        return cadastroMarcaDAO.listarMarcas();
    }

    public void atualizar(String nomeAntigo) {
        cadastroMarcaDTO.setNome_Marca(nomeMarca);
        cadastroMarcaDAO.atualizarMarca(cadastroMarcaDTO);
    }

    public void excluir(int idMarca) {
        cadastroMarcaDAO.excluirMarca(idMarca);
    }

    /**
     * @return the nomeMarca
     */
    public String getNomeMarca() {
        return nomeMarca;
    }

    /**
     * @param nomeMarca the nomeMarca to set
     */
    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public void limparCampos(JTextField txtReferencia) {
        txtReferencia.setText("");
    }
}
