package task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    void subtasksWithSameIdShouldBeEqual(){
        Task task1 = new Task("task1", "desxription");
        Task task2 = new Task("task2", "desxriptionsssss");
        task1.setId(1);
        task2.setId(1);
        assertEquals(task1, task2);
        assertEquals(task1.hashCode(), task2.hashCode());
    }
}
