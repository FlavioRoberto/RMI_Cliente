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
public class Servico implements Serializable {
<<<<<<< HEAD
    private int idServico;
    private String descricao;
=======
    private int idServico,idOS;
    private Date dataConclusao;
>>>>>>> ac075cdf18db8bc92564ad2346d0b69ee69ac56e
    
    

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

<<<<<<< HEAD
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
=======
    public int getIdOS() {
        return idOS;
    }

    public void setIdOS(int idOS) {
        this.idOS = idOS;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    } 
>>>>>>> ac075cdf18db8bc92564ad2346d0b69ee69ac56e
}
