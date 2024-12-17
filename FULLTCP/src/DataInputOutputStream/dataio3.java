
package DataInputOutputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class dataio3 {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109",2207);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        
        String code = "B21DCCN126;XYCrAtdl";
        dos.writeUTF(code);
        dos.flush();
        
        String str = dis.readUTF();
        int s = dis.readInt();
        
        String ans = "";
        for(char x: str.toCharArray()){
            char ini = Character.isUpperCase(x)?'A':'a';
            x = (char)(ini + (x-ini+s)%26);
            ans+=x;
        }
        
        dos.writeUTF(ans);
        dos.flush();
        socket.close();
    }
    
}
