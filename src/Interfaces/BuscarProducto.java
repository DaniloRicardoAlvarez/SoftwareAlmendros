/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.almendros.model.config.Conexion;
import com.almendros.model.dao.CategoriaDAO;
import com.almendros.model.dao.ProductoDAO;
import com.almendros.model.entity.Categoria;
import com.almendros.model.entity.Producto;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class BuscarProducto extends javax.swing.JDialog {

    ProductoDAO proDao;
    Conexion conexion;
    
    DefaultTableModel tableAuxi;
    
    String identificadores[] = new String[] {
        "ID Producto",
        "Tipo de Madera",
        "Producto",
        "Descripción",
        "Existencia"
    };
    
    Producto pro;
    
    List<Producto> lista = new ArrayList<Producto>();
    Ventas ven;
    
    
    /**
     * Creates new form buscarProducto
     */
    public BuscarProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
     public BuscarProducto(java.awt.Frame parent, boolean modal, Ventas v) {
        super(parent, modal);
        initComponents();
        this.setTitle("Almendros - Buscar Producto");
        
        conexion = Conexion.getConexion();
        proDao = new ProductoDAO(conexion.getFabricaConexion());
        
        this.lista = proDao.findProductoEntities();
        
        this.ven = v;
        
        cargarDatos(lista);
        btnBuscar.setEnabled(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vinculo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        radioNombre = new javax.swing.JRadioButton();
        radioCodigo = new javax.swing.JRadioButton();
        radioMadera = new javax.swing.JRadioButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDatos = new javax.swing.JTable();
        btnCargarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Busqueda de Producto ");

        jLabel4.setText("Buscar ");

        vinculo.add(radioNombre);
        radioNombre.setText("Nombre");
        radioNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNombreActionPerformed(evt);
            }
        });

        vinculo.add(radioCodigo);
        radioCodigo.setText("Codigo");
        radioCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCodigoActionPerformed(evt);
            }
        });

        vinculo.add(radioMadera);
        radioMadera.setText("Tipo de Madera");
        radioMadera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMaderaActionPerformed(evt);
            }
        });

        btnBuscar.setText("Mostrar Todo");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

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
                "Id Producto", "Tipo de Madera", "Producto", "Descripcion", "Existencias"
            }
        ));
        tableDatos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableDatos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioNombre)
                                .addGap(18, 18, 18)
                                .addComponent(radioCodigo)
                                .addGap(18, 18, 18)
                                .addComponent(radioMadera)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar)))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioNombre)
                    .addComponent(radioCodigo)
                    .addComponent(radioMadera)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnCargarProducto.setText("Cargar Producto");
        btnCargarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCargarProducto)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCargarProducto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarDatos(List<Producto> lista) {
        tableAuxi = new DefaultTableModel();
        tableAuxi.setColumnIdentifiers(identificadores);
        for (Producto objProducto : lista) {
            Vector<String> datos = objProducto.convertirVector();
            tableAuxi.addRow(datos);
        }
        tableDatos.setModel(tableAuxi);
    }

    
    private void radioNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNombreActionPerformed
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_radioNombreActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String buscar = txtBuscar.getText().toUpperCase();
        if (!buscar.isEmpty()) {
            if (radioCodigo.isSelected()) {
                try {
                    Integer bus = new Integer(buscar);
                    this.lista = proDao.findProductoByCode(bus);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Si busca por código debe ingresar un número entero");
                    txtBuscar.requestFocus();
                    txtBuscar.setSelectionColor(Color.red);
                    txtBuscar.selectAll();
                    return;
                }
                
            } else if (radioMadera.isSelected()) {
                
                CategoriaDAO catDao = new CategoriaDAO(conexion.getFabricaConexion());
                
                Categoria cat = catDao.findCategoriasName(buscar);
                if (cat == null) {
                    this.lista = new ArrayList<>();
                } else {
                    this.lista = proDao.findProductoByCategoria(cat);
                }
                
            } else { // radioNombre.isSelected()
                
                this.lista = proDao.findProductoByName(buscar);
                
            }
            
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ningúna coincidencia");
            }

            cargarDatos(lista);
            
        } else {
            JOptionPane.showMessageDialog(this, "El campo de busqueda está vacio");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCargarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarProductoActionPerformed
        if (getFilaSeleccionada() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente de la tabla");
            return;
        } else {
            pro = lista.get(getFilaSeleccionada()-1);
            ven.pro = pro;
            this.dispose();
        }
    }//GEN-LAST:event_btnCargarProductoActionPerformed

    private void radioCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCodigoActionPerformed
        radioNombreActionPerformed(evt);
    }//GEN-LAST:event_radioCodigoActionPerformed

    private void radioMaderaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMaderaActionPerformed
        radioNombreActionPerformed(evt);
    }//GEN-LAST:event_radioMaderaActionPerformed

    public int getFilaSeleccionada() {
        int pos = tableDatos.getSelectedRow();
        return (pos+1);
    }
    
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
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarProducto dialog = new BuscarProducto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioCodigo;
    private javax.swing.JRadioButton radioMadera;
    private javax.swing.JRadioButton radioNombre;
    private javax.swing.JTable tableDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.ButtonGroup vinculo;
    // End of variables declaration//GEN-END:variables
}
