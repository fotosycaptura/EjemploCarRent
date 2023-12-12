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
        }else if (command.equals(getVista().AGREGAR)){
            try{
                if (Vehiculo.encontrarVehiculo(getVista().getPatente(), getModelo())){
                    throw new IllegalArgumentException("El vehículo que intenta ingresar ya existe");
                }
                /**
                 * Toca crear un nuevo Vehículo.
                 * Se obtienen los datos de la vista.
                 */
                Vehiculo nuevoVehiculo= new Vehiculo(getVista().getPatente(), getVista().getMarca(), getVista().getModelo(), Integer.parseInt(getVista().getAnio()));
                //Se agrega al ArrayList<Vehiculo> del modelo
                getModelo().add(nuevoVehiculo);

                /**
                 * De la vista, al objeto listarVehiculos, se le agrega el ArrayList en este caso es Modelo.
                 * En el fondo lo que se hace acá, es colocar el listado de vehículos por decirlo así, en el JScrollpane
                 */
                getVista().listarVehiculos(getModelo());

                //Luego de ingresar el nuevo vehículo, se ha de limpiar el formulario.
                getVista().vaciarCampos();
                //Se despliega mensaje al usuario de que el vehículo fue agregado.
                getVista().mostrarMensaje(1, "¡Vehículo agregado!");

                //Comenté esto para desplegar mensaje de que se agregó, por si desea agregar otro.
                //Porque si quiere salir de esta ventana, ya tiene el botón volver.
                //Se elimina el panel
                //contenido.remove(getVista().getPanel());
                //Se vuelve a mostrar el panel anterior
                //contenido.getComponent(contenido.getComponentCount() - 1).setVisible(true);
            }catch(NumberFormatException ex){
                //Se despliega el mensaje de error al usuario si el año no se ingresa nada o si es un string en vez de un número
                getVista().mostrarMensaje(3, "Se produjo el siguiente error: debe ingresar un número para el año");
            }catch(Exception ex){
                //Para cualquier otro tipo de error
                getVista().mostrarMensaje(3, "Se produjo el siguiente error: " + ex.getMessage());
            }
        }else {
            throw new UnsupportedOperationException("Acción no implementada.");
        }
        
        contenido.validate();
        contenido.repaint();
    }
}
