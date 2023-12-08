/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import modelo.Cliente;

/**
 *
 * @author Tom
 */
public interface InterfazAgregarCliente {
    public final String AGREGAR = "AGREGAR";
    public final String VOLVER = "VOLVER";
    
    public JPanel getPanel();
    public void registrarEscuchador(ActionListener escuchador);
    public String getNombre();
    public String getRut();
    public void vaciarCampos();
    public void listarClientes(ArrayList<Cliente> clientes);
}
