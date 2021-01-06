package week7.animal;

public class Main {
    public static void main(String[] args) {
        Flyable flyable = new Eagle();
        Swimmable swimmable = new Shark();
        flyable.fly();              // eagle-fly
        swimmable.swim();           // shark-swim
    }
}
