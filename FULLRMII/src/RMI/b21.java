
package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class b21 {

    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService)res.lookup("RMIDataService");
        int input = (int)sv.requestData("B21DCCN764", "HUIP9uWU");
        List<Integer> li = new ArrayList<>();
        
        for(int i = 2; input > 1; i++){
            while(input%i==0){
                li.add(i);
                input/=i;
            }
        }
        
        sv.submitData("B21DCCN764", "HUIP9uWU", li);
        
        
    }
    
}
