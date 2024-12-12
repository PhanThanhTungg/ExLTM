package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.TreeSet;

public class b4 {
  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket();
    InetAddress serverAddress = InetAddress.getByName("203.162.10.109");
    int port = 2207;

    String code = ";B21DCCN703;Yvww9Id6";
    DatagramPacket sPacket = new DatagramPacket(code.getBytes(), code.length(), serverAddress, port);
    socket.send(sPacket);

    byte[] bytes = new byte[1024];
    DatagramPacket rPacket = new DatagramPacket(bytes, bytes.length);
    socket.receive(rPacket);

    String input = new String(rPacket.getData(), 0, rPacket.getLength());

    String[]inputArr = input.split(";");
    TreeSet<Integer> ts = new TreeSet<>();
    for(String x:inputArr[2].split(",")) ts.add(Integer.parseInt(x));
    String output = inputArr[0]+";";
    for(int i = 1 ; i <= Integer.parseInt(inputArr[1]);i++){
      if(!ts.contains(i)) output+=(i+",");
    }

    output = output.substring(0,output.length()-1);
    sPacket = new DatagramPacket(output.getBytes(), output.length(), serverAddress, port);
    socket.send(sPacket);

    socket.close();
    
  }
}
