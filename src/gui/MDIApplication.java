/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author User
 */
public class MDIApplication extends javax.swing.JFrame {

    /**
     * Creates new form MDIApplication
     */
    public MDIApplication() {
        initComponents();
        this.setTitle("Gestion des professeurs vacataires");
        this.setExtendedState(MAXIMIZED_BOTH);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        profMenuItem = new javax.swing.JMenuItem();
        coursMenuItem = new javax.swing.JMenuItem();
        affectationMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        profByName = new javax.swing.JMenuItem();
        profBySpecialite = new javax.swing.JMenuItem();
        coursByProf = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        NbCoursParProf = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Gestion");

        profMenuItem.setMnemonic('o');
        profMenuItem.setText("Professeurs");
        profMenuItem.setActionCommand("Professeur");
        profMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(profMenuItem);

        coursMenuItem.setMnemonic('s');
        coursMenuItem.setText("Cours");
        coursMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(coursMenuItem);

        affectationMenuItem.setText("Affectations");
        affectationMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affectationMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(affectationMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Recherche");

        profByName.setMnemonic('t');
        profByName.setText("Professeurs par nom");
        profByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profByNameActionPerformed(evt);
            }
        });
        editMenu.add(profByName);

        profBySpecialite.setMnemonic('y');
        profBySpecialite.setText("Professeurs par spécialité");
        profBySpecialite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profBySpecialiteActionPerformed(evt);
            }
        });
        editMenu.add(profBySpecialite);

        coursByProf.setMnemonic('d');
        coursByProf.setText("Cours par professeur");
        coursByProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursByProfActionPerformed(evt);
            }
        });
        editMenu.add(coursByProf);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Statistique");

        NbCoursParProf.setMnemonic('c');
        NbCoursParProf.setText("Nombre de cours par professeurs");
        NbCoursParProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NbCoursParProfActionPerformed(evt);
            }
        });
        helpMenu.add(NbCoursParProf);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void coursMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursMenuItemActionPerformed
        CoursForm cf = CoursForm.getInstance();
        if (!cf.isVisible()) {
            desktopPane.add(cf);
            cf.setVisible(true);
        }
    }//GEN-LAST:event_coursMenuItemActionPerformed

    private void profByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profByNameActionPerformed
        ProfesseurParNomForm profForm = ProfesseurParNomForm.getInstance();
        if (!profForm.isVisible()) {
            desktopPane.add(profForm);
            profForm.setVisible(true);
        }
    }//GEN-LAST:event_profByNameActionPerformed

    private void profMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profMenuItemActionPerformed
        ProfesseurForm profForm = ProfesseurForm.getInstance();
        if (!profForm.isVisible()) {
            desktopPane.add(profForm);
            profForm.setVisible(true);
        }
    }//GEN-LAST:event_profMenuItemActionPerformed

    private void affectationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affectationMenuItemActionPerformed
        AffectationForm affectationForm = AffectationForm.getInstance();
        if (!affectationForm.isVisible()) {
            desktopPane.add(affectationForm);
            affectationForm.setVisible(true);
        }
    }//GEN-LAST:event_affectationMenuItemActionPerformed

    private void profBySpecialiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profBySpecialiteActionPerformed
        ProfesseurParSpecialiteForm pbs = new ProfesseurParSpecialiteForm();
        desktopPane.add(pbs);
        pbs.setVisible(true);
    }//GEN-LAST:event_profBySpecialiteActionPerformed

    private void coursByProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursByProfActionPerformed
        CoursByProfForm coursForm = CoursByProfForm.getInstance();
        if (!coursForm.isVisible()) {
            desktopPane.add(coursForm);
            coursForm.setVisible(true);
        }
    }//GEN-LAST:event_coursByProfActionPerformed

    private void NbCoursParProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NbCoursParProfActionPerformed
        BarChartForm barForm = BarChartForm.getInstance();
        if (!barForm.isVisible()) {
            desktopPane.add(barForm);
            barForm.setVisible(true);
        }
    }//GEN-LAST:event_NbCoursParProfActionPerformed

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
            java.util.logging.Logger.getLogger(MDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem NbCoursParProf;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem affectationMenuItem;
    private javax.swing.JMenuItem coursByProf;
    private javax.swing.JMenuItem coursMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem profByName;
    private javax.swing.JMenuItem profBySpecialite;
    private javax.swing.JMenuItem profMenuItem;
    // End of variables declaration//GEN-END:variables

}
