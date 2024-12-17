package fullws;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;
import java.util.*;
public class B7 {
    public static void main(String[] args) {
        DataService_Service svv = new DataService_Service();
        DataService sv = svv.getDataServicePort();
        List<Integer> li = sv.getData("B21DCCN727","cmyGn6f8");
        List<Integer> chan = new ArrayList<>(), le = new ArrayList<>(), 
                ans = new ArrayList<>();
        for(int x:li){
            if(x%2==0) chan.add(x);
            else le.add(x);
        }
        int posChan = 0, posLe = 0, check = 0;
        while(posChan < chan.size() && posLe < le.size()){
            if(check == 0){
                ans.add(chan.get(posChan));posChan+=1;check = 1;
            }
            else{
                ans.add(le.get(posLe));posLe+=1;check = 0;
            }
        }
        for(int i = posChan; i < chan.size();i++) ans.add(chan.get(i));
        for(int i = posLe; i < le.size();i++) ans.add(le.get(i));
        sv.submitDataIntArray("B21DCCN727","cmyGn6f8", ans);
    }
}
