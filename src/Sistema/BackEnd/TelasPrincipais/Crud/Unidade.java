package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.UnidadeDAO;
import DTO.Crud.UnidadeDTO;


public class Unidade {
    private UnidadeDTO cadastroUnidadeDTO;
    private UnidadeDAO cadastroUnidadeDAO;
    private String descricao;
    
    public Unidade(){
        this.cadastroUnidadeDAO = new UnidadeDAO();
        this.cadastroUnidadeDTO = new UnidadeDTO();
        
    }
    public Unidade(String descricao){
        this();
        this.descricao = descricao;
        
    }
    public void cadastrar(){
        
        cadastroUnidadeDTO.setDescricao(descricao);
        
        cadastroUnidadeDAO.cadastrarUnidade(cadastroUnidadeDTO);
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
