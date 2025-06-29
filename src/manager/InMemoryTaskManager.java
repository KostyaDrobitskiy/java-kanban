package manager;

import task.Epic;
import task.Subtask;
import task.Task;

import java.util.*;

public class InMemoryTaskManager implements TaskManager {
    private final Map<Integer, Task> tasks = new HashMap<>();
    private final Map<Integer, Epic> epics = new HashMap<>();
    private final Map<Integer, Subtask> subtasks = new HashMap<>();
    int nextId = 1;
    private final HistoryManager historyManager;

    public InMemoryTaskManager(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    private int addId() {
        return nextId++;
    }

    @Override
    public List<Task> getHistory() {
        return historyManager.getHistory();
    }

    //Task
    @Override
    public ArrayList<Task> listOfTask() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public void clearTask() {
        tasks.clear();
    }

    @Override
    public Task getTask(Integer id) {
        Task task = tasks.get(id);
        if (task != null) {
            historyManager.add(task);
        }
        return task;
    }

    @Override
    public void createTask(Task task) {
        if (!tasks.containsKey(task.getId())) {
            task.setId(addId());
            tasks.put(task.getId(), task);
        }
    }

    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public Task deleteTask(Integer id) {
        return tasks.remove(id);
    }

    //Epic
    @Override
    public ArrayList<Epic> listOfEpic() {
        return new ArrayList<>(epics.values());
    }

    @Override
    public void clearEpic() {
        epics.clear();
    }

    @Override
    public Epic getEpic(Integer id) {
        Epic epic = epics.get(id);
        if (epic != null) {
            historyManager.add(epic);
        }
        return epic;
    }

    @Override
    public void createEpic(Epic epic) {
        if (!epics.containsKey(epic.getId())) {
            epic.setId(addId());
            epics.put(epic.getId(), epic);
        }
    }

    @Override
    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    @Override
    public void deleteEpicById(Integer id) {
        epics.remove(id);
    }

    // Список задач определенного эпика
    @Override
    public ArrayList<Subtask> getSubtaskByEpic(Epic epic) {
        return new ArrayList<>(epic.getSubtasks().values());
    }

    //Subtask
    @Override
    public ArrayList<Subtask> listOfSubtask() {
        return new ArrayList<>(subtasks.values());
    }

    @Override
    public void clearSubtask() {
        subtasks.clear();
    }

    @Override
    public Subtask getSubtask(Integer id) {
        Subtask subtask = subtasks.get(id);
        if (subtask != null) {
            historyManager.add(subtask);
        }
        return subtask;
    }

    @Override
    public void createSubtask(Subtask subtask) {
        if (!subtasks.containsKey(subtask.getId())) {
            subtask.setId(addId());
            subtasks.put(subtask.getId(), subtask);
        }
    }

    @Override
    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
    }

    @Override
    public void deleteSubtaskById(Integer id) {
        subtasks.remove(id);
    }
}