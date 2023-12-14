/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author xavie
 */
public class VistaArriendos extends javax.swing.JPanel implements InterfazArriendos {

    /**
     * Creates new form VistaArriendos
     */
    public VistaArriendos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnListar = new javax.swing.JButton();
        btnArrendar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        btnListar.setText("Listar Arriendos");

        btnArrendar.setText("Arrendar");

        btnPagar.setText("Pagar");

        btnVolver.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArrendar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(133, 133, 133))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnArrendar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArrendar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnVolver;
    // End of variables declaration//GEN-END:variables

    @Override
    public JPanel getPanel() {
        return this;
    }

    @Override
    public void registrarEscuchador(ActionListener escuchador) {
        this.btnArrendar.addActionListener(escuchador);
        this.btnArrendar.setActionCommand(ARRENDAR);
        
        this.btnListar.addActionListener(escuchador);
        this.btnListar.setActionCommand(LISTAR);
        
        this.btnPagar.addActionListener(escuchador);
        this.btnPagar.setActionCommand(PAGAR);
        
        this.btnVolver.addActionListener(escuchador);
        this.btnVolver.setActionCommand(VOLVER);
    }
    
    @Override
    public int mostrarMensaje(int tipoMensaje, String msj){
        String strTitulo = "Mensaje del sistema";
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
}