package duperfinder;

import java.util.Objects;

public abstract class Fruit implements Comparable<Fruit> {
    private String name;
    private int acidicLevel;

    public Fruit(String name, int acidLevel) {
        this.name = name;
        this.acidicLevel = acidLevel;
    }

    public String getName() {
        return name;
    }

    public int getAcidicLevel() {
        return acidicLevel;
    }

    @Override
    public String toString() {
        return this.name + " has acidic value of -> " + this.acidicLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return acidicLevel == fruit.acidicLevel && Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, acidicLevel);
    }

    @Override
    public int compareTo(Fruit o) {
        return this.acidicLevel - o.acidicLevel;
        /*
        if (this.acidicLevel > o.acidicLevel)
            return -1;
        if (this.acidicLevel < o.acidicLevel)
            return 1;

        return 0;

         */
    }
}
