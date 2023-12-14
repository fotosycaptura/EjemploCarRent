/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vista;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author xavie
 */
public interface InterfazArriendos {
    public static final String ARRENDAR = "ARRENDAR";
    public static final String LISTAR = "LISTAR";
    public static final String PAGAR = "PAGAR";
    public static final String VOLVER = "VOLVER";
    
    public JPanel getPanel();
    public void registrarEscuchador(ActionListener escuchador);
    public int mostrarMensaje(int tipoMensaje, String msj);
}
