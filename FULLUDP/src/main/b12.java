
package main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b12 {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress svAddress = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        String code = ";B21DCCN126;x7sBuwgv";
        DatagramPacket sPacket = new DatagramPacket(code.getBytes(), code.length(), svAddress, port);
        socket.send(sPacket);
        
        byte[] bytes = new byte[1024];
        DatagramPacket rPacket = new DatagramPacket(bytes, bytes.length);
        socket.receive(rPacket);
        
        String input = new String(rPacket.getData(), 0, rPacket.getLength());
        String[]arr = input.split(";");
        
        List<Integer> li = new ArrayList<>();
        for(String x: arr[1].split(",")){
            li.add(Integer.parseInt(x));
        }
        
        Collections.sort(li);
        
        String ans = arr[0]+";"+li.get(li.size()-1)+","+li.get(0);
        
        sPacket = new DatagramPacket(ans.getBytes(), ans.length(), svAddress, port);
        socket.send(sPacket);
        socket.close();
    }
    
}
