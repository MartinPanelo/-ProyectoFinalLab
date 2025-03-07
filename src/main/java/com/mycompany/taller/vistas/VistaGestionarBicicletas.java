/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.taller.vistas;

import com.mycompany.taller.entidades.Bicicleta;
import com.mycompany.taller.entidades.Cliente;
import com.mycompany.taller.entidades.Reparacion;
import com.mycompany.taller.persistencia.BicicletaData;
import com.mycompany.taller.persistencia.ClienteData;
import com.mycompany.taller.persistencia.Conexion;
import com.mycompany.taller.persistencia.ReparacionData;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ezequ
 */
public class VistaGestionarBicicletas extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaGestionarBicicletas
     */
    Connection conexiondb = Conexion.getConexion();
    BicicletaData bData = new BicicletaData(conexiondb);
    ClienteData cData = new ClienteData(conexiondb);
    ReparacionData ReData = new ReparacionData(conexiondb);
    ArrayList<Bicicleta> listaBicicletasAlta;
    ArrayList<Bicicleta> listaBicicletasBaja;
    ArrayList<Cliente> listaDeClientesAlta;
    ArrayList<Reparacion> listaReparaciones;

    private DefaultTableModel modeloTablaBicisAlta;
    private DefaultTableModel modeloTablaBicisBaja;

    public VistaGestionarBicicletas() {
        initComponents();
        modeloTablaBicisAlta = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        modeloTablaBicisBaja = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        armarTablas();
        cargarTablas();
        JBactualizar.setEnabled(false);
        JBdarDeAlta.setEnabled(false);
        JBdarDeBaja.setEnabled(false);
        jDCalendario.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTbiciDadasDeAlta = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTBicisDadasDeBaja = new javax.swing.JTable();
        JBdarDeBaja = new javax.swing.JButton();
        JBdarDeAlta = new javax.swing.JButton();
        JLbicisDadasDeAlta = new javax.swing.JLabel();
        JLbicisDadasDeBaja = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTFparametroAFiltrar = new javax.swing.JTextField();
        jCBTipoDeFiltro = new javax.swing.JComboBox<>();
        jBTNFiltrar = new javax.swing.JButton();
        jDCalendario = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        JBactualizar = new javax.swing.JButton();
        JLnumSerie = new javax.swing.JLabel();
        JTFnumSerie = new javax.swing.JTextField();
        JLmarca = new javax.swing.JLabel();
        JTFmarca = new javax.swing.JTextField();
        JLtipo = new javax.swing.JLabel();
        JLcolor = new javax.swing.JLabel();
        JLcliente = new javax.swing.JLabel();
        JCBcliente = new javax.swing.JComboBox<>();
        JTFtipo = new javax.swing.JTextField();
        JTFcolor = new javax.swing.JTextField();
        JLnumBicicleta = new javax.swing.JLabel();
        JTFnumBicicleta = new javax.swing.JTextField();
        JLclienteActual = new javax.swing.JLabel();
        JTFclienteActual = new javax.swing.JTextField();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Gestionar Bicicletas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Constantia", 0, 16))); // NOI18N

        JTbiciDadasDeAlta.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        JTbiciDadasDeAlta.setModel(new javax.swing.table.DefaultTableModel(
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
        JTbiciDadasDeAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTbiciDadasDeAltaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTbiciDadasDeAlta);

        JTBicisDadasDeBaja.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        JTBicisDadasDeBaja.setModel(new javax.swing.table.DefaultTableModel(
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
        JTBicisDadasDeBaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTBicisDadasDeBajaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JTBicisDadasDeBajaMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(JTBicisDadasDeBaja);

        JBdarDeBaja.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JBdarDeBaja.setText("Dar de baja");
        JBdarDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBdarDeBajaActionPerformed(evt);
            }
        });

        JBdarDeAlta.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JBdarDeAlta.setText("Dar de alta");
        JBdarDeAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBdarDeAltaActionPerformed(evt);
            }
        });

        JLbicisDadasDeAlta.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JLbicisDadasDeAlta.setText("Bicicletas dadas de Alta:");

        JLbicisDadasDeBaja.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JLbicisDadasDeBaja.setText("Bicicletas dadas de Baja:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jTFparametroAFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFparametroAFiltrarActionPerformed(evt);
            }
        });

        jCBTipoDeFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dueño", "servicio", "Fecha de entrada" }));
        jCBTipoDeFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoDeFiltroActionPerformed(evt);
            }
        });

        jBTNFiltrar.setText("Filtrar");
        jBTNFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTNFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTFparametroAFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBTipoDeFiltro, 0, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBTNFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jDCalendario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFparametroAFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCBTipoDeFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBTNFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(JBdarDeBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBdarDeAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLbicisDadasDeBaja)
                    .addComponent(JLbicisDadasDeAlta)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLbicisDadasDeAlta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLbicisDadasDeBaja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBdarDeBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBdarDeAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        JBactualizar.setFont(new java.awt.Font("Constantia", 0, 24)); // NOI18N
        JBactualizar.setText("Actualizar");
        JBactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBactualizarActionPerformed(evt);
            }
        });

        JLnumSerie.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JLnumSerie.setText("Numero de serie");

        JLmarca.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JLmarca.setText("Marca");

        JLtipo.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JLtipo.setText("Tipo");

        JLcolor.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JLcolor.setText("Color");

        JLcliente.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JLcliente.setText("Cliente");

        JCBcliente.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JCBcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBclienteActionPerformed(evt);
            }
        });

        JLnumBicicleta.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JLnumBicicleta.setText("N° de Bicicleta");

        JTFnumBicicleta.setEditable(false);
        JTFnumBicicleta.setEnabled(false);

        JLclienteActual.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JLclienteActual.setText("Cliente actual");

        JTFclienteActual.setEditable(false);
        JTFclienteActual.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(JLclienteActual)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTFclienteActual))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(JLnumBicicleta)
                                .addGap(22, 22, 22)
                                .addComponent(JTFnumBicicleta))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLcliente)
                                    .addComponent(JLcolor)
                                    .addComponent(JLtipo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTFtipo)
                                    .addComponent(JTFcolor)
                                    .addComponent(JCBcliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(JLnumSerie)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTFnumSerie))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(JLmarca)
                                .addGap(18, 18, 18)
                                .addComponent(JTFmarca))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(JBactualizar)
                        .addGap(0, 66, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLnumBicicleta)
                    .addComponent(JTFnumBicicleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLnumSerie)
                    .addComponent(JTFnumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLmarca)
                    .addComponent(JTFmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLtipo)
                    .addComponent(JTFtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLcolor)
                    .addComponent(JTFcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLclienteActual)
                    .addComponent(JTFclienteActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLcliente)
                    .addComponent(JCBcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(JBactualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTbiciDadasDeAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTbiciDadasDeAltaMouseClicked
        JTBicisDadasDeBaja.clearSelection();
        JBdarDeAlta.setEnabled(false);
        JBdarDeBaja.setEnabled(true);
        JBactualizar.setEnabled(true);
        JCBcliente.setEnabled(true);

        int filaSeleccionada = JTbiciDadasDeAlta.getSelectedRow();
        JTFnumBicicleta.setText(String.valueOf(JTbiciDadasDeAlta.getValueAt(filaSeleccionada, 0)));
        JTFnumSerie.setText(String.valueOf(JTbiciDadasDeAlta.getValueAt(filaSeleccionada, 1)));
        JTFmarca.setText((String) JTbiciDadasDeAlta.getValueAt(filaSeleccionada, 2));
        JTFtipo.setText((String) JTbiciDadasDeAlta.getValueAt(filaSeleccionada, 3));
        JTFcolor.setText((String) JTbiciDadasDeAlta.getValueAt(filaSeleccionada, 4));
        JTFclienteActual.setText((String) JTbiciDadasDeAlta.getValueAt(filaSeleccionada, 5));
        listaDeClientesAlta = cData.listarClientes(false);
        for (Cliente aux : listaDeClientesAlta) {
            JCBcliente.addItem(aux);

        }
        JCBcliente.setSelectedIndex(-1);
    }//GEN-LAST:event_JTbiciDadasDeAltaMouseClicked

    private void JTBicisDadasDeBajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBicisDadasDeBajaMouseClicked
        JTbiciDadasDeAlta.clearSelection();
        JBdarDeBaja.setEnabled(false);
        JBdarDeAlta.setEnabled(true);
        JBactualizar.setEnabled(false);
        JCBcliente.setSelectedIndex(-1);
        JCBcliente.setEnabled(false);

        int filaSeleccionada = JTBicisDadasDeBaja.getSelectedRow();
        JTFnumBicicleta.setText(String.valueOf(JTBicisDadasDeBaja.getValueAt(filaSeleccionada, 0)));
        JTFnumSerie.setText(String.valueOf(JTBicisDadasDeBaja.getValueAt(filaSeleccionada, 1)));
        JTFmarca.setText((String) JTBicisDadasDeBaja.getValueAt(filaSeleccionada, 2));
        JTFtipo.setText((String) JTBicisDadasDeBaja.getValueAt(filaSeleccionada, 3));
        JTFcolor.setText((String) JTBicisDadasDeBaja.getValueAt(filaSeleccionada, 4));
        JTFclienteActual.setText((String) JTBicisDadasDeBaja.getValueAt(filaSeleccionada, 5));
    }//GEN-LAST:event_JTBicisDadasDeBajaMouseClicked

    private void JBdarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBdarDeBajaActionPerformed
        int filaSeleccionada = JTbiciDadasDeAlta.getSelectedRow();
        // Bicicleta bici = new Bicicleta();
        if (filaSeleccionada != -1) {
            //bici = bData.buscarBicicletaPorID((Integer)JTbiciDadasDeAlta.getValueAt(filaSeleccionada, 0));
            bData.darDeBajaBicicleta((Integer) JTbiciDadasDeAlta.getValueAt(filaSeleccionada, 0));
            cargarTablas();
        }

    }//GEN-LAST:event_JBdarDeBajaActionPerformed

    private void JTBicisDadasDeBajaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBicisDadasDeBajaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JTBicisDadasDeBajaMouseEntered

    private void JBdarDeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBdarDeAltaActionPerformed
        int filaSeleccionada = JTBicisDadasDeBaja.getSelectedRow();
        // Bicicleta bici = new Bicicleta();
        if (filaSeleccionada != -1) {
            //bici = bData.buscarBicicletaPorID((Integer)JTbiciDadasDeAlta.getValueAt(filaSeleccionada, 0));
            bData.darDeAltaBicicleta((Integer) JTBicisDadasDeBaja.getValueAt(filaSeleccionada, 0));
            cargarTablas();
        }
    }//GEN-LAST:event_JBdarDeAltaActionPerformed

    private void JBactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBactualizarActionPerformed
        try {
            Bicicleta b = new Bicicleta();
            int filaSeleccionada = JTbiciDadasDeAlta.getSelectedRow();

            b.setId(Integer.parseInt(JTFnumBicicleta.getText()));
            b.setNumero_serie(Long.parseLong(JTFnumSerie.getText()));
            b.setMarca(JTFmarca.getText());
            b.setTipo(JTFtipo.getText());
            b.setColor(JTFcolor.getText());

            if (JCBcliente.getSelectedIndex() == -1) {
                System.out.println(JTbiciDadasDeAlta.getValueAt(filaSeleccionada, 1).getClass());
                b.setCliente(bData.buscarBicicletaPorNroSerie((Long) JTbiciDadasDeAlta.getValueAt(filaSeleccionada, 1)).getCliente());

            } else {

                b.setCliente((Cliente) JCBcliente.getSelectedItem());
            }

            bData.actualizarBicicleta(b);
            limpiarCampos();
            JBactualizar.setEnabled(false);
            JBdarDeBaja.setEnabled(false);

            cargarTablas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Los campos estan mal seteados.");
        }


    }//GEN-LAST:event_JBactualizarActionPerformed

    private void jBTNFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTNFiltrarActionPerformed

        cargarTablas();

    }//GEN-LAST:event_jBTNFiltrarActionPerformed

    private void jTFparametroAFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFparametroAFiltrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFparametroAFiltrarActionPerformed

    private void JCBclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBclienteActionPerformed

    private void jCBTipoDeFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoDeFiltroActionPerformed
        
        if(jCBTipoDeFiltro.getSelectedIndex() == 2){
            jDCalendario.setEnabled(true);
            jTFparametroAFiltrar.setEnabled(false);
            jTFparametroAFiltrar.setText("");
        }else{
            jDCalendario.setEnabled(false);
            jDCalendario.setCalendar(null);
            jTFparametroAFiltrar.setEnabled(true);
            
        }
    }//GEN-LAST:event_jCBTipoDeFiltroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBactualizar;
    private javax.swing.JButton JBdarDeAlta;
    private javax.swing.JButton JBdarDeBaja;
    private javax.swing.JComboBox<Cliente> JCBcliente;
    private javax.swing.JLabel JLbicisDadasDeAlta;
    private javax.swing.JLabel JLbicisDadasDeBaja;
    private javax.swing.JLabel JLcliente;
    private javax.swing.JLabel JLclienteActual;
    private javax.swing.JLabel JLcolor;
    private javax.swing.JLabel JLmarca;
    private javax.swing.JLabel JLnumBicicleta;
    private javax.swing.JLabel JLnumSerie;
    private javax.swing.JLabel JLtipo;
    private javax.swing.JTable JTBicisDadasDeBaja;
    private javax.swing.JTextField JTFclienteActual;
    private javax.swing.JTextField JTFcolor;
    private javax.swing.JTextField JTFmarca;
    private javax.swing.JTextField JTFnumBicicleta;
    private javax.swing.JTextField JTFnumSerie;
    private javax.swing.JTextField JTFtipo;
    private javax.swing.JTable JTbiciDadasDeAlta;
    private javax.swing.JButton jBTNFiltrar;
    private javax.swing.JComboBox<String> jCBTipoDeFiltro;
    private com.toedter.calendar.JDateChooser jDCalendario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFparametroAFiltrar;
    // End of variables declaration//GEN-END:variables

    private void armarTablas() {
        ArrayList<Object> columnas = new ArrayList();
        columnas.add("id");
        columnas.add("N serie");
        columnas.add("Marca");
        columnas.add("Tipo");
        columnas.add("Color");
        columnas.add("Cliente");
        for (Object aux : columnas) {
            modeloTablaBicisBaja.addColumn(aux);
            modeloTablaBicisAlta.addColumn(aux);
        }
        JTbiciDadasDeAlta.setModel(modeloTablaBicisAlta);
        JTbiciDadasDeAlta.getColumnModel().getColumn(0).setMaxWidth(0);
        JTbiciDadasDeAlta.getColumnModel().getColumn(0).setMinWidth(0);
        JTbiciDadasDeAlta.getColumnModel().getColumn(0).setPreferredWidth(0);

        JTBicisDadasDeBaja.setModel(modeloTablaBicisBaja);
        JTBicisDadasDeBaja.getColumnModel().getColumn(0).setMaxWidth(0);
        JTBicisDadasDeBaja.getColumnModel().getColumn(0).setMinWidth(0);
        JTBicisDadasDeBaja.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void cargarTablas() {
        modeloTablaBicisAlta.setNumRows(0);
        modeloTablaBicisBaja.setNumRows(0);

        listaBicicletasAlta = bData.listarBicicletas(false);
        listaBicicletasBaja = bData.listarBicicletas(true);

        if (jTFparametroAFiltrar.getText().isEmpty() && jCBTipoDeFiltro.getSelectedIndex() != 2) {

            for (Bicicleta aux : listaBicicletasAlta) {
                modeloTablaBicisAlta.addRow(new Object[]{aux.getId(), aux.getNumero_serie(), aux.getMarca(), aux.getTipo(), aux.getColor(), aux.getCliente().toString()});

            }

            for (Bicicleta aux : listaBicicletasBaja) {
                modeloTablaBicisBaja.addRow(new Object[]{aux.getId(), aux.getNumero_serie(), aux.getMarca(), aux.getTipo(), aux.getColor(), aux.getCliente().toString()});
            }

        } else if (jCBTipoDeFiltro.getSelectedIndex() == 0) { // filtro por Dueño

            for (Bicicleta aux : listaBicicletasAlta) {

                String Fdueno = aux.getCliente().getApellido() + aux.getCliente().getNombre() + aux.getCliente().getDomicilio() + aux.getCliente().getDni() + aux.getCliente().getCelular();

                if (Fdueno.contains(jTFparametroAFiltrar.getText())) {

                    modeloTablaBicisAlta.addRow(new Object[]{aux.getId(), aux.getNumero_serie(), aux.getMarca(), aux.getTipo(), aux.getColor(), aux.getCliente().toString()});

                }

            }
            for (Bicicleta aux : listaBicicletasBaja) {

                String Fdueno = aux.getCliente().getApellido() + aux.getCliente().getNombre() + aux.getCliente().getDomicilio() + aux.getCliente().getDni() + aux.getCliente().getCelular();

                if (Fdueno.contains(jTFparametroAFiltrar.getText())) {

                    modeloTablaBicisBaja.addRow(new Object[]{aux.getId(), aux.getNumero_serie(), aux.getMarca(), aux.getTipo(), aux.getColor(), aux.getCliente().toString()});

                }

            }

        } else if (jCBTipoDeFiltro.getSelectedIndex() == 1) { // filtro por servicio 

            try {

                HashSet<Reparacion> listaBicicletasFiltradaPorServicio = ReData.listarReparaciones();

                for (Reparacion aux : listaBicicletasFiltradaPorServicio) {

                    String Fservicio = aux.getServicio().getCodigo() + aux.getServicio().getDescripcion();

                    if (!aux.getBiclicleta().getBorrado() && Fservicio.contains(jTFparametroAFiltrar.getText())) {

                        modeloTablaBicisAlta.addRow(new Object[]{aux.getBiclicleta().getId(), aux.getBiclicleta().getNumero_serie(), aux.getBiclicleta().getMarca(), aux.getBiclicleta().getTipo(), aux.getBiclicleta().getColor(), aux.getBiclicleta().getCliente().toString()});

                    }
                    if (aux.getBiclicleta().getBorrado() && Fservicio.contains(jTFparametroAFiltrar.getText())) {
                        modeloTablaBicisBaja.addRow(new Object[]{aux.getBiclicleta().getId(), aux.getBiclicleta().getNumero_serie(), aux.getBiclicleta().getMarca(), aux.getBiclicleta().getTipo(), aux.getBiclicleta().getColor(), aux.getBiclicleta().getCliente().toString()});

                    }

                }
            } catch (java.time.format.DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Error --  ");

            }

        } else if (jCBTipoDeFiltro.getSelectedIndex() == 2) { // filtro por fecha de entrada
            try {
               
                HashSet<Bicicleta> listaBicicletasFiltradaPorFecha = ReData.buscarBicicletasPorFecha(LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(jDCalendario.getDate())));

                for (Bicicleta aux : listaBicicletasFiltradaPorFecha) {

                    if (!aux.getBorrado()) {
                        modeloTablaBicisAlta.addRow(new Object[]{aux.getId(), aux.getNumero_serie(), aux.getMarca(), aux.getTipo(), aux.getColor(), aux.getCliente().toString()});

                    } else {
                        modeloTablaBicisBaja.addRow(new Object[]{aux.getId(), aux.getNumero_serie(), aux.getMarca(), aux.getTipo(), aux.getColor(), aux.getCliente().toString()});

                    }

                }
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Error en el formato de la fecha [ AÑO-MES-DIA ] ");

            }

        }

    }

    private void limpiarCampos() {
        JTFnumBicicleta.setText("");
        JTFnumSerie.setText("");
        JTFmarca.setText("");
        JTFtipo.setText("");
        JTFcolor.setText("");
        JTFclienteActual.setText("");
        JCBcliente.setSelectedIndex(-1);
        JCBcliente.setEnabled(false);

    }

}
