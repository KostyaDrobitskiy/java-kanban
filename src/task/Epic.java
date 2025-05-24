package task;
import java.util.HashMap;
import java.util.Map;

public class Epic extends Task {
    private final Map<Integer, Subtask> subtasks = new HashMap<>();
    public Epic(String name, String description) {
        super(name, description);
    }
    public Map<Integer, Subtask> getSubtasks() {
        return subtasks;
    }
    public void addSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        subtask.setEpic(this);
    }
    @Override
    public void setStatus() {
        boolean allNew = false;
        boolean allInProgress = false;
        boolean allDone = false;
        if (subtasks.isEmpty()){
            return;
        }
        for (Subtask subtask : subtasks.values()) {
            if (subtask.getStatus() == Status.NEW) {
                allNew = true;
                continue;
            }
            if (subtask.getStatus() == Status.IN_PROGRESS) {
                allInProgress = true;
                continue;
            }
            if (subtask.getStatus() == Status.DONE) {
                allDone = true;
            }
        }
        if (allNew) {
            if (allInProgress || allDone) {
                fromNewToDone();
            }
        } else if (allInProgress) {
            fromNewToDone();
        } else {
            fromNewToDone();
            if (getStatus() == Status.IN_PROGRESS) {
                super.setStatus();
            }
        }
    }
    private void fromNewToDone() {
        if (getStatus() == Status.NEW) {
            super.setStatus();
        }
    }
    private String subtasksIds() {
        String s = "{ ";
        for(Subtask subtask : subtasks.values()) {
            s = s + subtask.getId() + " ";
        }
        s = s + "}";
        return s;
    }
    @Override
    public String toString() {
        return  "Epic{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", status=" + getStatus() +
                ", subtasks=" + subtasksIds() +
                '}';
    }
}
