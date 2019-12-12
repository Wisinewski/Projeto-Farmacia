package view;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.ProdutoController;
import db.DB;
import model.dao.PedidoDao;
import model.dao.ProdutoItemDao;
import model.dao.impl.PedidoDaoJDBC;
import model.dao.impl.ProdutoItemDaoJDBC;
import model.entities.Pedido;
import model.entities.Produto;
import model.entities.ProdutoItem;

public class JF_Venda extends javax.swing.JFrame {

    ProdutoItem produtoItem;
    ProdutoController produtoController;
    ProdutoItemDao produtoItemDao ;
    PedidoDao pedidoDao;
    Pedido pedido;
    DefaultTableModel modelo, listamodel;
    List<Produto> ls_produto;
    JF_Menu menu;

    Integer qtd, id_produto;
    String nome;
    Double preco, total;

    public JF_Venda() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        novoPedido();
        menu = new JF_Menu();
        
        produtoItemDao = new ProdutoItemDaoJDBC(DB.getConnection());
        produtoController = new ProdutoController();
        menu.setVisible(false);
        modelo = (DefaultTableModel) Jt_Produto.getModel();
        listamodel = (DefaultTableModel) JT_preco.getModel();
        ReadJtable();
        total = 0.00;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jt_Produto = new javax.swing.JTable();
        txt_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_adicionar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        JT_preco = new javax.swing.JTable();
        txt_total = new javax.swing.JTextField();
        btn_finalizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_voltar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jt_Produto.setBackground(new java.awt.Color(204, 255, 255));
        Jt_Produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Preço", "Presc. Medica", "Qtd Estoquel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Jt_Produto);
        if (Jt_Produto.getColumnModel().getColumnCount() > 0) {
            Jt_Produto.getColumnModel().getColumn(0).setHeaderValue("ID");
            Jt_Produto.getColumnModel().getColumn(3).setHeaderValue("Presc. Medica");
            Jt_Produto.getColumnModel().getColumn(4).setHeaderValue("Qtd Estoquel");
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 350, 153));

        txt_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nomeKeyPressed(evt);
            }
        });
        jPanel1.add(txt_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 157, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 40, -1));

        btn_adicionar.setBackground(new java.awt.Color(255, 255, 255));
        btn_adicionar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_adicionar.setText("Adicionar");
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_adicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 90, 42));

        JT_preco.setBackground(new java.awt.Color(204, 255, 255));
        JT_preco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Preço", "Qtd"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JT_preco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_precoMouseClicked(evt);
            }
        });
        JT_preco.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                JT_precoInputMethodTextChanged(evt);
            }
        });
        JT_preco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JT_precoKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(JT_preco);
        if (JT_preco.getColumnModel().getColumnCount() > 0) {
            JT_preco.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 269, 153));

        txt_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_total.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 70, 40));

        btn_finalizar.setBackground(new java.awt.Color(255, 255, 255));
        btn_finalizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_finalizar.setText("Finalizar");
        btn_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finalizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_finalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 220, 80, 46));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("R$");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 43, 51));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Venda");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(310, 30, 74, 29);

        btn_voltar.setBackground(new java.awt.Color(255, 255, 255));
        btn_voltar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_voltar);
        btn_voltar.setBounds(20, 20, 74, 23);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomeKeyPressed
        ReadJtableByName(txt_nome.getText());
    }//GEN-LAST:event_txt_nomeKeyPressed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        this.dispose();

        menu.setVisible(true);
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
        String numero = JOptionPane.showInputDialog("Qtd");
        qtd = Integer.parseInt(numero);
      //  System.out.println("" + qtd);

        transfereinfo();
        addlistpreco(id_produto, qtd, nome, preco);
        finalizaPedido();
    }//GEN-LAST:event_btn_adicionarActionPerformed

    private void btn_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalizarActionPerformed

       //produtoItemDao.findAllById(pedido.getIdpedido()).stream().forEach(System.out::println);
       int n_pedido =0;
      
        JOptionPane.showMessageDialog(null, n_pedido = pedido.getIdpedido(),"Número Pedido", JOptionPane.INFORMATION_MESSAGE);
       
       
       

    }//GEN-LAST:event_btn_finalizarActionPerformed

    private void JT_precoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_JT_precoInputMethodTextChanged

    }//GEN-LAST:event_JT_precoInputMethodTextChanged

    private void JT_precoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JT_precoKeyTyped
      
    }//GEN-LAST:event_JT_precoKeyTyped

    private void JT_precoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_precoMouseClicked

    }//GEN-LAST:event_JT_precoMouseClicked

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
            java.util.logging.Logger.getLogger(JF_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JF_Venda().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JF_Venda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JT_preco;
    private javax.swing.JTable Jt_Produto;
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_finalizar;
    private javax.swing.JToggleButton btn_voltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables

    private void ReadJtable() {

        modelo.setNumRows(0);
        for (Produto p : produtoController.findAll()) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getPreco(),
                p.toBooleanPrescricao(),
                p.getQtd()
            });

        }

    }

    private void ReadJtableByName(String desc) {

        modelo.setNumRows(0);

        for (Produto p : produtoController.findbyWord(desc)) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getPreco(),
                p.toBooleanPrescricao(),
                p.getQtd()
            });

        }

    }

    private void DeleteRow() {
        ls_produto = produtoController.findAll();

        Integer f = (Integer) Jt_Produto.getValueAt(Jt_Produto.getSelectedRow(), 0);
        if (produtoController.deleteById(f)) {
            JOptionPane.showMessageDialog(null,
                    "Produto Deletado!!", "Mensagem", WIDTH);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Erro ao Deletar o Produto!!", "Mensagem", ERROR_MESSAGE);
        }
        ReadJtable();
    }
    
    private void novoPedido() {
        pedidoDao = new PedidoDaoJDBC(DB.getConnection());
        pedido = new Pedido(null, "10-12-2019", 0.0);
        pedidoDao.insert(pedido);
    }

    private void addlistpreco(int id_produto, int qtd, String nome, Double preco) {

        listamodel.addRow(new Object[]{
            id_produto,
            nome,
            preco,
            qtd
        });
        ProdutoItemDao produtoItemDao = new ProdutoItemDaoJDBC(DB.getConnection());

        // cria novo produtoItem e insere com parametros (idpedido, idproduto, qtd).  Tambem vai adicionando ao preco total;
    }

    private void finalizaPedido() {

       
        produtoItem = new ProdutoItem(pedido.getIdpedido(), id_produto, qtd);
        produtoItemDao.insert(produtoItem);
        pedido.adicionaPrecoPedido(produtoItem);
        pedidoDao.update(pedido);
        txt_total.setText("" + pedido.getPrecopedido());

    }

    private void transfereinfo() {
        id_produto = (int) Jt_Produto.getValueAt(Jt_Produto.getSelectedRow(), 0);
        nome = (String) Jt_Produto.getValueAt(Jt_Produto.getSelectedRow(), 1);
        preco = (Double) Jt_Produto.getValueAt(Jt_Produto.getSelectedRow(), 2);

    }

}
