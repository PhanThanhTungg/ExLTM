package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class b17Object {
  public static void main(String[] args) throws Exception {
    Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
    ObjectService sv = (ObjectService) res.lookup("RMIObjectService");
    Order a = (Order) sv.requestObject("B21DCCN786", "ZQiq89Q7");

    String ans = a.getShippingType().substring(0,2).toUpperCase();
    int l = a.getCustomerCode().length();
    ans+=a.getCustomerCode().substring(l-3, l);
    String[] arr = a.getOrderDate().split("-");
    ans+=arr[2]+arr[1];
    
    a.setOrderCode(ans);
    sv.submitObject("B21DCCN786", "ZQiq89Q7", a);

  }
}
