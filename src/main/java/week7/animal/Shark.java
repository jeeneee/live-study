package week7.animal;

public class Shark extends Animal implements Swimmable {
    @Override
    public void eat() {
        System.out.println("shark-eat");
    }
    @Override
    public void swim() {
        System.out.println("shark-swim");
    }
    public void bite() {
        System.out.println("shark-bite");
    }
}
