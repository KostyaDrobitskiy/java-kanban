package task;

public class Subtask extends Task {
    private Epic epic;  // эпик, в который входит данная подзадача
    public Subtask(String name, String description) {
        super(name, description);
    }
    public Epic getEpic() {
        return epic;
    }
    public void setEpic(Epic epic) {
        this.epic = epic;
    }
    @Override
    public void setStatus() {
        super.setStatus();
        if (epic != null) {
            epic.setStatus();
        }
    }
    @Override
    public String toString() {
        return  "Subtask{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", status=" + getStatus() +
                ", epic " + epic.getId() +
                '}';
    }
}
