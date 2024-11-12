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
public class ExameTest {

    private Exame exame;

    public ExameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        exame = new Exame();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of cadastrar method, of class Exame.
     */
    @Test
    public void testCadastrar() {
        // Teste esqueleto gerado automaticamente para o método cadastrar
        // Você pode configurar os parâmetros do exame e chamar o método cadastrar aqui
        exame.setIdCliente(14);
        exame.setIdMedico(4);
        exame.setDataExame(new Date());
        exame.setTipoExame("Raio-X");
        exame.setResultados("Resultados normais");
        exame.setObservacoes("Paciente saudável");

        exame.cadastrar();

        // Verificação (assertion) - adicione aqui as validações necessárias
        assertNotNull(exame);  // Exemplo simples
    }

    /**
     * Test of getIdCliente method, of class Exame.
     */
    @Test
    public void testGetIdCliente() {
        System.out.println("getIdCliente");
        Exame instance = new Exame();
        int expResult = 0;
        int result = instance.getIdCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCliente method, of class Exame.
     */
    @Test
    public void testSetIdCliente() {
        System.out.println("setIdCliente");
        int idCliente = 0;
        Exame instance = new Exame();
        instance.setIdCliente(idCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdMedico method, of class Exame.
     */
    @Test
    public void testGetIdMedico() {
        System.out.println("getIdMedico");
        Exame instance = new Exame();
        int expResult = 0;
        int result = instance.getIdMedico();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdMedico method, of class Exame.
     */
    @Test
    public void testSetIdMedico() {
        System.out.println("setIdMedico");
        int idMedico = 0;
        Exame instance = new Exame();
        instance.setIdMedico(idMedico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataExame method, of class Exame.
     */
    @Test
    public void testGetDataExame() {
        System.out.println("getDataExame");
        Exame instance = new Exame();
        Date expResult = null;
        Date result = instance.getDataExame();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataExame method, of class Exame.
     */
    @Test
    public void testSetDataExame() {
        System.out.println("setDataExame");
        Date dataExame = null;
        Exame instance = new Exame();
        instance.setDataExame(dataExame);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipoExame method, of class Exame.
     */
    @Test
    public void testGetTipoExame() {
        System.out.println("getTipoExame");
        Exame instance = new Exame();
        String expResult = "";
        String result = instance.getTipoExame();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoExame method, of class Exame.
     */
    @Test
    public void testSetTipoExame() {
        System.out.println("setTipoExame");
        String tipoExame = "";
        Exame instance = new Exame();
        instance.setTipoExame(tipoExame);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultados method, of class Exame.
     */
    @Test
    public void testGetResultados() {
        System.out.println("getResultados");
        Exame instance = new Exame();
        String expResult = "";
        String result = instance.getResultados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResultados method, of class Exame.
     */
    @Test
    public void testSetResultados() {
        System.out.println("setResultados");
        String resultados = "";
        Exame instance = new Exame();
        instance.setResultados(resultados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObservacoes method, of class Exame.
     */
    @Test
    public void testGetObservacoes() {
        System.out.println("getObservacoes");
        Exame instance = new Exame();
        String expResult = "";
        String result = instance.getObservacoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObservacoes method, of class Exame.
     */
    @Test
    public void testSetObservacoes() {
        System.out.println("setObservacoes");
        String observacoes = "";
        Exame instance = new Exame();
        instance.setObservacoes(observacoes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
