/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metamerismoapp;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author alberto
 */
public class selectFileGui extends javax.swing.JFrame {

    private variationsColorsGui vGui;
    
    /**
     * Creates new form selectFileGui
     */
    public selectFileGui() {
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

        fileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Selector de igualaciones");

        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecciona el archivo igualaciones de color");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed
        try{
            File f = fileChooser.getSelectedFile();
            BufferedReader br = new BufferedReader(new FileReader(f));
            
            String line = br.readLine();
            
            LinkedHashMap<String, ArrayList> colores = new LinkedHashMap<String, ArrayList>();
            //LinkedHashMap<String, String> coloresPromedio = new LinkedHashMap<String, String>();

            while (line != null) {
                if(!line.equals(""))
                {
                    String[] parsedLine = line.split(";");
                    String key = parsedLine[0]+";"+parsedLine[1]+";"+parsedLine[2];

                    /*
                    if(!coloresPromedio.containsKey(key))
                    {
                        List l = new List(); l.add(parsedLine[3]+";"+parsedLine[4]+";"+parsedLine[5]);
                        coloresPromedio.put(key, "0;0;0");
                    }
                    */

                    //String[] promedio = coloresPromedio.get(key).split(";");

                    /* Pasamos los acumulados a enteros y acumulamos
                    int promedioInt[] = {0,0,0};
                    promedioInt[0] = Integer.parseInt(promedio[0]) + Integer.parseInt(parsedLine[3]);
                    promedioInt[1] = Integer.parseInt(promedio[1]) + Integer.parseInt(parsedLine[4]);
                    promedioInt[2] = Integer.parseInt(promedio[2]) + Integer.parseInt(parsedLine[5]);

                    coloresPromedio.put(key, promedioInt[0]+";"+promedioInt[1]+";"+promedioInt[2]);
                    */

                    if(colores.containsKey(key))
                    {
                        ArrayList l = colores.get(key); l.add(parsedLine[3]+";"+parsedLine[4]+";"+parsedLine[5]);
                        l.add(parsedLine[3]+";"+parsedLine[4]+";"+parsedLine[5]);
                        colores.put(key, l);
                    }
                    else
                    {
                        ArrayList l = new ArrayList(); l.add(parsedLine[3]+";"+parsedLine[4]+";"+parsedLine[5]);
                        l.add(parsedLine[3]+";"+parsedLine[4]+";"+parsedLine[5]);
                        colores.put(key, l);
                    }
                    line = br.readLine();
                }
            }
            
            /*
            for (Map.Entry<String, String> entry : coloresPromedio.entrySet()) {
                String kkey = entry.getKey();
                String vvalue = entry.getValue();
                
                String[] promedio = vvalue.split(";");
                
                // Pasamos los acumulados a enteros y acumulamos
                int promedioInt[] = {0,0,0};
                promedioInt[0] = Integer.parseInt(promedio[0]) / colores.get(kkey).size();
                promedioInt[1] = Integer.parseInt(promedio[1]) / colores.get(kkey).size();
                promedioInt[2] = Integer.parseInt(promedio[2]) / colores.get(kkey).size();
                coloresPromedio.put(kkey, promedioInt[0]+";"+promedioInt[1]+";"+promedioInt[2]);
            }
            */
            
            vGui = new variationsColorsGui();
            vGui.setExtendedState(JFrame.MAXIMIZED_BOTH);
            vGui.setVisible(true);
            vGui.setColors(colores /*, coloresPromedio*/);
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al leer archivo! Asegurate de que este en formato correcto! :S\n"+e.getMessage());
        }
    }//GEN-LAST:event_fileChooserActionPerformed

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
            java.util.logging.Logger.getLogger(selectFileGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selectFileGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selectFileGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selectFileGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selectFileGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
