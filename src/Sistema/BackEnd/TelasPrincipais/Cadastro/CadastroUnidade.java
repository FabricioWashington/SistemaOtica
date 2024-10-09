package Sistema.BackEnd.TelasPrincipais.Cadastro;

import DAO.Cadastro.CadastroUnidadeDAO;
import DTO.Cadastro.CadastroUnidadeDTO;


public class CadastroUnidade {
    private CadastroUnidadeDTO cadastroUnidadeDTO;
    private CadastroUnidadeDAO cadastroUnidadeDAO;
    private String descricao;
    
    public CadastroUnidade(){
        this.cadastroUnidadeDAO = new CadastroUnidadeDAO();
        this.cadastroUnidadeDTO = new CadastroUnidadeDTO();
        
    }
    public CadastroUnidade(String descricao){
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
