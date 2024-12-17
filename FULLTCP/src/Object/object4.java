
package Object;
import TCP.Product;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;
public class object4 {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        
        String code = "B21DCCN786;M9DMR3MK";
        oos.writeObject(code);
        oos.flush();
        
        Product a = (Product) ois.readObject();
        int val = (int) a.getPrice();
        int tmp = 0;
        for(char x: (val+"").toCharArray()){
            tmp+=Integer.parseInt(x+"");
        }
        a.setDiscount(tmp);
        
        oos.writeObject(a);
        oos.flush();
        socket.close();
    }
    
}
