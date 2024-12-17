
package fullws;

import vn.medianews.*;
import java.util.*;

public class B12 {

    public static void main(String[] args) throws Exception {
        DataService_Service svv = new DataService_Service();
        DataService sv = svv.getDataServicePort();

        int val = (int)sv.getDataDouble("B21DCCN126", "VNCl8aIf");
        
        List<Integer> output = new ArrayList<>();
        int cnt = 0;
        for(int i = 1; i < (int)Math.sqrt(val);i++){
            if(val%i==0){
                cnt+=2;
                output.add(i);
                output.add(val/i);
            }
        }
        if(Math.pow((int)Math.sqrt(val), 2)==val){
            cnt+=1;
            output.add((int)Math.sqrt(val));
        }
        Collections.sort(output);
        output.add(0, cnt);
        
        sv.submitDataIntArray("B21DCCN126", "VNCl8aIf", output);
        
        
    }
    
}
