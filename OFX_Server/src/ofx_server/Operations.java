/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofx_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ofx_server.Database_Server.stmt;

/**
 *
 * @author avishkar
 * 
 */

public class Operations extends OFX_Server implements Runnable {
    
   // OFX_Server obj;
    Socket soc;
    public static String [] user_detail = new String[10];
    Thread t;
    
    private  String su_UserName;
    private  String su_Password;
    private  String su_ConfirmPassword;
    private  String su_RoomNo;
    private  String su_Hostel;
    private  String su_Email;
    private  String su_ContactNo;
    private  String su_Name;
    private  String su_RegistrationNo;
    
    private String li_UserName;
    private String li_Password;
    
    private String save_username;
     private String save_address;
      private String save_email;
       private String save_mobileno;
    Operations(Socket soc){
        this.soc=soc;
        //this.obj=obj;
        t = new Thread(this);
        System.out.println("in Constructor of Operations");
        t.start();
    }
    
    
    public void run(){
   
                 System.out.println("In thread of Operations");
                String str = null;
              
                try {
                    System.out.println(soc.getPort());
                    System.out.println("try to read from pipe");
                    BufferedReader buff=new BufferedReader(new InputStreamReader(soc.getInputStream()));
                    str = buff.readLine();
                    System.out.println("read from pipe");
                    System.out.println(str);
                    
                } catch (IOException ex) {
                    Logger.getLogger(OFX_Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                if(str.equals("SIGNUP")){
                    System.out.println("signup condition satisfied");
                    this.Sign_Up();
                }
                else if(str.equals("LOGIN")){
                    System.out.println("login condition satisfied");
                    this.Log_In();
                }
                else if(str.equals("UPLOAD")){
                    System.out.println("upload condition satisfied");
                    this.Upload();
                }
                else if(str.equals("PROFILE")){
                    System.out.println("profile condition satisfied");
                    this.Update_Profile();
                }       
   
                else if(str.equals("SAVECHANGES")){
                    System.out.println("SAVE THE CHANGES");
                    this.Save_Changes();
                }       
   
    
    }
    
    
    public void Sign_Up(){
    
        Thread t= new Thread(){
            public void run(){
                try {
                    System.out.println("IN signup function");
                    int i=0;
                    PrintWriter pr = new PrintWriter(soc.getOutputStream(),true);
          
                    pr.println("OK");
                    System.out.println("written OK to pipe");
                    
                    //Database check for username already present
                    
                    BufferedReader buff= new BufferedReader( new InputStreamReader(soc.getInputStream()));
                       
                    su_UserName=buff.readLine();
                    
                    Database_Server db = new Database_Server();
                    db.Start_Connection();
                    
                    String sql = "SELECT User_Name FROM User_Details";
                    ResultSet rs=db.stmt.executeQuery(sql);
                    
                    boolean flag=false;
                    while(rs.next()){
                        String str = rs.getString("User_Name");
                        
                        if(su_UserName.equals(str)){
                            flag=true;
                            break;
                        }
                    }
                    
                    if(flag==true){
                        pr.println("DUPLICATE");
                    }
                    else{
                        pr.print("PROCEED");
                        su_Password=buff.readLine();
                        su_Name=buff.readLine();
                        su_RegistrationNo=buff.readLine();
                        su_RoomNo=buff.readLine();
                        su_Hostel=buff.readLine();
                        su_Email=buff.readLine();
                        su_ContactNo=buff.readLine();
                        sql = "INSERT INTO User_Details " +
                                 "VALUES (" +
                                  "'" +su_RegistrationNo+"'" + "," +
                                  "'"+su_Name+"'" + "," +
                                  "'"+su_UserName+"'" + "," +
                                  "'"+su_Password+"'" + "," +
                                  "'"+su_RoomNo+"'" + "," +
                                  "'"+su_Hostel+"'" + "," +
                                  "'"+su_Email+"'" + "," +
                                  "'"+su_ContactNo+"'" + ")";
                        
                    /*
                    String sql = "INSERT INTO User_Details " +
                                 "VALUES ( '20125135', 'sarang', 'xlr', 'khanpur24', '57', 'Tandon', 'sarang24s@gmai.com', '08173872815' )"; 
                      */            
                        db.stmt.executeUpdate(sql);  
                        pr.println("YES");
                    }
                    
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        t.start();
    }
        
    public void Log_In(){
        Thread t= new Thread(){
        
            public void run(){
                
                try {
                    PrintWriter pr=new PrintWriter(soc.getOutputStream(),true);
                    pr.println("OK");
                    
                    BufferedReader buff = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                    li_UserName = buff.readLine();
                    li_Password = buff.readLine();
                    
                    Database_Server db= new Database_Server();
                    db.Start_Connection();
                    String sql = "SELECT User_Name,Password FROM User_Details";
                    ResultSet rs = db.stmt.executeQuery(sql);
                    
                    boolean user_found = false;
                    boolean pass_match = false;
                    
                    while(rs.next()){
                            
                        String user=rs.getString("User_Name");
                        String pass=rs.getString("Password");
                        
                        if(user.equals(li_UserName)){
                            user_found=true;
                            if(pass.equals(li_Password))pass_match=true;
                        }
                        System.out.println(user + " " + pass);
                    }
                    
                    pr=new PrintWriter(soc.getOutputStream(),true);
                    
                    if(user_found==true&pass_match==true){
                        pr.println("MATCHFOUND"); 
                    }
                    else if(user_found==false){
                        pr.println("USERNOTFOUND");
                    }
                    else if(user_found==true&&pass_match==false){
                        pr.println("PASSWORDNOTMATCH");
                    }
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        
        };
        t.start();       
    
    }
    
     public  void Save_Changes(){
        Thread t= new Thread(){
        
            public void run(){
                BufferedReader rd = null;
                try {
                    PrintWriter pr = new PrintWriter(soc.getOutputStream(),true);
                    pr.println("OK");
                    rd = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                    save_username = rd.readLine();
                    save_address = rd.readLine();
                    save_email = rd.readLine();
                    save_mobileno = rd.readLine();
                    Database_Server db = new Database_Server();
                    
                    String str= "";
                    
                    db.stmt.executeQuery(str);
                    
                    try {
                        db.Start_Connection();
                    } catch (SQLException ex) {
                        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        rd.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        };
        t.start();   
    
    }
    
    public static void Upload(){
        Thread t= new Thread(){
        
            public void run(){
            
            
            }
        
        };
        t.start();   
    
    }
    
    public static void Update_Profile(){
        Thread t= new Thread(){
        
            public void run(){
            
            
            }
        
        };
        t.start();    
    
    }
    
    public static void Bid(){
        Thread t= new Thread(){
        
            public void run(){
            
            
            }
        
        };
        t.start();    
    
    }
    
}
