
package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class b20 {

    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService  sv = (ByteService ) res.lookup("RMIByteService");
        byte[] input = sv.requestData("B21DCCN764", "xuZIChAO");
        
        for(int i = 0 ; i < input.length;i++){
            input[i]+=input.length;
        }
        sv.submitData("B21DCCN764", "xuZIChAO", input);
        
    }
    
}
