package basicObject;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 1000;

            Scanner sc = new Scanner(System.in);

            while (true) {
                // Nhập thông tin đối tượng từ người dùng
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter age: ");
                int age = sc.nextInt();
                sc.nextLine(); // Đọc bỏ dòng trống

                // Tạo đối tượng Person
                Person person = new Person(name, age);

                // Tuần tự hóa đối tượng thành mảng byte
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                ObjectOutputStream objStream = new ObjectOutputStream(byteStream);
                objStream.writeObject(person);
                byte[] sendData = byteStream.toByteArray();

                // Đóng gói dữ liệu và gửi đến server
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                clientSocket.send(sendPacket);

                // Nếu người dùng nhập tên là "exit", thoát chương trình
                if (name.equalsIgnoreCase("exit")) {
                    System.out.println("Client is exiting...");
                    break;
                }
            }
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
