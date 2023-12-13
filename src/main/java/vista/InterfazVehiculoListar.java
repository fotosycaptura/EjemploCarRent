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
public interface InterfazVehiculoListar {
    public final String VOLVER = "VOLVER";
    public final String BUSCAR = "BUSCAR";
    public JPanel getPanel();
    public void registrarEscuchador(ActionListener escuchador);
    public int mostrarMensaje(int tipoMensaje, String msj);
    public void listarVehiculos(ArrayList<Vehiculo> vehiculos);
    public void ddlCondiciones(ArrayList<String> condiciones);
    public String getPatente();
}
