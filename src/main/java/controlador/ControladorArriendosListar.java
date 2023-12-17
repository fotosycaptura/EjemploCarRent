/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.ArriendoCuota;

import vista.InterfazArriendosListar;
import vista.VistaArriendosListar;
/**
 *
 * @author xavie
 */
public class ControladorArriendosListar implements ActionListener {
    private InterfazArriendosListar vista;
    private ArrayList<ArriendoCuota> modelo;

    public ControladorArriendosListar(vista.InterfazArriendosListar vista, ArrayList<ArriendoCuota> modelo) {
        setModelo(modelo);
        setVista(vista);
        getVista().registrarEscuchador(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        Container contenido = getVista().getPanel().getParent();
        String command = e.getActionCommand();
        
        if (command.equals(getVista().VOLVER)) {
            
            //Se remueve el panel
            contenido.remove(getVista().getPanel());
            //Se activa el panel anterior
            contenido.getComponent(contenido.getComponentCount() - 1).setVisible(true);
            
        }//if
    }
    
    /**
     * @return the vista
     */
    public InterfazArriendosListar getVista(){
        return this.vista;
    }
    
    /**
     * @param vista the vista to set
     */
    public void setVista (InterfazArriendosListar vista){
        this.vista = vista;
    }

    /**
     * @return the modelo
     */
    public ArrayList<ArriendoCuota> getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ArrayList<ArriendoCuota> modelo) {
        this.modelo = modelo;
    }
}
