/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Tom
 * Clase entregada para trabajar en ella por el profesor
 * Modificado por integrantes del grupo 2:
 * Xavier Fuentes
 * Carlos Anch
 * Felipe González
 * Sebastian Lantadilla
 * Ivan Rojas
 */
public class Vehiculo {
    //Patente largo 8
    private String patente;
    
    //Marca string largo mayor que 0
    private String marca;
    
    //Modelo string largo mayor que 0
    private String modelo;
    
    //Valor válido 2000 en adelante
    private int anho;
    
    //Condición puede recibir tres valores: D, A, M
    //D: Disponible
    //A: Arrendado
    //M: Mantención
    private char condicion;
    
    //Precio del arriendo valor 45000 inicialmente
    private int precioArriendo;
    
    /**
     * Método constructor
     */
    public Vehiculo(String patente, String marca, String modelo, int anho) {
        //Se setean los valores por parámetro
        //Se valida y setea patente
        setPatente(patente);
        //Se valida y setea marca
        setMarca(marca);
        //Se valida y setea modelo
        setModelo(modelo);
        //Se valida y setea año
        setAnho(anho);
        //Se inicializa con D de disponible
        setCondicion('D');
        //Se setea precio del arriendo para el vehículo inicialmente de 45000
        setPrecioArriendo(45000);
    }

    /**
     * @return the patente
     */
    public String getPatente() {
        return patente;
    }

    /**
     * Se encarga de validar que el largo de la patente sea 8
     * De ser así, se asigna
     */
    public void setPatente(String patente) {
        if (patente.length() != 8) {
            throw new IllegalArgumentException("EL LARGO DE LA PATENTE DEBE SER DE 8");
        }
        
        this.patente = patente;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Se encarga de validar y setear la marca
     */
    public void setMarca(String marca) {
        if (marca != null && marca.length()> 0){
            this.marca = marca;
        }else{
            throw new IllegalArgumentException("¡Marca no puede ser nula!");
        }
        
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the anho
     */
    public int getAnho() {
        return anho;
    }

    /**
     * @param anho the anho to set
     */
    public void setAnho(int anho) {
        if (anho < 2000) {
            throw new IllegalArgumentException("EL AÑO DE FABRICACIÓN DEBE SER MAYOR O IGUAL AL AÑO 2000");
        }
        
        this.anho = anho;
    }

    /**
     * @return the condicion
     */
    public char getCondicion() {
        return condicion;
    }
    /**
     * Retorna precio del arriendo diario del vehículo
     */
    public int getPrecioArriendo(){
        return this.precioArriendo;
    }
    
    /**
    * se encarga de setear un valor para el arriendo por día
    * En el supuesto caso de que un vehículo tenga un valor diferente
    * de arriendo, es posible establecerlo acá.
    */
    public void setPrecioArriendo(int PrecioArriendo){
        if (PrecioArriendo <= 0){
            throw new IllegalArgumentException("El precio no es válido, debe ser un valor positivo mayor que 0");
        }
        
        this.precioArriendo = PrecioArriendo;
    }

    /**
     * Establece la condición para vehículo que son 
     * A de arrendado
     * D de Disponible
     * M de Mantención
     */
    public void setCondicion(char condicion) {
        if (condicion != 'A' && condicion != 'D' && condicion != 'M') {
            throw new IllegalArgumentException("LA CONDICIÓN DEL VEHÍCULO NO ES VÁLIDA");
        }
        
        this.condicion = condicion;
    }
    
    /**
    * Asigna un vehículo en mantención siempre que el vehículo siempre que
    * No se encuentre Arrendado
    */
    public void AsignarVehiculoEnMantencion(){
        if (this.condicion == 'A'){
            throw new IllegalArgumentException("No es posible enviar a mantención un vehículo arrendado");
        }

        this.condicion = 'M';
    }
    
    /**
     * Sobreescribe el método toString para desplegar valores personalizados.
     */
    @Override
    public String toString() {
        return "PATENTE: " + getPatente() + "\t" +
                "MODELO: " + getModelo() + "\t" +
                "MARCA: " + getMarca() + "\t" +
                "CONDICION: " + getCondicion();
    }
}
