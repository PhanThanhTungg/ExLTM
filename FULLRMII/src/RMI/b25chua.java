
package RMI;
import java.net.URLEncoder;
import java.util.*;
import java.rmi.registry.*;
public class b25chua {

    public static void main(String[] args) throws Exception{
//        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
//        CharacterService sv = (CharacterService) res.lookup("RMICharacterService");
//        String input = sv.requestCharacter("B21DCCN001", "AhrzRLmM");
//        String output = URLEncoder.encode(input, "UTF-8").replaceAll("\\+", "%20");
//        sv.submitCharacter("B21DCCN001", "AhrzRLmM", output);
          for(byte x: Base64.getDecoder().decode("SGVsbG8gV29ybGQ=")){
              System.out.println(x);
          }
    }
    
}
