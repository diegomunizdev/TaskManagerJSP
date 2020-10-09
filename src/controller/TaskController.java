package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDAO;
import dao.TaskDAOImplementation;
import model.Task;

@WebServlet("/TaskController")
public class TaskController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private TaskDAO dao;
    public static final String LIST_ALL_TASKS = "/listalltasks.jsp";
    public static final String CREATE_OR_EDIT = "/createoredittask.jsp";
    
    public TaskController() {
        dao = new TaskDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
        String action = request.getParameter("action");
        
        if( action.equalsIgnoreCase("delete")) {
            forward = LIST_ALL_TASKS;
            this.delete(request);
        }
        
        else if( action.equalsIgnoreCase("edit")) {
            forward = CREATE_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Task task = dao.getTaskById(id);
            request.setAttribute("task", task);
        }
        else if(action.equalsIgnoreCase("create")) {
            forward = CREATE_OR_EDIT;
        }
        else {
            forward = LIST_ALL_TASKS;
            request.setAttribute("tasks", dao.listAllTasks());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}
	
	protected void delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
        dao.deleteTask(id);
        request.setAttribute("tasks", dao.listAllTasks());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Task task = new Task();
		task.setName(request.getParameter("name"));
		task.setDescription(request.getParameter("description"));
		task.setStatus_tarefa(request.getParameter("status_tarefa"));
		task.setAtribuido(request.getParameter("atribuido"));
		
        String id = request.getParameter("id");
 
        if(id == null || id.isEmpty())
            dao.createTask(task);
        else {
            task.setId(Integer.parseInt(id));
            String data_conclusao = request.getParameter("data_conclusao");
            String dateCreated = request.getParameter("dateCreated");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date;
			try {
				date = sdf.parse(dateCreated);
				java.sql.Date sqlDateCreated = new java.sql.Date(date.getTime());
				task.setDateCreated(sqlDateCreated);
				date = sdf.parse(data_conclusao);
				sqlDateCreated = new java.sql.Date(date.getTime());
				task.setData_conclusao(sqlDateCreated);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            dao.editTask(task);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_ALL_TASKS);
        request.setAttribute("tasks", dao.listAllTasks());
        view.forward(request, response);
	}

}
