package Sistema.BackEnd.NotaFiscal;


import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import br.com.swconsultoria.nfe.dom.enuns.PessoaEnum;
import br.com.swconsultoria.nfe.schema.retConsCad.TRetConsCad;
import br.com.swconsultoria.nfe.util.RetornoUtil;

/**
 * @author Samuel Oliveira
 *
 */
public class ConsultaCadastro {

    public static void main(String[] args) {
        try {
            // Inicia As Configurações - ver https://github.com/Samuel-Oliveira/Java_NFe/wiki/1-:-Configuracoes
            ConfiguracoesNfe config = Config.iniciaConfiguracoes();

            //Envia a Consulta
            TRetConsCad retorno = Nfe.consultaCadastro(config, PessoaEnum.JURIDICA, "XXX", EstadosEnum.DF);

            //Valida o Retorno da Consulta Cadastro
            RetornoUtil.validaConsultaCadastro(retorno);

            //Resultado
            System.out.println();
            System.out.println("# Status: " + retorno.getInfCons().getCStat() + " - " + retorno.getInfCons().getXMotivo());
            System.out.println();
            retorno.getInfCons().getInfCad().forEach(cadastro -> {
                System.out.println("# Razão Social: " + cadastro.getXNome());
                System.out.println("# Cnpj: " + cadastro.getCNPJ());
                System.out.println("# Ie: " + cadastro.getIE());
            });

        } catch (Exception e) {
            System.err.println();
            System.err.println(e.getMessage());
        }
    }
}
