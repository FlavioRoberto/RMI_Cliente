/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.Interface.IControllerBase;
import rmi.Model.Pessoa;

/**
 *
 * @author Admin
 */
public class RMI_Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        try{
            //cria conexao com a porta de comunicacao com o servidor
            Registry conexao = LocateRegistry.getRegistry("127.0.0.1",1500);
            //criar objeto da interface, usa o lookpu para pegar a chave
            IControllerBase objetoRemoto =(IControllerBase)conexao.lookup("chave");
            //chama metodo do servidor
            Pessoa pessoa = (Pessoa)objetoRemoto.read(1);
            //mostra a resposta do servidor
            System.out.println(pessoa.getNome());
        
        }catch(RemoteException e){
            System.out.println(e.getMessage());
        }catch(NotBoundException e){
            System.out.println(e.getMessage());
        } 
    }
    
}
    

