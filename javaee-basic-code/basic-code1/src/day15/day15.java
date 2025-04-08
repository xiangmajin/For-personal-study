package day15;

import java.io.File;

public class day15 {
    public static void main(String[] args) {
        File file = new File("D:\\\\桌面\\\\新建文件夹 (2)");

        deleteFile(file);

    }

    public static void deleteFile(File fileName) {
        File[] files = fileName.listFiles();
        for (File fileName1 : files) {
            if (fileName1.exists()) {
                if (fileName1.isFile()) {
                    fileName1.delete();
                } else {
                    deleteFile(fileName1);
                }
            }
        }
        fileName.delete();
    }
}
