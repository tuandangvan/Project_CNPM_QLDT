package Controller.SinhVien;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ITopicDao;
import Dao.Impl.TopicDaoImpl;
import Models.TopicModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/student/list-topic"})
public class TopicStudentController extends HttpServlet{

	ITopicDao topicDao = new TopicDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//id
		int studentId = 1;
		
		//lấy đề tài theo chuyên ngành
		
		List<TopicModel> topics = new ArrayList<TopicModel>();
		topics = topicDao.getAll();
		req.setAttribute("topics", topics);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/sinhvien/list-topics.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
