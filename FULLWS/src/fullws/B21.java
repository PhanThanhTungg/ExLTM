
package fullws;

import java.math.BigInteger;
import java.util.*;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class B21 {

    public static void main(String[] args) {
        DataService_Service svv = new DataService_Service();
        DataService sv = svv.getDataServicePort();
        double input = sv.getDataDouble("B21DCCN716", "pGnz4Sgo");
        
        int cntPhanTp = (input+"").split("\\.")[1].length();
        int mau = (int)Math.pow(10, cntPhanTp);
        int tu = (int)(input*mau);
        int gcd = Integer.parseInt(new BigInteger(tu+"").gcd(new BigInteger(mau+"")).toString());
        
        List<Integer> output = new ArrayList<>();
        output.add(tu/gcd);
        output.add(mau/gcd);
        
        sv.submitDataIntArray("B21DCCN716", "pGnz4Sgo", output);
    }
    
}
