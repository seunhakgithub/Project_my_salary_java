/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salary;

import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tickShow = new javax.swing.JCheckBox();
        txtPassword = new javax.swing.JPasswordField();
        cmdLogin = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("UserName");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 38));

        txtUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUser.setText("root");
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 240, 38));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 38));

        tickShow.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tickShow.setText("Show");
        tickShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tickShowActionPerformed(evt);
            }
        });
        getContentPane().add(tickShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, 50));

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setText("12345");
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 240, 38));

        cmdLogin.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmdLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Apps-session-quit-icon.png"))); // NOI18N
        cmdLogin.setText("Log In");
        cmdLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });
        getContentPane().add(cmdLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 130, 50));

        cmdClose.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/green-cross-icon.png"))); // NOI18N
        cmdClose.setText("Cancel");
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });
        getContentPane().add(cmdClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 130, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salary/img/salary.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 330));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
        if (txtUser.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Plase in put yout Username!");
            txtUser.requestFocus();
        } else if (txtPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Plase input your password !");
            txtPassword.requestFocus();
        } else if (txtUser.getText().equals("") && txtPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Plase input Username and Password !");

        } else {
            try {
                String UserName = txtUser.getText();
                String Pass = txtPassword.getText();
                String Ip = "127.0.0.1";
                String db = "salary1";

                Datacon.connection(Ip, db, UserName, Pass);
                loading obj = new loading();
                obj.SetupLoading();
                obj.setVisible(true);
                this.dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());

            }

        }
    }//GEN-LAST:event_cmdLoginActionPerformed

    private void tickShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tickShowActionPerformed
        //code for to show text password on the text field pass
        if (tickShow.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tickShowActionPerformed

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped

        // TODO add your handling code here:
        if (evt.getKeyChar() == 10) {
            cmdLoginActionPerformed(null);
        }
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        if (evt.getKeyChar() == 10) {
            txtPassword.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserKeyTyped

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JCheckBox tickShow;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
