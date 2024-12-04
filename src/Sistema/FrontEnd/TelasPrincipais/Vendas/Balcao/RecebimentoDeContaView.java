package Sistema.FrontEnd.TelasPrincipais.Vendas.Balcao;

import Sistema.FrontEnd.TelasPrincipais.Vendas.VendaClienteView;
import java.math.BigDecimal;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class RecebimentoDeContaView extends JDialog {

    private DefaultTableModel tabelaProdutos;
    private BigDecimal totalVenda;
   

    public RecebimentoDeContaView(JFrame parent, String title, boolean modal) {
        super(parent, title, modal);
        initComponents();

        // tabela formas de pagamento
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tablePagamento.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        //Largura dos campos
        TableColumnModel columnModel = tablePagamento.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20); // Coluna Codigo
        columnModel.getColumn(1).setPreferredWidth(100); // Coluna Descrição

        // tabela Resumo
        DefaultTableCellRenderer renderer2 = (DefaultTableCellRenderer) tableResumo.getTableHeader().getDefaultRenderer();
        renderer2.setHorizontalAlignment(SwingConstants.CENTER);
        //Largura dos campos
        TableColumnModel columnModel2 = tableResumo.getColumnModel();
        columnModel2.getColumn(0).setPreferredWidth(20); // Coluna Item
        columnModel2.getColumn(1).setPreferredWidth(20); // Coluna Codigo
        columnModel2.getColumn(2).setPreferredWidth(100); // Coluna Descrição
        columnModel2.getColumn(3).setPreferredWidth(100); // Coluna Valor Recebimento

    }

    public RecebimentoDeContaView(DefaultTableModel tabelaProdutos, BigDecimal totalVenda) {
        initComponents();
        this.tabelaProdutos = tabelaProdutos;
        this.totalVenda = totalVenda;
        txtVlrRecebimento.setText(totalVenda.toString());
        jLabel7.setText("Total R$ " + totalVenda.toString());
        lblReceber.setText(totalVenda.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableResumo = new javax.swing.JTable();
        t = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePagamento = new javax.swing.JTable();
        cbxCliente = new javax.swing.JComboBox<>();
        cbxFuncionario = new javax.swing.JComboBox<>();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblReceber = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        F7_Valores = new javax.swing.JLabel();
        F8_Desconto = new javax.swing.JLabel();
        F9_CancelarItem = new javax.swing.JLabel();
        F10_Gravar = new javax.swing.JLabel();
        F11_Cancelar = new javax.swing.JLabel();
        F12_Sair = new javax.swing.JLabel();
        txtVlrRecebimento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("WASHINGTON TECHNOLOGY - SISTEMA ÓTICA - VERSION 1.01.1");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Total R$ 0,00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setText("1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Forma Recebimento (F4)");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Valor Recebimento (F5)");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jScrollPane2.setBorder(null);

        tableResumo.setBackground(new java.awt.Color(255, 255, 255));
        tableResumo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableResumo.setForeground(new java.awt.Color(0, 0, 0));
        tableResumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Descrição", "Valor Recebimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableResumo.setFillsViewportHeight(true);
        tableResumo.setFocusTraversalPolicyProvider(true);
        tableResumo.setGridColor(new java.awt.Color(102, 102, 102));
        tableResumo.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableResumo.setShowGrid(false);
        tableResumo.getTableHeader().setResizingAllowed(false);
        tableResumo.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableResumo);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        t.setBackground(new java.awt.Color(255, 255, 255));
        t.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        tablePagamento.setBackground(new java.awt.Color(255, 255, 255));
        tablePagamento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablePagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePagamento.setFillsViewportHeight(true);
        tablePagamento.setGridColor(new java.awt.Color(153, 153, 153));
        tablePagamento.setShowGrid(false);
        tablePagamento.setShowHorizontalLines(true);
        tablePagamento.setShowVerticalLines(true);
        tablePagamento.getTableHeader().setResizingAllowed(false);
        tablePagamento.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablePagamento);

        cbxCliente.setBackground(new java.awt.Color(255, 255, 255));
        cbxCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxCliente.setForeground(new java.awt.Color(0, 0, 0));
        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        cbxFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        cbxFuncionario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxFuncionario.setForeground(new java.awt.Color(0, 0, 0));
        cbxFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        txtCpf.setBackground(new java.awt.Color(255, 255, 255));
        txtCpf.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Cliente");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("CPF");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Vendedor");

        javax.swing.GroupLayout tLayout = new javax.swing.GroupLayout(t);
        t.setLayout(tLayout);
        tLayout.setHorizontalGroup(
            tLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tLayout.createSequentialGroup()
                        .addGroup(tLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tLayout.setVerticalGroup(
            tLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpf)
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        jLabel3.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Desconto:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Receber:");

        jLabel6.setFont(new java.awt.Font("Book Antiqua", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("0,00");

        lblReceber.setFont(new java.awt.Font("Book Antiqua", 0, 36)); // NOI18N
        lblReceber.setForeground(new java.awt.Color(0, 0, 0));
        lblReceber.setText("0,00");

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Faltam R$");

        jLabel8.setFont(new java.awt.Font("Book Antiqua", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("0,00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(167, 167, 167)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        F7_Valores.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        F7_Valores.setForeground(new java.awt.Color(0, 0, 0));
        F7_Valores.setText("[F7] Valores");
        F7_Valores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        F7_Valores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F7_ValoresMouseClicked(evt);
            }
        });

        F8_Desconto.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        F8_Desconto.setForeground(new java.awt.Color(0, 0, 0));
        F8_Desconto.setText("[F8] Desconto");
        F8_Desconto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        F8_Desconto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F8_DescontoMouseClicked(evt);
            }
        });

        F9_CancelarItem.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        F9_CancelarItem.setForeground(new java.awt.Color(0, 0, 0));
        F9_CancelarItem.setText("[F9] Cancelar Item");
        F9_CancelarItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        F9_CancelarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F9_CancelarItemMouseClicked(evt);
            }
        });

        F10_Gravar.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        F10_Gravar.setForeground(new java.awt.Color(0, 0, 0));
        F10_Gravar.setText("[F10] Gravar");
        F10_Gravar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        F10_Gravar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F10_GravarMouseClicked(evt);
            }
        });

        F11_Cancelar.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        F11_Cancelar.setForeground(new java.awt.Color(0, 0, 0));
        F11_Cancelar.setText("[F11] Cancelar");
        F11_Cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        F11_Cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F11_CancelarMouseClicked(evt);
            }
        });

        F12_Sair.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        F12_Sair.setForeground(new java.awt.Color(0, 0, 0));
        F12_Sair.setText("[F12] Sair");
        F12_Sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        F12_Sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F12_SairMouseClicked(evt);
            }
        });

        txtVlrRecebimento.setEditable(false);
        txtVlrRecebimento.setBackground(new java.awt.Color(255, 255, 255));
        txtVlrRecebimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtVlrRecebimento.setForeground(new java.awt.Color(0, 0, 0));
        txtVlrRecebimento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtVlrRecebimento.setText("0,00");
        txtVlrRecebimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVlrRecebimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblReceber))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(45, 45, 45))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 38, Short.MAX_VALUE))
                                    .addComponent(txtVlrRecebimento)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(F7_Valores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(F8_Desconto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(F9_CancelarItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(F10_Gravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(F11_Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(F12_Sair)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVlrRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(F7_Valores)
                    .addComponent(F8_Desconto)
                    .addComponent(F9_CancelarItem)
                    .addComponent(F10_Gravar)
                    .addComponent(F11_Cancelar)
                    .addComponent(F12_Sair))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 570));

        setSize(new java.awt.Dimension(630, 571));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void txtVlrRecebimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVlrRecebimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVlrRecebimentoActionPerformed

    private void F7_ValoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F7_ValoresMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_F7_ValoresMouseClicked

    private void F8_DescontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F8_DescontoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_F8_DescontoMouseClicked

    private void F9_CancelarItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F9_CancelarItemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_F9_CancelarItemMouseClicked

    private void F10_GravarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F10_GravarMouseClicked
        // 
        VendaClienteView vendacliente = new VendaClienteView(null, "VendaCliente", true);
        vendacliente.setVisible(true);
    }//GEN-LAST:event_F10_GravarMouseClicked

    private void F11_CancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F11_CancelarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_F11_CancelarMouseClicked

    private void F12_SairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F12_SairMouseClicked
        // fechar
        dispose();
    }//GEN-LAST:event_F12_SairMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecebimentoDeContaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecebimentoDeContaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecebimentoDeContaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecebimentoDeContaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecebimentoDeContaView(null, "RecebimentoDeContaView", true).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel F10_Gravar;
    private javax.swing.JLabel F11_Cancelar;
    private javax.swing.JLabel F12_Sair;
    private javax.swing.JLabel F7_Valores;
    private javax.swing.JLabel F8_Desconto;
    private javax.swing.JLabel F9_CancelarItem;
    private javax.swing.JComboBox<String> cbxCliente;
    private javax.swing.JComboBox<String> cbxFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblReceber;
    private javax.swing.JPanel t;
    private javax.swing.JTable tablePagamento;
    private javax.swing.JTable tableResumo;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtVlrRecebimento;
    // End of variables declaration//GEN-END:variables
}
