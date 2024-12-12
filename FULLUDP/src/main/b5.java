package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.LinkedHashSet;

public class b5 {
  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket();
    InetAddress servAddress = InetAddress.getByName("203.162.10.109");
    int port = 2208;

    String code = ";B21DCCN703;0uQx6iUh";
    DatagramPacket sPacket = new DatagramPacket(code.getBytes(), code.length(), servAddress, port);
    socket.send(sPacket);
    
    byte[] bytes = new byte[1024];
    DatagramPacket rPacket = new DatagramPacket(bytes, bytes.length);
    socket.receive(rPacket);

    String input = new String(rPacket.getData(), 0, rPacket.getLength());
    String[]inputArr = input.trim().split(";");
    LinkedHashSet<Character> lhs = new LinkedHashSet<>();
    for(Character x: inputArr[1].toCharArray()) lhs.add(x);
    String output = inputArr[0]+";";
    for(char x: lhs)
      if(Character.isAlphabetic(x)) output+=x;
    
    sPacket = new DatagramPacket(output.getBytes(), output.length(), servAddress, port);
    socket.send(sPacket);

    socket.close();

  }
}
