/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
/**
 *
 * @author xavie
 * Grupo 2
 * Xavier Fuentes
 * Carlos Anch
 * Felipe González
 * Sebastian Lantadilla
 * Ivan Rojas
 */
public class Devolucion {
    private GregorianCalendar fechaDevolucion;
    private Vehiculo vehiculo;

    /**
     * Constructor
     * @param vehiculo
     * @param fechaDevolucion
     */
    public Devolucion(Vehiculo vehiculo, GregorianCalendar fechaDevolucion){
        this.vehiculo = vehiculo;
        setFechaDevolucion(fechaDevolucion);
    }
    
    /**
     * @return the fechaDevolucion
     */
    public GregorianCalendar getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * @param fechaDevolucion the fechaDevolucion to set
     */
    public void setFechaDevolucion(GregorianCalendar fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
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
     * Sobreescribe el método toString para desplegar valores personalizados.
     */
    @Override
    public String toString() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        fmt.setCalendar(getFechaDevolucion());
        String fechaFormateada = fmt.format(getFechaDevolucion().getTime());
        return "Fecha Devolución: " + fechaFormateada + "\t" +
                "Detalle del vehículo: " + getVehiculo();
    }
}
