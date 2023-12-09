/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import modelo.Cliente;
/**
 *
 * @author xavie
 */
public interface InterfazClientesListarEliminar {
    public final String VOLVER = "VOLVER";
    public final String ELIMINAR = "ELIMINAR";
    public JPanel getPanel();
    public void registrarEscuchador(ActionListener escuchador);
    public void listarClientes(ArrayList<Cliente> clientes);
    public void mostrarMensaje(String msj);
}
