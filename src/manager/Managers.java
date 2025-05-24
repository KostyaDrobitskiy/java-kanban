package manager;
import task.Epic;
import task.Subtask;
import task.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Managers {
    private final Map<Integer, Task> tasks = new HashMap<>();
    private final Map<Integer, Epic> epics = new HashMap<>();
    private final Map<Integer, Subtask> subtasks = new HashMap<>();
    //Task
    public ArrayList<Task> listOfTask() {
        return new ArrayList<>(tasks.values());
    }
    public void clearTask() {
        tasks.clear();
    }
    public Task getTaskById(Integer id) {
        return tasks.get(id);

    }
    public void createTask(Task task) {
        if (!tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
        }
    }
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }
    public Task deleteTaskById(Integer id) {
        return tasks.remove(id);
    }
    //Epic
    public ArrayList<Epic> listOfEpic() {
        return new ArrayList<>(epics.values());
    }
    public void clearEpic() {
        epics.clear();
    }
    public Epic getEpicById(Integer id) {
        return epics.get(id);
    }
    public void createEpic(Epic epic) {
        if (!epics.containsKey(epic.getId())) {
            epics.put(epic.getId(), epic);
        }
    }
    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }
    public void deleteEpicById(Integer id) {
        epics.remove(id);
    }
    // Список задач определенного эпика
    public ArrayList<Subtask> getSubtaskByEpic(Epic epic) {
        return new ArrayList<>(epic.getSubtasks().values());
    }
    //Subtask
    public ArrayList<Subtask> listOfSubtask() {
        return new ArrayList<>(subtasks.values());
    }
    public void clearSubtask() {
        subtasks.clear();
    }
    public Subtask getSubtaskById(Integer id) {
        return subtasks.get(id);
    }
    public void createSubtask(Subtask subtask) {
        if (!subtasks.containsKey(subtask.getId())) {
            subtasks.put(subtask.getId(), subtask);
        }
    }
    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
    }
    public void deleteSubtaskById(Integer id) {
        subtasks.remove(id);
    }
}
