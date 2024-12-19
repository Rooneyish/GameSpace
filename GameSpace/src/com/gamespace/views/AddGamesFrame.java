
package com.gamespace.views;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

/**
 *
 * @author ilust
 */
public class AddGamesFrame extends javax.swing.JFrame{

    /**
     * Creates new form AddGamesFrame
     */
    public AddGamesFrame() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        initializeGenreCheckBoxes();
    }
    
    private void closeWindow(){
        this.dispose();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlAddGames = new javax.swing.JPanel();
        comboBoxRating = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtFldGameNum = new javax.swing.JTextField();
        lblGameNum = new javax.swing.JLabel();
        lblGameTitle = new javax.swing.JLabel();
        txtFldGameTitle = new javax.swing.JTextField();
        lblMainDevelopers = new javax.swing.JLabel();
        txtFldMainDevelopers = new javax.swing.JTextField();
        lblPublishers = new javax.swing.JLabel();
        txtFldPublishers = new javax.swing.JTextField();
        lblGenres = new javax.swing.JLabel();
        lblGenres1 = new javax.swing.JLabel();
        lblGenres2 = new javax.swing.JLabel();
        comboBoxPlatform = new javax.swing.JComboBox<>();
        txtFldLink = new javax.swing.JTextField();
        lblLink = new javax.swing.JLabel();
        txtFldReleasedYear = new javax.swing.JTextField();
        lblReleasedDate = new javax.swing.JLabel();
        txtFldReleasedMonth = new javax.swing.JTextField();
        txtFldReleasedDay = new javax.swing.JTextField();
        lblSlash1 = new javax.swing.JLabel();
        lblSlash2 = new javax.swing.JLabel();
        btnAddGame = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pnlGenres = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(870, 640));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(233, 232, 231));
        jPanel1.setPreferredSize(new java.awt.Dimension(859, 627));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAddGames.setBackground(new java.awt.Color(145, 49, 117));
        pnlAddGames.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlAddGames.setFocusCycleRoot(true);
        pnlAddGames.setPreferredSize(new java.awt.Dimension(851, 620));

        comboBoxRating.setBackground(new java.awt.Color(32, 38, 46));
        comboBoxRating.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        comboBoxRating.setForeground(new java.awt.Color(233, 232, 231));
        comboBoxRating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " " }));
        comboBoxRating.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        comboBoxRating.setMinimumSize(new java.awt.Dimension(254, 22));

        jLabel1.setFont(new java.awt.Font("Pixelify Sans", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(233, 232, 231));
        jLabel1.setText("Add Games");

        txtFldGameNum.setBackground(new java.awt.Color(32, 38, 46));
        txtFldGameNum.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldGameNum.setForeground(new java.awt.Color(233, 232, 231));
        txtFldGameNum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldGameNum.setPreferredSize(new java.awt.Dimension(254, 42));

        lblGameNum.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblGameNum.setForeground(new java.awt.Color(233, 232, 231));
        lblGameNum.setText("Game No.");

        lblGameTitle.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblGameTitle.setForeground(new java.awt.Color(233, 232, 231));
        lblGameTitle.setText("Game Title");

        txtFldGameTitle.setBackground(new java.awt.Color(32, 38, 46));
        txtFldGameTitle.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldGameTitle.setForeground(new java.awt.Color(233, 232, 231));
        txtFldGameTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldGameTitle.setPreferredSize(new java.awt.Dimension(254, 42));

        lblMainDevelopers.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblMainDevelopers.setForeground(new java.awt.Color(233, 232, 231));
        lblMainDevelopers.setText("Main Developers");

        txtFldMainDevelopers.setBackground(new java.awt.Color(32, 38, 46));
        txtFldMainDevelopers.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldMainDevelopers.setForeground(new java.awt.Color(233, 232, 231));
        txtFldMainDevelopers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldMainDevelopers.setPreferredSize(new java.awt.Dimension(254, 42));

        lblPublishers.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblPublishers.setForeground(new java.awt.Color(233, 232, 231));
        lblPublishers.setText("Publishers");

        txtFldPublishers.setBackground(new java.awt.Color(32, 38, 46));
        txtFldPublishers.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldPublishers.setForeground(new java.awt.Color(233, 232, 231));
        txtFldPublishers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldPublishers.setPreferredSize(new java.awt.Dimension(254, 42));

        lblGenres.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblGenres.setForeground(new java.awt.Color(233, 232, 231));
        lblGenres.setText("Genres");

        lblGenres1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblGenres1.setForeground(new java.awt.Color(233, 232, 231));
        lblGenres1.setText("Platform");

        lblGenres2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblGenres2.setForeground(new java.awt.Color(233, 232, 231));
        lblGenres2.setText("Rating");

        comboBoxPlatform.setBackground(new java.awt.Color(32, 38, 46));
        comboBoxPlatform.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        comboBoxPlatform.setForeground(new java.awt.Color(233, 232, 231));
        comboBoxPlatform.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PC", "Play Station", "XBox" }));
        comboBoxPlatform.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        comboBoxPlatform.setMinimumSize(new java.awt.Dimension(254, 22));

        txtFldLink.setBackground(new java.awt.Color(32, 38, 46));
        txtFldLink.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldLink.setForeground(new java.awt.Color(233, 232, 231));
        txtFldLink.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldLink.setPreferredSize(new java.awt.Dimension(254, 42));

        lblLink.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblLink.setForeground(new java.awt.Color(233, 232, 231));
        lblLink.setText("Link");

        txtFldReleasedYear.setBackground(new java.awt.Color(32, 38, 46));
        txtFldReleasedYear.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldReleasedYear.setForeground(new java.awt.Color(233, 232, 231));
        txtFldReleasedYear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldReleasedYear.setPreferredSize(new java.awt.Dimension(84, 42));

        lblReleasedDate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblReleasedDate.setForeground(new java.awt.Color(233, 232, 231));
        lblReleasedDate.setText("Released Date");

        txtFldReleasedMonth.setBackground(new java.awt.Color(32, 38, 46));
        txtFldReleasedMonth.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldReleasedMonth.setForeground(new java.awt.Color(233, 232, 231));
        txtFldReleasedMonth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldReleasedMonth.setPreferredSize(new java.awt.Dimension(64, 42));

        txtFldReleasedDay.setBackground(new java.awt.Color(32, 38, 46));
        txtFldReleasedDay.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldReleasedDay.setForeground(new java.awt.Color(233, 232, 231));
        txtFldReleasedDay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldReleasedDay.setPreferredSize(new java.awt.Dimension(64, 42));

        lblSlash1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblSlash1.setForeground(new java.awt.Color(233, 232, 231));
        lblSlash1.setText("/");

        lblSlash2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblSlash2.setForeground(new java.awt.Color(233, 232, 231));
        lblSlash2.setText("/");

        btnAddGame.setBackground(new java.awt.Color(205, 88, 136));
        btnAddGame.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnAddGame.setForeground(new java.awt.Color(32, 38, 46));
        btnAddGame.setText("Add Game");
        btnAddGame.setBorder(null);
        btnAddGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGameActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/closeIcon.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGenresLayout = new javax.swing.GroupLayout(pnlGenres);
        pnlGenres.setLayout(pnlGenresLayout);
        pnlGenresLayout.setHorizontalGroup(
            pnlGenresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );
        pnlGenresLayout.setVerticalGroup(
            pnlGenresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlAddGamesLayout = new javax.swing.GroupLayout(pnlAddGames);
        pnlAddGames.setLayout(pnlAddGamesLayout);
        pnlAddGamesLayout.setHorizontalGroup(
            pnlAddGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddGamesLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(pnlAddGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddGamesLayout.createSequentialGroup()
                        .addGroup(pnlAddGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGameNum)
                            .addComponent(txtFldPublishers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPublishers)
                            .addComponent(txtFldMainDevelopers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMainDevelopers)
                            .addComponent(txtFldGameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGameTitle)
                            .addComponent(txtFldGameNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                        .addGroup(pnlAddGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGenres1)
                            .addComponent(lblGenres2)
                            .addComponent(comboBoxRating, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFldLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLink)
                            .addComponent(comboBoxPlatform, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReleasedDate)
                            .addGroup(pnlAddGamesLayout.createSequentialGroup()
                                .addComponent(txtFldReleasedYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSlash1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFldReleasedMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSlash2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFldReleasedDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(84, 84, 84))
                    .addGroup(pnlAddGamesLayout.createSequentialGroup()
                        .addGroup(pnlAddGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAddGamesLayout.createSequentialGroup()
                                .addComponent(pnlGenres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddGame, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(pnlAddGamesLayout.createSequentialGroup()
                                .addGroup(pnlAddGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(pnlAddGamesLayout.createSequentialGroup()
                                .addComponent(lblGenres)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addContainerGap())))
        );
        pnlAddGamesLayout.setVerticalGroup(
            pnlAddGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddGamesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlAddGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddGamesLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addComponent(jLabel3)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(pnlAddGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddGamesLayout.createSequentialGroup()
                        .addComponent(lblGameNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFldGameNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblGameTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFldGameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(lblMainDevelopers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFldMainDevelopers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPublishers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFldPublishers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddGamesLayout.createSequentialGroup()
                        .addComponent(lblGenres1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxPlatform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGenres2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxRating, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLink)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFldLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblReleasedDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAddGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFldReleasedYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFldReleasedMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFldReleasedDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSlash1)
                            .addComponent(lblSlash2))))
                .addGap(18, 18, 18)
                .addComponent(lblGenres)
                .addGroup(pnlAddGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddGamesLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnAddGame, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddGamesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlGenres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        jPanel1.add(pnlAddGames, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        closeWindow();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void initializeGenreCheckBoxes() {
    String[] genres = {"Action", "Adventure", "Role-Playing", "Simulation", "Sports", "Strategy"};

    for (String genre : genres) {
        JCheckBox checkBox = new JCheckBox(genre); // Create checkbox for each genre
        pnlGenres.add(checkBox);                  // Add checkbox to the JPanel
    }

    pnlGenres.revalidate(); // Refresh the panel to reflect the changes
    pnlGenres.repaint();
    }

    
    private void btnAddGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGameActionPerformed
        // TODO add your handling code here:
        String gameNum= txtFldGameNum.getText();
        String gameTitle= txtFldGameTitle.getText();
        String mainDevelopers= txtFldMainDevelopers.getText();
        String publishers = txtFldPublishers.getText();
        String platform = String.valueOf((String)comboBoxPlatform.getSelectedItem());
        int rating = Integer.parseInt((String)comboBoxRating.getSelectedItem());
    }//GEN-LAST:event_btnAddGameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddGame;
    private javax.swing.JComboBox<String> comboBoxPlatform;
    private javax.swing.JComboBox<String> comboBoxRating;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblGameNum;
    private javax.swing.JLabel lblGameTitle;
    private javax.swing.JLabel lblGenres;
    private javax.swing.JLabel lblGenres1;
    private javax.swing.JLabel lblGenres2;
    private javax.swing.JLabel lblLink;
    private javax.swing.JLabel lblMainDevelopers;
    private javax.swing.JLabel lblPublishers;
    private javax.swing.JLabel lblReleasedDate;
    private javax.swing.JLabel lblSlash1;
    private javax.swing.JLabel lblSlash2;
    private javax.swing.JPanel pnlAddGames;
    private javax.swing.JPanel pnlGenres;
    private javax.swing.JTextField txtFldGameNum;
    private javax.swing.JTextField txtFldGameTitle;
    private javax.swing.JTextField txtFldLink;
    private javax.swing.JTextField txtFldMainDevelopers;
    private javax.swing.JTextField txtFldPublishers;
    private javax.swing.JTextField txtFldReleasedDay;
    private javax.swing.JTextField txtFldReleasedMonth;
    private javax.swing.JTextField txtFldReleasedYear;
    // End of variables declaration//GEN-END:variables
}
