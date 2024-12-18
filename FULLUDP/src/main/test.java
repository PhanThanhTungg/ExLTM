package main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class test {
  public static void main(String[] args) throws Exception {
    DatagramSocket socket = new DatagramSocket();
    InetAddress sv = InetAddress.getByName("203.162.10.109");
    int port = 33333333;
    
    String code = ";B21DCCN;...";
    DatagramPacket sPacket = new DatagramPacket(code.getBytes(), code.length(), sv, port);
    socket.send(sPacket);
    
    byte[]bytes = new byte[2048];
    DatagramPacket rPacket = new DatagramPacket(bytes, bytes.length);
    socket.receive(rPacket);
    
    String requestId = new String(rPacket.getData(), 0, 8);
    
    ByteArrayInputStream bais = new ByteArrayInputStream(rPacket.getData(), 8, rPacket.getLength());
    ObjectInputStream ois = new ObjectInputStream(bais);
    //........
      
    
    bytes = new byte[2048];
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      oos.writeObject(aa);
      oos.flush();
      
      
      
      
    
    
  }
}
