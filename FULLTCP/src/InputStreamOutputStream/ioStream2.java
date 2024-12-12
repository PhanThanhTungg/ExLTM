package InputStreamOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ioStream2 {
  public static void main(String[] args) throws UnknownHostException, IOException {
    Socket socket = new Socket("203.162.10.109", 2206);
    OutputStream os = socket.getOutputStream();
    InputStream is = socket.getInputStream();

    os.write("B21DCCN703;J4aBFK6m".getBytes());
    os.flush();

    byte[] bytes = new byte[1024];
    int byteRead = is.read(bytes);
    String input = new String(bytes, 0, byteRead);
    char[] x = input.toCharArray();
    int max = 0, begin = 0, end = 0;
    for(int i = 0 ; i < x.length; i++){
      int[]cntArr = new int[1000];
      int cnt = 0;
      for(int j = i; j < x.length;j++){
        if(cntArr[x[j]]==1){
          if(cnt > max){
            max = cnt;
            begin = i;
            end = j-1;
          }
          break;
        }
        else{
          cntArr[x[j]]++;
          cnt++;
        }
      }
    }
    String output = "";
    for(int i = begin; i <= end; i++){
      output+=(x[i]+"");
    }
    output+=(";"+max);
    os.write(output.getBytes());
    os.flush();
    socket.close();
    
  }
  
}