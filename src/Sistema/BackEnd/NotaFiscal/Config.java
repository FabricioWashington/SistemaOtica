package Sistema.BackEnd.NotaFiscal;

import br.com.swconsultoria.certificado.Certificado;
import br.com.swconsultoria.certificado.CertificadoService;
import br.com.swconsultoria.certificado.exception.CertificadoException;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import br.com.swconsultoria.nfe.exception.NfeException;
import java.io.FileNotFoundException;

public class Config {

    public static ConfiguracoesNfe configurarCertificado(String caminhoCertificado, String senhaCertificado,
            EstadosEnum estado, AmbienteEnum ambiente)
            throws CertificadoException, NfeException, FileNotFoundException {
        // Carrega o certificado com o caminho e senha fornecidos pelo usuário
        Certificado certificado = CertificadoService.certificadoPfx(caminhoCertificado, senhaCertificado);

        // Configuração do ambiente com o estado e ambiente selecionado
        return ConfiguracoesNfe.criarConfiguracoes(
                estado, // Estado selecionado
                ambiente, // Ambiente selecionado
                certificado,
                "C:\\Users\\I5 9400F\\Desktop\\Pasta unica\\LibsSistemaOtica\\java-nfe-4.00.34\\schemas" // Caminho dos schemas
        );
    }

    public static ConfiguracoesNfe iniciaConfiguracoes() throws CertificadoException, NfeException, FileNotFoundException {
        // Caminho e senha do certificado digital
        Certificado certificado = CertificadoService.certificadoPfx("C:\\Users\\I5 9400F\\Desktop\\Pasta unica\\OPTICA OPTIVISUS LTDA_05657330000178.pfx", "123456");

        // Configuração do ambiente (substitua o estado e o ambiente conforme necessário)
        return ConfiguracoesNfe.criarConfiguracoes(
                EstadosEnum.DF, // Estado
                AmbienteEnum.HOMOLOGACAO, // Ambiente de Homologação ou Produção
                certificado,
                "C:\\Users\\I5 9400F\\Desktop\\Pasta unica\\LibsSistemaOtica\\java-nfe-4.00.34\\schemas" // Caminho dos schemas
        );
    }

}
