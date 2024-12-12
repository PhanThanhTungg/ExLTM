package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class b8 {

  public static boolean checkSNT(int a){
    for(int i = 2; i <= Math.sqrt(a);i++){
      if(a%i==0) return false;
    }
    return true;
  }
  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket();
    InetAddress servAddress = InetAddress.getByName("203.162.10.109");
    int port = 2207;

    String code = ";B21DCCN728;qfUDgkfS";
    DatagramPacket sPacket = new DatagramPacket(code.getBytes(), code.length(), servAddress, port);
    socket.send(sPacket);
    
    byte[] bytes = new byte[1024];
    DatagramPacket rPacket = new DatagramPacket(bytes, bytes.length);
    socket.receive(rPacket);

    String input = new String(rPacket.getData(), 0, rPacket.getLength());

    String[]inputArr = input.split(";");
    int n = Integer.parseInt(inputArr[1]);

    String output = inputArr[0]+";";
    int i = 2, cnt = 0;
    while(true){
      if(checkSNT(i)){
        output+=(i+",");
        cnt++;
      }
      if(cnt==n) break;
      i++;
    }
    output = output.substring(0, output.length()-1);
    
    sPacket = new DatagramPacket(output.getBytes(), output.length(), servAddress, port);
    socket.send(sPacket);

    socket.close();
  }
}
