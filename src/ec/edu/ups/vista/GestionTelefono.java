/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.modelo.Telefono;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Juanc
 */
public class GestionTelefono extends javax.swing.JInternalFrame {

    private List<String> operadoras;
    private ControladorUsuario controladorUsuario;
    private ControladorTelefono controladorTelefono;

    /**
     * Creates new form NewJInternalFrame
     *
     */
    public GestionTelefono(ControladorUsuario controladorUsuario, ControladorTelefono controladorTelefono) {
        this.controladorUsuario = controladorUsuario;
        this.controladorTelefono = controladorTelefono;
        initComponents();

        cargarDatosOperadoras();

        // cargarTelefonosTbl();
    }

    public void cargarDatosOperadoras() {
        operadoras = new ArrayList<>();
        operadoras.add("Movistar");
        operadoras.add("Claro");
        operadoras.add("CNT");
        operadoras.add("Tuenti");
        operadoras.add("Etapa");
        cbxCargarDatos();
    }

    public void cbxCargarDatos() {
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) cbxOperadora.getModel();
        for (String operadora : operadoras) {
            modelo.addElement(operadora);
        }
    }
    public void limpiarTabla(){
         DefaultTableModel modelo = (DefaultTableModel) tblTelefonos.getModel();
    modelo.setRowCount(0);
    }

    public void cargarTelefonosTbl() {
         DefaultTableModel modelo = (DefaultTableModel) tblTelefonos.getModel();
    modelo.setRowCount(0);
    for(Telefono telefono: controladorUsuario.ListarTelefonos()){
     Object[] rowData ={telefono.getCodigo(),telefono.getTipo(),telefono.getNumero(),telefono.getOperadora()};
     modelo.addRow(rowData);
     tblTelefonos.setModel(modelo);
    }

    }

    public void cargarSiguienteCodigo() {
        txtCodigo.setText(String.valueOf(controladorTelefono.obtenerSiguienteCodigo() + 1));
    }

    public void Limpiar() {
        txtCodigo.setText("");
        txtFormatoNumero.setValue("");
        cbxTipo.setSelectedIndex(0);
        cbxOperadora.setSelectedIndex(0);

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
        btnAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        cbxTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTelefonos = new javax.swing.JTable();
        txtFormatoNumero = new javax.swing.JFormattedTextField();
        cbxOperadora = new javax.swing.JComboBox<>();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Codigo");

        btnAgregar.setBackground(new java.awt.Color(0, 51, 255));
        btnAgregar.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Numero");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Tipo ");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Operadora");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(204, 204, 204));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCodigo.setText("0");
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar un tipo de telefono--", "Casa", "Trabajo", "Movil", "Fax Casa", "Fax Trabajo", "Localizador" }));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });

        tblTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Tipo", "Numero", "Operadora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblTelefonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelefonosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTelefonos);

        try {
            txtFormatoNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(+###) ###-###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFormatoNumero.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFormatoNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFormatoNumeroActionPerformed(evt);
            }
        });

        cbxOperadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione Operadora--" }));
        cbxOperadora.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbxOperadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOperadoraActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(51, 153, 255));
        btnActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 0, 51));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(102, 204, 255));
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxOperadora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFormatoNumero, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCodigo)
                            .addComponent(cbxTipo, 0, 230, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addGap(26, 26, 26)
                        .addComponent(btnBuscar)
                        .addGap(30, 30, 30)
                        .addComponent(btnEliminar)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFormatoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22)))
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        try {
            String item = (String) cbxTipo.getSelectedItem();
            if (item.equals("Casa")) {
                txtFormatoNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(+593)#-####-###")
                        ));
            } else if (item.equals("Movil")) {
                txtFormatoNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(+593)#-####-####")
                        ));
            } else {
                txtFormatoNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(+593)#-####-###")
                        ));
            }
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_cbxTipoActionPerformed

    private void txtFormatoNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFormatoNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFormatoNumeroActionPerformed

    private void cbxOperadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOperadoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxOperadoraActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        controladorUsuario.agregarTelefono(Integer.parseInt(txtCodigo.getText()), cbxTipo.getSelectedItem().toString().trim(), txtFormatoNumero.getText().trim(), cbxOperadora.getSelectedItem().toString().trim());
          JOptionPane.showMessageDialog(this, "Telefono agregado exitosamente");
          Limpiar();
           cargarTelefonosTbl();
        cargarSiguienteCodigo();

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        cargarSiguienteCodigo();
        cargarTelefonosTbl();
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
        controladorUsuario.actualizarTelefono(Integer.parseInt(txtCodigo.getText()), cbxTipo.getSelectedItem().toString().trim(), txtFormatoNumero.getText().trim(), cbxOperadora.getSelectedItem().toString().trim());
        JOptionPane.showMessageDialog(this, "Telefono actualizado exitosamente");
         cargarTelefonosTbl();
        //this.dispose();
        Limpiar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tblTelefonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelefonosMouseClicked
        int index = tblTelefonos.getSelectedRow();

        int codigo = (int) tblTelefonos.getValueAt(index, 0);
        String numero =""+ tblTelefonos.getValueAt(index, 1);
        String tipo = ""+tblTelefonos.getValueAt(index, 2);
        String operadora =""+ tblTelefonos.getValueAt(index, 3);
        
        
        
        txtCodigo.setText(String.valueOf(codigo));
        
        cbxTipo.setSelectedItem(tipo.trim());
        txtFormatoNumero.setValue(numero.trim());
        cbxOperadora.setSelectedItem(operadora.trim());
        
        
    }//GEN-LAST:event_tblTelefonosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
     
     int d=JOptionPane.showConfirmDialog(this, "Esta seguro de eliminar el telefono con codigo "+txtCodigo.getText());
     if(d==JOptionPane.YES_OPTION){
     controladorTelefono.eliminarTelefono(Integer.parseInt(txtCodigo.getText()));
     JOptionPane.showMessageDialog(this, "Telefono eliminado exitosamente");
     }else if(d==JOptionPane.NO_OPTION){
     cargarSiguienteCodigo();
     }
    // this.dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbxOperadora;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTelefonos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtFormatoNumero;
    // End of variables declaration//GEN-END:variables
}
