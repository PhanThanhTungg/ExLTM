/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package basic;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Scanner;

public class client {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 1000;
            
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.print("MessToServer: ");
                String mess = sc.nextLine();
                DatagramPacket sendData = new DatagramPacket(mess.getBytes(), mess.length(),serverAddress, serverPort);
                socket.send(sendData);
                
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String receiveMess = new String(receivePacket.getData(),0, receivePacket.getLength());
                if(receiveMess.trim().length()>0) System.out.println("Server: "+ receiveMess.trim());
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
}
