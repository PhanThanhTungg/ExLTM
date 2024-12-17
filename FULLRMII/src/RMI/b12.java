
package RMI;
import java.rmi.RemoteException;
import java.util.*;
import java.rmi.registry.*;
public class b12 {
    public static List<Integer> li = new ArrayList<>();
    public static List<List<Integer>> output = new ArrayList<>();
    public static int k;
    
    public static void solve(int i, List<Integer> a){
        if(a.size()==k){
            output.add(a);
            return;
        }
        for(int j = i; j < li.size(); j++){
            List<Integer> tmp = new ArrayList<>(a);
            tmp.add(li.get(j));
            solve(j+1,tmp);
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService)res.lookup("RMIDataService");
        String input = (String)sv.requestData("B21DCCN126", "XKZkjYOq");
        String[]arr = input.split(";");
        for(String x: arr[0].split(",")){
            li.add(Integer.parseInt(x.trim()));
        }
        k = Integer.parseInt(arr[1].trim());
        System.out.println(k);
        System.out.println(arr[0]);
        solve(0, new ArrayList<>());
        sv.submitData("B21DCCN126", "XKZkjYOq", output);
        
    }
    
}
