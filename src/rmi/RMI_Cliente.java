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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import rmi.Interface.IControllerBase;
import rmi.Model.Cliente;
import rmi.Model.Funcionario;
import rmi.Model.Pessoa;
import rmi.Util.conexao_server;

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
          Funcionario funcionario = new Funcionario();
          //criar objeto da interface, usa o lookpu para pegar a chave
          //conexa_server possui o ip e o registry para definir a conexao com o server
          IControllerBase objetoRemoto =(IControllerBase)conexao_server.conexao().lookup("funcionario"); 
          System.out.println("Atualizando Funcionario...");
          funcionario.setNome("bruno teste");
          funcionario.setIdPessoa(25);
          //funcionario = (Funcionario) objetoRemoto.update(funcionario);
          JOptionPane.showMessageDialog(null, objetoRemoto.update(funcionario), 
                        null,JOptionPane.INFORMATION_MESSAGE);
        }catch(RemoteException e){
            System.out.println(e.getMessage());
        }catch(NotBoundException e){
            System.out.println(e.getMessage());
        } 
        
        /*
        try{
            //cria conexao com a porta de comunicacao com o servidor
            Registry conexao = LocateRegistry.getRegistry("25.32.150.87",1500);
            //criar objeto da interface, usa o lookpu para pegar a chave
            IControllerBase objetoRemoto =(IControllerBase)conexao.lookup("pessoa");
            //chama metodo do servidor
            System.out.println("Cadastrando...");
            Pessoa p = new Pessoa();
            p = (Pessoa)objetoRemoto.findBy("cpf", "11111111111");   
            System.out.print(p.getNome());
        }catch(RemoteException e){
            System.out.println(e.getMessage());
        }catch(NotBoundException e){
            System.out.println(e.getMessage());
        } 
        */
    }
    
}
    

