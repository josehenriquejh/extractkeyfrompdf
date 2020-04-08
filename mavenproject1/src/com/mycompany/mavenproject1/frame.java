/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author Henrique
 */
public class frame extends javax.swing.JFrame {
    
    String caminhopdf = null;
    String caminhotxt = "C:\\chavesdeacesso.txt";
    String chave = null;
    JFileChooser jf = new JFileChooser();
    /**
     * Creates new form frame
     */
    public frame() {
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnpdf = new javax.swing.JButton();
        btntxt = new javax.swing.JButton();
        btncolsulta = new javax.swing.JButton();
        txtpdf = new javax.swing.JTextField();
        txttxt = new javax.swing.JTextField();
        txtchave = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Caminho do Arquivo PDF da(s) Nota(s)");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 36, -1, -1));

        jLabel3.setText("Caminho do TXT Gerado (Padr�o C:)");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel5.setText("Quatro Primeiros D�gitos da Chave de Acesso");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        btnpdf.setText("Abrir");
        btnpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpdfActionPerformed(evt);
            }
        });
        getContentPane().add(btnpdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 56, 70, -1));

        btntxt.setText("Salvar");
        btntxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntxtActionPerformed(evt);
            }
        });
        getContentPane().add(btntxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 70, -1));

        btncolsulta.setText("Consultar");
        btncolsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncolsultaActionPerformed(evt);
            }
        });
        getContentPane().add(btncolsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        txtpdf.setEditable(false);
        getContentPane().add(txtpdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 57, 216, -1));

        txttxt.setEditable(false);
        txttxt.setText("C:\\chavesdeacesso.txt");
        getContentPane().add(txttxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 216, -1));

        txtchave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtchaveActionPerformed(evt);
            }
        });
        getContentPane().add(txtchave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 91, -1));

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpdfActionPerformed
     // fileName = (new JFileChooser()).toString();
     
     
     jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
     int i= jf.showOpenDialog(null);
     if (i==1){
           txtpdf.setText("");
       } else {
           File arquivo = jf.getSelectedFile();
           txtpdf.setText(arquivo.getPath());
       }
     caminhopdf = txtpdf.getText();
     
    }//GEN-LAST:event_btnpdfActionPerformed

    private void btntxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntxtActionPerformed
        // TODO add your handling code here:
        jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
     int i= jf.showSaveDialog(null);
     if (i==1){
           txttxt.setText("");
       } else {
           File arquivo = jf.getSelectedFile();
           txttxt.setText(arquivo.getPath());
       }
     
     if(!txttxt.getText().contains(".txt")){
     caminhotxt = txttxt.getText()+".txt";}
     else {
     caminhotxt = txttxt.getText();    
     }
    }//GEN-LAST:event_btntxtActionPerformed

    private void btncolsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncolsultaActionPerformed
       com.mycompany.mavenproject1.testwrite controler = new com.mycompany.mavenproject1.testwrite();
       if(txtchave.getText().length() == 4){
       chave = txtchave.getText(); } else {
           JOptionPane.showMessageDialog(null, "Insira uma chave com apenas 4 n�meros.");
       }
       try {
            controler.consultachaves(caminhopdf, caminhotxt, chave);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Inconsist�ncia no Preenchimento!");
            Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btncolsultaActionPerformed

    private void txtchaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtchaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtchaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame().setVisible(true);
            }
        });
        
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncolsulta;
    private javax.swing.JButton btnpdf;
    private javax.swing.JButton btntxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtchave;
    private javax.swing.JTextField txtpdf;
    private javax.swing.JTextField txttxt;
    // End of variables declaration//GEN-END:variables
}