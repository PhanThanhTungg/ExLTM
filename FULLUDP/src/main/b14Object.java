package main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import UDP.Customer;

public class b14Object {
  public static void main(String[] args) throws Exception {
    DatagramSocket socket = new DatagramSocket();
    InetAddress svAddress = InetAddress.getByName("203.162.10.109");
    int port = 2209;

    String code = ";B17DCAT176;OH7rzusB";
    DatagramPacket sPacket = new DatagramPacket(code.getBytes(), code.length(), svAddress, port);
    socket.send(sPacket);

    byte[] bytes = new byte[2048];
    DatagramPacket rPacket = new DatagramPacket(bytes, bytes.length);
    socket.receive(rPacket);

    String requestId = new String(bytes, 0, 8);
    
    ByteArrayInputStream bais = new ByteArrayInputStream(bytes, 8, bytes.length-8);
    ObjectInputStream ois = new ObjectInputStream(bais);
    Customer a = (Customer) ois.readObject();
    
    String[]nameArr = a.getName().split("\\s+");
    String newName = nameArr[nameArr.length-1].toUpperCase()+",";
    String newUserName = "";
    for(int i = 0; i < nameArr.length-1;i++){
      newName+=" "+nameArr[i].substring(0,1).toUpperCase()+
      nameArr[i].substring(1).toLowerCase();
      newUserName += (nameArr[i].charAt(0)+"").toLowerCase();
    }
    newUserName+=nameArr[nameArr.length-1].toLowerCase();
    a.setName(newName);
    a.setUserName(newUserName);

    String[]birthArr = a.getDayOfBirth().split("-");
    a.setDayOfBirth(birthArr[1]+"/"+birthArr[0]+"/"+birthArr[2]);

    bytes = new byte[2048];
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(a);
    oos.flush();

    System.arraycopy(requestId.getBytes(), 0, bytes, 0, 8);
    System.arraycopy(baos.toByteArray(), 0, bytes, 8, baos.size());

    sPacket = new DatagramPacket(bytes, bytes.length, svAddress, port);
    socket.send(sPacket);
    socket.close();

  }
}
