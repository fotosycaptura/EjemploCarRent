/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vista;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import modelo.ArriendoCuota;
import modelo.Cliente;
import modelo.CuotaArriendo;

/**
 *
 * @author xavie
 */
public interface InterfazArriendosPagar {
    public final String VOLVER = "VOLVER";
    public final String BUSCAR = "BUSCAR";
    public final String BUSCAR_CUOTAS = "BUSCAR_CUOTAS";
    public JPanel getPanel();
    public void registrarEscuchador(ActionListener escuchador);
    public int mostrarMensaje(int tipoMensaje, String msj);
    public String getClienteSeleccionado();
    public void setDllCliente(ArrayList<Cliente> clientes);
    public void setLstArriendosDelCliente(ArrayList<ArriendoCuota> arriendos);
    public String getArriendoSeleccionado();
    public void setLstCuotasPorPagar(ArrayList<CuotaArriendo> cuotasArriendos);
    public void vaciarCosas();
}
