
package fullws;

import vn.medianews.*;

public class B6 {

    public static void main(String[] args) {
        ObjectService_Service svv = new ObjectService_Service();
        ObjectService sv = svv.getObjectServicePort();
        ProductY a = sv.requestProductY("B21DCCN703", "WoBQK2cv");
        a.setFinalPrice(a.getPrice()*(1+a.getTaxRate()/100)*(1-a.getDiscount()/100));
        sv.submitProductY("B21DCCN703", "WoBQK2cv", a);
    }
    
}
