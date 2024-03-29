/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;
import Seguridad.Cifrado;
import Controlador.ControladorLogin;
import DAO.DAOLogin;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan y María
 * Login
 * @version 1.0 
 * Clase para recibir parametros y la interfaz 
 */
public class Login extends javax.swing.JFrame {
    
    /**
     * Declaración atributos
     */
   
    private static Login login;
    private DAOLogin cLogin=ControladorLogin.getControladorLogin();
    Cifrado seguridad = new Cifrado();

 

    
    /**
     * Se crea un login
     */
    private Login() {
       initComponents();

    }
    /**
     * Login 
     * Se evalua si ya existe un valor, en caso de que no se crea uno.
     * @return login
     */

    public static Login getLogin(){
        if(login==null)
            login=new Login();
        
        return login;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        olvido = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        usuario = new javax.swing.JTextField();
        contrasenia = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        olvido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        olvido.setText("¿Olvido su contraseña?");
        olvido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                olvidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                olvidoMouseExited(evt);
            }
        });
        getContentPane().add(olvido, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.GridLayout(0, 1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Logo");
        jPanel1.add(jLabel1);

        jPanel2.setLayout(new java.awt.GridLayout(0, 1));

        usuario.setText("Usuario.....");
        usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioMouseClicked(evt);
            }
        });
        jPanel2.add(usuario);

        contrasenia.setText("Contraseña....");
        contrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contraseniaMouseClicked(evt);
            }
        });
        jPanel2.add(contrasenia);

        jButton1.setText("Iniciar Sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jPanel1.add(jPanel2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioMouseClicked
        // TODO add your handling code here:
        usuario.setText("");
    }//GEN-LAST:event_usuarioMouseClicked

    private void contraseniaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contraseniaMouseClicked
        // TODO add your handling code here:
        contrasenia.setText("");
    }//GEN-LAST:event_contraseniaMouseClicked

    private void olvidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_olvidoMouseEntered
        // TODO add your handling code here:
        olvido.setForeground(new java.awt.Color(51, 0, 255));
    }//GEN-LAST:event_olvidoMouseEntered

    private void olvidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_olvidoMouseExited
        // TODO add your handling code here:
        olvido.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_olvidoMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        /**
         * Se especifica que se le indicará al usuario al momento que dijite los parametros
         */
        
        if(cLogin.VerificarUsuarios(usuario.getText(), contrasenia.getText())){
            
            JOptionPane.showMessageDialog(this, "Usuario correcto", "Información", JOptionPane.OK_OPTION);
            try {
               String claveSecreta="aaaa";
               String a=seguridad.encriptar(contrasenia.getText(), claveSecreta);
               JOptionPane.showMessageDialog(this, seguridad.encriptar(contrasenia.getText(), claveSecreta), "Encriptado", JOptionPane.OK_OPTION);
               JOptionPane.showMessageDialog(this, seguridad.desencriptar(a,claveSecreta), "Desencriptado", JOptionPane.OK_OPTION);
                 
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Usuario incorrecto", "Información", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contrasenia;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel olvido;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
