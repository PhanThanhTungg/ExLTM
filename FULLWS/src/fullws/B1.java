package fullws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import vn.medianews.*;
public class B1 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN775", qCode = "pUbYZZHn"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        int k = a.get(0); 
        a.remove(0);

        Collections.sort(a);
        
        List<Integer>ans = new ArrayList<>();
        ans.add(a.get(a.size()-k));
        ans.add(a.get(k-1));
        
        port.submitDataIntArray(msv, qCode, ans);
    }
}
