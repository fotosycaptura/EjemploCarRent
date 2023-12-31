/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Vehiculo;
import modelo.CuotaArriendo;

/**
 *
 * @author xavie
 */
public class VistaArriendosArrendar extends javax.swing.JPanel implements InterfazArriendosArrendar {

    /**
     * Creates new form VistaArriendosArrendar
     */
    public VistaArriendosArrendar() {
        initComponents();
        this.tblCuotas.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ddlCliente = new javax.swing.JComboBox<>();
        ddlVehiculo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumCuotas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDias = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioDia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnGuardarArriendo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuotas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();

        btnVolver.setText("Volver");

        jLabel1.setText("Arriendos con cuotas");

        ddlCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ddlVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Fecha Arriendo");

        txtFecha.setColumns(10);

        jLabel3.setText("Cantidad Cuotas");

        txtNumCuotas.setColumns(2);

        jLabel4.setText("Días");

        txtDias.setColumns(2);

        jLabel5.setText("Precio por día");

        txtPrecioDia.setColumns(6);

        jLabel6.setText("Monto a Pagar");

        txtTotal.setEditable(false);
        txtTotal.setColumns(7);

        btnGuardarArriendo.setText("Guardar arriendo y mostrar cuotas >>");

        tblCuotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Número", "Valor", "¿Pagada?"
            }
        ));
        jScrollPane1.setViewportView(tblCuotas);

        jLabel7.setText("Cuotas a pagar");

        btnPagar.setText("Pagar primera cuota");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ddlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ddlVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardarArriendo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPagar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVolver)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ddlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ddlVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNumCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPrecioDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarArriendo)
                    .addComponent(btnPagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarArriendo;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> ddlCliente;
    private javax.swing.JComboBox<String> ddlVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCuotas;
    private javax.swing.JTextField txtDias;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNumCuotas;
    private javax.swing.JTextField txtPrecioDia;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public JPanel getPanel() {
        return this;
    }
    
    @Override
    public void registrarEscuchador(ActionListener escuchador) {
        this.btnVolver.addActionListener(escuchador);
        this.btnVolver.setActionCommand(VOLVER);
        this.btnGuardarArriendo.addActionListener(escuchador);
        this.btnGuardarArriendo.setActionCommand(GUARDAR_ARRIENDO);
        this.btnPagar.addActionListener(escuchador);
        this.btnPagar.setActionCommand(PAGAR_PRIMERA_CUOTA);
    }
    
    @Override
    public void vaciarCampos(){
        txtDias.setText("");
        txtFecha.setText("");
        txtNumCuotas.setText("");
        txtPrecioDia.setText("");
        txtTotal.setText("");
    }
    
    @Override
    public int mostrarMensaje(int tipoMensaje, String msj){
        String strTitulo = "Arriendo con cuotas";
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
    @Override
    public void setDllCliente(ArrayList<Cliente> clientes){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel();
        this.ddlCliente.setModel(model);
        
        model.addElement(new String("--Seleccione Cliente--"));
        for(int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);

            model.addElement(cliente.toString());
        }//for
    }
    
    @Override
    public void setDllCliente(String cedula, ArrayList<Cliente> clientes){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel();
        this.ddlCliente.setModel(model);
        
        model.addElement(new String("--Seleccione Cliente--"));
        for(int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);

            model.addElement(cliente.toString());
            
            if (cliente.getCedula().equals(cedula)){
                model.setSelectedItem(cliente.toString());
            }
        }//for
    }
    
    @Override
    public void setDllVehiculos(ArrayList<Vehiculo> vehiculos){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel();
        this.ddlVehiculo.setModel(model);
        model.addElement(new String("--Seleccione Vehículo--"));
        for(int i = 0; i < vehiculos.size(); i++) {
            Vehiculo vehiculo = vehiculos.get(i);

            model.addElement(vehiculo.toString());
        }//for
    }
    
    @Override
    public void setDllVehiculos(String patente, ArrayList<Vehiculo> vehiculos){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel();
        this.ddlVehiculo.setModel(model);
        model.addElement(new String("--Seleccione Vehículo--"));
        
        for(int i = 0; i < vehiculos.size(); i++) {
            Vehiculo vehiculo = vehiculos.get(i);
            model.addElement(vehiculo.toString());
            if (vehiculo.getPatente().equals(patente)){
                model.setSelectedItem(vehiculo.toString());
            }
        }//for
    }
    
    @Override
    public String getClienteSeleccionado(){
        if (this.ddlCliente.getSelectedIndex() == 0){
            
        }
        return this.ddlCliente.getSelectedItem().toString();
    }
    
    @Override
    public String getVehiculoSeleccionado(){
        return this.ddlVehiculo.getSelectedItem().toString();
    }
    
    @Override
    public String getFecha(){
        return this.txtFecha.getText();
    }
    
    @Override
    public String getDias(){
        return this.txtDias.getText();
    }
    
    @Override
    public String getCantidadCuotas(){
        return this.txtNumCuotas.getText();
    }
    
    @Override
    public String getPrecioArriendoPorDia(){
        return this.txtPrecioDia.getText();
    }
    
    @Override
    public void setMontoAPagar(String monto){
        this.txtTotal.setText(monto);
    }
    
    @Override
    public void setFecha(String fecha){
        this.txtFecha.setText(fecha);
    }
    
    @Override
    public void setMostrarCuotas(ArrayList<CuotaArriendo> cuotas){
        //Se establecen las cabeceras de la tabla
        Object[] header = new Object[]{"Número", "Valor", "¿Pagada?"};
        
        //Se establece un model para la tabla, para evitar la edición por celda.
        DefaultTableModel model = new DefaultTableModel(header, 0){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; 
            }
        };
        
        this.tblCuotas.setModel(model);
        
        for (int i=0; i < cuotas.size(); i++){
            model.addRow(new Object[]{cuotas.get(i).getNumCuota(), cuotas.get(i).getValorCouta(), (cuotas.get(i).isPagada() ? "Sí": "No")} );
        }//for
        this.tblCuotas.enableInputMethods(false);
    }
    
    @Override
    public void setCantidadCuotas(int NumCuotas){
        this.txtNumCuotas.setText(String.valueOf(NumCuotas));
    }
    
    @Override
    public void setDias(int NumDias){
        this.txtDias.setText(String.valueOf(NumDias));
    }
    
    @Override
    public void setPrecioPorDia(int PrecioPorDia){
        this.txtPrecioDia.setText(String.valueOf(PrecioPorDia));
    }
}
