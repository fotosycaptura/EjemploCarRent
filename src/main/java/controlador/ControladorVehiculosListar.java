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
import vista.InterfazVehiculoListar;
/**
 *
 * @author xavier.fuentes
 */
public class ControladorVehiculosListar implements ActionListener {
    private InterfazVehiculoListar vista;
    private ArrayList<Vehiculo> modelo;
    private ArrayList<String> condicion;

    public ControladorVehiculosListar(InterfazVehiculoListar vista, ArrayList<Vehiculo> modelo) {
        setVista(vista);
        setModelo(modelo);
        getVista().registrarEscuchador(this);
        getVista().listarVehiculos(getModelo());
    }

    public ArrayList<String> getCondicion(){
        ArrayList<String> condiciones = new ArrayList<String>();
        condiciones.add("-Seleccione-");
        condiciones.add("D");
        condiciones.add("A");
        condiciones.add("M");
        return condiciones;
    }
    
    /**
     * @return the vista
     */
    public InterfazVehiculoListar getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(InterfazVehiculoListar vista) {
        this.vista = vista;
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
    
    @Override
    public void actionPerformed(ActionEvent e){
        Container contenido = getVista().getPanel().getParent();
        String command = e.getActionCommand();
        if (command.equals(getVista().VOLVER)) {
            //Se remueve el panel
            contenido.remove(getVista().getPanel());
            //Se activa el panel anterior
            contenido.getComponent(contenido.getComponentCount() - 1).setVisible(true);
        } else if (command.equals(getVista().CAMBIARCONDICION)){
            //Se extrae la patente
            //Se busca y se verifica que exista el vehículo y se manda a mantención
            try{
                setModelo(Vehiculo.cambiarEstadoVehiculo(getVista().getPatente(), getModelo()));
                getVista().listarVehiculos(getModelo());
                getVista().mostrarMensaje(1, "El vehículo se envió a mantención");
            }catch(Exception ex){
                getVista().mostrarMensaje(3, "No se pudo completar la operación: " + ex.getMessage());
            }//trycatch
            
        } else {
            throw new UnsupportedOperationException("Acción no implementada.");
        }//if
        
        contenido.validate();
        contenido.repaint();
    }
}
