package bufferReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.Map;

public class brw1 {
  public static void main(String[] args) throws UnknownHostException, IOException {
    Socket socket = new Socket("203.162.10.109", 2208 );
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    bw.write("B21DCCN775;4G3vbY8Q\n");
    bw.flush();

    String input = br.readLine();
    int[]cnt = new int[1000];
    for(char x: input.toCharArray()) if(Character.isAlphabetic(x)) cnt[x]++;
    String output= "";
    for(char x: input.toCharArray())
        if(cnt[x]>0){
            output+=x;
            cnt[x]=0;
        }

    bw.write(output);
    bw.flush();

    socket.close();
  }
}
