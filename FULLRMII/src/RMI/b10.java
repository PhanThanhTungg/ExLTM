
package RMI;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
public class b10 {
    public static TreeSet<String> st = new TreeSet<>();
    public static int[]input;
    public static boolean []check;
    public static void solve(String str, int cnt){
        if(cnt==input.length){
            st.add(str.substring(0, str.length()-2));
            return;
        }
        for(int i = 0; i < input.length;i++){
            if(!check[i]){
                check[i] = true;
                solve(str+input[i]+", ", cnt+1);
                check[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) res.lookup("RMIDataService");
        String inputStr = (String)sv.requestData("B21DCCN780", "sdGkLzBN");
        String[]arr = inputStr.split(",");
        input = new int[arr.length];
        check = new boolean[arr.length];
        for(int i = 0 ; i < input.length;i++) 
            input[i] = Integer.parseInt(arr[i].trim());
        solve("", 0);
        
        List<String> li = new ArrayList<>(st);
        
        String output="";
        int pos = li.indexOf(inputStr);
        if(pos == li.size()-1) output = li.get(0);
        else output = li.get(pos+1);
     
        String outputTmp = "";
        for(String x: output.split(",")){
            outputTmp+=x.trim()+",";
        }
        
        sv.submitData("B21DCCN780", "sdGkLzBN", outputTmp.substring(0, outputTmp.length()-1));
    }
    
}
