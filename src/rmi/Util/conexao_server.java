/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.Util;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.Interface.IControllerBase;

/**
 *
 * @author Bruno
 */
public class conexao_server {
    
    private static Registry conexao;
    
    public static Registry conexao(){
        try{
            //cria conexao com a porta de comunicacao com o servidor
            conexao = LocateRegistry.getRegistry("127.0.0.1", 1500);
        }catch(RemoteException e){
            System.out.println(e.getMessage());
        }
        return conexao;
    }

}
