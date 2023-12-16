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
            
            /**
             * Se valida si hay un cliente seleccionado
             * Se busca el o los arriendos del cliente
             * Se despliegan los arriendo encontrados
             */

            if (!(getVista().getClienteSeleccionado() != null && !getVista().getClienteSeleccionado().equals("--Seleccione Cliente--"))){
                getVista().mostrarMensaje(3, "Seleccione un cliente antes de proceder");
                getVista().vaciarCosas();
                return;
            }//if

            getVista().setLstArriendosDelCliente(ArriendoCuota.buscarArriendo(
                    Cliente.buscarCliente(getVista().getClienteSeleccionado().substring(0,10), getClientes()),
                    getModelo()));
        
        } else if (command.equals(getVista().BUSCAR_CUOTAS)){
            
            /**
             * Se valida si hay un cliente seleccionado
             * Se valida que haya un arriendo seleccionado
             * Se buscan las cuotas asociadas al arriendo seleccionado
             */
            
            if (!(getVista().getClienteSeleccionado() != null && !getVista().getClienteSeleccionado().equals("--Seleccione Cliente--"))){
                getVista().mostrarMensaje(3, "Seleccione un cliente antes de proceder");
                getVista().vaciarCosas();
                return;
            }//if
            
            if (getVista().getArriendoSeleccionado() == null){
                getVista().mostrarMensaje(3, "Seleccione un arriendo antes de proceder");
                getVista().setLstCuotasPorPagar(null);
                return;
            }//if
            
            //Se buscan las cuotas y se traspasan
//            ArriendoCuota arriendoEncontrado = ArriendoCuota.buscarArriendo(
//                    Cliente.buscarCliente(getVista().getClienteSeleccionado().substring(0,10), getClientes()),
//                   Vehiculo.buscarVehiculo(getVista().getArriendoSeleccionado().substring(0, 8), getVehiculos()),
//                  getModelo());
            
            String numID = getVista().getArriendoSeleccionado();
            String[] trozos = numID.split(":");
            if (trozos.length == 0){
                getVista().mostrarMensaje(3, "Hubo un problema con la búsqueda del arriendo y sus cuotas");
                return;
            }
            
            ArriendoCuota arriendoEncontrado = ArriendoCuota.buscarArriendo(Integer.parseInt(trozos[0]), getModelo());
            
            if (arriendoEncontrado != null){
                getVista().setLstCuotasPorPagar(arriendoEncontrado.getCuotas());
            }//if
            
        } else if (command.equals(getVista().PAGAR_CUOTAS_SELECCIONADAS)){
            
            /**
             * Se valida que haya un cliente seleccionado
             * Se valida que haya un arriendo seleccionado
             * Se valida si hay cuotas seleccionadas
             * 
             * Luego, se verifica que el cliente y el arriendo existan.
             * Se extrae el arriendo y las cuotas asociadas
             * Se marcan como pagadas las cuotas en cuestión
             */
            
            if (!(getVista().getClienteSeleccionado() != null && !getVista().getClienteSeleccionado().equals("--Seleccione Cliente--"))){
                getVista().mostrarMensaje(3, "Seleccione un cliente antes de proceder");
                getVista().vaciarCosas();
                return;
            }//if
            
            if (getVista().getArriendoSeleccionado() == null){
                getVista().mostrarMensaje(3, "Seleccione un arriendo antes de proceder");
                getVista().setLstCuotasPorPagar(null);
                return;
            }//if
            
            if (getVista().getCuotasSeleccionadas() == null){
                getVista().mostrarMensaje(3, "Seleccione al menos una cuota antes de proceder");
                return;
            }
            
            //Se buscan las cuotas y se traspasan
            String numID = getVista().getArriendoSeleccionado();
            String[] trozos = numID.split(":");
            if (trozos.length == 0){
                getVista().mostrarMensaje(3, "Hubo un problema con la búsqueda del arriendo y sus cuotas");
                return;
            }
            
            ArriendoCuota arriendoEncontrado = ArriendoCuota.buscarArriendo(Integer.parseInt(trozos[0]), getModelo());
            
            if (arriendoEncontrado == null){
                getVista().mostrarMensaje(3, "Hubo un problema con la búsqueda del arriendo");
               return;
            }//if
             
            ArrayList<String> cuotasSeleccionadas = getVista().getCuotasSeleccionadas();

            if (cuotasSeleccionadas.size() > 0){
                
                if (getVista().mostrarMensaje(2, "¿Está seguro de realizar esta operación?") == 0){
                    //Ciclo para recorrer las cuotas seleccionadas
                    for (int i=0; i < cuotasSeleccionadas.size(); i++){
                        String[] idArriendo = cuotasSeleccionadas.get(i).split(":");
                        if (trozos.length == 0){
                            getVista().mostrarMensaje(3, "Hubo un problema al procesar las cuotas seleccionadas para pagarlas");
                            return;
                        }//if

                        //Ciclo para recorrer las cuotas 
                        for (int j=0; j < arriendoEncontrado.getCuotas().size(); j++){
                            //Se compara el id de la cuota seleccionada
                            if (arriendoEncontrado.getCuotas().get(j).getNumCuota() == Integer.parseInt(idArriendo[0])){
                                //Si es encontrada se marca como pagada si es que no lo estaba ya de antes
                                if (!arriendoEncontrado.getCuotas().get(j).isPagada()){
                                    arriendoEncontrado.getCuotas().get(j).setPagada(true);
                                    //Se sale de este ciclo
                                    break;
                                }//if
                            }//if
                        }//for
                    }//for

                    //Ahora que se han pagado todas las cuotas, se debe de volver a refrescar la lista de cuotas
                    getVista().setLstCuotasPorPagar(arriendoEncontrado.getCuotas());
            
                    //Se le notifica al usuario
                    getVista().mostrarMensaje(1, "Pago procesado");
                }else{
                    getVista().mostrarMensaje(0, "Operación cancelada");
                }//if
                
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
