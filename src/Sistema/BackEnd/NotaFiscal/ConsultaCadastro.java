package Sistema.BackEnd.NotaFiscal;


import DTO.Crud.EmpresaDTO;
import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import br.com.swconsultoria.nfe.dom.enuns.PessoaEnum;
import br.com.swconsultoria.nfe.schema.retConsCad.TRetConsCad;
import br.com.swconsultoria.nfe.util.RetornoUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Samuel Oliveira
 *
 */
public class ConsultaCadastro {

    private ConfiguracoesNfe configuracoes; // Configurações do certificado
    private List<EmpresaDTO> empresasConsultadas = new ArrayList<>(); // Lista para armazenar os dados obtidos

    public void consultarCadastro() {
        if (configuracoes == null) {
            JOptionPane.showMessageDialog(null, "Certificado não configurado. Por favor, configure antes de realizar a consulta.");
            return;
        }

        try {
            // Envia a consulta
            TRetConsCad retorno = Nfe.consultaCadastro(configuracoes, PessoaEnum.JURIDICA, "XXX", EstadosEnum.DF);

            // Valida o retorno da consulta
            RetornoUtil.validaConsultaCadastro(retorno);

            // Processa os dados obtidos
            retorno.getInfCons().getInfCad().forEach(cadastro -> {
                EmpresaDTO empresa = new EmpresaDTO(
                        cadastro.getXNome(),
                        cadastro.getCNPJ(),
                        cadastro.getIE()
                );
                empresasConsultadas.add(empresa);
            });

            // Exibe os resultados no console (ou interface gráfica)
            exibirResultados();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a consulta: " + e.getMessage());
        }
    }

    private void exibirResultados() {
        System.out.println("Empresas consultadas:");
        empresasConsultadas.forEach(System.out::println);
    }

    // Getter para acessar os dados armazenados
    public List<EmpresaDTO> getEmpresasConsultadas() {
        return empresasConsultadas;
    }

    // Setter para configurar as configurações do certificado
    public void setConfiguracoes(ConfiguracoesNfe configuracoes) {
        this.configuracoes = configuracoes;
    }
}

