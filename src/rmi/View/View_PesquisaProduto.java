/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.View;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import rmi.Interface.IControllerBase;
import rmi.Model.Pessoa;
import rmi.Model.Produto;
import rmi.Util.conexao_server;

/**
 *
 * @author Bruno
 */
public class View_PesquisaProduto extends javax.swing.JFrame {

    /**
     * Creates new form View_PesquisaProduto
     */
    
    private int IDProduto;
    
    public View_PesquisaProduto() {
        initComponents();
        //Define que os campos para edição das informações comecem invisiveis
        Panel_Produto.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FormattedTextField_IDProduto = new javax.swing.JFormattedTextField();
        Button_Pesquisar = new javax.swing.JButton();
        Panel_Produto = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        FormattedTextField_Preco = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        TextField_Nome = new javax.swing.JTextField();
        Button_Editar = new javax.swing.JButton();
        Button_Excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Edita Produto");

        jLabel2.setText("ID Produto:");

        Button_Pesquisar.setText("Pesquisar");
        Button_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PesquisarActionPerformed(evt);
            }
        });

        jLabel3.setText("Preco:");

        FormattedTextField_Preco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel4.setText("Nome:");

        Button_Editar.setText("Editar");
        Button_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EditarActionPerformed(evt);
            }
        });

        Button_Excluir.setText("Excluir");
        Button_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_ProdutoLayout = new javax.swing.GroupLayout(Panel_Produto);
        Panel_Produto.setLayout(Panel_ProdutoLayout);
        Panel_ProdutoLayout.setHorizontalGroup(
            Panel_ProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ProdutoLayout.createSequentialGroup()
                .addGroup(Panel_ProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ProdutoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(TextField_Nome)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ProdutoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_Editar)
                        .addGap(51, 51, 51)))
                .addGroup(Panel_ProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button_Excluir)
                    .addGroup(Panel_ProdutoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(FormattedTextField_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        Panel_ProdutoLayout.setVerticalGroup(
            Panel_ProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_ProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(FormattedTextField_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_ProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Editar)
                    .addComponent(Button_Excluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(FormattedTextField_IDProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Button_Pesquisar)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_Produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(FormattedTextField_IDProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Pesquisar))
                .addGap(18, 18, 18)
                .addComponent(Panel_Produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Button_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_PesquisarActionPerformed
        valoresDosCampos();
    }//GEN-LAST:event_Button_PesquisarActionPerformed

    private void Button_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EditarActionPerformed
        editaProduto();
    }//GEN-LAST:event_Button_EditarActionPerformed

    private void Button_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ExcluirActionPerformed
        excluiProduto();
    }//GEN-LAST:event_Button_ExcluirActionPerformed

    private void valoresDosCampos(){
        String aux = FormattedTextField_IDProduto.getText().toString();
        int idProduto;
        if(aux.equals(null)){
            JOptionPane.showMessageDialog(null, "É necessário preencher o campo!", 
                        null,JOptionPane.ERROR_MESSAGE);
        }else{
            idProduto = Integer.parseInt(aux);
            pesquisaProduto(idProduto);
        }
    }
    
    private void pesquisaProduto(int idProduto){
         try{
             Produto produto = new Produto();
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto =(IControllerBase)conexao_server.conexao().lookup("produto");
            System.out.println("Consultando...");
            produto = (Produto) objetoRemoto.findBy("idProduto", idProduto);
            //Passa o id do produto para o atributo
            IDProduto = produto.getIdProduto();
            if(produto.getIdProduto() == 0){
                JOptionPane.showMessageDialog(null, "Produto não encontrado!", 
                        null,JOptionPane.ERROR_MESSAGE);
            }else{
                //se o id for encontrado, os campos para edição são ativados
                Panel_Produto.setVisible(true);
                preencheCampos(produto.getNome(), produto.getPreco());
            }
                                   
        }catch(RemoteException e){
            System.out.println(e.getMessage());
        }catch(NotBoundException e){
            System.out.println(e.getMessage());
        } 
    }
    
    private void preencheCampos(String nome, float preco){
        String aux = Float.toString(preco);
        TextField_Nome.setText(nome);
        FormattedTextField_Preco.setText(aux);
    }
    
    private void editaProduto(){
        try{
             Produto produto = new Produto();
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto =(IControllerBase)conexao_server.conexao().lookup("produto");
            System.out.println("Editando...");
            String nome = TextField_Nome.getText().toString();
            String aux = FormattedTextField_Preco.getText().toString();
            float preco;
            if(!nome.equals(null) && !aux.equals(null)){
                preco = Float.parseFloat(aux);
                produto.setIdProduto(IDProduto);
                produto.setNome(nome);
                produto.setPreco(preco);
                JOptionPane.showMessageDialog(null, objetoRemoto.update(produto), 
                        null,JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Há campos vazios!", 
                        null,JOptionPane.ERROR_MESSAGE);
            }                    
        }catch(RemoteException e){
            System.out.println(e.getMessage());
        }catch(NotBoundException e){
            System.out.println(e.getMessage());
        } 
    }
    
    private void excluiProduto(){
        try{
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto =(IControllerBase)conexao_server.conexao().lookup("produto");
            System.out.println("Excluindo...");
            JOptionPane.showMessageDialog(null, objetoRemoto.delete(IDProduto), 
                        null,JOptionPane.INFORMATION_MESSAGE);
            Panel_Produto.setVisible(false);
        }catch(RemoteException e){
            System.out.println(e.getMessage());
        }catch(NotBoundException e){
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
            java.util.logging.Logger.getLogger(View_PesquisaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_PesquisaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_PesquisaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_PesquisaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_PesquisaProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Editar;
    private javax.swing.JButton Button_Excluir;
    private javax.swing.JButton Button_Pesquisar;
    private javax.swing.JFormattedTextField FormattedTextField_IDProduto;
    private javax.swing.JFormattedTextField FormattedTextField_Preco;
    private javax.swing.JPanel Panel_Produto;
    private javax.swing.JTextField TextField_Nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}