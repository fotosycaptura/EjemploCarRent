/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Vehiculo;
import vista.InterfazVehiculo;
import vista.VistaVehiculos;

/**
 *
 * @author xavie
 */
public class ControladorVehiculos implements ActionListener {
    private final InterfazVehiculo vista = new VistaVehiculos();
    private ArrayList<Vehiculo> modelo = new ArrayList<Vehiculo>();
    
    public ControladorVehiculos(){
        getVista().registrarEscuchador(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Container contenido = getVista().getPanel().getParent();
        String command = e.getActionCommand();
        
        if (command.equals(getVista().LISTAR)){
            System.out.println("Se ha clickeado en Listar");
        }
        else if (command.equals(getVista().AGREGAR)){
            System.out.println("Se ha clickeado en Agregar");
        }
        else if (command.equals(getVista().VOLVER)) {
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
    public InterfazVehiculo getVista() {
        return vista;
    }

    /**
     * @return the modelo
     */
    public ArrayList<Vehiculo> getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ArrayList<Vehiculo> modelo) {
        this.modelo = modelo;
    }
    
}
