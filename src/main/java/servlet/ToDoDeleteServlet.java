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

public class ToDoDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ToDoTask> taskList = ToDoTaskStorage.getToDoTaskList();
        int idTask = Integer.parseInt(request.getParameter("idDeleteTask"));
        taskList.remove(idTask);
        response.sendRedirect("/todolist");
    }
}
