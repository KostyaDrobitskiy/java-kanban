package manager;
import task.Task;
import java.util.List;

public interface HistoryManager {
    void add(Task task);
    void remove(int id);
    List<Task> getHistory();
}
//There isn’t anything to compare.
//main and sprint_6-solution are identical.
// не могу понять как исправить
