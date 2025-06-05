package manager;

import task.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {
    private static final Integer MAX_HISTORY_SIZE = 10;
    private final List<Task> history = new LinkedList<>();

    @Override
    public void add(Task task) {
        if (task == null) return;
        history.removeIf(t -> t.getId() == task.getId()); // Удаляем старую версию
        history.addFirst(task); // Добавляем в начало
        if (history.size() > MAX_HISTORY_SIZE) {
            history.removeLast();
        }
    }

    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }
}

