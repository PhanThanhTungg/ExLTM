
package fullws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class B10 {
    public static String convert(int a){
        String ans = "";
        while(a>0){
            ans = a%2+ans;
            a/=2;
        }
        return ans;
    }

    public static void main(String[] args) {
        DataService_Service svv = new DataService_Service();
        DataService sv = svv.getDataServicePort();
        List<Integer> li = sv.getData("B21DCCN780", "lxyKxFc7");
        
        List<String> ans = new ArrayList<>();
        for(int x: li){
           ans.add(convert(x));
        }
      
        sv.submitDataStringArray("B21DCCN780", "lxyKxFc7", ans);
    }
    
}
