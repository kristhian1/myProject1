
package scheduling;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class Database extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private JPanel cardpanel;
    private String ipAdd;
    private String num;
    private final LocalDate today = LocalDate.now();
    mytoolsTest r = new mytoolsTest();
    Login log = new Login();
    
    public Database(Data dataObj) {
        initComponents();
        con = Connect.ConnectDB();
        
        this.ipAdd = dataObj.getIP();
        this.num = dataObj.getNum();
        
        setTable();
        
        cardpanel = new JPanel(new CardLayout());
        cardpanel.add(page1, "Panel1");
        cardpanel.add(page2, "Panel2");
        cardpanel.add(page3, "Panel3");

        // Create the main container with BorderLayout
        JPanel container = new JPanel(new BorderLayout());
        
        container.add(top, BorderLayout.NORTH);
        container.add(cardpanel, BorderLayout.CENTER);

        // Set the container as the content pane
        setContentPane(container);
        addclient.setOpaque(true);
        this.setLocationRelativeTo(null);
        
    }

    private Database() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
    public void setTable() {
        try {
            pst = con.prepareStatement("Select * from client");
            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    public static void setNum(String num){
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        page2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        searchtf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        page3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        obs = new javax.swing.JLabel();
        preg = new javax.swing.JLabel();
        anak = new javax.swing.JLabel();
        hiwalay = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        mainpanel = new javax.swing.JPanel();
        top = new javax.swing.JPanel();
        addclient = new javax.swing.JLabel();
        view = new javax.swing.JLabel();
        search = new javax.swing.JLabel();
        page1 = new javax.swing.JPanel();
        clienttf = new javax.swing.JTextField();
        addresstf = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jCalendar = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();

        page2.setBackground(new java.awt.Color(153, 255, 255));

        table.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        searchtf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchtf.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        searchtf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchtfKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchtfKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout page2Layout = new javax.swing.GroupLayout(page2);
        page2.setLayout(page2Layout);
        page2Layout.setHorizontalGroup(
            page2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(page2Layout.createSequentialGroup()
                .addGroup(page2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(page2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE))
                    .addGroup(page2Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(page2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchtf)))
                .addContainerGap())
        );
        page2Layout.setVerticalGroup(
            page2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, page2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(searchtf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        page3.setBackground(new java.awt.Color(152, 155, 152));

        jPanel1.setLayout(new java.awt.GridLayout());

        obs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        obs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        obs.setText("observation");
        obs.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observation", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.add(obs);

        preg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        preg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preg.setText("pregnant");
        preg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pregnant", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.add(preg);

        anak.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        anak.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        anak.setText("nanganakna");
        anak.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nanganak Na", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.add(anak);

        hiwalay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hiwalay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hiwalay.setText("hiwalay");
        hiwalay.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hiwalay", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.add(hiwalay);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("View");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout page3Layout = new javax.swing.GroupLayout(page3);
        page3.setLayout(page3Layout);
        page3Layout.setHorizontalGroup(
            page3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(page3Layout.createSequentialGroup()
                .addGroup(page3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(page3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(page3Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jButton2)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        page3Layout.setVerticalGroup(
            page3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(page3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(jButton2)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        top.setBackground(new java.awt.Color(102, 102, 102));

        addclient.setBackground(new java.awt.Color(255, 255, 255));
        addclient.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addclient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addclient.setText("Add Client");
        addclient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addclientMouseClicked(evt);
            }
        });

        view.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        view.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        view.setText("Search");
        view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewMouseClicked(evt);
            }
        });

        search.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        search.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        search.setText("View");
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(addclient, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addclient, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        page1.setBackground(new java.awt.Color(255, 255, 255));

        clienttf.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        clienttf.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Client Name:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        addresstf.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        addresstf.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Address:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        add.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Date:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jCalendar.setDateFormatString("MM/dd/yyyy");
        jCalendar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCalendar.setOpaque(false);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Observation", "pregnant", "nanganak na", " " }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        javax.swing.GroupLayout page1Layout = new javax.swing.GroupLayout(page1);
        page1.setLayout(page1Layout);
        page1Layout.setHorizontalGroup(
            page1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(page1Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addGroup(page1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(page1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(clienttf, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(addresstf)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCalendar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(page1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        page1Layout.setVerticalGroup(
            page1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, page1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(clienttf, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addresstf, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(page1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                .addComponent(top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(page1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:

        if (clienttf.getText().isEmpty() || addresstf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }
        Date selectedDate = jCalendar.getDate();

        LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate first = LocalDate.now();

        String name = clienttf.getText();
        String address = addresstf.getText();
        
        LocalDate due = localDate.plusDays(15);
        java.sql.Date date = java.sql.Date.valueOf(localDate);
        java.sql.Date duedate = java.sql.Date.valueOf(due);
        long remaining = ChronoUnit.DAYS.between(first, due);

        int q = (int) remaining;

        try {
            pst = con.prepareStatement("insert into client(client_name,address,entry_date,status,due_date,days_left) values(?,?,?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setObject(3, date);
            pst.setString(4, "observation");
            pst.setObject(5, duedate);
            pst.setInt(6, q);

            pst.execute();
            setTable();
            JOptionPane.showMessageDialog(this, "Entry has been entered!");
            clienttf.setText("");
            addresstf.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_addActionPerformed

    private void viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseClicked
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) cardpanel.getLayout();
        cardLayout.show(cardpanel, "Panel2");
        view.setBackground(new Color(153, 255, 255));
        view.setOpaque(true);

        search.setBackground(new Color(102, 102, 102));
        addclient.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_viewMouseClicked

    private void addclientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addclientMouseClicked
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) cardpanel.getLayout();
        cardLayout.show(cardpanel, "Panel1");
        addclient.setBackground(new Color(255, 255, 255));
        addclient.setOpaque(true);

        search.setBackground(new Color(102, 102, 102));
        view.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_addclientMouseClicked

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) cardpanel.getLayout();
        cardLayout.show(cardpanel, "Panel3");
        search.setBackground(new Color(152, 155, 152));
        search.setOpaque(true);

        view.setBackground(new Color(102, 102, 102));
        addclient.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_searchMouseClicked

    private void searchtfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtfKeyPressed


    }//GEN-LAST:event_searchtfKeyPressed

    private void searchtfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtfKeyTyped
       
        String searchText = searchtf.getText();

        // Create a TableRowSorter to sort and filter the table data
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);

        // Apply the filter with the text entered by the user
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText)); // The "(?i)" makes it case-insensitive

        // Refresh the table with the updated filter
        sorter.setRowFilter(RowFilter.regexFilter(searchText));
    }//GEN-LAST:event_searchtfKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        send();
        updatetable();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        method meth = new method();
        
        obs.setText(String.valueOf(meth.getnumOfObs()));
        preg.setText(String.valueOf(meth.getnumOfpreg()));
        anak.setText(String.valueOf(meth.getnumOfanak()));
        hiwalay.setText(String.valueOf(meth.getnumOfhiwalay()));
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Database().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel addclient;
    private javax.swing.JTextField addresstf;
    private javax.swing.JLabel anak;
    private javax.swing.JTextField clienttf;
    private javax.swing.JLabel hiwalay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jCalendar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JLabel obs;
    private javax.swing.JPanel page1;
    private javax.swing.JPanel page2;
    private javax.swing.JPanel page3;
    private javax.swing.JLabel preg;
    private javax.swing.JLabel search;
    private javax.swing.JTextField searchtf;
    private javax.swing.JTable table;
    private javax.swing.JPanel top;
    private javax.swing.JLabel view;
    // End of variables declaration//GEN-END:variables
public void updatetable() {
        String selectQuery = "SELECT id, entry_date, due_date FROM client";
        String updateQuery = "UPDATE client SET days_left = ? WHERE id = ?";

        try (
                PreparedStatement pst = con.prepareStatement(selectQuery);
                ResultSet rs = pst.executeQuery();
                PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                
                LocalDate due = rs.getDate("due_date").toLocalDate();

                long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), due);

                // Set parameters for the update statement
                updatePst.setLong(1, daysLeft); // Set the days left
                updatePst.setInt(2, id);        // Set the id

                // Add to batch for more efficient updates
                updatePst.addBatch();
            }

            // Execute batch update
            updatePst.executeBatch();
            setTable();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
  public void send() {
        String query = "SELECT id, client_name, entry_date, due_date, status FROM client";
         boolean hasScheduledTask = false;
        
        try (PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int clientId = rs.getInt("id");
                String name = rs.getString("client_name");
                String status = rs.getString("status");
                LocalDate dueDate = rs.getDate("due_date").toLocalDate();
                
                long daysLeft = ChronoUnit.DAYS.between(today, dueDate);
                    
                 if (daysLeft <= 0) {
                r.processStatus(clientId, name, status);
                r.message(ipAdd,num);
                 hasScheduledTask = true;
            }
        }
          if (!hasScheduledTask) {
            JOptionPane.showMessageDialog(null, "No Schedule Today.");
        }   
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
}
