package RMI;
import java.rmi.RemoteException;
import java.rmi.registry.*;

public class b9 {
    
    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) res.lookup("RMIByteService");
        byte[] input = sv.requestData("B21DCCN780", "VNEfcZz3");
        String output = "";
        for(byte x: input){
            output += Integer.toOctalString(x);
        }
        sv.submitData("B21DCCN780", "VNEfcZz3", output.getBytes());
    }
    
}
