/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empresa;

import Vistas.Login;

/**
 *
 * @author Juan y María
 * @class Empresa 
 * @version 1.0 
 * Clase Empresa donde se implementa el singleton
 */
public class Empresa {

    /**
     * Clase principal
     * Implementamos el singleton 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login login=Login.getLogin();
        login.setVisible(true);
    }
    
}
