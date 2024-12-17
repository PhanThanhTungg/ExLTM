
package RMI;
import java.util.*;
import java.rmi.registry.*;
public class b14 {

    public static void main(String[] args) throws Exception{
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) res.lookup("RMIObjectService");
        Product a = (Product) sv.requestObject("B21DCCN126", "nw1cuSC7");
        
        a.setCode(a.getCode().toUpperCase());
        a.setExportPrice(a.getImportPrice()*1.2f);
        
        sv.submitObject("B21DCCN126", "nw1cuSC7", a);
    }
    
}
