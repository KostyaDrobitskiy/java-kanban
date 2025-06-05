import manager.HistoryManager;
import manager.InMemoryHistoryManager;
import manager.InMemoryTaskManager;
import manager.TaskManager;
import task.Epic;
import task.Subtask;
import task.Task;

public class Main {

    public static void main(String[] args) {
        HistoryManager historyManager = new InMemoryHistoryManager();
        TaskManager managers = new InMemoryTaskManager(historyManager);
        Task task1 = new Task("Переезд", "Собрать вещи");
        Task task2 = new Task("Отпуск", "Купить зонт");
        Epic epic1 = new Epic("выучить язык", "составить график");
        Subtask subtask1 = new Subtask("заниматься 2 раза", "или 3 ");
        Subtask subtask2 = new Subtask("или 4 раза ", "или пять");
        Epic epic2 = new Epic("поход в магазин", "составить список");
        Subtask subtask3 = new Subtask("купить курицо", "купить ананасы");
        managers.createTask(task1);
        managers.createTask(task2);
        managers.createEpic(epic1);
        managers.createSubtask(subtask1);
        managers.createSubtask(subtask2);
        managers.createEpic(epic2);
        managers.createSubtask(subtask3);

        epic1.addSubtask(subtask1);
        epic1.addSubtask(subtask2);

        epic2.addSubtask(subtask3);

        System.out.println(managers.listOfTask());
        System.out.println(managers.listOfEpic());
        System.out.println(managers.listOfSubtask());

        task1.setStatus();
        task2.setStatus();

        epic1.setStatus();
        epic1.setStatus();
        epic1.setStatus();
        System.out.println("***");
        System.out.println(managers.listOfEpic());

        subtask1.setStatus();
        //subtask2.setStatus();
        epic2.setStatus();
        subtask3.setStatus();
        System.out.println("***");
        System.out.println(managers.listOfEpic());

        subtask2.setStatus();
        subtask3.setStatus();
        System.out.println("***");
        System.out.println(managers.listOfEpic());

        subtask1.setStatus();
        System.out.println("***");
        System.out.println(managers.listOfEpic());

        subtask2.setStatus();
        System.out.println("***");
        System.out.println(managers.listOfEpic());
        System.out.println("***");


        managers.getTask(task1.getId());
        managers.getTask(task2.getId());
        managers.getEpic(epic1.getId());
        managers.getEpic(epic2.getId());
        managers.getSubtask(subtask1.getId());
        managers.getSubtask(subtask2.getId());
        managers.getSubtask(subtask3.getId());
        System.out.println(historyManager.getHistory());
    }
}