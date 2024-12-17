
package fullws;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.*;

public class B4 {

    public static int cnt(String x){
        int cnt = 0;
        String check = "ueoaiUEOAI";
        for(char y: x.toCharArray()){
            if(check.contains(y+"")) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String msv = "B21DCCN703", qcode = "dA4qEnap";
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        List<String> input = port.requestStringArray(msv, qcode);
        
        Collections.sort(input, new Comparator<String>(){
            public int compare(String o1, String o2) {
                if(cnt(o1)!= cnt(o2)) return cnt(o1) - cnt(o2);
                return 0;
            }
            
        });
        
        port.submitCharacterStringArray(msv, qcode, input);
        
    }
    
}
