package DataInputOutputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class dataio1 {
  public static void main(String[] args) throws UnknownHostException, IOException {
    Socket socket = new Socket("203.162.10.109", 2207);
    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
    DataInputStream dis = new DataInputStream(socket.getInputStream());

    dos.writeUTF("B21DCCN775;UtiOuEZS");
    dos.flush();

    int n = dis.readInt();
    int[]cnt = new int[7];
    for(int i = 0; i < n; i++){
      cnt[dis.readInt()]++;
    }

    for(int i = 1; i <=6; i++){
      dos.writeFloat((float)cnt[i]/n);
      System.out.println((float)cnt[i]/n);
      dos.flush();
    }

    socket.close();
  }
}
