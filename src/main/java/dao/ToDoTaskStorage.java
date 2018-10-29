package dao;

import java.util.ArrayList;
import java.util.HashMap;

public class ToDoTaskStorage {
    static ToDoTaskStorage toDoTaskStorage;
    static int currentTaskId = 0;

    static public ArrayList<ToDoTask> getToDoTaskList() {
        return toDoTaskList;
    }

    static ArrayList<ToDoTask> toDoTaskList;
    static private Integer getNextTaskId(){
        return (Integer)currentTaskId++;
    }
    static public void addTask(ToDoTask toDoTask){
        int id = getNextTaskId();
        toDoTaskList.add(id, toDoTask);
        toDoTask.setId(id);
    }

    static public void removeTask(Integer taskId){
        toDoTaskList.remove(taskId);
    }
    static public void editTask(Integer taskId,ToDoTask toDoTask){
        toDoTaskList.set(taskId, toDoTask);
    }

     private ToDoTaskStorage(){
        toDoTaskList = new ArrayList<ToDoTask>(10);
    }

    static public void init(){
        if(toDoTaskStorage == null)
        {
            toDoTaskStorage = new ToDoTaskStorage();
        }
    }

}
