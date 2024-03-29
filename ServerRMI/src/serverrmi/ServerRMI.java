/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serverrmi;

/**
 *
 * @author sistemas
 */

import Interface.RMIDAO; //libreria propia

//librerias que se importan
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.management.remote.rmi.RMIServer;


public class ServerRMI extends UnicastRemoteObject implements RMIDAO{

    public ServerRMI() throws RemoteException{
        super();
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Registry registro = LocateRegistry.createRegistry(7777);
            registro.rebind("RemotoRMI", new ServerRMI());
            System.out.println("Servidor esta activo");
        }catch(RemoteException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int sumar(int numero1, int numero2) throws RemoteException {
        return numero1 + numero2;
    }

    @Override
    public int restar(int numero1, int numero2) throws RemoteException {
        return numero1 - numero2;
    }

    @Override
    public int multiplicar(int numero1, int numero2) throws RemoteException {
        return numero1 * numero2;
    }

    @Override
    public int dividir(int numero1, int numero2) throws RemoteException {
        return numero1 /numero2;
    }

    @Override
    public String Mensaje(String mensaje) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String operacion(String ope, int numero1, int numero2) throws RemoteException {
       int result=0;
       switch (ope){ 
            case "+" : result = sumar(numero1, numero2);break;
            case "-" : result = restar(numero1, numero2);break;
            case "x" : result = multiplicar(numero1, numero2);break;
            case "/" : result = dividir(numero1, numero2);break;
       }
       return String.valueOf(result);
    }
    
}
