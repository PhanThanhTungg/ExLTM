
package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class b1 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        
        String code = ";B21DCCN775;s0tWWOiR";
        DatagramPacket dPacket = new DatagramPacket(code.getBytes(), code.length(), serverAddress, port);
        socket.send(dPacket);

        byte[] receivedData = new byte[1024];
        DatagramPacket rPacket = new DatagramPacket(receivedData, receivedData.length);
        socket.receive(rPacket);

        String receiveMess = new String(rPacket.getData(), 0, rPacket.getLength());
        String []arr = receiveMess.split(";");
        int []cnt = new int[1000];
        int max = 0;
        for(char x: arr[1].toCharArray()){
            cnt[x]++;
            if(cnt[x]>max){
                max = cnt[x];
            }
        }

        char charMax = 'a';
        for(char x: arr[1].toCharArray()){
            if(cnt[x]==max){
                charMax = x;
                break;
            }
        }

        String pos = "";
        for(int i = 0 ; i < arr[1].length();i++) 
            if(arr[1].charAt(i)==charMax){
                int a = i + 1;
                pos+= a+",";
            }

        String sendMess = arr[0]+";"+charMax+":"+pos;
        dPacket = new DatagramPacket(sendMess.getBytes(), sendMess.length(), serverAddress, port);
        socket.send(dPacket);

        socket.close();

    }
}
