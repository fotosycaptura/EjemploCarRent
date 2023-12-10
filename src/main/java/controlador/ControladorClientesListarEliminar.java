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
import vista.InterfazClientesListarEliminar;

/**
 *
 * @author xavie
 */
public class ControladorClientesListarEliminar implements ActionListener{
    private InterfazClientesListarEliminar vista;
    private ArrayList<Cliente> modelo;

    public ControladorClientesListarEliminar(InterfazClientesListarEliminar vista, ArrayList<Cliente> modelo) {
        setVista(vista);
        setModelo(modelo);
        getVista().registrarEscuchador(this);
        getVista().listarClientes(getModelo());
    }

    /**
     * @return the vista
     */
    public InterfazClientesListarEliminar getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(InterfazClientesListarEliminar vista) {
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
        else if (command.equals(getVista().ELIMINAR)){
            //Se debe de verificar que haya un elemento seleccionado antes de proceder.
            String strSeleccion = getVista().getListaClientes();
            if (strSeleccion == null){
                getVista().mostrarMensaje(1, "Debe de seleccionar un cliente del listado antes de proceder a su eliminación.");
            }else{
                int inAccion = getVista().mostrarMensaje(2, "¿Está seguro que desea eliminar al cliente?\n" + strSeleccion);
                switch (inAccion){
                    case 0:
                        //Realizar proceso de eliminación
                        getVista().mostrarMensaje(1, "Se elimina con éxito.");
                        break;
                    default:
                        getVista().mostrarMensaje(1, "No se ha realizado ninguna acción.");
                        break;
                }//switch
            }//if
        }
        else {
            throw new UnsupportedOperationException("Acción no implementada.");
        }
        
        contenido.validate();
        contenido.repaint();
    }
}
