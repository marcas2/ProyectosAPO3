/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.DAOLogin;

/**
 *
 * @author Juan y María
 * @class ControladorLogin 
 * @version 1.0 
 * Clase para verificar el usuario en la cual se implementa el DAO
 */
public class ControladorLogin implements DAOLogin{

    /**
     * Declaración de variables y variable estatica  
     */
    private static ControladorLogin controladorLogin;
    private String usuario;
    private String contrasenia;
    
    /**
     * Constructor
     */

    private ControladorLogin() {
        
    }
     /**
     * Metodo controlar Login
     * Verifica si existe o no un controlador, en caso de que no se crea uno.
     * @return controladorLogin
     */
    
    public static ControladorLogin getControladorLogin(){
        if(controladorLogin==null)
            controladorLogin=new ControladorLogin();
        
        return controladorLogin;
    }
    
     /**
     * Metodo verificar el usuario
     * @param usuario
     * @param contrasenia
     * Se verifica si el usuario y la contraseña coinciden. 
     * @return estado
     */
    @Override
    
    public boolean VerificarUsuarios(String usuario, String contrasenia) {
        boolean estado=false;
        
        if((usuario.equals("daniel"))&&(contrasenia.equals("12345")))
            estado=true;
        
        return estado;
    }
     /**
     * Metodo obtener el usuario
     * Se obtiene lo que contiene usuario. 
     * @return usuario
     */
    @Override
    public String getUsuario() {
        return this.usuario;
    }
     /**
     * Metodo cambiar contraseña
     * @param contrasenia
     * El estado se establece en verdadero y se reescribe contrasenia. 
     * @return estado
     */
    @Override
    public boolean CambiarContrasenia(String contrasenia) {
        boolean estado=true;        
        this.contrasenia=contrasenia;
        return estado;
        
    }
    
    
    
    
    
}
