
package fullws;

import java.util.Collections;
import java.util.List;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

public class B22 {

    public static void main(String[] args) {
        CharacterService_Service svv = new CharacterService_Service();
        CharacterService sv = svv.getCharacterServicePort();
        
        String input = sv.requestString("B21DCCN716", "Mu6wg4tw");
        String max = "";
        String min = input.split("\\s+")[0];
        for(String x: input.split("\\s+")){
            if(x.length() > max.length()) max = x;
            if(x.length() < min.length()) min = x;
        }
        
        String res = max+"; "+min;
        sv.submitCharacterString("B21DCCN716", "Mu6wg4tw", res);
        
    }
    
}
