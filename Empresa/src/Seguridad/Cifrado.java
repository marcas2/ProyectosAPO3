/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguridad;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;



/**
 *
 * @author maria
 */
public class Cifrado {
  

    public Cifrado() {
    }
    

    private SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        
        byte[] claveEncriptar = clave.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        
        claveEncriptar = sha.digest(claveEncriptar);
        claveEncriptar = Arrays.copyOf(claveEncriptar,16);
        
        SecretKeySpec secretKey = new SecretKeySpec(claveEncriptar, "AES");
        
        return secretKey;
    }
    
     public String encriptar(String datos, String claveSecreta) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
       
         SecretKeySpec secretKey = this.crearClave(claveSecreta);
        
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        byte[] datosEncriptar = datos.getBytes("UTF-8");
        byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
        String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);
        
        return encriptado;
        
    }
    
    public String desencriptar (String encriptado, String claveSecreta) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
       
        SecretKeySpec sk = this.crearClave(claveSecreta);
        byte[] decodedKey = Base64.getDecoder().decode(claveSecreta);
        
    try{
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
        cipher.init(Cipher.DECRYPT_MODE, sk);
        byte[] desencriptado = cipher.doFinal(Base64.getDecoder().decode(encriptado));
        return new String(desencriptado);
    }
    catch (Exception e) {
              throw new RuntimeException(
                    "Error occured while decrypting data", e);
        }
        

    }
    

    }

    

     
    

