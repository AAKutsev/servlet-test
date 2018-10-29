package servlet;

import dao.ToDoTask;
import dao.ToDoTaskStorage;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ToDoAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();

        ToDoTask toDoTask = null;
        if(!request.getRequestURI().contains("/todolist/add"))
        {
            toDoTask = ToDoTaskStorage.getToDoTaskList().get(Integer.parseInt(request.getParameter("idEditTask")));
        }
        else
        {
            toDoTask = new ToDoTask();
        }
        pageVariables.put("toDoTask", toDoTask);
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html;charset=utf-8");

        response.getWriter().println(PageGenerator.instance().getPage("templates/ToDoAddEditTemplate.html", pageVariables));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ToDoTask> taskList = ToDoTaskStorage.getToDoTaskList();
        int idTask = Integer.parseInt(request.getParameter("idTask"));
        ToDoTask toDoTask = null;
        if(idTask == -1){
            toDoTask = new ToDoTask();
            taskList.add(toDoTask);
        }
        else {
            toDoTask= taskList.get(idTask);
        }

        toDoTask.setTaskDescription(request.getParameter("description"));
        toDoTask.setPriority(Integer.parseInt(request.getParameter("priority")));
        toDoTask.setDueDate(request.getParameter("dueDate"));

        response.sendRedirect("/todolist");
    }
}
