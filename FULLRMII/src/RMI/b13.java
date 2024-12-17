
package RMI;
import java.rmi.RemoteException;
import java.util.*;
import java.rmi.registry.*;
public class b13 {

    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService)res.lookup("RMICharacterService");
        String input = sv.requestCharacter("B21DCCN126", "VBhtasjY");

        String[] arr = input.substring(1,input.length()-1).split(",");
        String output = "";
        for(int i = 0 ; i < arr.length;i+=2){
            String[]tmp = arr[i].split(":");
            output+=tmp[0].trim().substring(1, tmp[0].trim().length()-1);
            output+=": ";
            output+=tmp[1].trim().substring(1, tmp[1].trim().length()-1);
            output+=", ";
        }
        output = output.substring(0, output.length()-2)+"; ";
        for(int i = 1 ; i < arr.length;i+=2){
            String[]tmp = arr[i].split(":");
            output+=tmp[0].trim().substring(1, tmp[0].trim().length()-1);
            output+=": ";
            output+=tmp[1].trim().substring(1, tmp[1].trim().length()-1);
            output+=", ";
        } 
        output = output.substring(0, output.length()-2);
        
        sv.submitCharacter("B21DCCN126", "VBhtasjY", output);
        
    }
    
}
