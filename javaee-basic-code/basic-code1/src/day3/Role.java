package day3;

import java.util.Random;

public class Role
{
   private String role;
   private int blood;

   public Role(){}

   public Role(String role,int blood){
       this.role=role;
       this.blood=blood;
   }

   public void  setRole(String role){
       this.role=role;
   }
   public String getRole(){
       return role;
   }

   public void setBlood(int blood){
       this.blood=blood;
   }
   public int getBlood(){
       return blood;
   }

   //a击打了b a.playrole

    public void playrole(Role role,int blood){
        Random rand=new Random();
        int hurt=rand.nextInt(10)+1;
        blood-=hurt;
        blood=blood<0?blood=0:blood;
        role.setBlood(blood);
        System.out.println(this.role+"攻击了"+role.getRole()+hurt+"血");
    }





}
