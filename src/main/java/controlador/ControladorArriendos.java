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
import modelo.Vehiculo;
import vista.InterfazArriendos;
import vista.VistaArriendos;
/**
 *
 * @author xavie
 */
public class ControladorArriendos implements ActionListener{
    private InterfazArriendos vista = new VistaArriendos();
    private ArrayList<ArriendoCuota> modelo = new ArrayList<ArriendoCuota>();

    public ControladorArriendos() {
         getVista().registrarEscuchador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Container contenido = getVista().getPanel().getParent();
        String command = e.getActionCommand();
        
        if (command.equals(getVista().LISTAR)){
            getVista().mostrarMensaje(0, "No implementado");
        } else if (command.equals(getVista().ARRENDAR)){
            getVista().mostrarMensaje(0, "No implementado");
        } else if (command.equals(getVista().PAGAR)){
            getVista().mostrarMensaje(0, "No implementado");
        } else if (command.equals(getVista().VOLVER)) {
            contenido.remove(getVista().getPanel());
            contenido.getComponent(contenido.getComponentCount() - 1).setVisible(true);
        } else {
            getVista().mostrarMensaje(0, "No implementado");
        }
        
        contenido.validate();
        contenido.repaint();
    }

    /**
     * @return the vista
     */
    public InterfazArriendos getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(InterfazArriendos vista) {
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
