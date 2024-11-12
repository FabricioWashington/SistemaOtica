package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.VendaDAO;
import DTO.Crud.VendaDTO;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FaFa
 */
public class VendaTest {

    private Venda venda;

    public VendaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        venda = new Venda();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of cadastrar method, of class Venda.
     */
    @Test
    public void testCadastrar() {
        // Configura os dados da venda
        venda.setIdFuncionario(5);
        venda.setIdCliente(14);
        venda.setIdPagamento(3);
        venda.setData(new Date());
        venda.setDataVencimento(new Date());
        venda.setVlrSugerido(BigDecimal.valueOf(100.00));
        venda.setVlrFinal(BigDecimal.valueOf(90.00));
        venda.setDesconto(BigDecimal.valueOf(10.00));
        venda.setVlrRecebido(BigDecimal.valueOf(90.00));
        venda.setVlrRestante(BigDecimal.valueOf(0.00));
        venda.setTotalVenda(BigDecimal.valueOf(90.00));
        venda.setParcela("1/1");
        venda.setStatus("Em aberto");

        // Executa o método cadastrar
        venda.cadastrar();
    }

    /**
     * Test of getVendaDTO method, of class Venda.
     */
    @Test
    public void testGetVendaDTO() {
        System.out.println("getVendaDTO");
        Venda instance = new Venda();
        VendaDTO expResult = null;
        VendaDTO result = instance.getVendaDTO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVendaDTO method, of class Venda.
     */
    @Test
    public void testSetVendaDTO() {
        System.out.println("setVendaDTO");
        VendaDTO vendaDTO = null;
        Venda instance = new Venda();
        instance.setVendaDTO(vendaDTO);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVendaDAO method, of class Venda.
     */
    @Test
    public void testGetVendaDAO() {
        System.out.println("getVendaDAO");
        Venda instance = new Venda();
        VendaDAO expResult = null;
        VendaDAO result = instance.getVendaDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVendaDAO method, of class Venda.
     */
    @Test
    public void testSetVendaDAO() {
        System.out.println("setVendaDAO");
        VendaDAO vendaDAO = null;
        Venda instance = new Venda();
        instance.setVendaDAO(vendaDAO);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdVenda method, of class Venda.
     */
    @Test
    public void testGetIdVenda() {
        System.out.println("getIdVenda");
        Venda instance = new Venda();
        int expResult = 0;
        int result = instance.getIdVenda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdVenda method, of class Venda.
     */
    @Test
    public void testSetIdVenda() {
        System.out.println("setIdVenda");
        int idVenda = 0;
        Venda instance = new Venda();
        instance.setIdVenda(idVenda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdFuncionario method, of class Venda.
     */
    @Test
    public void testGetIdFuncionario() {
        System.out.println("getIdFuncionario");
        Venda instance = new Venda();
        int expResult = 0;
        int result = instance.getIdFuncionario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdFuncionario method, of class Venda.
     */
    @Test
    public void testSetIdFuncionario() {
        System.out.println("setIdFuncionario");
        int idFuncionario = 0;
        Venda instance = new Venda();
        instance.setIdFuncionario(idFuncionario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdCliente method, of class Venda.
     */
    @Test
    public void testGetIdCliente() {
        System.out.println("getIdCliente");
        Venda instance = new Venda();
        int expResult = 0;
        int result = instance.getIdCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCliente method, of class Venda.
     */
    @Test
    public void testSetIdCliente() {
        System.out.println("setIdCliente");
        int idCliente = 0;
        Venda instance = new Venda();
        instance.setIdCliente(idCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdPagamento method, of class Venda.
     */
    @Test
    public void testGetIdPagamento() {
        System.out.println("getIdPagamento");
        Venda instance = new Venda();
        int expResult = 0;
        int result = instance.getIdPagamento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdPagamento method, of class Venda.
     */
    @Test
    public void testSetIdPagamento() {
        System.out.println("setIdPagamento");
        int idPagamento = 0;
        Venda instance = new Venda();
        instance.setIdPagamento(idPagamento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Venda.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Venda instance = new Venda();
        Date expResult = null;
        Date result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData method, of class Venda.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        Date data = null;
        Venda instance = new Venda();
        instance.setData(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataVencimento method, of class Venda.
     */
    @Test
    public void testGetDataVencimento() {
        System.out.println("getDataVencimento");
        Venda instance = new Venda();
        Date expResult = null;
        Date result = instance.getDataVencimento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataVencimento method, of class Venda.
     */
    @Test
    public void testSetDataVencimento() {
        System.out.println("setDataVencimento");
        Date dataVencimento = null;
        Venda instance = new Venda();
        instance.setDataVencimento(dataVencimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVlrSugerido method, of class Venda.
     */
    @Test
    public void testGetVlrSugerido() {
        System.out.println("getVlrSugerido");
        Venda instance = new Venda();
        BigDecimal expResult = null;
        BigDecimal result = instance.getVlrSugerido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVlrSugerido method, of class Venda.
     */
    @Test
    public void testSetVlrSugerido() {
        System.out.println("setVlrSugerido");
        BigDecimal vlrSugerido = null;
        Venda instance = new Venda();
        instance.setVlrSugerido(vlrSugerido);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVlrFinal method, of class Venda.
     */
    @Test
    public void testGetVlrFinal() {
        System.out.println("getVlrFinal");
        Venda instance = new Venda();
        BigDecimal expResult = null;
        BigDecimal result = instance.getVlrFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVlrFinal method, of class Venda.
     */
    @Test
    public void testSetVlrFinal() {
        System.out.println("setVlrFinal");
        BigDecimal vlrFinal = null;
        Venda instance = new Venda();
        instance.setVlrFinal(vlrFinal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDesconto method, of class Venda.
     */
    @Test
    public void testGetDesconto() {
        System.out.println("getDesconto");
        Venda instance = new Venda();
        BigDecimal expResult = null;
        BigDecimal result = instance.getDesconto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDesconto method, of class Venda.
     */
    @Test
    public void testSetDesconto() {
        System.out.println("setDesconto");
        BigDecimal desconto = null;
        Venda instance = new Venda();
        instance.setDesconto(desconto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVlrRecebido method, of class Venda.
     */
    @Test
    public void testGetVlrRecebido() {
        System.out.println("getVlrRecebido");
        Venda instance = new Venda();
        BigDecimal expResult = null;
        BigDecimal result = instance.getVlrRecebido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVlrRecebido method, of class Venda.
     */
    @Test
    public void testSetVlrRecebido() {
        System.out.println("setVlrRecebido");
        BigDecimal vlrRecebido = null;
        Venda instance = new Venda();
        instance.setVlrRecebido(vlrRecebido);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVlrRestante method, of class Venda.
     */
    @Test
    public void testGetVlrRestante() {
        System.out.println("getVlrRestante");
        Venda instance = new Venda();
        BigDecimal expResult = null;
        BigDecimal result = instance.getVlrRestante();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVlrRestante method, of class Venda.
     */
    @Test
    public void testSetVlrRestante() {
        System.out.println("setVlrRestante");
        BigDecimal vlrRestante = null;
        Venda instance = new Venda();
        instance.setVlrRestante(vlrRestante);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalVenda method, of class Venda.
     */
    @Test
    public void testGetTotalVenda() {
        System.out.println("getTotalVenda");
        Venda instance = new Venda();
        BigDecimal expResult = null;
        BigDecimal result = instance.getTotalVenda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalVenda method, of class Venda.
     */
    @Test
    public void testSetTotalVenda() {
        System.out.println("setTotalVenda");
        BigDecimal totalVenda = null;
        Venda instance = new Venda();
        instance.setTotalVenda(totalVenda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParcela method, of class Venda.
     */
    @Test
    public void testGetParcela() {
        System.out.println("getParcela");
        Venda instance = new Venda();
        String expResult = "";
        String result = instance.getParcela();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParcela method, of class Venda.
     */
    @Test
    public void testSetParcela() {
        System.out.println("setParcela");
        String parcela = "";
        Venda instance = new Venda();
        instance.setParcela(parcela);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Venda.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Venda instance = new Venda();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Venda.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        Venda instance = new Venda();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
