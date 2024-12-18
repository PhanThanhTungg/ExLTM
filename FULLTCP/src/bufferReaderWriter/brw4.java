
package bufferReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Comparator;

public class brw4 {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        String code = "B21DCCN739;2w3Ur3BA\n";
        bw.write(code);
        bw.flush();
        
        String input = br.readLine().trim();

        String[]arr = input.split("\\s+");
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        
        int pos = input.indexOf(arr[0]);

        bw.write(arr[0]);
        bw.newLine();
        bw.flush();
        bw.write(pos+"");
        bw.newLine();
        bw.flush();
        socket.close();
    }
}
