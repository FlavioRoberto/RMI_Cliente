/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.View;

/**
 *
 * @author Bruno
 */
public class View_Gerente extends javax.swing.JFrame {

    /**
     * Creates new form View_Gerente
     */
    public View_Gerente() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button_CadastraFuncionario1 = new javax.swing.JButton();
        Button_CadastraFuncionario = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        Button_CadastraProduto = new javax.swing.JButton();
        Button_CadastraCliente = new javax.swing.JButton();
        Button_EditaFuncionario = new javax.swing.JButton();
        Button_EditarProduto = new javax.swing.JButton();
        Button_EditarCliente = new javax.swing.JButton();
        Button_EncerraSessao = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        Button_CadastraFuncionario1.setText("Editar Funcionario");
        Button_CadastraFuncionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CadastraFuncionario1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gerente");
        setResizable(false);

        Button_CadastraFuncionario.setText("Cadastrar Funcionario");
        Button_CadastraFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CadastraFuncionarioActionPerformed(evt);
            }
        });

        Button_CadastraProduto.setText("Cadastrar Produto");
        Button_CadastraProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CadastraProdutoActionPerformed(evt);
            }
        });

        Button_CadastraCliente.setText("Cadastrar Cliente");
        Button_CadastraCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CadastraClienteActionPerformed(evt);
            }
        });

        Button_EditaFuncionario.setText("Editar Funcionario");
        Button_EditaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EditaFuncionarioActionPerformed(evt);
            }
        });

        Button_EditarProduto.setText("Editar Produto");
        Button_EditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EditarProdutoActionPerformed(evt);
            }
        });

        Button_EditarCliente.setText("Editar Cliente");
        Button_EditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EditarClienteActionPerformed(evt);
            }
        });

        Button_EncerraSessao.setText("Encerrar Sessão");
        Button_EncerraSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EncerraSessaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Button_CadastraFuncionario)
                        .addGap(18, 18, 18)
                        .addComponent(Button_CadastraProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_CadastraCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Button_EditaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Button_EncerraSessao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Button_EditarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(Button_EditarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_CadastraFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_CadastraProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_CadastraCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_EditaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_EditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_EditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Button_EncerraSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Button_CadastraFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CadastraFuncionarioActionPerformed
        View_CadastraFuncionario view = new View_CadastraFuncionario();
        view.setVisible(true);
    }//GEN-LAST:event_Button_CadastraFuncionarioActionPerformed

    private void Button_CadastraProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CadastraProdutoActionPerformed
        View_CadastroProduto view = new View_CadastroProduto();
        view.setVisible(true);
    }//GEN-LAST:event_Button_CadastraProdutoActionPerformed

    private void Button_CadastraClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CadastraClienteActionPerformed
        View_CadastroCliente view = new View_CadastroCliente();
        view.setVisible(true);
    }//GEN-LAST:event_Button_CadastraClienteActionPerformed

    private void Button_CadastraFuncionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CadastraFuncionario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_CadastraFuncionario1ActionPerformed

    private void Button_EditaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EditaFuncionarioActionPerformed
        View_PesquisaFuncionario view = new View_PesquisaFuncionario();
        view.setVisible(true);
    }//GEN-LAST:event_Button_EditaFuncionarioActionPerformed

    private void Button_EditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EditarProdutoActionPerformed
        View_PesquisaProduto view = new View_PesquisaProduto();
        view.setVisible(true);
    }//GEN-LAST:event_Button_EditarProdutoActionPerformed

    private void Button_EditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EditarClienteActionPerformed
        View_PesquisaCliente view = new View_PesquisaCliente();
        view.setVisible(true);
    }//GEN-LAST:event_Button_EditarClienteActionPerformed

    private void Button_EncerraSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EncerraSessaoActionPerformed
        Login view = new Login();
        view.setVisible(true);
        dispose();
    }//GEN-LAST:event_Button_EncerraSessaoActionPerformed

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
            java.util.logging.Logger.getLogger(View_Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Gerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_CadastraCliente;
    private javax.swing.JButton Button_CadastraFuncionario;
    private javax.swing.JButton Button_CadastraFuncionario1;
    private javax.swing.JButton Button_CadastraProduto;
    private javax.swing.JButton Button_EditaFuncionario;
    private javax.swing.JButton Button_EditarCliente;
    private javax.swing.JButton Button_EditarProduto;
    private javax.swing.JButton Button_EncerraSessao;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
