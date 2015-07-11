/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frasiek.dss;

import com.frasiek.dss.configuration.Store;
import com.frasiek.dss.configuration.StoreException;
import com.frasiek.dss.connection.Connection;
import com.frasiek.dss.connection.ConnectionException;
import com.frasiek.dss.connection.Manager;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import org.slf4j.LoggerFactory;

/**
 *
 * @author frasiek
 */
public class Main extends javax.swing.JFrame {

    private Store connectionStore;
    private org.slf4j.Logger logger = null;

    /**
     * Creates new form Main
     */
    public Main() {
        logger = LoggerFactory.getLogger(Main.class);
        try {
            connectionStore = Store.getInstance();
        } catch (StoreException ex) {
            logger.debug(ex.toString());
        }
        initComponents();
        setComboConnections();
        centeredFrame(this);
    }

    private void setComboConnections() {
        SourceConnection.removeAllItems();
        DestinationConnection.removeAllItems();
        for (Connection c : connectionStore.getStoredConnections()) {
            SourceConnection.addItem(c);
            DestinationConnection.addItem(c);
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

        NewConnection = new javax.swing.JDialog();
        Type = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Host = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Login = new javax.swing.JTextField();
        AddConnection = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        TestConnection = new javax.swing.JButton();
        Port = new javax.swing.JFormattedTextField();
        SourceConnection = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DestinationConnection = new javax.swing.JComboBox();
        Synchronize = new javax.swing.JButton();
        GenerateSQL = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        InfoBox = new javax.swing.JTextArea();
        srcDbDeleteBtn = new javax.swing.JButton();
        destDbDeleteBtn = new javax.swing.JButton();
        srcEditBtn = new javax.swing.JButton();
        sedtEditBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MainMenuFile = new javax.swing.JMenu();
        AddNewConnection = new javax.swing.JMenuItem();
        Quit = new javax.swing.JMenuItem();
        MainMenuHelp = new javax.swing.JMenu();
        MainMenuInformation = new javax.swing.JMenuItem();

        NewConnection.setTitle("Nowe połączenie");
        NewConnection.setAlwaysOnTop(true);
        NewConnection.setMinimumSize(new java.awt.Dimension(429, 330));
        NewConnection.setModal(true);
        NewConnection.setPreferredSize(new java.awt.Dimension(429, 330));
        NewConnection.setResizable(false);
        NewConnection.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                NewConnectionWindowOpened(evt);
            }
        });

        Type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bezpośrednie połączenie", "HTTP PHP Proxy" }));

        jLabel3.setText("Typ połączenia");

        jLabel4.setText("Host / URL");

        Host.setToolTipText("");

        jLabel5.setText("Login");

        jLabel6.setText("Hasło");

        jLabel7.setText("Port");

        AddConnection.setText("Dodaj połączenie");
        AddConnection.setActionCommand("jButton1");
        AddConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddConnectionActionPerformed(evt);
            }
        });

        TestConnection.setText("Testuj połączenie");
        TestConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestConnectionActionPerformed(evt);
            }
        });

        Port.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout NewConnectionLayout = new javax.swing.GroupLayout(NewConnection.getContentPane());
        NewConnection.getContentPane().setLayout(NewConnectionLayout);
        NewConnectionLayout.setHorizontalGroup(
            NewConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewConnectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NewConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewConnectionLayout.createSequentialGroup()
                        .addComponent(TestConnection)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                        .addComponent(AddConnection))
                    .addGroup(NewConnectionLayout.createSequentialGroup()
                        .addGroup(NewConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(64, 64, 64)
                        .addGroup(NewConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Host)
                            .addComponent(Login)
                            .addComponent(Password)
                            .addComponent(Port))))
                .addContainerGap())
        );
        NewConnectionLayout.setVerticalGroup(
            NewConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewConnectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NewConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(NewConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(NewConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TestConnection)
                    .addComponent(AddConnection))
                .addGap(27, 27, 27))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DBSync");
        setAutoRequestFocus(false);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(800, 350));
        setName("mainFrame"); // NOI18N

        jLabel1.setText("Źródłowa baza:");

        jLabel2.setText("Docelowa baza:");

        Synchronize.setText("Wgraj zmiany");
        Synchronize.setEnabled(false);

        GenerateSQL.setText("Generuj SQL");
        GenerateSQL.setEnabled(false);

        jButton3.setText("Wczytaj schematy baz");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        InfoBox.setColumns(20);
        InfoBox.setRows(5);
        InfoBox.setFocusTraversalPolicyProvider(true);
        InfoBox.setName("infoBox"); // NOI18N
        jScrollPane1.setViewportView(InfoBox);

        srcDbDeleteBtn.setText("Usuń");
        srcDbDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcDbDeleteBtnActionPerformed(evt);
            }
        });

        destDbDeleteBtn.setText("Usuń");
        destDbDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destDbDeleteBtnActionPerformed(evt);
            }
        });

        srcEditBtn.setText("Edytuj");
        srcEditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcEditBtnActionPerformed(evt);
            }
        });

        sedtEditBtn.setText("Edytuj");
        sedtEditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sedtEditBtnActionPerformed(evt);
            }
        });

        MainMenuFile.setText("Plik");

        AddNewConnection.setText("Stwórz nowe połączenie");
        AddNewConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewConnectionActionPerformed(evt);
            }
        });
        MainMenuFile.add(AddNewConnection);

        Quit.setText("Zakończ");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });
        MainMenuFile.add(Quit);

        jMenuBar1.add(MainMenuFile);

        MainMenuHelp.setText("Pomoc");

        MainMenuInformation.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        MainMenuInformation.setText("Informacie");
        MainMenuInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuInformationActionPerformed(evt);
            }
        });
        MainMenuHelp.add(MainMenuInformation);

        jMenuBar1.add(MainMenuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Synchronize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GenerateSQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SourceConnection, 0, 195, Short.MAX_VALUE)
                            .addComponent(DestinationConnection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(destDbDeleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sedtEditBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(srcDbDeleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(srcEditBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SourceConnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(srcDbDeleteBtn)
                            .addComponent(srcEditBtn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(DestinationConnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(destDbDeleteBtn)
                            .addComponent(sedtEditBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(GenerateSQL)
                        .addGap(18, 18, 18)
                        .addComponent(Synchronize))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        setBounds(0, 0, 817, 292);
    }// </editor-fold>//GEN-END:initComponents

    private void MainMenuInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuInformationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MainMenuInformationActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        this.dispose();
    }//GEN-LAST:event_QuitActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void AddNewConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewConnectionActionPerformed
        loadConnection();
        this.NewConnection.setVisible(true);
    }//GEN-LAST:event_AddNewConnectionActionPerformed

    private void TestConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestConnectionActionPerformed
        try {
            Connection c = getConnectionFromForm();
            JOptionPane.showMessageDialog(this.NewConnection, "Udało podłączyć się do bazy danych.");
        } catch (ConnectionException ex) {
            LoggerFactory.getLogger(Main.class).error(ex.toString());
            JOptionPane.showMessageDialog(this.NewConnection, ex.getMessage());
        }
    }//GEN-LAST:event_TestConnectionActionPerformed

    private void NewConnectionWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_NewConnectionWindowOpened
        centeredFrame(this.NewConnection);
    }//GEN-LAST:event_NewConnectionWindowOpened

    private void AddConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddConnectionActionPerformed
        try {
            Connection c = getConnectionFromForm();
            connectionStore.addConnection(c);
            setComboConnections();
            connectionStore.saveStoredData();
            this.NewConnection.setVisible(false);
            JOptionPane.showMessageDialog(this.NewConnection, "Dodano połączenie");
        } catch (StoreException | ConnectionException ex) {
            LoggerFactory.getLogger(Main.class).error(ex.toString());
            JOptionPane.showMessageDialog(this.NewConnection, ex.getMessage());
        }

    }//GEN-LAST:event_AddConnectionActionPerformed

    private void srcDbDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcDbDeleteBtnActionPerformed
        Connection c = (Connection) SourceConnection.getSelectedItem();
        delConnection(c);
        setComboConnections();
    }//GEN-LAST:event_srcDbDeleteBtnActionPerformed

    private void destDbDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destDbDeleteBtnActionPerformed
        Connection c = (Connection) DestinationConnection.getSelectedItem();
        delConnection(c);
        setComboConnections();
    }//GEN-LAST:event_destDbDeleteBtnActionPerformed

    private void srcEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcEditBtnActionPerformed
        Connection c = (Connection) SourceConnection.getSelectedItem();
        loadConnection(c);
        NewConnection.setVisible(true);
    }//GEN-LAST:event_srcEditBtnActionPerformed

    private void sedtEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sedtEditBtnActionPerformed
        Connection c = (Connection) DestinationConnection.getSelectedItem();
        loadConnection(c);
        NewConnection.setVisible(true);
    }//GEN-LAST:event_sedtEditBtnActionPerformed

    private void loadConnection(Connection c) {
        Host.setText(c.getHost());
        Port.setText(c.getPort().toString());
        Login.setText(c.getUsername());
        Password.setText(c.getPassword());
        switch (c.getClass().getName()) {
            case "com.frasiek.dss.connection.Direct":
                Type.setSelectedIndex(0);
                break;
            case "com.frasiek.dss.connection.PhpProxy":
                Type.setSelectedIndex(1);
                break;
        }
    }

    private void loadConnection() {
        Host.setText("");
        Port.setText("");
        Login.setText("");
        Password.setText("");
        Type.setSelectedIndex(-1);
    }

    private void delConnection(Connection c) {
        connectionStore.removeConnection(c);
        try {
            connectionStore.saveStoredData();
        } catch (StoreException ex) {
            LoggerFactory.getLogger(Main.class).error(ex.toString());
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private Connection getConnectionFromForm() throws ConnectionException {
        try {
            Connection c = Manager.getConnection(String.valueOf(Type.getSelectedItem()), Host.getText(), Port.getText(), Login.getText(), String.valueOf(Password.getPassword()));
            if (c.isConnectionOK() == false) {
                throw new ConnectionException("Nie można podłączyć się do bazy danych");
            }
            return c;
        } catch (ConnectionException ex) {
            LoggerFactory.getLogger(Main.class).error(ex.toString());
            throw new ConnectionException("Podane parametry nie są poprawne");
        }
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    public void centeredFrame(javax.swing.JFrame objFrame) {
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        objFrame.setLocation(iCoordX, iCoordY);
    }

    public void centeredFrame(javax.swing.JDialog objDialog) {
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objDialog.getWidth()) / 2;
        int iCoordY = (objDimension.height - objDialog.getHeight()) / 2;
        objDialog.setLocation(iCoordX, iCoordY);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddConnection;
    private javax.swing.JMenuItem AddNewConnection;
    private javax.swing.JComboBox DestinationConnection;
    private javax.swing.JButton GenerateSQL;
    private javax.swing.JTextField Host;
    private javax.swing.JTextArea InfoBox;
    private javax.swing.JTextField Login;
    private javax.swing.JMenu MainMenuFile;
    private javax.swing.JMenu MainMenuHelp;
    private javax.swing.JMenuItem MainMenuInformation;
    private javax.swing.JDialog NewConnection;
    private javax.swing.JPasswordField Password;
    private javax.swing.JFormattedTextField Port;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JComboBox SourceConnection;
    private javax.swing.JButton Synchronize;
    private javax.swing.JButton TestConnection;
    private javax.swing.JComboBox Type;
    private javax.swing.JButton destDbDeleteBtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sedtEditBtn;
    private javax.swing.JButton srcDbDeleteBtn;
    private javax.swing.JButton srcEditBtn;
    // End of variables declaration//GEN-END:variables
}