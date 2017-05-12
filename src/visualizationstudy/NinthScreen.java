/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizationstudy;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import static java.io.File.separatorChar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author xfurman
 */
public class NinthScreen extends javax.swing.JPanel {

    private ArrayList<ArrayList<File>> allImages = new ArrayList<>();
    private int[] answers = new int[10];
    private ImageButton[] buttons = new ImageButton[7];
    private int counter;
    private ArrayList<String> folders = new ArrayList<>();

    /**
     * Creates new form FifthScreen
     */
    public NinthScreen() {
        initComponents();
        loadImages();
        counter = 0;
        addImages();

    }

    public boolean next() {
        if (counter <= 9) {
            boolean answer = false;
            for (ImageButton button : buttons) {
                if (button.getHighlighted()) {
                    answer = true;
                }
            }
            if (!answer) {
                errorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visualizationstudy/resources/red_error_icon.png")));
                errorLabel.setText("Zvolte odpověď.");
                return true;
            } else if (counter < 9) {
                counter++;
                countLabel.setText(counter + 1 + "/10");
                addImages();
                if (answers[counter] != 0) {
                    buttons[answers[counter] - 1].setHighlighted(true);
                    buttons[answers[counter] - 1].setColor(Color.GREEN);
                }
                errorLabel.setIcon(null);
                errorLabel.setText("");

                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean back() {
        errorLabel.setIcon(null);
        errorLabel.setText("");
        if (counter > 0) {
            counter--;
            countLabel.setText(counter + 1 + "/10");
            addImages();
            buttons[answers[counter] - 1].setHighlighted(true);
            buttons[answers[counter] - 1].setColor(Color.GREEN);
            return true;
        }
        return false;
    }

    private void addImages() {
        jPanel1.removeAll();
        for (int i = 0; i < 7; i++) {
            if (i == 0 || i == 1) {
                ImageButton b = new ImageButton();
                jPanel1.add(b);
            }
            File f = new File(allImages.get(counter).get(i).getParent());
            final int index = i;
            final String image = f.getParent() + separatorChar + allImages.get(counter).get(i).getName();
            ImageButton b = new ImageButton();
            buttons[i] = b;
            b.setImage(allImages.get(counter).get(i));
            jPanel1.add(b);
            b.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isRightMouseButton(evt)) {
                        JDialog d = new JDialog();
                        d.setModal(true);
                        d.setResizable(false);
                        d.setSize(995, 700);
                        ImageIcon icon = new ImageIcon(image);
                        icon = new ImageIcon(icon.getImage().getScaledInstance(1450 * d.getHeight() / 1024, d.getHeight(), Image.SCALE_SMOOTH));
                        JLabel thumb = new JLabel();
                        thumb.setIcon(icon);
                        d.add(thumb);
                        thumb.setBackground(Color.WHITE);
                        d.setBackground(Color.WHITE);
                        d.setVisible(true);
                    }
                    if (SwingUtilities.isLeftMouseButton(evt) && index != 0) {
                        for (int j = 0; j < 7; j++) {
                            buttons[j].setHighlighted(false);
                            buttons[j].setColor(new Color(240, 240, 240));
                        }
                        buttons[index].setHighlighted(true);
                        buttons[index].setColor(Color.GREEN);
                        answers[counter] = index + 1;
                        errorLabel.setIcon(null);
                        errorLabel.setText("");
                    }
                }
            });

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        countLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });
        jPanel1.setLayout(new java.awt.GridLayout(3, 3, 5, 5));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(220, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 62));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Kliknutím na obrázek vyberte schéma, keré nejlépe zobrazuje rozdíly mezi dvěma obličeji.");
        jLabel1.setMaximumSize(new java.awt.Dimension(250, 22));
        jLabel1.setMinimumSize(new java.awt.Dimension(270, 22));
        jLabel1.setPreferredSize(new java.awt.Dimension(250, 22));

        errorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        countLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        countLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countLabel.setText("1/10");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Kliknutím pravého tlačítka myši je možné zvětšit velikost obrázku.");
        jLabel2.setMaximumSize(new java.awt.Dimension(250, 22));
        jLabel2.setMinimumSize(new java.awt.Dimension(270, 22));
        jLabel2.setPreferredSize(new java.awt.Dimension(250, 22));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(countLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(countLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2.add(jPanel3, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1ComponentResized

    private void loadImages() {
        try {

            File f = new File(new java.io.File(".").getCanonicalPath() + separatorChar + "Images" + separatorChar + "task3");
            for (File fl : f.listFiles()) {
                File ic = new File(fl.getPath() + separatorChar + "icons");
                ArrayList<File> images = new ArrayList<>();
                images.addAll(Arrays.asList(ic.listFiles()));
                images.remove(0);
                Collections.shuffle(images);
                images.add(0, ic.listFiles()[0]);
                allImages.add(images);
                folders.add(fl.getName());
            }

        } catch (IOException ex) {
        }
        long seed = System.nanoTime();
        Collections.shuffle(allImages, new Random(seed));
        Collections.shuffle(folders, new Random(seed));
    }
    
    public String[] getAnswers(){
        String ans[] = new String[answers.length];
        for(int i = 0; i< answers.length; i++){
            ans[i] = allImages.get(i).get(answers[i]-1).getName();
        }
        return ans;
    }
    
    public ArrayList<String> getFolders() {
        return folders;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel countLabel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration//GEN-END:variables
}
