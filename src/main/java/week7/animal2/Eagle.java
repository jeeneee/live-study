package week7.animal2;

public class Eagle implements Bird {

    @Override
    public void eat() {
        System.out.println("eagle-eat");
    }

    @Override
    public void fly() {
        System.out.println("eagle-fly");
    }

    @Override
    public void peck() {
        System.out.println("eagle-peck");
    }
}
