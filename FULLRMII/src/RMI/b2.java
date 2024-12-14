package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class b2 {
  public static void main(String[] args) throws Exception {
    Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
    DataService sv = (DataService) res.lookup("RMIDataService");
    String input = (String)sv.requestData("B21DCCN775", "oAt42XzE");
    String [] inputArr = input.split(";");
    int n = Integer.parseInt(inputArr[0].trim());
    int k = Integer.parseInt(inputArr[1].trim());

    List<Integer> list = new ArrayList<>(); 
    for(int i = n ; i < k; i++){
      String x = i+"";
      int check = 0;
      for(int j = 0; j < Math.floor(x.length()/2); j++){
        if(x.charAt(j) != x.charAt(x.length()-1-j)){
          check = 1;
          break;
        }
      }
      if(check == 0) list.add(i);
    }
    sv.submitData("B21DCCN775", "oAt42XzE", list);
  }
}
