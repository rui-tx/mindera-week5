package todoapp;

public class Main {
    public static void main(String[] args) {

        TodoList list = new TodoList("test");

        TodoList.TodoItem todo1 = new TodoList.TodoItem(
                "walk the dog",
                "",
                false,
                10);

        TodoList.TodoItem todo2 = new TodoList.TodoItem(
                "buy groceris",
                "",
                false,
                200);

        TodoList.TodoItem todo3 = new TodoList.TodoItem(
                "take out the trash",
                "",
                false,
                20);

        list.addTask(todo1);
        list.addTask(todo2);
        list.addTask(todo3);
        list.addTask(todo3);
        list.removeTask(todo3);

        list.markTaskComplete(todo1);
        list.markTaskComplete(todo3);
        list.markTaskIncomplete(todo3);

        System.out.println("tasks");
        list.printAllTasks();

        System.out.printf("next highest todo\n");
        list.getNext().print();

        System.out.println("incompleted tasks");
        for (int i = 0; i < list.getIncompleteTasks().length; i++) {
            list.getIncompleteTasks()[i].print();
            System.out.println();
        }

        System.out.println("completed tasks");
        for (int i = 0; i < list.getCompleteTasks().length; i++) {
            list.getCompleteTasks()[i].print();
            System.out.println();
        }

    }
}