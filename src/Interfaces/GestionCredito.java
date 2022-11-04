package Interfaces;

import com.almendros.model.config.Conexion;
import com.almendros.model.dao.ClienteDAO;
import com.almendros.model.dao.FacturaDAO;
import com.almendros.model.dao.exceptions.NonexistentEntityException;
import com.almendros.model.entity.Cliente;
import com.almendros.model.entity.Factura;
import com.almendros.model.entity.Usuario;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Coders
 */
public class GestionCredito extends javax.swing.JFrame {
    
    private Conexion con;
    
    private FacturaDAO facDao; 
    private ClienteDAO cliDao;

    private Usuario user;
    
    DefaultTableModel tableAuxiDatos;
    DefaultTableModel tableAuxiCreditos;

    String identificadoresDatos[] = new String[]{
        "ID",
        "Nombre",
        "Apellidos",
        "Direccion",
        "Telefono"
    };
    
    String identificadoresCreditos[] = new String[]{
        "ID Factura",
        "ID",
        "Tipo ID",
        "Nombre",
        "Estado",
        "Total",
        "Abono",
        "Deuda a Pagar"
    };

    List<Cliente> listClientes = new ArrayList<Cliente>();
    
    List<Factura> listFacturas = new ArrayList<Factura>();
    
    public GestionCredito() {
        initComponents();
    }
    
    public GestionCredito(Usuario user) {
        initComponents();
        this.user = user;
        
        this.setTitle("Almendros - Gestión de Creditos");
        
        this.con = Conexion.getConexion();
        facDao = new FacturaDAO(con.getFabricaConexion());
        cliDao = new ClienteDAO(con.getFabricaConexion());
        
        cargarClientes(listClientes);
        cargarCreditos(listFacturas);
        
        btnCancelarCredito.setEnabled(false);
    }
    
    private void cargarClientes(List<Cliente> lista) {
        tableAuxiDatos = new DefaultTableModel();
        tableAuxiDatos.setColumnIdentifiers(identificadoresDatos);
        
        for (Cliente cliObj : lista) {
            Vector<String> datos = cliObj.convertirVector();
            tableAuxiDatos.addRow(datos);
        }
        tableDatos.setModel(tableAuxiDatos);
    }
    
    private void cargarCreditos(List<Factura> lista) {
        tableAuxiCreditos = new DefaultTableModel();
        tableAuxiCreditos.setColumnIdentifiers(identificadoresCreditos);
        
        for (Factura facObj : lista) {
            Vector<String> datos = facObj.convertirVectorFactura();
            tableAuxiCreditos.addRow(datos);
        }
        tableCreditos.setModel(tableAuxiCreditos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vinculo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnMostrarTodo = new javax.swing.JButton();
        radioId = new javax.swing.JRadioButton();
        radioNombre = new javax.swing.JRadioButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDatos = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnCancelarCredito = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnMostrarCreditos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCreditos = new javax.swing.JTable();
        btnGenerarPdf = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnMostrarTodo.setText("Mostrar Todo");
        btnMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodoActionPerformed(evt);
            }
        });

        vinculo.add(radioId);
        radioId.setText("Identificacion");

        vinculo.add(radioNombre);
        radioNombre.setSelected(true);
        radioNombre.setText("Nombre");

        jLabel4.setText("Buscar ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Busqueda de Cliente ");

        tableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Identificacion", "Nombre", "Apellidos", "Direccion", "Telefono"
            }
        ));
        tableDatos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableDatos);

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_menu_32px.png"))); // NOI18N
        btnBack.setText("Volve al menu");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCancelarCredito.setText("Cancelar Credito");
        btnCancelarCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCreditoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Gestion Credito");

        btnMostrarCreditos.setText("Mostrar Creditos");
        btnMostrarCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCreditosActionPerformed(evt);
            }
        });

        jLabel1.setText("Tabla de Creditos");

        tableCreditos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Factura", "Identificacion", "Tipo de identificacion", "Nombre", "Estado", "Total", "Abono", "Deuda a Pagar"
            }
        ));
        tableCreditos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tableCreditos);

        btnGenerarPdf.setText("Generar PDF");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radioNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(btnMostrarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(110, 110, 110)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerarPdf)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMostrarCreditos)
                .addGap(118, 118, 118)
                .addComponent(btnCancelarCredito)
                .addGap(258, 258, 258))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioNombre)
                    .addComponent(btnMostrarTodo)
                    .addComponent(radioId)
                    .addComponent(btnBuscar))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnGenerarPdf))
                .addContainerGap())
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MenuPrincipal ventanaPricipal = new MenuPrincipal(user);
        ventanaPricipal.setLocationRelativeTo(this);
        ventanaPricipal.setResizable(false);
        ventanaPricipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCancelarCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCreditoActionPerformed
        if (getPosCreditos() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una factura");
        } else {
            Factura f = listFacturas.get(getPosCreditos()-1);
            if (f.getTotalFactura() == f.getAdelanto()) {
                JOptionPane.showMessageDialog(this, "Esta factura ya ha sido cancelada");
            } else {
                try {
                    
                    
                    double pag = f.getAdelanto();
                            
                    double faltaPorPagar = f.getTotalFactura() - pag;
                    double can;
                    try {
                        can = Double.parseDouble(JOptionPane.showInputDialog("Debe " + faltaPorPagar + ", ¿Cuánto va pagar?"));
                    } catch (NullPointerException ex) {
                        return;
                    }
                    
                    if (can <= 0 || can > faltaPorPagar) {
                        JOptionPane.showMessageDialog(this, "La cantidad que ingreso esta por fuera del resto que va a pagar");
                    } else {
                        
                        double ad = can + pag;
                        
                        try {
                            if (can == faltaPorPagar) {
                                f.setEstado("Pagó");
                            }
                            
                            f.setAdelanto(ad);
                            facDao.edit(f);
                            if (f.getTotalFactura() == f.getAdelanto()) {
                                JOptionPane.showMessageDialog(this, "La deuda ha sido cancelada");
                            } else {
                                JOptionPane.showMessageDialog(this, "Queda debiendo " + (f.getTotalFactura()-f.getAdelanto()));
                            }
                            cargarCreditos(listFacturas);
                        } catch (NonexistentEntityException ex) {
                            JOptionPane.showMessageDialog(this, "La factura no existe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(this, "Error inesperado, contacte con el servidor de bases de datos");
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Formato incorrecto");
                }
            }
        }
    }//GEN-LAST:event_btnCancelarCreditoActionPerformed

    private void btnMostrarCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCreditosActionPerformed
        if (getPosClientes() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente");
            listFacturas = new ArrayList<>();
            btnCancelarCredito.setEnabled(false);
        } else {
            listFacturas = listClientes.get(getPosClientes()-1).getFacturaList();
            listFacturas = convertFacturas(listFacturas);
            if (listFacturas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente");
                btnCancelarCredito.setEnabled(false);
            } else {
                btnCancelarCredito.setEnabled(true);
            }
        }
        cargarCreditos(listFacturas);
    }//GEN-LAST:event_btnMostrarCreditosActionPerformed

    private List<Factura> convertFacturas(List<Factura> lista) {
        List<Factura> l = new ArrayList<>();
        for (Factura f : lista) {
            if (f.getIdTipo().getIdTipo() == 2) {
                l.add(f);
            }
        }
        return l;
    }
    
    private List<Cliente> convertClientes(List<Cliente> lista) {
        List<Cliente> l = new ArrayList<>();
        for (Cliente c : lista) {
            boolean si = false;
            for (Factura f : c.getFacturaList()) {
                if (f.getIdTipo().getIdTipo() == 2) {
                    si = true;
                    break;
                }
            }
            if (! c.getFacturaList().isEmpty() && si == true) {
                l.add(c);
            }
        }
        return l;
    }
    
    private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
        listClientes = cliDao.findClienteEntities();
        listClientes = convertClientes(listClientes);    
        cargarClientes(listClientes);
        listFacturas = new ArrayList<>();
        cargarCreditos(listFacturas);
    }//GEN-LAST:event_btnMostrarTodoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String buscar = txtBuscar.getText().toUpperCase();
        if (! buscar.isEmpty()) {
            if (radioId.isSelected()) {
                // Buscar Por Id
                listClientes = cliDao.findClienteId(buscar);
                listClientes = convertClientes(listClientes);
            } else {
                // Buscar Por Nombre
                listClientes = cliDao.findClienteName(buscar, buscar);
                listClientes = convertClientes(listClientes);
            }
            if (listClientes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ninguna coincidencia");
            }
            cargarClientes(listClientes);
            listFacturas = new ArrayList<>();
            cargarCreditos(listFacturas);
        } else {
            JOptionPane.showMessageDialog(this, "El campo de busqueda está vacio");
            txtBuscar.requestFocus();
            txtBuscar.setSelectionColor(Color.red);
            txtBuscar.selectAll();
            return;
        }       
    }//GEN-LAST:event_btnBuscarActionPerformed

    public int getPosClientes() {
        int row = tableDatos.getSelectedRow() + 1;
        return row;
    }
    
    public int getPosCreditos() {
        int row = tableCreditos.getSelectedRow() + 1;
        return row;
    }
    
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
            java.util.logging.Logger.getLogger(GestionCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionCredito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelarCredito;
    private javax.swing.JButton btnGenerarPdf;
    private javax.swing.JButton btnMostrarCreditos;
    private javax.swing.JButton btnMostrarTodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radioId;
    private javax.swing.JRadioButton radioNombre;
    private javax.swing.JTable tableCreditos;
    private javax.swing.JTable tableDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.ButtonGroup vinculo;
    // End of variables declaration//GEN-END:variables
}
