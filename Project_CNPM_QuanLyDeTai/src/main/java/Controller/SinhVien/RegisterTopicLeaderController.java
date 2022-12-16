package Controller.SinhVien;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.IStudentsDao;
import Dao.ITopicDetailsDao;
import Dao.Impl.StudentsDaoImpl;
import Dao.Impl.TopicDetailsDaoImpl;
import Models.StudentsModel;
import Models.TopicDetailsModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/student/register"})
public class RegisterTopicLeaderController extends HttpServlet{

	IStudentsDao studentsDao = new StudentsDaoImpl();
	ITopicDetailsDao topicDetailsDao = new TopicDetailsDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String topicId = req.getParameter("topicId");
		String leader = req.getParameter("leader");
		
		StudentsModel student = new StudentsModel();
		student = studentsDao.findStudentByEmail(email);
		
		TopicDetailsModel topicDetail = new TopicDetailsModel();
		topicDetail.setStudentId(student.getStudentId());
		topicDetail.setTopicId(Integer.parseInt(topicId));
		
		if(leader.equals("1"))
		{
			topicDetailsDao.insertLeader(topicDetail);
		}
		else if(leader.equals("0"))
		{
			topicDetailsDao.insertMenber(topicDetail);
		}
		
		resp.sendRedirect(req.getContextPath() + "/student/list-topic-register");
	}
	
}
