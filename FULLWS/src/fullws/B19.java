
package fullws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

public class B19 {

    public static void main(String[] args) {
        CharacterService_Service svv = new CharacterService_Service();
        CharacterService sv = svv.getCharacterServicePort();
        
        List<Integer> li = sv.requestCharacter("B21DCCN803", "JRqTFuRj");

        int n = li.get(0)%li.size();
        Collections.rotate(li, li.get(n));
//        while(n-->0){
//            int tmp = li.get(li.size()-1);
//            for(int i = li.size()-1 ; i >= 1;i--){
//                li.set(i, li.get(i-1));
//            }
//            li.set(0, tmp);
//        }
        sv.submitCharacterCharArray("B21DCCN803", "JRqTFuRj", li);
    }
}