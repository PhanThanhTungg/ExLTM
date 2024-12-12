package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class b7 {
  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket();
    InetAddress servAddress = InetAddress.getByName("203.162.10.109");
    int port = 2208;

    String code = ";B21DCCN728;sZUo1GIJ";
    DatagramPacket sPacket = new DatagramPacket(code.getBytes(), code.length(), servAddress, port);
    socket.send(sPacket);
    
    byte[] bytes = new byte[1024];
    DatagramPacket rPacket = new DatagramPacket(bytes, bytes.length);
    socket.receive(rPacket);

    String input = new String(rPacket.getData(), 0, rPacket.getLength());

    String[] inputArr = input.split(";");
    String str1 = inputArr[1], str2 = inputArr[2];
    int i = 0;
    while(i < str1.length()){
      if(str2.contains(str1.charAt(i)+"")==true){
        if(i==str1.length()-1) str1 = str1.substring(0, i);
        else str1 = str1.substring(0, i)+str1.substring(i+1);
        i--;
      }
        
      i++;
    }

    str1 = inputArr[0]+";"+str1;
    System.out.println(str1);
    sPacket = new DatagramPacket(str1.getBytes(), str1.length(), servAddress, port);
    socket.send(sPacket);

    socket.close();
  }
}
