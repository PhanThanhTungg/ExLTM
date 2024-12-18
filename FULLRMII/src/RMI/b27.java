
package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class b27 {

    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) res.lookup("RMIDataService");
        String input = (String)sv.requestData("B21DCCN003", "QZ8jT0DC");
        System.out.println(input);
        
        List<Float> li = new ArrayList<>();
        float sum = 0;
        for(String x: input.split(",")){
            float val = Float.parseFloat(x.trim());
            sum+=val;
            li.add(val);
        }
        float avg = sum/li.size();
        float ps = 0f;
        for(float x: li){
            ps += Math.pow(x-avg, 2);
        }
        ps/=li.size();
        sv.submitData("B21DCCN003", "QZ8jT0DC", 
                String.format("%.2f : %.2f", ps,Math.sqrt(ps)));
    }
    
}
