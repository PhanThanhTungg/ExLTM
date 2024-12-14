package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b3 {
  public static void main(String[] args) throws Exception {
    Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
    ByteService sv = (ByteService) res.lookup("RMIByteService");
    byte[] input = sv.requestData("B21DCCN775", "dO09xH8x");
    List<Integer> list = new ArrayList<>();

    int k = Integer.parseInt(input[input.length-1]+"");
    for(int i = 0 ; i < input.length-1;i++){
      list.add(Integer.parseInt(input[i]+""));
    }
    List<Integer> listCopy = List.copyOf(list);

    Collections.sort(list, Collections.reverseOrder());

    Object[] outputArr = list.toArray();
    int output = Integer.parseInt(outputArr[k-1]+"");

    byte[] byteOutput = {(byte) output,(byte) (listCopy.indexOf(output)+1) };

    sv.submitData("B21DCCN775", "dO09xH8x", byteOutput);

  }
}
