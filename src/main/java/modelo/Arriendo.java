/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 *
 * @author Tom
 * Modificado por integrantes del grupo 2:
 * Xavier Fuentes
 * Carlos Anch
 * Felipe González
 * Sebastian Lantadilla
 * Ivan Rojas
 */
public class Arriendo {
    private int numero; //Número del arriendo
    private GregorianCalendar fechaArriendo;
    private int dias;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private Devolucion devolucion;
    
    /**
     * Constructor
     * @param numero
     * @param fechaArriendo
     * @param dias
     * @param vehiculo
     * @param cliente 
     */
    public Arriendo(int numero, GregorianCalendar fechaArriendo, int dias, Cliente cliente, Vehiculo vehiculo) {
        setNumero(numero);
        setFechaArriendo(fechaArriendo);
        setDias(dias);
        setVehiculo(vehiculo);
        setCliente(cliente);
    }
    
    /**
     * Realiza el proceso de ingreso del arriendo.
     * Si tanto el vehículo como el cliente estén correctos, se retorna true
     * en caso contrario se lanza una exception.
     * @return 
     */
    public Boolean IngresarArriendo(){
        if (!validarArriendo()) {
            throw new IllegalArgumentException("VEHICULO Ó CLIENTE INVÁLIDOS. \nArriendo NO ingresado");
        }
        
        //La validación es correcta, por lo que se ingresa cambia el estado del vehículo a Arrendado
        vehiculo.setCondicion('A');
        System.out.println("Se realizó el ingreso del arriendo correctamente");
        
        return true;
    }
    
    /**
     * Retorna el cliente
     * @return 
     */
    public Cliente getCliente(){
        return this.cliente;
    }
    /**
     * Setea el cliente
     * @param cliente 
     */
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Valida y setea el número del arriendo.
     */
    public void setNumero(int numero) {
        if (numero > 0){
            this.numero = numero;
        }else{
            throw new IllegalArgumentException("El número no es válido, debe ser un valor positivo mayor que 0");
        }
    }

    /**
     * @return the fechaArriendo
     */
    public GregorianCalendar getFechaArriendo() {
        return fechaArriendo;
    }

    /**
     * @param fechaArriendo the fechaArriendo to set
     */
    public void setFechaArriendo(GregorianCalendar fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    /**
     * @return the dias
     */
    public int getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(int dias) {
        if (dias > 1 && dias < 10){
            this.dias = dias;
        }
        else{
            throw new IllegalArgumentException("Número de días inválidos. Debe ser mayor que 1 y menor que 10.");
        }
    }

    /**
     * @return the vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    /**
     * Valida el arriendo del vehículo
     * Valida la vigencia del cliente
     * Si vehículo está Disponible y cliente Vigente
     * Entonces se retorna true
     * En caso contrario false
     * Metodo llamado desde ingresarArriendo
     * @return 
     */
    private boolean validarArriendo() {
        
        Boolean blResultado = false;
        //Se valida que la condición del vehículo sea D y que el cliente esté vigente
        if (getVehiculo().getCondicion() == 'D' && getCliente().isVigente()) {
            blResultado = true;
        }
        
        return blResultado;
    }
    /**
     * Método encargado de generar la devolución
     * @param v
     * @param fechaDevolucion
     * @return 
     */
    public Boolean generarDevolucion(Vehiculo v, GregorianCalendar fechaDevolucion){
        //Se debe de validar la fecha de devolución que sea mayor que la fecha de arriendo
        //Se debe de validar que el vehículo a devolver corresponda al mismo con el que se inició el arriendo del mismo.
        if (v.getAnho() == vehiculo.getAnho() && v.getMarca().equals(vehiculo.getMarca()) && v.getModelo().equals(vehiculo.getModelo()) && v.getPatente().equals(vehiculo.getPatente())){
            setDevolucion(v, fechaDevolucion);
            return true;
        }else{
            return false;
        }
    }
    /**
     * Encargado de setear una instancia de Devolucion
     * Setea la condición del vehículo en Disponible
     * @param vehiculo
     * @param fechaDevolucion 
     */
    private void setDevolucion(Vehiculo vehiculo, GregorianCalendar fechaDevolucion){
        this.devolucion = new Devolucion(vehiculo, fechaDevolucion);
        //Se cambia la condición del vehículo a disponible
        vehiculo.setCondicion('D');
    }
    
    public String getDevolucion(){
        return this.devolucion.toString() + "\nCliente: " + cliente.toString();
    }
    
    /**
     * Obtiene el monto multiplicando el precio diario de arriendo por el 
     * número de días
     * @return 
     */
    private int obtenerMonto(){
        return getVehiculo().getPrecioArriendo() * getDias();
    }
    
    /**
     * Se encarga de generar el voucher o ticket en pantalla
     */
    public void generarTicketDeArriendo(){
        /*
        * Este método debe de imprimir el ticket 
        * de arriendo
        */
        for(int i=0; i < 80; i++){
            System.out.print("=");
        }
        System.out.println("");
        System.out.println("                      TICKET ARRIENDO DE VEHÍCULO");
        System.out.println("");
        System.out.println("                        Número de Arriendo: " + getNumero());
        System.out.println("                        Vehículo          : " + getVehiculo().getPatente() + " " + getVehiculo().getMarca() + " " + getVehiculo().getModelo());
        System.out.println("                        Precio Diario     : " + getVehiculo().getPrecioArriendo());
        System.out.println("");
        System.out.println("Fecha           Cliente                        Días            A Pagar");
        
        for(int i=0; i < 80; i++){
            System.out.print("-");
        }
        System.out.println("");
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        fmt.setCalendar(getFechaArriendo());
        String fechaFormateada = fmt.format(getFechaArriendo().getTime());

        //getDias() * 
        System.out.println(fechaFormateada + "      " + this.cliente.getCedula() + "/" + this.cliente.getNombre() + "       " + getDias() + " días" + "          $" + obtenerMonto());
        for(int i=0; i < 80; i++){
            System.out.print("-");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("                                                _____________");
        System.out.println("                                                Firma Cliente");
        
        for(int i=0; i < 80; i++){
            System.out.print("=");
        }
        System.out.println("");
    }
    
    
}
