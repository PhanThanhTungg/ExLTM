
package fullws;

import java.util.*;
import vn.medianews.*;

public class B2 {
    public static int cnt(String x){
        int cnt = 0;
        String check = "ueoaiUEOAI";
        for(char y: x.toCharArray()){
            if(check.contains(y+"")) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String msv = "B21DCCN775", qcode = "GDevU95o";
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        List<String> input = port.requestStringArray(msv, qcode);
        
        Collections.sort(input, new Comparator<String>(){
            public int compare(String o1, String o2) {
                if(cnt(o1)!= cnt(o2)) return cnt(o1) - cnt(o2);
                else return o1.compareTo(o2);
            }
            
        });
        
        List<String>output = new ArrayList<>();
        String tmp = input.get(0);
        for(int i = 1; i <input.size();i++){
            if(cnt(input.get(i))== cnt(input.get(i-1))){
                tmp+=", "+input.get(i);
            }
            else{
                output.add(tmp);
                tmp = input.get(i);
            }
        }
        output.add(tmp);
        port.submitCharacterStringArray(msv, qcode, output);
        
    }
    
}
