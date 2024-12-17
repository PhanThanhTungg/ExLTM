
package fullws;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.*;

public class B9 {

    public static void main(String[] args) {
        CharacterService_Service svv = new CharacterService_Service();
        CharacterService sv = svv.getCharacterServicePort();
        List<String> li = sv.requestStringArray("B21DCCN780", "8KwPxbCk");
        Collections.sort(li, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
            
        });
        sv.submitCharacterStringArray("B21DCCN780", "8KwPxbCk", li);
    }
    
}
