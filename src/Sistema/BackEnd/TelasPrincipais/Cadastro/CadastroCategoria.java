package Sistema.BackEnd.TelasPrincipais.Cadastro;

import DAO.Cadastro.CadastroCategoriaDAO;
import DTO.Cadastro.CadastroCategoriaDTO;


public class CadastroCategoria {
    
    private CadastroCategoriaDAO  cadastroCategoriaDAO;
    private CadastroCategoriaDTO cadastroCategoriaDTO;
    private String Nome_Categoria;
    
    public CadastroCategoria(){
        this.cadastroCategoriaDAO = new CadastroCategoriaDAO();
        this.cadastroCategoriaDTO = new CadastroCategoriaDTO();
        
    }
    
    public CadastroCategoria(String Nome_Categoria){
        this();
        this.Nome_Categoria = Nome_Categoria;
        
    }
    
    public void cadastrar(){
        
        cadastroCategoriaDTO.setNome_Categoria(getNome_Categoria());
        
        cadastroCategoriaDAO.cadastrarCategoria(cadastroCategoriaDTO);
        
    }

    /**
     * @return the Nome_Categoria
     */
    public String getNome_Categoria() {
        return Nome_Categoria;
    }

    /**
     * @param Nome_Categoria the Nome_Categoria to set
     */
    public void setNome_Categoria(String Nome_Categoria) {
        this.Nome_Categoria = Nome_Categoria;
    }
    
}
