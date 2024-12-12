package InputStreamOutputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;

public class ioStream3 {
  public static void main(String[] args) throws UnknownHostException, IOException {
    Socket socket = new Socket("203.162.10.109", 2206);
    OutputStream os = socket.getOutputStream();
    InputStream is = socket.getInputStream();
    
    os.write("B21DCCN727;ow1OSGK0".getBytes());
    os.flush();
    
    byte[] bytes = new byte[1024];
    int byteRead = is.read(bytes);
    String msgFromServer = new String(bytes, 0, byteRead);
    ArrayList<Integer> chan = new ArrayList<>();
    ArrayList<Integer> le = new ArrayList<>();
    for(String c: msgFromServer.split(",")){
        int x = Integer.parseInt(c);
        if(x % 2 == 0) chan.add(x);
        else le.add(x);
    }
    Collections.sort(chan);
    Collections.sort(le);
    
    String result = chan.toString()+";"+le.toString();
    os.write(result.getBytes());
    os.flush();

    socket.close();
  }
}
