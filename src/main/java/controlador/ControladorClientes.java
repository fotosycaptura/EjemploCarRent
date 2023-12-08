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
import vista.InterfazClientes;
import vista.VistaAgregarCliente;
import vista.VistaClientes;

/**
 *
 * @author Tom
 */
public class ControladorClientes implements ActionListener {
    private final InterfazClientes vista = new VistaClientes();
    private ArrayList<Cliente> modelo = new ArrayList<Cliente>();
    
    public ControladorClientes() {
        getVista().registrarEscuchador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Container contenido = getVista().getPanel().getParent();
        String command = e.getActionCommand();
        
        if (command.equals(getVista().ELIMINAR)) {
            System.out.println("HAGO CLICK AL ELIMINAR");
        } else if (command.equals(getVista().LISTAR)) {
            System.out.println("HAGO CLICK AL LISTAR");
        } else if (command.equals(getVista().VOLVER)) {
            contenido.remove(getVista().getPanel());
            contenido.getComponent(contenido.getComponentCount() - 1).setVisible(true);
        } else if (command.equals(getVista().AGREGAR)) {
            ControladorAgregarCliente controlador = new ControladorAgregarCliente(
                    new VistaAgregarCliente(), 
                    getModelo()
            );
            getVista().getPanel().setVisible(false);
            contenido.add(controlador.getVista().getPanel());
        } else {
            throw new UnsupportedOperationException("Acción no implementada.");
        }
        
        contenido.validate();
        contenido.repaint();
    }
    
    /**
     * @return the vista
     */
    public InterfazClientes getVista() {
        return vista;
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
