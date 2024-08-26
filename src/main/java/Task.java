/**
 * represents an abstract task with a description and completion status.
 * a Task can be marked as done or undone and has a specific TaskType.
 */
public abstract class Task {
    private String description;
    private boolean isDone;
    protected TaskType type;

    /**
     * constructs a Task with the specified description and type.
     *
     * @param description The description of the task.
     * @param type The type of the task, defined by the TaskType enum.
     */
    public Task(String description, TaskType type){
        this.description = description;
        this.type = type;
    }

    /**
     * Marks this task as done by setting its completion status to true.
     */
    public void markAsDone(){
        this.isDone = true;
    }

    /**
     * Unmarks this task, setting its completion status to false.
     */
    public void unmarkTask(){
        this.isDone = false;
    }

    /**
     * Returns a status icon indicating whether the task is done.
     *
     * @return "X" if the task is done, otherwise a blank space.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String getFileIcon() {
        return (isDone ? "1" : "0");
    }
    /**
     * Retrieves the description of this task.
     *
     * @return The description of the task.
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Returns the type of the task.
     * This method must be implemented by subclasses.
     *
     * @return The TaskType of the task.
     */
    protected abstract TaskType type();

    /**
     * Returns a string representation of the task for file storage.
     * The format includes the task type, status icon, description, and deadline.
     *
     * @return A string in the format depending on the type of task.
     * @see Event#toFileString() For the string format used when saving events.
     * @see Deadline#toFileString() For the string format used when saving events.
     * @see Todo#toFileString() For the string format used when saving events.
     */
    public abstract String toFileString();



}
