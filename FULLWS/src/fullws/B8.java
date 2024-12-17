package fullws;

import vn.medianews.*;
import java.util.*;

public class B8 {
    public static void main(String[] args) {
        ObjectService_Service svv = new ObjectService_Service();
        ObjectService sv = svv.getObjectServicePort();
        List<Student> li = sv.requestListStudent("B21DCCN727", "HC6Zdynz");
        
        for(int i = 0; i < li.size();i++){
            float score = li.get(i).getScore();
            if(score < 8 && score >=5){
                li.remove(i);
                i--;
            }
        }
        sv.submitListStudent("B21DCCN727", "HC6Zdynz", li);
    } 
}
