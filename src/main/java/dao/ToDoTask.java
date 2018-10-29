package dao;

public class ToDoTask {
    String taskDescription="";
    String dueDate="";
    int priority=0;
    int id = -1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getToDoTaskString(){
        return getTaskDescription() +" "+ getDueDate() +" "+ getPriority();
    }
}
