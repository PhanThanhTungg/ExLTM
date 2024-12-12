package InputStreamOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ioStream1 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        
        String code = "B21DCCN775;yD5O6nfk";
        os.write(code.getBytes());
        os.flush();
        
        byte[] buffer = new byte[1024];
        int byteReads = is.read(buffer);
        String input = new String(buffer,0,byteReads);
        
        System.out.println(input);
        ArrayList<Integer> arl = new ArrayList<>();
        for(String x: input.split("\\s+")) arl.add(Integer.parseInt(x));
        int max = 1;
        int cnt = 1;
        for(int i = 0; i < arl.size()-1;i++){
            if(arl.get(i+1) > arl.get(i)) cnt+=1;
            else cnt = 1;
            if(cnt > max) max = cnt;
        }
        
        os.write((max+"").getBytes());
        os.flush();
        socket.close();
    }
    
}
