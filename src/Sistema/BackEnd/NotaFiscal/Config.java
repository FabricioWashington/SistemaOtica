package Sistema.BackEnd.NotaFiscal;

import DAO.Crud.ConfiguracaoDAO;
import DTO.Crud.ConfiguracaoDTO;
import br.com.swconsultoria.certificado.Certificado;
import br.com.swconsultoria.certificado.CertificadoService;
import br.com.swconsultoria.certificado.exception.CertificadoException;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import br.com.swconsultoria.nfe.exception.NfeException;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

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

    public static ConfiguracoesNfe testeConfiguracoes() throws SQLException, CertificadoException, NfeException, FileNotFoundException {
        // Carregar dados do banco de dados usando ConfiguracaoDAO
        ConfiguracaoDAO configuracaoDAO = new ConfiguracaoDAO();
        List<ConfiguracaoDTO> configuracoes = configuracaoDAO.carregarConfiguracoes();

        // Adicionando logs para depuração
        System.out.println("Iniciando o carregamento das configurações...");
        System.out.println("Configurações carregadas: " + configuracoes.size());
        for (ConfiguracaoDTO config : configuracoes) {
            System.out.println("Certificado: Tirei para gravar o video" /*+ config.getCertificado()*/);
            System.out.println("Senha: Tirei para gravar o video " /*+ config.getSenha()*/);
            System.out.println("Estado: " + config.getEstado());
            System.out.println("Ambiente: " + config.getAmbiente());
        }

        // Certifique-se de que alguma configuração foi carregada
        if (configuracoes.isEmpty()) {
            throw new RuntimeException("Nenhuma configuração encontrada no banco de dados.");
        }

        // Usar a primeira configuração (se existir mais de uma)
        ConfiguracaoDTO configuracaoDTO = configuracoes.get(0);

        // Validar campos obrigatórios
        if (configuracaoDTO.getCertificado() == null || configuracaoDTO.getSenha() == null) {
            throw new RuntimeException("Certificado ou senha não configurados corretamente no banco de dados.");
        }

        if (configuracaoDTO.getEstado() == null || configuracaoDTO.getAmbiente() == null) {
            throw new RuntimeException("Estado ou ambiente não configurados corretamente no banco de dados.");
        }

        // Validar caminho do certificado
        File certificadoFile = new File(configuracaoDTO.getCertificado());
        if (!certificadoFile.exists() || !certificadoFile.isFile()) {
            throw new RuntimeException("Certificado não encontrado no caminho: " + configuracaoDTO.getCertificado());
        }

        // Validar enums
        EstadosEnum estado;
        AmbienteEnum ambiente;
        try {
            estado = EstadosEnum.valueOf(configuracaoDTO.getEstado());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Estado inválido: " + configuracaoDTO.getEstado());
        }

        try {
            ambiente = AmbienteEnum.valueOf(configuracaoDTO.getAmbiente());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Ambiente inválido: " + configuracaoDTO.getAmbiente());
        }

        // Criar certificado
        Certificado certificado = CertificadoService.certificadoPfx(configuracaoDTO.getCertificado(), configuracaoDTO.getSenha());

        // Configurar e retornar a configuração
        return ConfiguracoesNfe.criarConfiguracoes(
                estado,
                ambiente,
                certificado,
                "C:\\Users\\I5 9400F\\Desktop\\Pasta unica\\LibsSistemaOtica\\java-nfe-4.00.34\\schemas" // Substitua pelo caminho correto ou parametrize
        );
    }

}
