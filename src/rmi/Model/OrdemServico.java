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

   

public class OrdemServico implements Serializable {
<<<<<<< HEAD
    private int idOrdemServico, idFuncionario,idServico,idVenda;
    private String Descricao;
    private boolean completado;

    private Date dataInicio, dataFim;//, dataConclusao;
=======
    private int idOrdemServico, idFuncionario,estado,idVenda;
    private Date dataExp;//, dataConclusao;
>>>>>>> ac075cdf18db8bc92564ad2346d0b69ee69ac56e

    public int getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(int idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }
/*
    public int getIdClienteHasproduto() {
        return idClienteHasproduto;
    }
*/
    public int getEstado() {
        return estado;
    }

    public void setEstado(int servicoCompleto) {
        this.estado = servicoCompleto;
    }

    public int getVendaId() {
        return idVenda;
    }

<<<<<<< HEAD
    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
=======
    public void setVendaId(int produtoId) {
        this.idVenda = produtoId;
    }

    
    /*
    
    public void setIdClienteHasproduto(int idClienteHasproduto) {
        this.idClienteHasproduto = idClienteHasproduto;
    }
*/
    
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
>>>>>>> ac075cdf18db8bc92564ad2346d0b69ee69ac56e
    }

/*
    public int getIdVenda() {
        return idVenda;
    }
*/
    /*
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }*/

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

<<<<<<< HEAD
    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

=======
    
    
    /*public Date getDataConclusao() {
        return dataConclusao;
    }*/

    /*
    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }*/
    
>>>>>>> ac075cdf18db8bc92564ad2346d0b69ee69ac56e
    
}
