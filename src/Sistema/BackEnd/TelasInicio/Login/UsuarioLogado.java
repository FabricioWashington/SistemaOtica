package Sistema.BackEnd.TelasInicio.Login;

import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import java.awt.Dimension;

public class UsuarioLogado {

    private String nomeUsuario;
    private String tipoAcesso;

    public UsuarioLogado(String nomeUsuario, String tipoAcesso) {
        this.nomeUsuario = nomeUsuario;
        this.tipoAcesso = tipoAcesso;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getTipoAcesso() {
        return tipoAcesso;
    }

    public void aplicarRestricoesFuncionarios(List<Component> componentesParaEsconder, Dimension novaDimensaoTabela, Component tabela, Component scrollPane, Component labelHistorico) {
        // Esconder os componentes para funcionários
        if ("Funcionario".equals(getTipoAcesso())) {
            // Esconder todos os componentes fornecidos na lista
            for (Component componente : componentesParaEsconder) {
                if (componente != null) {
                    componente.setVisible(false);
                }
            }

            // Verificações e ajustes nos componentes que devem ser modificados (se não forem nulos)
            if (tabela != null && novaDimensaoTabela != null) {
                tabela.setPreferredSize(novaDimensaoTabela);
                tabela.revalidate();
                tabela.repaint();
            }

            if (scrollPane != null && novaDimensaoTabela != null) {
                scrollPane.setPreferredSize(novaDimensaoTabela);
                scrollPane.revalidate();
                scrollPane.repaint();
            }

            if (labelHistorico != null) {
                labelHistorico.setVisible(true);
                labelHistorico.revalidate();
                labelHistorico.repaint();
            }

            if (tabela != null) {
                tabela.revalidate();
                tabela.repaint();
            }
        }
    }

}
