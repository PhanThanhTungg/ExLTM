
package fullws;

import vn.medianews.*;
import java.util.*;

public class B13 {

    public static void main(String[] args) throws Exception {
        CharacterService_Service svv = new CharacterService_Service();
        CharacterService sv = svv.getCharacterServicePort();
        String input = sv.requestString("B21DCCN126", "Uldly3uq");
        System.out.println(input);
        
        String ans = "";
        for(char x: input.toCharArray()){
            if(Character.isAlphabetic(x)) ans = x+ ans;
        }
        sv.submitCharacterString("B21DCCN126", "Uldly3uq", ans);
    }
    
}
