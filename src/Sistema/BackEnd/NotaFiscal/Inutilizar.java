package Sistema.BackEnd.NotaFiscal;

import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.DocumentoEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import br.com.swconsultoria.nfe.schema_4.inutNFe.TInutNFe;
import br.com.swconsultoria.nfe.schema_4.inutNFe.TRetInutNFe;
import br.com.swconsultoria.nfe.util.InutilizacaoUtil;
import br.com.swconsultoria.nfe.util.RetornoUtil;

import java.time.LocalDateTime;

/**
 * @author Samuel Oliveira
 *
 */
public class Inutilizar {

    public static void main(String[] args) {

        try {

            /// Inicia As Configurações
            ConfiguracoesNfe config = Config.iniciaConfiguracoes();

            //Informe o CNPJ do emitente
            String cnpj = "XXX";
            //Informe a serie
            int serie = 1;
            //Informe a numeracao Inicial
            int numeroInicial = 1;
            //Informe a numeracao Final
            int numeroFinal = 1;
            //Informe a Justificativa da Inutilizacao
            String justificativa = "Teste de Inutilização";
            //Informe a data do Cancelamento
            LocalDateTime dataCancelamento = LocalDateTime.now();

            //MOnta Inutilização
            TInutNFe inutNFe = InutilizacaoUtil.montaInutilizacao(DocumentoEnum.NFE,cnpj,serie,numeroInicial,numeroFinal,justificativa,dataCancelamento,config);

            //Envia Inutilização
            TRetInutNFe retorno = Nfe.inutilizacao(config,inutNFe, DocumentoEnum.NFE,true);

            //Valida o Retorno da Inutilização
            RetornoUtil.validaInutilizacao(retorno);

            //Resultado
            System.out.println();
            System.out.println("# Status: " + retorno.getInfInut().getCStat() + " - " + retorno.getInfInut().getXMotivo());
            System.out.println("# Protocolo: " + retorno.getInfInut().getNProt());

            //Cria ProcEvento da Inutilização
            String proc = InutilizacaoUtil.criaProcInutilizacao(config,inutNFe, retorno);
            System.out.println();
            System.out.println("# ProcInutilizacao : " + proc);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}