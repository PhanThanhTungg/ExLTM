package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class b4Object {
  public static void main(String[] args) throws Exception {
    Registry res = LocateRegistry.getRegistry("203.162.10.109", 1099);
    ObjectService sv = (ObjectService) res.lookup("RMIObjectService");
    ProductX a = (ProductX) sv.requestObject("B21DCCN703", "ctOkbTcA");
    
    int discount = 0;
    for(char x: a.getDiscountCode().toCharArray()){
      if(Character.isDigit(x)) discount+=Integer.parseInt(x+"");
    }
    a.setDiscount(discount);

    sv.submitObject("B21DCCN775", "IJhTAcnU", a);
  }
}
