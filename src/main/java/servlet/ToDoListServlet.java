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

public class ToDoListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        ArrayList<ToDoTask> taskList = ToDoTaskStorage.getToDoTaskList();

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("tasks",taskList);

        responce.setStatus(HttpServletResponse.SC_OK);
        responce.setContentType("text/html;charset=utf-8");

        responce.getWriter().println(PageGenerator.instance().getPage("templates/ToDoListTemplate.html", pageVariables));
    }
}
