package week7.animal;

public class Swan extends Animal implements Flyable, Swimmable{
    @Override
    public void eat() {
        System.out.println("swan-eat");
    }

    @Override
    public void fly() {
        System.out.println("swan-fly");
    }

    @Override
    public void swim() {
        System.out.println("swan-swim");
    }
}
