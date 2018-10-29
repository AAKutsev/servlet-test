package main;

import dao.ToDoTask;
import dao.ToDoTaskStorage;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlet.ToDoAddServlet;
import servlet.ToDoDeleteServlet;
import servlet.ToDoListServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        ToDoListServlet toDoListServlet = new ToDoListServlet();
        ToDoDeleteServlet toDoDeleteServlet = new ToDoDeleteServlet();
        ToDoAddServlet toDoAddServlet = new ToDoAddServlet();


        ToDoTaskStorage.init();
        ToDoTask toDoTask = new ToDoTask();
        toDoTask.setPriority(1);
        toDoTask.setDueDate("2018-01-01");
        toDoTask.setTaskDescription("Do something1");
        ToDoTaskStorage.addTask(toDoTask);
        ToDoTask toDoTask2 = new ToDoTask();
        toDoTask2.setPriority(10);
        toDoTask2.setDueDate("2020-01-01");
        toDoTask2.setTaskDescription("Vacation");
        ToDoTaskStorage.addTask(toDoTask2);


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(toDoListServlet), "/todolist");
        context.addServlet(new ServletHolder(toDoDeleteServlet), "/todolist/delete");
        context.addServlet(new ServletHolder(toDoAddServlet), "/todolist/add");
        context.addServlet(new ServletHolder(toDoAddServlet), "/todolist/edit");


        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
    }
}
