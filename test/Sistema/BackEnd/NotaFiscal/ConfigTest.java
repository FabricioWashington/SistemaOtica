package Sistema.BackEnd.NotaFiscal;

import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
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
public class ConfigTest {

    public ConfigTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of configurarCertificado method, of class Config.
     */
    @Test
    public void testConfigurarCertificado() throws Exception {
        System.out.println("configurarCertificado");
        String caminhoCertificado = "";
        String senhaCertificado = "";
        EstadosEnum estado = null;
        AmbienteEnum ambiente = null;
        ConfiguracoesNfe expResult = null;
        ConfiguracoesNfe result = Config.configurarCertificado(caminhoCertificado, senhaCertificado, estado, ambiente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciaConfiguracoes method, of class Config.
     */
    @Test
    public void testIniciaConfiguracoes() throws Exception {
        System.out.println("iniciaConfiguracoes");
        ConfiguracoesNfe expResult = null;
        ConfiguracoesNfe result = Config.iniciaConfiguracoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testeConfiguracoes method, of class Config.
     */
    @Test
    public void testTesteConfiguracoes() throws Exception {
        System.out.println("testeConfiguracoes - Iniciando o teste de configurações...");

        // Executa o método que será testado
        ConfiguracoesNfe result = Config.testeConfiguracoes();

        // Validação 1: Certifica-se de que o resultado não é nulo
        assertNotNull("As configurações não devem ser nulas.", result);

        // Validação 2: Certifica-se de que o certificado foi configurado
        assertNotNull("O certificado deve ser configurado.", result.getCertificado());

        // Validação 3: Certifica-se de que o ambiente foi configurado
        assertNotNull("O ambiente deve ser configurado.", result.getAmbiente());

        // Validação 4: Certifica-se de que o estado foi configurado
        assertNotNull("O estado deve ser configurado.", result.getEstado());

        // Exibe as configurações carregadas para debug
        System.out.println("Configurações carregadas com sucesso:");
        System.out.println("Certificado: " + result.getCertificado().getArquivo());
        System.out.println("Senha do Certificado: [Senha Oculta]");
        System.out.println("Ambiente: " + result.getAmbiente());
        System.out.println("Estado: " + result.getEstado());
    }

}
