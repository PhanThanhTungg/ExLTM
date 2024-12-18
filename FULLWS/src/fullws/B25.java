
package fullws;
import java.time.LocalDate;
import java.util.*;
import vn.medianews.*;
public class B25 {

    public static void main(String[] args) throws Exception{
        ObjectService_Service svv = new ObjectService_Service();
        ObjectService sv = svv.getObjectServicePort();
        List<EmployeeY> li = sv.requestListEmployeeY("B21DCCN004", "vewbvojZ");
        Collections.sort(li, new Comparator<EmployeeY>(){
            public int compare(EmployeeY o1, EmployeeY o2) {
                String strDate1 = o1.getStartDate().toString().substring(0,10);
                String strDate2 = o2.getStartDate().toString().substring(0,10);
                LocalDate date1 = LocalDate.parse(strDate1);
                LocalDate date2 = LocalDate.parse(strDate2);
                if(date1.isBefore(date2)) return -1;
                else if(date1.isAfter(date2)) return 1;
                return 0;
            }
        });
        sv.submitListEmployeeY("B21DCCN004", "vewbvojZ", li);
    }
    
}
