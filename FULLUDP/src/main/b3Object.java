package main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import UDP.Student;
import basic.server;


public class b3Object {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    DatagramSocket socket = new DatagramSocket();
    InetAddress serverAddress = InetAddress.getByName("203.162.10.109");
    int port = 2209;

    String code = ";B21DCCN775;QqtTbcau";
    DatagramPacket sPacket = new DatagramPacket(code.getBytes(), code.length(), serverAddress, port);
    socket.send(sPacket);

    byte[] bytes = new byte[2048];
    DatagramPacket rPacket = new DatagramPacket(bytes, bytes.length);
    socket.receive(rPacket);

    String requestId = new String(rPacket.getData(), 0, 8);

    ByteArrayInputStream bais = new ByteArrayInputStream(rPacket.getData(), 8, rPacket.getLength()-8);
    ObjectInputStream ois = new ObjectInputStream(bais);
    Student a = (Student) ois.readObject();

    String[] nameArr = a.getName().split("\\s+");
    String newName = "";
    String email = nameArr[nameArr.length-1].toLowerCase();
    for(int i = 0 ; i < nameArr.length; i++){
      String x = nameArr[i];
      newName+=x.substring(0,1).toUpperCase()+x.substring(1).toLowerCase()+" ";
      if(i!=nameArr.length-1)
        email+=x.substring(0, 1).toLowerCase();
    }
      
    a.setName(newName.trim());
    a.setEmail(email.trim()+"@ptit.edu.vn");

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(a);
    oos.flush();
    
    bytes = new byte[2048];
    System.arraycopy(requestId.getBytes(), 0, bytes, 0,8);
    System.arraycopy(baos.toByteArray(), 0, bytes, 8, baos.size());
    sPacket = new DatagramPacket(bytes, bytes.length, serverAddress, port);
    socket.send(sPacket);

    socket.close();
  }
}
