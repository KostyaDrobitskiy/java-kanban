package manager;

import task.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {
    @Test
    void historyShouldPreserveTaskState() {
        HistoryManager history = Managers.getDefaultHistory();
        Task task = new Task("Task", "Desc");
        task.setId(1);
        task.setStatus();

        history.add(task);
        task.setStatus(); // Меняем состояние после добавления
        task.setStatus();
        task.setStatus();
        Task fromHistory = history.getHistory().get(0);
        assertEquals(task.getStatus(), fromHistory.getStatus());
    }
}