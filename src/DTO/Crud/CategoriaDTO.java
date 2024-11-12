package DTO.Crud;


public class CategoriaDTO {
    private int idCategoria;
    private String Nome_Categoria;

    /**
     * @return the idCategoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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
