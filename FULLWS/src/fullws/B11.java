package fullws;

import java.time.*;
import vn.medianews.*;

public class B11 {
    public static void main(String[] args) {
        ObjectService_Service svv = new ObjectService_Service();
        ObjectService sv = svv.getObjectServicePort();
        Employee a = (Employee) sv.requestEmployee("B21DCCN780", "9XYwfkgi");
        
        String stDay = a.getStartDate().toString().substring(0,10),
               eDay = a.getEndDate().toString().substring(0,10);
        
        LocalDate stDate = LocalDate.parse(stDay), eDate = LocalDate.parse(eDay);
        
        int cnt = 0;
        for(LocalDate i = stDate; !i.isAfter(eDate); i=i.plusDays(1)){
            if(i.getDayOfWeek()!= DayOfWeek.SATURDAY 
               && i.getDayOfWeek()!=DayOfWeek.SUNDAY) cnt++;
        }
        
        a.setWorkingDays(cnt);
        sv.submitEmployee("B21DCCN780", "9XYwfkgi", a);
    }
}
