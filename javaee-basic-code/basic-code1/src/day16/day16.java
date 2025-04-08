package day16;

public class day16 {
        public static void main(String[] args) {
            String str = "www.example.com";

            // 使用 split("\\.") 来按点号分割字符串
            String[] parts = str.split("\\.");
            for (String part : parts) {
                System.out.println(part);
            }
            Thread t = new Thread();


        }
}
