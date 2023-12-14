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
import vista.InterfazArriendosArrendar;
import vista.VistaArriendosArrendar;
/**
 *
 * @author xavie
 */
public class ControladorArriendosArrendar implements ActionListener {
    private InterfazArriendosArrendar vista = new VistaArriendosArrendar();
    private ArrayList<ArriendoCuota> modelo;

    public ControladorArriendosArrendar(InterfazArriendosArrendar vista, ArrayList<ArriendoCuota> modelo) {
        setVista(vista);
        setModelo(modelo);
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
        } else {
            throw new UnsupportedOperationException("Acción no implementada.");
        }
        
        contenido.validate();
        contenido.repaint();
    }
    
    /**
     * @return the vista
     */
    public InterfazArriendosArrendar getVista() {
        return vista;
    }
    
    /**
     * @param vista the vista to set
     */
    public void setVista(InterfazArriendosArrendar vista) {
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
