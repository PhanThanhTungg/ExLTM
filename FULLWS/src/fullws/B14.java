
package fullws;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import vn.medianews.*;
import java.util.*;
public class B14 {

    public static void main(String[] args) throws Exception {
        ObjectService_Service svv = new ObjectService_Service();
        ObjectService sv = svv.getObjectServicePort();
        
        List<CustomerY> li =  sv.requestListCustomerY("B21DCCN126", "1s8adhKb");
        for(int i = 0 ; i < li.size(); i++){
            CustomerY tmp = li.get(i);
            LocalDate now = LocalDate.now();
            LocalDate last = LocalDate.parse(tmp.getLastTransactionDate().toString()
                            .substring(0,10));
            if(last.isAfter(now.minusMonths(6))){
                li.remove(i);
                i--;
            }
        }
        sv.submitListCustomerY("B21DCCN126", "1s8adhKb", li);
    }
    
}
