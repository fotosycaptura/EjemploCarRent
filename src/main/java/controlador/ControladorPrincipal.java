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
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import vista.InterfazPrincipal;
import Utiles.Archivos;
import java.awt.GridBagLayout;

/**
 *
 * @author Tom
 */
public class ControladorPrincipal implements ActionListener {
    
    private JFrame ventana;
    private InterfazPrincipal vista;
    
    private final ControladorClientes controladorClientes = new ControladorClientes();
    private final ControladorVehiculos controladorVehiculos = new ControladorVehiculos();
    private final ControladorArriendos controladorArriendos = new ControladorArriendos();
    
    public ControladorPrincipal(JFrame ventana, InterfazPrincipal vista) {
        setVentana(ventana);
        setVista(vista);
        getVista().registrarEscuchador(this);
        
        //Carga de datos para los controladores
        //Se cargan datos de clientes
        getControladorClientes().setModelo(Archivos.LeerArchivoClientes());         
        //Se cargan datos de vehículos
        getControladorVehiculos().setModelo(Archivos.LeerArchivoVehiculos()); 
    }
    
    public void iniciar() {
        getVentana().setSize(640, 400);
        //getVentana().setLayout(new BorderLayout());
        //Para que ocupe todo el espeacio - creo -
        getVentana().setLayout(new GridBagLayout());
        getVentana().setResizable(false);
        //Para centrar en la ventana del usuario
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
            //se oculta el que esté visible
            getVista().getPanel().setVisible(false);
            //Hay que traspasar los datos de vehículos, clientes
            getControladorArriendos().setClientes(getControladorClientes().getModelo());
            getControladorArriendos().setVehiculos(getControladorVehiculos().getModelo());
            //Se despliega panel de arriendos
            contenido.add(getControladorArriendos().getVista().getPanel());
        } else if (command.equals(getVista().CLIENTES)) {
            //Se oculta el que esté visible
            getVista().getPanel().setVisible(false);
            //Se muestra el de clientes
            contenido.add(getControladorClientes().getVista().getPanel());
        } else if (command.equals(getVista().VEHICULOS)) {
            //Se oculta el panel que esté visible
            getVista().getPanel().setVisible(false);
            //Se muestra el de vehículos
            contenido.add(getControladorVehiculos().getVista().getPanel());
        } else if (command.equals(getVista().SALIR)) {
            int valor = JOptionPane.showConfirmDialog(getControladorClientes().getVista().getPanel(), "¿Está seguro que desea salir?", "Finalizar sistema", JOptionPane.OK_CANCEL_OPTION);
            if (valor == JOptionPane.OK_OPTION){
                System.out.println("Finalizando...");
            System.exit(0);
            }
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
    
    public ControladorVehiculos getControladorVehiculos() {
        return controladorVehiculos;
    }
    
    public ControladorArriendos getControladorArriendos() {
        return controladorArriendos;
    }
}
