package day3;

public class string {
    public static void main(String[] args) {
        //直接创建
        String str1="hello";//串池，只有一个hello
        //通过构造方法创建
        String str2=new String("hello");
        //通过字符数组创建
        char[] ch={'h','e','l','l','o'};
        String str3=new String(ch);
        //通过字节数组创建
        System.out.println(str1);

        boolean a=str1.equals(str2);
        boolean b=str1.equalsIgnoreCase(str2);
    }
}
