
package RMI;
import java.util.*;
import java.rmi.registry.*;
public class b19Object {

    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) res.lookup("RMIObjectService");
        Book a = (Book)sv.requestObject("B21DCCN803", "MMlznxqy");
        
        String code = "";
        String []arr = a.getAuthor().split("\\s+");
        code+=arr[0].substring(0,1).toUpperCase();
        code+=arr[arr.length-1].substring(0,1).toUpperCase();
        code+=(a.getYearPublished()+"").substring(2, 4);
        code+=a.getTitle().length();
        String pageCount = a.getPageCount()+"";
        while(pageCount.length()<3){
            pageCount = '0'+pageCount;
        }
        code+=pageCount;
        a.setCode(code);
        sv.submitObject("B21DCCN803", "MMlznxqy", a);
        
    }
    
}
