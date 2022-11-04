package Interfaces;

import com.almendros.model.config.Conexion;
import com.almendros.model.dao.ClienteDAO;
import com.almendros.model.dao.exceptions.NonexistentEntityException;
import com.almendros.model.entity.Cliente;
import com.almendros.model.entity.DetalleVenta;
import com.almendros.model.entity.Usuario;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Coders
 */
public class ClienteCrear extends javax.swing.JFrame {

    String anterior;
    private Usuario user;

    private Conexion conexion;
    private ClienteDAO cliDao;
    
    private Cliente cliente;

    public ClienteCrear() {
        initComponents();
    }

    public ClienteCrear(Usuario user) {
        initComponents();
        this.user = user;
        this.setTitle("Almendros - Registro Cliente");
        conexion = Conexion.getConexion();
        cliDao = new ClienteDAO(conexion.getFabricaConexion());
    }

    public ClienteCrear(Usuario user, Cliente cliente) {
        initComponents();
        this.user = user;
        this.setTitle("Almendros - Registro Cliente");
        conexion = Conexion.getConexion();
        cliDao = new ClienteDAO(conexion.getFabricaConexion());
        this.cliente = cliente;
        ponerCliente();
    }
    
    public ClienteCrear(Usuario user, String volver) {
        initComponents();
        this.user = user;
        this.setTitle("Almendros - Registro Cliente");
        conexion = Conexion.getConexion();
        cliDao = new ClienteDAO(conexion.getFabricaConexion());
        anterior = volver;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vincular = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtId2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtId1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        radioCedula = new javax.swing.JRadioButton();
        radioNit = new javax.swing.JRadioButton();
        btnSave = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Identificacion (*)");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Apellidos");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Direccion");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Telefono (*)");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(218, 68, 35));
        jLabel1.setText("Datos Clientes ");

        vincular.add(radioCedula);
        radioCedula.setText("Cedula");
        radioCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCedulaActionPerformed(evt);
            }
        });

        vincular.add(radioNit);
        radioNit.setText("NIT");
        radioNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNitActionPerformed(evt);
            }
        });

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Nombre (*)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnVolver)
                                .addGap(39, 39, 39)
                                .addComponent(btnSave)
                                .addGap(37, 37, 37))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addGap(47, 47, 47)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(radioCedula)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(radioNit))
                                        .addComponent(txtId1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtApellidos))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(60, 60, 60)
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(45, 45, 45)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(167, 167, 167))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioCedula)
                    .addComponent(radioNit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtId2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(txtId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnVolver))
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ponerCliente() {
        if (this.cliente != null) {

            btnSave.setEnabled(true);
            int pos = cliente.getId().indexOf("-");

            if (this.cliente.getId().contains("-")) {

                radioNit.setSelected(true);
                radioNit.doClick();
                radioCedula.setEnabled(false);

                txtId1.setText(cliente.getId().substring(0, pos));
                txtId2.setText(cliente.getId().substring(pos + 1, cliente.getId().length()));

            } else {
                radioCedula.setSelected(true);
                radioCedula.doClick();
                radioNit.setEnabled(false);
                txtId1.setText(cliente.getId());
            }

            txtId1.setEditable(false);
            txtId2.setEditable(false);

            txtNombre.setText(cliente.getNombre());
            txtApellidos.setText(cliente.getApellidos());
            txtDireccion.setText(cliente.getDireccion());
            txtCelular.setText(cliente.getTelefono());
        }
    }

    private void limpiar() {
        txtId2.setText("");
        txtId1.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtCelular.setText("");
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (!(vincular.getSelection() == null)) {
            
            vincular.add(btnSave);

            /////// ID BEGIN (*)
            int id1;
            int id2;
            try {
                id1 = new Integer(txtId1.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Campo invalido");
                txtId1.requestFocus();
                txtId1.setSelectionColor(Color.red);
                txtId1.selectAll();
                return;
            }
            try {
                id2 = (radioCedula.isSelected()) ? 0 : new Integer(txtId2.getText());
                if (id2 < 0 || id2 > 9) {
                    JOptionPane.showMessageDialog(this, "Debe ser un número entre 0 y 9");
                    NumberFormatException e = new NumberFormatException();
                    throw e;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Campo invalido");
                txtId2.requestFocus();
                txtId2.setSelectionColor(Color.red);
                txtId2.selectAll();
                return;
            }

            /////// ID END
            String nom = txtNombre.getText(); // NOMBRE (*)
            if (nom.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo nombre es obligatorio");
                txtNombre.requestFocus();
                txtNombre.setSelectionColor(Color.red);
                txtNombre.selectAll();
                return;
            }

            String ape = txtApellidos.getText(); // APELLIDOS

            /////// DIRECCION BEGIN
            String direccion = txtDireccion.getText(); // DIRECCION            
            /////// DIRECCION END

            String phone = txtCelular.getText();
            if (phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Campo obligatorio");
                txtCelular.requestFocus();
                txtCelular.setSelectionColor(Color.red);
                txtCelular.selectAll();
                return;
            }

            String id;
            String tipoId;

            if (radioCedula.isSelected()) {
                id = String.valueOf(id1);
                tipoId = "CEDULA";
            } else {
                id = String.valueOf(id1) + "-" + String.valueOf(id2);
                tipoId = "NIT";
            }

            Cliente client = new Cliente();
            client.setId(id);
            client.setNombre(nom.toUpperCase());
            client.setApellidos(ape.toUpperCase());
            client.setDireccion(direccion.toUpperCase());
            client.setTelefono(phone);
            client.setTipoId(tipoId.toUpperCase());

            if (this.cliente == null) {
                try {
                    cliDao.create(client);
                    JOptionPane.showMessageDialog(this, "Se agregó correctamente");
                    limpiar();
                } catch (Exception e) {
                    String message = e.getMessage();
                    if (message.contains("Duplicate")) {
                        JOptionPane.showMessageDialog(this, "Ya existe un cliente registrado con ese ID");
                    } else {
                        JOptionPane.showMessageDialog(this, "Ocurrio un error al agregar, verifique los campos");
                    }
                    return;
                }
            } else {
                try {
                    client.setCodigoCliente(cliente.getCodigoCliente());
                    client.setFacturaList(cliente.getFacturaList());
                    cliDao.edit(client);
                    JOptionPane.showMessageDialog(this, "Se actualizó correctamente");
                } catch (NonexistentEntityException ex) {
                    JOptionPane.showMessageDialog(this, "No existe el cliente en la base de datos");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado");
                    ex.printStackTrace();
                }
            }

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if (anterior == null) {
            ClienteMenu window = new ClienteMenu(user);
            window.setVisible(true);
            window.setLocationRelativeTo(this);
            this.dispose();
        } else {
            Ventas window = new Ventas(user);
            window.setLocationRelativeTo(this);
            window.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_btnVolverActionPerformed

    private void radioCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCedulaActionPerformed
        if (this.cliente == null) {
            if (radioCedula.isSelected()) {
                activar(true);
                txtId2.setText("");
                txtId2.setEditable(false);
            }
        }
    }//GEN-LAST:event_radioCedulaActionPerformed

    private void radioNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNitActionPerformed

        if (this.cliente == null) {
            if (radioNit.isSelected()) {
                activar(true);
            }
        }
    }//GEN-LAST:event_radioNitActionPerformed

    private void activar(boolean param) {
        txtId2.setEditable(param);
        txtId1.setEditable(param);
        txtNombre.setEditable(param);
        txtApellidos.setEditable(param);
        txtDireccion.setEditable(param);
        txtCelular.setEditable(param);
        btnSave.setEnabled(param);
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (this.cliente == null) {
            activar(false);
        }
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(ClienteCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteCrear().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton radioCedula;
    private javax.swing.JRadioButton radioNit;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId1;
    private javax.swing.JTextField txtId2;
    private javax.swing.JTextField txtNombre;
    private javax.swing.ButtonGroup vincular;
    // End of variables declaration//GEN-END:variables
}
