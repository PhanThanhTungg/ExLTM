
package RMI;
import java.rmi.registry.*;
import java.util.*;
public class b18 {

    public static void main(String[] args) throws Exception{
        Registry res = LocateRegistry.getRegistry("203.162.10.109");
        DataService sv = (DataService) res.lookup("RMIDataService");
        
        int n = (int) sv.requestData("B21DCCN803", "lhxOIpXR");
        List<List<Integer>> output = new ArrayList<>();
        
        for(int i = 1; i <= n-1; i++){
            for(int j = i+1; j <=n; j++){
                int val = (int)Math.sqrt(i*i+j*j);
                if(Math.pow(val, 2)==i*i+j*j && val <=n){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i); tmp.add(j); tmp.add(val);
                    output.add(tmp);
                }
                if(val > n) break;
            }
        }
        
        sv.submitData("B21DCCN803", "lhxOIpXR", output);
    }
    
}
