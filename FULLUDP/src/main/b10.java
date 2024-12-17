
package main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class b10 {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress svAddress = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        String code = ";B21DCCN780;mHTTtuzd";
        DatagramPacket sPacket = new DatagramPacket(code.getBytes(), code.length(), svAddress, port);
        socket.send(sPacket);
        
        byte[]bytes = new byte[1024];
        DatagramPacket rPacket = new DatagramPacket(bytes, bytes.length);
        socket.receive(rPacket);
        
        String[]rMess = new String(rPacket.getData(), 0, rPacket.getLength()).split(";");
        int sum = 0;
        for(char x: rMess[1].toCharArray()){
            sum+=Integer.parseInt(x+"");
        }
        String output = rMess[0]+";"+sum;
        
        sPacket = new DatagramPacket(output.getBytes(), output.length(),svAddress, port);
        socket.send(sPacket);
        
    }
    
}
