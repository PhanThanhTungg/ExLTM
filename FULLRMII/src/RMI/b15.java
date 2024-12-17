
package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class b15 {

    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService  sv = (ByteService ) res.lookup("RMIByteService");
        byte[] input = sv.requestData("B21DCCN786", "EVb5Iq1T");
        
        byte[] output = new byte[input.length];
        int i = 0;
        for(byte x: input)
            if(x%2==0){
                output[i] = x; i++;
            }
        
        for(byte x: input)
            if(x%2==1){
                output[i] = x; i++;
            }
        
        sv.submitData("B21DCCN786", "EVb5Iq1T", output);
    }
    
}
