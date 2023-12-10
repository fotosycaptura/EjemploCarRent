/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utiles;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Cliente;

/**
 *
 * @author xavie
 */
public class Archivos {
    /**
     * Encargado de leer el archivo de clientes.
     * Este es un archivo CSV separado por ;
     * su estructura es de String cedula, String nombre, boolean vigente
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
}
