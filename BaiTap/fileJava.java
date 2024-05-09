package BaiTap;

import java.io.File;
import java.util.Scanner;

public class fileJava {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập đường dẫn của tệp:");
        String filePath = scanner.nextLine();
        File file = new File(filePath);
        if (file.exists()) {
            if (file.isFile()) {
                long fileSize = file.length();
                String fileSizeStr = formatSize(fileSize);
                System.out.println("Kích thước của tệp '" + filePath + "' là " + fileSizeStr + ".");
            } else {
                System.out.println("Đường dẫn không phải là một tệp.");
            }
        } else {
            System.out.println("Đường dẫn không tồn tại.");
        }
        scanner.close();
    }

    public static String formatSize(long size) {
        String[] units = {"bytes", "KB", "MB", "GB", "TB"};
        int unitIndex = 0;
        while (size > 1024) {
            size /= 1024;
            unitIndex++;
        }
        return size + " " + units[unitIndex];
    }
}
