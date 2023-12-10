/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.GregorianCalendar;

/**
 *
 * @author Tom
 */
public class Arriendo {
    private int numArriendo;
    private GregorianCalendar fecArr;
    private int diasArriendo;
    private Cliente cliente;
    private Vehiculo vehiculo;
    
    public Arriendo(int numArriendo, GregorianCalendar fecArr, int diasArriendo, Cliente cliente, Vehiculo vehiculo) {
        setNumArriendo(numArriendo);
        setFecArr(fecArr);
        setDiasArriendo(diasArriendo);
        setCliente(cliente);
        setVehiculo(vehiculo);
    }

    /**
     * @return the numArriendo
     */
    public int getNumArriendo() {
        return numArriendo;
    }

    /**
     * @param numArriendo the numArriendo to set
     */
    public void setNumArriendo(int numArriendo) {
        if (numArriendo <= 0){
            throw new IllegalArgumentException("Número de arriendo inválido.");
        }
        this.numArriendo = numArriendo;
    }

    /**
     * @return the fecArr
     */
    public GregorianCalendar getFecArr() {
        return fecArr;
    }

    /**
     * @param fecArr the fecArr to set
     */
    public void setFecArr(GregorianCalendar fecArr) {
        this.fecArr = fecArr;
    }

    /**
     * @return the diasArriendo
     */
    public int getDiasArriendo() {
        return diasArriendo;
    }

    /**
     * @param diasArriendo the diasArriendo to set
     */
    public void setDiasArriendo(int diasArriendo) {
        this.diasArriendo = diasArriendo;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
}
