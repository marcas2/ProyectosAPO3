package Operador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maria Casanova y Juan Calpa
 */
public class Operaciones {
    

    
    
    public String Suma(float numero1, float numero2){
        float resultado = numero1+numero2;
        return String.valueOf(resultado);
        
    }
    
    public String Resta(float numero1, float numero2){
        float resultado = numero1-numero2;
        return String.valueOf(resultado);
        
    }
    
    public String Multiplicacion(float numero1, float numero2){
        float resultado = numero1*numero2;
        return String.valueOf(resultado);
        
    }
    
    public String Division(float numero1, float numero2){
        float resultado= numero1/numero2;
        return String.valueOf(resultado);
        
    }
    
    

    
}
