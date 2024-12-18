
package fullws;

import java.time.LocalDate;
import java.util.List;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.Project;


public class B24 {

    public static void main(String[] args) {
        ObjectService_Service svv = new ObjectService_Service();
        ObjectService sv = svv.getObjectServicePort();
        List<Project> li = sv.requestListProject("B21DCCN715", "CtlpMEfh");
        
        for(int i = 0 ; i < li.size(); i++){
            Project x = li.get(i);
            if(x.getCompletionPercentage() > 80){
                LocalDate now = LocalDate.now();
                String strNext = x.getDueDate().toString().substring(0,10);
                LocalDate next = LocalDate.parse(strNext);
                if(next.isBefore(now.plusDays(15))) continue;
            }
            li.remove(i); i--;
        }
        sv.submitListProject("B21DCCN715", "CtlpMEfh", li);
    }
    
}
