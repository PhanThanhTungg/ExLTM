import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class UploadImageApp {
    private static Cloudinary cloudinary;

    public static void main(String[] args) {
        // Cấu hình Cloudinary
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "ddr3axv38",
                "api_key", "147594271812811",
                "api_secret", "KlZCzS0-PsCdv2TdvJf6Zu-pk-I"));

        // Tạo giao diện Swing
        JFrame frame = new JFrame("Tải ảnh lên Cloudinary");
        JButton uploadButton = new JButton("Chọn và tải ảnh lên");

        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        // Tải ảnh lên Cloudinary
                        Map uploadResult = cloudinary.uploader().upload(selectedFile, ObjectUtils.emptyMap());
                        String imageUrl = (String) uploadResult.get("url");

                        JOptionPane.showMessageDialog(frame, "Tải ảnh thành công!\nURL: " + imageUrl);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Tải ảnh thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        frame.add(uploadButton);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
