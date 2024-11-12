package Sistema.BackEnd.TelasPrincipais.Crud;

import Sistema.BackEnd.TelasPrincipais.Crud.Produto;
import DAO.Crud.ProdutoDAO;
import DTO.Crud.ProdutoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProdutoTest {

    @Mock
    private ProdutoDAO produtoDAO;

    @InjectMocks
    private Produto produto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCadastrarProduto() {
        // Definindo valores para o objeto Produto
        produto.setNomeProduto("Produto Teste");
        produto.setCodigoBarras("123456789");
        produto.setImagem("imagem.jpg");
        produto.setObservacoes("Observação de teste");
        produto.setIdCategoria(1);
        produto.setIdUnidade(2);
        produto.setPreco(new BigDecimal("100.00"));

        // Chamando o método para obter a data atual
        produto.obterDataAtual();

        // Verificando a chamada do método cadastrar no DAO
        produto.cadastrar();

        // Verificando se o método cadastrarProduto foi chamado
        verify(produtoDAO, times(1)).cadastrarProduto(any(ProdutoDTO.class));
    }

    @Test
    void testConsultarProduto() {
        // Configurando dados de teste e o mock do ProdutoDAO
        JTextField txtPesquisa = new JTextField("Produto Teste");
        produto.setTxtPesquisa(txtPesquisa);

        ArrayList<ProdutoDTO> mockProdutoList = new ArrayList<>();
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome_Produto("Oculos");
        produtoDTO.setCodigo_de_Barras("123");
        produtoDTO.setPreco(new BigDecimal("100.00"));
        mockProdutoList.add(produtoDTO);

        when(produtoDAO.consultarProduto(anyString(), anyString())).thenReturn(mockProdutoList);

        // Executa o método de consulta
        produto.consultar();

        // Verifica se a lista está corretamente preenchida
        assertEquals(1, produto.getListaProduto().size());
        assertEquals("Produto Teste", produto.getListaProduto().get(0).getNome_Produto());
    }

    @Test
    void testLimparCampos() {
        // Criação dos campos de teste
        JTextField txtNomeProduto = new JTextField("Produto Teste");
        JTextArea txtAreaObservacoes = new JTextArea("Observações de teste");
        JFormattedTextField txtPreco = new JFormattedTextField(new BigDecimal("100.00"));
        JTextField txtCodigoBarras = new JTextField("123456789");
        JComboBox cbxUnidade = new JComboBox(new String[]{"Unidade1", "Unidade2"});
        cbxUnidade.setSelectedIndex(1);
        JComboBox cbxCategoria = new JComboBox(new String[]{"Categoria1", "Categoria2"});
        cbxCategoria.setSelectedIndex(1);
        JLabel lblImg = new JLabel("imagem.jpg");

        // Chama o método de limpar campos
        produto.limparCampos(txtNomeProduto, txtAreaObservacoes, txtPreco, txtCodigoBarras, cbxUnidade, cbxCategoria, lblImg);

        // Verifica se todos os campos foram limpos
        assertEquals("", txtNomeProduto.getText());
        assertEquals("", txtAreaObservacoes.getText());
        assertEquals("", txtPreco.getText());
        assertEquals("", txtCodigoBarras.getText());
        assertEquals(-1, cbxUnidade.getSelectedIndex());
        assertEquals(-1, cbxCategoria.getSelectedIndex());
        assertEquals("", lblImg.getText());
    }

    @Test
    void testObterDataAtual() {
        produto.obterDataAtual();
        assertNotNull(produto.getData());
    }
}
