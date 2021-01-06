package week7.animal;

public class Eagle extends Animal implements Flyable {
    @Override
    public void eat() {
        System.out.println("eagle-eat");
    }
    @Override
    public void fly() {
        System.out.println("eagle-fly");
    }
    public void peck() {
        System.out.println("eagle-peck");
    }
}
