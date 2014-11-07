/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
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
import static pkgnew.Main_Frame.DisplayPanel;
import static pkgnew.Profile.person_image;
import static pkgnew.Profile.profile_pic;
import static pkgnew.Main_Frame.card;
import static pkgnew.Main_Frame.ip;
/**
 *
 * @author priyanja
 */
public class SignUp extends javax.swing.JPanel {

    /**
     * Creates new form SignUp
     */
    public SignUp() {
        initComponents();
    }

    private static String su_UserName;
    private static String su_Password;
    private static String su_ConfirmPassword;
   
    private static String su_Address;
    private static String su_Email;
    private static String su_ContactNo;
    private static String su_Name;
    private static String su_RegistrationNo;
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tf_Password = new javax.swing.JPasswordField();
        tf_Email = new javax.swing.JTextField();
        tf_Name = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tf_Address = new javax.swing.JTextField();
        tf_RegistrationNo = new javax.swing.JTextField();
        tf_ConfirmPassword = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        tf_ContactNo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_UserName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pic_signup = new javax.swing.JLabel();
        ButtonUpload = new javax.swing.JButton();
        ButtonOk = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18), new java.awt.Color(9, 9, 254))); // NOI18N

        tf_Email.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tf_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_EmailActionPerformed(evt);
            }
        });

        tf_Name.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tf_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NameActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel11.setText("Registration No :-");

        tf_Address.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tf_Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_AddressActionPerformed(evt);
            }
        });

        tf_RegistrationNo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tf_RegistrationNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_RegistrationNoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel12.setText("Name :-");

        tf_ContactNo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tf_ContactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ContactNoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setText("Password :-");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setText("Confirm Password :-");

        tf_UserName.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tf_UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_UserNameActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel7.setText("Address:-");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setText("User Name :-");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel8.setText("Email :-");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel9.setText("Contact No :-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tf_Address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_Email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_ContactNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel11))
                                    .addGap(27, 27, 27))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(62, 62, 62)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_Name)
                                .addComponent(tf_RegistrationNo)
                                .addComponent(tf_ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_RegistrationNo)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(tf_Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tf_ContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgnew/sign-up-here.png"))); // NOI18N

        pic_signup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pic_signup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgnew/imageNotFound.jpg"))); // NOI18N

        ButtonUpload.setText("Upload Img");
        ButtonUpload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonUploadMouseClicked(evt);
            }
        });
        ButtonUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUploadActionPerformed(evt);
            }
        });

        ButtonOk.setText("O.K.");
        ButtonOk.setMaximumSize(new java.awt.Dimension(50, 30));
        ButtonOk.setMinimumSize(new java.awt.Dimension(50, 30));
        ButtonOk.setPreferredSize(new java.awt.Dimension(50, 30));
        ButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(pic_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(ButtonUpload)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pic_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonUpload)
                .addGap(48, 48, 48)
                .addComponent(jLabel2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(ButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tf_UserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_UserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_UserNameActionPerformed

    private void tf_AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_AddressActionPerformed

    private void tf_ContactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ContactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ContactNoActionPerformed

    private void tf_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_EmailActionPerformed

    private void tf_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_NameActionPerformed

    private void tf_RegistrationNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_RegistrationNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_RegistrationNoActionPerformed

    private void ButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOkActionPerformed

        Thread t = new Thread(){

            public void run(){

                su_UserName=tf_UserName.getText();
                su_Password=tf_Password.getText();
                su_ConfirmPassword=tf_ConfirmPassword.getText();
                su_Name=tf_Name.getText();
                su_RegistrationNo=tf_RegistrationNo.getText();
               
                su_Address=tf_Address.getText();
                su_Email=tf_Email.getText();
                su_ContactNo=tf_ContactNo.getText();
                
                
                boolean flag=false;
                    int l = su_RegistrationNo.length();
                    for(int i=0;i<l;i++){
                        
                        if(su_RegistrationNo.charAt(i)=='0'||su_RegistrationNo.charAt(i)=='1'||su_RegistrationNo.charAt(i)=='2'||su_RegistrationNo.charAt(i)=='3'||su_RegistrationNo.charAt(i)=='4'||su_RegistrationNo.charAt(i)=='5'||su_RegistrationNo.charAt(i)=='6'||su_RegistrationNo.charAt(i)=='7'||su_RegistrationNo.charAt(i)=='8'||su_RegistrationNo.charAt(i)=='9'){
                        
                        
                        
                     }
                        else{
                            flag=true;
                            break;
                        }
                    
                    }
                
                    if(flag==true){
                    
                    JOptionPane.showMessageDialog(null, "REGISTRATION NUMBER SHOULD BE AN INTEGER");
                    return;
                    }
                
                
                if(su_UserName.equals("") || su_Name.equals("") || su_Password.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"One or more field is empty");
                }

                else if(!su_Password.equals(su_ConfirmPassword)){

                    tf_Password.setText("");
                    tf_ConfirmPassword.setText((""));
                    System.out.println("A");
                    JOptionPane.showMessageDialog(null,"PASSWORDS DO NOT MATCH");
                }
                else{
                    try     {

                        System.out.println("B");
                        Socket soc =  new Socket(ip,12345);
                        System.out.println("connection established and now writing to pipe");

                        PrintWriter pr= new PrintWriter(soc.getOutputStream(),true);
                        pr.println("SIGNUP");
                        /*
                        buff = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                        String str = buff.readLine();

                        pr.println(su_UserName);
                        */
                        System.out.println("trying to read from the pipe");
                        BufferedReader buff = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                        String str=buff.readLine();
                        System.out.println("mssg from server" + str);

                        if(str.equals("OK")){

                            pr.println(su_UserName);

                            str=buff.readLine();
                            if(str.equals("DUPLICATE")){
                                JOptionPane.showMessageDialog(null, "USERNAME ALREADY REGISTERED TRY ANOTHER USERNAME");
                            }
                            else if (str.equals("PROCEED")){
                                
                                System.out.println("wrote proceed");
                                ObjectOutputStream ob = new ObjectOutputStream(soc.getOutputStream());
                                ob.writeObject(person_image);
                                
                                pr.println(su_Password);
                                pr.println(su_Name);
                                pr.println(su_RegistrationNo);
                              
                                pr.println(su_Address);
                                pr.println(su_Email);
                                pr.println(su_ContactNo);
                                JOptionPane.showMessageDialog(null, "USER SUCCESSFULLY REGISTERED !!");
                             
                                tf_Address.setText("");
                                tf_ConfirmPassword.setText("");
                                tf_ContactNo.setText("");
                                tf_Email.setText("");
                                tf_Name.setText("");
                                tf_Password.setText("");
                                tf_RegistrationNo.setText("");
                                tf_UserName.setText("");
                                tf_Password.setText("");
                                tf_ConfirmPassword.setText("");
                                
                                CardLayout Card =(CardLayout) DisplayPanel.getLayout();
                                card = "category";
                                Card.show(DisplayPanel, "category");
                          
                            }
                        }
                        // TODO add your handling code here:
                    } catch (IOException ex) {
                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        };
        t.start();

    }//GEN-LAST:event_ButtonOkActionPerformed

    private void ButtonUploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonUploadMouseClicked
        // TODO add your handling code here:
                FileInputStream fis = null;
        try {
            // TODO add your handling code here:
            
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String str = f.getAbsolutePath();
            File image = new File(str);
            
            
            BufferedImage bi = ImageIO.read(image);
            BufferedImage new_bi= Thumbnails.of(bi).size(pic_signup.getWidth(), pic_signup.getHeight()).asBufferedImage();
            
            
            fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(new_bi, "png", bos);
            
            /*
            fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int i;(i=fis.read(buf))!=-1;){
                
                bos.write(buf,0,i);
            }   
              */                 
            person_image= bos.toByteArray();
            
            ImageIcon format = new ImageIcon(person_image);
            pic_signup.setIcon(format);
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ButtonUploadMouseClicked

    private void ButtonUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUploadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonUploadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonOk;
    private javax.swing.JButton ButtonUpload;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel pic_signup;
    private javax.swing.JTextField tf_Address;
    private javax.swing.JPasswordField tf_ConfirmPassword;
    private javax.swing.JTextField tf_ContactNo;
    private javax.swing.JTextField tf_Email;
    private javax.swing.JTextField tf_Name;
    private javax.swing.JPasswordField tf_Password;
    private javax.swing.JTextField tf_RegistrationNo;
    private javax.swing.JTextField tf_UserName;
    // End of variables declaration//GEN-END:variables
}
