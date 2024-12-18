
package RMI;
import java.rmi.registry.*;
import java.util.Base64;

public class b8 {
    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService)res.lookup("RMICharacterService");
        String input = sv.requestCharacter("B21DCCN727", "anBwpIH1");
        sv.submitCharacter("B21DCCN727", "anBwpIH1", Base64.getEncoder().encodeToString(input.getBytes()));
        //Mã hóa 1 mảng byte thành dạng base64 
        //Encode: Base64.getEncoder().encodeToString(data) **data là 1 mảng byte
        
        //Giải mã 1 mảng base64 thành mảng byte ban đầu
        //Decode: Base64.getDecoder().decode(base64Str);
    }
    
}
