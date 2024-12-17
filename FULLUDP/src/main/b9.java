
package main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class b9 {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress svAddress = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        
        String code = ";B21DCCN780;rafY7Kmf";
        DatagramPacket spacket = new DatagramPacket(code.getBytes(), code.length(), svAddress, port);
        socket.send(spacket);
        
        byte[] bytes = new byte[1024];
        DatagramPacket rPacket = new DatagramPacket(bytes, bytes.length);
        socket.receive(rPacket);
        
        String []rMess = new String(rPacket.getData(), 0, rPacket.getLength()).split(";");
        String requestId = rMess[0], input = rMess[1];
        
        LinkedHashMap<Character, Integer> mp = new LinkedHashMap<>();
        for(char x: input.toCharArray()){
            if(!mp.containsKey(x)) mp.put(x, 1);
            else mp.put(x, mp.get(x)+1);
        }
        
        char keyMax = 'a';
        int valMax = 0;
        for(Map.Entry<Character, Integer> et: mp.entrySet()){
            if(et.getValue() > valMax){
                valMax = et.getValue();
                keyMax = et.getKey();
            }
        }
        
        String output = requestId+";"+keyMax+":";
        for(int i = 0; i < input.length();i++){
            if(input.charAt(i)==keyMax) output+=(i+1)+",";
        }
        System.out.println(output);
        spacket = new DatagramPacket(output.getBytes(), output.length(), svAddress, port);
        socket.send(spacket);
    }
    
}
