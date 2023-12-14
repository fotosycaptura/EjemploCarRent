/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.*;
/**
 *
 * @author Tom
 */
public class Cliente {
    private String cedula;
    private String nombre;
    private boolean vigente;

    public Cliente(String cedula, String nombre, boolean vigente) {
        setCedula(cedula);
        setNombre(nombre);
        setVigente(vigente);
    }
    
    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
        //Se pide validación de cedula. largo máximo 10
        //Estilo xxxxxxxx-d
        //Donde xxxxxxxx es una parte entera y d es un número de 0 a 9 o k
        
        if (cedula != null && cedula.length() == 10){
            //Se debe de dividir en dos partes y realizar validación
            StringTokenizer stk = new StringTokenizer(cedula, "-");
            if (stk.countTokens() == 2){
                String conversor = new String(stk.nextToken());
                int rutNumerico = Integer.parseInt(conversor);
                char chrDigito = stk.nextToken().charAt(0);
                //Se valida si el digito verificaro es correcto
                if (ValidarDigitoVerificador(rutNumerico).equals(String.valueOf(chrDigito).toUpperCase())){
                    this.cedula = cedula;
                }else{
                    throw new IllegalArgumentException("Cédula de cliente inválida. Posiblemente dígito verificador no válido.");       
                }
            }else{
                throw new IllegalArgumentException("Cédula de cliente inválida. Posiblemente no se incluyó el guión");   
            }
        }else{
             throw new IllegalArgumentException("Cédula de cliente inválida. No posee el largo de 10 caracteres");
        }

    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        if (nombre != null && nombre.length() > 0){
            this.nombre = nombre;
        }else{
            throw new IllegalArgumentException("Nombre inválido. Por favor ingrese un nombre!");
        }
    }

    /**
     * @return the vigente
     */
    public boolean isVigente() {
        return vigente;
    }

    /**
     * @param vigente the vigente to set
     */
    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
    
    /**
     * Se encarga de obtener el dígito verificador de un rut.
     * Se utiliza para obtenerlo - generarlo - o para la comparación en un if
     * @param rut
     * @return 
     */
    private String ValidarDigitoVerificador(int rut)
    {
        int Digito;
        int Contador;
        int Multiplo;
        int Acumulador;
        String RutDigito;

        Contador = 2;
        Acumulador = 0;

        while (rut != 0)
        {
            Multiplo = (rut % 10) * Contador;
            Acumulador = Acumulador + Multiplo;
            rut = rut / 10;
            Contador = Contador + 1;
            if (Contador == 8)
            {
                Contador = 2;
            }
        }

        Digito = 11 - (Acumulador % 11);
        RutDigito = Integer.toString(Digito);
        if (Digito == 10)
        {
            RutDigito = "K";
        }
        if (Digito == 11)
        {
            RutDigito = "0";
        }
        return (RutDigito);
    }
    
    public static Boolean encontrarCliente(String cedula, ArrayList<Cliente> clientes){
        for (Cliente cliente: clientes){
            if (cliente.getCedula().equals(cedula)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Se encarga de eliminar a un cliente del ArrayList
     * En caso exitoso, retorna true
     * Si no, retornará false.
     * @param cedula
     * @param clientes
     * @return 
     */
    public static ArrayList<Cliente> eliminarCliente(String cedula, ArrayList<Cliente> clientes){
        
        if (!(cedula != null && cedula.length() == 10)){
            throw new IllegalArgumentException("Debe ingresar una cedula válida");
        }
        
        if (clientes == null){
            throw new IllegalArgumentException("No hay elementos para eliminar");
        }
        
        //Se realiza ciclo para buscar y eliminar al cliente en cuestión.
        int inClienteEncontrado = -1;
        for (int i=0; i < clientes.size(); i++){
            if (clientes.get(i).getCedula().equals(cedula)){
                inClienteEncontrado = i;
                break;
            }//if
        }//for
        
        if (inClienteEncontrado < 0){
            throw new IllegalArgumentException("No se encontró cliente a eliminar");
        }//if
        
        clientes.remove(inClienteEncontrado);
        return clientes;
    }
    
    public static ArrayList<Cliente> ActivarDesactivarCliente(String cedula, ArrayList<Cliente> clientes){
        
        if (!(cedula != null && cedula.length() == 10)){
            throw new IllegalArgumentException("Debe ingresar una cedula válida");
        }
        
        if (clientes == null){
            throw new IllegalArgumentException("No hay elementos para proceder");
        }
        
        //Se realiza ciclo para buscar y eliminar al cliente en cuestión.
        int inClienteEncontrado = -1;
        for (int i=0; i < clientes.size(); i++){
            if (clientes.get(i).getCedula().equals(cedula)){
                inClienteEncontrado = i;
                //Se activa o desactiva el cliente
                clientes.get(i).setVigente(!clientes.get(i).isVigente());
                break;
            }//if
        }//for
        
        if (inClienteEncontrado < 0){
            throw new IllegalArgumentException("No se encontró cliente a eliminar");
        }//if
        
        return clientes;
    }
    /**
     * Sobreescribe el método toString para desplegar valores personalizados.
     */
    @Override
    public String toString() {
        return getCedula() + " - " + getNombre();
    }

}
