package Sistema.BackEnd.TelasPrincipais.Crud;

import java.math.BigDecimal;
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
public class LenteTest {

    private Lente lente;

    public LenteTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lente = new Lente();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of cadastrarLenteContato method, of class Lente.
     */
    @Test
    public void testCadastrarLenteContato() {
        lente.setIdProduto(1);
        lente.setIdTipoLente(2);
        lente.setIdMaterial(3);
        lente.setIdTratamento(4);
        lente.setCurvaBase(new BigDecimal("8.5"));
        lente.setDiametro(new BigDecimal("14.0"));
        lente.setPrecoCusto(new BigDecimal("50.00"));
        lente.setPrecoVenda(new BigDecimal("100.00"));
        lente.setQuantidade(10);
        lente.setGrau(new BigDecimal("1.75"));

        // Chama o método a ser testado
        lente.cadastrarLenteContato();
    }

    /**
     * Test of cadastrarLente method, of class Lente.
     */
    @Test
    public void testCadastrarLente() {
        lente.setIdProduto(1);
        lente.setIdTipoLente(2);
        lente.setIdMaterial(3);
        lente.setIdTratamento(4);
        lente.setIndiceRefracao(new BigDecimal("1.6"));
        lente.setPrecoCusto(new BigDecimal("70.00"));
        lente.setPrecoVenda(new BigDecimal("150.00"));
        lente.setQuantidade(5);
        lente.setGrau(new BigDecimal("2.0"));
        lente.setEixo(90);
    }

    /**
     * Test of getIdLente method, of class Lente.
     */
    @Test
    public void testGetIdLente() {
        System.out.println("getIdLente");
        Lente instance = new Lente();
        int expResult = 0;
        int result = instance.getIdLente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdLente method, of class Lente.
     */
    @Test
    public void testSetIdLente() {
        System.out.println("setIdLente");
        int idLente = 0;
        Lente instance = new Lente();
        instance.setIdLente(idLente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdProduto method, of class Lente.
     */
    @Test
    public void testGetIdProduto() {
        System.out.println("getIdProduto");
        Lente instance = new Lente();
        int expResult = 0;
        int result = instance.getIdProduto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdProduto method, of class Lente.
     */
    @Test
    public void testSetIdProduto() {
        System.out.println("setIdProduto");
        int idProduto = 0;
        Lente instance = new Lente();
        instance.setIdProduto(idProduto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdTipoLente method, of class Lente.
     */
    @Test
    public void testGetIdTipoLente() {
        System.out.println("getIdTipoLente");
        Lente instance = new Lente();
        int expResult = 0;
        int result = instance.getIdTipoLente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdTipoLente method, of class Lente.
     */
    @Test
    public void testSetIdTipoLente() {
        System.out.println("setIdTipoLente");
        int idTipoLente = 0;
        Lente instance = new Lente();
        instance.setIdTipoLente(idTipoLente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdMaterial method, of class Lente.
     */
    @Test
    public void testGetIdMaterial() {
        System.out.println("getIdMaterial");
        Lente instance = new Lente();
        int expResult = 0;
        int result = instance.getIdMaterial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdMaterial method, of class Lente.
     */
    @Test
    public void testSetIdMaterial() {
        System.out.println("setIdMaterial");
        int idMaterial = 0;
        Lente instance = new Lente();
        instance.setIdMaterial(idMaterial);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdTratamento method, of class Lente.
     */
    @Test
    public void testGetIdTratamento() {
        System.out.println("getIdTratamento");
        Lente instance = new Lente();
        int expResult = 0;
        int result = instance.getIdTratamento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdTratamento method, of class Lente.
     */
    @Test
    public void testSetIdTratamento() {
        System.out.println("setIdTratamento");
        int idTratamento = 0;
        Lente instance = new Lente();
        instance.setIdTratamento(idTratamento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndiceRefracao method, of class Lente.
     */
    @Test
    public void testGetIndiceRefracao() {
        System.out.println("getIndiceRefracao");
        Lente instance = new Lente();
        BigDecimal expResult = null;
        BigDecimal result = instance.getIndiceRefracao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIndiceRefracao method, of class Lente.
     */
    @Test
    public void testSetIndiceRefracao() {
        System.out.println("setIndiceRefracao");
        BigDecimal indiceRefracao = null;
        Lente instance = new Lente();
        instance.setIndiceRefracao(indiceRefracao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecoCusto method, of class Lente.
     */
    @Test
    public void testGetPrecoCusto() {
        System.out.println("getPrecoCusto");
        Lente instance = new Lente();
        BigDecimal expResult = null;
        BigDecimal result = instance.getPrecoCusto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecoCusto method, of class Lente.
     */
    @Test
    public void testSetPrecoCusto() {
        System.out.println("setPrecoCusto");
        BigDecimal precoCusto = null;
        Lente instance = new Lente();
        instance.setPrecoCusto(precoCusto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecoVenda method, of class Lente.
     */
    @Test
    public void testGetPrecoVenda() {
        System.out.println("getPrecoVenda");
        Lente instance = new Lente();
        BigDecimal expResult = null;
        BigDecimal result = instance.getPrecoVenda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecoVenda method, of class Lente.
     */
    @Test
    public void testSetPrecoVenda() {
        System.out.println("setPrecoVenda");
        BigDecimal precoVenda = null;
        Lente instance = new Lente();
        instance.setPrecoVenda(precoVenda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGrau method, of class Lente.
     */
    @Test
    public void testGetGrau() {
        System.out.println("getGrau");
        Lente instance = new Lente();
        BigDecimal expResult = null;
        BigDecimal result = instance.getGrau();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGrau method, of class Lente.
     */
    @Test
    public void testSetGrau() {
        System.out.println("setGrau");
        BigDecimal grau = null;
        Lente instance = new Lente();
        instance.setGrau(grau);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiametro method, of class Lente.
     */
    @Test
    public void testGetDiametro() {
        System.out.println("getDiametro");
        Lente instance = new Lente();
        BigDecimal expResult = null;
        BigDecimal result = instance.getDiametro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDiametro method, of class Lente.
     */
    @Test
    public void testSetDiametro() {
        System.out.println("setDiametro");
        BigDecimal diametro = null;
        Lente instance = new Lente();
        instance.setDiametro(diametro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurvaBase method, of class Lente.
     */
    @Test
    public void testGetCurvaBase() {
        System.out.println("getCurvaBase");
        Lente instance = new Lente();
        BigDecimal expResult = null;
        BigDecimal result = instance.getCurvaBase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurvaBase method, of class Lente.
     */
    @Test
    public void testSetCurvaBase() {
        System.out.println("setCurvaBase");
        BigDecimal curvaBase = null;
        Lente instance = new Lente();
        instance.setCurvaBase(curvaBase);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantidade method, of class Lente.
     */
    @Test
    public void testGetQuantidade() {
        System.out.println("getQuantidade");
        Lente instance = new Lente();
        int expResult = 0;
        int result = instance.getQuantidade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantidade method, of class Lente.
     */
    @Test
    public void testSetQuantidade() {
        System.out.println("setQuantidade");
        int quantidade = 0;
        Lente instance = new Lente();
        instance.setQuantidade(quantidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEixo method, of class Lente.
     */
    @Test
    public void testGetEixo() {
        System.out.println("getEixo");
        Lente instance = new Lente();
        int expResult = 0;
        int result = instance.getEixo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEixo method, of class Lente.
     */
    @Test
    public void testSetEixo() {
        System.out.println("setEixo");
        int eixo = 0;
        Lente instance = new Lente();
        instance.setEixo(eixo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
