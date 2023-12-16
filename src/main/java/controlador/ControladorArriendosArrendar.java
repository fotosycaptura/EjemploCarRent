/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import modelo.ArriendoCuota;
import vista.InterfazArriendosArrendar;
import vista.VistaArriendosArrendar;
import modelo.Vehiculo;
import modelo.Cliente;

/**
 *
 * @author xavie
 */
public class ControladorArriendosArrendar implements ActionListener {
    private InterfazArriendosArrendar vista = new VistaArriendosArrendar();
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cliente> clientes;
    private ArrayList<ArriendoCuota> modelo;

    public ControladorArriendosArrendar(InterfazArriendosArrendar vista, ArrayList<ArriendoCuota> modelo, ArrayList<Cliente> clientes, ArrayList<Vehiculo> vehiculos) {
        setVista(vista);
        setClientes(clientes);
        setVehiculos(vehiculos);
        setModelo(modelo);
        getVista().registrarEscuchador(this);
        getVista().setFecha(ArriendoCuota.getHoy());
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
        } else if (command.equals(getVista().GUARDAR_ARRIENDO)){
            try {
                //La fecha se convierte en una que se pueda manejar por el sistema
                GregorianCalendar fecha = ArriendoCuota.ConvertFecha(getVista().getFecha());
                Vehiculo vehiculoPorArrendar = Vehiculo.buscarVehiculo(getVista().getVehiculoSeleccionado().substring(0,8), vehiculos);
                if (vehiculoPorArrendar != null){
                    vehiculoPorArrendar.setPrecioArriendo(Integer.parseInt(getVista().getPrecioArriendoPorDia()));
                }//if
                //Se crea el arriendo
                ArriendoCuota nuevoArriendo = new ArriendoCuota(
                        ArriendoCuota.generarNumeroArriendo(getModelo()),
                        fecha,
                        Integer.parseInt(getVista().getDias()),
                        Cliente.buscarCliente(getVista().getClienteSeleccionado().substring(0, 10), getClientes()),
                        vehiculoPorArrendar,
                        Integer.parseInt(getVista().getCantidadCuotas())
                );
                
                //Se intenta guardar el arriendo. Si es exitoso se crea.
                //Al generarse exitoso, también internamente ya se generaron las cuotas
                nuevoArriendo.IngresarArriendo();
                
                //Se deberían de refrescar el ddl de vehículos
                getVista().setDllVehiculos(getVista().getVehiculoSeleccionado().substring(0,8), getVehiculos());
                
                //Se agrega al modelo
                setModelo(ArriendoCuota.agregarArriendo(nuevoArriendo, modelo));
                
                //Se envía el cálculo del monto el precio del arriendo total a la vista
                getVista().setMontoAPagar(String.valueOf(nuevoArriendo.obtenerMonto()));
                
                //Se debería de desplegar las cuotas generadas
                getVista().setMostrarCuotas(nuevoArriendo.getCuotas());
                
                //Se despliega mensaje al usuario
                getVista().mostrarMensaje(1, "Arriendo ingresado exitosamente");
            } catch (ParseException ex) {
                getVista().mostrarMensaje(3, "Debe ingresar una fecha en formato día, mes, año: dd-MM-yyyy");
            }catch (NumberFormatException ex) {
                getVista().mostrarMensaje(3, "Para el caso de días y cuotas, este valor debe de ser un número");
            } catch(Exception ex){
                getVista().mostrarMensaje(3, "Ocurrió un error: " + ex.getMessage());
            }//trycatch
        } else if (command.equals(getVista().PAGAR_PRIMERA_CUOTA)){
            /**
             * Se debe de obtener cliente y vehículo para proceder a buscar el arriendo
             * Porque el usuario puede ir y darle clic en ese botón sin haber buscado o arrendado algo antes.
             * Por lo que habría que en cierta forma, buscar y "cargar" ese arriendo en la vista y ahí pagar 
             * la primera cuota, si ya se encontraba pagada, habría que notificarlo.
             */
            try{
                ArriendoCuota arriendoBuscado = ArriendoCuota.buscarArriendo(
                        Cliente.buscarCliente(getVista().getClienteSeleccionado().substring(0, 10), getClientes()),
                        Vehiculo.buscarVehiculo(getVista().getVehiculoSeleccionado().substring(0,8), getVehiculos()),
                        getModelo());
                if (arriendoBuscado != null){
                    //Se encontró el arriendo
                    //Se setea cliente
                    getVista().setDllCliente(arriendoBuscado.getCliente().getCedula(), getClientes());
                    //Se setea vehículo
                    getVista().setDllVehiculos(arriendoBuscado.getVehiculo().getPatente(), getVehiculos());
                    //Se setea fecha arriendo
                    getVista().setFecha(ArriendoCuota.ConvertFecha(arriendoBuscado.getFechaArriendo()));
                    //Se setea cantidad cuotas
                    getVista().setCantidadCuotas(arriendoBuscado.getCantCuotas());
                    //Se setea días
                    getVista().setDias(arriendoBuscado.getDias());
                    //Se setea precio por día
                    getVista().setPrecioPorDia(arriendoBuscado.getVehiculo().getPrecioArriendo());
                    //Se setea el monto a pagar
                    getVista().setMontoAPagar(String.valueOf(arriendoBuscado.obtenerMonto()));
                    //Se setean las cuotas por pagar en la vista (tabla)
                    getVista().setMostrarCuotas(arriendoBuscado.getCuotas());
                    
                    //Se verifica si la primera cuota se encuentra pagada de antes o no.
                    if (!arriendoBuscado.getCuotas().getFirst().isPagada()){
                        if (getVista().mostrarMensaje(2, "¿Confirma pago primera cuota?") == 0){
                            arriendoBuscado.getCuotas().getFirst().setPagada(true);
                            //Se debe de refrescar las cuotas de la vista.(tabla)
                            getVista().setMostrarCuotas(arriendoBuscado.getCuotas());
                        }else{
                            getVista().mostrarMensaje(1, "Operación cancelada.");
                        }//if
                    }else{
                        getVista().mostrarMensaje(1, "La primera cuota ya se encontraba pagada.");
                    }//if
                }else{
                    getVista().mostrarMensaje(1, "Arriendo no encontrado para el cliente y vehículo seleccionado");
                }//if
            }catch(Exception ex){
                getVista().mostrarMensaje(3, "No se pudo completar la operación: \n" + ex.getMessage());
            }//trycatch
        } else {
            throw new UnsupportedOperationException("Acción no implementada.");
        }
        
        contenido.validate();
        contenido.repaint();
    }
    
    /**
     * @return the vista
     */
    public InterfazArriendosArrendar getVista() {
        return vista;
    }
    
    /**
     * @param vista the vista to set
     */
    public void setVista(InterfazArriendosArrendar vista) {
        this.vista = vista;
    }

    /**
     * @return the modelo
     */
    public ArrayList<ArriendoCuota> getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ArrayList<ArriendoCuota> modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the vehiculos
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * @param vehiculos the vehiculos to set
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
        getVista().setDllVehiculos(getVehiculos());
    }

    /**
     * @return the clientes
     */
    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
        getVista().setDllCliente(getClientes());
    }
}
