/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

import com.sun.rowset.CachedRowSetImpl;
import daily_diary.Notes;
import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.coobird.thumbnailator.Thumbnails;
import static pkgnew.Upload.cb_Category;
import static pkgnew.Upload.cb_Sub_category;
import net.proteanit.sql.DbUtils;
import static pkgnew.Bids.list_bid;
import static pkgnew.List_Items.rs_bidders;
import static pkgnew.List_Items.rs_individualitem;
import static pkgnew.List_Items.table_listitems;
import static pkgnew.Notification.list1;
import static pkgnew.Notification.list2;
import static pkgnew.Notification.list3;
import static pkgnew.Notification.list4;
import static pkgnew.Profile.person_image;
import static pkgnew.Profile.profile_pic;
import static pkgnew.Profile.tf_address;
import static pkgnew.Profile.tf_confirmpass;
import static pkgnew.Profile.tf_currpass;
import static pkgnew.Profile.tf_email;
import static pkgnew.Profile.tf_mobile_no;
import static pkgnew.Profile.tf_newpass;
import static pkgnew.Profile.tf_username;
import static pkgnew.SignUp.pic_signup;
import static pkgnew.Upload.User_solditem;
import static pkgnew.Upload.newitem_pic;
import static pkgnew.Upload.tobesold_itemlist;
import java.util.Date;
import static pkgnew.LogIn.chat_soc;
import static pkgnew.LogIn.update_soc;
import static pkgnew.Profile.tf_name;
import static pkgnew.Search.crs_search;
       


/**
 *
 * @author priyanja
 */
public class Main_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Main_Frame
     */
    
    public static CachedRowSetImpl crs = null;
    public static CachedRowSetImpl rs_tobesold = null;
    public static CachedRowSetImpl rs_tobesold_bids = null;
    public static CachedRowSetImpl rs_solditems = null;
    public static CachedRowSetImpl rs_bid = null;
    public static CachedRowSetImpl rs_bidlist = null;
    public static CachedRowSetImpl rs_sold_buyer = null;
    public static CachedRowSetImpl rs_notify = null;
    public static CachedRowSetImpl rs_recent_sale = null;
    public static CachedRowSetImpl rs_user_like = null;
    public static CachedRowSetImpl rs_image = null;
            
    public static CachedRowSetImpl rs_user_online = null;
    public static CachedRowSetImpl crs_searchuser = null;
    public static CachedRowSetImpl crs_searchu = null;

    public static String category,sub_category;
    public static boolean LOGIN=false;
    public static  String  user_login;
    public static int number_login;
    private ImageIcon format = null;
    public static boolean SEARCH=false;
    public static String card = null;
    
    public static Chat [] chat_to = new Chat[100];
    String [] online_user =new String[100];
    public static int [] mark = new int[100];
    public static String ip = "localhost";
    public static Thread read_t,online_t,like_t;
    
    public Main_Frame() {
        initComponents();
        bt_logout.setVisible(false);
        bt_signup.setVisible(true);
        bt_login.setVisible(true);

        bt_profile.setVisible(false);
        bt_notifications.setVisible(false);
        bt_uploads.setVisible(false);
        bt_bids.setVisible(false);
        CardLayout Card = (CardLayout)DisplayPanel.getLayout();
        card = "category";
        Card.show(DisplayPanel, "category");
        Items.table_bids.setEnabled(false);
        
        bt_refresh.setVisible(false);
        label_online.setVisible(false);
        label_like.setVisible(false);
        list_online.setVisible(false);
        search_user.setVisible(false);
        list_like.setVisible(false);
        panel1.setVisible(false);
        panel2.setVisible(false);
  
    }

    
    public static void Read(){
    
        read_t = new Thread(){
            public void run(){
            
                try {
                    BufferedReader buff = new BufferedReader(new InputStreamReader(chat_soc.getInputStream()));
                    
                   while(true){

                       System.out.println("trying to rad from the pipesssssssss");
                       String from = buff.readLine();
                       String msg = buff.readLine();
                       String nu = buff.readLine();
                       
                       int num = Integer.parseInt(nu);
                       
                       if(mark[num]==0){
                           mark[num]=1;
                           System.out.println(num + " zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                        
                           chat_to[num] = new Chat(from); 
                       }
                       chat_to[num].setVisible(true);
                       
                       System.out.println(from);
                       System.out.println(msg);
                       String s =chat_to[num].tf_read.getText();
                        s+= "\n" + from + ": " + msg;
                       chat_to[num].tf_read.setText(s);
                       
                       System.out.println("chat msggggggggggggggggggg received");
                     
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } 
            
            }
        };
        read_t.start();
    
    }
    
     public static void Show_OnlineUsers(){
    
        online_t = new Thread(){
        
            public void run(){
       
                try {
                    
                   while(true){
                        ObjectInputStream ob12 = new ObjectInputStream(update_soc.getInputStream());

                        System.out.println("entered once");
                        rs_user_online =  (CachedRowSetImpl)ob12.readObject();
                        
                        DefaultListModel kuchbhi;
                        kuchbhi = new DefaultListModel();
                        
                        rs_user_online.beforeFirst();
                        
                        while(rs_user_online.next())
                        {
                            String user_name = rs_user_online.getString("User_name");
                            int num=rs_user_online.getInt("number");
                            
                            if(user_name.equals(user_login))continue;
                            System.out.println(user_name);
                            kuchbhi.addElement(user_name);
                            

                        }
                        
                        
                        
                        list_online.setModel(kuchbhi);
                        //Thread.sleep(1000);
                        System.out.println("exited once");
                        
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } 

            }
        
        };
        online_t.start();
            
    }
    
    
    
    public static void recent_sale()
    {
        Thread t;
        t = new Thread(){
            public void run(){
                      
                try {
                    System.out.println("trying to create a new connection");
                    
                    Socket soc = new Socket(ip,12345);
                    
                    
                    PrintWriter pr = new PrintWriter(soc.getOutputStream(),true);
                pr.println("RECENT_SALE");
                    
                    System.out.println("written dsiplay to socket");
                     
                    BufferedReader rd = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                    
                    String str = rd.readLine();
                    ObjectInputStream ob = new ObjectInputStream(soc.getInputStream());
                    rs_recent_sale =  (CachedRowSetImpl)ob.readObject();
                      DefaultListModel kuchbhi;
                     kuchbhi = new DefaultListModel();
                    
                    rs_recent_sale.beforeFirst();

                    while(rs_recent_sale.next())
                    {
                        String item_name = rs_recent_sale.getString("item_name");
                        System.out.println(item_name);
                        kuchbhi.addElement(item_name);
                        
                    }
                    list_recent.setModel(kuchbhi);
                } catch (IOException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        };t.start();
    }
    
    public static void user_like()
    {
        Thread t;
       t = new Thread(){
            public void run(){
                      
                try {
                    System.out.println("trying to create a new connection");
                    
                    Socket soc = new Socket(ip,12345);
                    
                    
                    PrintWriter pr = new PrintWriter(soc.getOutputStream(),true);
                    pr.println("USER_LIKE");
                    
                    pr.println(user_login);
                    
                    System.out.println("written dsiplay to socket");
                     
                    
                    ObjectInputStream ob = new ObjectInputStream(soc.getInputStream());
                    rs_user_like =  (CachedRowSetImpl)ob.readObject();
                     
                    DefaultListModel kuchbhi;
                     kuchbhi = new DefaultListModel();
                    
                    rs_user_like.beforeFirst();

                    while(rs_user_like.next())
                    {
                        String item_name = rs_user_like.getString("item_name");
                        System.out.println(item_name);
                        kuchbhi.addElement(item_name);
                        
                    }
                    list_like.setModel(kuchbhi);
                } catch (IOException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        };t.start();
    }
    
     public void for_user(){
     
         Thread t = new Thread(){
         public void run(){
        
                System.out.println("hey thr can u see me");
                while(true){

                    if(LOGIN==true){
                         label_user.setText("Welcome " + user_login);
                    }
                    else{
                        label_user.setText("");
                    }
                }

            }
         
         };
           
     }
     
          
     public void Display_Details(){
     
         Thread t = new Thread(){
             
             public void run(){
             
                 try {
                     Socket soc = new Socket(ip,12345);
                     PrintWriter pr = new PrintWriter(soc.getOutputStream(),true);
                     pr.println("DISPLAYDETAILS");
                     
                     BufferedReader buff = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                     String str =buff.readLine();
                     
                     System.out.println("mssg from server " + str);
                     
                     pr.println(user_login);
                     
                     ObjectInputStream ob = new ObjectInputStream(soc.getInputStream());
                     person_image= (byte[]) ob.readObject();
                     
                     String username = buff.readLine();
                     String address = buff.readLine();
                     String email = buff.readLine();
                     String contactno = buff.readLine();
                     String snum=buff.readLine();
                     String name =  buff.readLine();
                     
                     number_login=Integer.parseInt(snum);
                     
                     tf_username.setText(username);
                     tf_address.setText(address);
                     tf_email.setText(email);
                     tf_mobile_no.setText(contactno);
                     
                     tf_newpass.setText("");
                     tf_currpass.setText("");
                     tf_confirmpass.setText("");
                     tf_name.setText(name);
                     
                     System.out.println("imgae successfully fetched from server");
                     
                     format = new ImageIcon(person_image);
                     profile_pic.setIcon(format);
                     
                     System.out.println("image successfully set on icon");
                     
                 } catch (IOException ex) {
                     Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
             }
         
         };
         t.start();
     
     
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
        jLabel1 = new javax.swing.JLabel();
        label_user = new javax.swing.JLabel();
        bt_refresh = new javax.swing.JButton();
        sidepanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        label_like = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panel1 = new javax.swing.JScrollPane();
        list_like = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_recent = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        sidepanel2 = new javax.swing.JPanel();
        bt_home = new javax.swing.JButton();
        bt_signup = new javax.swing.JButton();
        bt_login = new javax.swing.JButton();
        bt_logout = new javax.swing.JButton();
        bt_profile = new javax.swing.JButton();
        bt_notifications = new javax.swing.JButton();
        bt_uploads = new javax.swing.JButton();
        bt_bids = new javax.swing.JButton();
        search_user = new javax.swing.JTextField();
        label_online = new javax.swing.JLabel();
        panel2 = new javax.swing.JScrollPane();
        list_online = new javax.swing.JList();
        DisplayPanel = new javax.swing.JPanel();
        subcategory_Sports1 = new pkgnew.Subcategory_Sports();
        subcategory_Electroni2 = new pkgnew.Subcategory_Electroni();
        signUp2 = new pkgnew.SignUp();
        main_Category2 = new pkgnew.Main_Category();
        profile1 = new pkgnew.Profile();
        notification2 = new pkgnew.Notification();
        upload1 = new pkgnew.Upload();
        search1 = new pkgnew.Search();
        bids1 = new pkgnew.Bids();
        items2 = new pkgnew.Items();
        list_Items2 = new pkgnew.List_Items();
        subcategory_Books1 = new pkgnew.Subcategory_Books();
        subcategory_Home1 = new pkgnew.Subcategory_Home();
        userfromsearch1 = new pkgnew.Userfromsearch();
        read_manual1 = new pkgnew.Read_manual();
        logIn1 = new pkgnew.LogIn();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(39, 35, 85));
        jPanel1.setForeground(new java.awt.Color(21, 9, 9));

        jLabel1.setFont(new java.awt.Font("Te X Gyre Schola", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Offline EXCHANGE");

        label_user.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        label_user.setForeground(new java.awt.Color(254, 254, 254));

        bt_refresh.setBackground(new java.awt.Color(67, 76, 221));
        bt_refresh.setFont(new java.awt.Font("URW Chancery L", 3, 24)); // NOI18N
        bt_refresh.setText("Refresh");
        bt_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_user, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_user, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        sidepanel1.setBackground(new java.awt.Color(74, 103, 186));
        sidepanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sidepanel1.setForeground(new java.awt.Color(9, 12, 12));

        jLabel2.setFont(new java.awt.Font("URW Chancery L", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(15, 3, 3));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(" Recent Uploads");

        label_like.setFont(new java.awt.Font("URW Chancery L", 3, 24)); // NOI18N
        label_like.setForeground(new java.awt.Color(23, 7, 7));
        label_like.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_like.setText("You may also like !");

        jButton1.setBackground(new java.awt.Color(67, 76, 221));
        jButton1.setFont(new java.awt.Font("URW Chancery L", 3, 24)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        list_like.setBackground(new java.awt.Color(74, 103, 186));
        list_like.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        list_like.setFont(new java.awt.Font("URW Palladio L", 1, 14)); // NOI18N
        list_like.setFocusable(false);
        list_like.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_likeMouseClicked(evt);
            }
        });
        panel1.setViewportView(list_like);

        list_recent.setBackground(new java.awt.Color(74, 103, 186));
        list_recent.setBorder(null);
        list_recent.setFont(new java.awt.Font("URW Palladio L", 1, 14)); // NOI18N
        list_recent.setFocusable(false);
        list_recent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_recentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                list_recentMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(list_recent);

        jButton2.setBackground(new java.awt.Color(67, 76, 221));
        jButton2.setFont(new java.awt.Font("URW Chancery L", 3, 24)); // NOI18N
        jButton2.setText("Reading Manual");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidepanel1Layout = new javax.swing.GroupLayout(sidepanel1);
        sidepanel1.setLayout(sidepanel1Layout);
        sidepanel1Layout.setHorizontalGroup(
            sidepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(label_like, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidepanel1Layout.setVerticalGroup(
            sidepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2)
                .addGap(18, 18, 18)
                .addComponent(label_like, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sidepanel2.setBackground(new java.awt.Color(74, 103, 186));
        sidepanel2.setForeground(new java.awt.Color(34, 13, 13));

        bt_home.setBackground(new java.awt.Color(67, 76, 221));
        bt_home.setFont(new java.awt.Font("URW Chancery L", 3, 24)); // NOI18N
        bt_home.setForeground(new java.awt.Color(20, 6, 6));
        bt_home.setText("Home");
        bt_home.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_home.setBorderPainted(false);
        bt_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_homeActionPerformed(evt);
            }
        });

        bt_signup.setBackground(new java.awt.Color(67, 76, 221));
        bt_signup.setFont(new java.awt.Font("URW Chancery L", 3, 24)); // NOI18N
        bt_signup.setForeground(new java.awt.Color(24, 19, 19));
        bt_signup.setText("Sign Up");
        bt_signup.setBorderPainted(false);
        bt_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_signupActionPerformed(evt);
            }
        });

        bt_login.setBackground(new java.awt.Color(67, 76, 221));
        bt_login.setFont(new java.awt.Font("URW Chancery L", 3, 24)); // NOI18N
        bt_login.setForeground(new java.awt.Color(26, 12, 12));
        bt_login.setText("Log In");
        bt_login.setBorderPainted(false);
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });

        bt_logout.setBackground(new java.awt.Color(67, 76, 221));
        bt_logout.setFont(new java.awt.Font("URW Chancery L", 3, 24)); // NOI18N
        bt_logout.setText("Log Out");
        bt_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_logoutActionPerformed(evt);
            }
        });

        bt_profile.setBackground(new java.awt.Color(67, 76, 221));
        bt_profile.setFont(new java.awt.Font("URW Chancery L", 3, 24)); // NOI18N
        bt_profile.setText("Profile");
        bt_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_profileActionPerformed(evt);
            }
        });

        bt_notifications.setBackground(new java.awt.Color(67, 76, 221));
        bt_notifications.setFont(new java.awt.Font("URW Chancery L", 3, 24)); // NOI18N
        bt_notifications.setText("Notifications");
        bt_notifications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_notificationsActionPerformed(evt);
            }
        });

        bt_uploads.setBackground(new java.awt.Color(67, 76, 221));
        bt_uploads.setFont(new java.awt.Font("URW Chancery L", 3, 24)); // NOI18N
        bt_uploads.setText("Uploads");
        bt_uploads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_uploadsActionPerformed(evt);
            }
        });

        bt_bids.setBackground(new java.awt.Color(67, 76, 221));
        bt_bids.setFont(new java.awt.Font("URW Chancery L", 3, 24)); // NOI18N
        bt_bids.setText("Bids");
        bt_bids.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_bidsActionPerformed(evt);
            }
        });

        search_user.setBackground(new java.awt.Color(74, 103, 186));
        search_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_userKeyReleased(evt);
            }
        });

        label_online.setFont(new java.awt.Font("URW Chancery L", 3, 24)); // NOI18N
        label_online.setForeground(new java.awt.Color(23, 7, 7));
        label_online.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_online.setText("Users Online !");

        list_online.setBackground(new java.awt.Color(74, 103, 186));
        list_online.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        list_online.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_onlineMouseClicked(evt);
            }
        });
        panel2.setViewportView(list_online);

        javax.swing.GroupLayout sidepanel2Layout = new javax.swing.GroupLayout(sidepanel2);
        sidepanel2.setLayout(sidepanel2Layout);
        sidepanel2Layout.setHorizontalGroup(
            sidepanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidepanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(search_user, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_online, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_uploads, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(bt_profile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(bt_notifications, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(bt_logout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(bt_login, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_signup, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(bt_home, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(bt_bids, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        sidepanel2Layout.setVerticalGroup(
            sidepanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_notifications, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_uploads, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_bids, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_online, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        DisplayPanel.setBackground(new java.awt.Color(240, 237, 234));
        DisplayPanel.setPreferredSize(new java.awt.Dimension(850, 650));
        DisplayPanel.setLayout(new java.awt.CardLayout());
        DisplayPanel.add(subcategory_Sports1, "sub_sports");
        DisplayPanel.add(subcategory_Electroni2, "sub_electronics");
        DisplayPanel.add(signUp2, "signup");
        DisplayPanel.add(main_Category2, "category");
        DisplayPanel.add(profile1, "profile");
        DisplayPanel.add(notification2, "notifications");
        DisplayPanel.add(upload1, "upload");
        DisplayPanel.add(search1, "search");
        DisplayPanel.add(bids1, "bids");
        DisplayPanel.add(items2, "items");
        DisplayPanel.add(list_Items2, "list_items");
        DisplayPanel.add(subcategory_Books1, "sub_books");
        DisplayPanel.add(subcategory_Home1, "sub_home");
        DisplayPanel.add(userfromsearch1, "usersearch");
        DisplayPanel.add(read_manual1, "read_manual");
        DisplayPanel.add(logIn1, "login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidepanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(DisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sidepanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidepanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sidepanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_homeActionPerformed
        // TODO add your handling code here:
        
        CardLayout Card = (CardLayout)DisplayPanel.getLayout();
        card = "category";
        Card.show(DisplayPanel, "category");
    }//GEN-LAST:event_bt_homeActionPerformed

    private void bt_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_signupActionPerformed
        // TODO add your handling code here:
        CardLayout Card = (CardLayout)DisplayPanel.getLayout();
        card = "signup";
        Card.show(DisplayPanel, "signup");
        image();
    }//GEN-LAST:event_bt_signupActionPerformed

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        // TODO add your handling code here:
        CardLayout Card = (CardLayout)DisplayPanel.getLayout();
        card = "login";
        Card.show(DisplayPanel, "login");
    }//GEN-LAST:event_bt_loginActionPerformed

    private void bt_profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_profileActionPerformed
        // TODO add your handling code here:
        CardLayout Card = (CardLayout)DisplayPanel.getLayout();
        card = "profile";
        Card.show(DisplayPanel, "profile");
       
        Display_Details();
    }//GEN-LAST:event_bt_profileActionPerformed

    private void bt_notificationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_notificationsActionPerformed
        // TODO add your handling code here:
        CardLayout Card = (CardLayout)DisplayPanel.getLayout();
        card = "notifications";
        Card.show(DisplayPanel, "notifications");
        Show_notifications();
    }//GEN-LAST:event_bt_notificationsActionPerformed

    private void bt_uploadsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_uploadsActionPerformed
        // TODO add your handling code here:
        CardLayout Card = (CardLayout)DisplayPanel.getLayout();
        Card.show(DisplayPanel, "upload");
        card = "upload";
       // Select_Sub();
        User_upload();
        User_solditem();
        long now = System.currentTimeMillis();

        java.util.Date date = new java.util.Date(now);
        Upload.date.setMinSelectableDate(date);
    }//GEN-LAST:event_bt_uploadsActionPerformed

    private void bt_bidsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_bidsActionPerformed
        // TODO add your handling code here:
        CardLayout Card = (CardLayout)DisplayPanel.getLayout();
        card = "bids";
        Card.show(DisplayPanel, "bids");
        User_bid();
    }//GEN-LAST:event_bt_bidsActionPerformed

    private void bt_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_logoutActionPerformed
        // TODO add your handling code here:
         
        Thread t= new Thread(){
            
            public void run(){
            
                try {
                    Socket soc = new Socket(ip,12345);
                    PrintWriter pr = new PrintWriter(soc.getOutputStream(),true);
                    pr.println("LOGOUT");
                    pr.println(user_login);
                    read_t.stop();
                    online_t.stop();
                    CardLayout Card = (CardLayout)DisplayPanel.getLayout();
                    Card.show(DisplayPanel, "category");
                    label_user.setText("");
                    bt_logout.setVisible(false);
                    bt_signup.setVisible(true);
                    bt_login.setVisible(true);
                    
                    bt_profile.setVisible(false);
                    bt_notifications.setVisible(false);
                    bt_uploads.setVisible(false);
                    bt_bids.setVisible(false);
                    search_user.setVisible(false);
                    list_online.setVisible(false);
                    
                    bt_refresh.setVisible(false);
                    label_online.setVisible(false);
                    label_like.setVisible(false);
                    list_online.setVisible(false);
                    search_user.setVisible(false);
                    list_like.setVisible(false);
                    panel1.setVisible(false);
                    panel2.setVisible(false);
                    
                    ini();
                    JOptionPane.showMessageDialog(null, "LOGGED OUT SUCCESSFULLY");
                    LOGIN=false;
                    user_login=null;
                    
                    DefaultListModel kuchbhi =  new DefaultListModel();
                    list_like.setModel(kuchbhi);
                    
                } catch (IOException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        
        
        };
        t.start();     
    }//GEN-LAST:event_bt_logoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CardLayout Card = (CardLayout)DisplayPanel.getLayout();
        card = "search";
        Card.show(DisplayPanel, "search");
        SEARCH = true;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void list_likeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_likeMouseClicked
        // TODO add your handling code here:
        Thread t = new Thread(){
            
            public void run(){
                    int item_id=0;
                try {
                    System.out.println("clicked on table");
                    String item_name = list_like.getSelectedValue().toString();
                    rs_user_like.beforeFirst();
                    while(rs_user_like.next())
                    {
                        if(rs_user_like.getString("item_name").equals(item_name))
                        {
                           item_id = rs_user_like.getInt("item_id");
                        }
                    }
                        System.out.println("item_id");
                   
                    Socket soc = new Socket(ip,12345);
                    PrintWriter pr = new PrintWriter(soc.getOutputStream(),true) ;
                    pr.println("INDIVIDUALITEM");
                    //pr.flush();
                    
                    BufferedReader buff = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                    String str= buff.readLine();
                    System.out.println(str);
                    
                    System.out.println("writing itemid on socket");
                    
                    PrintWriter pr1 = new PrintWriter(soc.getOutputStream(),true) ;
                    pr1.println(item_id);
                    pr1.println(user_login);
                    
                    
                    System.out.println("written on socket");
                    
                    System.out.println("getting first rs from server");
                    ObjectInputStream ob = new ObjectInputStream(soc.getInputStream());
                    
                    rs_individualitem =  (CachedRowSetImpl)ob.readObject(); 
                    System.out.println("got the first rs");
                    ObjectInputStream obj = new ObjectInputStream(soc.getInputStream());
                    rs_bidders =  (CachedRowSetImpl)obj.readObject();
                    System.out.println("got the second rs");
                    
                    
                    
                    if(rs_individualitem.next()){
                    
                        Items.label_itemname.setText(rs_individualitem.getString("item_name"));
                        Items.items_Info.setText(rs_individualitem.getString("item_name"));
                        Items.items_BasePrice.setText(rs_individualitem.getString("base_price"));
                        Items.items_TimeLimit.setText(rs_individualitem.getString("time_limit"));
                        Items.items_UploadDate.setText(rs_individualitem.getString("date"));
                        Items.items_UploadedBy.setText(rs_individualitem.getString("User_name"));
                        Items.items_meetingplace.setText(rs_individualitem.getString("meeting_place"));
                        
                        category = rs_individualitem.getString("category");
                        sub_category = rs_individualitem.getString("sub_category");
                        
                        byte[] pic = rs_individualitem.getBytes("image");
                        ImageIcon img = new ImageIcon(pic);
                        Items.pic.setIcon(img);
                        
                        category = rs_individualitem.getString("category");
                        sub_category = rs_individualitem.getString("sub_category");
                        
                    }
                    
                    pr1.println(category);
                    pr1.println(sub_category);
                    
                    Items.table_bids.setModel(DbUtils.resultSetToTableModel(rs_bidders));
                    
                    CardLayout Card = (CardLayout)DisplayPanel.getLayout();
                    card = "items";
                    SEARCH =false;
                    Card.show(DisplayPanel, "items");
                    
                } catch (IOException ex) {
                    Logger.getLogger(List_Items.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(List_Items.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(List_Items.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        
        };
        t.start();
    }//GEN-LAST:event_list_likeMouseClicked

    private void list_recentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_recentMouseClicked
        // TODO add your handling code here:
        Thread t = new Thread(){
            
            public void run(){
                    int item_id=0;
                try {
                    System.out.println("clicked on table");
                    String item_name = list_recent.getSelectedValue().toString();
                    rs_recent_sale.beforeFirst();
                    while(rs_recent_sale.next())
                    {
                        if(rs_recent_sale.getString("item_name").equals(item_name))
                        {
                           item_id = rs_recent_sale.getInt("item_id");
                        }
                    }
                        System.out.println("item_id");
                   
                    Socket soc = new Socket(ip,12345);
                    PrintWriter pr = new PrintWriter(soc.getOutputStream(),true) ;
                    pr.println("INDIVIDUALITEM");
                    //pr.flush();
                    
                    BufferedReader buff = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                    String str= buff.readLine();
                    System.out.println(str);
                    
                    System.out.println("writing itemid on socket");
                    
                    PrintWriter pr1 = new PrintWriter(soc.getOutputStream(),true) ;
                    pr1.println(item_id);
                    pr1.println(user_login);
                    
                    
                    System.out.println("written on socket");
                    
                    System.out.println("getting first rs from server");
                    ObjectInputStream ob = new ObjectInputStream(soc.getInputStream());
                    
                    rs_individualitem =  (CachedRowSetImpl)ob.readObject(); 
                    System.out.println("got the first rs");
                    ObjectInputStream obj = new ObjectInputStream(soc.getInputStream());
                    rs_bidders =  (CachedRowSetImpl)obj.readObject();
                    System.out.println("got the second rs");
                    
                    
                    
                    if(rs_individualitem.next()){
                    
                        Items.label_itemname.setText(rs_individualitem.getString("item_name"));
                        Items.items_Info.setText(rs_individualitem.getString("item_name"));
                        Items.items_BasePrice.setText(rs_individualitem.getString("base_price"));
                        Items.items_TimeLimit.setText(rs_individualitem.getString("time_limit"));
                        Items.items_UploadDate.setText(rs_individualitem.getString("date"));
                        Items.items_UploadedBy.setText(rs_individualitem.getString("User_name"));
                        Items.items_meetingplace.setText(rs_individualitem.getString("meeting_place"));
                        
                        category = rs_individualitem.getString("category");
                        sub_category = rs_individualitem.getString("sub_category");
                        
                        byte[] pic = rs_individualitem.getBytes("image");
                        ImageIcon img = new ImageIcon(pic);
                        Items.pic.setIcon(img);
                        
                        category = rs_individualitem.getString("category");
                        sub_category = rs_individualitem.getString("sub_category");
                    }
                    
                    pr1.println(category);
                    pr1.println(sub_category);
                    
                    Items.table_bids.setModel(DbUtils.resultSetToTableModel(rs_bidders));
                    
                    CardLayout Card = (CardLayout)DisplayPanel.getLayout();
                    card = "items";
                    SEARCH = false;
                    Card.show(DisplayPanel, "items");
                    
                } catch (IOException ex) {
                    Logger.getLogger(List_Items.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(List_Items.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(List_Items.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        
        };
        t.start();
    }//GEN-LAST:event_list_recentMouseClicked

    private void list_recentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_recentMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_list_recentMouseEntered

    private void bt_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_refreshActionPerformed
        // TODO add your handling code here:
        Show_notifications();
        User_upload();
        User_solditem();
        
        //Display(category,sub_category);
        
        //CardLayout Card = (CardLayout)DisplayPanel.getLayout();
        //Card.show(DisplayPanel, card);
    }//GEN-LAST:event_bt_refreshActionPerformed

    private void search_userKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_userKeyReleased
        // TODO add your handling code here:
        
        Thread t = new Thread(){
            
            public void run(){
            
                try {
                    
                    System.out.println("in search function");
                    String s= search_user.getText();
                    Socket soc = new Socket(ip,12345);
                    
                    PrintWriter pr =new PrintWriter(soc.getOutputStream(),true);
                    pr.println("SEARCHUSER");
                    
                    //ObjectOutputStream ob = new ObjectOutputStream(soc.getOutputStream());
                    //ob.writeObject(s);
                    
                    
                    System.out.println("writing to socket "+ s);
                    pr.println(s);
                    System.out.println("wrote to socket");
                    
                    DefaultListModel kuchbhi;
                    kuchbhi = new DefaultListModel();
                      
                   
                    ObjectInputStream ob1 = new ObjectInputStream(soc.getInputStream());
                    rs_user_online =  (CachedRowSetImpl)ob1.readObject();
                   
                    rs_user_online.beforeFirst();
                     while(rs_user_online.next())
                    {
                        String item_name = rs_user_online.getString("User_Name");
                        System.out.println(item_name);
                        if(item_name.equals(user_login))continue;
                        kuchbhi.addElement(item_name);
                        
                    }
                    list_online.setModel(kuchbhi);
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            
            }
        };
        t.start();
    }//GEN-LAST:event_search_userKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CardLayout Card = (CardLayout)DisplayPanel.getLayout();
                   
        Card.show(DisplayPanel, "read_manual");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void list_onlineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_onlineMouseClicked
        // TODO add your handling code here:
        
        Thread t = new Thread(){
        
            public void run(){
                
                try {
                    String str = list_online.getSelectedValue().toString();
                    int n=0;
                    rs_user_online.beforeFirst();
                    while(rs_user_online.next()){
                        
                        String temp = rs_user_online.getString("User_Name");
                        if(str.equals(temp)){
                        n=rs_user_online.getInt("number");
                        }  
                    }
                    
                    System.out.println(str);
                    
                    
                    if(mark[n]==0){
                        System.out.println(n + " zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                        mark[n]=1;
                        chat_to[n] = new Chat(str);
                        
                    }
                    chat_to[n].setVisible(true);
                    
                    System.out.println("new chat created");
                } catch (SQLException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        };
        t.start();
    }//GEN-LAST:event_list_onlineMouseClicked

    
    public static void Show_notifications(){
    
        Thread t = new Thread(){
        
            public void run(){
            
                try {
                    Socket soc = new Socket(ip,12345);
                    
                    PrintWriter pr = new PrintWriter(soc.getOutputStream(),true);
                    pr.println("NOTIFICATIONS");
                    
                    pr.println(user_login);
                    ObjectInputStream ob = new ObjectInputStream(soc.getInputStream());
                    rs_notify =  (CachedRowSetImpl)ob.readObject();
                   
                    
                    DefaultListModel kuchbhi1,kuchbhi2,kuchbhi3,kuchbhi4;
                    kuchbhi1 = new DefaultListModel();
                    kuchbhi2 = new DefaultListModel();
                    kuchbhi3 = new DefaultListModel();
                    kuchbhi4 = new DefaultListModel();
             
                    
                    rs_notify.beforeFirst();
                    while(rs_notify.next()){
                        
                        int type = rs_notify.getInt("type");
                        String st= rs_notify.getString("statement");
                        if(type==1){
                        kuchbhi1.addElement(st);
                        }else if(type==2){
                        kuchbhi2.addElement(st);
                        }
                        else if(type==3){
                        kuchbhi3.addElement(st);
                        }
                        else if(type==4){
                        kuchbhi4.addElement(st);
                        
                        }
                        
                        
                    
                    }
                    list1.setModel(kuchbhi1);
                    list2.setModel(kuchbhi2);
                    list3.setModel(kuchbhi3);
                    list4.setModel(kuchbhi4);
                   // list_bid.setModel(kuchbhi);
                    
                } catch (IOException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
            }
        
        };
        t.start();
    
    }
    
    
    public static void User_bid() {
        Thread t;
        t = new Thread(){
            public void run(){
                System.out.println("in Main Frame");
                      
                try {
                    System.out.println("trying to create a new connection");
                    
                    Socket soc = new Socket(ip,12345);
                    
                    
                    PrintWriter pr = new PrintWriter(soc.getOutputStream(),true);
                    pr.println("USER_BID");
                    
                    System.out.println("written dsiplay to socket");
                     
                    BufferedReader rd = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                    
                    String str = rd.readLine();
                    
                    if(str.equals("OK"))
                    {
                        pr.println(user_login);
                      
                    }
                    
                     
                   
                    
                    ObjectInputStream ob = new ObjectInputStream(soc.getInputStream());
                    rs_bid =  (CachedRowSetImpl)ob.readObject();
                   
                     DefaultListModel kuchbhi;
                    kuchbhi = new DefaultListModel();
                    
                    rs_bid.beforeFirst();
                     while(rs_bid.next())
                    {
                        String item_name = rs_bid.getString("item_name");
                        System.out.println(item_name);
                        kuchbhi.addElement(item_name);
                        
                    }
                    list_bid.setModel(kuchbhi);
                    
                    //ObjectInputStream ob1 = new ObjectInputStream(soc.getInputStream());
                    rs_bidlist =  (CachedRowSetImpl)ob.readObject();
                    
                } catch (IOException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }//To change body of generated methods, choose Tools | Templates.
    }; t.start();
                }
    
    public void clear_profile(){
    
        tf_username.setText("");
        tf_address.setText("");
        tf_email.setText("");
        tf_mobile_no.setText("");
        tf_newpass.setText("");
        tf_currpass.setText("");
        tf_confirmpass.setText("");
        
    
    }
    
    
    public void clear_uploads(){
    
    
    
    }
    
    public void clear_bids(){
    
    
    }
    
   
    
    
    public static void Display(final String cat, final String sub){
    
        Thread t;
        t = new Thread(){
            public void run(){
                
                
                try {
                    category = cat.substring(0);
                    sub_category = sub.substring(0);  
                    System.out.println("trying to create a new connection");
                    
                   Socket soc = new Socket(ip,12345);
                    
                    
                     PrintWriter pr = new PrintWriter(soc.getOutputStream(),true);
                    pr.println("DISPLAY");
                    
                    System.out.println("written dsiplay to socket");
                     
                    BufferedReader rd = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                    
                    String str = rd.readLine();
                    
                    System.out.println("checking " +cat + " " + sub);
                    System.out.println("mssg from server " + str);
                    if(str.equals("OK"))
                    {
                        pr.println(cat);
                        pr.println(sub);
                    }
                    System.out.println("sent cat and sub to server " + cat + " " + sub);
                    ObjectInputStream ob = new ObjectInputStream(soc.getInputStream());
                    List_Items.rs_list_items =  (CachedRowSetImpl)ob.readObject();
                    
                    System.out.println("received cached rowset from server");
                    
                    table_listitems.setModel(DbUtils.resultSetToTableModel(List_Items.rs_list_items));
                    System.out.println("table is set up");
                    
                    /*
                           
                    
                    String cnt = rd.readLine();
                    int j=Integer.parseInt(cnt);
                    
                    for(int i=0;i<j;i++){
                        String item_name = rd.readLine();
                        String base_price = rd.readLine();
                        String user_name = rd.readLine();
                        
                        System.out.println(item_name);
                        System.out.println(base_price);
                        System.out.println(user_name);
                        
                    }
                   */ 
                    
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }  catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        
        };
        t.start();
    
    
    }
    
    public static void User_upload(){
    
        Thread t;
        t = new Thread(){
            public void run(){
                System.out.println("in Main Frame");
                      
                try {
                    System.out.println("trying to create a new connection");
                    
                    Socket soc = new Socket(ip,12345);
                    
                    
                    PrintWriter pr = new PrintWriter(soc.getOutputStream(),true);
                    pr.println("USER_UPLOAD");
                    
                    System.out.println("written dsiplay to socket");
                     
                    BufferedReader rd = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                    
                    String str = rd.readLine();
                    
                    if(str.equals("OK"))
                    {
                        pr.println(user_login);
                      
                    }
                    ObjectInputStream ob = new ObjectInputStream(soc.getInputStream());
                    rs_tobesold =  (CachedRowSetImpl)ob.readObject();
                     DefaultListModel kuchbhi;
                     kuchbhi = new DefaultListModel();
                    
                    
                     
                    while(rs_tobesold.next())
                    {
                        String item_name = rs_tobesold.getString("item_name");
                        System.out.println(item_name);
                        kuchbhi.addElement(item_name);
                        
                    }tobesold_itemlist.setModel(kuchbhi);
                    System.out.println("user_upload done");
                } catch (IOException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        };t.start();
    }
    
    
public static void image()
    {
        Thread t;
        t = new Thread(){
            public void run(){
                      
                try {
                    System.out.println("trying to create a new connection");
                    
                    Socket soc = new Socket(ip,12345);
                    
                    
                    PrintWriter pr = new PrintWriter(soc.getOutputStream(),true);
                    pr.println("INITIAL_IMAGE");
                    
                    System.out.println("written dsiplay to socket");
                     
                    
                    ObjectInputStream ob = new ObjectInputStream(soc.getInputStream());
                    rs_image =  (CachedRowSetImpl)ob.readObject();
                      
                    
                    rs_image.beforeFirst();

                    while(rs_image.next())
                    {
                        System.out.println("done");
                        person_image= rs_image.getBytes("image");
                        Upload.newitem_image=rs_image.getBytes("image");
                    }
                    
                    ImageIcon img =new ImageIcon(person_image);
                    ImageIcon img1 =new ImageIcon(Upload.newitem_image);
                    
                    newitem_pic.setIcon(img1);
                   //profile_pic.setIcon(img);
                    pic_signup.setIcon(img);
                    Items.pic.setIcon(img1);
                    
                    
                    System.out.println("done done");
                } catch (IOException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Main_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        };t.start();
    }

    public static void ini(){
    
        Thread t = new Thread(){
            
            public void run(){
            
            
                for(int i=0;i<100;i++)mark[i]=0;
            }
        
        };
        t.start();
    
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
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Frame().setVisible(true);
                 recent_sale();
                 image();
                 ini();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel DisplayPanel;
    public static pkgnew.Bids bids1;
    public static javax.swing.JButton bt_bids;
    private javax.swing.JButton bt_home;
    public static javax.swing.JButton bt_login;
    public static javax.swing.JButton bt_logout;
    public static javax.swing.JButton bt_notifications;
    public static javax.swing.JButton bt_profile;
    public static javax.swing.JButton bt_refresh;
    public static javax.swing.JButton bt_signup;
    public static javax.swing.JButton bt_uploads;
    public static pkgnew.Items items2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel label_like;
    public static javax.swing.JLabel label_online;
    public static javax.swing.JLabel label_user;
    public static pkgnew.List_Items list_Items2;
    public static javax.swing.JList list_like;
    public static javax.swing.JList list_online;
    public static javax.swing.JList list_recent;
    public static pkgnew.LogIn logIn1;
    public static pkgnew.Main_Category main_Category2;
    public static pkgnew.Notification notification2;
    public static javax.swing.JScrollPane panel1;
    public static javax.swing.JScrollPane panel2;
    public static pkgnew.Profile profile1;
    public static pkgnew.Read_manual read_manual1;
    public static pkgnew.Search search1;
    public static javax.swing.JTextField search_user;
    public static javax.swing.JPanel sidepanel1;
    public static javax.swing.JPanel sidepanel2;
    private pkgnew.SignUp signUp2;
    public static pkgnew.Subcategory_Books subcategory_Books1;
    public static pkgnew.Subcategory_Electroni subcategory_Electroni2;
    public static pkgnew.Subcategory_Home subcategory_Home1;
    public static pkgnew.Subcategory_Sports subcategory_Sports1;
    public static pkgnew.Upload upload1;
    public static pkgnew.Userfromsearch userfromsearch1;
    // End of variables declaration//GEN-END:variables
}
