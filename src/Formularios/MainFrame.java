package Formularios;

import clases.Fecha;
import clases.PQR;
import clases.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {

    private final String EMPTY_CHARACTER = "";
    
    private final String EMPTY_FIELDS_ERROR_MESSAGE = "Por favor complete todos los campos.";
    private final String ERROR_MESSAGE_TITLE = "Error";
    private final String EMPTY_ARRAY_ERROR_MESSAGE = "Listado de PQRs vacío.";
    private final String DELETE_CONFIRMATION_MESSAGE = "¿Desea eliminar todas las PQRs?";
    private final String CONFIRMATION_MESSAGE_TITLE = "Adevertencia";
    private final String EMPTY_ARRAY_INFORMATION_MESSAGE = "EL listado de PQR ha sido eliminado correctamente.";
    private final String INFORMATION_MESSAGE_TITLE= "Información";
    
    private final String NOMBRE_OBJETO_TITLE = "Responsable";
    private final String NOMBRE_DESTINO_TITLE = "Destino";
    private final String DESCRIPCION_TITLE = "Descripción";
    private final String NOMBRE_ORIGEN_TITLE = "Firma";
    private final String ESTADO_TITLE = "Estado";
    private final String FECHA_TITLE = "Fecha y hora";    
    
    private final int INT_CERO = 0;
    private final int INT_UNO = 1;
    
    private AboutFrame aboutFrame;
    private DefaultTableModel defaultTableModel;
    
    private PQR pqr;
    private int contador;
    private Vector vector;
    
    
    public MainFrame() {
        initComponents();
               
        this.aboutFrame = new AboutFrame();
        this.contador = this.INT_CERO;
        this.vector = new Vector();
        
        mostrarPQRs();
    }
    
    public boolean validarCampos() {
        boolean respuesta = true;
        if (txtNomreObjeto.getText().compareTo(this.EMPTY_CHARACTER) == this.INT_CERO
            || txtNombreDestino.getText().compareTo(this.EMPTY_CHARACTER) == this.INT_CERO
            || txtDescripcion.getText().compareTo(this.EMPTY_CHARACTER) == this.INT_CERO
            || txtNombreOrigen.getText().compareTo(this.EMPTY_CHARACTER) == this.INT_CERO) {
            respuesta = false;
        }
        return respuesta;
    }
    
    public void limpiarCampos() {
        txtNomreObjeto.setText(this.EMPTY_CHARACTER);
        txtNombreDestino.setText(this.EMPTY_CHARACTER);
        txtDescripcion.setText(this.EMPTY_CHARACTER);
        txtNombreOrigen.setText(this.EMPTY_CHARACTER);
        cbxEstado.setSelectedIndex(this.INT_CERO);
        txtNomreObjeto.requestFocus();
    }
    
    public void capturarCampos(PQR objetoPQR) {
        objetoPQR.setNombreObjeto(txtNomreObjeto.getText());
        objetoPQR.setNombreDestino(txtNombreDestino.getText());
        objetoPQR.setDescripcion(txtDescripcion.getText());
        objetoPQR.setNombreOrigen(txtNombreOrigen.getText());
        objetoPQR.setEstado(cbxEstado.getSelectedItem().toString());
        
        Fecha fecha = new Fecha();
        objetoPQR.setFecha(fecha);
    }
    
    public void agregarPQR(PQR objetoPQR) {
        if (this.vector.getTamano() == this.INT_CERO) {
            this.contador++;
            this.vector.setTamano(this.contador);
            this.vector.setPQRs(this.INT_CERO, objetoPQR);
            
            return;
        }
        
        Vector vectorTemporal = new Vector();
        vectorTemporal.setTamano(this.vector.getTamano() + this.INT_UNO);
        
        for (int i=0; i<this.vector.getTamano(); i++) {
            vectorTemporal.setPQRs(i, this.vector.getPQRs(i));
        }
        
        vectorTemporal.setPQRs(this.contador, objetoPQR);
        this.contador++;        
        this.vector = new Vector();
        this.vector.setTamano(this.contador);
        
        for (int i=0; i<vectorTemporal.getTamano(); i++) {
            this.vector.setPQRs(i, vectorTemporal.getPQRs(i));
        }        
    }
    
    public void mostrarPQRs() {
        String[] headers = {
            this.NOMBRE_OBJETO_TITLE,
            this.NOMBRE_DESTINO_TITLE,
            this.DESCRIPCION_TITLE,
            this.NOMBRE_ORIGEN_TITLE,
            this.ESTADO_TITLE,
            this.FECHA_TITLE
        };
                
        this.defaultTableModel = new DefaultTableModel(headers, this.INT_CERO);

        for (int i = 0; i < this.vector.getTamano(); i++) {            
            this.defaultTableModel.addRow( new Object[] {
                this.vector.getPQRs(i).getNombreObjeto(),
                this.vector.getPQRs(i).getNombreDestino(),
                this.vector.getPQRs(i).getDescripcion(),
                this.vector.getPQRs(i).getNombreOrigen(),
                this.vector.getPQRs(i).getEstado(),
                this.vector.getPQRs(i).getFecha().getFechaCompleta()
            });
        }

        tblPqr.setModel(defaultTableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        lblNombreObjeto = new javax.swing.JLabel();
        txtNomreObjeto = new javax.swing.JTextField();
        lblNombreDestino = new javax.swing.JLabel();
        txtNombreDestino = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblNombreOrigen = new javax.swing.JLabel();
        txtNombreOrigen = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnLimpiarCampos = new javax.swing.JButton();
        lblTituloListado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPqr = new javax.swing.JTable();
        btnBorrarPqrs = new javax.swing.JButton();
        btnAcercaDe = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        cbxEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("SIMULADOR DE PQRs");

        lblSubtitulo.setText("Por favor complete los siguientes campos");

        lblNombreObjeto.setText("Nombre persona responsable de la PQR");

        lblNombreDestino.setText("Nombre persona a quien dirige la PQR");

        lblEstado.setText("Estado de la PQR");

        lblDescripcion.setText("Descripción de la PQR");

        txtDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lblNombreOrigen.setText("Firma");

        btnAgregar.setText("Agregar PQR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnLimpiarCampos.setText("Limpiar campos");
        btnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposActionPerformed(evt);
            }
        });

        lblTituloListado.setText("LISTADO DE PQRs");

        tblPqr.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPqr);

        btnBorrarPqrs.setText("Borrar listado");
        btnBorrarPqrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPqrsActionPerformed(evt);
            }
        });

        btnAcercaDe.setText("Acerca de");
        btnAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercaDeActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Creada", "En revisión", "Atendida" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(lblTituloListado)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblSubtitulo)
                        .addGap(531, 531, 531))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBorrarPqrs, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(btnAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescripcion)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNombreOrigen)
                                    .addComponent(txtNombreOrigen)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiarCampos, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreObjeto)
                                    .addComponent(txtNomreObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNombreDestino)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNombreDestino)
                                        .addGap(15, 15, 15)))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEstado)
                                    .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreObjeto)
                    .addComponent(lblNombreDestino)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomreObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(lblNombreOrigen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTituloListado))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombreOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiarCampos)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrarPqrs)
                    .addComponent(btnAcercaDe)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercaDeActionPerformed
        this.aboutFrame.setResizable(false);
        this.aboutFrame.setLocationRelativeTo(null);
        this.aboutFrame.setAlwaysOnTop(true);
        this.aboutFrame.show();
    }//GEN-LAST:event_btnAcercaDeActionPerformed

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (!validarCampos()) {
            JOptionPane.showMessageDialog(null, this.EMPTY_FIELDS_ERROR_MESSAGE, this.ERROR_MESSAGE_TITLE, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        this.pqr = new PQR();
        capturarCampos(this.pqr);
        agregarPQR(this.pqr);
        mostrarPQRs();
        limpiarCampos();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBorrarPqrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPqrsActionPerformed
        if (this.vector.getTamano() == this.INT_CERO) {
            JOptionPane.showMessageDialog(null, this.EMPTY_ARRAY_ERROR_MESSAGE,this.ERROR_MESSAGE_TITLE, JOptionPane.ERROR_MESSAGE);
            
            return;
        }
        
        int dialogButtons = JOptionPane.YES_NO_OPTION;        
        int dialogResponse = JOptionPane.showConfirmDialog (null, this.DELETE_CONFIRMATION_MESSAGE, this.CONFIRMATION_MESSAGE_TITLE, dialogButtons, JOptionPane.WARNING_MESSAGE);              
        
        if (dialogResponse == JOptionPane.YES_OPTION){
            this.vector = new Vector();
            this.contador = this.INT_CERO;
            mostrarPQRs();

            JOptionPane.showMessageDialog(null, this.EMPTY_ARRAY_INFORMATION_MESSAGE, this.INFORMATION_MESSAGE_TITLE, JOptionPane.INFORMATION_MESSAGE);

            limpiarCampos();
        }
    }//GEN-LAST:event_btnBorrarPqrsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcercaDe;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrarPqrs;
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombreDestino;
    private javax.swing.JLabel lblNombreObjeto;
    private javax.swing.JLabel lblNombreOrigen;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloListado;
    private javax.swing.JTable tblPqr;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombreDestino;
    private javax.swing.JTextField txtNombreOrigen;
    private javax.swing.JTextField txtNomreObjeto;
    // End of variables declaration//GEN-END:variables
}
