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
public interface InterfazVehiculo {
    public static final String AGREGAR = "AGREGAR";
    public static final String LISTAR = "LISTAR";
    public static final String VOLVER = "VOLVER";
    
    public JPanel getPanel();
    public void registrarEscuchador(ActionListener escuchador);
}
