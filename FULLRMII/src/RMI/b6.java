package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class b6 {
  public static void main(String[] args) throws Exception {
    Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
    DataService  sv = (DataService ) res.lookup("RMIDataService");
    
    int input =(int) sv.requestData("B21DCCN703", "EweJ3K0R");
    System.out.println(input);

    int[] arrCoin = new int[]{10,5,2,1};
    int cnt = 0;
    String output = "";

    for(int x: arrCoin){
      while(input > 0){
        if(input>=x){
          output+=x+",";
          cnt++;
          input-=x;
        }
        else break;
      }
    }
    
    output = cnt+"; "+output.substring(0, output.length()-1);
    System.out.println(output);
    sv.submitData("B21DCCN703", "EweJ3K0R", output);
    
  }
}
