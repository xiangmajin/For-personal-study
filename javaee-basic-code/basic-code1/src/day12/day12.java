package day12;

import java.util.HashMap;
import java.util.Map;

public class day12 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan",13);
        Student student2 = new Student("lis",14);
        Student student3 = new Student("wangwu",15);
        Student student4 = new Student("wangwu",15);
        Map<Student,String> map=new HashMap<>();
        map.put(student1,"anhui");
        map.put(student2,"beijing");
        map.put(student3,"henan");
        map.put(student4,"xian");
        /*Set<Map.Entry<Student,String>> entries = map.entrySet();
        for(Map.Entry<Student,String> entry:entries){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }*/
        map.forEach((k,v)->{System.out.println(k+":"+v);});

    }
}
