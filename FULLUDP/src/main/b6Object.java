package main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import UDP.Product;

public class b6Object {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    DatagramSocket socket = new DatagramSocket();
    InetAddress serverAddress = InetAddress.getByName("203.162.10.109");
    int port = 2209;

    String code = ";B21DCCN703;SCk7Nvmv";
    DatagramPacket sPacket = new DatagramPacket(code.getBytes(), code.length(), serverAddress, port);
    socket.send(sPacket);

    byte[] bytes = new byte[2048];
    DatagramPacket rPacket = new DatagramPacket(bytes, bytes.length);
    socket.receive(rPacket);

    String requestId = new String(bytes, 0, 8);
    
    ByteArrayInputStream bais = new ByteArrayInputStream(bytes, 8, bytes.length-8);
    ObjectInputStream ois = new ObjectInputStream(bais);
    Product a = (Product) ois.readObject();

    String[]nameArr = a.getName().split("\\s+");
    String tmp = nameArr[0];
    nameArr[0] = nameArr[nameArr.length-1];
    nameArr[nameArr.length-1] = tmp;
    String newName = "";
    for(int i = 0 ; i < nameArr.length; i++) newName+=nameArr[i]+" ";
    a.setName(newName.trim());

    StringBuilder sb = new StringBuilder(a.getQuantity()+"");
    a.setQuantity(Integer.parseInt(sb.reverse()+""));

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(a);
    oos.flush();

    bytes = new byte[2048];
    System.arraycopy(requestId.getBytes(), 0, bytes, 0, 8);
    System.arraycopy(baos.toByteArray(), 0, bytes, 8, baos.size());
    sPacket = new DatagramPacket(bytes, bytes.length, serverAddress, port);
    socket.send(sPacket);

    socket.close();
  }
}
