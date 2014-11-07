/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;
import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.coobird.thumbnailator.Thumbnails;
import static pkgnew.Main_Frame.ip;
import static pkgnew.Main_Frame.user_login;
/**
 *
 * @author avishkar
 */
public class Profile extends javax.swing.JPanel {

    /**
     * Creates new form Profile
     */
    
    public static String user;
    public static String address;
    public static String email;
    public static String mobile_no;
    public static String curr_pass;
    public static String new_pass;
    public static String confirm_pass;
    String Filename=null;
    int s=0;
    public static byte[] person_image = null;
    private ImageIcon format = null;
    
    public Profile() {
        initComponents();
        tf_username.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        change_pic = new javax.swing.JButton();
        profile_pic = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tf_email = new javax.swing.JTextField();
        tf_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tf_mobile_no = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_address = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_name = new javax.swing.JTextField();
        save_changes = new javax.swing.JButton();
        change_passwd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tf_confirmpass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_newpass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        tf_currpass = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();

        change_pic.setText("Change Pic");
        change_pic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_picActionPerformed(evt);
            }
        });

        profile_pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgnew/imageNotFound.jpg"))); // NOI18N
        profile_pic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18), java.awt.SystemColor.activeCaption)); // NOI18N

        tf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });

        jLabel2.setText("Address:-");

        jLabel1.setText("Username:-");

        jLabel3.setText("email:-");

        jLabel4.setText("mobile no:-");

        jLabel9.setText("Name:-");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(113, 113, 113)
                        .addComponent(tf_mobile_no, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(144, 144, 144)
                        .addComponent(tf_email))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addGap(110, 110, 110)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_username, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(tf_address)
                            .addComponent(tf_name))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_mobile_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        save_changes.setText("Save changes");
        save_changes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_changesActionPerformed(evt);
            }
        });

        change_passwd.setText("Change Password");
        change_passwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_passwdActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Passwords", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18), java.awt.SystemColor.activeCaption)); // NOI18N

        tf_confirmpass.setText("jPasswordField3");

        jLabel5.setText("Current Password");

        jLabel7.setText("Confirm New Password");

        tf_newpass.setText("jPasswordField2");

        jLabel6.setText("New Password");

        tf_currpass.setText("jPasswordField1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(79, 79, 79))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(42, 42, 42)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tf_newpass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(tf_currpass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_confirmpass))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_currpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_newpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_confirmpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgnew/profile.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(save_changes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(change_passwd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(change_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profile_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(profile_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(change_pic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(save_changes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(change_passwd)))
                .addGap(64, 64, 64))
        );
    }// </editor-fold>//GEN-END:initComponents

    private BufferedImage resize (Image img,int h,int w){
    
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g =bi.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        
        g.drawImage(img,0,0,w,h,null);
        g.dispose();
        return bi;
    }
    
    
    private void change_picActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_picActionPerformed

        
        try {
            // TODO add your handling code here:
            
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String str = f.getAbsolutePath();
            File image = new File(str);
            
            BufferedImage bi = ImageIO.read(image);
            BufferedImage new_bi= Thumbnails.of(bi).size(150,200).asBufferedImage();
            
            FileInputStream fis = null;
            fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(new_bi, "png", bos);
            
            /*
            byte[] buf = new byte[1024];
            for(int i;(i=fis.read(buf))!=-1;){
                
                bos.write(buf,0,i);
            }   
              */                 
            person_image= bos.toByteArray();
            
           // BufferedImage img = ImageIO.read(new ByteArrayInputStream(person_image));
            //Image new_img=;
            
            format = new ImageIcon(person_image);
            profile_pic.setIcon(format);
            
            System.out.println("done son done");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//GEN-LAST:event_change_picActionPerformed

    private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_usernameActionPerformed

    private void save_changesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_changesActionPerformed
        // TODO add your handling code here:

        Thread t= new Thread()
        {
            public void run()
            {
                try {
                   // user = tf_username.getText();
                    address = tf_address.getText();
                    email = tf_email.getText();
                    mobile_no = tf_mobile_no.getText();
                    Socket soc = new Socket (ip,12345);
                    
                    System.out.println("writing to server");
                    PrintWriter pr = new PrintWriter(soc.getOutputStream(),true);
                    pr.println("SAVECHANGES");

                    BufferedReader rd = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                    String str = rd.readLine();
                    System.out.println("received mssg from server " + str);
                    if(str.equals("OK"))
                    {
                        //person_image=profile_pic.getIcon();
                        ObjectOutputStream ob = new ObjectOutputStream(soc.getOutputStream());
                        ob.writeObject(person_image);
                        
                       // pr.println(user);
                        System.out.println("sending details to server");
                        pr.println(address);
                        pr.println(email);
                        pr.println(mobile_no);
                        pr.println(user_login);

                        //format = new ImageIcon(person_image);
                        //profile_pic.setIcon(format);
                    }
                             JOptionPane.showMessageDialog(null,"CHANGES SAVED" );
                } catch (IOException ex) {
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        t.start();
    }//GEN-LAST:event_save_changesActionPerformed

    private void change_passwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_passwdActionPerformed
        // TODO add your handling code here:

        Thread t = new Thread(){

            public void run(){

                try {
                    curr_pass=tf_currpass.getText();
                    new_pass=tf_newpass.getText();
                    confirm_pass=tf_confirmpass.getText();

                    Socket soc = new Socket(ip,12345);
                    PrintWriter pr = new PrintWriter(soc.getOutputStream(),true);
                    pr.println("CHANGEPASSWORD");
                    BufferedReader buff = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                    String str = buff.readLine();
                    if(str.equals("OK")){

                        pr = new PrintWriter(soc.getOutputStream(),true);
                        pr.println(user_login);

                        String pass = buff.readLine();

                        if(!pass.equals(curr_pass)){

                            JOptionPane.showMessageDialog(null, "Current Password does not match");
                        }
                        else {

                            if(!new_pass.equals(confirm_pass)){
                                JOptionPane.showMessageDialog(null,"Password and Confirm Password do not match");
                            }
                            else{

                                System.out.println("sending original username and new password");
                                pr.println(new_pass);
                                pr.println(user_login);
                                JOptionPane.showMessageDialog(null,"Password changes" );
                            }

                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        t.start();
    }//GEN-LAST:event_change_passwdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton change_passwd;
    private javax.swing.JButton change_pic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel profile_pic;
    private javax.swing.JButton save_changes;
    public static javax.swing.JTextField tf_address;
    public static javax.swing.JPasswordField tf_confirmpass;
    public static javax.swing.JPasswordField tf_currpass;
    public static javax.swing.JTextField tf_email;
    public static javax.swing.JTextField tf_mobile_no;
    public static javax.swing.JTextField tf_name;
    public static javax.swing.JPasswordField tf_newpass;
    public static javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
