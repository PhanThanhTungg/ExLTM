package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class b7 {
  public static void main(String[] args) throws Exception {
    Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
    CharacterService sv = (CharacterService) res.lookup("RMICharacterService");
    String input = sv.requestCharacter("B21DCCN703", "60yI0upT");

    String[]inputArr = input.split(";");
    Character key = inputArr[0].charAt(0);
    String output = inputArr[1];
    for(int i = 0 ; i < output.length(); i++){
      output = output.substring(0, i)+ (char)(output.charAt(i)^key)+output.substring(i+1);
    }
  
    sv.submitCharacter("B21DCCN703", "60yI0upT", output);
  }
}
