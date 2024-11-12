package Sistema.BackEnd.NotaFiscal;

import br.com.swconsultoria.certificado.Certificado;
import br.com.swconsultoria.certificado.CertificadoService;
import br.com.swconsultoria.certificado.exception.CertificadoException;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import br.com.swconsultoria.nfe.exception.NfeException;
import java.io.FileNotFoundException;

public class NFeConfig {

    public class ConfiguracaoNFe {

        private static ConfiguracoesNfe configuracoesNfe;

        public static ConfiguracoesNfe criaConfiguracoes() throws CertificadoException, NfeException, FileNotFoundException {
            // Configuração do Certificado Digital (substitua o caminho e senha pelo seu certificado)
            Certificado certificado = CertificadoService.certificadoPfx("C:\\Users\\I5 9400F\\Desktop\\Pasta unica\\OPTICA OPTIVISUS LTDA_05657330000178.pfx", "123456");

            // Configuração Inicial da NFe
            configuracoesNfe = ConfiguracoesNfe.criarConfiguracoes(
                    EstadosEnum.DF, // Substitua pelo estado desejado
                    AmbienteEnum.HOMOLOGACAO, // Ambiente de homologação ou produção
                    certificado,
                    "C:\\Users\\I5 9400F\\Desktop\\Pasta unica\\LibsSistemaOtica\\java-nfe-4.00.34\\schemas" // Caminho da pasta dos Schemas XSD
            );

            return configuracoesNfe;
        }

        public static void main(String[] args) {
            try {
                criaConfiguracoes();
                System.out.println("Configuração inicializada com sucesso!");
            } catch (CertificadoException | NfeException | FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
