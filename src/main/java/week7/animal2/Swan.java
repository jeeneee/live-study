package week7.animal2;

public class Swan implements Bird, Swimmable {

    @Override
    public void eat() {
        System.out.println("swan-eat");
    }

    @Override
    public void fly() {
        System.out.println("swan-fly");
    }

    @Override
    public void peck() {
        System.out.println("swan-peck");
    }
}
