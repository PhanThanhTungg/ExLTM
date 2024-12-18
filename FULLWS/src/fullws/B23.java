
package fullws;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class B23 {
    public static void main(String[] args) {
        DataService_Service svv = new DataService_Service();
        DataService sv = svv.getDataServicePort();
        List<Integer> li = sv.getData("B21DCCN118", "KqRExHj3");
        List<String> res = new ArrayList<>();
        for(int x: li){
            res.add(Integer.toOctalString(x)+"|"+Integer.toHexString(x).toUpperCase());
        }
        
        sv.submitDataStringArray("B21DCCN118", "KqRExHj3", res);
    }
    
}
