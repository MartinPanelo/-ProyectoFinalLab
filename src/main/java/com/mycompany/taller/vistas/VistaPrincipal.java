/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.taller.vistas;

/**
 *
 * @author martin
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMgestionar = new javax.swing.JMenuItem();
        JMRepuesto = new javax.swing.JMenu();
        JMIgestion = new javax.swing.JMenuItem();
        JMIlistado = new javax.swing.JMenuItem();
        JMCliente = new javax.swing.JMenu();
        JMGestion = new javax.swing.JMenuItem();
        JMReparacion = new javax.swing.JMenu();
        JMIGestion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Taller de bicicletas El pinchazo");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 898, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );

        jMenu2.setText("Bicicleta");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Servicios");

        jMgestionar.setText("Gestionar");
        jMgestionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMgestionarActionPerformed(evt);
            }
        });
        jMenu3.add(jMgestionar);

        jMenuBar1.add(jMenu3);

        JMRepuesto.setText("Repuesto");

        JMIgestion.setText("Gestion");
        JMIgestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIgestionActionPerformed(evt);
            }
        });
        JMRepuesto.add(JMIgestion);

        JMIlistado.setText("Listado");
        JMIlistado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIlistadoActionPerformed(evt);
            }
        });
        JMRepuesto.add(JMIlistado);

        jMenuBar1.add(JMRepuesto);

        JMCliente.setText("Cliente");

        JMGestion.setText("Gestion");
        JMGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMGestionActionPerformed(evt);
            }
        });
        JMCliente.add(JMGestion);

        jMenuBar1.add(JMCliente);

        JMReparacion.setText("Reparación");

        JMIGestion.setText("Gestión");
        JMIGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIGestionActionPerformed(evt);
            }
        });
        JMReparacion.add(JMIGestion);

        jMenuBar1.add(JMReparacion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMgestionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMgestionarActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaServicio vistaServicio = new VistaServicio();
        vistaServicio.setVisible(true);
        jDesktopPane1.add(vistaServicio);
        jDesktopPane1.moveToFront(vistaServicio);
    }//GEN-LAST:event_jMgestionarActionPerformed

    private void JMIgestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIgestionActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaRepuesto gestionRepuesto = new VistaRepuesto();
        gestionRepuesto.setVisible(true);
        jDesktopPane1.add(gestionRepuesto);
        jDesktopPane1.moveToFront(gestionRepuesto);
    }//GEN-LAST:event_JMIgestionActionPerformed

    private void JMIlistadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIlistadoActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaListadoRepuesto listadoRepuesto = new VistaListadoRepuesto();
        listadoRepuesto.setVisible(true);
        jDesktopPane1.add(listadoRepuesto);
        jDesktopPane1.moveToFront(listadoRepuesto);
    }//GEN-LAST:event_JMIlistadoActionPerformed

    private void JMGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMGestionActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaCliente clientesGestion = new VistaCliente();
        clientesGestion.setVisible(true);
        jDesktopPane1.add(clientesGestion);
        jDesktopPane1.moveToFront(clientesGestion);
    }//GEN-LAST:event_JMGestionActionPerformed

    private void JMIGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIGestionActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        VistaReparacion clientesGestion = new VistaReparacion();
        clientesGestion.setVisible(true);
        jDesktopPane1.add(clientesGestion);
        jDesktopPane1.moveToFront(clientesGestion);
        // VistaReparacion reparacionGestion = new VistaReparacion(); (No funca);

    }//GEN-LAST:event_JMIGestionActionPerformed

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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMCliente;
    private javax.swing.JMenuItem JMGestion;
    private javax.swing.JMenuItem JMIGestion;
    private javax.swing.JMenuItem JMIgestion;
    private javax.swing.JMenuItem JMIlistado;
    private javax.swing.JMenu JMReparacion;
    private javax.swing.JMenu JMRepuesto;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMgestionar;
    // End of variables declaration//GEN-END:variables
}
