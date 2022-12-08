/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.taller.vistas;

import com.mycompany.taller.entidades.Bicicleta;
import com.mycompany.taller.persistencia.Conexion;
import com.mycompany.taller.persistencia.BicicletaData;
import java.sql.Connection;
import javax.swing.JOptionPane;
import com.mycompany.taller.persistencia.ClienteData;
import com.mycompany.taller.entidades.Cliente;
import java.util.List;

/**
 *
 * @author ailen
 */
public class VistaBicicleta extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaBicicleta
     */
    Connection conexiondb = Conexion.getConexion();
    BicicletaData bData = new BicicletaData(conexiondb);
    ClienteData cData = new ClienteData(conexiondb);
    List<Cliente> listaClientes;

    //private ClienteData cData;

    public VistaBicicleta() {
        initComponents();
        CargarClientes();
       // this.cData = new ClienteData(conexiondb);
        
    }

    //Validaciones  !!VER LA VALIDACION DE CLIENTE
    public boolean validarCamposVaciosBuscarID() {
        if (JTFid.getText().equals("")) {
            return false;
        }
        return true;
    }

    public boolean validarCamposVaciosAgregar() {
        if (JTFnroSerie.getText().equals("") || JTFmarca.getText().equals("") || JTFtipo.getText().equals("") || JTFcolor.getText().equals("")) {
            return false;
        }
        return true;
    }

    public boolean validarCamposVaciosBuscarNroSerie() {
        if (JTFnroSerie.getText().equals("")) {
            return false;
        }
        return true;
    }

    public boolean validarCamposVaciosActualizar() {
        if (JTFnroSerie.getText().equals("") || JTFmarca.getText().equals("") || JTFtipo.getText().equals("") || JTFcolor.getText().equals("")) {
            return false;
        }
        return true;
    }

   /* public boolean validarCamposVaciosBuscarCliente() {
        if (JCBclientes.getSelectedItem()) {
            return false;
        }
        return true;
    }*/

  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JLnroSerie = new javax.swing.JLabel();
        JLmarca = new javax.swing.JLabel();
        JLcolor = new javax.swing.JLabel();
        JLcliente = new javax.swing.JLabel();
        JTFid = new javax.swing.JTextField();
        JTFnroSerie = new javax.swing.JTextField();
        JTFmarca = new javax.swing.JTextField();
        JTFtipo = new javax.swing.JTextField();
        JLtipo = new javax.swing.JLabel();
        JTFcolor = new javax.swing.JTextField();
        JLid = new javax.swing.JLabel();
        JBagregar = new javax.swing.JButton();
        JBlimpiar = new javax.swing.JButton();
        JCBclientes = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Gestion de Bicicletas");

        JLnroSerie.setText("N° de Serie");

        JLmarca.setText("Marca");

        JLcolor.setText("Color");

        JLcliente.setText("Cliente");

        JTFid.setEnabled(false);
        JTFid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFidActionPerformed(evt);
            }
        });

        JTFnroSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFnroSerieActionPerformed(evt);
            }
        });

        JLtipo.setText("Tipo");

        JLid.setText("N° de Bicicleta");

        JBagregar.setText("Agregar");
        JBagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBagregarActionPerformed(evt);
            }
        });

        JBlimpiar.setText("Limpiar");
        JBlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBlimpiarActionPerformed(evt);
            }
        });

        JCBclientes.setToolTipText("");
        JCBclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBclientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(JBlimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(JBagregar)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLcliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLtipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLnroSerie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLid, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(JLmarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLcolor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCBclientes, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTFid)
                            .addComponent(JTFmarca)
                            .addComponent(JTFtipo)
                            .addComponent(JTFcolor)
                            .addComponent(JTFnroSerie))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLid)
                    .addComponent(JTFid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFnroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLnroSerie))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLmarca)
                    .addComponent(JTFmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLtipo)
                    .addComponent(JTFtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLcolor)
                    .addComponent(JTFcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLcliente)
                    .addComponent(JCBclientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBagregar)
                    .addComponent(JBlimpiar))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFidActionPerformed

    private void JTFnroSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFnroSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFnroSerieActionPerformed

    private void JBlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBlimpiarActionPerformed
        // TODO add your handling code here:
        JTFid.setText("");
        JTFnroSerie.setText("");
        JTFmarca.setText("");
        JTFtipo.setText("");
        JTFcolor.setText("");
        JCBclientes.removeAllItems();
    }//GEN-LAST:event_JBlimpiarActionPerformed

    private void JBagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBagregarActionPerformed
        // TODO add your handling code here:
        
        try {
            if (validarCamposVaciosAgregar()) {
                Bicicleta b = new Bicicleta();
                //Cliente c = new Cliente();
               b.setNumero_serie(Long.parseLong(JTFnroSerie.getText()));
                b.setMarca(JTFmarca.getText());
                b.setTipo(JTFtipo.getText());
                b.setColor(JTFcolor.getText());
                b.setCliente((Cliente)JCBclientes.getSelectedItem());
                
//b.setCliente(cData.buscarClientePorDni(Long.parseLong(JCBclientes.getName())));
                bData.guardarBicicleta(b);
            } else {
                JOptionPane.showMessageDialog(null, "Faltan llenar campos");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema revise los datos ingresados.");
        }
       
    }//GEN-LAST:event_JBagregarActionPerformed

    private void JCBclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBclientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBclientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBagregar;
    private javax.swing.JButton JBlimpiar;
    private javax.swing.JComboBox<Cliente> JCBclientes;
    private javax.swing.JLabel JLcliente;
    private javax.swing.JLabel JLcolor;
    private javax.swing.JLabel JLid;
    private javax.swing.JLabel JLmarca;
    private javax.swing.JLabel JLnroSerie;
    private javax.swing.JLabel JLtipo;
    private javax.swing.JTextField JTFcolor;
    private javax.swing.JTextField JTFid;
    private javax.swing.JTextField JTFmarca;
    private javax.swing.JTextField JTFnroSerie;
    private javax.swing.JTextField JTFtipo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
  private void CargarClientes() {

        listaClientes = cData.listarClientes(false);

        for (Cliente aux : listaClientes) {

            JCBclientes.addItem(aux);
        }
        JCBclientes.getSelectedIndex();
    }
}
