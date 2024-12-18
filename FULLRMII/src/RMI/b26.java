
package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;

public class b26 {

    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService  sv = (ByteService ) res.lookup("RMIByteService");
        byte[] input = sv.requestData("B21DCCN002", "XwgdSU5o");
        String tmp = "";
        for(int i = 0 ; i < input.length; i++){
            tmp+= (char)input[i]+"";
        }
        sv.submitData("B21DCCN002", "XwgdSU5o", Base64.getDecoder().decode(tmp));
    }
    
}
