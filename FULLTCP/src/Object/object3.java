package Object;

import TCP.Student;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class object3 {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        String code = "B21DCCN126;Q8ag2BW5";
        oos.writeObject(code);
        oos.flush();

        Student a = (Student) ois.readObject();
        System.out.println(a);

        float val = a.getGpa();
        a.setGpaLetter(val >= 3.7 ? "A" : (val >= 3 ? "B" : (val >= 2 ? "C" : (val >= 1 ? "D" : "F"))));

        System.out.println(a.getGpaLetter());
        oos.writeObject(a);
        oos.flush();

        socket.close();

    }

}
