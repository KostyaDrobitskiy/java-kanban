package task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {
    @Test
    void subtasksWithSameIdShouldBeEqual(){
        Subtask subtask1 = new Subtask("sub1", "desxription");
        Subtask subtask2 = new Subtask("sub2", "desxriptionsssss");
        subtask1.setId(1);
        subtask2.setId(1);
        assertEquals(subtask1, subtask2);
        assertEquals(subtask1.hashCode(), subtask2.hashCode());
    }
    @Test
    void epicCannotBeSubtaskOfItself() {
        Epic epic = new Epic("Epic", "");
        epic.setId(1);

        assertThrows(IllegalArgumentException.class, () -> {
            epic.addSubtask(new Subtask("Fake", "") {{
                setId(1); // Подделываем ID чтобы совпадал с эпиком
            }});
        });
    }
}