package acesskeyfrompdf;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class frame2 extends javax.swing.JFrame {

    
    
    String caminhopdf = null;
    String caminhotxt = "C:\\chavesdeacesso.txt";
    String chave = null;
    JFileChooser jfpdf = new JFileChooser();
    JFileChooser jftxt = new JFileChooser();
    Desktop desktop = Desktop.getDesktop();
    
    public frame2() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnpdf = new javax.swing.JButton();
        btntxt = new javax.swing.JButton();
        btnconsulta = new javax.swing.JButton();
        btnsair = new javax.swing.JButton();
        txtpdf = new javax.swing.JTextField();
        txttxt = new javax.swing.JTextField();
        txtchave = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnpdf.setText("Abrir");
        btnpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpdfActionPerformed(evt);
            }
        });

        btntxt.setText("Salvar");
        btntxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntxtActionPerformed(evt);
            }
        });

        btnconsulta.setText("Consultar");
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });

        btnsair.setText("Sair");
        btnsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsairActionPerformed(evt);
            }
        });

        txttxt.setText("C:\\chavesdeacesso.txt");

        txtchave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtchaveActionPerformed(evt);
            }
        });

        jLabel1.setText("Caminho para salvar TXT com as chaves (Padrao C:)");

        jLabel2.setText("4 Primeiros Digitos da Chave de acesso");

        jLabel3.setText("Arquivo PDF das Danfes com as chaves");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txttxt)
                                .addGap(18, 18, 18)
                                .addComponent(btntxt))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(txtpdf, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnpdf, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtchave, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnconsulta)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnsair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(106, 106, 106))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnpdf)
                    .addComponent(txtpdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntxt))
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtchave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconsulta)
                    .addComponent(btnsair))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpdfActionPerformed
        jfpdf.setFileSelectionMode(JFileChooser.FILES_ONLY);
     int i= jfpdf.showOpenDialog(null);
     if (i==1){
           txtpdf.setText("");
       } else {
           File arquivo = jfpdf.getSelectedFile();
           txtpdf.setText(arquivo.getPath());
       }
     caminhopdf = txtpdf.getText();
    }//GEN-LAST:event_btnpdfActionPerformed

    private void btntxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntxtActionPerformed
     jftxt.setFileSelectionMode(JFileChooser.FILES_ONLY);
     int i= jftxt.showSaveDialog(null);
     if (i==1){
           txttxt.setText("");
       } else {
           File arquivo = jftxt.getSelectedFile();
           txttxt.setText(arquivo.getPath());
       }
     caminhotxt = txttxt.getText();
     
     if(!caminhotxt.contains(".txt")){
     caminhotxt = caminhotxt+".txt";}
     else {
     }// TODO add your handling code here:
    }//GEN-LAST:event_btntxtActionPerformed

    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed
        testwrite controler = new testwrite();
        if (txtchave.getText().length() == 4) {
            chave = txtchave.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Insira uma chave com apenas 4 números.");
        }
        try {
            if (controler.consultachaves(caminhopdf, caminhotxt, chave) == true) {
                int option = JOptionPane.showConfirmDialog(null, "Deseja Abrir o TXT Gerado com as Chaves?", "Abrir txt", YES_NO_OPTION);
                if (option == YES_NO_OPTION) {
                    File file = new File(caminhotxt);
                    System.out.println(caminhotxt + " 1");

                    if (!Desktop.isDesktopSupported()) {
                        System.out.println("Desktop is not supported");
                        return;
                    }
                    if (file.exists()) {
                        System.out.println("teste1");
                        System.out.println(caminhotxt + " 2");
                        desktop.open(file);
                    } else {
                        file = new File(caminhotxt + ".txt");
                        openfile(file);
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "O sistema não pode encontrar o arquivo especificado!");
            Logger.getLogger(frame2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnconsultaActionPerformed

    private void btnsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsairActionPerformed
       System.exit(0);
        
    }//GEN-LAST:event_btnsairActionPerformed

    private void txtchaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtchaveActionPerformed
       
    }//GEN-LAST:event_txtchaveActionPerformed

   
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame2().setVisible(true);
            }
        });
    }
    
    public void openfile(File file) throws IOException {
        desktop.open(file);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsulta;
    private javax.swing.JButton btnpdf;
    private javax.swing.JButton btnsair;
    private javax.swing.JButton btntxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtchave;
    private javax.swing.JTextField txtpdf;
    private javax.swing.JTextField txttxt;
    // End of variables declaration//GEN-END:variables
}
