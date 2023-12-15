/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private ArrayList<ArriendoCuota> modelo;
    

    public ControladorArriendosPagar(vista.InterfazArriendosPagar vista, ArrayList<ArriendoCuota> modelo, ArrayList<Cliente> clientes, ArrayList<Vehiculo> vehiculos) {
        setModelo(modelo);
        setVista(vista);
        setClientes(clientes);
        getVista().registrarEscuchador(this);
        getVista().setLstArriendosDelCliente(null);
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
            
        } else if (command.equals(getVista().BUSCAR)) {
            System.out.println(getVista().getClienteSeleccionado());
            getVista().setLstArriendosDelCliente(ArriendoCuota.buscarArriendo(
                    Cliente.buscarCliente(getVista().getClienteSeleccionado().substring(0,10), getClientes()),
                    getModelo()));
            
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
        getVista().setDllCliente(getClientes());
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

    /**
     * @return the cuotas
     */
    public ArrayList<ArriendoCuota> getModelo() {
        return this.modelo;
    }

    /**
     * @param cuotas the cuotas to set
     */
    public void setModelo(ArrayList<ArriendoCuota> modelo) {
        this.modelo = modelo;
    }
}
