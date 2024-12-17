
package InputStreamOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;
public class ioStream4 {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2206);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        String code = "B21DCCN780;aXRct51I";
        
        os.write(code.getBytes());
        os.flush();
        
        byte[] bytes = new byte[1024];
        int byteRead = is.read(bytes);
        String input = new String(bytes, 0, byteRead);
        
        List<Integer> li = new ArrayList<>();
        for(String x: input.trim().split(",")){
            li.add(Integer.parseInt(x));
        }
        List<Integer> iniLi = List.copyOf(li);
        Collections.sort(li, Collections.reverseOrder());
        int val = li.get(1);
        int pos = iniLi.indexOf(val);
        String output = val+","+pos;
        
        os.write(output.getBytes());
        os.flush();
        
        
        socket.close();
    }
    
}
