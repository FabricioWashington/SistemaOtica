package Sistema.BackEnd.TelasInicio.Login;

import static Sistema.FrontEnd.TelasPrincipais.Telas.CadastroView.btnCadastroUsuarios;
import static Sistema.FrontEnd.TelasPrincipais.Telas.CadastroView.lblCadastro_Usuario;
import static Sistema.FrontEnd.TelasPrincipais.Telas.HomeView.btnECF;
import static Sistema.FrontEnd.TelasPrincipais.Telas.HomeView.btnFinanceiro_Auditoria;
import static Sistema.FrontEnd.TelasPrincipais.Telas.HomeView.graficoPanel;
import static Sistema.FrontEnd.TelasPrincipais.Telas.HomeView.jScrollPane1;
import static Sistema.FrontEnd.TelasPrincipais.Telas.HomeView.lblHistorico;
import static Sistema.FrontEnd.TelasPrincipais.Telas.HomeView.tabela1;
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

    public void aplicarRestricoesFuncionarios() {
        if ("Funcionario".equals(getTipoAcesso())) {
            btnFinanceiro_Auditoria.setVisible(false);
            btnECF.setVisible(false);
            graficoPanel.setVisible(false);
            //btnCadastroUsuarios.setVisible(false);
            //lblCadastro_Usuario.setVisible(false);
            tabela1.setPreferredSize(new Dimension(1580, 600));
            jScrollPane1.setPreferredSize(new Dimension(1580, 600));
            jScrollPane1.setVisible(true);
            lblHistorico.setVisible(true);
            jScrollPane1.revalidate();
            jScrollPane1.repaint();
            lblHistorico.revalidate();
            lblHistorico.repaint();
            tabela1.revalidate();
            tabela1.repaint();

        }
    }

}
