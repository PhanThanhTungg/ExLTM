
package basicObject;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class server {

    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(1000); // Lắng nghe trên cổng 1000
            byte[] receiveData = new byte[1024];

            System.out.println("Server is running...");

            while (true) {
                // Nhận gói tin từ client
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Chuyển đổi byte thành đối tượng
                ByteArrayInputStream byteStream = new ByteArrayInputStream(receivePacket.getData());
                ObjectInputStream objStream = new ObjectInputStream(byteStream);
                Person person = (Person) objStream.readObject();

                // Hiển thị đối tượng nhận được
                System.out.println("Received object from client: " + person.getName());

                // Nếu nhận được đối tượng có tên là "exit", thì thoát
                if (person.getName().equalsIgnoreCase("exit")) {
                    System.out.println("Client has exited.");
                    break;
                }
            }

            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
