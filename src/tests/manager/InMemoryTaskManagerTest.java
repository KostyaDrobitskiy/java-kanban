package manager;

import org.junit.jupiter.api.Test;
import task.Epic;
import task.Status;
import task.Subtask;
import task.Task;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {
    @Test
    void canAddAndFindDifferentTasks() {
        TaskManager manager = Managers.getDefault();

        Task task = new Task("TaskName", "desc");
        manager.createTask(task);

        Epic epic = new Epic("EpicName", "desc");
        manager.createEpic(epic);

        Subtask sub = new Subtask("SubName", "desc");
        manager.createSubtask(sub);

        int taskId = task.getId();
        int epicId = epic.getId();
        int subId = sub.getId();

        Task fetchedTask = manager.getTask(taskId);
        Epic fetchedEpic = manager.getEpic(epicId);
        Subtask fetchedSub = manager.getSubtask(subId);

        assertEquals(task, fetchedTask);
        assertEquals(epic, fetchedEpic);
        assertEquals(sub, fetchedSub);
    }
    @Test
    void generatedIdsAreUnique() {
        InMemoryTaskManager manager = new InMemoryTaskManager(new InMemoryHistoryManager());

        Task t1 = new Task("T1", "desc");
        manager.createTask(t1);
        int id1 = t1.getId();

        Task t2 = new Task("T2", "desc");
        manager.createTask(t2);
        int id2 = t2.getId();

        assertNotEquals(id1, id2);
        assertTrue(id2 > id1);
    }
    @Test
    void taskShouldNotChangeWhenAddedToManager() {
        TaskManager manager = Managers.getDefault();
        Task original = new Task("Original", "Desc");
        original.setStatus();

        manager.createTask(original);
        Task retrieved = manager.getTask(original.getId());

        assertEquals(original.getName(), retrieved.getName());
        assertEquals(original.getDescription(), retrieved.getDescription());
        assertEquals(original.getStatus(), retrieved.getStatus());
    }
}