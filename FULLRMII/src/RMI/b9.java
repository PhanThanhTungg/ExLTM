package RMI;
import java.rmi.RemoteException;
import java.rmi.registry.*;

public class b9 {
    public static String solve(byte a){
        String ans = "";
        while(a > 0){
            ans =  a%8 +ans;
            a/=8;
        }
        while(ans.length()<3) ans="0"+ans;
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) res.lookup("RMIByteService");
        byte[] input = sv.requestData("B21DCCN780", "VNEfcZz3");
        String output = "";
        for(byte x: input){
            output += solve(x);
        }
        sv.submitData("B21DCCN780", "VNEfcZz3", output.getBytes());
    }
    
}
