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
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<ArriendoCuota> modelo;
    

    public ControladorArriendosPagar(vista.InterfazArriendosPagar vista, ArrayList<ArriendoCuota> modelo, ArrayList<Cliente> clientes, ArrayList<Vehiculo> vehiculos) {
        setModelo(modelo);
        setVista(vista);
        setClientes(clientes);
        setVehiculos(vehiculos);
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

            getVista().setLstArriendosDelCliente(ArriendoCuota.buscarArriendo(
                    Cliente.buscarCliente(getVista().getClienteSeleccionado().substring(0,10), getClientes()),
                    getModelo()));
        
        } else if (command.equals(getVista().BUSCAR_CUOTAS)){
            System.out.println("Se buscan las cuotas...");
            if (!(getVista().getClienteSeleccionado() != null && !getVista().getClienteSeleccionado().equals("--Seleccione Cliente--"))){
                getVista().mostrarMensaje(3, "Seleccione un cliente antes de proceder");
                return;
            }//if
            
            if (getVista().getArriendoSeleccionado() == null){
                getVista().mostrarMensaje(3, "Seleccione un arriendo antes de proceder");
                return;
            }//if
            
            //Se buscan las cuotas y se traspasan
            ArriendoCuota arriendoEncontrado = ArriendoCuota.buscarArriendo(
                    Cliente.buscarCliente(getVista().getClienteSeleccionado().substring(0,10), getClientes()),
                    Vehiculo.buscarVehiculo(getVista().getArriendoSeleccionado().substring(0, 8), getVehiculos()),
                    getModelo());
            if (arriendoEncontrado != null){
                arriendoEncontrado.getCuotas();
            }//if
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
    
    public ArrayList<Vehiculo> getVehiculos(){
        return this.vehiculos;
    }
    
    public void setVehiculos(ArrayList<Vehiculo> vehiculos){
        this.vehiculos = vehiculos;
    }
}
