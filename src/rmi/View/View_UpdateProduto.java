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
import rmi.Model.Produto;
import rmi.Util.conexao_server;

/**
 *
 * @author bruno
 */
public class View_UpdateProduto extends javax.swing.JInternalFrame {

    /**
     * Creates new form View_UpdateProduto
     */
    
    private int IDProduto;
    
    public View_UpdateProduto() {
        initComponents();
        //Define que os campos para edição das informações comecem invisiveis
        Panel_Produto.setVisible(false);
    }
    
    private void valoresDosCampos(){
        String nome = TextField_NomeProduto.getText().toString();
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null, "É necessário preencher o campo!", 
                        null,JOptionPane.ERROR_MESSAGE);
        }else{
            pesquisaProduto(nome);
        }
    }
    
    private void pesquisaProduto(String nomeProduto){
         try{
             Produto produto = new Produto();
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto =(IControllerBase)conexao_server.conexao().lookup("produto");
            System.out.println("Consultando...");
            produto = (Produto) objetoRemoto.findBy("nome", nomeProduto);
            //Passa o id do produto para o atributo
            IDProduto = produto.getIdProduto();
            if(produto.getIdProduto() == 0){
                JOptionPane.showMessageDialog(null, "Produto não encontrado!", 
                        null,JOptionPane.ERROR_MESSAGE);
            }else{
                //se o id for encontrado, os campos para edição são ativados
                Panel_Produto.setVisible(true);
                preencheCampos(produto.getNome(), produto.getPreco(), produto.getQuantidade());
            }
                                   
        }catch(RemoteException e){
            System.out.println(e.getMessage());
        }catch(NotBoundException e){
            System.out.println(e.getMessage());
        } 
    }
    
    private void preencheCampos(String nome, float preco, int quantidade){
        String aux = Float.toString(preco);
        String aux2 = Integer.toString(quantidade);
        TextField_Nome.setText(nome);
        FormattedTextField_Preco.setText(aux);
        FormattedTextField_Quantidade.setText(aux2);
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
            String aux2 = FormattedTextField_Quantidade.getText().toString();
            float preco;
            int quantidade;
            if(!nome.equals("") && !aux.equals("") && !aux2.equals("")){
                preco = Float.parseFloat(aux);
                quantidade = Integer.parseInt(aux2);
                if(preco < 0 || quantidade < 0){
                    JOptionPane.showMessageDialog(null, "Valores de preço/quantidade inválidos!", 
                        null,JOptionPane.ERROR_MESSAGE);
                }else{
                    produto.setIdProduto(IDProduto);
                produto.setNome(nome);
                produto.setPreco(preco);
                produto.setQuantidade(quantidade);
                JOptionPane.showMessageDialog(null, objetoRemoto.update(produto), 
                        null,JOptionPane.INFORMATION_MESSAGE);
                }
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextField_NomeProduto = new javax.swing.JTextField();
        Panel_Produto = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        FormattedTextField_Preco = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        TextField_Nome = new javax.swing.JTextField();
        Button_Editar = new javax.swing.JButton();
        Button_Excluir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        FormattedTextField_Quantidade = new javax.swing.JFormattedTextField();
        Button_Pesquisar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Update Produto");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Update Produto");

        jLabel2.setText("Nome Produto:");

        Panel_Produto.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jLabel3.setText("Preço:");

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

        jLabel5.setText("Quantidade:");

        FormattedTextField_Quantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        javax.swing.GroupLayout Panel_ProdutoLayout = new javax.swing.GroupLayout(Panel_Produto);
        Panel_Produto.setLayout(Panel_ProdutoLayout);
        Panel_ProdutoLayout.setHorizontalGroup(
            Panel_ProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(TextField_Nome)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(FormattedTextField_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(Panel_ProdutoLayout.createSequentialGroup()
                .addGroup(Panel_ProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ProdutoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(FormattedTextField_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_ProdutoLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(Button_Editar)
                        .addGap(73, 73, 73)
                        .addComponent(Button_Excluir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jLabel5)
                    .addComponent(FormattedTextField_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_ProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Editar)
                    .addComponent(Button_Excluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Button_Pesquisar.setText("Pesquisar");
        Button_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(204, 204, 204))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_Produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(TextField_NomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Button_Pesquisar)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextField_NomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Pesquisar))
                .addGap(18, 18, 18)
                .addComponent(Panel_Produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EditarActionPerformed
        editaProduto();
    }//GEN-LAST:event_Button_EditarActionPerformed

    private void Button_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ExcluirActionPerformed
        excluiProduto();
    }//GEN-LAST:event_Button_ExcluirActionPerformed

    private void Button_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_PesquisarActionPerformed
        valoresDosCampos();
    }//GEN-LAST:event_Button_PesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Editar;
    private javax.swing.JButton Button_Excluir;
    private javax.swing.JButton Button_Pesquisar;
    private javax.swing.JFormattedTextField FormattedTextField_Preco;
    private javax.swing.JFormattedTextField FormattedTextField_Quantidade;
    private javax.swing.JPanel Panel_Produto;
    private javax.swing.JTextField TextField_Nome;
    private javax.swing.JTextField TextField_NomeProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
