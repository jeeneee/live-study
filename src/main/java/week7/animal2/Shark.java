package week7.animal2;

public class Shark implements Swimmable, Animal {

    @Override
    public void eat() {
        System.out.println("shark-eat");
    }

    public void bite() {
        System.out.println("shark-bite");
    }

}
