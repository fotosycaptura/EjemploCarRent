/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public static int generarNumeroArriendo(ArrayList<ArriendoCuota> arriendos){
        int numeroGenerado = 1;
        if (arriendos != null && !arriendos.isEmpty()){
            for (ArriendoCuota arriendo: arriendos){
                if (arriendo.getNumero() > numeroGenerado){
                    numeroGenerado = arriendo.getNumero() + 1;
                }
            }//for
        }//if
        System.out.println(numeroGenerado);
        return numeroGenerado;
    }
    
    public static ArrayList<ArriendoCuota> agregarArriendo(ArriendoCuota arriendo, ArrayList<ArriendoCuota> arriendos){
        arriendos.add(arriendo);
        return arriendos;
    }
    
    public static GregorianCalendar ConvertFecha(String fecha) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        Date dFecha = fmt.parse(fecha);
        
        GregorianCalendar fechaConvertida = new GregorianCalendar();
        fechaConvertida.setTime(dFecha);
        return fechaConvertida;
        
    }
}
