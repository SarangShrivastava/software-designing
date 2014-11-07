/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static pkgnew.Main_Frame.DisplayPanel;
import static pkgnew.Main_Frame.LOGIN;
import static pkgnew.Main_Frame.bt_bids;
import static pkgnew.Main_Frame.bt_login;
import static pkgnew.Main_Frame.bt_logout;
import static pkgnew.Main_Frame.bt_notifications;
import static pkgnew.Main_Frame.bt_profile;
import static pkgnew.Main_Frame.bt_refresh;
import static pkgnew.Main_Frame.bt_signup;
import static pkgnew.Main_Frame.bt_uploads;
import static pkgnew.Main_Frame.ip;
import static pkgnew.Main_Frame.label_like;
import static pkgnew.Main_Frame.label_online;
import static pkgnew.Main_Frame.label_user;
import static pkgnew.Main_Frame.list_like;
import static pkgnew.Main_Frame.list_online;
import static pkgnew.Main_Frame.number_login;
import static pkgnew.Main_Frame.panel1;
import static pkgnew.Main_Frame.panel2;
import static pkgnew.Main_Frame.search_user;
import static pkgnew.Main_Frame.user_login;

/**
 *
 * @author priyanja
 */
public class LogIn extends javax.swing.JPanel {

    /**
     * Creates new form LogIn
     */
    public LogIn() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_Password = new javax.swing.JPasswordField();
        tf_UserName = new javax.swing.JTextField();
        bt_Ok = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("LOG IN");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter your detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18), new java.awt.Color(0, 0, 128))); // NOI18N

        jLabel2.setText("UserName :-");

        jLabel3.setText("Password :-");

        bt_Ok.setText("OK");
        bt_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_OkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tf_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(tf_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(bt_Ok)
                .addGap(33, 33, 33))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgnew/login_s.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private String li_UserName;
    private String li_Password;
    Socket soc;  
    
    public static Socket chat_soc;
    public static Socket update_soc;
    public static Socket listen_soc;
    
    private void bt_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_OkActionPerformed
        // TODO add your handling code here:
        
        Thread t = new Thread(){

            public void run(){

                li_UserName=tf_UserName.getText();
                li_Password=tf_Password.getText();
                tf_UserName.setText("");
                tf_Password.setText("");
                try {
                    soc = new Socket(ip,12345);

                    PrintWriter pr = new PrintWriter(soc.getOutputStream(),true);
                    pr.println("LOGIN");

                    BufferedReader buff=new BufferedReader(new InputStreamReader(soc.getInputStream()));
                    String str=buff.readLine();

                    if(str.equals("OK")){
                        System.out.println("mssg fromserver " + str);
                        pr = new PrintWriter(soc.getOutputStream(),true);
                        pr.println(li_UserName);
                        pr.println(li_Password);
                    }

                    //buff=new BufferedReader(new InputStreamReader(soc.getInputStream()));
                    str=buff.readLine();
                    
                    if(str.equals("MATCHFOUND")){

                        String snum =buff.readLine();
                        number_login=Integer.parseInt(snum);
                        Chat_soc();
                        
                        System.out.println("mssg from server " + str);
                        CardLayout card =(CardLayout) DisplayPanel.getLayout();
                        card.show(DisplayPanel, "category");
                        
                        LOGIN=true;
                        
                        user_login=li_UserName.substring(0);
                        label_user.setText("Welcome " + user_login + " !!");
                        
                        //sidepanel3.setVisible(true);
                        bt_logout.setVisible(true);
                        bt_signup.setVisible(false);
                        bt_login.setVisible(false);
                        
                        bt_profile.setVisible(true);
                        bt_notifications.setVisible(true);
                        bt_uploads.setVisible(true);
                        bt_bids.setVisible(true);
                        search_user.setVisible(true);
                        list_online.setVisible(true);
                        
                        bt_refresh.setVisible(true);
                        label_online.setVisible(true);
                        label_like.setVisible(true);
                        list_online.setVisible(true);
                        search_user.setVisible(true);
                        list_like.setVisible(true);
                        panel1.setVisible(true);
                        panel2.setVisible(true);
                        Main_Frame.user_like();
                        //Main_Frame.Read();
                        JOptionPane.showMessageDialog(null,"LOG IN SUCCESSFULL!!!" );
                        //Thread.sleep(2000);
                        //Main_Frame.Show_OnlineUsers();
                        
                        
                        
                    }
                    else if(str.equals("USERNOTFOUND")){
                        System.out.println("mssg form server " + str);

                    }
                    else if(str.equals("PASSWORDNOTMATCH")){
                        JOptionPane.showMessageDialog(null,"RENTER YOUR PASSWORD" );
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        };
        t.start();
                
        
    }//GEN-LAST:event_bt_OkActionPerformed

    
        public  void Chat_soc(){
    
        Thread t = new Thread(){
            
            public void run(){
            
                try {
                    System.out.println("done");
                    
                    chat_soc = new Socket(ip,12346);

                    update_soc = new Socket(ip,12346);
                    
                    Main_Frame.Show_OnlineUsers();
                    Main_Frame.Read();
                    System.out.println("done done");
                } catch (IOException ex) {
                    Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        
        };
        t.start();
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Ok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField tf_Password;
    private javax.swing.JTextField tf_UserName;
    // End of variables declaration//GEN-END:variables
}
