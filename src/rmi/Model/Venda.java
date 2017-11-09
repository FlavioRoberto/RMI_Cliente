/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Venda implements Serializable {
<<<<<<< HEAD
    private int idVenda,idCliente,idFuncionario;
    private Date data;
    private boolean confirmado;
    private float valorTotal;
=======
    private int idVenda, quantidade,produto_idProduto,cliente_idCliente;
>>>>>>> ac075cdf18db8bc92564ad2346d0b69ee69ac56e

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

<<<<<<< HEAD
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int cliente_idCliente) {
        this.idCliente = cliente_idCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }
    
    
=======
    public int getProduto_idProduto() {
        return produto_idProduto;
    }

    public void setProduto_idProduto(int produto_idProduto) {
        this.produto_idProduto = produto_idProduto;
    }

    public int getCliente_idCliente() {
        return cliente_idCliente;
    }

    public void setCliente_idCliente(int cliente_idCliente) {
        this.cliente_idCliente = cliente_idCliente;
    }
<<<<<<< HEAD
=======
    
>>>>>>> 32bb49736aca22440f27ecf640603e5f8caf2148
>>>>>>> ac075cdf18db8bc92564ad2346d0b69ee69ac56e
    
    
}
