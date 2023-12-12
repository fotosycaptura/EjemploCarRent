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
import vista.InterfazVehiculoAgregar;
/**
 *
 * @author xavier.fuentes
 */
public class ControladorVehiculosAgregar implements ActionListener{
    private InterfazVehiculoAgregar vista;
    private ArrayList<Vehiculo> modelo;

    public ControladorVehiculosAgregar(InterfazVehiculoAgregar vista, ArrayList<Vehiculo> modelo) {
        setVista(vista);
        setModelo(modelo);
        getVista().registrarEscuchador(this);
        getVista().listarVehiculos(getModelo());
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

    /**
     * @return the vista
     */
    public InterfazVehiculoAgregar getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(InterfazVehiculoAgregar vista) {
        this.vista = vista;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Intentando Volver");
        Container contenido = getVista().getPanel().getParent();
        String command = e.getActionCommand();
        //Verifica las acciones
        if (command.equals(getVista().VOLVER)) {
            //Se remueve el panel
            contenido.remove(getVista().getPanel());
            //Se activa el panel anterior
            contenido.getComponent(contenido.getComponentCount() - 1).setVisible(true);
        }else {
            throw new UnsupportedOperationException("Acción no implementada.");
        }
        
        contenido.validate();
        contenido.repaint();
    }
}
