package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class b5 {
  public static void main(String[] args) throws Exception {
    Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
    ByteService sv = (ByteService) res.lookup("RMIByteService");
    
    byte[] input = sv.requestData("B21DCCN703", "6qFMw9Ug");
    
    String output = "";
    String arrHex = "0123456789abcdef";
    for(byte x:input){
      String tmp ="";
      while(x != 0){
        tmp = arrHex.charAt(x%16)+tmp;
        x/=16;
      }
      output+=tmp;
    }

    sv.submitData("B21DCCN703", "6qFMw9Ug", output.getBytes());
    
  }
}
