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
import vista.InterfazClientesListar;
/**
 *
 * @author xavie
 */
public class ControladorClientesListar implements ActionListener {
    private InterfazClientesListar vista;
    private ArrayList<Cliente> modelo;

    public ControladorClientesListar(InterfazClientesListar vista, ArrayList<Cliente> modelo) {
        setVista(vista);
        setModelo(modelo);
        getVista().registrarEscuchador(this);
        getVista().listarClientes(getModelo());
    }

    /**
     * @return the vista
     */
    public InterfazClientesListar getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(InterfazClientesListar vista) {
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
    
    @Override
    public void actionPerformed(ActionEvent e){
        Container contenido = getVista().getPanel().getParent();
        String command = e.getActionCommand();
        
        //Verifica las acciones
        if (command.equals(getVista().VOLVER)) {
            //Se remueve el panel
            contenido.remove(getVista().getPanel());
            //Se activa el panel anterior
            contenido.getComponent(contenido.getComponentCount() - 1).setVisible(true);
        }
        else if (command.equals(getVista().CHGESTADO)){
            //Se debe de verificar que haya un elemento seleccionado antes de proceder.
            String strSeleccion = getVista().getListaClientes();
            if (strSeleccion == null){
                getVista().mostrarMensaje(1, "Debe de seleccionar un cliente del listado antes de proceder a su cambio de estado.");
            }else{
                int inAccion = getVista().mostrarMensaje(2, "¿Está seguro que desea cambiar el estado del cliente?\n" + strSeleccion);
                switch (inAccion){
                    case 0:
                        try{
                            //Se extrae la cedula
                            String cedula = strSeleccion.substring(0, 10);
                            //Realizar proceso de cambio de estado, si es que es posible
                            setModelo(Cliente.ActivarDesactivarCliente(cedula, getModelo()));

                            //Se refresca el listado de clientes en la vista
                            getVista().listarClientes(getModelo());

                            //Se informa de la operación
                            getVista().mostrarMensaje(1, "Procesado.");
                        }catch (Exception ex){
                            getVista().mostrarMensaje(3, "Hubo un problema al realizar la operación.\n" + ex.getMessage());
                        }//trycatch
                        
                        break;
                    default:
                        getVista().mostrarMensaje(1, "No se ha realizado ninguna acción.");
                        break;
                }//switch
            }
        }
        else {
            throw new UnsupportedOperationException("Acción no implementada.");
        }
        
        contenido.validate();
        contenido.repaint();
    }
    
}
