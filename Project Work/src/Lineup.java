/*
 * This class works as a user interface of the software
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Lassi
 */
public class Lineup extends javax.swing.JFrame {

    /**
     * Creates new form Lineup
     */
    public Lineup() {
        initComponents();
    }
    Graphics g;
    Graphics2D g2;

    int targetPlayerSet = 0;
    AffineTransform toLogical;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new javax.swing.JPopupMenu();
        editName = new javax.swing.JMenuItem();
        editNumber = new javax.swing.JMenuItem();
        dialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        field1 = new Field();
        loadPic = new javax.swing.JButton();
        setShirtColor = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        seven = new javax.swing.JRadioButton();
        eleven = new javax.swing.JRadioButton();
        print = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        undo = new javax.swing.JMenuItem();
        redo = new javax.swing.JMenuItem();

        editName.setText("Edit name...");
        editName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNameActionPerformed(evt);
            }
        });
        popup.add(editName);

        editNumber.setText("Edit number...");
        editNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNumberActionPerformed(evt);
            }
        });
        popup.add(editNumber);

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout dialogLayout = new javax.swing.GroupLayout(dialog.getContentPane());
        dialog.getContentPane().setLayout(dialogLayout);
        dialogLayout.setHorizontalGroup(
            dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        dialogLayout.setVerticalGroup(
            dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel1)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setComponentPopupMenu(popup);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        field1.setToolTipText("Right-click to edit");
        field1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                field1MouseDragged(evt);
            }
        });
        field1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                field1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                field1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout field1Layout = new javax.swing.GroupLayout(field1);
        field1.setLayout(field1Layout);
        field1Layout.setHorizontalGroup(
            field1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        field1Layout.setVerticalGroup(
            field1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(field1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(519, Short.MAX_VALUE))
            .addComponent(field1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );

        loadPic.setText("Load a background...");
        loadPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadPicActionPerformed(evt);
            }
        });

        setShirtColor.setText("Choose the shirt color");
        setShirtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setShirtColorActionPerformed(evt);
            }
        });

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4-4-2", "4-3-3", "3-5-2", "3-4-3" }));
        combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboItemStateChanged(evt);
            }
        });
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jLabel2.setText("Formation:");

        buttonGroup1.add(seven);
        seven.setText("7 players");
        seven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sevenActionPerformed(evt);
            }
        });

        buttonGroup1.add(eleven);
        eleven.setSelected(true);
        eleven.setText("11 players");
        eleven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elevenActionPerformed(evt);
            }
        });

        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        undo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        undo.setText("Undo");
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });
        jMenu2.add(undo);

        redo.setText("Redo");
        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });
        jMenu2.add(redo);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setShirtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadPic, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(print)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seven)
                    .addComponent(eleven)
                    .addComponent(jLabel2))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(seven)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eleven)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189)
                .addComponent(setShirtColor)
                .addGap(18, 18, 18)
                .addComponent(loadPic)
                .addGap(18, 18, 18)
                .addComponent(print)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*
     * The operations of the user interface
     */
    private void loadPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadPicActionPerformed
        JFileChooser c = new JFileChooser();
        if (c.showOpenDialog(null) == 0) {
            try {
                Image i = ImageIO.read(c.getSelectedFile());
                field1.setImage(i);
                field1.repaint();
            } catch (IOException e) {
            }
        }


    }//GEN-LAST:event_loadPicActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void editNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNumberActionPerformed
        String oldValue = (String) field1.getSetNumber();
        String newValue = "" + (String) field1.getSetNumber();
        undos.addEdit(new AbstractUndoableEdit() {
            @Override
            public void undo() {
                super.undo();
                field1.setNumbers(oldValue);
            }

            @Override
            public void redo() {
                super.redo();
                field1.setNumbers(newValue);
            }
        });

        String num = JOptionPane.showInputDialog(this, "Number:", field1.getSetNumber());
        if (num != null) {
            field1.setNumbers(num);
        }

    }//GEN-LAST:event_editNumberActionPerformed

    private void setShirtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setShirtColorActionPerformed
        Color newValue = field1.getSetColor();
        Color old = field1.getSetColor();
        undos.addEdit(new AbstractUndoableEdit() {
            @Override
            public void undo() {
                super.undo();
                field1.setSetColor(old);
            }

            @Override
            public void redo() {
                super.redo();
                field1.setSetColor(newValue);
            }
        });
        Color c = JColorChooser.showDialog(this, "Set color", Color.BLACK);
        if (c != null) {
            field1.setSetColor(c);
        }
    }//GEN-LAST:event_setShirtColorActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed

    }//GEN-LAST:event_comboActionPerformed

    private void field1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field1MousePressed
        if (evt.isPopupTrigger() && field1.selectPlayerSet(evt)) {
            popup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_field1MousePressed

    private void field1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field1MouseReleased
        if (evt.isPopupTrigger() && field1.selectPlayerSet(evt)) {
            popup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_field1MouseReleased

    private void editNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNameActionPerformed

        String oldValue = (String) field1.getSetName();
        System.out.println(oldValue);
        undos.addEdit(new AbstractUndoableEdit() {
            @Override
            public void undo() {
                super.undo();
                field1.setNames(oldValue);
            }
        });

        String name = JOptionPane.showInputDialog(this, "Name:", field1.getSetName());
        if (name != null) {
            field1.setNames(name);
        }
    }//GEN-LAST:event_editNameActionPerformed

    private void comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboItemStateChanged
        String choose = evt.getItem().toString();
        if (combo.isCursorSet()) {
            String oldValue = (String) combo.getSelectedItem();
            undos.addEdit(new AbstractUndoableEdit() {
                @Override
                public void undo() {
                    super.undo();
                    combo.setSelectedItem(oldValue);
                }
            });
        }
        System.out.println(choose);
        if (choose.equals("4-3-3")) {
            field1.draw433();
            repaint();
        }
        if (choose.equals("3-5-2")) {
            field1.draw352();
            repaint();
        }
        if (choose.equals("4-4-2")) {
            field1.draw442();
            repaint();
        }
        if (choose.equals("3-4-3")) {
            field1.draw343();
            repaint();
        }
    }//GEN-LAST:event_comboItemStateChanged

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        if (undos.canUndo()) {
            undos.undo();
        }
    }//GEN-LAST:event_undoActionPerformed

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed
        if (undos.canRedo()) {
            undos.redo();
        }
    }//GEN-LAST:event_redoActionPerformed

    private void sevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sevenActionPerformed

        if (seven.isSelected()) {
            combo.setEnabled(false);
            field1.draw331();
            repaint();
        }
    }//GEN-LAST:event_sevenActionPerformed

    private void elevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elevenActionPerformed

        if (eleven.isSelected()) {
            combo.setEnabled(true);
        }
    }//GEN-LAST:event_elevenActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable((Printable) field1);
        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException ex) {
                Logger.getLogger(Lineup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_printActionPerformed

    private void field1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field1MouseDragged

    }//GEN-LAST:event_field1MouseDragged

    public void mouseDragged(MouseEvent e) {
        System.out.println("asd");
        field1 = (Field) (JPanel) e.getComponent().getParent();
        int newX = e.getX();
        int newY = e.getY();
        e.getComponent().setLocation(newX, newY);
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
            java.util.logging.Logger.getLogger(Lineup.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lineup.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lineup.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lineup.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lineup().setVisible(true);

            }
        });
    }
    UndoManager undos = new UndoManager();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JDialog dialog;
    private javax.swing.JMenuItem editName;
    private javax.swing.JMenuItem editNumber;
    private javax.swing.JRadioButton eleven;
    private Field field1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JButton loadPic;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel2;
    private javax.swing.JPopupMenu popup;
    private javax.swing.JButton print;
    private javax.swing.JMenuItem redo;
    private javax.swing.JButton setShirtColor;
    private javax.swing.JRadioButton seven;
    private javax.swing.JMenuItem undo;
    // End of variables declaration//GEN-END:variables
}
