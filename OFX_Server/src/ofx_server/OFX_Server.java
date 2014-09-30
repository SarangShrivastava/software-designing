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
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author avishkar
 */



public class OFX_Server {

    /**
     * @param args the command line arguments
     */
    
   
    
   
    
    
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        ServerSocket ser = new ServerSocket(12345);
        Socket soc= new Socket();
        int i=0;
        while(true){  
            soc=ser.accept();
            System.out.println(soc.getPort());
            System.out.println("connection accepted and now creating object");
            Operations obj = new Operations(soc);
            System.out.println("Object made");
        }
        
    }
    
}
