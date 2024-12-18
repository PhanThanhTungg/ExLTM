package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class b29 {

    public static char solve(char x, int s) {
        char ini = Character.isUpperCase(x) ? 'A' : 'a';
        return (char) (ini + (x - ini + s) % 26);
    }

    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) res.lookup("RMICharacterService");
        String input = sv.requestCharacter("B21DCCN004", "5qhZKgac");
        String[] inputArr = input.split(";");
        String key = inputArr[0], keyV = inputArr[1];

        String ans = "";
        for (int i = 0; i < keyV.length(); i++) {
            char x = keyV.charAt(i);
            int s = key.charAt(i % key.length()) - 'a';
            ans += solve(x, s);
        }
        sv.submitCharacter("B21DCCN004", "5qhZKgac", ans);
    }

}
