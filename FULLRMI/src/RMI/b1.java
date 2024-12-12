package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class b1 {
  public static void main(String[] args) throws Exception {
    Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
    CharacterService sv = (CharacterService) res.lookup("RMICharacterService");
    String input = (String) sv.requestCharacter("B21DCCN775", "9ucjuiIh");

    int n = input.length()%7;

    for(int i = 0; i < input.length(); i++){
      char x = input.charAt(i);
      char ini = Character.isLowerCase(x)?'z':'Z';
      x = (char)(ini-(ini-x+n)%26);
      input = input.substring(0, i)+x+input.substring(i+1);
    }

    sv.submitCharacter("B21DCCN775", "9ucjuiIh", input);
  }
}
