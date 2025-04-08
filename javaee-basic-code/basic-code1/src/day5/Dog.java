package day5;

public class Dog extends Animal {

    public Dog() {
    }

    public Dog(int age, String color) {
        super(age,color);
    }

    public void lookHome(){
        System.out.println("Dog is looking home");
    }

    @Override
    public void eat(String something) {
        System.out.println("Dog is eating"+something);
    }

}
