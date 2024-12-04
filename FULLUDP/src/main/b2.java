package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class b2 {
  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket();
    InetAddress serverAddress = InetAddress.getByName("203.162.10.109");
    int port = 2207;

    String sendMess = ";B21DCCN775;nFtPCNlv";
    DatagramPacket pSend = new DatagramPacket(sendMess.getBytes(), sendMess.length(), serverAddress, port);
    socket.send(pSend);

    byte[] bytes = new byte[1024];
    DatagramPacket pReceive = new DatagramPacket(bytes, bytes.length);
    socket.receive(pReceive);

    String receiveMess = new String(pReceive.getData(), 0, pReceive.getLength());
    String[] arr = receiveMess.split(";");

    int s = Integer.parseInt(arr[2]);
    String str = arr[1];
    
    for(int i = 0 ; i < str.length(); i ++){
      char x = str.charAt(i);
      char initial = Character.isUpperCase(x)?'A':'a';
      char newX = (char)(initial+(x+s-initial)%26);
      str = str.substring(0, i)+newX+str.substring(i+1);
    }

    str = arr[0]+";"+str;
    pSend = new DatagramPacket(str.getBytes(), str.length(), serverAddress, port);
    socket.send(pSend);

    socket.close();


  }
}
