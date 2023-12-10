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
        //Verifica las acciones
        if (command.equals(getVista().VOLVER)) {
            //Se remueve el panel
            contenido.remove(getVista().getPanel());
            //Se activa el panel anterior
            contenido.getComponent(contenido.getComponentCount() - 1).setVisible(true);
        } else if (command.equals(getVista().AGREGAR)) {
            try{
                if (Cliente.encontrarCliente(getVista().getRut(), getModelo())){
                    throw new IllegalArgumentException("El usuario que intenga ingresar ya existe");
                }
                /**
                 * Toca crear un nuevo cliente.
                 * Se obtienen los datos de la vista.
                 */
                Cliente nuevoCliente = new Cliente(getVista().getRut(), getVista().getNombre(), true);
                //Se agrega al ArrayList<Cliente> del modelo
                getModelo().add(nuevoCliente);

                /**
                 * De la vista, al objeto listarClientes, se le agrega el ArrayList en este caso es Modelo.
                 * En el fondo lo que se hace acá, es colocar el listado de clientes por decirlo así, en el JScrollpane
                 */
                getVista().listarClientes(getModelo());

                //Luego de ingresar el nuevo cliente, se ha de limpiar el formulario.
                getVista().vaciarCampos();
                //Se despliega mensaje al usuario de que el cliente fue agregado.
                getVista().mostrarMensaje("¡Cliente agregado!");

                //Comenté esto para desplegar mensaje de que se agregó, por si desea agregar otro.
                //Porque si quiere salir de esta ventana, ya tiene el botón volver.
                //Se elimina el panel
                //contenido.remove(getVista().getPanel());
                //Se vuelve a mostrar el panel anterior
                //contenido.getComponent(contenido.getComponentCount() - 1).setVisible(true);
            }catch(Exception ex){
                //Se despliega el mensaje de error al usuario
                getVista().mostrarMensaje("Se produjo el siguiente error: " + ex.getMessage());
            }
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
