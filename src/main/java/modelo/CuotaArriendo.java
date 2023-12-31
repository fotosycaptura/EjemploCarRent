/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Tom
 */
public class CuotaArriendo {
    private int numCuota;
    private int valorCouta;
    private boolean pagada;
    
    public CuotaArriendo(int numCuota, int valorCouta, boolean pagada) {
        setNumCuota(numCuota);
        setValorCouta(valorCouta);
        setPagada(pagada);
    }

    /**
     * @return the numCuota
     */
    public int getNumCuota() {
        return numCuota;
    }

    /**
     * @param numCuota the numCuota to set
     */
    public void setNumCuota(int numCuota) {
        if (numCuota <= 0){
            throw new IllegalArgumentException("El número de cuota debe de ser mayor o igual que 1.");
        }
        
        this.numCuota = numCuota;
    }

    /**
     * @return the valorCouta
     */
    public int getValorCouta() {
        return valorCouta;
    }

    /**
     * @param valorCouta the valorCouta to set
     */
    public void setValorCouta(int valorCouta) {
        if (valorCouta <= 0){
            throw new IllegalArgumentException("El valor de una cuota debe de ser mayor que 0.");
        }
        
        this.valorCouta = valorCouta;
    }

    /**
     * @return the pagada
     */
    public boolean isPagada() {
        return pagada;
    }

    /**
     * @param pagada the pagada to set
     */
    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }
}
