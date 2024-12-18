
package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class b22Object {

    public static void main(String[] args) throws Exception {
        Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) res.lookup("RMIObjectService");
        Ticket a = (Ticket) sv.requestObject("B21DCCN764", "rX7E9caN");
        
        String eventName = a.getEventName();
        String code = (eventName.charAt(0)+"").toUpperCase()+
                (eventName.charAt(eventName.length()-1)+"").toUpperCase();
        String[] arr = a.getSaleDate().split("/");
        code+=arr[1]+arr[0];
        
        int min = 9, max = 0;
        for(int i = 0 ; i <=9; i++){
            if(i < min && !a.getSaleDate().contains(i+"")) min = i;
            if(i > max && !a.getSaleDate().contains(i+"")) max = i;
        }
        code+=max+""+min;
        a.setTicketCode(code);
        sv.submitObject("B21DCCN764", "rX7E9caN", a);
    }
    
}
