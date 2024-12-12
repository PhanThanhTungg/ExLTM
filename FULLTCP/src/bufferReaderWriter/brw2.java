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

public class brw2 {
  public static void main(String[] args) throws UnknownHostException, IOException {
    Socket socket = new Socket("203.162.10.109", 2208);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    bw.write("B21DCCN728;5EVRh0wr\n");
    bw.flush();

    String input = br.readLine();
    System.out.println(input);

    LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<>();
    for(char x: input.toCharArray()){
      if(!lhm.containsKey(x)) lhm.put(x, 1);
      else lhm.put(x,lhm.get(x)+1);
    }

    String output = "";
    for(Map.Entry<Character, Integer> ets: lhm.entrySet()){
      if(Character.isLetterOrDigit(ets.getKey()) && ets.getValue()>1)
        output+=(ets.getKey()+":"+ets.getValue()+",");
    }
    bw.write(output);
    bw.flush();
    socket.close();


  }
}
