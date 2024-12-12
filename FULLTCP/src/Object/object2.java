package Object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import TCP.Laptop;

public class object2 {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Socket socket = new Socket("203.162.10.109", 2209);
    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

    String code = "B21DCCN703;TMPKKs6G";
    oos.writeObject(code);
    oos.flush();

    Laptop a = (Laptop) ois.readObject();

    String[]nameArr = a.getName().split("\\s+");
    String tmp = nameArr[0];
    nameArr[0] = nameArr[nameArr.length-1];
    nameArr[nameArr.length-1] = tmp;
    String newName = "";
    for(int i = 0 ; i < nameArr.length; i++) newName+=nameArr[i]+" ";
    a.setName(newName.trim());

    StringBuilder sb = new StringBuilder(a.getQuantity()+"");
    a.setQuantity(Integer.parseInt(sb.reverse()+""));

    oos.writeObject(a);
    oos.flush();

    socket.close();
  }
}
