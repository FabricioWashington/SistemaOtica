package Sistema.BackEnd.TelasPrincipais.Crud;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmpresaTest {

    private Empresa empresa;

    public EmpresaTest() {
        empresa = new Empresa();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        empresa = new Empresa();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of cadastrar method, of class Empresa.
     */
    @Test
    public void testCadastrar() {
        empresa.setCnpj("12.345.678/0001-95");
        empresa.setRazaoSocial("Empresa Teste");
        empresa.setNomeFantasia("Fantasia Teste");
        empresa.setRegimeTributario("Simples Nacional");
        empresa.setInscricaoEstadual("123456789");
        empresa.setIndicadorIE("N");
        empresa.setIdCNAE(1234);
        empresa.setIdDDD(61);
        empresa.setTelefone("999999999");
        empresa.setTelefone2("888888888");
        empresa.setEmail("teste@empresa.com");
        empresa.setLogradouro("Rua Teste");
        empresa.setBairro("Bairro Teste");
        empresa.setNumero("123");
        empresa.setComplemento("Sala 1");
        empresa.setCep("70000-000");
        empresa.setUf("DF");
        empresa.setMunicipio("Brasília");
    }

    /**
     * Test of obterDataAtual method, of class Empresa.
     */
    @Test
    public void testObterDataAtual() {
        System.out.println("obterDataAtual");
        Empresa instance = new Empresa();
        instance.obterDataAtual();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdContato method, of class Empresa.
     */
    @Test
    public void testGetIdContato() {
        System.out.println("getIdContato");
        Empresa instance = new Empresa();
        int expResult = 0;
        int result = instance.getIdContato();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdContato method, of class Empresa.
     */
    @Test
    public void testSetIdContato() {
        System.out.println("setIdContato");
        int idContato = 0;
        Empresa instance = new Empresa();
        instance.setIdContato(idContato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdEndereco method, of class Empresa.
     */
    @Test
    public void testGetIdEndereco() {
        System.out.println("getIdEndereco");
        Empresa instance = new Empresa();
        int expResult = 0;
        int result = instance.getIdEndereco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdEndereco method, of class Empresa.
     */
    @Test
    public void testSetIdEndereco() {
        System.out.println("setIdEndereco");
        int idEndereco = 0;
        Empresa instance = new Empresa();
        instance.setIdEndereco(idEndereco);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdEmpresa method, of class Empresa.
     */
    @Test
    public void testGetIdEmpresa() {
        System.out.println("getIdEmpresa");
        Empresa instance = new Empresa();
        int expResult = 0;
        int result = instance.getIdEmpresa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdEmpresa method, of class Empresa.
     */
    @Test
    public void testSetIdEmpresa() {
        System.out.println("setIdEmpresa");
        int idEmpresa = 0;
        Empresa instance = new Empresa();
        instance.setIdEmpresa(idEmpresa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdCNAE method, of class Empresa.
     */
    @Test
    public void testGetIdCNAE() {
        System.out.println("getIdCNAE");
        Empresa instance = new Empresa();
        int expResult = 0;
        int result = instance.getIdCNAE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCNAE method, of class Empresa.
     */
    @Test
    public void testSetIdCNAE() {
        System.out.println("setIdCNAE");
        int idCNAE = 0;
        Empresa instance = new Empresa();
        instance.setIdCNAE(idCNAE);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCnpj method, of class Empresa.
     */
    @Test
    public void testGetCnpj() {
        System.out.println("getCnpj");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getCnpj();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCnpj method, of class Empresa.
     */
    @Test
    public void testSetCnpj() {
        System.out.println("setCnpj");
        String cnpj = "";
        Empresa instance = new Empresa();
        instance.setCnpj(cnpj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRazaoSocial method, of class Empresa.
     */
    @Test
    public void testGetRazaoSocial() {
        System.out.println("getRazaoSocial");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getRazaoSocial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRazaoSocial method, of class Empresa.
     */
    @Test
    public void testSetRazaoSocial() {
        System.out.println("setRazaoSocial");
        String razaoSocial = "";
        Empresa instance = new Empresa();
        instance.setRazaoSocial(razaoSocial);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNomeFantasia method, of class Empresa.
     */
    @Test
    public void testGetNomeFantasia() {
        System.out.println("getNomeFantasia");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getNomeFantasia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNomeFantasia method, of class Empresa.
     */
    @Test
    public void testSetNomeFantasia() {
        System.out.println("setNomeFantasia");
        String nomeFantasia = "";
        Empresa instance = new Empresa();
        instance.setNomeFantasia(nomeFantasia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegimeTributario method, of class Empresa.
     */
    @Test
    public void testGetRegimeTributario() {
        System.out.println("getRegimeTributario");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getRegimeTributario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegimeTributario method, of class Empresa.
     */
    @Test
    public void testSetRegimeTributario() {
        System.out.println("setRegimeTributario");
        String regimeTributario = "";
        Empresa instance = new Empresa();
        instance.setRegimeTributario(regimeTributario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInscricaoEstadual method, of class Empresa.
     */
    @Test
    public void testGetInscricaoEstadual() {
        System.out.println("getInscricaoEstadual");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getInscricaoEstadual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInscricaoEstadual method, of class Empresa.
     */
    @Test
    public void testSetInscricaoEstadual() {
        System.out.println("setInscricaoEstadual");
        String inscricaoEstadual = "";
        Empresa instance = new Empresa();
        instance.setInscricaoEstadual(inscricaoEstadual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndicadorIE method, of class Empresa.
     */
    @Test
    public void testGetIndicadorIE() {
        System.out.println("getIndicadorIE");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getIndicadorIE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIndicadorIE method, of class Empresa.
     */
    @Test
    public void testSetIndicadorIE() {
        System.out.println("setIndicadorIE");
        String indicadorIE = "";
        Empresa instance = new Empresa();
        instance.setIndicadorIE(indicadorIE);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataCadastro method, of class Empresa.
     */
    @Test
    public void testGetDataCadastro() {
        System.out.println("getDataCadastro");
        Empresa instance = new Empresa();
        Date expResult = null;
        Date result = instance.getDataCadastro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataCadastro method, of class Empresa.
     */
    @Test
    public void testSetDataCadastro() {
        System.out.println("setDataCadastro");
        Date dataCadastro = null;
        Empresa instance = new Empresa();
        instance.setDataCadastro(dataCadastro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataModificacao method, of class Empresa.
     */
    @Test
    public void testGetDataModificacao() {
        System.out.println("getDataModificacao");
        Empresa instance = new Empresa();
        Date expResult = null;
        Date result = instance.getDataModificacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataModificacao method, of class Empresa.
     */
    @Test
    public void testSetDataModificacao() {
        System.out.println("setDataModificacao");
        Date dataModificacao = null;
        Empresa instance = new Empresa();
        instance.setDataModificacao(dataModificacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdDDD method, of class Empresa.
     */
    @Test
    public void testGetIdDDD() {
        System.out.println("getIdDDD");
        Empresa instance = new Empresa();
        int expResult = 0;
        int result = instance.getIdDDD();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdDDD method, of class Empresa.
     */
    @Test
    public void testSetIdDDD() {
        System.out.println("setIdDDD");
        int idDDD = 0;
        Empresa instance = new Empresa();
        instance.setIdDDD(idDDD);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLogradouro method, of class Empresa.
     */
    @Test
    public void testGetLogradouro() {
        System.out.println("getLogradouro");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getLogradouro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLogradouro method, of class Empresa.
     */
    @Test
    public void testSetLogradouro() {
        System.out.println("setLogradouro");
        String logradouro = "";
        Empresa instance = new Empresa();
        instance.setLogradouro(logradouro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBairro method, of class Empresa.
     */
    @Test
    public void testGetBairro() {
        System.out.println("getBairro");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getBairro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBairro method, of class Empresa.
     */
    @Test
    public void testSetBairro() {
        System.out.println("setBairro");
        String bairro = "";
        Empresa instance = new Empresa();
        instance.setBairro(bairro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class Empresa.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class Empresa.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        String numero = "";
        Empresa instance = new Empresa();
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComplemento method, of class Empresa.
     */
    @Test
    public void testGetComplemento() {
        System.out.println("getComplemento");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getComplemento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComplemento method, of class Empresa.
     */
    @Test
    public void testSetComplemento() {
        System.out.println("setComplemento");
        String complemento = "";
        Empresa instance = new Empresa();
        instance.setComplemento(complemento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCep method, of class Empresa.
     */
    @Test
    public void testGetCep() {
        System.out.println("getCep");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getCep();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCep method, of class Empresa.
     */
    @Test
    public void testSetCep() {
        System.out.println("setCep");
        String cep = "";
        Empresa instance = new Empresa();
        instance.setCep(cep);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUf method, of class Empresa.
     */
    @Test
    public void testGetUf() {
        System.out.println("getUf");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getUf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUf method, of class Empresa.
     */
    @Test
    public void testSetUf() {
        System.out.println("setUf");
        String uf = "";
        Empresa instance = new Empresa();
        instance.setUf(uf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMunicipio method, of class Empresa.
     */
    @Test
    public void testGetMunicipio() {
        System.out.println("getMunicipio");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getMunicipio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMunicipio method, of class Empresa.
     */
    @Test
    public void testSetMunicipio() {
        System.out.println("setMunicipio");
        String municipio = "";
        Empresa instance = new Empresa();
        instance.setMunicipio(municipio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefone method, of class Empresa.
     */
    @Test
    public void testGetTelefone() {
        System.out.println("getTelefone");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getTelefone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefone method, of class Empresa.
     */
    @Test
    public void testSetTelefone() {
        System.out.println("setTelefone");
        String telefone = "";
        Empresa instance = new Empresa();
        instance.setTelefone(telefone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefone2 method, of class Empresa.
     */
    @Test
    public void testGetTelefone2() {
        System.out.println("getTelefone2");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getTelefone2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefone2 method, of class Empresa.
     */
    @Test
    public void testSetTelefone2() {
        System.out.println("setTelefone2");
        String telefone2 = "";
        Empresa instance = new Empresa();
        instance.setTelefone2(telefone2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Empresa.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Empresa.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Empresa instance = new Empresa();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
