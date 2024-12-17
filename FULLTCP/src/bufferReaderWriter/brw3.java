
package bufferReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class brw3 {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        String code = "B21DCCN780;WOxzqSUg\n";
        bw.write(code);
        bw.flush();
        
        String str1 = br.readLine(), str2 = br.readLine();
        
        for(int i = 0 ; i < str1.length(); i++){
            if(str2.contains(str1.charAt(i)+"")){
                str1 = str1.substring(0, i)+str1.substring(i+1);
                i--;
            }
        }
        
        bw.write(str1+"\n");
        bw.flush();
    }
    
}
