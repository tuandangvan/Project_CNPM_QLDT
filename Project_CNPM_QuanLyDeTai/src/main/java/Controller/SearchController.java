package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ISignUpDao;
import Dao.IStudentsDao;
import Dao.ITeachersDao;
import Dao.ITopicDao;
import Dao.Impl.SignUpDaoImpl;
import Dao.Impl.StudentsDaoImpl;
import Dao.Impl.TeachersDaoImpl;
import Dao.Impl.TopicDaoImpl;
import Models.SignUpModel;
import Models.StudentsModel;
import Models.TeachersModel;
import Models.TopicDetailsModel;
import Models.TopicModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/home/TimKiem"})
public class SearchController extends HttpServlet{
	
	ISignUpDao signUp = new SignUpDaoImpl();
	IStudentsDao students = new StudentsDaoImpl();
	ITeachersDao teachers = new TeachersDaoImpl();
	ITopicDao topics = new TopicDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<SignUpModel> signs = signUp.getAll();
		req.setAttribute("signs",signs);
		
		String panel = req.getParameter("param_option");
		req.setAttribute("panel",panel);
		String key = req.getParameter("param_textbox");
		if(panel.equals("timkiemsinhvien"))
		{
			List<StudentsModel> stu = students.getListSearh(key);
			req.setAttribute("stu",stu);
			
		}
		else if(panel.equals("timkiemgiangvien"))
		{
			List<TeachersModel> tea = teachers.getListSearh(key);
			req.setAttribute("tea",tea);
		}
		else
		{
			List<TopicModel> topi =topics.getListSearh(key);
			req.setAttribute("topi",topi);
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/search.jsp");
		dispatcher.forward(req, resp);
	}
	
}