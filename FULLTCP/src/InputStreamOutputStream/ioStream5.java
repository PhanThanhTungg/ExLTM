
package InputStreamOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class ioStream5 {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109",2206);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        
        String code = "B21DCCN716;3obplfDw";
        os.write(code.getBytes());
        os.flush();
        
        byte[]bytes = new byte[1024];
        int byteRead = is.read(bytes);
        String input = new String(bytes,0, byteRead);
        
        String[]arr = input.split(",");
        int[]num = new int[arr.length];
        for(int i = 0; i < num.length;i++) num[i] = Integer.parseInt(arr[i]);
        Arrays.sort(num);
        
        int min = Integer.MAX_VALUE;
        int val1 = 0, val2= 0;
        for(int i = 0; i< num.length-1;i++){
            int val = num[i+1]-num[i];
            if(val<=min){
                min = val;
                val1 = num[i];
                val2 = num[i+1];
            }
        }
        
        String ans = min+","+val1+","+val2;
        os.write(ans.getBytes());
        os.flush();
        socket.close();
    }
    
}
