/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import vista.InterfazPrincipal;

/**
 *
 * @author Tom
 */
public class ControladorPrincipal implements ActionListener {
    
    private JFrame ventana;
    private InterfazPrincipal vista;
    
    private final ControladorClientes controladorClientes = new ControladorClientes();
    
    public ControladorPrincipal(JFrame ventana, InterfazPrincipal vista) {
        setVentana(ventana);
        setVista(vista);
        getVista().registrarEscuchador(this);
    }
    
    public void iniciar() {
        getVentana().setSize(400, 400);
        getVentana().setLayout(new BorderLayout());
        getVentana().setResizable(false);
        getVentana().setLocationRelativeTo(null);
        getVentana().setDefaultCloseOperation(EXIT_ON_CLOSE);
        getVentana().add(getVista().getPanel());
        getVentana().setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Container contenido = getVista().getPanel().getParent();
        String command = e.getActionCommand();
        
        if (command.equals(getVista().ARRIENDOS)) {
            System.out.println("HAGO CLICK AL ARRIENDO");
        } else if (command.equals(getVista().CLIENTES)) {
            getVista().getPanel().setVisible(false);
            contenido.add(getControladorClientes().getVista().getPanel());
        } else if (command.equals(getVista().VEHICULOS)) {
            System.out.println("HAGO CLICK AL VEHICULOS");
        } else if (command.equals(getVista().SALIR)) {
            System.out.println("HAGO CLICK AL SALIR");
        } else {
            throw new UnsupportedOperationException("Acción no implementada.");
        }
        
        contenido.validate();
        contenido.repaint();
    }

    /**
     * @return the vista
     */
    public InterfazPrincipal getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(InterfazPrincipal vista) {
        this.vista = vista;
    }

    /**
     * @return the ventana
     */
    public JFrame getVentana() {
        return ventana;
    }

    /**
     * @param ventana the ventana to set
     */
    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }

    /**
     * @return the controladorClientes
     */
    public ControladorClientes getControladorClientes() {
        return controladorClientes;
    }
}
