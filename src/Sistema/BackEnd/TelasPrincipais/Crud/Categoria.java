package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.CategoriaDAO;
import DTO.Crud.CategoriaDTO;
import java.util.ArrayList;

public class Categoria {

    private CategoriaDAO cadastroCategoriaDAO;
    private CategoriaDTO cadastroCategoriaDTO;
    private String Nome_Categoria;

    public Categoria() {
        this.cadastroCategoriaDAO = new CategoriaDAO();
        this.cadastroCategoriaDTO = new CategoriaDTO();

    }

    public Categoria(String Nome_Categoria) {
        this();
        this.Nome_Categoria = Nome_Categoria;

    }

    public void cadastrar() {

        cadastroCategoriaDTO.setNome_Categoria(getNome_Categoria());

        cadastroCategoriaDAO.cadastrarCategoria(cadastroCategoriaDTO);

    }
    // Método para listar categorias

    public ArrayList<CategoriaDTO> listar() {
        return cadastroCategoriaDAO.listarCategorias();
    }

    // Método para atualizar categoria
    public void atualizar(int idCategoria, String novoNomeCategoria) {
        cadastroCategoriaDTO.setIdCategoria(idCategoria);
        cadastroCategoriaDTO.setNome_Categoria(novoNomeCategoria);
        cadastroCategoriaDAO.atualizarCategoria(cadastroCategoriaDTO);
    }

    // Método para excluir categoria
    public void excluir(int idCategoria) {
        cadastroCategoriaDAO.excluirCategoria(idCategoria);
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
