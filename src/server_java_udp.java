
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
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
public class server_java_udp {
    
    public static void main(String[] args) throws SocketException, IOException {
        
         Scanner in = new Scanner(System.in);
         System.out.println("Enter the port number");
        int PortNum = in.nextInt();
        
        DatagramSocket SSocket = new DatagramSocket(PortNum);
        
        System.out.println("csil-machine1> server " + PortNum);
        
        byte[] ReceivingData = new byte[1024];
        DatagramPacket ReceivingPacket = new DatagramPacket(ReceivingData, ReceivingData.length);
        SSocket.receive(ReceivingPacket);
        String Initial;
        Initial = new String(ReceivingPacket.getData());
        
        System.out.println("Connection to the client established");
        
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
        
        byte[] SendingData = new byte[1024];
        SendingData = Final.getBytes();
        DatagramPacket SendingPacket = new DatagramPacket(SendingData, SendingData.length, ReceivingPacket.getAddress(),ReceivingPacket.getPort());
        SSocket.send(SendingPacket);
        
        SSocket.close();
        
        
        
    }
    
}
