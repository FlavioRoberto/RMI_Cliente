/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.View;

import Application.formataData;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rmi.Interface.IControllerBase;
import rmi.Model.Carrinho;
import rmi.Model.Cliente;
import rmi.Model.Funcionario;
import rmi.Model.OrdemServico;
import rmi.Model.Pessoa;
import rmi.Model.Produto;
import rmi.Model.Venda;
import rmi.Util.conexao_server;

/**
 *
 * @author bruno
 */
public class View_RealizaVenda extends javax.swing.JInternalFrame {

    /**
     * Creates new form View_RealizaVenda
     */
    private Pessoa pessoa = new Pessoa();
    private Venda venda = new Venda();
    private Cliente cliente = new Cliente();
    private ArrayList<Carrinho> produtos = new ArrayList<Carrinho>();
    private int IDVENDA;

    public View_RealizaVenda() {
        initComponents();
        Panel.setVisible(false);
        Panel_Carrinho.setVisible(false);
    }

    //
    private void valoresDosCampos() {
        String cpf = FormattedTextField_CPFCliente.getText().toString();
        if (!cpf.equals(null)) {
            pesquisaCpf(cpf);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário informar o CPF!", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    //
    private void pesquisaCpf(String cpf) {
        try {
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("pessoa");
            System.out.println("Consultando...");
            pessoa = (Pessoa) objetoRemoto.findBy("cpf", cpf);

            if (pessoa.getIdPessoa() == 0) {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!",
                        null, JOptionPane.ERROR_MESSAGE);
            } else {
                pesquisaCliente(pessoa.getIdPessoa());
            }

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void pesquisaCliente(int idPessoa) {
        try {
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("cliente");
            cliente = (Cliente) objetoRemoto.findBy("idPessoa", idPessoa);
            if (cliente.getIdCliente() == 0) {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!",
                        null, JOptionPane.ERROR_MESSAGE);
            } else {
                Panel.setVisible(true);
                Label_NomeCliente.setText(pessoa.getNome());

                mostraVendas("");

                //iniciaVenda();
            }
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private DefaultTableModel preparaModelVendas() {
        DefaultTableModel modelo = (DefaultTableModel) Table_Vendas.getModel();
        return modelo;
    }

    private DefaultTableModel preparaModelCarrinho() {
        DefaultTableModel modelo = (DefaultTableModel) Table_Carrinho.getModel();
        return modelo;
    }

    private void mostraVendas(String op) {
        ArrayList<Venda> lista = new ArrayList<Venda>();

        try {

            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("venda");
            System.out.println("Consultando...");
            lista = (ArrayList) objetoRemoto.findByList("idCliente", cliente.getIdCliente());

            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não há vendas!",
                        null, JOptionPane.ERROR_MESSAGE);
            } else {
                acessaNomeFuncionarioENomeCliente(lista);
            }

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void mostraCarrinho(ArrayList<Carrinho> carrinho) {
        DefaultTableModel modelo = preparaModelCarrinho();
        Object rowData[] = new Object[3];

        for (int i = 0; i < carrinho.size(); i++) {
            rowData[0] = carrinho.get(i).getIdVenda();
            rowData[1] = retornaNomeProduto(carrinho.get(i).getIdProduto());
            rowData[2] = carrinho.get(i).getQuantidadeItemVenda();
            modelo.addRow(rowData);
        }
    }

    private String retornaNomeProduto(int idProduto) {
        String nomeProduto = null;
        try {
            Produto produto = new Produto();
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("produto");
            produto = (Produto) objetoRemoto.findBy("idProduto", idProduto);

            nomeProduto = produto.getNome();

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
        return nomeProduto;
    }

    private void acessaNomeFuncionarioENomeCliente(ArrayList<Venda> lista) {
        DefaultTableModel modelo = preparaModelVendas();
        Object rowData[] = new Object[6];

        for (int i = 0; i < lista.size(); i++) {
            rowData[0] = lista.get(i).getIdVenda();
            rowData[1] = pesquisaIdCliente(lista.get(i).getIdCliente());
            rowData[2] = pesquisaIdFuncionario(lista.get(i).getIdFuncionario());
            rowData[3] = lista.get(i).getData();
            rowData[4] = lista.get(i).getValorTotal();
            if (lista.get(i).isConfirmado()) {
                rowData[5] = "SIM";
            } else {
                rowData[5] = "NAO";
            }
            modelo.addRow(rowData);
        }
    }

    private String pesquisaIdFuncionario(int idFuncionario) {
        String nomeFuncionario = null;
        try {
            Funcionario funcionarioLista = new Funcionario();
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("funcionario");
            funcionarioLista = (Funcionario) objetoRemoto.findBy("idFuncionario", idFuncionario);

            nomeFuncionario = funcionarioLista.getNome();

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }

        return nomeFuncionario;
    }

    private String pesquisaIdCliente(int idCliente) {
        String nomeCliente = null;
        try {
            Cliente clienteLista = new Cliente();
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("cliente");
            clienteLista = (Cliente) objetoRemoto.findBy("idCliente", idCliente);
            nomeCliente = clienteLista.getNome();
            //nomeCliente = nomeCliente(clienteLista.getIdPessoa());

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }

        return nomeCliente;
    }

    private void verificaIdVenda() {
        String aux = FormattedTextField_IDVenda.getText().toString();
        int idVenda;
        if (aux.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo vazio!",
                    null, JOptionPane.ERROR_MESSAGE);
        } else {
            idVenda = Integer.parseInt(aux);
            try {
                Venda venda = new Venda();
                //criar objeto da interface, usa o lookpu para pegar a chave
                //conexa_server possui o ip e o registry para definir a conexao com o server
                IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("venda");
                venda = (Venda) objetoRemoto.findBy("idVenda", idVenda);
                if (venda.getIdCliente() == 0) {
                    JOptionPane.showMessageDialog(null, "ID inválido!",
                            null, JOptionPane.ERROR_MESSAGE);
                } else {
                    if (venda.getIdCliente() == cliente.getIdCliente()) {
                        Panel_Carrinho.setVisible(true);
                        IDVENDA = venda.getIdVenda();

                    } else {
                        JOptionPane.showMessageDialog(null, "ID inválido!",
                                null, JOptionPane.ERROR_MESSAGE);
                    }
                }

            } catch (RemoteException e) {
                System.out.println(e.getMessage());
            } catch (NotBoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void verificaDadosCarrinho() {
        String nomeProduto = TextField_NomeProduto.getText().toString();
        String aux = FormattedTextField_Quantidade.getText().toString();
        int quantidade;
        if (!nomeProduto.equals("") && !aux.equals("")) {
            quantidade = Integer.parseInt(aux);
            if (quantidade > 0) {

                adicionaProdutoCarrinho(nomeProduto, quantidade, IDVENDA);

            } else {
                JOptionPane.showMessageDialog(null, "Campos vazios!",
                        null, JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade inválida!",
                    null, JOptionPane.ERROR_MESSAGE);
        }

    }

    private void adicionaProdutoCarrinho(String nomeProduto, int quantidade, int idVenda) {
        Produto produto = new Produto();
        Carrinho carrinho = new Carrinho();
        try {
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("produto");
            produto = (Produto) objetoRemoto.findBy("nome", nomeProduto);
            if (produto.getIdProduto() != 0 && produto.getQuantidade() >= quantidade) {
                carrinho.setIdProduto(produto.getIdProduto());
                carrinho.setIdVenda(idVenda);
                carrinho.setQuantidadeItemVenda(quantidade);
                produtos.add(carrinho);

                mostraCarrinho(produtos);
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado/não possui a quantidade passada.",
                        null, JOptionPane.ERROR_MESSAGE);
            }
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //TERMINAR
    private void encerraVenda() {
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Carrinho vazio!",
                    null, JOptionPane.ERROR_MESSAGE);
        } else {
            int idVenda, idProduto, quantidade;

            for (int i = 0; i < produtos.size(); i++) {
                idVenda = produtos.get(i).getIdVenda();
                idProduto = produtos.get(i).getIdProduto();
                quantidade = produtos.get(i).getQuantidadeItemVenda();
                try {
                    Carrinho carrinho = new Carrinho();
                    //criar objeto da interface, usa o lookpu para pegar a chave
                    //conexa_server possui o ip e o registry para definir a conexao com o server
                    IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("carrinho");
                    carrinho.setIdProduto(idProduto);
                    carrinho.setIdVenda(idVenda);
                    carrinho.setQuantidadeItemVenda(quantidade);

                    JOptionPane.showMessageDialog(null, objetoRemoto.create(carrinho),
                            null, JOptionPane.ERROR_MESSAGE);
                } catch (RemoteException e) {
                    System.out.println(e.getMessage());
                } catch (NotBoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private void novaVenda() {
        try {
            Venda venda = new Venda();
            //criar objeto da interface, usa o lookpu para pegar a chave
            //conexa_server possui o ip e o registry para definir a conexao com o server
            IControllerBase objetoRemoto = (IControllerBase) conexao_server.conexao().lookup("venda");
            venda.setConfirmado(false);
            venda.setData(formataData.dataAtual());
            venda.setIdFuncionario(Login.IDFUNCIONARIO);
            venda.setIdCliente(cliente.getIdCliente());
            JOptionPane.showMessageDialog(null, objetoRemoto.create(venda),
                    null, JOptionPane.ERROR_MESSAGE);

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
        FormattedTextField_CPFCliente = new javax.swing.JFormattedTextField();
        Button_Pesquisar = new javax.swing.JButton();
        Panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Label_NomeCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Vendas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        FormattedTextField_IDVenda = new javax.swing.JFormattedTextField();
        Button_Carrinho = new javax.swing.JButton();
        Panel_Carrinho = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TextField_NomeProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        FormattedTextField_Quantidade = new javax.swing.JFormattedTextField();
        Button_Adicionar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_Carrinho = new javax.swing.JTable();
        Button_Finaliza = new javax.swing.JButton();
        Button_NovaVenda = new javax.swing.JButton();

        setClosable(true);
        setTitle("Realizar Venda");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Venda");

        jLabel2.setText("CPF do Cliente:");

        try {
            FormattedTextField_CPFCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        Button_Pesquisar.setText("Pesquisar");
        Button_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PesquisarActionPerformed(evt);
            }
        });

        Panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Venda"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cliente:");

        Table_Vendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Venda", "Cliente", "Funcionário", "Data", "Valor", "Finalizada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table_Vendas);

        jLabel4.setText("ID Venda:");

        FormattedTextField_IDVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        Button_Carrinho.setText("Abrir Carrinho");
        Button_Carrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CarrinhoActionPerformed(evt);
            }
        });

        Panel_Carrinho.setBorder(javax.swing.BorderFactory.createTitledBorder("Carrinho"));

        jLabel5.setText("Nome Produto:");

        jLabel6.setText("Quantidade:");

        FormattedTextField_Quantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        Button_Adicionar.setText("Adicionar");
        Button_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AdicionarActionPerformed(evt);
            }
        });

        Table_Carrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Venda", "Produto", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Table_Carrinho);

        Button_Finaliza.setText("Finalizar");
        Button_Finaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_FinalizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_CarrinhoLayout = new javax.swing.GroupLayout(Panel_Carrinho);
        Panel_Carrinho.setLayout(Panel_CarrinhoLayout);
        Panel_CarrinhoLayout.setHorizontalGroup(
            Panel_CarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(Panel_CarrinhoLayout.createSequentialGroup()
                .addGroup(Panel_CarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_CarrinhoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(TextField_NomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(FormattedTextField_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_Adicionar))
                    .addGroup(Panel_CarrinhoLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(Button_Finaliza)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        Panel_CarrinhoLayout.setVerticalGroup(
            Panel_CarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_CarrinhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_CarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextField_NomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(FormattedTextField_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Adicionar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(Button_Finaliza)
                .addContainerGap())
        );

        Button_NovaVenda.setText("Nova Venda");
        Button_NovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_NovaVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Carrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(Label_NomeCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(FormattedTextField_IDVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_Carrinho)
                        .addGap(68, 68, 68)
                        .addComponent(Button_NovaVenda)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Label_NomeCliente))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(FormattedTextField_IDVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Carrinho)
                    .addComponent(Button_NovaVenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_Carrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(304, 304, 304))
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(FormattedTextField_CPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Button_Pesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(FormattedTextField_CPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Pesquisar))
                .addGap(18, 18, 18)
                .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_PesquisarActionPerformed
        valoresDosCampos();
    }//GEN-LAST:event_Button_PesquisarActionPerformed

    private void Button_CarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CarrinhoActionPerformed
        verificaIdVenda();
    }//GEN-LAST:event_Button_CarrinhoActionPerformed

    private void Button_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AdicionarActionPerformed
        verificaDadosCarrinho();
    }//GEN-LAST:event_Button_AdicionarActionPerformed

    private void Button_FinalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_FinalizaActionPerformed
        encerraVenda();
    }//GEN-LAST:event_Button_FinalizaActionPerformed

    private void Button_NovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_NovaVendaActionPerformed
        novaVenda();
    }//GEN-LAST:event_Button_NovaVendaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Adicionar;
    private javax.swing.JButton Button_Carrinho;
    private javax.swing.JButton Button_Finaliza;
    private javax.swing.JButton Button_NovaVenda;
    private javax.swing.JButton Button_Pesquisar;
    private javax.swing.JFormattedTextField FormattedTextField_CPFCliente;
    private javax.swing.JFormattedTextField FormattedTextField_IDVenda;
    private javax.swing.JFormattedTextField FormattedTextField_Quantidade;
    private javax.swing.JLabel Label_NomeCliente;
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel Panel_Carrinho;
    private javax.swing.JTable Table_Carrinho;
    private javax.swing.JTable Table_Vendas;
    private javax.swing.JTextField TextField_NomeProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
