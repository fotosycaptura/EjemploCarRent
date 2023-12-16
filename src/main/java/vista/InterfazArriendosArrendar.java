/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vista;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import modelo.Cliente;
import modelo.Vehiculo;
import modelo.CuotaArriendo;

/**
 *
 * @author xavie
 */
public interface InterfazArriendosArrendar {
    public final String GUARDAR_ARRIENDO = "GUARDAR_ARRIENDO";
    public final String PAGAR_PRIMERA_CUOTA = "PAGAR_PRIMERA_CUOTA";
    public final String VOLVER = "VOLVER";
    
    public JPanel getPanel();
    public void registrarEscuchador(ActionListener escuchador);
    public void vaciarCampos();
    public int mostrarMensaje(int tipoMensaje, String msj);
    public void setDllCliente(ArrayList<Cliente> clientes);
    public void setDllCliente(String cedula, ArrayList<Cliente> clientes);
    public void setDllVehiculos(ArrayList<Vehiculo> vehiculos);
    public void setDllVehiculos(String patente, ArrayList<Vehiculo> vehiculos);
    public String getClienteSeleccionado();
    public String getVehiculoSeleccionado();
    public String getFecha();
    public void setFecha(String fecha);
    public String getDias();
    public void setDias(int NumDias);
    public String getCantidadCuotas();
    public void setCantidadCuotas(int NumCuotas);
    public String getPrecioArriendoPorDia();
    public void setPrecioPorDia(int PrecioPorDia);
    public void setMontoAPagar(String monto);
    public void setMostrarCuotas(ArrayList<CuotaArriendo> cuotas);

}
