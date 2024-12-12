package DataInputOutputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class dataio2 {
  public static void main(String[] args) throws UnknownHostException, IOException {
    Socket socket = new Socket("203.162.10.109", 2207);
    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
    DataInputStream dis = new DataInputStream(socket.getInputStream());

    dos.writeUTF(("B21DCCN703;k0RTJe0d"));
    dos.flush();

    int n = dis.readInt();
    int[]a = new int[n];
    int sum = 0;
    float avg = 0f;
    float s = 0f;
    for(int i = 0 ; i < n; i++){
      a[i] = dis.readInt();
      sum += a[i];
      avg += a[i]/(float)n;
    }
    for(int i = 0; i < n ; i++){
      s+=Math.pow(a[i]-avg, 2)/n;
    }
    dos.writeInt(sum);
    dos.writeFloat(avg);
    dos.writeFloat(s);
    
    socket.close();
  }
}
