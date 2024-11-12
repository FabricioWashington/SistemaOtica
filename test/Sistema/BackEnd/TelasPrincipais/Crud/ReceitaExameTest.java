package Sistema.BackEnd.TelasPrincipais.Crud;

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
public class ReceitaExameTest {

    private ReceitaExame receitaExame;

    public ReceitaExameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        receitaExame = new ReceitaExame();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of cadastrar method, of class ReceitaExame.
     */
    @Test
    public void testCadastrar() {
        int idCliente = 1;
        int idMedico = 4;
        int idExame = 3;
        Date dataReceita = new Date();
        String esferaDireito = "1.0";
        String cilindroDireito = "0.5";
        String eixoDireito = "90";
        String dipDireito = "12";
        String dnpDireito = "10";
        String adicaoDireito = "2.0";
        String esferaEsquerdo = "1.5";
        String cilindroEsquerdo = "0.75";
        String eixoEsquerdo = "80";
        String dipEsquerdo = "11";
        String dnpEsquerdo = "9";
        String adicaoEsquerdo = "2.5";
        String observacoes = "Test Observations";

        // Setar dados na classe ReceitaExame
        receitaExame.setIdCliente(idCliente);
        receitaExame.setIdMedico(idMedico);
        receitaExame.setIdExame(idExame);
        receitaExame.setDataReceita(dataReceita);
        receitaExame.setEsferaDireito(esferaDireito);
        receitaExame.setCilindroDireito(cilindroDireito);
        receitaExame.setEixoDireito(eixoDireito);
        receitaExame.setDipDireito(dipDireito);
        receitaExame.setDnpDireito(dnpDireito);
        receitaExame.setAdicaoDireito(adicaoDireito);
        receitaExame.setEsferaEsquerdo(esferaEsquerdo);
        receitaExame.setCilindroEsquerdo(cilindroEsquerdo);
        receitaExame.setEixoEsquerdo(eixoEsquerdo);
        receitaExame.setDipEsquerdo(dipEsquerdo);
        receitaExame.setDnpEsquerdo(dnpEsquerdo);
        receitaExame.setAdicaoEsquerdo(adicaoEsquerdo);
        receitaExame.setObservacoes(observacoes);

        // Executar o método de cadastro
        receitaExame.cadastrar();

    }

    /**
     * Test of getIdCliente method, of class ReceitaExame.
     */
    @Test
    public void testGetIdCliente() {
        System.out.println("getIdCliente");
        ReceitaExame instance = new ReceitaExame();
        int expResult = 0;
        int result = instance.getIdCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCliente method, of class ReceitaExame.
     */
    @Test
    public void testSetIdCliente() {
        System.out.println("setIdCliente");
        int idCliente = 0;
        ReceitaExame instance = new ReceitaExame();
        instance.setIdCliente(idCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdMedico method, of class ReceitaExame.
     */
    @Test
    public void testGetIdMedico() {
        System.out.println("getIdMedico");
        ReceitaExame instance = new ReceitaExame();
        int expResult = 0;
        int result = instance.getIdMedico();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdMedico method, of class ReceitaExame.
     */
    @Test
    public void testSetIdMedico() {
        System.out.println("setIdMedico");
        int idMedico = 0;
        ReceitaExame instance = new ReceitaExame();
        instance.setIdMedico(idMedico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdExame method, of class ReceitaExame.
     */
    @Test
    public void testGetIdExame() {
        System.out.println("getIdExame");
        ReceitaExame instance = new ReceitaExame();
        int expResult = 0;
        int result = instance.getIdExame();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdExame method, of class ReceitaExame.
     */
    @Test
    public void testSetIdExame() {
        System.out.println("setIdExame");
        int idExame = 0;
        ReceitaExame instance = new ReceitaExame();
        instance.setIdExame(idExame);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataReceita method, of class ReceitaExame.
     */
    @Test
    public void testGetDataReceita() {
        System.out.println("getDataReceita");
        ReceitaExame instance = new ReceitaExame();
        Date expResult = null;
        Date result = instance.getDataReceita();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataReceita method, of class ReceitaExame.
     */
    @Test
    public void testSetDataReceita() {
        System.out.println("setDataReceita");
        Date dataReceita = null;
        ReceitaExame instance = new ReceitaExame();
        instance.setDataReceita(dataReceita);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEsferaDireito method, of class ReceitaExame.
     */
    @Test
    public void testGetEsferaDireito() {
        System.out.println("getEsferaDireito");
        ReceitaExame instance = new ReceitaExame();
        String expResult = "";
        String result = instance.getEsferaDireito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEsferaDireito method, of class ReceitaExame.
     */
    @Test
    public void testSetEsferaDireito() {
        System.out.println("setEsferaDireito");
        String esferaDireito = "";
        ReceitaExame instance = new ReceitaExame();
        instance.setEsferaDireito(esferaDireito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCilindroDireito method, of class ReceitaExame.
     */
    @Test
    public void testGetCilindroDireito() {
        System.out.println("getCilindroDireito");
        ReceitaExame instance = new ReceitaExame();
        String expResult = "";
        String result = instance.getCilindroDireito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCilindroDireito method, of class ReceitaExame.
     */
    @Test
    public void testSetCilindroDireito() {
        System.out.println("setCilindroDireito");
        String cilindroDireito = "";
        ReceitaExame instance = new ReceitaExame();
        instance.setCilindroDireito(cilindroDireito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEixoDireito method, of class ReceitaExame.
     */
    @Test
    public void testGetEixoDireito() {
        System.out.println("getEixoDireito");
        ReceitaExame instance = new ReceitaExame();
        String expResult = "";
        String result = instance.getEixoDireito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEixoDireito method, of class ReceitaExame.
     */
    @Test
    public void testSetEixoDireito() {
        System.out.println("setEixoDireito");
        String eixoDireito = "";
        ReceitaExame instance = new ReceitaExame();
        instance.setEixoDireito(eixoDireito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDipDireito method, of class ReceitaExame.
     */
    @Test
    public void testGetDipDireito() {
        System.out.println("getDipDireito");
        ReceitaExame instance = new ReceitaExame();
        String expResult = "";
        String result = instance.getDipDireito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDipDireito method, of class ReceitaExame.
     */
    @Test
    public void testSetDipDireito() {
        System.out.println("setDipDireito");
        String dipDireito = "";
        ReceitaExame instance = new ReceitaExame();
        instance.setDipDireito(dipDireito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDnpDireito method, of class ReceitaExame.
     */
    @Test
    public void testGetDnpDireito() {
        System.out.println("getDnpDireito");
        ReceitaExame instance = new ReceitaExame();
        String expResult = "";
        String result = instance.getDnpDireito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDnpDireito method, of class ReceitaExame.
     */
    @Test
    public void testSetDnpDireito() {
        System.out.println("setDnpDireito");
        String dnpDireito = "";
        ReceitaExame instance = new ReceitaExame();
        instance.setDnpDireito(dnpDireito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdicaoDireito method, of class ReceitaExame.
     */
    @Test
    public void testGetAdicaoDireito() {
        System.out.println("getAdicaoDireito");
        ReceitaExame instance = new ReceitaExame();
        String expResult = "";
        String result = instance.getAdicaoDireito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdicaoDireito method, of class ReceitaExame.
     */
    @Test
    public void testSetAdicaoDireito() {
        System.out.println("setAdicaoDireito");
        String adicaoDireito = "";
        ReceitaExame instance = new ReceitaExame();
        instance.setAdicaoDireito(adicaoDireito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEsferaEsquerdo method, of class ReceitaExame.
     */
    @Test
    public void testGetEsferaEsquerdo() {
        System.out.println("getEsferaEsquerdo");
        ReceitaExame instance = new ReceitaExame();
        String expResult = "";
        String result = instance.getEsferaEsquerdo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEsferaEsquerdo method, of class ReceitaExame.
     */
    @Test
    public void testSetEsferaEsquerdo() {
        System.out.println("setEsferaEsquerdo");
        String esferaEsquerdo = "";
        ReceitaExame instance = new ReceitaExame();
        instance.setEsferaEsquerdo(esferaEsquerdo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCilindroEsquerdo method, of class ReceitaExame.
     */
    @Test
    public void testGetCilindroEsquerdo() {
        System.out.println("getCilindroEsquerdo");
        ReceitaExame instance = new ReceitaExame();
        String expResult = "";
        String result = instance.getCilindroEsquerdo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCilindroEsquerdo method, of class ReceitaExame.
     */
    @Test
    public void testSetCilindroEsquerdo() {
        System.out.println("setCilindroEsquerdo");
        String cilindroEsquerdo = "";
        ReceitaExame instance = new ReceitaExame();
        instance.setCilindroEsquerdo(cilindroEsquerdo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEixoEsquerdo method, of class ReceitaExame.
     */
    @Test
    public void testGetEixoEsquerdo() {
        System.out.println("getEixoEsquerdo");
        ReceitaExame instance = new ReceitaExame();
        String expResult = "";
        String result = instance.getEixoEsquerdo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEixoEsquerdo method, of class ReceitaExame.
     */
    @Test
    public void testSetEixoEsquerdo() {
        System.out.println("setEixoEsquerdo");
        String eixoEsquerdo = "";
        ReceitaExame instance = new ReceitaExame();
        instance.setEixoEsquerdo(eixoEsquerdo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDipEsquerdo method, of class ReceitaExame.
     */
    @Test
    public void testGetDipEsquerdo() {
        System.out.println("getDipEsquerdo");
        ReceitaExame instance = new ReceitaExame();
        String expResult = "";
        String result = instance.getDipEsquerdo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDipEsquerdo method, of class ReceitaExame.
     */
    @Test
    public void testSetDipEsquerdo() {
        System.out.println("setDipEsquerdo");
        String dipEsquerdo = "";
        ReceitaExame instance = new ReceitaExame();
        instance.setDipEsquerdo(dipEsquerdo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDnpEsquerdo method, of class ReceitaExame.
     */
    @Test
    public void testGetDnpEsquerdo() {
        System.out.println("getDnpEsquerdo");
        ReceitaExame instance = new ReceitaExame();
        String expResult = "";
        String result = instance.getDnpEsquerdo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDnpEsquerdo method, of class ReceitaExame.
     */
    @Test
    public void testSetDnpEsquerdo() {
        System.out.println("setDnpEsquerdo");
        String dnpEsquerdo = "";
        ReceitaExame instance = new ReceitaExame();
        instance.setDnpEsquerdo(dnpEsquerdo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdicaoEsquerdo method, of class ReceitaExame.
     */
    @Test
    public void testGetAdicaoEsquerdo() {
        System.out.println("getAdicaoEsquerdo");
        ReceitaExame instance = new ReceitaExame();
        String expResult = "";
        String result = instance.getAdicaoEsquerdo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdicaoEsquerdo method, of class ReceitaExame.
     */
    @Test
    public void testSetAdicaoEsquerdo() {
        System.out.println("setAdicaoEsquerdo");
        String adicaoEsquerdo = "";
        ReceitaExame instance = new ReceitaExame();
        instance.setAdicaoEsquerdo(adicaoEsquerdo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObservacoes method, of class ReceitaExame.
     */
    @Test
    public void testGetObservacoes() {
        System.out.println("getObservacoes");
        ReceitaExame instance = new ReceitaExame();
        String expResult = "";
        String result = instance.getObservacoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObservacoes method, of class ReceitaExame.
     */
    @Test
    public void testSetObservacoes() {
        System.out.println("setObservacoes");
        String observacoes = "";
        ReceitaExame instance = new ReceitaExame();
        instance.setObservacoes(observacoes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
