
package fullws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class B18 {

    public static void main(String[] args) {
        DataService_Service svv = new DataService_Service();
        DataService sv = svv.getDataServicePort();
        List<Integer> li = sv.getData("B21DCCN803", "oyF1kJvE");
        Collections.sort(li, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                int n = Math.min((o1+"").length(), (o2+"").length());
                return -(o1+"").substring(0, n).compareTo((o2+"").substring(0,n));
            }
            
        });
        String ans = "";
        for(int x: li){
            ans+=x+"";
        }
        sv.submitDataString("B21DCCN803", "oyF1kJvE", ans);
    }
    
}
