
package fullws;
import java.util.*;
import vn.medianews.*;
public class B20 {

    public static void main(String[] args) throws Exception {
        ObjectService_Service svv = new ObjectService_Service();
        ObjectService sv = svv.getObjectServicePort();
        List<StudentY> li = sv.requestListStudentY("B21DCCN739", "zxVhXff6");
        Map<String, Float> mp = new HashMap<>();
        for(StudentY x: li){
            if(!mp.containsKey(x.getSubject()) || x.getScore()>mp.get(x.getSubject())) 
                mp.put(x.getSubject(), x.getScore());
            
        }
        for(int i = 0; i < li.size();i++){
            if(li.get(i).getScore()==mp.get(li.get(i).getSubject())) continue;
            else{
                li.remove(i);
                i--;
            }
        }
        sv.submitListStudentY("B21DCCN739", "zxVhXff6", li);
    }
    
}
