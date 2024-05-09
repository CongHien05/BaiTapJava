package BaiTap;

import java.io.File;
import java.util.Scanner;

public class Bai2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập đường dẫn của thư mục hoặc tệp để xóa:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("Đường dẫn không tồn tại.");
            return;
        }

        System.out.print("Bạn có chắc chắn muốn xóa " + path + " không? (Y/N): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("Y")) {
            deleteFileOrDirectory(file);
            System.out.println("Xóa thành công.");
        } else {
            System.out.println("Không thực hiện xóa.");
        }

        scanner.close();
    }

    public static void deleteFileOrDirectory(File file) {
        if (file.isDirectory()) {
            // Xóa toàn bộ các tệp con trong thư mục trước
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    deleteFileOrDirectory(subFile);
                }
            }
        }
        file.delete(); // Xóa tệp hoặc thư mục
    }
}

