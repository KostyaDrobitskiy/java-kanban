import task.Epic;
import task.Subtask;
import task.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EpicTest {
    @Test
    void tasksWithSameIdShouldBeEqual() {
        Task task1 = new Task("Task 1", "Description");
        Task task2 = new Task("Task 2", "Different description");
        task1.setId(1);
        task2.setId(1);

        assertEquals(task1, task2);
        assertEquals(task1.hashCode(), task2.hashCode());
    }
    @Test
    void subtaskCannotBeItsOwnEpic() {
        Subtask subtask = new Subtask("Subtask", "");
        subtask.setId(1);

        assertThrows(IllegalArgumentException.class, () -> {
            subtask.setEpic(new Epic("Fake", "") {{
                setId(1); // Подделываем ID эпика
            }});
        });
    }
}