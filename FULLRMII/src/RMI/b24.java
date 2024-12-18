
package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class b24 {
    public static int num(char x){
        return x=='I'?1:(x=='V'?5:(x=='X'?10:(
                    x=='L'?50:(x=='C'?100:(x=='D'?500:1000)))));
    }
    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) res.lookup("RMICharacterService");
        String input = sv.requestCharacter("B21DCCN709", "zRSOv3hO");
        
        char[]arr = input.toCharArray();
        int sum = 0;
        for(int i = arr.length-1; i >=0; i--){
            char x = arr[i];
            if(i==arr.length-1){
                sum+=num(x); continue;
            }
            if(num(x) >= num(arr[i+1])) sum+= num(x);
            else sum-= num(x);
        }
        sv.submitCharacter("B21DCCN709", "zRSOv3hO", sum+"");
        
    }
    
}
