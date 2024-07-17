
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import jdk.nashorn.internal.parser.TokenType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
//Group Members:
//Rafay Tanweer, 19734
//Ali Muhammad, 18585
public class server_java_tcp{
    
    public static void main(String[] args) throws IOException {
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the port number");
        int PortNum = in.nextInt();
        
        System.out.println("csil-machine1> server " + PortNum);
        
        ServerSocket serversocket = new ServerSocket(PortNum);
        Socket socket = serversocket.accept();
        
        Scanner sc = new Scanner(socket.getInputStream());
        String Initial;
        Initial = sc.nextLine();
        
        System.out.println("Connection to client establised");
        
        String Final = "";
        char temp;
        for(int i = Initial.length() - 1; i >= 0; i--){
            
            if((int)Initial.charAt(i) >= 65 && (int)Initial.charAt(i) <= 90){
                temp = (char)((int)Initial.charAt(i) + 32);
                Final = Final + temp;
            }
            else if((int)Initial.charAt(i) >= 97 && (int)Initial.charAt(i) <= 122){
                temp = (char)((int)Initial.charAt(i) - 32);
                Final = Final + temp;
            }
            else 
                Final = Final + Initial.charAt(i);
            
        }
        
        PrintStream PStream = new PrintStream(socket.getOutputStream());
        PStream.println(Final);
        
        socket.close();
        serversocket.close();
        
        
    }
    
}
