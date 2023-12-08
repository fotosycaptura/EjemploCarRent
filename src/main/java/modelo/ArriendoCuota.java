/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author Tom
 */
public class ArriendoCuota extends Arriendo {
    private int cantCuotas;
    private ArrayList<CuotaArriendo> cuotas;

    public ArriendoCuota(int numArriendo, GregorianCalendar fecArr, int diasArriendo, Cliente cliente, Vehiculo vehiculo, int cantCuotas) {
        super(numArriendo, fecArr, diasArriendo, cliente, vehiculo);
        setCantCuotas(cantCuotas);
        asignarCuotas();
    }
    
    /**
     * @return the cantCuotas
     */
    public int getCantCuotas() {
        return cantCuotas;
    }

    /**
     * @param cantCuotas the cantCuotas to set
     */
    public void setCantCuotas(int cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    /**
     * @return the cuotas
     */
    public ArrayList<CuotaArriendo> getCuotas() {
        return cuotas;
    }

    /**
     * @param cuotas the cuotas to set
     */
    public void setCuotas(ArrayList<CuotaArriendo> cuotas) {
        this.cuotas = cuotas;
    }
    
    private void asignarCuotas() {
        ArrayList<CuotaArriendo> cuotas = new ArrayList<CuotaArriendo>();
        
        for (int i = 0; i < getCantCuotas(); i++) {
            cuotas.add(new CuotaArriendo(i + 1, 0, false));
        }
        
        setCuotas(cuotas);
    }
}
