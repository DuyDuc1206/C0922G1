package ss7_abstract_and_interface.practice.animal_and_interface_edible;

public class Main {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        System.out.println(tiger.makeSound());
        Chicken chicken = new Chicken();
        System.out.println(chicken.makeSound());
        Orange orange =new Orange();
        System.out.println(orange.howToEat());
        Apple apple =new Apple();
        System.out.println(apple.howToEat());
    }
}
