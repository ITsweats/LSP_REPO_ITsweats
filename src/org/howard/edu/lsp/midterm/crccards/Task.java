package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a task with an ID, description, and status.
 * A new task is created with a default status of OPEN.
 *
 * @author Nathan Hinds
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a new Task with the given task ID and description.
     * The default status is set to OPEN.
     *
     * @param taskId the unique ID of the task
     * @param description the description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task ID.
     *
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     *
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the current task status.
     *
     * @return the current task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the task status.
     * Valid statuses are OPEN, IN_PROGRESS, and COMPLETE.
     * Any invalid status is set to UNKNOWN.
     *
     * @param status the new status of the task
     */
    public void setStatus(String status) {
        if ("OPEN".equals(status) || "IN_PROGRESS".equals(status) || "COMPLETE".equals(status)) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns a string representation of the task in the format:
     * taskId description [status]
     *
     * @return the formatted task string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}