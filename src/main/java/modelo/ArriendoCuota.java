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
    
    /**
     * Genera las cuotas necesarias para el pago
     * De acuerdo al precio por día y al total de días que se arrendará
     * Se calcula el monto total y se divide por la cantidad de cuotas.
     */
    private void asignarCuotas() {
        ArrayList<CuotaArriendo> cuotas = new ArrayList<CuotaArriendo>();
        for (int i = 0; i < getCantCuotas(); i++) {
            int MontoTotal = this.getVehiculo().getPrecioArriendo() * this.getDias();
            int PrecioPorDia = MontoTotal / this.getCantCuotas();
            cuotas.add(new CuotaArriendo(i + 1, PrecioPorDia, false));
        }
        
        setCuotas(cuotas);
    }
    /**
     * Genera el número de arriendo de forma automática, por así decirlo...
     */
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
    /**
     * Agrega un arriendo nuevo al ArrayList y lo retorna
     * @param arriendo
     * @param arriendos
     * @return 
     */
    public static ArrayList<ArriendoCuota> agregarArriendo(ArriendoCuota arriendo, ArrayList<ArriendoCuota> arriendos){
        arriendo.asignarCuotas();
        arriendos.add(arriendo);
        return arriendos;
    }
    /**
     * Método para convertir la fecha de string a gregorian calendar
     * @param fecha
     * @return
     * @throws ParseException 
     */
    public static GregorianCalendar ConvertFecha(String fecha) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        Date dFecha = fmt.parse(fecha);
        
        GregorianCalendar fechaConvertida = new GregorianCalendar();
        fechaConvertida.setTime(dFecha);
        return fechaConvertida;
    }
    
    public static String ConvertFecha(GregorianCalendar fecha) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        fmt.setCalendar(fecha);
        
        String fechaFormateada = fmt.format(fecha.getTime());
        return fechaFormateada;
    }
    
    /**
     * Se encarga de obtener una fecha en string del día de hoy.
     * @return 
     */
    public static String getHoy(){
        GregorianCalendar fechaHoy = new GregorianCalendar();
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        fmt.setCalendar(fechaHoy);
        String fechaFormateada = fmt.format(fechaHoy.getTime());

        return fechaFormateada;
    }
    
    //Falta poder buscar el arriendo mediante la patente del vehículo y el cliente.
    public static ArriendoCuota buscarArriendo(Cliente cliente, Vehiculo vehiculo, ArrayList<ArriendoCuota> arriendos){
        for (ArriendoCuota arriendo: arriendos){
            if (arriendo.getCliente().getCedula().equals(cliente.getCedula()) && arriendo.getVehiculo().getPatente().equals(vehiculo.getPatente())){
                return arriendo;
            }
        }
        return null;
    }
    
    /**
     * Busca arriendos cuotas en base a la cédula del cliente
     * Retorna un ArrayList ArriendoCuota
     * @param cliente
     * @param arriendos
     * @return 
     */
    public static ArrayList<ArriendoCuota> buscarArriendo(Cliente cliente, ArrayList<ArriendoCuota> arriendos){
        
        if (cliente == null){
            throw new IllegalArgumentException("Debe de seleccionar un cliente antes de proceder.");
        }
        
        ArrayList<ArriendoCuota> lstResultados = new ArrayList<ArriendoCuota>();
        for (ArriendoCuota arriendo: arriendos){
            if (arriendo.getCliente().getCedula().equals(cliente.getCedula())){
                lstResultados.add(arriendo);
            }
        }
        return lstResultados;
    }
}
