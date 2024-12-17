package fullws;

import java.util.*;
import vn.medianews.*;

public class B5 {
    public static String solve(int a){
        String ans = "";
        int i = 2;
        while(a!=1){
            if(a%i==0){
                ans+=i+", ";
                a/=i;
            }
            else i++;
        }
        return ans.substring(0,ans.length()-2);
    }

    public static void main(String[] args) {
        DataService_Service svv = new DataService_Service();
        DataService sv = svv.getDataServicePort();
        List<Integer> li = sv.getData("B21DCCN703", "lU1IrFkg");
        
        List<String> output = new ArrayList<>();
        for(int x: li) output.add(solve(x));
        sv.submitDataStringArray("B21DCCN703", "lU1IrFkg", output);
    }
    
}
