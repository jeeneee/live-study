package week7.animal2;

public interface Swimmable {

    default void swim() {
        System.out.println("swim");
    }
}
