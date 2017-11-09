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
import rmi.Model.Funcionario;
import rmi.Model.Pessoa;
import rmi.Util.conexao_server;

/**
 *
 * @author bruno
 */
public class View_UpdateFuncionario extends javax.swing.JInternalFrame {

    private int IDPessoa, IDFuncionario;
    
    /**
     * Creates new form View_UpdateFuncionario
     */
    public View_UpdateFuncionario() {
        initComponents();
        Panel_DadosFuncionario.setVisible(false);
    }
    
    private void valoresDosCampos(){
        String cpf = FormattedTextField_Cpf.getText().toString();
        if(!cpf.equals(null)){
            pesquisaCpf(cpf);
        }else{
            JOptionPane.showMessageDialog(null, "É necessário informar o CPF!", null,JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void pesquisaCpf(String cpf){
        try{
            Pessoa pessoa = new Pessoa();
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto =(IControllerBase)conexao_server.conexao().lookup("pessoa");
            System.out.println("Consultando...");
            pessoa = (Pessoa) objetoRemoto.findBy("cpf", cpf);
            if(pessoa.getIdPessoa() == 0){
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado!", 
                        null,JOptionPane.ERROR_MESSAGE);
            }else{
                retornaFuncionario(pessoa.getIdPessoa());
            }
                                   
        }catch(RemoteException e){
            System.out.println(e.getMessage());
        }catch(NotBoundException e){
            System.out.println(e.getMessage());
        } 
    }
    
    private void retornaFuncionario(int idPessoa){
        try{
          Funcionario funcionario = new Funcionario();
          //criar objeto da interface, usa o lookpu para pegar a chave
          //conexa_server possui o ip e o registry para definir a conexao com o server
          IControllerBase objetoRemoto =(IControllerBase)conexao_server.conexao().lookup("funcionario"); 
          System.out.println("Consultando Funcionario...");
          funcionario = (Funcionario) objetoRemoto.findBy("idPessoa", idPessoa);
          //verifica se o id pertence a um funcionario
          if(funcionario.getIdFuncionario() == 0){
              JOptionPane.showMessageDialog(null, "Funcionário não encontrado!", 
                        null,JOptionPane.ERROR_MESSAGE);
          }else{
              //habilita o panel para ediçao dos dados
              Panel_DadosFuncionario.setVisible(true);
              //recupera o idPessoa
              IDPessoa = funcionario.getIdPessoa();
              //recupera o ifFuncionario
              IDFuncionario = funcionario.getIdFuncionario();
              String nome = funcionario.getNome();
              String cpf = funcionario.getCpf();
              String rg = funcionario.getRg();
              String telefone = funcionario.getTelefone();
              String celular = funcionario.getCelular();
              String especificacao = funcionario.getEspecialidade();
              preecheCampos(nome, cpf, rg, telefone, celular, especificacao);
          }
        }catch(RemoteException e){
            System.out.println(e.getMessage());
        }catch(NotBoundException e){
            System.out.println(e.getMessage());
        } 
    }
    
    private void preecheCampos(String nome, String cpf, String rg, String telefone, String celular, String espeficicacao){
        //seta os valores para os campos na Tela
        TextField_Nome.setText(nome);
        FormattedTextField_CpfFuncionario.setText(cpf);
        FormattedTextField_RG.setText(rg);
        FormattedTextField_Telefone.setText(telefone);
        FormattedTextField_Celular.setText(celular);
        if(espeficicacao.equals("Gerente")){
            ComboBox_Especialidade.setSelectedItem("Gerente");
        }else if(espeficicacao.equals("Vendedor")){
            ComboBox_Especialidade.setSelectedItem("Vendedor");
        }else{
            ComboBox_Especialidade.setSelectedItem("Produção");
        }
    }
    
    private void editaFuncionario(){
        try{
          Funcionario funcionario = new Funcionario();
          //criar objeto da interface, usa o lookpu para pegar a chave
          //conexa_server possui o ip e o registry para definir a conexao com o server
          IControllerBase objetoRemoto =(IControllerBase)conexao_server.conexao().lookup("funcionario"); 
          System.out.println("Atualizando Funcionario...");
          String nome = TextField_Nome.getText().toString();
          String cpf = FormattedTextField_Cpf.getText().toString();
          String rg = FormattedTextField_RG.getText().toString();
          String telefone = FormattedTextField_Telefone.getText().toString();
          String celular = FormattedTextField_Celular.getText().toString();
          String especialidade = ComboBox_Especialidade.getSelectedItem().toString();
          if(!nome.equals(null) || !cpf.equals(null) || !rg.equals(null) || !telefone.equals(null) || !celular.equals(null)){
              if(cpf.length() < 11){
                 JOptionPane.showMessageDialog(null, "CPF incorreto!", 
                        null,JOptionPane.ERROR_MESSAGE); 
              }else if(rg.length() < 10){
                  JOptionPane.showMessageDialog(null, "RG incorreto!", 
                        null,JOptionPane.ERROR_MESSAGE); 
              }else if(telefone.length() < 10){
                  JOptionPane.showMessageDialog(null, "Telefone incorreto!", 
                        null,JOptionPane.ERROR_MESSAGE); 
              }else if(celular.length() < 11){
                  JOptionPane.showMessageDialog(null, "Celular incorreto!", 
                        null,JOptionPane.ERROR_MESSAGE); 
              }else{
                  funcionario.setCpf(cpf);
              funcionario.setEspecialidade(especialidade);
              funcionario.setNome(nome);
              funcionario.setRg(rg);
              funcionario.setSalario(2000);
              funcionario.setTelefone(telefone);
              funcionario.setCelular(celular);
              funcionario.setIdPessoa(IDPessoa);
              funcionario.setIdFuncionario(IDFuncionario);
              JOptionPane.showMessageDialog(null, objetoRemoto.update(funcionario), 
                        null,JOptionPane.INFORMATION_MESSAGE);
              }     
          }else{
              JOptionPane.showMessageDialog(null, "Preencha todos os campos!", 
                        null,JOptionPane.ERROR_MESSAGE);
          }
        }catch(RemoteException e){
            System.out.println(e.getMessage());
        }catch(NotBoundException e){
            System.out.println(e.getMessage());
        } 
    }
    
    private void deletaFuncionario(){
        try{
          Funcionario funcionario = new Funcionario();
          //criar objeto da interface, usa o lookpu para pegar a chave
          //conexa_server possui o ip e o registry para definir a conexao com o server
          IControllerBase objetoRemoto =(IControllerBase)conexao_server.conexao().lookup("funcionario"); 
          System.out.println("Apagando Funcionario...");
          funcionario.setIdFuncionario(IDFuncionario);
          JOptionPane.showMessageDialog(null, objetoRemoto.delete(IDPessoa), 
                        null,JOptionPane.INFORMATION_MESSAGE);
          Panel_DadosFuncionario.setVisible(false);
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
        FormattedTextField_Cpf = new javax.swing.JFormattedTextField();
        Button_Pesquisar = new javax.swing.JButton();
        Panel_DadosFuncionario = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TextField_Nome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        FormattedTextField_RG = new javax.swing.JFormattedTextField();
        FormattedTextField_Telefone = new javax.swing.JFormattedTextField();
        ComboBox_Especialidade = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        Button_Editar = new javax.swing.JButton();
        Button_Excluir = new javax.swing.JButton();
        FormattedTextField_CpfFuncionario = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        FormattedTextField_Celular = new javax.swing.JFormattedTextField();

        setClosable(true);
        setTitle("Update Funcionário");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Update Funcionário");

        jLabel2.setText("CPF:");

        try {
            FormattedTextField_Cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        Button_Pesquisar.setText("Pesquisar");
        Button_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PesquisarActionPerformed(evt);
            }
        });

        Panel_DadosFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jLabel3.setText("Nome:");

        jLabel4.setText("CPF:");

        jLabel5.setText("Telefone:");

        jLabel6.setText("RG:");

        try {
            FormattedTextField_RG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            FormattedTextField_Telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        ComboBox_Especialidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gerente", "Vendedor", "Produção" }));

        jLabel7.setText("Especificação:");

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

        try {
            FormattedTextField_CpfFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setText("Celular:");

        try {
            FormattedTextField_Celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout Panel_DadosFuncionarioLayout = new javax.swing.GroupLayout(Panel_DadosFuncionario);
        Panel_DadosFuncionario.setLayout(Panel_DadosFuncionarioLayout);
        Panel_DadosFuncionarioLayout.setHorizontalGroup(
            Panel_DadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DadosFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_DadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Panel_DadosFuncionarioLayout.createSequentialGroup()
                        .addGroup(Panel_DadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Panel_DadosFuncionarioLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(FormattedTextField_CpfFuncionario))
                            .addGroup(Panel_DadosFuncionarioLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(FormattedTextField_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_DadosFuncionarioLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(Button_Editar)))
                        .addGroup(Panel_DadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Panel_DadosFuncionarioLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FormattedTextField_RG))
                            .addGroup(Panel_DadosFuncionarioLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(FormattedTextField_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_DadosFuncionarioLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(Button_Excluir))))
                    .addGroup(Panel_DadosFuncionarioLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(TextField_Nome))
                    .addGroup(Panel_DadosFuncionarioLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBox_Especialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_DadosFuncionarioLayout.setVerticalGroup(
            Panel_DadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DadosFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_DadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_DadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(FormattedTextField_RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(FormattedTextField_CpfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_DadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(FormattedTextField_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(FormattedTextField_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_DadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ComboBox_Especialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(Panel_DadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Editar)
                    .addComponent(Button_Excluir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(166, 166, 166))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(FormattedTextField_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Pesquisar)
                        .addGap(116, 116, 116))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(Panel_DadosFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(38, 38, 38)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(FormattedTextField_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Pesquisar))
                .addContainerGap(307, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(Panel_DadosFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(77, 77, 77)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_PesquisarActionPerformed
        valoresDosCampos();
    }//GEN-LAST:event_Button_PesquisarActionPerformed

    private void Button_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EditarActionPerformed
        editaFuncionario();
    }//GEN-LAST:event_Button_EditarActionPerformed

    private void Button_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ExcluirActionPerformed
        deletaFuncionario();
    }//GEN-LAST:event_Button_ExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Editar;
    private javax.swing.JButton Button_Excluir;
    private javax.swing.JButton Button_Pesquisar;
    private javax.swing.JComboBox ComboBox_Especialidade;
    private javax.swing.JFormattedTextField FormattedTextField_Celular;
    private javax.swing.JFormattedTextField FormattedTextField_Cpf;
    private javax.swing.JFormattedTextField FormattedTextField_CpfFuncionario;
    private javax.swing.JFormattedTextField FormattedTextField_RG;
    private javax.swing.JFormattedTextField FormattedTextField_Telefone;
    private javax.swing.JPanel Panel_DadosFuncionario;
    private javax.swing.JTextField TextField_Nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
