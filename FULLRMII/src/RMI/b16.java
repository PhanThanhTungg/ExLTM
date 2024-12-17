
package RMI;
import java.util.*;
import java.rmi.registry.*;
public class b16 {

    public static void main(String[] args) throws Exception{
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) res.lookup("RMICharacterService");
        String input = sv.requestCharacter("B21DCCN786", "4LkEM5Uu");
        
        LinkedHashMap<Character, Integer> mp = new LinkedHashMap<>();
        for(char x: input.toCharArray()){
            if(!mp.containsKey(x)) mp.put(x, 1);
            else mp.put(x, mp.get(x)+1);
        }
        
        String output = "{";
        for(Map.Entry<Character, Integer> ets: mp.entrySet()){
            output+= String.format("\"%s\": %d, ",ets.getKey(), ets.getValue());
        }
        output = output.substring(0, output.length()-2)+"}";
        
        sv.submitCharacter("B21DCCN786", "4LkEM5Uu", output);
        
    }
    
}
