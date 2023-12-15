/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import vista.InterfazArriendosPagar;
import vista.VistaArriendosPagar;

import modelo.Vehiculo;
import modelo.Cliente;
import modelo.ArriendoCuota;

/**
 *
 * @author xavie
 */
public class ControladorArriendosPagar implements ActionListener {
    private InterfazArriendosPagar vista = new VistaArriendosPagar();
    private ArrayList<Cliente> clientes;
    private ArrayList<Vehiculo> Vehiculo;
    private ArrayList<ArriendoCuota> cuotas;
    

    public ControladorArriendosPagar(vista.InterfazArriendosPagar vista, ArrayList<ArriendoCuota> cuotas, ArrayList<Cliente> clientes, ArrayList<Vehiculo> vehiculos) {
        setVista(vista);
        setClientes(clientes);
        getVista().registrarEscuchador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Container contenido = getVista().getPanel().getParent();
        String command = e.getActionCommand();
        
        if (command.equals(getVista().VOLVER)) {
            //Se remueve el panel
            contenido.remove(getVista().getPanel());
            //Se activa el panel anterior
            contenido.getComponent(contenido.getComponentCount() - 1).setVisible(true);
        } else {
            throw new UnsupportedOperationException("Acción no implementada.");
        }//if
        
        contenido.validate();
        contenido.repaint();
    }
    
    /**
     * @return the clientes
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * @return the vista
     */
    public InterfazArriendosPagar getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(InterfazArriendosPagar vista) {
        this.vista = vista;
    }
    
    
}
