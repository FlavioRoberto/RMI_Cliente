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
import rmi.Model.Cliente;
import rmi.Model.Pessoa;
import rmi.Util.conexao_server;

/**
 *
 * @author bruno
 */
public class View_UpdateCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form View_UpdateCliente
     */
    private int IDPessoa;
    private int IDCliente;

    public View_UpdateCliente() {
        initComponents();
        Panel_EditaCliente.setVisible(false);
    }

    private void valoresDosCampos() {
        String cpf = FormattedTextField_Cpf.getText().toString();
        if (!cpf.equals(null)) {
            pesquisaCpf(cpf);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário informar o CPF!", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void pesquisaCpf(String cpf) {
        try {
            Pessoa pessoa = new Pessoa();
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("pessoa");
            System.out.println("Consultando...");
            pessoa = (Pessoa) objetoRemoto.findBy("cpf", cpf);
            if (pessoa.getIdPessoa() == 0) {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!",
                        null, JOptionPane.ERROR_MESSAGE);
            } else {
                retornaCliente(pessoa.getIdPessoa());
            }

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void retornaCliente(int idPessoa) {
        try {
            Cliente cliente = new Cliente();
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("cliente");
            System.out.println("Consultando Cliente...");
            cliente = (Cliente) objetoRemoto.findBy("idPessoa", idPessoa);
            //verifica se o id pertence a um funcionario
            if (cliente.getIdCliente() == 0) {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!",
                        null, JOptionPane.ERROR_MESSAGE);
            } else {
                //habilita o panel para ediçao dos dados
                Panel_EditaCliente.setVisible(true);
                //recupera o idPessoa
                IDPessoa = cliente.getIdPessoa();
                //recupera o ifFuncionario
                IDCliente = cliente.getIdCliente();
                String nome = cliente.getNome();
                String cpf = cliente.getCpf();
                String rg = cliente.getRg();
                String telefone = cliente.getTelefone();
                String celular = cliente.getCelular();
                preecheCampos(nome, cpf, rg, telefone, celular);
            }
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void preecheCampos(String nome, String cpf, String rg, String telefone, String celular) {
        //seta os valores para os campos na Tela
        TextField_Nome.setText(nome);
        FormattedTextField_CPF.setText(cpf);
        FormattedTextField_RG.setText(rg);
        FormattedTextField_Telefone.setText(telefone);
        FormattedTextField_Celular.setText(celular);
    }

    private void editaPessoa() {
        try {
            Pessoa pessoa = new Pessoa();
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("pessoa");
            System.out.println("Atualizando Pessoa...");
            String nome = TextField_Nome.getText().toString();
            String cpf = FormattedTextField_Cpf.getText().toString();
            String rg = FormattedTextField_RG.getText().toString();
            String telefone = FormattedTextField_Telefone.getText().toString();
            String celular = FormattedTextField_CPF.getText().toString();
            if (!nome.equals(null) || !cpf.equals(null) || !rg.equals(null) || !telefone.equals(null)) {
                if (cpf.length() < 11) {
                    JOptionPane.showMessageDialog(null, "CPF incorreto!",
                            null, JOptionPane.ERROR_MESSAGE);
                } else if (rg.length() < 10) {
                    JOptionPane.showMessageDialog(null, "RG incorreto!",
                            null, JOptionPane.ERROR_MESSAGE);
                } else if (telefone.length() < 10) {
                    JOptionPane.showMessageDialog(null, "Telefone incorreto!",
                            null, JOptionPane.ERROR_MESSAGE);
                } else if (celular.length() < 11) {
                    JOptionPane.showMessageDialog(null, "Celular incorreto!",
                            null, JOptionPane.ERROR_MESSAGE);
                } else {
                    pessoa.setCpf(cpf);
                    pessoa.setNome(nome);
                    pessoa.setRg(rg);
                    pessoa.setTelefone(telefone);
                    pessoa.setCelular(celular);
                    pessoa.setIdPessoa(IDPessoa);
                    JOptionPane.showMessageDialog(null, objetoRemoto.update(pessoa),
                            null, JOptionPane.INFORMATION_MESSAGE);
                    editaCliente();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!",
                        null, JOptionPane.ERROR_MESSAGE);
            }
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void editaCliente() {
        try {
            Cliente cliente = new Cliente();
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("cliente");
            System.out.println("Atualizando Cliente...");
            cliente.setTipo("Pessoa Física");
            cliente.setIdPessoa(IDPessoa);
            cliente.setIdCliente(IDCliente);
            JOptionPane.showMessageDialog(null, objetoRemoto.update(cliente),
                    null, JOptionPane.INFORMATION_MESSAGE);

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deletaFuncionario() {
        try {
            Cliente cliente = new Cliente();
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("cliente");
            System.out.println("Apagando Cliente...");
            cliente.setIdCliente(IDCliente);
            JOptionPane.showMessageDialog(null, objetoRemoto.delete(IDPessoa),
                    null, JOptionPane.INFORMATION_MESSAGE);
            Panel_EditaCliente.setVisible(false);
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
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
        Button_PesquisarCliente = new javax.swing.JButton();
        Panel_EditaCliente = new javax.swing.JPanel();
        FormattedTextField_RG = new javax.swing.JFormattedTextField();
        FormattedTextField_CPF = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        FormattedTextField_Telefone = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        TextField_Nome = new javax.swing.JTextField();
        Button_Editar = new javax.swing.JButton();
        Button_Excluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        FormattedTextField_Celular = new javax.swing.JFormattedTextField();

        setClosable(true);
        setTitle("Update Cliente");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Update Cliente");

        jLabel2.setText("CPF:");

        try {
            FormattedTextField_Cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        Button_PesquisarCliente.setText("Pesquisar");
        Button_PesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PesquisarClienteActionPerformed(evt);
            }
        });

        Panel_EditaCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        try {
            FormattedTextField_RG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
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

        try {
            FormattedTextField_Telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setText("Nome:");

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

        jLabel3.setText("Celular:");

        try {
            FormattedTextField_Celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout Panel_EditaClienteLayout = new javax.swing.GroupLayout(Panel_EditaCliente);
        Panel_EditaCliente.setLayout(Panel_EditaClienteLayout);
        Panel_EditaClienteLayout.setHorizontalGroup(
            Panel_EditaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_EditaClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_EditaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Panel_EditaClienteLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextField_Nome))
                    .addGroup(Panel_EditaClienteLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(FormattedTextField_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(FormattedTextField_Celular))
                    .addGroup(Panel_EditaClienteLayout.createSequentialGroup()
                        .addGroup(Panel_EditaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_EditaClienteLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(FormattedTextField_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_EditaClienteLayout.createSequentialGroup()
                                .addComponent(Button_Editar)
                                .addGap(53, 53, 53)))
                        .addGroup(Panel_EditaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FormattedTextField_RG, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_EditaClienteLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(Button_Excluir)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        Panel_EditaClienteLayout.setVerticalGroup(
            Panel_EditaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_EditaClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_EditaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_EditaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(FormattedTextField_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(FormattedTextField_RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_EditaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(FormattedTextField_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(FormattedTextField_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_EditaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Editar)
                    .addComponent(Button_Excluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(FormattedTextField_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button_PesquisarCliente)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Panel_EditaCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(FormattedTextField_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_PesquisarCliente))
                .addGap(18, 18, 18)
                .addComponent(Panel_EditaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_PesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_PesquisarClienteActionPerformed
        valoresDosCampos();
    }//GEN-LAST:event_Button_PesquisarClienteActionPerformed

    private void FormattedTextField_RGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormattedTextField_RGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FormattedTextField_RGActionPerformed

    private void Button_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EditarActionPerformed
        editaPessoa();
    }//GEN-LAST:event_Button_EditarActionPerformed

    private void Button_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ExcluirActionPerformed
        deletaFuncionario();
    }//GEN-LAST:event_Button_ExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Editar;
    private javax.swing.JButton Button_Excluir;
    private javax.swing.JButton Button_PesquisarCliente;
    private javax.swing.JFormattedTextField FormattedTextField_CPF;
    private javax.swing.JFormattedTextField FormattedTextField_Celular;
    private javax.swing.JFormattedTextField FormattedTextField_Cpf;
    private javax.swing.JFormattedTextField FormattedTextField_RG;
    private javax.swing.JFormattedTextField FormattedTextField_Telefone;
    private javax.swing.JPanel Panel_EditaCliente;
    private javax.swing.JTextField TextField_Nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
