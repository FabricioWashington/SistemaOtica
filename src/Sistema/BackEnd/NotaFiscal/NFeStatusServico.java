package Sistema.BackEnd.NotaFiscal;

import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.DocumentoEnum;
import br.com.swconsultoria.nfe.schema_4.retConsStatServ.TRetConsStatServ;

public class NFeStatusServico {

    public static void main(String[] args) {
        try {
            // Inicia as configurações
            ConfiguracoesNfe config = Config.iniciaConfiguracoes();

            // Efetua a consulta de status do serviço
            TRetConsStatServ retorno = Nfe.statusServico(config, DocumentoEnum.NFE);

            // Exibe o resultado
            System.out.println();
            System.out.println("# Status: " + retorno.getCStat() + " - " + retorno.getXMotivo());
        } catch (Exception e) {
            System.err.println("# Erro: " + e.getMessage());
        }
    }
}
