package Sistema.BackEnd.NotaFiscal;

import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.DocumentoEnum;
import br.com.swconsultoria.nfe.schema_4.retConsSitNFe.TRetConsSitNFe;

public class NFeConsultaXml {

    public static void main(String[] args) {
        try {
            // Inicia as configurações NFe
            ConfiguracoesNfe config = Config.iniciaConfiguracoes();

            // Informe a chave de acesso da NFe que será consultada
            String chave = "52190310732644000128550010000125531000125532"; // Exemplo de chave

            // Efetua a consulta da NFe na SEFAZ
            TRetConsSitNFe retorno = Nfe.consultaXml(config, chave, DocumentoEnum.NFE);

            // Exibe o status e motivo do retorno da consulta
            System.out.println();
            System.out.println("# Status: " + retorno.getCStat() + " - " + retorno.getXMotivo());
        } catch (Exception e) {
            System.err.println();
            System.err.println("# Erro: " + e.getMessage());
        }
    }
}
