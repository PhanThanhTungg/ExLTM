
package RMI;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.List;
public class b11 {

    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService)res.lookup("RMIByteService");
        byte[] input = sv.requestData("B21DCCN126", "SPP67pF9");
        byte cnt = 1;
        List<Byte> li = new ArrayList<>();
        for(int i = 1; i < input.length; i++){
           if(input[i]==input[i-1]) cnt++;
           else{
               li.add(input[i-1]);
               li.add(cnt);
               cnt = 1;
           }
        }
        li.add(input[input.length-1]); li.add(cnt);
        
        byte[]output = new byte[li.size()];
        for(int i = 0; i < output.length;i++) output[i] = li.get(i);
        sv.submitData("B21DCCN126", "SPP67pF9", output);
    }
    
}
