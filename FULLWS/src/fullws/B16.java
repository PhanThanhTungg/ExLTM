
package fullws;
import java.util.*;
import vn.medianews.*;
public class B16 {

    public static void main(String[] args) {
        CharacterService_Service svv = new CharacterService_Service();
        CharacterService sv = svv.getCharacterServicePort();
        String input = sv.requestString("B21DCCN786", "iDK1ztEm");
        
        input = input.replace("_", " ");
        String[]arr = input.split("\\s+");
        String pascal="", camel = "", snake = "";
        int check = 0;
        for(String x: arr){
            pascal+=x.substring(0,1).toUpperCase()+x.substring(1).toLowerCase();
            
            if(check == 0){
                camel+=x.toLowerCase();
                check = 1;
            }
            else camel+=x.substring(0,1).toUpperCase()+x.substring(1).toLowerCase();
            
            snake+=x.toLowerCase()+"_";
        }
        List<String> output = new ArrayList<>();
        output.add(pascal); output.add(camel); output.add(snake.substring(0, snake.length()-1));
        sv.submitCharacterStringArray("B21DCCN786", "iDK1ztEm", output);
    }
    
}
