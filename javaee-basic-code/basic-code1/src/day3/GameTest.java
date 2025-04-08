package day3;
//CTRL+p补全左边
//ctrl+f12查找类
//ctrl+shift+/多行注释
//ctrl+alt+t包裹语块
//ctrl+insert快速生成构造器
//ctrl+alt+l格式化代码
//ctrl+p查看参数

public class GameTest {
    public static void main(String[] args) {

        Role role1=new Role("战士",100);
        Role role2=new Role("法师",80);

        while(true){

            role1.playrole(role2,role2.getBlood());
            if(role2.getBlood()==0){
                System.out.println(role1.getRole()+"赢了");
                break;
            }
            role2.playrole(role1,role1.getBlood());
            if(role1.getBlood()==0){
                System.out.println(role2.getRole()+"赢了");
                break;
            }



        }



    }
}
