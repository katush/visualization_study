/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizationstudy;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author xfurman
 */
public class Main extends javax.swing.JFrame {

    private int activeIndex;
    private int screencounter;
    private Map<Integer, JPanel> panels;
    private Map<Integer, Long> times;
    long timeStartProgram;
    long timeEndProgram;
    private Task task;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        registerScreens();
        times = new HashMap<>();
        jPanel1.add(panels.get(activeIndex));
        jPanel1.revalidate();
        jPanel1.repaint();
        screencounter = 0;
        Timer timer = new Timer();
        task = new Task(timerLabel, timer, 0);
        timer.scheduleAtFixedRate(task, 0, 1000);
        
    }

    private void registerScreens() {
        panels = new HashMap<>();
        FirstScreen p0 = new FirstScreen();
        activeIndex = 0;
        panels.put(0, p0);
        SecondScreen p1 = new SecondScreen();
        panels.put(1, p1);
        BarvocitScreen pb = new BarvocitScreen();
        panels.put(2, pb);
        ThirdScreen p2 = new ThirdScreen();
        panels.put(3, p2);
        FourthScreen p3 = new FourthScreen();
        panels.put(4, p3);
        FifthScreen p4 = new FifthScreen();
        panels.put(5, p4);
        SixthScreen p5 = new SixthScreen();
        panels.put(6, p5);
        SeventhScreen p6 = new SeventhScreen();
        panels.put(7, p6);
        EightScreen p7 = new  EightScreen();
        panels.put(8, p7);
        NinthScreen p8 = new  NinthScreen();
        panels.put(9, p8);
        TenthScreen p9 = new  TenthScreen();
        panels.put(10, p9);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        timerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Study");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new java.awt.Dimension(900, 800));
        setPreferredSize(new java.awt.Dimension(800, 800));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("<< Zpět");
        jButton1.setMargin(new java.awt.Insets(20, 25, 20, 25));
        jButton1.setMaximumSize(new java.awt.Dimension(107, 51));
        jButton1.setPreferredSize(new java.awt.Dimension(700, 450));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new java.awt.GridBagConstraints());
        jButton1.setVisible(false);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Další >>");
        jButton2.setMargin(new java.awt.Insets(20, 25, 20, 25));
        jButton2.setMaximumSize(new java.awt.Dimension(105, 51));
        jButton2.setPreferredSize(new java.awt.Dimension(700, 450));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new java.awt.GridBagConstraints());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        timerLabel.setText("Time:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(timerLabel))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        task.stop();
        times.put(screencounter, task.getCompleteTime());
        screencounter--;
        Timer timer = new Timer();
        task = new Task(timerLabel, timer,times.containsKey(screencounter) ? times.get(screencounter) : 0);
        timer.scheduleAtFixedRate(task, 0, 1000);
        
        
        if (panels.get(activeIndex) instanceof FifthScreen) {
            if (!((FifthScreen) panels.get(activeIndex)).back()) {
                previousPanel();
            }
        }else if (panels.get(activeIndex) instanceof SeventhScreen) {
            if (!((SeventhScreen) panels.get(activeIndex)).back()) {
                previousPanel();
            }
        }else if (panels.get(activeIndex) instanceof NinthScreen) {
            if (!((NinthScreen) panels.get(activeIndex)).back()) {
                previousPanel();
            }
        }else{
            previousPanel();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        task.stop();
        times.put(screencounter, task.getCompleteTime());
        screencounter++;
        Timer timer = new Timer();
        task = new Task(timerLabel, timer,times.containsKey(screencounter) ? times.get(screencounter) : 0);
        timer.scheduleAtFixedRate(task, 0, 1000);
        
        if (panels.get(activeIndex) instanceof SecondScreen) {
            if (((SecondScreen) panels.get(activeIndex)).validateForm()) {
                nextPanel();
            }
        } else if (panels.get(activeIndex) instanceof BarvocitScreen) {
            if (((BarvocitScreen) panels.get(activeIndex)).validateForm()) {
                nextPanel();
            }
        } else if (panels.get(activeIndex) instanceof FifthScreen) {
            if (!((FifthScreen) panels.get(activeIndex)).next()) {
                nextPanel();
            }
        } else if (panels.get(activeIndex) instanceof SeventhScreen) {
            if (!((SeventhScreen) panels.get(activeIndex)).next()) {
                nextPanel();
            }
        }else if (panels.get(activeIndex) instanceof NinthScreen) {
            if (!((NinthScreen) panels.get(activeIndex)).next()) {
                nextPanel();
            }
        }else if (panels.get(activeIndex) instanceof TenthScreen) {
            save();
        }else {
            nextPanel();
        }


    }//GEN-LAST:event_jButton2ActionPerformed
    private void previousPanel() {
        activeIndex--;
        jPanel1.removeAll();
        if (panels.containsKey(activeIndex)) {
            jPanel1.add(panels.get(activeIndex));
            jPanel1.revalidate();
            jPanel1.repaint();
        }
        jButton2.setVisible(true);
        if (!panels.containsKey(activeIndex - 1)) {
            jButton1.setVisible(false);
        }
        jButton2.setText("Další >>");
    }

    private void nextPanel() {
        activeIndex++;
        jPanel1.removeAll();
        if (panels.containsKey(activeIndex)) {
            jPanel1.add(panels.get(activeIndex));
            jPanel1.revalidate();
            jPanel1.repaint();
        }
        jButton1.setVisible(true);
        if (!panels.containsKey(activeIndex + 1)) {
            jButton2.setText("Uložit a ukončit");//setVisible(false);
        }
    }
    
    private void save(){
        String results = "";
         results +=((SecondScreen)panels.get(1)).getData();
         results +=((BarvocitScreen)panels.get(2)).getData();
         results +="Ukol 1\n";
         for(int i= 0; i<((FifthScreen)panels.get(5)).getAnswers().length; i++){
             results +=(i+1) + "." + ((FifthScreen)panels.get(5)).getFolders().get(i)+ ": \n";
             results += times.get(i+5) + " ms \n";
             results += ((((FifthScreen)panels.get(5)).getAnswers()[i]==1?"stejny jedinec":"ruzne osoby") +"\n").toUpperCase();
         }
         results +="Ukol 2\n";
         for(int i= 0; i<((SeventhScreen)panels.get(7)).getAnswers().length; i++){
             String answer ="";
             answer +=(i+1) + ". " + ((SeventhScreen)panels.get(7)).getFolders().get(i)+ ": \n";
             answer += times.get(i+16) + " ms \n";
             switch (((SeventhScreen)panels.get(7)).getAnswers()[i]){
                 case 1:answer +=  "sequential".toUpperCase();
                 break;
                 case 2:answer +=  "diverging".toUpperCase();
                 break;
                 case 3:answer +=  "rainbow".toUpperCase();
                 break;
             }
             results += answer +"\n";
         }
         results +="Ukol 3\n";
         for(int i= 0; i<((NinthScreen)panels.get(9)).getAnswers().length; i++){
             results +=(i+1) + ". " + ((NinthScreen)panels.get(9)).getFolders().get(i)+ ": \n";
             results += times.get(i+16) + " ms \n";
             String answ = ((NinthScreen)panels.get(9)).getAnswers()[i];
             String answer = "";
             if(answ.contains("diverging")){
                 answer = "COLORMAP DIVERGING";
             }else if(answ.contains("rainbow")){
                 answer = "COLORMAP RAINBOW";
             }else if(answ.contains("sequential")){
                 answer = "COLORMAP SEQUENTIAL";
             }else if(answ.contains("crosscuts")){
                 answer = "CROSSCUTS";
             }else if(answ.contains("glyphs")){
                 answer = "GLYPHS";
             }else if(answ.contains("fog") && !answ.contains("superimposition")){
                 answer = "FOG";
             }else if(answ.contains("fog") && answ.contains("superimposition")){
                 answer = "SUPERIMPOSITION + FOG";
             }
             else if(!answ.contains("fog") && answ.contains("superimposition")){
                 answer = "SUPERIMPOSITION";
             }
             results += answer +"\n";
         }
         
         Saver saver = new Saver(results);
         new Thread(saver).start();       
        
         
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
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
