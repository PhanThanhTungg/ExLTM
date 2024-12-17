
package fullws;
import java.time.LocalDate;
import java.util.*;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.OrderY;
public class B17 {

    public static void main(String[] args) throws Exception{
        ObjectService_Service svv = new ObjectService_Service();
        ObjectService sv = svv.getObjectServicePort();
        List<OrderY> li = sv.requestListOrderY("B21DCCN803", "ir8l4ZvZ");
        List<OrderY> ans = new ArrayList<>();
        for(OrderY x: li){
            if(x.getStatus().equals("pending") || x.getStatus().equals("processing")){
                String strDate = x.getOrderDate().toString().substring(0,10);
                LocalDate now = LocalDate.now();
                LocalDate last = LocalDate.parse(strDate);
                
                if(last.isBefore(now.minusDays(30))){
                    ans.add(x);
                }
            }
        }
        sv.submitListOrderY("B21DCCN803", "ir8l4ZvZ", ans);
    }
    
}
