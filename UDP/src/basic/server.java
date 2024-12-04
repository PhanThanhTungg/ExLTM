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

public class server {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(1000);
            InetAddress address = InetAddress.getByName("localhost");
            
            System.out.println("Server is running...");
            byte[] receiveData = new byte[1024];
            Scanner sc = new Scanner(System.in);
            while(true){
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String receiveMess = new String(receivePacket.getData(),0,receivePacket.getLength());
                if(receiveMess.trim().length() > 0){
                    System.out.println("Client: "+ receiveMess);
                }
                
                
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                System.out.print("Server: "); String messSend = sc.nextLine();
                DatagramPacket sendData = new DatagramPacket(messSend.getBytes(), messSend.length(),clientAddress, clientPort);
                socket.send(sendData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
