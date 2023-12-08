/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Cliente;
import vista.InterfazAgregarCliente;

/**
 *
 * @author Tom
 */
public class ControladorAgregarCliente implements ActionListener {
    private InterfazAgregarCliente vista;
    private ArrayList<Cliente> modelo;
    
    public ControladorAgregarCliente(InterfazAgregarCliente vista, ArrayList<Cliente> modelo) {
        setVista(vista);
        setModelo(modelo);
        getVista().registrarEscuchador(this);
        getVista().listarClientes(getModelo());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Container contenido = getVista().getPanel().getParent();
        String command = e.getActionCommand();
        
        if (command.equals(getVista().VOLVER)) {
            contenido.remove(getVista().getPanel());
            contenido.getComponent(contenido.getComponentCount() - 1).setVisible(true);
        } else if (command.equals(getVista().AGREGAR)) {
            Cliente nuevoCliente = new Cliente(getVista().getRut(), getVista().getNombre(), true);
            getModelo().add(nuevoCliente);
            contenido.remove(getVista().getPanel());
            contenido.getComponent(contenido.getComponentCount() - 1).setVisible(true);
        } else {
            throw new UnsupportedOperationException("Acción no implementada.");
        }
        
        contenido.validate();
        contenido.repaint();
    }

    /**
     * @return the vista
     */
    public InterfazAgregarCliente getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(InterfazAgregarCliente vista) {
        this.vista = vista;
    }

    /**
     * @return the modelo
     */
    public ArrayList<Cliente> getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ArrayList<Cliente> modelo) {
        this.modelo = modelo;
    }
    
}
