package fullws;
import java.util.*;
import vn.medianews.*;
public class B3 {
    public static void main(String[] args) {
        ObjectService_Service svv = new ObjectService_Service();
        ObjectService sv = svv.getObjectServicePort();
        List<Customer> li = sv.requestListCustomer("B21DCCN775", "65TRdLFF");
      
        for(int i = 0 ; i < li.size(); i++){
            Customer x = li.get(i);
            if(x.getTotalSpent() < 5000 || x.getPurchaseCount() < 5){
                li.remove(i);
                i-=1;
            }
        }
       
        sv.submitListCustomer("B21DCCN775", "65TRdLFF", li);
    }
    
}
