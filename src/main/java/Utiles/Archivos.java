/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utiles;
import java.io.File;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Vehiculo;

/**
 *
 * @author xavie
 */
public class Archivos {
    /**
     * Encargado de leer el archivo de clientes.
     * Este es un archivo CSV separado por ;
     * su estructura es de cedula;nombre;vigente
     * En caso de no existir el archivo se crea la estructura de memoria (ArrayList) con datos
     * @return 
     */
    public static ArrayList<Cliente> LeerArchivoClientes(){
        //Se genera un ArrayList de clientes vacío
        ArrayList<Cliente> lineasClientes = new ArrayList<Cliente>();
        
        try {
            //Se carga el archivo en memoria
            File archivo = new File("Clientes.csv");

            // VALIDACIÓN DEL ARCHIVO
            if (!archivo.exists()) {
                throw new IllegalArgumentException("El archivo no existe.");
            }//if

            // Se lee archivo
            Scanner lector = new Scanner(archivo);
            String columnas = lector.nextLine();
            while(lector.hasNextLine()){
                String linea = lector.nextLine();
                String cortado[] = linea.split(";");
                Cliente obj = new Cliente(cortado[0], cortado[1], Boolean.valueOf(cortado[2]));
                lineasClientes.add(obj);

            }//while
            lector.close();
        }catch(Exception ex){
            lineasClientes.add(new Cliente("11111111-1", "José María", true));
            lineasClientes.add(new Cliente("22222222-2", "Jhon Smith", true));
            lineasClientes.add(new Cliente("33333333-3", "Monomario", true));
        }
        
        return lineasClientes;
    }
    
    
    /**
     * Encargado de leer el archivo de Vehiculos.
     * Este es un archivo CSV separado por ;
     * su estructura es de patente;marca;modelo;anho
     * En caso de no existir el archivo se crea la estructura de memoria (ArrayList) con datos
     * @return 
     */
    public static ArrayList<Vehiculo> LeerArchivoVehiculos(){
        //Se genera un ArrayList de clientes vacío
        ArrayList<Vehiculo> lineasVehiculos = new ArrayList<Vehiculo>();
        
        try {
            //Se carga el archivo en memoria
            File archivo = new File("Vehiculos.csv");

            // VALIDACIÓN DEL ARCHIVO
            if (!archivo.exists()) {
                throw new IllegalArgumentException("El archivo no existe.");
            }//if

            // Se lee archivo
            Scanner lector = new Scanner(archivo);
            String columnas = lector.nextLine();
            while(lector.hasNextLine()){
                String linea = lector.nextLine();
                String cortado[] = linea.split(";");
                Vehiculo obj = new Vehiculo(cortado[0], cortado[1], cortado[2], Integer.parseInt(cortado[3]));
                lineasVehiculos.add(obj);

            }//while
            lector.close();
        }catch(Exception ex){
            lineasVehiculos.add(new Vehiculo("DKXAT01", "Nissan1", "Sport 01", 2006));
            lineasVehiculos.add(new Vehiculo("DKXAT02", "Nissan2", "Sport 02", 2006));
            lineasVehiculos.add(new Vehiculo("DKXAT03", "Nissan3", "Sport 03", 2006));
        }
        
        return lineasVehiculos;
    }
    
    public static String ConvertFecha(GregorianCalendar fecha) {
         String fechaFormateada = "dd-MM-yyyy";
        try{
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
            fmt.setCalendar(fecha);

            fechaFormateada = fmt.format(fecha.getTime());
            
        }catch (Exception ex){
            System.out.println("Ocurrio un error al convertir la fecha" + ex.getMessage());
        }
        return fechaFormateada;
    }
}
