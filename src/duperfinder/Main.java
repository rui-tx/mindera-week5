package duperfinder;

import util.Notification;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fruit> fruitList = new ArrayList<>();

        fruitList.add(new Apple(1));
        fruitList.add(new Apple(1));
        fruitList.add(new Apple(2));
        fruitList.add(new Orange(3));
        fruitList.add(new Orange(3));
        fruitList.add(new Orange(1));
        fruitList.add(new Orange(2));
        fruitList.add(new Orange(2));
        fruitList.add(new Apple(2));

        DuperFinder<Fruit> dupeFinder = new DuperFinder<>(fruitList);

        System.out.println("number of duplicates: " + dupeFinder.checkDupes());
        Notification.send("Number of duplicates fruits: ", dupeFinder.checkDupes() + "");

        //List<Fruit> dupes = dupeFinder.getDupes();
        List<Fruit> dupes = dupeFinder.sortedDupes();

        for (int i = 0; i < dupes.size(); i++) {
            System.out.println(dupes.get(i));
        }
    }
}
