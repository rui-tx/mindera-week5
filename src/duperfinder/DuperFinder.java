package duperfinder;

import java.util.*;

public class DuperFinder<T extends Comparable<T>> {

    private List<T> list;

    public DuperFinder(List<T> list) {
        this.list = list;
    }

    public int checkDupes(){
        Set<T> temp = new HashSet<>();
        Iterator<T> iterator = this.list.iterator();

        while(iterator.hasNext()) {
            temp.add(iterator.next());
        }

        return this.list.size() - temp.size();
    }

    public List<T> getDupes() {
        Iterator<T> iterator = this.list.iterator();

        List<T> dupedList = new ArrayList<>();
        Set<T> temp = new HashSet<>();

        while(iterator.hasNext()) {
            T currentItem = iterator.next();
            if (!temp.add(currentItem)) {
                dupedList.add(currentItem);
            }
        }

        return dupedList;
    }

    public List<T> sortedDupes() {
        List<T> dupedList = this.getDupes();

        dupedList.sort(Comparator.reverseOrder());
        return dupedList;
    }
}
