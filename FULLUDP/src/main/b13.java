
package main;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;
public class b13 {

    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress svAddress = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        
        String code = ";B21DCCN786;HG01rV4c";
        DatagramPacket sPacket = new DatagramPacket(code.getBytes(), code.length(), svAddress, port); 
        socket.send(sPacket);
        
        byte[]bytes = new byte[1024];
        DatagramPacket rPacket = new DatagramPacket(bytes, bytes.length);
        socket.receive(rPacket);
        
        String input = new String(rPacket.getData(), 0,rPacket.getLength());
        String[]arr = input.split(";");
        
        int[]cnt = new int[1000];
        
        for(char x: arr[1].toCharArray()){
            cnt[x]++;
        }
        
        String output = arr[0]+";";
        for(int i = 0 ; i < arr[1].length();i++){
            if(cnt[arr[1].charAt(i)]!=0){
                output+=cnt[arr[1].charAt(i)]+""+arr[1].charAt(i);
                cnt[arr[1].charAt(i)] = 0;
            }
                
        }
        
        sPacket = new DatagramPacket(output.getBytes(), output.length(), svAddress, port);
        socket.send(sPacket);
        
        socket.close();
    }
    
}
