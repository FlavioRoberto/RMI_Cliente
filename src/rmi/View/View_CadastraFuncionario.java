/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.View;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import rmi.Interface.IControllerBase;
import rmi.Model.Funcionario;

/**
 *
 * @author Bruno
 */
public class View_CadastraFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form View_CadastraFuncionario
     */
    public View_CadastraFuncionario() {
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

        Label_Cadastro_de_Cliente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TextField_Nome = new javax.swing.JTextField();
        FormattedTextField_RG = new javax.swing.JFormattedTextField();
        FormattedTextField_CPF = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Btn_Cadastrar = new javax.swing.JButton();
        FormattedTextField_Telefone = new javax.swing.JFormattedTextField();
        ComboBox_Cargo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Label_Cadastro_de_Cliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Label_Cadastro_de_Cliente.setText("Cadastro de Funcionário");

        jLabel8.setText("Nome:");

        try {
            FormattedTextField_RG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        FormattedTextField_RG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormattedTextField_RGActionPerformed(evt);
            }
        });

        try {
            FormattedTextField_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("CPF:");

        jLabel10.setText("RG:");

        jLabel11.setText("Telefone:");

        jLabel12.setText("Especificação:");

        Btn_Cadastrar.setText("Cadastrar");
        Btn_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CadastrarActionPerformed(evt);
            }
        });

        try {
            FormattedTextField_Telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        ComboBox_Cargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cargo", "Gerente", "Vendedor", "Produção" }));
        ComboBox_Cargo.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel5))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 42, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(FormattedTextField_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(FormattedTextField_RG, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(TextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(FormattedTextField_Telefone)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(ComboBox_Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(60, 60, 60))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(142, 142, 142)
                                    .addComponent(Btn_Cadastrar))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(106, 106, 106)
                            .addComponent(jLabel3)
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(Label_Cadastro_de_Cliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_Cadastro_de_Cliente)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FormattedTextField_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FormattedTextField_RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(FormattedTextField_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox_Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(42, 42, 42)
                .addComponent(Btn_Cadastrar)
                .addGap(113, 113, 113)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FormattedTextField_RGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormattedTextField_RGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FormattedTextField_RGActionPerformed

    private void Btn_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CadastrarActionPerformed
        valoresDosCampos();
    }//GEN-LAST:event_Btn_CadastrarActionPerformed

    //Metodo para recuperar os valores digitados nos campos e verificar se algum campo ficou vazio
    private void valoresDosCampos(){
        String nome = TextField_Nome.getText().toString();
        String cpf = FormattedTextField_CPF.getText().toString();
        String rg = FormattedTextField_RG.getText().toString();
        String telefone = FormattedTextField_Telefone.getText().toString();
        String cargo = ComboBox_Cargo.getSelectedItem().toString();
        String especialidade = null;
        if(cargo.equals("Cargo")){
            JOptionPane.showMessageDialog(null, "É necessário escolher um cargo!", null,JOptionPane.ERROR_MESSAGE);
        }else if(cargo.equals("Gerente")){
            especialidade = "Gerente";
        }else if(cargo.equals("Vendedor")){
            especialidade = "Vendedor";
        }else if(cargo.equals("Produção")){
            especialidade = "Produção";
        }
        
        if(!nome.equals(null) && !cpf.equals(null) && !rg.equals(null) && 
                !telefone.equals(null) && !especialidade.equals(null)){
            cadastraFuncionario(nome, cpf, rg, telefone, especialidade);
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", null,JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cadastraFuncionario(String nome, String cpf, String rg, String telefone, String especialidade){
        try{
            //cria conexao com a porta de comunicacao com o servidor
            Registry conexao = LocateRegistry.getRegistry("127.0.0.1",1500);
            //criar objeto da interface, usa o lookpu para pegar a chave
            IControllerBase objetoRemoto =(IControllerBase)conexao.lookup("funcionario");
            //chama metodo do servidor
            System.out.println("Cadastrando...");
            
            Funcionario funcionario = new Funcionario();
            
            funcionario.setCpf(cpf);
            funcionario.setEspecialidade(especialidade);
            funcionario.setNome(nome);
            funcionario.setRg(rg);
            funcionario.setSalario(2000);
            funcionario.setTelefone(telefone);
            JOptionPane.showMessageDialog(null, objetoRemoto.create(funcionario), null,JOptionPane.INFORMATION_MESSAGE);
                        
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
            java.util.logging.Logger.getLogger(View_CadastraFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_CadastraFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_CadastraFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_CadastraFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_CadastraFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Cadastrar;
    private javax.swing.JComboBox ComboBox_Cargo;
    private javax.swing.JFormattedTextField FormattedTextField_CPF;
    private javax.swing.JFormattedTextField FormattedTextField_RG;
    private javax.swing.JFormattedTextField FormattedTextField_Telefone;
    private javax.swing.JLabel Label_Cadastro_de_Cliente;
    private javax.swing.JTextField TextField_Nome;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}