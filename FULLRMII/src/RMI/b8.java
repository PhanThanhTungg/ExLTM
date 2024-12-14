
package RMI;
import java.rmi.*;
import java.rmi.registry.*;

public class b8 {
    public static String binaryEncoder(char x){
        int num = x;
        String ans = "";
        while(num > 0){
            ans = num%2+ans;
            num/=2;
        }
        return ans;
    }
    public static char binaryDecoder(String x){
        int ans = 0;
        for(int i = x.length()-1; i >=0; i--){
            ans+= Integer.parseInt(x.charAt(i)+"")* Math.pow(2,x.length()-1-i);
        }
        return (char)ans;
    }
    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService)res.lookup("RMICharacterService");
        String input = sv.requestCharacter("B21DCCN727", "anBwpIH1");
        System.out.println(input);
        
        String tmp = "";
        for(char x: input.toCharArray()){
            tmp += binaryEncoder(x);
        }
        System.out.println(tmp);
        
        while(tmp.length()%6!=0){
            tmp+="0";
        }
        
        String ans = "";
        for(int i = 0; i < tmp.length(); i+=6){
            ans+=binaryDecoder(tmp.substring(i,i+6)+"");
        }
        System.out.println(ans);
        sv.submitCharacter("B21DCCN727", "anBwpIH1", ans);
    }
    
}
