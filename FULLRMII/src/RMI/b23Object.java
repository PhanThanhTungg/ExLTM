
package RMI;
import java.util.*;
import java.rmi.registry.*;
public class b23Object {

    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) res.lookup("RMIObjectService");
        BookX a = (BookX)sv.requestObject("B21DCCN118", "3suBGOxg");
        
        String name = a.getAuthor();
        String code = (name.charAt(0)+"")+
                (name.charAt(name.length()-1)+"");
        System.out.println(a.getYearPulished());
        code+=(a.getYearPulished()+"").substring(2,4);
        code+=a.getGenre().length();
        code+=a.getTitle().length()%10;
        
        a.setCode(code);
        
        sv.submitObject("B21DCCN118", "3suBGOxg", a);
    }
    
}
