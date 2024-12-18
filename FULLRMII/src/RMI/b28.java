
package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class b28 {

    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) res.lookup("RMIByteService");
        byte[] input = sv.requestData("B21DCCN004", "Yo4r28BW");
        
        String str = new String(input);
        String strXor = "PTIT";
        byte[] ans = new byte[input.length];
        for(int i = 0; i < str.length(); i++){
            char x = str.charAt(i);
            ans[i]=(byte)(x^strXor.charAt(i%4));
        }
        sv.submitData("B21DCCN004", "Yo4r28BW", ans);
    }
    
}
