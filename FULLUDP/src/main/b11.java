
package main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class b11 {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress svAddress = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        
        String code = ";B21DCCN126;lQbfVO0m";
        DatagramPacket sPacket = new DatagramPacket(code.getBytes(), code.length(), svAddress, port);
        socket.send(sPacket);
        
        byte[] bytes = new byte[1024];
        DatagramPacket rPacket = new DatagramPacket(bytes, bytes.length);
        socket.receive(rPacket);
        
        String input = new String(rPacket.getData(), 0, rPacket.getLength());
        String[]arr = input.split(";");
        String ans = "";
        for(String x: arr[1].split("\\s+")){
            ans+=x.substring(0,1).toUpperCase()+x.substring(1).toLowerCase()+" ";
        }
        
        ans = arr[0]+";"+ans.trim();
        sPacket = new DatagramPacket(ans.getBytes(), ans.length(), svAddress, port);
        socket.send(sPacket);
        socket.close();
    }
    
}
