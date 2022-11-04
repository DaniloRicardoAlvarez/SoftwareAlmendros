package Interfaces;

import com.almendros.model.config.Conexion;
import com.almendros.model.dao.CategoriaDAO;
import com.almendros.model.dao.ProductoDAO;
import com.almendros.model.entity.Categoria;
import com.almendros.model.entity.Producto;
import com.almendros.model.entity.Usuario;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Coders
 */
public class ProductoNuevo extends javax.swing.JFrame {

    private Usuario user;
    Conexion conexion;
    CategoriaDAO cateDao;
    ProductoDAO proDao;
    List<Categoria> lista;
    
    Producto pro;

    public ProductoNuevo() {
        initComponents();
    }

    public ProductoNuevo(Usuario user) {
        initComponents();
        this.setTitle("Almendros - Registro Productos");
        this.user = user;
        conexion = Conexion.getConexion();
        proDao = new ProductoDAO(conexion.getFabricaConexion());

        txtIdProducto.setText(proDao.autoIncrement());

        cateDao = new CategoriaDAO(conexion.getFabricaConexion());

        lista = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripProducto = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtSelTipMad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        comboTipoMad = new javax.swing.JComboBox<>();
        btnSaveProduc = new javax.swing.JButton();
        btnCancelProduct = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtNombreMadera = new javax.swing.JTextField();
        btnCancelLumber = new javax.swing.JButton();
        btnSaveLumber = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtIdMadera = new javax.swing.JTextField();
        btnBack = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Id Producto");

        txtIdProducto.setEditable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre del Producto");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Descripcion");

        txtDescripProducto.setColumns(20);
        txtDescripProducto.setRows(5);
        jScrollPane1.setViewportView(txtDescripProducto);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Id Tipo Mad");

        txtSelTipMad.setEditable(false);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText(" Tipo de  Madera");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Stock");

        comboTipoMad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));
        comboTipoMad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoMadActionPerformed(evt);
            }
        });

        btnSaveProduc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_save_32px.png"))); // NOI18N
        btnSaveProduc.setText("Guardar");
        btnSaveProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProducActionPerformed(evt);
            }
        });

        btnCancelProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_cancel_32px.png"))); // NOI18N
        btnCancelProduct.setText("Cancelar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtStock)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSelTipMad, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomProducto)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboTipoMad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(btnSaveProduc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelProduct)
                        .addGap(67, 67, 67))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSelTipMad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTipoMad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaveProduc)
                            .addComponent(btnCancelProduct))
                        .addGap(23, 23, 23))))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(" Tipo de  Madera");

        btnCancelLumber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_cancel_32px.png"))); // NOI18N
        btnCancelLumber.setText("Cancelar");
        btnCancelLumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelLumberActionPerformed(evt);
            }
        });

        btnSaveLumber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_save_32px.png"))); // NOI18N
        btnSaveLumber.setText("Guardar");
        btnSaveLumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveLumberActionPerformed(evt);
            }
        });

        jLabel8.setText("Id Mad");

        txtIdMadera.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveLumber)
                .addGap(100, 100, 100)
                .addComponent(btnCancelLumber)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdMadera, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(txtNombreMadera, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreMadera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdMadera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveLumber)
                    .addComponent(btnCancelLumber))
                .addContainerGap())
        );

        btnBack.setText("Regresar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel10.setText("Producto");

        jLabel11.setText("Tipo de Madera");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnBack)))
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiar() {
        comboTipoMad.setSelectedIndex(0);
        txtNomProducto.setText("");
        txtDescripProducto.setText("");
        txtStock.setText("");
        txtSelTipMad.setText("");
    }
    
    private void btnSaveProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProducActionPerformed
        int pos = comboTipoMad.getSelectedIndex();

        String nom = txtNomProducto.getText();
        String descrip = txtDescripProducto.getText();
        String stock = txtStock.getText();

        int sto;
        int ca;

        if (nom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo nombre es requerido");
            txtNomProducto.requestFocus();
            txtNomProducto.setSelectionColor(Color.red);
            txtNomProducto.selectAll();
            return;
        } else if (pos == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente");
            comboTipoMad.requestFocus();
            return;
        } else {
            try {
                sto = (stock.isEmpty()) ? 0 : new Integer(stock);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Stock es incorrecto");
                return;
            }
            
            Categoria cate = lista.get(pos-1);
            
            System.out.println(cate.getTipoMadera());

            Producto producto = new Producto();
            producto.setIdCategoria(cate);
            producto.setProducto(nom.toUpperCase());
            producto.setCaracteristicas(descrip.toUpperCase());
            producto.setStock(sto);
            producto.setEstado(1);

            try {
                proDao.create(producto);
                JOptionPane.showMessageDialog(this, "Se agregó correctamente el producto");
                limpiar();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No se agregó el producto");
                return;
            }
            txtIdProducto.setText(proDao.autoIncrement());
        }
    }//GEN-LAST:event_btnSaveProducActionPerformed

    private void btnSaveLumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveLumberActionPerformed
        String nomMad = txtNombreMadera.getText().toUpperCase();
        if (nomMad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo está vacio");
            txtNombreMadera.requestFocus();
            txtNombreMadera.setSelectionColor(Color.red);
            txtNombreMadera.selectAll();
            return;
        } else {
            try {
                Categoria cate = new Categoria();
                cate.setTipoMadera(nomMad);
                cateDao.create(cate);
                JOptionPane.showMessageDialog(this, "Se agregó con exito el nuevo tipo de madera");
                txtNombreMadera.setText("");
            } catch (Exception e) {
                String message = e.getMessage();
                if (message.contains("Duplicate")) {
                    JOptionPane.showMessageDialog(this, "No es posible agregar, ese tipo de madera ya está registrado");
                    txtNombreMadera.requestFocus();
                    txtNombreMadera.setSelectionColor(Color.red);
                    txtNombreMadera.selectAll();
                }
            }
        }

        cargarCategorias();

    }//GEN-LAST:event_btnSaveLumberActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        GentionInventario window = new GentionInventario(user);
        window.setVisible(true);
        window.setLocationRelativeTo(this);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    public void cargarCategorias() {
        // Obtenemos una lista de las categorias en la DB
        lista = cateDao.findCategoriaEntities();

        // Creamos una instancia de la clase DefaultComboBoxModel para poder trabajar con los datos que se van a mostrar en el combo
        DefaultComboBoxModel datosComboCategoria = new DefaultComboBoxModel();

        datosComboCategoria.addElement("Seleccione...");

        for (Categoria instanciaCategoria : lista) {
            String dato = instanciaCategoria.getTipoMadera();
            datosComboCategoria.addElement(dato);
        }

        comboTipoMad.setModel(datosComboCategoria);

        txtIdMadera.setText(cateDao.autoIncrement());
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarCategorias();
    }//GEN-LAST:event_formWindowOpened

    private void btnCancelLumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelLumberActionPerformed
        txtNombreMadera.setText("");
    }//GEN-LAST:event_btnCancelLumberActionPerformed

    private void comboTipoMadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoMadActionPerformed
        int pos = comboTipoMad.getSelectedIndex();
        pos = (pos > 0) ?  lista.get(pos-1).getIdCategoria() : 0;
        txtSelTipMad.setText(pos + "");
    }//GEN-LAST:event_comboTipoMadActionPerformed

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
            java.util.logging.Logger.getLogger(ProductoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductoNuevo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBack;
    private javax.swing.JButton btnCancelLumber;
    private javax.swing.JButton btnCancelProduct;
    private javax.swing.JButton btnSaveLumber;
    private javax.swing.JButton btnSaveProduc;
    private javax.swing.JComboBox<String> comboTipoMad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescripProducto;
    private javax.swing.JTextField txtIdMadera;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtNomProducto;
    private javax.swing.JTextField txtNombreMadera;
    private javax.swing.JTextField txtSelTipMad;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
