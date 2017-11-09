/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.View;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rmi.Interface.IControllerBase;
import rmi.Model.OrdemServico;
import rmi.Model.Venda;
import rmi.Util.conexao_server;

/**
 *
 * @author Bruno
 */
public class View_OrdemDeServico extends javax.swing.JFrame {

    /**
     * Creates new form View_OrdemDeServico
     */
    public View_OrdemDeServico() {
        initComponents();
        Panel_Ordens.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Ordens = new javax.swing.JTable();
        ComboBox_Filtro = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        Button_Filtrar = new javax.swing.JButton();
        Panel_Ordens = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        FormattedTextField_IDOrdem = new javax.swing.JFormattedTextField();
        Button_Finalizar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ordem de Serviço");

        Table_Ordens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Ordem", "Data Expedição", "ID Venda", "ID Funcionario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table_Ordens);

        ComboBox_Filtro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar", "Ordens Completas", "Ordens Incompletas" }));
        ComboBox_Filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_FiltroActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtrar:");

        Button_Filtrar.setText("Filtrar");
        Button_Filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_FiltrarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Finalizar Ordem");

        jLabel4.setText("ID da Ordem:");

        FormattedTextField_IDOrdem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        Button_Finalizar.setText("Finalizar");
        Button_Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_FinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_OrdensLayout = new javax.swing.GroupLayout(Panel_Ordens);
        Panel_Ordens.setLayout(Panel_OrdensLayout);
        Panel_OrdensLayout.setHorizontalGroup(
            Panel_OrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_OrdensLayout.createSequentialGroup()
                .addGroup(Panel_OrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_OrdensLayout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel3))
                    .addGroup(Panel_OrdensLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(FormattedTextField_IDOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_Finalizar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_OrdensLayout.setVerticalGroup(
            Panel_OrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_OrdensLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_OrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(FormattedTextField_IDOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Finalizar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBox_Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_Filtrar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel1)
                        .addGap(230, 230, 230))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(Panel_Ordens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox_Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(Button_Filtrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel_Ordens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBox_FiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_FiltroActionPerformed

    }//GEN-LAST:event_ComboBox_FiltroActionPerformed

    private void Button_FiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_FiltrarActionPerformed
        readFiltro();
    }//GEN-LAST:event_Button_FiltrarActionPerformed

    private void Button_FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_FinalizarActionPerformed
        readId();
    }//GEN-LAST:event_Button_FinalizarActionPerformed

    private void readFiltro() {
        String op = ComboBox_Filtro.getSelectedItem().toString();
        if (op.equals("Selecionar")) {
            JOptionPane.showMessageDialog(null, "Selecione uma opção!",
                    null, JOptionPane.ERROR_MESSAGE);
        } else if (op.equals("Ordens Completas")) {
            mostraOrdens("Completas");
        } else if (op.equals("Ordens Incompletas")) {
            mostraOrdens("Incompletas");
        }
    }

    private DefaultTableModel preparaModel() {
        DefaultTableModel modelo = (DefaultTableModel) Table_Ordens.getModel();
        return modelo;
    }

    private void mostraOrdens(String op) {
        ArrayList<OrdemServico> lista = new ArrayList<OrdemServico>();
        lista.clear();
        try {
            int estado = 1;
            if (op.equals("Completas")) {
                estado = 1;
            } else if (op.equals("Incompletas")) {
                estado = 0;
            }
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("ordem_servico");
            System.out.println("Consultando...");
            lista = (ArrayList) objetoRemoto.findByList("estado", estado);

            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não há ordens!",
                        null, JOptionPane.ERROR_MESSAGE);
            } else {
                preencheLista(lista);
            }

            if (estado == 0 && !lista.isEmpty()) {
                Panel_Ordens.setVisible(true);
            }

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void preencheLista(ArrayList<OrdemServico> lista) {
        DefaultTableModel modelo = preparaModel();
        Object rowData[] = new Object[4];

        for (int i = 0; i < lista.size(); i++) {
            rowData[0] = lista.get(i).getIdOrdemServico();
            rowData[1] = lista.get(i).getDataExp();
            rowData[2] = lista.get(i).getVendaId();
            rowData[3] = lista.get(i).getIdFuncionario();

            modelo.addRow(rowData);
        }
    }

    private void readId() {
        try {
            OrdemServico ordem = new OrdemServico();
            String aux = FormattedTextField_IDOrdem.getText().toString();
            int idOrdem;
            if (aux.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo vazio!",
                        null, JOptionPane.ERROR_MESSAGE);
            } else {
                idOrdem = Integer.parseInt(aux);
                //criar objeto da interface, usa o lookpu para pegar a chave
                //conexa_server possui o ip e o registry para definir a conexao com o server
                IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("ordem_servico");
                System.out.println("Consultando...");
                ordem = (OrdemServico) objetoRemoto.findBy("idOrdemServico", idOrdem);
                Date dataExp = ordem.getDataExp();
                int idVenda = ordem.getVendaId();
                int idFuncionario = ordem.getIdFuncionario();

                if (ordem.getIdOrdemServico() == 0) {
                    JOptionPane.showMessageDialog(null, "ID não encontrado!",
                            null, JOptionPane.ERROR_MESSAGE);
                } else {
                    updateOrdem(ordem.getIdOrdemServico(), dataExp, idVenda, idFuncionario);
                }
            }

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateOrdem(int idOrdem, Date dataExp, int idVenda, int idFuncionario) {
        try {
            OrdemServico ordem = new OrdemServico();
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("ordem_servico");
            ordem.setDataExp(dataExp);
            ordem.setEstado(1);
            ordem.setIdFuncionario(idFuncionario);
            ordem.setIdOrdemServico(idOrdem);
            ordem.setVendaId(idVenda);
            
            System.out.println("Consultando...");
            
            JOptionPane.showMessageDialog(null, objetoRemoto.update(ordem),
                            null, JOptionPane.ERROR_MESSAGE);
            
            Panel_Ordens.setVisible(false);
            
            

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }

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
            java.util.logging.Logger.getLogger(View_OrdemDeServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_OrdemDeServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_OrdemDeServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_OrdemDeServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_OrdemDeServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Filtrar;
    private javax.swing.JButton Button_Finalizar;
    private javax.swing.JComboBox ComboBox_Filtro;
    private javax.swing.JFormattedTextField FormattedTextField_IDOrdem;
    private javax.swing.JPanel Panel_Ordens;
    private javax.swing.JTable Table_Ordens;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
