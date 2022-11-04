package Interfaces;

import com.almendros.model.config.Conexion;
import com.almendros.model.dao.ClienteDAO;
import com.almendros.model.dao.DetalleVentaDAO;
import com.almendros.model.entity.DetalleVenta;
import com.almendros.model.entity.Producto;
import com.almendros.model.entity.Usuario;
import com.almendros.model.entity.Cliente;
import com.almendros.model.dao.FacturaDAO;
import com.almendros.model.dao.ProductoDAO;
import com.almendros.model.dao.TipoVentaDAO;
import com.almendros.model.dao.exceptions.NonexistentEntityException;
import com.almendros.model.entity.Factura;
import com.almendros.model.entity.TipoVenta;
import java.awt.Color;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventas extends javax.swing.JFrame {

    private Usuario user;

    Producto pro;

    String identificadores[] = new String[]{
        "ID PRODUCTO",
        "CANTIDAD",
        "DESCRIPCIÓN",
        "PRECIO UNITARIO",
        "TOTAL"
    };

    Conexion conexion;
    FacturaDAO facDao;

    ClienteDAO cliDao;
    Cliente cli;

    DefaultTableModel tableAuxi = new DefaultTableModel();

    DetalleVentaDAO detVenDao;
    List<DetalleVenta> listaVentas = new ArrayList<>();

    TipoVentaDAO tipoDao;

    Factura fac = new Factura();

    public Ventas() {
        initComponents();
    }

    public Ventas(Usuario user) {
        initComponents();
        this.user = user;
        
        this.setTitle("Almendros - Ventas");
        
        activar(false);
        conexion = Conexion.getConexion();
        facDao = new FacturaDAO(conexion.getFabricaConexion());
        detVenDao = new DetalleVentaDAO(conexion.getFabricaConexion());

        txtFacturaId.setText(facDao.autoIncrement());

        activarCamposFactura(false);
        btnVerificarCliente.setEnabled(false);
        editarCampos(false);
        editarCamposFac(false);
        txtIva.setEnabled(false);

        btnRealizarVenta.setEnabled(false);

        txtFacturaId.setEditable(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vinculoTipoFActura = new javax.swing.ButtonGroup();
        vinculoTipoID = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtAdelanto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtId1 = new javax.swing.JTextField();
        btnVerificarCliente = new javax.swing.JButton();
        txtId2 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        radioNit = new javax.swing.JRadioButton();
        radioCedula = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        btnRegistrarCliente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtFacturaId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        dateFecha = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCodPro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDescripPro = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPrecioUnitario = new javax.swing.JTextField();
        btnCargar = new javax.swing.JButton();
        btnAgregarCarrito = new javax.swing.JButton();
        lblCan = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDatos = new javax.swing.JTable();
        txtSubTotal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnRealizarVenta = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtValorIva = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        radioContado = new javax.swing.JRadioButton();
        radioCredito = new javax.swing.JRadioButton();
        btnCalcular = new javax.swing.JButton();
        radioIva = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(218, 68, 35));
        jLabel1.setText("Factura de Ventas ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Direccion");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Adelanto");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("C.C/NIT");

        btnVerificarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVerificarCliente.setText("Verificar Cliente");
        btnVerificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarClienteActionPerformed(evt);
            }
        });

        vinculoTipoID.add(radioNit);
        radioNit.setText("NIT");
        radioNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNitActionPerformed(evt);
            }
        });

        vinculoTipoID.add(radioCedula);
        radioCedula.setSelected(true);
        radioCedula.setText("Cédula");
        radioCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCedulaActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Celular");

        btnRegistrarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrarCliente.setText("Registrar Cliente");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(11, 11, 11)
                        .addComponent(txtCelular))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtId1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAdelanto)
                            .addComponent(txtDireccion))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtId2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnVerificarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(radioNit)
                                        .addGap(27, 27, 27))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(radioCedula)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVerificarCliente)
                        .addComponent(txtId2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radioNit)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(radioCedula, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtAdelanto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrarCliente))
                        .addGap(12, 12, 12))))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Factura N°");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Fecha");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFacturaId, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(dateFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFacturaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Detalles de venta");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("ID Producto");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Descripcion del Producto");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Cantidad");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Precio unitario");

        btnCargar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCargar.setText("Buscar Producto");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnAgregarCarrito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregarCarrito.setText("Agregar");
        btnAgregarCarrito.setActionCommand("Agregar ");
        btnAgregarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarritoActionPerformed(evt);
            }
        });

        lblCan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCantidad)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(49, 49, 49))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtDescripPro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarCarrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCargar)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarCarrito)
                .addGap(20, 20, 20))
        );

        btnRemove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRemove.setText("Remover");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setActionCommand("Agregar ");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Productos a Comprar");

        tableDatos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "ID", "Cantidad", "Descripcion", "Precio unitario", "Precio total"
            }
        ));
        jScrollPane1.setViewportView(tableDatos);

        txtSubTotal.setEditable(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Subtotal");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("IVA %");

        btnHome.setText("Menu Principal");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnRealizarVenta.setText("Realizar Venta");
        btnRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVentaActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Total");

        txtTotal.setEditable(false);

        txtValorIva.setEditable(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Iva");

        vinculoTipoFActura.add(radioContado);
        radioContado.setText("Contado");
        radioContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioContadoActionPerformed(evt);
            }
        });

        vinculoTipoFActura.add(radioCredito);
        radioCredito.setText("Credito");
        radioCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCreditoActionPerformed(evt);
            }
        });

        btnCalcular.setText("Calcular Total");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        radioIva.setText("Iva");
        radioIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioIvaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(244, 244, 244)
                .addComponent(radioContado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioCredito)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                        .addGap(18, 84, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnHome)
                                            .addComponent(radioIva))
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnRealizarVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel20)
                                                        .addGap(18, 18, 18))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel21)
                                                        .addGap(29, 29, 29)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtValorIva, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                                    .addComponent(txtTotal))))))))
                        .addGap(66, 66, 66)
                        .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(radioContado)
                    .addComponent(radioCredito))
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCalcular))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtValorIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(radioIva)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome)
                    .addComponent(btnRealizarVenta))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarClienteActionPerformed
        if (vinculoTipoFActura.getSelection() != null) {
            String buscar = txtId1.getText();
            String id = null;
            Integer id1 = null;
            try {
                id1 = new Integer(buscar);
                if (id1 <= 0) {
                    JOptionPane.showMessageDialog(this, "Debe ser mayor que 0");
                    txtId1.requestFocus();
                    txtId1.setSelectionColor(Color.red);
                    txtId1.selectAll();
                    return;
                }
                id = id1.toString();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Campo invalido");
                txtId1.requestFocus();
                txtId1.setSelectionColor(Color.red);
                txtId1.selectAll();
                return;
            }
            String buscar2 = txtId2.getText();
            Integer id2;
            if (radioNit.isSelected()) {
                try {
                    id2 = new Integer(buscar2);
                    if (id2 < 0 || id2 > 9) {
                        JOptionPane.showMessageDialog(this, "Este campo debe ser un número en 0 y 9");
                        txtId2.requestFocus();
                        txtId2.setSelectionColor(Color.red);
                        txtId2.selectAll();
                        return;
                    }
                    id = id1 + "-" + id2;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Campo invalido");
                    txtId2.requestFocus();
                    txtId2.setSelectionColor(Color.red);
                    txtId2.selectAll();
                    return;
                }
            }

            cliDao = new ClienteDAO(conexion.getFabricaConexion());
            cli = cliDao.findOneClienteId(id);
            if (cli == null) {
                JOptionPane.showMessageDialog(this, "No existe el cliente en la base de datos, registrelo o compruebe que los campos esten correctos");
                txtId1.requestFocus();
                txtId1.setSelectionColor(Color.red);
                txtId1.selectAll();
                limpiarCliente();
                return;
            } else {
                cargarCliente();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de factura");
        }
    }//GEN-LAST:event_btnVerificarClienteActionPerformed

    public void cargarCliente() {
        if (cli == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el cliente");
            return;
        } else {
            txtNombre.setText(cli.getNombre() + " " + cli.getApellidos());
            txtDireccion.setText(cli.getDireccion());
            txtCelular.setText(cli.getTelefono());
        }
    }

    public void limpiarCliente() {
        txtNombre.setText("");
        txtDireccion.setText("");
        txtCelular.setText("");
    }

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        pro = null;
        BuscarProducto window = new BuscarProducto(this, true, this);
        window.setLocationRelativeTo(this);
        window.setVisible(true);
        if (pro != null) {
            ponerProducto();
            activar(true);
        } else {
            limpiarProductoVenta(false);
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    public void ponerProducto() {
        txtCodPro.setText(pro.getCodigoProducto().toString());
        txtDescripPro.setText(pro.getCaracteristicas());
        lblCan.setText(String.valueOf(pro.getStock()));

        txtCodPro.setEditable(false);
        txtDescripPro.setEditable(false);
    }

    public void limpiarProductoVenta(boolean param) {
        pro = null;
        txtCodPro.setText("");
        txtDescripPro.setText("");
        lblCan.setText("");
        txtCantidad.setText("");
        txtPrecioUnitario.setText("");
        activar(param);
    }

    public void activar(boolean param) {
        txtCodPro.setEnabled(param);
        txtDescripPro.setEnabled(param);
        lblCan.setEnabled(param);
        txtCantidad.setEnabled(param);
        txtPrecioUnitario.setEnabled(param);
        btnAgregarCarrito.setEnabled(param);
    }

    public void activarCamposFactura(boolean param) {
        txtId1.setEnabled(param);
        txtId2.setEnabled(param);
        txtNombre.setEnabled(param);
        txtDireccion.setEnabled(param);
        txtCelular.setEnabled(param);
        txtAdelanto.setEnabled(param);
    }

    public void editarCampos(boolean param) {
        txtNombre.setEditable(param);
        txtDireccion.setEditable(param);
        txtCelular.setEditable(param);
    }

    private void btnAgregarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarritoActionPerformed
        if (pro == null) {
            JOptionPane.showMessageDialog(this, "Debe selecionar un producto");
        } else {
            String canText = txtCantidad.getText();
            Integer can;
            try {
                can = new Integer(canText);
                if (can <= 0 || can > pro.getStock()) {
                    JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor que 0 y menor que el stock");
                    txtCantidad.requestFocus();
                    txtCantidad.setSelectionColor(Color.RED);
                    txtCantidad.selectAll();
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Cantidad debe ser un número entero");
                txtCantidad.requestFocus();
                txtCantidad.setSelectionColor(Color.RED);
                txtCantidad.selectAll();
                return;
            }

            String preText = txtPrecioUnitario.getText();
            Double pre;
            try {
                pre = new Double(preText);
                if (pre <= 0) {
                    JOptionPane.showMessageDialog(this, "El precio debe ser mayor que 0");
                    txtPrecioUnitario.requestFocus();
                    txtPrecioUnitario.setSelectionColor(Color.RED);
                    txtPrecioUnitario.selectAll();
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Precio unitario debe ser un número");
                txtPrecioUnitario.requestFocus();
                txtPrecioUnitario.setSelectionColor(Color.RED);
                txtPrecioUnitario.selectAll();
                return;
            }

            double total = (pre * can);

            int pos = -1;
            for (DetalleVenta objeto : listaVentas) {
                if (Objects.equals(objeto.getProductoCodigo().getCodigoProducto(), pro.getCodigoProducto())) {
                    pos = 2;
                    break;
                }
            }

            if (pos == -1) {
                DetalleVenta detVen = new DetalleVenta();

                detVen.setProductoCodigo(pro);
                detVen.setPrecioUnitario(pre);
                detVen.setCantidad(can);
                detVen.setTotalVenta(total);

                listaVentas.add(detVen);

                cargarDatos(listaVentas);

            } else {

                JOptionPane.showMessageDialog(this, "Ya se había agregado el producto a la compra anteriormente");

            }

            limpiarProductoVenta(false);

        }

        pro = null;
        btnRealizarVenta.setEnabled(false);
        limpiarVenta();
    }//GEN-LAST:event_btnAgregarCarritoActionPerformed

    private void cargarDatos(List<DetalleVenta> lista) {
        tableAuxi = new DefaultTableModel();
        tableAuxi.setColumnIdentifiers(identificadores);
        for (DetalleVenta objInstancia : lista) {
            Vector<String> datos = objInstancia.convertirVector();
            tableAuxi.addRow(datos);
        }
        tableDatos.setModel(tableAuxi);
    }

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if (getFilaSeleccionada() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto");
        } else {
            listaVentas.remove(getFilaSeleccionada() - 1);
            JOptionPane.showMessageDialog(this, "Se removio satisfactoriamente");
            cargarDatos(listaVentas);
        }
        limpiarVenta();
        btnRealizarVenta.setEnabled(false);

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarProductoVenta(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVentaActionPerformed
        if (vinculoTipoFActura.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de factura");
        } else {
            if (cli != null) {
                int opc = JOptionPane.showConfirmDialog(this, "¿Desea continuar con la venta?");
                if (opc == JOptionPane.YES_OPTION) {
                    Date fecha_pago = null;
                    String estado;
                    String textoAdelanto;
                    double adelanto = 0;

                    java.util.Date utilDate = dateFecha.getDate();
                    if (utilDate == null) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar la fecha del pago");
                        dateFecha.requestFocus();
                        return;
                    }
                    fecha_pago = new Date(utilDate.getTime());
                    if (radioContado.isSelected()) {

                        estado = "Pagó";

                    } else {
                        estado = "Deudor";

                        textoAdelanto = txtAdelanto.getText();

                        if (!textoAdelanto.isEmpty()) {
                            try {
                                adelanto = Double.parseDouble(textoAdelanto);
                                if (adelanto < 0) {
                                    JOptionPane.showMessageDialog(this, "La cantidad ha adelantar debe ser mayor o igual que 0");
                                    txtAdelanto.requestFocus();
                                    return;
                                }
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(this, "Campo invalido");
                                txtAdelanto.requestFocus();
                                txtAdelanto.setSelectionColor(Color.red);
                                txtAdelanto.selectAll();
                                return;
                            }
                        } else {
                            adelanto = 0;
                        }
                    }
                    //fecha_registro;
                    if (!listaVentas.isEmpty()) {
                        String nom = cli.getNombre();
                        String ape = cli.getApellidos();
                        String nombreCliente = nom + " " + ape;

                        double sub_total = subTotal();
                        double iva = iva();
                        double total_factura = sub_total + iva;

                        tipoDao = new TipoVentaDAO(conexion.getFabricaConexion());

                        TipoVenta objetoTipo;

                        fac.setIdCliente(cli);

                        fac.setIdVendedor(user);

                        if (radioContado.isSelected()) {
                            fac.setFechaPago(fecha_pago);
                            fac.setAdelanto(total_factura);
                            objetoTipo = tipoDao.findTipoVenta(1);
                        } else {
                            if (adelanto > total_factura) {
                                JOptionPane.showMessageDialog(this, "El valor del abono debe ser menor que el valor de la factura");
                                txtAdelanto.requestFocus();
                                txtAdelanto.setSelectionColor(Color.red);
                                txtAdelanto.selectAll();
                                return;
                            }
                            fac.setAdelanto(adelanto);
                            objetoTipo = tipoDao.findTipoVenta(2);
                        }
                        fac.setIdTipo(objetoTipo);
                        fac.setNombreCliente(nombreCliente);
                        fac.setEstado(estado);

                        fac.setSubTotal(sub_total);
                        fac.setTotalFactura(total_factura);
                        fac.setIva(iva);

                        try {
                            facDao.create(fac);

                            fac = facDao.findFactura(Integer.parseInt(txtFacturaId.getText()));

                            detalleVentas(fac);

                            ventaRealizada();

                            limpiarFactura();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "Ocurrio un error al llenar la factura");
                            System.out.println(e.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No hay productos a vender");
                        return;
                    }
                }

            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar el cliente comprador");
            }
        }
    }//GEN-LAST:event_btnRealizarVentaActionPerformed

    public void limpiarFactura() {
        txtId1.setText("");
        txtId2.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtCelular.setText("");
        txtAdelanto.setText("");
        txtCodPro.setText("");
        txtCantidad.setText("");
        txtDescripPro.setText("");
        txtPrecioUnitario.setText("");
        txtIva.setText("");
        txtSubTotal.setText("");
        txtValorIva.setText("");
        txtTotal.setText("");
        lblCan.setText("");
        listaVentas = new ArrayList<>();
        cargarDatos(listaVentas);
        cli = null;
        fac = new Factura();
        txtFacturaId.setText(facDao.autoIncrement());
    }

    public void detalleVentas(Factura idFactura) {
        ProductoDAO proDao = new ProductoDAO(conexion.getFabricaConexion());
        for (DetalleVenta objVenta : listaVentas) {
            objVenta.setFacturaCodigo(idFactura);
            detVenDao.create(objVenta);

            actualizarStock(objVenta, proDao);
        }
    }

    public void actualizarStock(DetalleVenta objVenta, ProductoDAO proDao) {
        double can = objVenta.getCantidad();
        double stock = objVenta.getProductoCodigo().getStock();
        double tot = stock - can;
        Producto p = objVenta.getProductoCodigo();
        p.setStock((int) tot);
        try {
            proDao.edit(p);
        } catch (NonexistentEntityException ex) {
            System.out.println("No existe producto al actualizar stock");
        } catch (Exception ex) {
            System.out.println("Error desconocido al actualizar stock");
        }

    }

    public void ventaRealizada() {
        VentaRealizada window = new VentaRealizada(this, true);
        window.setLocationRelativeTo(this);
        window.setVisible(true);
    }

    public void limpiarVenta() {
        txtValorIva.setText("");
        txtSubTotal.setText("");
        txtTotal.setText("");
    }

    public double subTotal() {
        double sub_total = 0;
        for (DetalleVenta objetoVenta : listaVentas) {
            sub_total += objetoVenta.getTotalVenta();
        }
        return sub_total;
    }

    private double iva() {
        double iva = (double) 0;
        if (radioIva.isSelected()) {
            try {
                int textoIva = Integer.parseInt(txtIva.getText());
                if (textoIva <= 0 || textoIva > 30) {
                    JOptionPane.showMessageDialog(this, "Debe ingresar un iva valido");
                    txtIva.requestFocus();
                    txtIva.setSelectionColor(Color.red);
                    txtIva.selectAll();
                } else {
                    iva = (textoIva * subTotal()) / 100;

                    txtValorIva.setText(iva + "");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un iva valido");
                txtIva.requestFocus();
                txtIva.setSelectionColor(Color.red);
                txtIva.selectAll();

            }
        } else {
            iva = (double) 0;
        }
        return iva;
    }

    private void radioContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioContadoActionPerformed
        activarCamposFactura(true);
        txtAdelanto.setEnabled(false);
        dateFecha.setEnabled(true);

    }//GEN-LAST:event_radioContadoActionPerformed

    public void editarCamposFac(boolean param) {
        txtAdelanto.setEditable(param);
        txtId1.setEditable(param);
        txtId2.setEditable(param);
    }

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        int opc = JOptionPane.showConfirmDialog(this, "¿Seguro que desea abandonar la venta?");
        if (opc == JOptionPane.YES_OPTION) {
            MenuPrincipal ventanaPricipal = new MenuPrincipal(user);
            ventanaPricipal.setLocationRelativeTo(this);
            ventanaPricipal.setResizable(false);
            ventanaPricipal.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnHomeActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        ClienteCrear window = new ClienteCrear(user, "Regresa");
        window.setLocationRelativeTo(this);
        window.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void radioNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNitActionPerformed
        editarCamposFac(true);
        btnVerificarCliente.setEnabled(true);
    }//GEN-LAST:event_radioNitActionPerformed

    private void radioCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCedulaActionPerformed
        editarCamposFac(true);
        txtId2.setEditable(false);
        txtId2.setText("");
        btnVerificarCliente.setEnabled(true);
    }//GEN-LAST:event_radioCedulaActionPerformed

    private void radioCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCreditoActionPerformed
        activarCamposFactura(true);
    }//GEN-LAST:event_radioCreditoActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        limpiarVenta();
        double sub_total = subTotal();

        double iva = iva();
        if (radioIva.isSelected() && iva == 0) {
            return;
        }
        double total_factura = sub_total + iva;

        txtSubTotal.setText(sub_total + "");
        txtValorIva.setText(iva + "");
        txtTotal.setText(total_factura + "");

        fac.setSubTotal(sub_total);
        fac.setIva(iva);
        fac.setTotalFactura(total_factura);

        btnRealizarVenta.setEnabled(true);

    }//GEN-LAST:event_btnCalcularActionPerformed

    private void radioIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioIvaActionPerformed
        if (radioIva.isSelected()) {
            txtIva.setEnabled(true);
        } else {
            txtIva.setEnabled(false);
            txtIva.setText("");
        }
        btnRealizarVenta.setEnabled(false);
    }//GEN-LAST:event_radioIvaActionPerformed

    public int getFilaSeleccionada() {
        int pos = tableDatos.getSelectedRow();
        return (pos + 1);
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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCarrito;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRealizarVenta;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnVerificarCliente;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCan;
    private javax.swing.JRadioButton radioCedula;
    private javax.swing.JRadioButton radioContado;
    private javax.swing.JRadioButton radioCredito;
    private javax.swing.JRadioButton radioIva;
    private javax.swing.JRadioButton radioNit;
    private javax.swing.JTable tableDatos;
    private javax.swing.JTextField txtAdelanto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCodPro;
    private javax.swing.JTextField txtDescripPro;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFacturaId;
    private javax.swing.JTextField txtId1;
    private javax.swing.JTextField txtId2;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValorIva;
    private javax.swing.ButtonGroup vinculoTipoFActura;
    private javax.swing.ButtonGroup vinculoTipoID;
    // End of variables declaration//GEN-END:variables
}
