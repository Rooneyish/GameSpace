package com.gamespace.views;

import com.gamespace.controller.algorithms.CustomBinarySearch;
import com.gamespace.controller.algorithms.CustomInsertionSort;
import com.gamespace.controller.algorithms.CustomMergeSort;
import com.gamespace.controller.algorithms.CustomSelectionSort;
import com.gamespace.controller.datastructure.CustomQueue;
import com.gamespace.controller.datastructure.CustomStack;
import com.gamespace.util.ValidationUtil;
import com.gamespace.model.GameModel;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronish Prajapati LmuID: 23048584
 */
public class GameSpace extends javax.swing.JFrame {

    private java.awt.CardLayout cardLayout;
    private List<GameModel> gameList;
    private com.gamespace.util.ValidationUtil validation;
    private com.gamespace.controller.datastructure.CustomStack myLibrary;
    private com.gamespace.controller.datastructure.CustomQueue playGameQueue;

    /**
     * Creates new form GameSpace
     */
    public GameSpace() {
        setUndecorated(true);
        initComponents();
        initializeLayout();
        initializeTools();
        initializeData();
        startProgress();
        jScrollPane2.setVisible(false);
        btnSearchReset.setVisible(false);
    }

    private void initializeTools() {
        gameList = new ArrayList();
        validation = new ValidationUtil();
        myLibrary = new CustomStack(100);
        playGameQueue = new CustomQueue(100);
    }

    private void initializeLayout() {
        cardLayout = new java.awt.CardLayout();
        getContentPane().setLayout(cardLayout);

        getContentPane().add(pnlWelcome, "WelcomeScreen");
        getContentPane().add(pnlMainLogIn, "LogInScreen");
        getContentPane().add(pnlAdmin, "AdminScreen");
        getContentPane().add(pnlAddGamesOuter, "AddGamesScreeen");
        getContentPane().add(pnlUpdateGamesOuter, "UpdateGamesScreen");
        getContentPane().add(pnlMyLibrary, "MyLibraryScreen");

        cardLayout.show(getContentPane(), "WelcomeScreen");
    }

    private void initializeData() {
        addGamesToTable(new GameModel(1, "CS:GO", "Valve", "Valve", "PC", "2012/08/21", "Action, Shooting", 4, "Free", "https://www.counter-strike.net"));
        addGamesToTable(new GameModel(12, "CS:Source", "Valve", "Valve", "PC", "2004/11/01", "Action, Shooting", 4, "$20", "https://www.counter-strike.net"));
        addGamesToTable(new GameModel(3, "Minecraft", "Mojang Studios", "Mojang Studios", "PC", "2011/11/18", "Simulation, Adventure", 5, "Free", "https://www.minecraft.net"));
        addGamesToTable(new GameModel(4, "Fortnite", "Epic Games", "Epic Games", "PC", "2017/07/25", "Action, Battle Royale", 5, "Free", "https://www.epicgames.com/fortnite"));
        addGamesToTable(new GameModel(10, "Apex Legends", "Respawn Entertainment", "Electronic Arts", "PC", "2019/02/04", "Action, Shooter", 5, "Free", "https://www.ea.com/games/apex-legends"));
        addGamesToTable(new GameModel(16, "League of Legends", "Riot Games", "Riot Games", "PC", "2009/10/27", "Action, MOBA", 5, "Free", "https://www.leagueoflegends.com"));
        addGamesToTable(new GameModel(7, "Valorant", "Riot Games", "Riot Games", "PC", "2020/06/02", "Action, Shooter", 4, "Free", "https://playvalorant.com"));
        addGamesToTable(new GameModel(14, "Red Dead Redemption 2", "Rockstar Studios", "Rockstar Games", "Console", "2018/10/26", "Action, Adventure", 5, "$60", "https://www.rockstargames.com/reddeadredemption2"));
        addGamesToTable(new GameModel(15, "The Elder Scrolls V: Skyrim", "Bethesda Game Studios", "Bethesda Softworks", "Console", "2011/11/11", "Role-Playing, Action", 5, "$40", "https://elderscrolls.bethesda.net"));
        addGamesToTable(new GameModel(5, "Halo: Infinite", "343 Industries", "Xbox Game Studios", "Console", "2021/12/08", "Action, Shooter", 4, "$60", "https://www.halowaypoint.com"));
        addGamesToTable(new GameModel(11, "Forza Horizon 5", "Playground Games", "Xbox Game Studios", "Console", "2021/11/09", "Racing/Driving", 5, "$60", "https://www.forzamotorsport.net"));
        addGamesToTable(new GameModel(2, "FIFA 22", "EA Sports", "Electronic Arts", "Console", "2021/10/01", "Sports", 4, "$60", "https://www.ea.com/games/fifa"));
        addGamesToTable(new GameModel(13, "Civilization VI", "Firaxis Games", "2K Games", "PC", "2016/10/21", "Strategy", 5, "$60", "https://www.civilization.com"));
        addGamesToTable(new GameModel(8, "Football Manager 2022", "Sports Interactive", "SEGA", "PC", "2021/11/09", "Sports, Simulation", 4, "$50", "https://www.footballmanager.com"));
        addGamesToTable(new GameModel(9, "Age of Empires IV", "Relic Entertainment", "Xbox Game Studios", "PC", "2021/10/28", "Strategy, Simulation", 5, "$60", "https://www.ageofempires.com"));

        CustomInsertionSort sorter = new CustomInsertionSort();
        List<GameModel> sortedNum = sorter.sortByGameNum(gameList, false);
        gameList = sortedNum;
        tableUpdator();

    }

    private void tableUpdator() {
        DefaultTableModel model = (DefaultTableModel) tblGameData.getModel();
        model.setRowCount(0);

        for (GameModel game : gameList) {
            model.addRow(new Object[]{
                game.getGameNum(),
                game.getGameName(),
                game.getMainDevelopers(),
                game.getPublishers(),
                game.getPlatform(),
                game.getReleasedDate(),
                game.getGenres(),
                game.getRating(),
                game.getPrice(),
                game.getLink()
            });
        }
    }

    public void addGamesToTable(GameModel game) {
        gameList.add(game);
        tableUpdator();
    }

    private void startProgress() {
        javax.swing.SwingWorker<Void, Integer> worker = new javax.swing.SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(0); // Simulated delay for progress bar
                    publish(i);
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                int progress = chunks.get(chunks.size() - 1);
                pgBarWelcomeScreen.setValue(progress);
            }

            @Override
            protected void done() {
                loadScreen("LogInScreen"); // Switch to login screen
            }
        };
        worker.execute();
    }

    private void loadScreen(String screenName) {
        cardLayout.show(getContentPane(), screenName);
    }

    private void closeWindow() {
        WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
    }

    private void minimizeWindow() {
        setExtendedState(JFrame.ICONIFIED);
    }

    private void logout() {
        loadScreen("LogInScreen");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainLogIn = new javax.swing.JPanel();
        btnMinimizeLogIn = new javax.swing.JButton();
        btnCloseLogIn = new javax.swing.JButton();
        pnlWelcomeLogIn = new CustomRoundedPanel(80, new Color(145, 49, 117));
        pnlLogInBorder = new CustomRoundedPanel(80, new Color(233, 232, 231));
        pnlLogIn = new CustomRoundedPanel(70,new Color(32, 38, 46));
        lblLogInTitle = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtFldUsername = new javax.swing.JTextField();
        txtFldPassword = new javax.swing.JPasswordField();
        lblForgotPassword = new javax.swing.JLabel();
        pnlLogInbtn = new javax.swing.JPanel();
        btnLogIn = new javax.swing.JButton();
        lblHaveAccount = new javax.swing.JLabel();
        lblLoginError = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblLogInBackground = new javax.swing.JLabel();
        pnlAdmin = new javax.swing.JPanel();
        pnlSidebar = new javax.swing.JPanel();
        lblAdminIcon = new javax.swing.JLabel();
        btnLogoutAdmin = new javax.swing.JButton();
        btnMyLibrary = new javax.swing.JButton();
        pnlSearchBar = new javax.swing.JPanel();
        lblLogoAdmin = new javax.swing.JLabel();
        txtFldSearchAdmin = new javax.swing.JTextField();
        btnCloseWinAdmin = new javax.swing.JButton();
        btnMinimizeWinAdmin = new javax.swing.JButton();
        btnAdminSearch = new javax.swing.JButton();
        pnlDashboard = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGameData1 = new javax.swing.JTable();
        divider = new javax.swing.JPanel();
        btnSearchReset = new javax.swing.JButton();
        pnlGameData = new javax.swing.JPanel();
        lblGameData = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGameData = new javax.swing.JTable();
        btnAddGames = new javax.swing.JButton();
        btnRemoveGames = new javax.swing.JButton();
        btnUpdateGames = new javax.swing.JButton();
        comboBoxSorts = new javax.swing.JComboBox<>();
        btnAddToMyLibrary = new javax.swing.JButton();
        btnUndoAddToLibrary = new javax.swing.JButton();
        pnlTotalAdmin = new CustomRoundedPanel(80, new Color(145,49,117));
        lblTotalAdmin = new javax.swing.JLabel();
        lblAdminNum = new javax.swing.JLabel();
        lblAdminIC = new javax.swing.JLabel();
        pnlTotalUsers = new CustomRoundedPanel(80, new Color(145,49,117));
        lblTotalUsers = new javax.swing.JLabel();
        lblUsersNum = new javax.swing.JLabel();
        lblUserIcon = new javax.swing.JLabel();
        pnlTotalGames = new CustomRoundedPanel(80, new Color(145,49,117));
        lblTotalGames = new javax.swing.JLabel();
        lblGamesNum = new javax.swing.JLabel();
        lblGameIcon = new javax.swing.JLabel();
        pnlDashboardBg = new javax.swing.JLabel();
        pnlAddGamesOuter = new javax.swing.JPanel();
        pnlAddGamesBorder = new javax.swing.JPanel();
        pnlAddGamesFrame = new javax.swing.JPanel();
        comboBoxRating = new javax.swing.JComboBox<>();
        lblAddGames = new javax.swing.JLabel();
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
        checkBoxAction = new javax.swing.JCheckBox();
        checkBoxAdventures = new javax.swing.JCheckBox();
        checkBoxEducational = new javax.swing.JCheckBox();
        checkBoxRolePlaying = new javax.swing.JCheckBox();
        checkBoxRacing = new javax.swing.JCheckBox();
        checkBoxSimulation = new javax.swing.JCheckBox();
        checkBoxSports = new javax.swing.JCheckBox();
        checkBoxStrategy = new javax.swing.JCheckBox();
        btnCloseAddGames = new javax.swing.JButton();
        txtFldPrice = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        checkBoxShooting = new javax.swing.JCheckBox();
        lblAddGamesBG = new javax.swing.JLabel();
        pnlUpdateGamesOuter = new javax.swing.JPanel();
        pnlUpdateGamesBorder = new javax.swing.JPanel();
        pnlUpdateGamesFrame = new javax.swing.JPanel();
        comboBoxRatingUpdate = new javax.swing.JComboBox<>();
        lblUpdateGames = new javax.swing.JLabel();
        txtFldGameNumUpdate = new javax.swing.JTextField();
        lblGameNumUpdate = new javax.swing.JLabel();
        lblGameTitleUpdate = new javax.swing.JLabel();
        txtFldGameTitleUpdate = new javax.swing.JTextField();
        lblMainDevelopersUpdate = new javax.swing.JLabel();
        txtFldMainDevelopersUpdate = new javax.swing.JTextField();
        lblPublishersUpdate = new javax.swing.JLabel();
        txtFldPublishersUpdate = new javax.swing.JTextField();
        lblGenresUpdate = new javax.swing.JLabel();
        lblPlatformsUpdate = new javax.swing.JLabel();
        lblRatingUpdate = new javax.swing.JLabel();
        comboBoxPlatformUpdate = new javax.swing.JComboBox<>();
        txtFldLinkUpdate = new javax.swing.JTextField();
        lblLinkUpdate = new javax.swing.JLabel();
        txtFldReleasedYearUpdate = new javax.swing.JTextField();
        lblReleasedDateUpdate = new javax.swing.JLabel();
        txtFldReleasedMonthUpdate = new javax.swing.JTextField();
        txtFldReleasedDayUpdate = new javax.swing.JTextField();
        lblSlash3 = new javax.swing.JLabel();
        lblSlash4 = new javax.swing.JLabel();
        btnUpdateGame = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        checkBoxActionUpdate = new javax.swing.JCheckBox();
        checkBoxAdventuresUpdate = new javax.swing.JCheckBox();
        checkBoxEducationalUpdate = new javax.swing.JCheckBox();
        checkBoxRolePlayingUpdate = new javax.swing.JCheckBox();
        checkBoxRacingUpdate = new javax.swing.JCheckBox();
        checkBoxSimulationUpdate = new javax.swing.JCheckBox();
        checkBoxSportsUpdate = new javax.swing.JCheckBox();
        checkBoxStrategyUpdate = new javax.swing.JCheckBox();
        btnCloseUpdateGames = new javax.swing.JButton();
        checkBoxShootingUpdate = new javax.swing.JCheckBox();
        txtFldPriceUpdate = new javax.swing.JTextField();
        lblPriceUpdate = new javax.swing.JLabel();
        lblUpdateGamesBG = new javax.swing.JLabel();
        pnlMyLibrary = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlGameData1 = new javax.swing.JPanel();
        lblGameData1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMyLibraryData = new javax.swing.JTable();
        btnMyLibraryPlayGame = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnMyLibraryGoBack = new javax.swing.JButton();
        lblCurrentlyPlaying = new javax.swing.JLabel();
        lblCurrentStatus = new javax.swing.JLabel();
        lblMyLibraryBackground = new javax.swing.JLabel();
        pnlWelcome = new javax.swing.JPanel();
        pgBarWelcomeScreen = new javax.swing.JProgressBar();
        lblWelcome = new javax.swing.JLabel();
        lblWlcPgLogo = new javax.swing.JLabel();
        lblWelcomePageImg = new javax.swing.JLabel();

        pnlMainLogIn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMinimizeLogIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/minmize-icon.png"))); // NOI18N
        btnMinimizeLogIn.setBorder(null);
        btnMinimizeLogIn.setBorderPainted(false);
        btnMinimizeLogIn.setContentAreaFilled(false);
        btnMinimizeLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeLogInActionPerformed(evt);
            }
        });
        pnlMainLogIn.add(btnMinimizeLogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1860, 10, -1, -1));

        btnCloseLogIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/closeIcon.png"))); // NOI18N
        btnCloseLogIn.setBorder(null);
        btnCloseLogIn.setBorderPainted(false);
        btnCloseLogIn.setContentAreaFilled(false);
        btnCloseLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseLogInActionPerformed(evt);
            }
        });
        pnlMainLogIn.add(btnCloseLogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1890, 10, -1, -1));

        pnlWelcomeLogIn.setBackground(new java.awt.Color(145, 49, 117));
        pnlWelcomeLogIn.setPreferredSize(new java.awt.Dimension(1280, 700));

        pnlLogInBorder.setBackground(new java.awt.Color(233, 232, 231));
        pnlLogInBorder.setPreferredSize(new java.awt.Dimension(650, 700));
        pnlLogInBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogIn.setBackground(new java.awt.Color(32, 38, 46));
        pnlLogIn.setPreferredSize(new java.awt.Dimension(640, 700));

        lblLogInTitle.setBackground(new java.awt.Color(233, 232, 231));
        lblLogInTitle.setFont(new java.awt.Font("Pixelify Sans", 0, 32)); // NOI18N
        lblLogInTitle.setForeground(new java.awt.Color(233, 232, 231));
        lblLogInTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogInTitle.setText("Log-In To GameSpace");

        lblUsername.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(233, 232, 231));
        lblUsername.setText("Username");

        lblPassword.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(233, 232, 231));
        lblPassword.setText("Password");

        txtFldUsername.setBackground(new java.awt.Color(145, 49, 117));
        txtFldUsername.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldUsername.setForeground(new java.awt.Color(233, 232, 231));
        txtFldUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldUsername.setPreferredSize(new java.awt.Dimension(368, 42));

        txtFldPassword.setBackground(new java.awt.Color(145, 49, 117));
        txtFldPassword.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldPassword.setForeground(new java.awt.Color(233, 232, 231));
        txtFldPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldPassword.setPreferredSize(new java.awt.Dimension(368, 42));

        lblForgotPassword.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblForgotPassword.setForeground(new java.awt.Color(233, 232, 231));
        lblForgotPassword.setText("Forgot Password?");
        lblForgotPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        pnlLogInbtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        pnlLogInbtn.setPreferredSize(new java.awt.Dimension(147, 43));

        btnLogIn.setBackground(new java.awt.Color(32, 38, 46));
        btnLogIn.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnLogIn.setForeground(new java.awt.Color(233, 232, 231));
        btnLogIn.setText("Log-In");
        btnLogIn.setBorder(null);
        btnLogIn.setBorderPainted(false);
        btnLogIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogIn.setPreferredSize(new java.awt.Dimension(141, 37));
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLogInbtnLayout = new javax.swing.GroupLayout(pnlLogInbtn);
        pnlLogInbtn.setLayout(pnlLogInbtnLayout);
        pnlLogInbtnLayout.setHorizontalGroup(
            pnlLogInbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogInbtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlLogInbtnLayout.setVerticalGroup(
            pnlLogInbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogInbtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblHaveAccount.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblHaveAccount.setForeground(new java.awt.Color(233, 232, 231));
        lblHaveAccount.setText("Don't have a Account?");

        lblLoginError.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblLoginError.setForeground(new java.awt.Color(217, 84, 79));
        lblLoginError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlLogInLayout = new javax.swing.GroupLayout(pnlLogIn);
        pnlLogIn.setLayout(pnlLogInLayout);
        pnlLogInLayout.setHorizontalGroup(
            pnlLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogInLayout.createSequentialGroup()
                .addGroup(pnlLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlLogInLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLoginError, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlLogInLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(pnlLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlLogInLayout.createSequentialGroup()
                                .addComponent(pnlLogInbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(lblHaveAccount))
                            .addGroup(pnlLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblForgotPassword)
                                .addComponent(txtFldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPassword)
                                .addComponent(txtFldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblUsername)
                                .addComponent(lblLogInTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        pnlLogInLayout.setVerticalGroup(
            pnlLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogInLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(lblLogInTitle)
                .addGap(18, 18, 18)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblForgotPassword)
                .addGap(18, 18, 18)
                .addGroup(pnlLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblHaveAccount)
                    .addComponent(pnlLogInbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblLoginError)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        pnlLogInBorder.add(pnlLogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/logoGameSpaceResized.png"))); // NOI18N

        javax.swing.GroupLayout pnlWelcomeLogInLayout = new javax.swing.GroupLayout(pnlWelcomeLogIn);
        pnlWelcomeLogIn.setLayout(pnlWelcomeLogInLayout);
        pnlWelcomeLogInLayout.setHorizontalGroup(
            pnlWelcomeLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWelcomeLogInLayout.createSequentialGroup()
                .addGap(0, 89, Short.MAX_VALUE)
                .addComponent(lblLogo)
                .addGap(78, 78, 78)
                .addComponent(pnlLogInBorder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlWelcomeLogInLayout.setVerticalGroup(
            pnlWelcomeLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWelcomeLogInLayout.createSequentialGroup()
                .addComponent(pnlLogInBorder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlWelcomeLogInLayout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(lblLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMainLogIn.add(pnlWelcomeLogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 1280, -1));

        lblLogInBackground.setBackground(new java.awt.Color(145, 49, 117));
        lblLogInBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/loginpage Background.png"))); // NOI18N
        pnlMainLogIn.add(lblLogInBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlAdmin.setPreferredSize(new java.awt.Dimension(1920, 1080));
        pnlAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSidebar.setBackground(new java.awt.Color(32, 38, 46));
        pnlSidebar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        pnlSidebar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblAdminIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/crown.png"))); // NOI18N

        btnLogoutAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/logout.png"))); // NOI18N
        btnLogoutAdmin.setBorder(null);
        btnLogoutAdmin.setBorderPainted(false);
        btnLogoutAdmin.setContentAreaFilled(false);
        btnLogoutAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogoutAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutAdminActionPerformed(evt);
            }
        });

        btnMyLibrary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/book stack.png"))); // NOI18N
        btnMyLibrary.setBorder(null);
        btnMyLibrary.setBorderPainted(false);
        btnMyLibrary.setContentAreaFilled(false);
        btnMyLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyLibraryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSidebarLayout = new javax.swing.GroupLayout(pnlSidebar);
        pnlSidebar.setLayout(pnlSidebarLayout);
        pnlSidebarLayout.setHorizontalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSidebarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogoutAdmin)
                    .addComponent(lblAdminIcon))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSidebarLayout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(btnMyLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlSidebarLayout.setVerticalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAdminIcon)
                .addGap(40, 40, 40)
                .addComponent(btnMyLibrary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 842, Short.MAX_VALUE)
                .addComponent(btnLogoutAdmin)
                .addGap(22, 22, 22))
        );

        pnlAdmin.add(pnlSidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 120, 1100));

        pnlSearchBar.setBackground(new java.awt.Color(145, 49, 117));
        pnlSearchBar.setPreferredSize(new java.awt.Dimension(1820, 100));

        lblLogoAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/Untitled-1.png"))); // NOI18N

        txtFldSearchAdmin.setBackground(new java.awt.Color(233, 232, 231));
        txtFldSearchAdmin.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtFldSearchAdmin.setForeground(new java.awt.Color(145, 49, 117));
        txtFldSearchAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(32, 38, 46), 5));
        txtFldSearchAdmin.setPreferredSize(new java.awt.Dimension(1275, 45));

        btnCloseWinAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/closeIcon.png"))); // NOI18N
        btnCloseWinAdmin.setBorder(null);
        btnCloseWinAdmin.setBorderPainted(false);
        btnCloseWinAdmin.setContentAreaFilled(false);
        btnCloseWinAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseWinAdminActionPerformed(evt);
            }
        });

        btnMinimizeWinAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/minmize-icon.png"))); // NOI18N
        btnMinimizeWinAdmin.setBorder(null);
        btnMinimizeWinAdmin.setBorderPainted(false);
        btnMinimizeWinAdmin.setContentAreaFilled(false);
        btnMinimizeWinAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeWinAdminActionPerformed(evt);
            }
        });

        btnAdminSearch.setBackground(new java.awt.Color(32, 38, 46));
        btnAdminSearch.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btnAdminSearch.setForeground(new java.awt.Color(233, 232, 231));
        btnAdminSearch.setText("Search");
        btnAdminSearch.setBorder(null);
        btnAdminSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchBarLayout = new javax.swing.GroupLayout(pnlSearchBar);
        pnlSearchBar.setLayout(pnlSearchBarLayout);
        pnlSearchBarLayout.setHorizontalGroup(
            pnlSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchBarLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(lblLogoAdmin)
                .addGap(51, 51, 51)
                .addComponent(txtFldSearchAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdminSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMinimizeWinAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCloseWinAdmin)
                .addContainerGap())
        );
        pnlSearchBarLayout.setVerticalGroup(
            pnlSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchBarLayout.createSequentialGroup()
                .addGroup(pnlSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSearchBarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblLogoAdmin)
                            .addComponent(txtFldSearchAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdminSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlSearchBarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnMinimizeWinAdmin))
                    .addGroup(pnlSearchBarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnCloseWinAdmin)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pnlAdmin.add(pnlSearchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 1820, -1));

        pnlDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.setBackground(null);
        jScrollPane2.getViewport().setBorder(null);

        tblGameData1.setOpaque(false);
        ((DefaultTableCellRenderer)tblGameData1.getDefaultRenderer(Object.class)).setOpaque(false);
        tblGameData1.setShowGrid(false);
        tblGameData1.getTableHeader().setFont(new java.awt.Font("Roboto", 0,16 ));
        tblGameData1.getTableHeader().setOpaque(false);
        tblGameData1.getTableHeader().setBackground(new Color(145,49,117));
        tblGameData1.getTableHeader().setForeground(new Color(233,232,231));
        tblGameData1.setRowHeight(40);
        tblGameData1.setBorder(null);
        tblGameData1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        tblGameData1.setForeground(new java.awt.Color(233, 232, 231));
        tblGameData1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Game No.", "Game Title", "Main Developers", "Publisher", "Plaform", "Released Date", "Genres", "Rating", "Price", "Link"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGameData1.setFocusable(false);
        tblGameData1.setRequestFocusEnabled(false);
        tblGameData1.setRowHeight(40);
        tblGameData1.setSelectionBackground(new java.awt.Color(145, 49, 117));
        tblGameData1.setSelectionForeground(new java.awt.Color(145, 49, 117));
        tblGameData1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblGameData1.setShowGrid(false);
        tblGameData1.setShowHorizontalLines(true);
        tblGameData1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblGameData1);
        if (tblGameData1.getColumnModel().getColumnCount() > 0) {
            tblGameData1.getColumnModel().getColumn(0).setResizable(false);
            tblGameData1.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblGameData1.getColumnModel().getColumn(1).setResizable(false);
            tblGameData1.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblGameData1.getColumnModel().getColumn(2).setResizable(false);
            tblGameData1.getColumnModel().getColumn(2).setPreferredWidth(180);
            tblGameData1.getColumnModel().getColumn(3).setResizable(false);
            tblGameData1.getColumnModel().getColumn(3).setPreferredWidth(170);
            tblGameData1.getColumnModel().getColumn(4).setResizable(false);
            tblGameData1.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblGameData1.getColumnModel().getColumn(5).setResizable(false);
            tblGameData1.getColumnModel().getColumn(5).setPreferredWidth(120);
            tblGameData1.getColumnModel().getColumn(6).setResizable(false);
            tblGameData1.getColumnModel().getColumn(6).setPreferredWidth(250);
            tblGameData1.getColumnModel().getColumn(7).setResizable(false);
            tblGameData1.getColumnModel().getColumn(7).setPreferredWidth(80);
            tblGameData1.getColumnModel().getColumn(8).setResizable(false);
            tblGameData1.getColumnModel().getColumn(8).setPreferredWidth(80);
            tblGameData1.getColumnModel().getColumn(9).setResizable(false);
            tblGameData1.getColumnModel().getColumn(9).setPreferredWidth(280);
        }

        pnlDashboard.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1771, 260));

        divider.setBackground(new java.awt.Color(233, 232, 231));
        divider.setPreferredSize(new java.awt.Dimension(1800, 5));

        javax.swing.GroupLayout dividerLayout = new javax.swing.GroupLayout(divider);
        divider.setLayout(dividerLayout);
        dividerLayout.setHorizontalGroup(
            dividerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1800, Short.MAX_VALUE)
        );
        dividerLayout.setVerticalGroup(
            dividerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlDashboard.add(divider, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 1800, 10));

        btnSearchReset.setBackground(new java.awt.Color(145, 49, 117));
        btnSearchReset.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btnSearchReset.setForeground(new java.awt.Color(233, 232, 231));
        btnSearchReset.setText("Search Reset");
        btnSearchReset.setBorder(null);
        btnSearchReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchResetActionPerformed(evt);
            }
        });
        pnlDashboard.add(btnSearchReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 280, 113, 27));

        pnlGameData.setBackground(new java.awt.Color(32, 38, 46));
        pnlGameData.setOpaque(false);

        lblGameData.setFont(new java.awt.Font("Pixelify Sans", 0, 24)); // NOI18N
        lblGameData.setForeground(new java.awt.Color(233, 232, 231));
        lblGameData.setText("Game Data");

        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setBackground(null);
        jScrollPane1.getViewport().setBorder(null);

        tblGameData.setOpaque(false);
        ((DefaultTableCellRenderer)tblGameData.getDefaultRenderer(Object.class)).setOpaque(false);
        tblGameData.setShowGrid(false);
        tblGameData.getTableHeader().setFont(new java.awt.Font("Roboto", 0,16 ));
        tblGameData.getTableHeader().setOpaque(false);
        tblGameData.getTableHeader().setBackground(new Color(145,49,117));
        tblGameData.getTableHeader().setForeground(new Color(233,232,231));
        tblGameData.setRowHeight(40);
        tblGameData.setBorder(null);
        tblGameData.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        tblGameData.setForeground(new java.awt.Color(233, 232, 231));
        tblGameData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Game No.", "Game Title", "Main Developers", "Publisher", "Plaform", "Released Date", "Genres", "Rating", "Price", "Link"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGameData.setFocusable(false);
        tblGameData.setRequestFocusEnabled(false);
        tblGameData.setRowHeight(40);
        tblGameData.setSelectionBackground(new java.awt.Color(145, 49, 117));
        tblGameData.setSelectionForeground(new java.awt.Color(145, 49, 117));
        tblGameData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblGameData.setShowGrid(false);
        tblGameData.setShowHorizontalLines(true);
        tblGameData.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblGameData);
        if (tblGameData.getColumnModel().getColumnCount() > 0) {
            tblGameData.getColumnModel().getColumn(0).setResizable(false);
            tblGameData.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblGameData.getColumnModel().getColumn(1).setResizable(false);
            tblGameData.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblGameData.getColumnModel().getColumn(2).setResizable(false);
            tblGameData.getColumnModel().getColumn(2).setPreferredWidth(180);
            tblGameData.getColumnModel().getColumn(3).setResizable(false);
            tblGameData.getColumnModel().getColumn(3).setPreferredWidth(170);
            tblGameData.getColumnModel().getColumn(4).setResizable(false);
            tblGameData.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblGameData.getColumnModel().getColumn(5).setResizable(false);
            tblGameData.getColumnModel().getColumn(5).setPreferredWidth(120);
            tblGameData.getColumnModel().getColumn(6).setResizable(false);
            tblGameData.getColumnModel().getColumn(6).setPreferredWidth(250);
            tblGameData.getColumnModel().getColumn(7).setResizable(false);
            tblGameData.getColumnModel().getColumn(7).setPreferredWidth(80);
            tblGameData.getColumnModel().getColumn(8).setResizable(false);
            tblGameData.getColumnModel().getColumn(8).setPreferredWidth(80);
            tblGameData.getColumnModel().getColumn(9).setResizable(false);
            tblGameData.getColumnModel().getColumn(9).setPreferredWidth(280);
        }

        btnAddGames.setBackground(new java.awt.Color(145, 49, 117));
        btnAddGames.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btnAddGames.setForeground(new java.awt.Color(233, 232, 231));
        btnAddGames.setText("Add Games");
        btnAddGames.setBorder(null);
        btnAddGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGamesActionPerformed(evt);
            }
        });

        btnRemoveGames.setBackground(new java.awt.Color(145, 49, 117));
        btnRemoveGames.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btnRemoveGames.setForeground(new java.awt.Color(233, 232, 231));
        btnRemoveGames.setText("Remove");
        btnRemoveGames.setBorder(null);
        btnRemoveGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveGamesActionPerformed(evt);
            }
        });

        btnUpdateGames.setBackground(new java.awt.Color(145, 49, 117));
        btnUpdateGames.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btnUpdateGames.setForeground(new java.awt.Color(233, 232, 231));
        btnUpdateGames.setText("Update");
        btnUpdateGames.setBorder(null);
        btnUpdateGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateGamesActionPerformed(evt);
            }
        });

        comboBoxSorts.setBackground(new java.awt.Color(145, 49, 117));
        comboBoxSorts.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        comboBoxSorts.setForeground(new java.awt.Color(233, 232, 231));
        comboBoxSorts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending No.", "Descending No.", "A-Z", "Z-A", "Highest Rating", "Lowest Rating", "Highest Price", "Lowest Price" }));
        comboBoxSorts.setAutoscrolls(true);
        comboBoxSorts.setBorder(null);
        comboBoxSorts.setMinimumSize(new java.awt.Dimension(254, 22));
        comboBoxSorts.setPreferredSize(new java.awt.Dimension(254, 42));
        comboBoxSorts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSortsActionPerformed(evt);
            }
        });

        btnAddToMyLibrary.setBackground(new java.awt.Color(145, 49, 117));
        btnAddToMyLibrary.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btnAddToMyLibrary.setForeground(new java.awt.Color(233, 232, 231));
        btnAddToMyLibrary.setText("Add to My Library");
        btnAddToMyLibrary.setBorder(null);
        btnAddToMyLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToMyLibraryActionPerformed(evt);
            }
        });

        btnUndoAddToLibrary.setBackground(new java.awt.Color(145, 49, 117));
        btnUndoAddToLibrary.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btnUndoAddToLibrary.setForeground(new java.awt.Color(233, 232, 231));
        btnUndoAddToLibrary.setText("Undo Add to My Library");
        btnUndoAddToLibrary.setBorder(null);
        btnUndoAddToLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoAddToLibraryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGameDataLayout = new javax.swing.GroupLayout(pnlGameData);
        pnlGameData.setLayout(pnlGameDataLayout);
        pnlGameDataLayout.setHorizontalGroup(
            pnlGameDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameDataLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlGameDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlGameDataLayout.createSequentialGroup()
                        .addComponent(lblGameData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUndoAddToLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddToMyLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxSorts, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddGames, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateGames, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveGames, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1771, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
        );
        pnlGameDataLayout.setVerticalGroup(
            pnlGameDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameDataLayout.createSequentialGroup()
                .addGroup(pnlGameDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGameDataLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblGameData)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGameDataLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlGameDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGameDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAddGames, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRemoveGames, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUpdateGames, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGameDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboBoxSorts, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAddToMyLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUndoAddToLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDashboard.add(pnlGameData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 1790, 620));

        pnlTotalAdmin.setBackground(new java.awt.Color(145, 49, 117));

        lblTotalAdmin.setFont(new java.awt.Font("Pixelify Sans", 0, 36)); // NOI18N
        lblTotalAdmin.setForeground(new java.awt.Color(233, 232, 231));
        lblTotalAdmin.setText("Total Admin");

        lblAdminNum.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblAdminNum.setForeground(new java.awt.Color(233, 232, 231));
        lblAdminNum.setText("100");

        lblAdminIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/whiteCrown.png"))); // NOI18N

        javax.swing.GroupLayout pnlTotalAdminLayout = new javax.swing.GroupLayout(pnlTotalAdmin);
        pnlTotalAdmin.setLayout(pnlTotalAdminLayout);
        pnlTotalAdminLayout.setHorizontalGroup(
            pnlTotalAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalAdminLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlTotalAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTotalAdminLayout.createSequentialGroup()
                        .addComponent(lblAdminIC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAdminNum)
                        .addGap(31, 31, 31))
                    .addGroup(pnlTotalAdminLayout.createSequentialGroup()
                        .addComponent(lblTotalAdmin)
                        .addContainerGap(151, Short.MAX_VALUE))))
        );
        pnlTotalAdminLayout.setVerticalGroup(
            pnlTotalAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalAdminLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblTotalAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(pnlTotalAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdminNum, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAdminIC, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(31, 31, 31))
        );

        pnlDashboard.add(pnlTotalAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 60, -1, -1));

        pnlTotalUsers.setBackground(new java.awt.Color(145, 49, 117));

        lblTotalUsers.setFont(new java.awt.Font("Pixelify Sans", 0, 36)); // NOI18N
        lblTotalUsers.setForeground(new java.awt.Color(233, 232, 231));
        lblTotalUsers.setText("Total Users");

        lblUsersNum.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblUsersNum.setForeground(new java.awt.Color(233, 232, 231));
        lblUsersNum.setText("100");

        lblUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/users.png"))); // NOI18N

        javax.swing.GroupLayout pnlTotalUsersLayout = new javax.swing.GroupLayout(pnlTotalUsers);
        pnlTotalUsers.setLayout(pnlTotalUsersLayout);
        pnlTotalUsersLayout.setHorizontalGroup(
            pnlTotalUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalUsersLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlTotalUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTotalUsersLayout.createSequentialGroup()
                        .addComponent(lblUserIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUsersNum)
                        .addGap(31, 31, 31))
                    .addGroup(pnlTotalUsersLayout.createSequentialGroup()
                        .addComponent(lblTotalUsers)
                        .addContainerGap(151, Short.MAX_VALUE))))
        );
        pnlTotalUsersLayout.setVerticalGroup(
            pnlTotalUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalUsersLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblTotalUsers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(pnlTotalUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsersNum, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUserIcon, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(31, 31, 31))
        );

        pnlDashboard.add(pnlTotalUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, -1, -1));

        pnlTotalGames.setBackground(new java.awt.Color(145, 49, 117));

        lblTotalGames.setFont(new java.awt.Font("Pixelify Sans", 0, 36)); // NOI18N
        lblTotalGames.setForeground(new java.awt.Color(233, 232, 231));
        lblTotalGames.setText("Total Games");

        lblGamesNum.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblGamesNum.setForeground(new java.awt.Color(233, 232, 231));
        lblGamesNum.setText("100");

        lblGameIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/joystick.png"))); // NOI18N

        javax.swing.GroupLayout pnlTotalGamesLayout = new javax.swing.GroupLayout(pnlTotalGames);
        pnlTotalGames.setLayout(pnlTotalGamesLayout);
        pnlTotalGamesLayout.setHorizontalGroup(
            pnlTotalGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalGamesLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlTotalGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalGames)
                    .addComponent(lblGameIcon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(lblGamesNum)
                .addGap(31, 31, 31))
        );
        pnlTotalGamesLayout.setVerticalGroup(
            pnlTotalGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalGamesLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblTotalGames)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(pnlTotalGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGamesNum, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblGameIcon, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(31, 31, 31))
        );

        pnlDashboard.add(pnlTotalGames, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 400, 210));

        pnlDashboardBg.setBackground(new java.awt.Color(233, 232, 231));
        pnlDashboardBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/pgBackground.png"))); // NOI18N
        pnlDashboardBg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlDashboard.add(pnlDashboardBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlAdmin.add(pnlDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 1820, 980));

        pnlAddGamesOuter.setPreferredSize(new java.awt.Dimension(1920, 1080));
        pnlAddGamesOuter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAddGamesBorder.setBackground(new java.awt.Color(233, 232, 231));
        pnlAddGamesBorder.setPreferredSize(new java.awt.Dimension(870, 630));

        pnlAddGamesFrame.setBackground(new java.awt.Color(145, 49, 117));
        pnlAddGamesFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlAddGamesFrame.setFocusCycleRoot(true);
        pnlAddGamesFrame.setPreferredSize(new java.awt.Dimension(851, 620));

        comboBoxRating.setBackground(new java.awt.Color(32, 38, 46));
        comboBoxRating.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        comboBoxRating.setForeground(new java.awt.Color(233, 232, 231));
        comboBoxRating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        comboBoxRating.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        comboBoxRating.setMinimumSize(new java.awt.Dimension(254, 22));
        comboBoxRating.setPreferredSize(new java.awt.Dimension(254, 42));

        lblAddGames.setFont(new java.awt.Font("Pixelify Sans", 0, 36)); // NOI18N
        lblAddGames.setForeground(new java.awt.Color(233, 232, 231));
        lblAddGames.setText("Add Games");

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
        comboBoxPlatform.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PC", "Console", "Mobile", "Cloud" }));
        comboBoxPlatform.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        comboBoxPlatform.setMinimumSize(new java.awt.Dimension(254, 22));
        comboBoxPlatform.setPreferredSize(new java.awt.Dimension(254, 42));

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

        checkBoxAction.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxAction.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxAction.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxAction.setText("Action");

        checkBoxAdventures.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxAdventures.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxAdventures.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxAdventures.setText("Adventures");

        checkBoxEducational.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxEducational.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxEducational.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxEducational.setText("Educational");

        checkBoxRolePlaying.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxRolePlaying.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxRolePlaying.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxRolePlaying.setText("Role-Playing");

        checkBoxRacing.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxRacing.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxRacing.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxRacing.setText("Racing/Driving");

        checkBoxSimulation.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxSimulation.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxSimulation.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxSimulation.setText("Simulation");

        checkBoxSports.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxSports.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxSports.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxSports.setText("Sports");

        checkBoxStrategy.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxStrategy.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxStrategy.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxStrategy.setText("Strategy");

        btnCloseAddGames.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/closeIcon.png"))); // NOI18N
        btnCloseAddGames.setBorder(null);
        btnCloseAddGames.setBorderPainted(false);
        btnCloseAddGames.setContentAreaFilled(false);
        btnCloseAddGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseAddGamesActionPerformed(evt);
            }
        });

        txtFldPrice.setBackground(new java.awt.Color(32, 38, 46));
        txtFldPrice.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldPrice.setForeground(new java.awt.Color(233, 232, 231));
        txtFldPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldPrice.setPreferredSize(new java.awt.Dimension(254, 42));

        lblPrice.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(233, 232, 231));
        lblPrice.setText("Price");

        checkBoxShooting.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxShooting.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxShooting.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxShooting.setText("Shooting");

        javax.swing.GroupLayout pnlAddGamesFrameLayout = new javax.swing.GroupLayout(pnlAddGamesFrame);
        pnlAddGamesFrame.setLayout(pnlAddGamesFrameLayout);
        pnlAddGamesFrameLayout.setHorizontalGroup(
            pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblGameNum)
                        .addGap(323, 323, 323)
                        .addComponent(lblGenres1))
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(txtFldGameNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(comboBoxPlatform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGameTitle)
                            .addComponent(txtFldGameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(143, 143, 143)
                        .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGenres2)
                            .addComponent(comboBoxRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblMainDevelopers)
                        .addGap(272, 272, 272)
                        .addComponent(lblLink))
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(txtFldMainDevelopers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(txtFldLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblPublishers)
                        .addGap(318, 318, 318)
                        .addComponent(lblReleasedDate))
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(txtFldPublishers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(txtFldReleasedYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblSlash1)
                        .addGap(12, 12, 12)
                        .addComponent(txtFldReleasedMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblSlash2)
                        .addGap(12, 12, 12)
                        .addComponent(txtFldReleasedDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(lblGenres))
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(checkBoxAction)
                        .addGap(54, 54, 54)
                        .addComponent(checkBoxEducational))
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxAdventures)
                            .addComponent(checkBoxSports))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxRolePlaying)
                            .addComponent(checkBoxStrategy))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                                .addComponent(checkBoxRacing)
                                .addGap(213, 213, 213)
                                .addComponent(btnAddGame, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                                .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkBoxSimulation)
                                    .addComponent(checkBoxShooting))
                                .addGap(32, 32, 32)
                                .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrice)
                                    .addComponent(txtFldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(24, 33, Short.MAX_VALUE))
            .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(lblAddGames)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCloseAddGames)
                .addContainerGap())
        );
        pnlAddGamesFrameLayout.setVerticalGroup(
            pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblAddGames))
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCloseAddGames)))
                .addGap(18, 18, 18)
                .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGameNum)
                    .addComponent(lblGenres1))
                .addGap(6, 6, 6)
                .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFldGameNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxPlatform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addComponent(lblGameTitle)
                        .addGap(6, 6, 6)
                        .addComponent(txtFldGameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblGenres2)
                        .addGap(6, 6, 6)
                        .addComponent(comboBoxRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMainDevelopers)
                    .addComponent(lblLink))
                .addGap(6, 6, 6)
                .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFldMainDevelopers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPublishers)
                    .addComponent(lblReleasedDate))
                .addGap(6, 6, 6)
                .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFldPublishers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldReleasedYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldReleasedMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldReleasedDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSlash1)
                            .addComponent(lblSlash2))))
                .addGap(18, 18, 18)
                .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addComponent(lblGenres)
                        .addGap(6, 6, 6)
                        .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxAction)
                            .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(checkBoxEducational)
                                .addComponent(checkBoxShooting)))
                        .addGap(17, 17, 17)
                        .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxAdventures)
                            .addComponent(checkBoxRolePlaying)
                            .addComponent(checkBoxSimulation))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAddGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddGame, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBoxSports)
                            .addComponent(checkBoxStrategy)
                            .addComponent(checkBoxRacing)))
                    .addGroup(pnlAddGamesFrameLayout.createSequentialGroup()
                        .addComponent(lblPrice)
                        .addGap(6, 6, 6)
                        .addComponent(txtFldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlAddGamesBorderLayout = new javax.swing.GroupLayout(pnlAddGamesBorder);
        pnlAddGamesBorder.setLayout(pnlAddGamesBorderLayout);
        pnlAddGamesBorderLayout.setHorizontalGroup(
            pnlAddGamesBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(pnlAddGamesBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlAddGamesBorderLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlAddGamesFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlAddGamesBorderLayout.setVerticalGroup(
            pnlAddGamesBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(pnlAddGamesBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlAddGamesBorderLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlAddGamesFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlAddGamesOuter.add(pnlAddGamesBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 225, -1, -1));

        lblAddGamesBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/welcomePage.png"))); // NOI18N
        pnlAddGamesOuter.add(lblAddGamesBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlUpdateGamesOuter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlUpdateGamesBorder.setBackground(new java.awt.Color(233, 232, 231));
        pnlUpdateGamesBorder.setPreferredSize(new java.awt.Dimension(870, 630));

        pnlUpdateGamesFrame.setBackground(new java.awt.Color(145, 49, 117));
        pnlUpdateGamesFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlUpdateGamesFrame.setFocusCycleRoot(true);
        pnlUpdateGamesFrame.setPreferredSize(new java.awt.Dimension(851, 620));

        comboBoxRatingUpdate.setBackground(new java.awt.Color(32, 38, 46));
        comboBoxRatingUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        comboBoxRatingUpdate.setForeground(new java.awt.Color(233, 232, 231));
        comboBoxRatingUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        comboBoxRatingUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        comboBoxRatingUpdate.setMinimumSize(new java.awt.Dimension(254, 22));
        comboBoxRatingUpdate.setPreferredSize(new java.awt.Dimension(254, 42));

        lblUpdateGames.setFont(new java.awt.Font("Pixelify Sans", 0, 36)); // NOI18N
        lblUpdateGames.setForeground(new java.awt.Color(233, 232, 231));
        lblUpdateGames.setText("Update Games");

        txtFldGameNumUpdate.setBackground(new java.awt.Color(32, 38, 46));
        txtFldGameNumUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldGameNumUpdate.setForeground(new java.awt.Color(233, 232, 231));
        txtFldGameNumUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldGameNumUpdate.setPreferredSize(new java.awt.Dimension(254, 42));

        lblGameNumUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblGameNumUpdate.setForeground(new java.awt.Color(233, 232, 231));
        lblGameNumUpdate.setText("Game No.");

        lblGameTitleUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblGameTitleUpdate.setForeground(new java.awt.Color(233, 232, 231));
        lblGameTitleUpdate.setText("Game Title");

        txtFldGameTitleUpdate.setBackground(new java.awt.Color(32, 38, 46));
        txtFldGameTitleUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldGameTitleUpdate.setForeground(new java.awt.Color(233, 232, 231));
        txtFldGameTitleUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldGameTitleUpdate.setPreferredSize(new java.awt.Dimension(254, 42));

        lblMainDevelopersUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblMainDevelopersUpdate.setForeground(new java.awt.Color(233, 232, 231));
        lblMainDevelopersUpdate.setText("Main Developers");

        txtFldMainDevelopersUpdate.setBackground(new java.awt.Color(32, 38, 46));
        txtFldMainDevelopersUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldMainDevelopersUpdate.setForeground(new java.awt.Color(233, 232, 231));
        txtFldMainDevelopersUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldMainDevelopersUpdate.setPreferredSize(new java.awt.Dimension(254, 42));

        lblPublishersUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblPublishersUpdate.setForeground(new java.awt.Color(233, 232, 231));
        lblPublishersUpdate.setText("Publishers");

        txtFldPublishersUpdate.setBackground(new java.awt.Color(32, 38, 46));
        txtFldPublishersUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldPublishersUpdate.setForeground(new java.awt.Color(233, 232, 231));
        txtFldPublishersUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldPublishersUpdate.setPreferredSize(new java.awt.Dimension(254, 42));

        lblGenresUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblGenresUpdate.setForeground(new java.awt.Color(233, 232, 231));
        lblGenresUpdate.setText("Genres");

        lblPlatformsUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblPlatformsUpdate.setForeground(new java.awt.Color(233, 232, 231));
        lblPlatformsUpdate.setText("Platform");

        lblRatingUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblRatingUpdate.setForeground(new java.awt.Color(233, 232, 231));
        lblRatingUpdate.setText("Rating");

        comboBoxPlatformUpdate.setBackground(new java.awt.Color(32, 38, 46));
        comboBoxPlatformUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        comboBoxPlatformUpdate.setForeground(new java.awt.Color(233, 232, 231));
        comboBoxPlatformUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PC", "Console", "Mobile", "Cloud" }));
        comboBoxPlatformUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        comboBoxPlatformUpdate.setMinimumSize(new java.awt.Dimension(254, 22));
        comboBoxPlatformUpdate.setPreferredSize(new java.awt.Dimension(254, 42));

        txtFldLinkUpdate.setBackground(new java.awt.Color(32, 38, 46));
        txtFldLinkUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldLinkUpdate.setForeground(new java.awt.Color(233, 232, 231));
        txtFldLinkUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldLinkUpdate.setPreferredSize(new java.awt.Dimension(254, 42));

        lblLinkUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblLinkUpdate.setForeground(new java.awt.Color(233, 232, 231));
        lblLinkUpdate.setText("Link");

        txtFldReleasedYearUpdate.setBackground(new java.awt.Color(32, 38, 46));
        txtFldReleasedYearUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldReleasedYearUpdate.setForeground(new java.awt.Color(233, 232, 231));
        txtFldReleasedYearUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldReleasedYearUpdate.setPreferredSize(new java.awt.Dimension(84, 42));

        lblReleasedDateUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblReleasedDateUpdate.setForeground(new java.awt.Color(233, 232, 231));
        lblReleasedDateUpdate.setText("Released Date");

        txtFldReleasedMonthUpdate.setBackground(new java.awt.Color(32, 38, 46));
        txtFldReleasedMonthUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldReleasedMonthUpdate.setForeground(new java.awt.Color(233, 232, 231));
        txtFldReleasedMonthUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldReleasedMonthUpdate.setPreferredSize(new java.awt.Dimension(64, 42));

        txtFldReleasedDayUpdate.setBackground(new java.awt.Color(32, 38, 46));
        txtFldReleasedDayUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldReleasedDayUpdate.setForeground(new java.awt.Color(233, 232, 231));
        txtFldReleasedDayUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldReleasedDayUpdate.setPreferredSize(new java.awt.Dimension(64, 42));

        lblSlash3.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblSlash3.setForeground(new java.awt.Color(233, 232, 231));
        lblSlash3.setText("/");

        lblSlash4.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblSlash4.setForeground(new java.awt.Color(233, 232, 231));
        lblSlash4.setText("/");

        btnUpdateGame.setBackground(new java.awt.Color(205, 88, 136));
        btnUpdateGame.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnUpdateGame.setForeground(new java.awt.Color(32, 38, 46));
        btnUpdateGame.setText("Update Game");
        btnUpdateGame.setBorder(null);
        btnUpdateGame.setFocusPainted(false);
        btnUpdateGame.setFocusable(false);
        btnUpdateGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateGameActionPerformed(evt);
            }
        });

        checkBoxActionUpdate.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxActionUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxActionUpdate.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxActionUpdate.setText("Action");

        checkBoxAdventuresUpdate.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxAdventuresUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxAdventuresUpdate.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxAdventuresUpdate.setText("Adventures");

        checkBoxEducationalUpdate.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxEducationalUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxEducationalUpdate.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxEducationalUpdate.setText("Educational");

        checkBoxRolePlayingUpdate.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxRolePlayingUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxRolePlayingUpdate.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxRolePlayingUpdate.setText("Role-Playing");

        checkBoxRacingUpdate.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxRacingUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxRacingUpdate.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxRacingUpdate.setText("Racing/Driving");

        checkBoxSimulationUpdate.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxSimulationUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxSimulationUpdate.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxSimulationUpdate.setText("Simulation");

        checkBoxSportsUpdate.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxSportsUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxSportsUpdate.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxSportsUpdate.setText("Sports");

        checkBoxStrategyUpdate.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxStrategyUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxStrategyUpdate.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxStrategyUpdate.setText("Strategy");

        btnCloseUpdateGames.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/closeIcon.png"))); // NOI18N
        btnCloseUpdateGames.setBorder(null);
        btnCloseUpdateGames.setBorderPainted(false);
        btnCloseUpdateGames.setContentAreaFilled(false);
        btnCloseUpdateGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseUpdateGamesActionPerformed(evt);
            }
        });

        checkBoxShootingUpdate.setBackground(new java.awt.Color(145, 49, 117));
        checkBoxShootingUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        checkBoxShootingUpdate.setForeground(new java.awt.Color(233, 232, 231));
        checkBoxShootingUpdate.setText("Shooting");

        txtFldPriceUpdate.setBackground(new java.awt.Color(32, 38, 46));
        txtFldPriceUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFldPriceUpdate.setForeground(new java.awt.Color(233, 232, 231));
        txtFldPriceUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 232, 231), 3));
        txtFldPriceUpdate.setPreferredSize(new java.awt.Dimension(254, 42));

        lblPriceUpdate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lblPriceUpdate.setForeground(new java.awt.Color(233, 232, 231));
        lblPriceUpdate.setText("Price");

        javax.swing.GroupLayout pnlUpdateGamesFrameLayout = new javax.swing.GroupLayout(pnlUpdateGamesFrame);
        pnlUpdateGamesFrame.setLayout(pnlUpdateGamesFrameLayout);
        pnlUpdateGamesFrameLayout.setHorizontalGroup(
            pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblGameNumUpdate)
                        .addGap(323, 323, 323)
                        .addComponent(lblPlatformsUpdate))
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(txtFldGameNumUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(comboBoxPlatformUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGameTitleUpdate)
                            .addComponent(txtFldGameTitleUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(143, 143, 143)
                        .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRatingUpdate)
                            .addComponent(comboBoxRatingUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblMainDevelopersUpdate)
                        .addGap(272, 272, 272)
                        .addComponent(lblLinkUpdate))
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(txtFldMainDevelopersUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(txtFldLinkUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblPublishersUpdate)
                        .addGap(318, 318, 318)
                        .addComponent(lblReleasedDateUpdate))
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(txtFldPublishersUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(txtFldReleasedYearUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblSlash3)
                        .addGap(12, 12, 12)
                        .addComponent(txtFldReleasedMonthUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblSlash4)
                        .addGap(12, 12, 12)
                        .addComponent(txtFldReleasedDayUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(lblGenresUpdate))
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUpdateGames)
                            .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 742, Short.MAX_VALUE)
                                .addComponent(btnCloseUpdateGames))))
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkBoxAdventuresUpdate)
                                    .addComponent(checkBoxSportsUpdate))
                                .addGap(18, 18, 18)
                                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkBoxRolePlayingUpdate)
                                    .addComponent(checkBoxStrategyUpdate)))
                            .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                                .addComponent(checkBoxActionUpdate)
                                .addGap(54, 54, 54)
                                .addComponent(checkBoxEducationalUpdate)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                                .addComponent(checkBoxRacingUpdate)
                                .addGap(213, 213, 213)
                                .addComponent(btnUpdateGame, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkBoxShootingUpdate)
                                    .addComponent(checkBoxSimulationUpdate))
                                .addGap(32, 32, 32)
                                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPriceUpdate)
                                    .addComponent(txtFldPriceUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        pnlUpdateGamesFrameLayout.setVerticalGroup(
            pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(lblUpdateGames))
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCloseUpdateGames)))
                .addGap(18, 18, 18)
                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGameNumUpdate)
                    .addComponent(lblPlatformsUpdate))
                .addGap(6, 6, 6)
                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFldGameNumUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxPlatformUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addComponent(lblGameTitleUpdate)
                        .addGap(6, 6, 6)
                        .addComponent(txtFldGameTitleUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblRatingUpdate)
                        .addGap(6, 6, 6)
                        .addComponent(comboBoxRatingUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMainDevelopersUpdate)
                    .addComponent(lblLinkUpdate))
                .addGap(6, 6, 6)
                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFldMainDevelopersUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldLinkUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPublishersUpdate)
                    .addComponent(lblReleasedDateUpdate))
                .addGap(6, 6, 6)
                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFldPublishersUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldReleasedYearUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldReleasedMonthUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldReleasedDayUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSlash3)
                            .addComponent(lblSlash4))))
                .addGap(18, 18, 18)
                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addComponent(lblGenresUpdate)
                        .addGap(6, 6, 6)
                        .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxActionUpdate)
                            .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(checkBoxEducationalUpdate)
                                .addComponent(checkBoxShootingUpdate)))
                        .addGap(17, 17, 17)
                        .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxAdventuresUpdate)
                            .addComponent(checkBoxRolePlayingUpdate)
                            .addComponent(checkBoxSimulationUpdate))
                        .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdateGame, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlUpdateGamesFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkBoxStrategyUpdate)
                                    .addComponent(checkBoxSportsUpdate)
                                    .addComponent(checkBoxRacingUpdate)))))
                    .addGroup(pnlUpdateGamesFrameLayout.createSequentialGroup()
                        .addComponent(lblPriceUpdate)
                        .addGap(6, 6, 6)
                        .addComponent(txtFldPriceUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlUpdateGamesBorderLayout = new javax.swing.GroupLayout(pnlUpdateGamesBorder);
        pnlUpdateGamesBorder.setLayout(pnlUpdateGamesBorderLayout);
        pnlUpdateGamesBorderLayout.setHorizontalGroup(
            pnlUpdateGamesBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(pnlUpdateGamesBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlUpdateGamesBorderLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlUpdateGamesFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlUpdateGamesBorderLayout.setVerticalGroup(
            pnlUpdateGamesBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(pnlUpdateGamesBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlUpdateGamesBorderLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlUpdateGamesFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlUpdateGamesOuter.add(pnlUpdateGamesBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 225, -1, -1));

        lblUpdateGamesBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/welcomePage.png"))); // NOI18N
        pnlUpdateGamesOuter.add(lblUpdateGamesBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlMyLibrary.setPreferredSize(new java.awt.Dimension(1920, 1080));
        pnlMyLibrary.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(32, 38, 46, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        pnlGameData1.setBackground(new java.awt.Color(32, 38, 46));
        pnlGameData1.setOpaque(false);

        lblGameData1.setFont(new java.awt.Font("Pixelify Sans", 0, 36)); // NOI18N
        lblGameData1.setForeground(new java.awt.Color(233, 232, 231));
        lblGameData1.setText("My Library");

        jScrollPane4.setOpaque(true);
        jScrollPane4.getViewport().setOpaque(true);
        jScrollPane4.getViewport().setBorder(null);
        jScrollPane4.setBackground(new java.awt.Color(32, 38, 46));
        jScrollPane4.getViewport().setBackground(new java.awt.Color(32, 38, 46));

        tblMyLibraryData.setOpaque(true);
        ((DefaultTableCellRenderer)tblMyLibraryData.getDefaultRenderer(Object.class)).setOpaque(true);
        tblMyLibraryData.setShowGrid(false);
        tblMyLibraryData.getTableHeader().setFont(new java.awt.Font("Roboto", 0,16 ));
        tblMyLibraryData.getTableHeader().setOpaque(false);
        tblMyLibraryData.getTableHeader().setBackground(new Color(145,49,117));
        tblMyLibraryData.getTableHeader().setForeground(new Color(233,232,231));
        tblMyLibraryData.setRowHeight(40);
        tblMyLibraryData.setBorder(null);
        tblMyLibraryData.setBackground(new java.awt.Color(32, 38, 46));
        tblMyLibraryData.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        tblMyLibraryData.setForeground(new java.awt.Color(233, 232, 231));
        tblMyLibraryData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Game No.", "Game Title", "Main Developers", "Publisher", "Plaform", "Released Date", "Genres", "Rating", "Price", "Link"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMyLibraryData.setFocusable(false);
        tblMyLibraryData.setRequestFocusEnabled(false);
        tblMyLibraryData.setRowHeight(40);
        tblMyLibraryData.setSelectionBackground(new java.awt.Color(32, 38, 46));
        tblMyLibraryData.setSelectionForeground(new java.awt.Color(145, 49, 117));
        tblMyLibraryData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblMyLibraryData.setShowGrid(false);
        tblMyLibraryData.setShowHorizontalLines(true);
        tblMyLibraryData.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblMyLibraryData);
        if (tblMyLibraryData.getColumnModel().getColumnCount() > 0) {
            tblMyLibraryData.getColumnModel().getColumn(0).setResizable(false);
            tblMyLibraryData.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblMyLibraryData.getColumnModel().getColumn(1).setResizable(false);
            tblMyLibraryData.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblMyLibraryData.getColumnModel().getColumn(2).setResizable(false);
            tblMyLibraryData.getColumnModel().getColumn(2).setPreferredWidth(180);
            tblMyLibraryData.getColumnModel().getColumn(3).setResizable(false);
            tblMyLibraryData.getColumnModel().getColumn(3).setPreferredWidth(170);
            tblMyLibraryData.getColumnModel().getColumn(4).setResizable(false);
            tblMyLibraryData.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblMyLibraryData.getColumnModel().getColumn(5).setResizable(false);
            tblMyLibraryData.getColumnModel().getColumn(5).setPreferredWidth(120);
            tblMyLibraryData.getColumnModel().getColumn(6).setResizable(false);
            tblMyLibraryData.getColumnModel().getColumn(6).setPreferredWidth(250);
            tblMyLibraryData.getColumnModel().getColumn(7).setResizable(false);
            tblMyLibraryData.getColumnModel().getColumn(7).setPreferredWidth(80);
            tblMyLibraryData.getColumnModel().getColumn(8).setResizable(false);
            tblMyLibraryData.getColumnModel().getColumn(8).setPreferredWidth(80);
            tblMyLibraryData.getColumnModel().getColumn(9).setResizable(false);
            tblMyLibraryData.getColumnModel().getColumn(9).setPreferredWidth(280);
        }

        btnMyLibraryPlayGame.setBackground(new java.awt.Color(145, 49, 117));
        btnMyLibraryPlayGame.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btnMyLibraryPlayGame.setForeground(new java.awt.Color(233, 232, 231));
        btnMyLibraryPlayGame.setText("Play Game");
        btnMyLibraryPlayGame.setBorder(null);
        btnMyLibraryPlayGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyLibraryPlayGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGameData1Layout = new javax.swing.GroupLayout(pnlGameData1);
        pnlGameData1.setLayout(pnlGameData1Layout);
        pnlGameData1Layout.setHorizontalGroup(
            pnlGameData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameData1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlGameData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1865, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlGameData1Layout.createSequentialGroup()
                        .addComponent(lblGameData1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMyLibraryPlayGame, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        pnlGameData1Layout.setVerticalGroup(
            pnlGameData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameData1Layout.createSequentialGroup()
                .addGroup(pnlGameData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGameData1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblGameData1)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGameData1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnMyLibraryPlayGame, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setOpaque(false);

        btnMyLibraryGoBack.setBackground(new java.awt.Color(145, 49, 117));
        btnMyLibraryGoBack.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btnMyLibraryGoBack.setForeground(new java.awt.Color(233, 232, 231));
        btnMyLibraryGoBack.setText("Go Back");
        btnMyLibraryGoBack.setBorder(null);
        btnMyLibraryGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyLibraryGoBackActionPerformed(evt);
            }
        });

        lblCurrentlyPlaying.setFont(new java.awt.Font("Pixelify Sans", 0, 36)); // NOI18N
        lblCurrentlyPlaying.setForeground(new java.awt.Color(233, 232, 231));
        lblCurrentlyPlaying.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCurrentlyPlaying.setText("Your Game Status");

        lblCurrentStatus.setFont(new java.awt.Font("Pixelify Sans", 0, 36)); // NOI18N
        lblCurrentStatus.setForeground(new java.awt.Color(233, 232, 231));
        lblCurrentStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCurrentStatus.setText("Your Game Status");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMyLibraryGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addComponent(lblCurrentlyPlaying, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblCurrentStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblCurrentStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCurrentlyPlaying)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addComponent(btnMyLibraryGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGameData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGameData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMyLibrary.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1080));

        lblMyLibraryBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/welcomePage.png"))); // NOI18N
        pnlMyLibrary.add(lblMyLibraryBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlWelcome.setPreferredSize(new java.awt.Dimension(1920, 1080));
        pnlWelcome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pgBarWelcomeScreen.setStringPainted(true);
        pgBarWelcomeScreen.setBackground(new java.awt.Color(32, 38, 46));
        pgBarWelcomeScreen.setForeground(new java.awt.Color(145, 49, 117));
        pgBarWelcomeScreen.setBorder(null);
        pgBarWelcomeScreen.setBorderPainted(false);
        pgBarWelcomeScreen.setPreferredSize(new java.awt.Dimension(1920, 4));
        pnlWelcome.add(pgBarWelcomeScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1070, 1920, 10));

        lblWelcome.setFont(new java.awt.Font("Pixelify Sans", 0, 36)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(233, 232, 231));
        lblWelcome.setText("WELCOME TO");
        pnlWelcome.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 400, -1, -1));

        lblWlcPgLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWlcPgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/logoGameSpaceResized1.png"))); // NOI18N
        lblWlcPgLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlWelcome.add(lblWlcPgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1070));

        lblWelcomePageImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gamespace/resources/welcomePage.png"))); // NOI18N
        pnlWelcome.add(lblWelcomePageImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(pnlWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseLogInActionPerformed
        // TODO add your handling code here:
        closeWindow();
    }//GEN-LAST:event_btnCloseLogInActionPerformed

    private void btnMinimizeLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeLogInActionPerformed
        // TODO add your handling code here:
        minimizeWindow();
    }//GEN-LAST:event_btnMinimizeLogInActionPerformed

    private void btnMinimizeWinAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeWinAdminActionPerformed
        // TODO add your handling code here:
        minimizeWindow();
    }//GEN-LAST:event_btnMinimizeWinAdminActionPerformed

    private void btnCloseWinAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseWinAdminActionPerformed
        // TODO add your handling code here:
        closeWindow();
    }//GEN-LAST:event_btnCloseWinAdminActionPerformed

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        // TODO add your handling code here:
        String admin = "admin";
        String adminpassword = "admin";
        txtFldUsername.setText("admin");
        txtFldPassword.setText("admin");

        String usernametxt = txtFldUsername.getText();
        String passwordtxt = new String(txtFldPassword.getPassword());

        // Check if username or password is empty
        if (usernametxt.isEmpty() || passwordtxt.isEmpty()) {
            lblLoginError.setText("Please enter your username and password.");
        } // Check if username and password are incorrect
        else if (usernametxt.equals(admin) && passwordtxt.equals(adminpassword)) {
            lblLoginError.setText("");
            loadScreen("AdminScreen");
        } else {
            lblLoginError.setText("Username or Password mismatch");
        }
    }//GEN-LAST:event_btnLogInActionPerformed

    private void btnAddGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGamesActionPerformed
        // TODO add your handling code here:
        loadScreen("AddGamesScreeen");
    }//GEN-LAST:event_btnAddGamesActionPerformed

    private void btnLogoutAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutAdminActionPerformed
        // TODO add your handling code here:
        logout();
    }//GEN-LAST:event_btnLogoutAdminActionPerformed

    private void btnAddGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGameActionPerformed
        // TODO add your handling code here:
        try {

            int gameNum = Integer.parseInt(txtFldGameNum.getText());
            String gameTitle = txtFldGameTitle.getText();
            String mainDevelopers = txtFldMainDevelopers.getText();
            String publishers = txtFldPublishers.getText();
            String platform = String.valueOf((String) comboBoxPlatform.getSelectedItem());
            int rating = Integer.parseInt((String) comboBoxRating.getSelectedItem());
            double priceValue = Double.parseDouble((String) txtFldPrice.getText());
            String price = priceValue == 0 ? "Free" : "$" + priceValue;
            String link = txtFldLink.getText();

            ArrayList<String> selectedGenres = new ArrayList<>();
            if (checkBoxAction.isSelected()) {
                selectedGenres.add("Action");
            }
            if (checkBoxAdventures.isSelected()) {
                selectedGenres.add("Adventures");
            }
            if (checkBoxEducational.isSelected()) {
                selectedGenres.add("Educational");
            }
            if (checkBoxSports.isSelected()) {
                selectedGenres.add("Sports");
            }
            if (checkBoxStrategy.isSelected()) {
                selectedGenres.add("Strategy");
            }
            if (checkBoxSimulation.isSelected()) {
                selectedGenres.add("Simulation");
            }
            if (checkBoxRacing.isSelected()) {
                selectedGenres.add("Racing/Driving");
            }
            if (checkBoxRolePlaying.isSelected()) {
                selectedGenres.add("Role-Playing");
            }
            if (checkBoxShooting.isSelected()) {
                selectedGenres.add("Shooting");
            }
            if (selectedGenres.isEmpty()) {
                CustomMessageJOptionPane.showCustomMessage("Please select at least one genre!", "ALERT", JOptionPane.WARNING_MESSAGE);
            }

            String genres = String.join(", ", selectedGenres);

            String yearNum = (txtFldReleasedYear.getText());
            String monthNum = (txtFldReleasedMonth.getText());
            String dayNum = (txtFldReleasedDay.getText());

            if (!validation.isValidReleasedDate(yearNum, monthNum, dayNum)) {
                CustomMessageJOptionPane.showCustomMessage("Invalid Released Date! Please enter a valid date (YYYY/MM/DD).", "ALERT!!", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String releasedDate = yearNum + "/" + monthNum + "/" + dayNum;

            boolean exists = false;

            for (GameModel game : gameList) {
                if (gameNum == game.getGameNum() || gameTitle.equalsIgnoreCase(game.getGameName())) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                if (!validation.isValidGameNum(gameNum)) {
                    CustomMessageJOptionPane.showCustomMessage("Enter valid Game Number!!", "ALERT!!", JOptionPane.WARNING_MESSAGE);
                } else if (!validation.isValidString(gameTitle) && !validation.isValidString(mainDevelopers) && !validation.isValidString(publishers)) {
                    CustomMessageJOptionPane.showCustomMessage("Please Enter Valid Value!!", "ALERT!!", JOptionPane.WARNING_MESSAGE);
                } else if (!validation.isValidPrice(priceValue)) {
                    CustomMessageJOptionPane.showCustomMessage("Enter valid Price!!", "ALERT!!", JOptionPane.WARNING_MESSAGE);
                } else {
                    GameModel game = new GameModel(gameNum, gameTitle, mainDevelopers, publishers, platform, releasedDate, genres, rating, price, link);
                    addGamesToTable(game);
                    CustomMessageJOptionPane.showCustomMessage("Game added SUCCESSFULLY!!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadScreen("AdminScreen");
                }
            } else {
                CustomMessageJOptionPane.showCustomMessage("The Game Already Exists", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            CustomMessageJOptionPane.showCustomMessage("Invalid value please try again!!", "ALERT!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddGameActionPerformed

    private void btnCloseAddGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseAddGamesActionPerformed
        // TODO add your handling code here:
        loadScreen("AdminScreen");
    }//GEN-LAST:event_btnCloseAddGamesActionPerformed

    private void btnUpdateGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateGameActionPerformed
        // TODO add your handling code here:
        try {
            String gameNumInput = txtFldGameNumUpdate.getText();
            if (gameNumInput.isEmpty() || !gameNumInput.matches("\\d+")) {
                CustomMessageJOptionPane.showCustomMessage("Game Number must be a valid integer!", "ALERT!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int gameNum = Integer.parseInt(gameNumInput);

            String gameTitle = txtFldGameTitleUpdate.getText();
            String mainDevelopers = txtFldMainDevelopersUpdate.getText();
            String publishers = txtFldPublishersUpdate.getText();
            String platform = String.valueOf(comboBoxPlatformUpdate.getSelectedItem());
            String link = txtFldLinkUpdate.getText();

            ArrayList<String> selectedGenres = new ArrayList<>();
            if (checkBoxActionUpdate.isSelected()) {
                selectedGenres.add("Action");
            }
            if (checkBoxAdventuresUpdate.isSelected()) {
                selectedGenres.add("Adventures");
            }
            if (checkBoxEducationalUpdate.isSelected()) {
                selectedGenres.add("Educational");
            }
            if (checkBoxSportsUpdate.isSelected()) {
                selectedGenres.add("Sports");
            }
            if (checkBoxStrategyUpdate.isSelected()) {
                selectedGenres.add("Strategy");
            }
            if (checkBoxSimulationUpdate.isSelected()) {
                selectedGenres.add("Simulation");
            }
            if (checkBoxRacingUpdate.isSelected()) {
                selectedGenres.add("Racing/Driving");
            }
            if (checkBoxRolePlayingUpdate.isSelected()) {
                selectedGenres.add("Role-Playing");
            }
            if (checkBoxShootingUpdate.isSelected()) {
                selectedGenres.add("Shooting");
            }
            String genres = selectedGenres.isEmpty() ? null : String.join(",", selectedGenres);

            String yearNum = txtFldReleasedYearUpdate.getText();
            String monthNum = txtFldReleasedMonthUpdate.getText();
            String dayNum = txtFldReleasedDayUpdate.getText();
            String releasedDate = yearNum.isEmpty() && monthNum.isEmpty() && dayNum.isEmpty() ? null : yearNum + "/" + monthNum + "/" + dayNum;

            if (!yearNum.isEmpty() && !validation.isValidReleasedDate(yearNum, monthNum, dayNum)) {
                CustomMessageJOptionPane.showCustomMessage("Invalid Released Date! Please enter a valid date (YYYY/MM/DD).", "ALERT!!", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String price = null;
            String priceInput = txtFldPriceUpdate.getText();
            if (!priceInput.isEmpty()) {
                double priceValue = Double.parseDouble(priceInput);
                if (priceValue == 0) {
                    price = "Free";
                } else {
                    price = "$" + priceInput;
                }
            }

            String ratingInput = (String) comboBoxRatingUpdate.getSelectedItem();
            int rating = ratingInput == null || ratingInput.isEmpty() ? -1 : Integer.parseInt(ratingInput);

            boolean exists = false;
            for (GameModel game : gameList) {
                if (gameNum == game.getGameNum()) {
                    game.setGameName(gameTitle.isEmpty() ? game.getGameName() : gameTitle);
                    game.setMainDevelopers(mainDevelopers.isEmpty() ? game.getMainDevelopers() : mainDevelopers);
                    game.setPublishers(publishers.isEmpty() ? game.getPublishers() : publishers);
                    game.setPlatform(platform.isEmpty() ? game.getPlatform() : platform);
                    game.setReleasedDate(releasedDate == null ? game.getReleasedDate() : releasedDate);
                    game.setGenres(genres == null ? game.getGenres() : genres);
                    game.setRating(rating == -1 ? game.getRating() : rating);
                    game.setPrice(price == null ? game.getPrice() : price);
                    game.setLink(link.isEmpty() ? game.getLink() : link);
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                CustomMessageJOptionPane.showCustomMessage("The Game No. does not Exist!!", "Alert", JOptionPane.WARNING_MESSAGE);
                return;
            }

            tableUpdator();
            loadScreen("AdminScreen");
            CustomMessageJOptionPane.showCustomMessage("The Game Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            CustomMessageJOptionPane.showCustomMessage("Invalid value, please try again!", "ALERT!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateGameActionPerformed

    private void btnUpdateGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateGamesActionPerformed
        // TODO add your handling code here:
        loadScreen("UpdateGamesScreen");
    }//GEN-LAST:event_btnUpdateGamesActionPerformed

    private void btnCloseUpdateGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseUpdateGamesActionPerformed
        // TODO add your handling code here:
        loadScreen("AdminScreen");
    }//GEN-LAST:event_btnCloseUpdateGamesActionPerformed

    private void btnRemoveGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveGamesActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblGameData.getSelectedRow();

        if (selectedRow == -1) {
            CustomMessageJOptionPane.showCustomMessage("Please selecte a game to remove. ", "Game Not Selected", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String removeNumInt = String.valueOf(tblGameData.getValueAt(selectedRow, 0));
            int removeNumButton = Integer.parseInt(removeNumInt);
            boolean exist = false;
            for (int i = 0; i < gameList.size(); i++) {
                if ((gameList.get(i).getGameNum()) == removeNumButton) {
                    gameList.remove(i);
                    exist = true;
                    break;
                }
            }

            if (exist) {
                tableUpdator();
                CustomMessageJOptionPane.showCustomMessage("Game Successfully Removed", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                CustomMessageJOptionPane.showCustomMessage("Game Not Found!!", "Alert", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            CustomMessageJOptionPane.showCustomMessage("Invalid value please try again!!", "ALERT!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoveGamesActionPerformed

    private void btnAdminSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminSearchActionPerformed
        // TODO add your handling code here:

        String searchText = txtFldSearchAdmin.getText();

        if (searchText.isEmpty()) {
            CustomMessageJOptionPane.showCustomMessage("Please enter game name to search.", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        GameModel result = searchGame(searchText);
        if (result != null) {
            pnlTotalAdmin.setVisible(false);
            pnlTotalUsers.setVisible(false);
            pnlTotalGames.setVisible(false);
            jScrollPane2.setVisible(true);
            List<GameModel> searchedList = new LinkedList<>();
            searchedList.add(result);

            DefaultTableModel model = (DefaultTableModel) tblGameData1.getModel();
            model.setRowCount(0);

            for (GameModel game : searchedList) {
                model.addRow(new Object[]{
                    game.getGameNum(),
                    game.getGameName(),
                    game.getMainDevelopers(),
                    game.getPublishers(),
                    game.getPlatform(),
                    game.getReleasedDate(),
                    game.getGenres(),
                    game.getRating(),
                    game.getPrice(),
                    game.getLink()
                });
            }
            txtFldSearchAdmin.setText("");
            btnSearchReset.setVisible(true);
        } else {
            CustomMessageJOptionPane.showCustomMessage("Can't Find Game. Please Try again", "Information", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnAdminSearchActionPerformed

    private GameModel searchGame(String gameName) {
        CustomSelectionSort selectionSort = new CustomSelectionSort();
        List<GameModel> sortedList = selectionSort.sortByGameName(gameList, false);
        CustomBinarySearch search = new CustomBinarySearch();
        return search.searchByName(gameName, sortedList, 0, sortedList.size() - 1);
    }

    private void comboBoxSortsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSortsActionPerformed
        // TODO add your handling code here:
        String sortby = String.valueOf((String) comboBoxSorts.getSelectedItem());
        List<GameModel> sortedList = new LinkedList<>(gameList);
        switch (sortby) {
            case "Ascending No.":
                sortedList = new CustomInsertionSort().sortByGameNum(gameList, false);
                break;
            case "Descending No.":
                sortedList = new CustomInsertionSort().sortByGameNum(gameList, true);
                break;
            case "A-Z":
                sortedList = new CustomSelectionSort().sortByGameName(gameList, false);
                break;
            case "Z-A":
                sortedList = new CustomSelectionSort().sortByGameName(gameList, true);
                break;
            case "Highest Rating":
                sortedList = new CustomMergeSort().sortGames(gameList, "rating", true);
                break;
            case "Lowest Rating":
                sortedList = new CustomMergeSort().sortGames(gameList, "rating", false);
                break;
            case "Highest Price":
                sortedList = new CustomMergeSort().sortGames(gameList, "price", true);
                break;
            case "Lowest Price":
                sortedList = new CustomMergeSort().sortGames(gameList, "price", false);
                break;
        }
        gameList = sortedList;
        tableUpdator();
    }//GEN-LAST:event_comboBoxSortsActionPerformed

    private void btnSearchResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchResetActionPerformed
        // TODO add your handling code here:
        pnlTotalAdmin.setVisible(true);
        pnlTotalUsers.setVisible(true);
        pnlTotalGames.setVisible(true);
        jScrollPane2.setVisible(false);
        btnSearchReset.setVisible(false);
    }//GEN-LAST:event_btnSearchResetActionPerformed

    private void updateMyLibraryTbl(GameModel myLibrary) {
        DefaultTableModel model = (DefaultTableModel) tblMyLibraryData.getModel();
        model.addRow(new Object[]{
            myLibrary.getGameNum(),
            myLibrary.getGameName(),
            myLibrary.getMainDevelopers(),
            myLibrary.getPublishers(),
            myLibrary.getPlatform(),
            myLibrary.getReleasedDate(),
            myLibrary.getGenres(),
            myLibrary.getRating(),
            myLibrary.getPrice(),
            myLibrary.getLink()
        });
    }

    private void addToMyLibrary() {
        int selectedRow = tblGameData.getSelectedRow();

        if (selectedRow == -1) {
            CustomMessageJOptionPane.showCustomMessage("Please selecte a game to remove. ", "Game Not Selected", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String addGameNum = String.valueOf(tblGameData.getValueAt(selectedRow, 0));
        int addGameNumInt = Integer.parseInt(addGameNum);
        boolean exist = false;
        for (int i = 0; i < myLibrary.size(); i++) {
            if (myLibrary.peek().getGameNum() == addGameNumInt) {
                exist = true;
                break;
            }
        }
        if (exist) {
            CustomMessageJOptionPane.showCustomMessage("Game is Already in the Library.", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            for (GameModel game : gameList) {
                if (game.getGameNum() == addGameNumInt) {
                    myLibrary.push(game);
                    updateMyLibraryTbl(game);
                }
            }
            CustomMessageJOptionPane.showCustomMessage("Game added to My Library", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void btnAddToMyLibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToMyLibraryActionPerformed
        // TODO add your handling code here:
        addToMyLibrary();
    }//GEN-LAST:event_btnAddToMyLibraryActionPerformed

    private void btnUndoAddToLibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoAddToLibraryActionPerformed
        // TODO add your handling code here:
        if (myLibrary.isEmpty()) {
            CustomMessageJOptionPane.showCustomMessage("No games to undo. Your Library is EMPTY", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }

        GameModel removeGameFromLibrary = myLibrary.pop();
        DefaultTableModel model = (DefaultTableModel) tblMyLibraryData.getModel();

            for (int i = 0; i < model.getRowCount(); i++) {
                if ((int) model.getValueAt(i, 0) == removeGameFromLibrary.getGameNum()) {
                    model.removeRow(i);
                    break;
                }
            }
        CustomMessageJOptionPane.showCustomMessage("Last added game removed from the Library", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnUndoAddToLibraryActionPerformed

    private void btnMyLibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyLibraryActionPerformed
        // TODO add your handling code here:
        loadScreen("MyLibraryScreen");
    }//GEN-LAST:event_btnMyLibraryActionPerformed

    private void btnMyLibraryGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyLibraryGoBackActionPerformed
        // TODO add your handling code here:
        loadScreen("AdminScreen");
    }//GEN-LAST:event_btnMyLibraryGoBackActionPerformed

    private void btnMyLibraryPlayGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyLibraryPlayGameActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblMyLibraryData.getSelectedRow();

        if (selectedRow == -1) {
            CustomMessageJOptionPane.showCustomMessage("Please selecte a game to remove. ", "Game Not Selected", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String playGameSelected = String.valueOf(tblMyLibraryData.getValueAt(selectedRow, 0));
        int playGameInt = Integer.parseInt(playGameSelected);
        boolean exist = false;
        for (int i = 0; i < playGameQueue.poll(); i++) {
            if (playGameQueue.peek().getGameNum() == playGameInt) {
                exist = true;
                break;
            }
        }
        if (exist) {
            CustomMessageJOptionPane.showCustomMessage("Game is Already in the Library.", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            for (GameModel game : gameList) {
                if (game.getGameNum() == playGameInt) {
                    playGameQueue.enQueue(game);
                    lblCurrentlyPlaying.setText("You are currently playing " + game.getGameName() + ".");
                }
            }
        }
    }//GEN-LAST:event_btnMyLibraryPlayGameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameSpace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GameSpace app = new GameSpace();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameSpace().setVisible(true);
            }
        });

        app.startProgress();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddGame;
    private javax.swing.JButton btnAddGames;
    private javax.swing.JButton btnAddToMyLibrary;
    private javax.swing.JButton btnAdminSearch;
    private javax.swing.JButton btnCloseAddGames;
    private javax.swing.JButton btnCloseLogIn;
    private javax.swing.JButton btnCloseUpdateGames;
    private javax.swing.JButton btnCloseWinAdmin;
    private javax.swing.JButton btnLogIn;
    private javax.swing.JButton btnLogoutAdmin;
    private javax.swing.JButton btnMinimizeLogIn;
    private javax.swing.JButton btnMinimizeWinAdmin;
    private javax.swing.JButton btnMyLibrary;
    private javax.swing.JButton btnMyLibraryGoBack;
    private javax.swing.JButton btnMyLibraryPlayGame;
    private javax.swing.JButton btnRemoveGames;
    private javax.swing.JButton btnSearchReset;
    private javax.swing.JButton btnUndoAddToLibrary;
    private javax.swing.JButton btnUpdateGame;
    private javax.swing.JButton btnUpdateGames;
    private javax.swing.JCheckBox checkBoxAction;
    private javax.swing.JCheckBox checkBoxActionUpdate;
    private javax.swing.JCheckBox checkBoxAdventures;
    private javax.swing.JCheckBox checkBoxAdventuresUpdate;
    private javax.swing.JCheckBox checkBoxEducational;
    private javax.swing.JCheckBox checkBoxEducationalUpdate;
    private javax.swing.JCheckBox checkBoxRacing;
    private javax.swing.JCheckBox checkBoxRacingUpdate;
    private javax.swing.JCheckBox checkBoxRolePlaying;
    private javax.swing.JCheckBox checkBoxRolePlayingUpdate;
    private javax.swing.JCheckBox checkBoxShooting;
    private javax.swing.JCheckBox checkBoxShootingUpdate;
    private javax.swing.JCheckBox checkBoxSimulation;
    private javax.swing.JCheckBox checkBoxSimulationUpdate;
    private javax.swing.JCheckBox checkBoxSports;
    private javax.swing.JCheckBox checkBoxSportsUpdate;
    private javax.swing.JCheckBox checkBoxStrategy;
    private javax.swing.JCheckBox checkBoxStrategyUpdate;
    private javax.swing.JComboBox<String> comboBoxPlatform;
    private javax.swing.JComboBox<String> comboBoxPlatformUpdate;
    private javax.swing.JComboBox<String> comboBoxRating;
    private javax.swing.JComboBox<String> comboBoxRatingUpdate;
    private javax.swing.JComboBox<String> comboBoxSorts;
    private javax.swing.JPanel divider;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAddGames;
    private javax.swing.JLabel lblAddGamesBG;
    private javax.swing.JLabel lblAdminIC;
    private javax.swing.JLabel lblAdminIcon;
    private javax.swing.JLabel lblAdminNum;
    private javax.swing.JLabel lblCurrentStatus;
    private javax.swing.JLabel lblCurrentlyPlaying;
    private javax.swing.JLabel lblForgotPassword;
    private javax.swing.JLabel lblGameData;
    private javax.swing.JLabel lblGameData1;
    private javax.swing.JLabel lblGameIcon;
    private javax.swing.JLabel lblGameNum;
    private javax.swing.JLabel lblGameNumUpdate;
    private javax.swing.JLabel lblGameTitle;
    private javax.swing.JLabel lblGameTitleUpdate;
    private javax.swing.JLabel lblGamesNum;
    private javax.swing.JLabel lblGenres;
    private javax.swing.JLabel lblGenres1;
    private javax.swing.JLabel lblGenres2;
    private javax.swing.JLabel lblGenresUpdate;
    private javax.swing.JLabel lblHaveAccount;
    private javax.swing.JLabel lblLink;
    private javax.swing.JLabel lblLinkUpdate;
    private javax.swing.JLabel lblLogInBackground;
    private javax.swing.JLabel lblLogInTitle;
    private javax.swing.JLabel lblLoginError;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoAdmin;
    private javax.swing.JLabel lblMainDevelopers;
    private javax.swing.JLabel lblMainDevelopersUpdate;
    private javax.swing.JLabel lblMyLibraryBackground;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPlatformsUpdate;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblPriceUpdate;
    private javax.swing.JLabel lblPublishers;
    private javax.swing.JLabel lblPublishersUpdate;
    private javax.swing.JLabel lblRatingUpdate;
    private javax.swing.JLabel lblReleasedDate;
    private javax.swing.JLabel lblReleasedDateUpdate;
    private javax.swing.JLabel lblSlash1;
    private javax.swing.JLabel lblSlash2;
    private javax.swing.JLabel lblSlash3;
    private javax.swing.JLabel lblSlash4;
    private javax.swing.JLabel lblTotalAdmin;
    private javax.swing.JLabel lblTotalGames;
    private javax.swing.JLabel lblTotalUsers;
    private javax.swing.JLabel lblUpdateGames;
    private javax.swing.JLabel lblUpdateGamesBG;
    private javax.swing.JLabel lblUserIcon;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsersNum;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblWelcomePageImg;
    private javax.swing.JLabel lblWlcPgLogo;
    private javax.swing.JProgressBar pgBarWelcomeScreen;
    private javax.swing.JPanel pnlAddGamesBorder;
    private javax.swing.JPanel pnlAddGamesFrame;
    private javax.swing.JPanel pnlAddGamesOuter;
    private javax.swing.JPanel pnlAdmin;
    private javax.swing.JPanel pnlDashboard;
    private javax.swing.JLabel pnlDashboardBg;
    private javax.swing.JPanel pnlGameData;
    private javax.swing.JPanel pnlGameData1;
    private javax.swing.JPanel pnlLogIn;
    private javax.swing.JPanel pnlLogInBorder;
    private javax.swing.JPanel pnlLogInbtn;
    private javax.swing.JPanel pnlMainLogIn;
    private javax.swing.JPanel pnlMyLibrary;
    private javax.swing.JPanel pnlSearchBar;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JPanel pnlTotalAdmin;
    private javax.swing.JPanel pnlTotalGames;
    private javax.swing.JPanel pnlTotalUsers;
    private javax.swing.JPanel pnlUpdateGamesBorder;
    private javax.swing.JPanel pnlUpdateGamesFrame;
    private javax.swing.JPanel pnlUpdateGamesOuter;
    private javax.swing.JPanel pnlWelcome;
    private javax.swing.JPanel pnlWelcomeLogIn;
    private javax.swing.JTable tblGameData;
    private javax.swing.JTable tblGameData1;
    private javax.swing.JTable tblMyLibraryData;
    private javax.swing.JTextField txtFldGameNum;
    private javax.swing.JTextField txtFldGameNumUpdate;
    private javax.swing.JTextField txtFldGameTitle;
    private javax.swing.JTextField txtFldGameTitleUpdate;
    private javax.swing.JTextField txtFldLink;
    private javax.swing.JTextField txtFldLinkUpdate;
    private javax.swing.JTextField txtFldMainDevelopers;
    private javax.swing.JTextField txtFldMainDevelopersUpdate;
    private javax.swing.JPasswordField txtFldPassword;
    private javax.swing.JTextField txtFldPrice;
    private javax.swing.JTextField txtFldPriceUpdate;
    private javax.swing.JTextField txtFldPublishers;
    private javax.swing.JTextField txtFldPublishersUpdate;
    private javax.swing.JTextField txtFldReleasedDay;
    private javax.swing.JTextField txtFldReleasedDayUpdate;
    private javax.swing.JTextField txtFldReleasedMonth;
    private javax.swing.JTextField txtFldReleasedMonthUpdate;
    private javax.swing.JTextField txtFldReleasedYear;
    private javax.swing.JTextField txtFldReleasedYearUpdate;
    private javax.swing.JTextField txtFldSearchAdmin;
    private javax.swing.JTextField txtFldUsername;
    // End of variables declaration//GEN-END:variables

}
