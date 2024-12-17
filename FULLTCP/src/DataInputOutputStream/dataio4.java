
package DataInputOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.util.*;

public class dataio4 {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        
        dos.writeUTF("B21DCCN803;awUwuPKb");
        dos.flush();
        
        int a = dis.readInt(), b = dis.readInt();
        int tong = a+b, tich = a*b;
        BigInteger bigA = new BigInteger(a+"");
        BigInteger bigB = new BigInteger(b+"");
        
        int gcd = Integer.parseInt(bigA.gcd(bigB)+"");
        int bcnn = a*b/gcd;
        
        dos.writeInt(gcd);
        dos.writeInt(bcnn);
        dos.writeInt(tong);
        dos.writeInt(tich);
        
        socket.close();
    }
    
}
