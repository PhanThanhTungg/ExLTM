
package Object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import TCP.Customer;

public class object1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        
        oos.writeObject("B21DCCN775;5HBJkHd9");
        oos.flush();
        
        Customer cus = (Customer) ois.readObject();
        System.out.println(cus.getName());
        System.out.println(cus.getDayOfBirth());
        System.out.println(cus.getCode());
        
        String []nameArr = cus.getName().split("\\s+");
        String newName = nameArr[nameArr.length -1].toUpperCase()+",";
        String newUserName = "";
        
        for(int i = 0; i < nameArr.length-1;i++){
            newName +=" "+nameArr[i].substring(0,1).toUpperCase()+
                    nameArr[i].substring(1).toLowerCase();
            newUserName += nameArr[i].substring(0,1).toLowerCase();
        }
        newUserName += nameArr[nameArr.length -1].toLowerCase();
            
        String[]birth = cus.getDayOfBirth().split("-");
        String newBirth = birth[1]+"/"+birth[0]+"/"+birth[2];
        
        cus.setName(newName);
        cus.setDayOfBirth(newBirth);
        cus.setUserName(newUserName);
        
        oos.writeObject(cus);
        oos.flush();

        socket.close();
    }
    
}
