/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Vehiculo;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author xavier.fuentes
 */
public class VistaVehiculosListar extends javax.swing.JPanel implements InterfazVehiculoListar {
    /**
     * Creates new form VistaVehiculoListar
     */
    public VistaVehiculosListar() {
        initComponents();
        //Inicializa la tabla de visualización de vehículo
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaVehiculos = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPatente = new javax.swing.JTextField();
        btnCambiar = new javax.swing.JButton();

        jLabel1.setText("Lista de Vehículos");

        listaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        listaVehiculos.setToolTipText("");
        jScrollPane1.setViewportView(listaVehiculos);

        btnVolver.setText("Volver");

        jLabel2.setText("Confirme enviar a mantención escribiendo la patente del vehículo");

        txtPatente.setColumns(8);

        btnCambiar.setText("Enviar a Mantención");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(btnVolver))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnCambiar))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiar))
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaVehiculos;
    private javax.swing.JTextField txtPatente;
    // End of variables declaration//GEN-END:variables

    @Override
    public JPanel getPanel() {
        return this;
    }
    
    @Override
    public void registrarEscuchador(ActionListener escuchador) {
        this.btnVolver.addActionListener(escuchador);
        this.btnVolver.setActionCommand(VOLVER);
        this.btnCambiar.addActionListener(escuchador);
        this.btnCambiar.setActionCommand(CAMBIARCONDICION);
    }
    
    @Override
    public int mostrarMensaje(int tipoMensaje, String msj){
        String strTitulo = "Agregar Vehículo";
        int retorno = 0;
        switch (tipoMensaje){
            case 1: //Solo informativo
                JOptionPane.showMessageDialog(this, msj, strTitulo, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2: //Si se desea eliminar
                retorno = JOptionPane.showConfirmDialog(this, msj, strTitulo, JOptionPane.OK_CANCEL_OPTION);
                break;
            case 3: //Si hay un error
                JOptionPane.showMessageDialog(this, msj, strTitulo, JOptionPane.ERROR_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Acción no implementada", strTitulo, JOptionPane.INFORMATION_MESSAGE);
        }
        return retorno;
    }
    
    /**
     * Llena con datos la JTable. Además setea la misma tabla de solo lectura las celdas
     * Y solo permite una sola selección - fila -
     * @param vehiculos 
     */
    @Override
    public void listarVehiculos(ArrayList<Vehiculo> vehiculos){
        //Se establecen las cabeceras de la tabla
        Object[] header = new Object[]{"Patente", "Marca", "Modelo", "Año", "Condición", "Precio Arriendo"};
        
        //Se establece un model para la tabla, para evitar la edición por celda.
        DefaultTableModel model = new DefaultTableModel(header, 0){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; 
            }
        };
        this.listaVehiculos.setModel(model);

        //Se llena la JTable con los datos de los vehículos
        for(int i = 0; i < vehiculos.size(); i++) {
            Vehiculo vehiculo = vehiculos.get(i);
            model.addRow(new Object[] {vehiculo.getPatente(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getAnho(), vehiculo.getCondicion(), vehiculo.getPrecioArriendo()});
        }//for
        
        //Seteo como no editable cada una de las celdas.
        for (int i = 0; i < listaVehiculos.getRowCount(); i++) {
            listaVehiculos.changeSelection(i, 1, false, false);
        }//for
        
        //Seteo como no editable por columna
        listaVehiculos.setColumnSelectionAllowed(false);
        
        //Solo permito una sola selección de la JTable
        listaVehiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    @Override
    public String getPatente(){
        return this.txtPatente.getText();
    }
}
