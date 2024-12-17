
package fullws;
import java.util.*;
import vn.medianews.*;
public class B15 {

    public static void main(String[] args) {
        DataService_Service svv = new DataService_Service();
        DataService sv = svv.getDataServicePort();
        List<Integer> li = sv.getData("B21DCCN786", "dM0OwUta");
        LinkedHashSet<Integer> st = new LinkedHashSet<>(li);
        List<Integer> output = new ArrayList<>(st);
        sv.submitDataIntArray("B21DCCN786", "dM0OwUta", output);
    }
    
}
