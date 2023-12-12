/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vista;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import modelo.Vehiculo;
/**
 *
 * @author xavier.fuentes
 */
public interface InterfazVehiculoAgregar {
    public final String AGREGAR = "AGREGAR";
    public final String VOLVER = "VOLVER";
    
    public JPanel getPanel();
    public void registrarEscuchador(ActionListener escuchador);
    public String getPatente();
    public String getModelo();
    public String getMarca();
    public String getAnio();
    public void vaciarCampos();
    public int mostrarMensaje(int tipoMensaje, String msj);
    public void listarVehiculos(ArrayList<Vehiculo> vehiculos);
}
