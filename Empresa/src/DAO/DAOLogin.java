/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

/**
 *
 * @author Juan y María
 * DAOLogin
 * @version 1.0 
 * Clase para implementar el DAO
 */
public interface DAOLogin {
    /**
     * Se llaman los metodos que contiene la clase ControladorLogin
     */
    /**
     * VerificarUsuarios
     * @param usuario
     * @param contrasenia
     * @return estado
     */
    public boolean VerificarUsuarios(String usuario, String contrasenia);
    /**
     * getUsuario
     * @return usuario
     */
    public String getUsuario();
    /**
     * CambiarContrasenia
     * @param contrasenia
     * @return estado
     */
    public boolean CambiarContrasenia(String contrasenia);
    
}
