/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vista;

import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Tom
 */
public interface InterfazPrincipal {
    public static final String ARRIENDOS = "ARRIENDOS";
    public static final String CLIENTES = "CLIENTES";
    public static final String VEHICULOS = "VEHICULOS";
    public static final String SALIR = "SALIR";
    
    public JPanel getPanel();
    public void registrarEscuchador(ActionListener escuchador);
}
