package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.CategoriaDAO;
import DTO.Crud.CategoriaDTO;


public class Categoria {
    
    private CategoriaDAO  cadastroCategoriaDAO;
    private CategoriaDTO cadastroCategoriaDTO;
    private String Nome_Categoria;
    
    public Categoria(){
        this.cadastroCategoriaDAO = new CategoriaDAO();
        this.cadastroCategoriaDTO = new CategoriaDTO();
        
    }
    
    public Categoria(String Nome_Categoria){
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
