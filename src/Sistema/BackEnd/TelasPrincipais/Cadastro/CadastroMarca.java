package Sistema.BackEnd.TelasPrincipais.Cadastro;

import DAO.Cadastro.CadastroMarcaDAO;
import DTO.Cadastro.CadastroMarcaDTO;
import javax.swing.JTextField;

public class CadastroMarca {

    private String nomeMarca;
    private CadastroMarcaDTO cadastroMarcaDTO;
    private CadastroMarcaDAO cadastroMarcaDAO;

    public CadastroMarca() {
        this.cadastroMarcaDAO = new CadastroMarcaDAO();
        this.cadastroMarcaDTO = new CadastroMarcaDTO();
    }

    public CadastroMarca(String nomeMarca) {
        this();
        this.nomeMarca = nomeMarca;
    }

    public void cadastrar() {
        
        cadastroMarcaDTO.setNome_Marca(nomeMarca);

        cadastroMarcaDAO.cadastrarMarca(cadastroMarcaDTO);

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
