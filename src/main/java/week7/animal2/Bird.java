package week7.animal2;

public interface Bird extends Flyable, Animal {

    int LEGS = 2;

    default void peck() {
        System.out.println("bird-peck");
    }

    default void info() {
        System.out.println("bird has " + getLegs() + "legs");
    }

    private int getLegs() {
        return LEGS;
    }
}
