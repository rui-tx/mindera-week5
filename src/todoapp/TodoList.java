package todoapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class TodoList {

    private String name;
    private PriorityQueue<TodoItem> list;

    public TodoList(String name) {
        this.name = name;
        this.list = new PriorityQueue<>();
    }

    public void addTask(TodoItem todo) {
        this.list.add(todo);
    }

    public void removeTask(TodoItem todo) {
        if(!this.list.contains(todo)) {
            return;
        }

        this.list.remove(todo);
    }

    public TodoItem getNext() {
        return this.list.peek();
    }

    public TodoItem[] getAllTasks() {
        return list.toArray(new TodoItem[0]);
    }

    public TodoItem[] getIncompleteTasks() {
        Iterator<TodoItem> iterator = this.list.iterator();
        ArrayList<TodoItem> uncompletedTasks = new ArrayList<>();

        while (iterator.hasNext()) {
            TodoItem currentItem = iterator.next();
            if (!currentItem.completed) {
                uncompletedTasks.add(currentItem);
            }
        }

        return uncompletedTasks.toArray(new TodoItem[0]);
    }

    public TodoItem[] getCompleteTasks() {
        Iterator<TodoItem> iterator = this.list.iterator();
        ArrayList<TodoItem> completedTasks = new ArrayList<>();

        while (iterator.hasNext()) {
            TodoItem currentItem = iterator.next();
            if (currentItem.completed) {
                completedTasks.add(currentItem);
            }
        }

        return completedTasks.toArray(new TodoItem[0]);
    }

    public void printAllTasks() {
        Iterator<TodoItem> iterator = this.list.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
            System.out.println();
        }
    }

    public void markTaskComplete(TodoItem todo) {
        if(!this.list.contains(todo)) {
            return;
        }

        Iterator<TodoItem> iterator = this.list.iterator();
        while (iterator.hasNext()) {
            TodoItem currentItem = iterator.next();
            if(currentItem.equals(todo)) {
                currentItem.completed = true;
                return;
            }
        }
    }

    public void markTaskIncomplete(TodoItem todo) {
        if(!this.list.contains(todo)) {
            return;
        }

        Iterator<TodoItem> iterator = this.list.iterator();
        while (iterator.hasNext()) {
            TodoItem currentItem = iterator.next();
            if(currentItem.equals(todo)) {
                currentItem.completed = false;
                return;
            }
        }
    }

    public static class TodoItem implements Comparable<TodoItem> {
        private String name;
        private String description;
        private boolean completed;
        private int priority;

        public TodoItem(String name, String description, boolean completed, int priority) {
            this.name = name;
            this.description = description;
            this.completed = completed;
            this.priority = priority;
        }

        public void print() {
            System.out.printf("Task: %s \n", this.name);
            System.out.printf("Description: %s \n", this.description);
            System.out.printf("Completed: %s \n", this.completed);
            System.out.printf("Priority: %d \n", this.priority);
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(TodoItem o) {
            return this.priority > o.priority ? -1 : this.priority == o.priority ? 0 : 1;
        }
    }
}
