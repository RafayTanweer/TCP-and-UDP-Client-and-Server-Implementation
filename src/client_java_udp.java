
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
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
public class client_java_udp {
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the IP Address: ");
        String IPAdd = sc.nextLine();
        System.out.println("Enter the port number: ");
        int PortNum = sc.nextInt();
        System.out.println("csil-machine2> client " + IPAdd + " " + PortNum);
        sc.nextLine();
        String Initial;
        System.out.println("Enter text, this is the text to be changed by the SERVER ");
        Initial = sc.nextLine();
        
        DatagramSocket CSocket = new DatagramSocket();
        
        byte[] SendingData = new byte[1024];
        SendingData = Initial.getBytes();
        InetAddress IP = InetAddress.getByName(IPAdd);
        DatagramPacket SendingPacket  = new DatagramPacket(SendingData, SendingData.length, IP,PortNum);
        
        CSocket.send(SendingPacket);
        
        byte[] ReceivingData = new byte[1024];
        DatagramPacket ReceivingPacket  = new DatagramPacket(ReceivingData, ReceivingData.length);
        CSocket.receive(ReceivingPacket);
        String Final;
        Final = new String(ReceivingPacket.getData());
        
        System.out.println("Response from server: " + Final);
        
        CSocket.close();
        
    }
    
    
    
    
}
