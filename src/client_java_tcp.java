
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

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
public class client_java_tcp {
    
    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the IP Address: ");
        String IPAdd = sc.nextLine();
        System.out.println("Enter the port number: ");
        int PortNum = sc.nextInt();
        System.out.println("csil-machine2> client " + IPAdd + " " + PortNum);
        System.out.println("Enter text, this is the text to be changed by the SERVER ");
        sc.nextLine();
        String Initial = sc.nextLine();
        
        Socket socket = new Socket(IPAdd,PortNum);
        
        PrintStream PStream = new PrintStream(socket.getOutputStream());
        PStream.println(Initial);
        
        Scanner sc2 = new Scanner(socket.getInputStream());
        String Final;
        Final = sc2.nextLine();
        
        System.out.println("Response from server: " + Final);
        
        socket.close();
        
    }
    
}
