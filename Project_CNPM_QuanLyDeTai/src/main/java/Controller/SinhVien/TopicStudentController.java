package Controller.SinhVien;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ISignUpDao;
import Dao.IStudentsDao;
import Dao.ITopicDao;
import Dao.ITopicDetailsDao;
import Dao.Impl.SignUpDaoImpl;
import Dao.Impl.StudentsDaoImpl;
import Dao.Impl.TopicDaoImpl;
import Dao.Impl.TopicDetailsDaoImpl;
import Models.AccountModel;
import Models.SignUpModel;
import Models.TopicDetailsModel;
import Models.TopicModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/student/list-topic-register" })
public class TopicStudentController extends HttpServlet {

	ITopicDao topicDao = new TopicDaoImpl();
	ITopicDetailsDao topicDetailsDao = new TopicDetailsDaoImpl();
	IStudentsDao studentsDao = new StudentsDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ISignUpDao signUp = new SignUpDaoImpl();
		List<SignUpModel> signs = signUp.getAll();
		req.setAttribute("signs",signs);
		
		ISignUpDao signUpDao = new SignUpDaoImpl();
		SignUpModel signUpModel = signUpDao.getLast();
		Date now = Date.valueOf(LocalDate.now());

		if ((now.compareTo(signUpModel.getStartTime()) > 0 || now.compareTo(signUpModel.getStartTime()) == 0)
				&& (now.compareTo(signUpModel.getEndTime()) < 0 || now.compareTo(signUpModel.getEndTime()) == 0)) {
			if (signUpModel.getRole() == true) {
				HttpSession session = req.getSession();
				if (session != null && session.getAttribute("account") != null) {
					AccountModel account = (AccountModel) session.getAttribute("account");

					// email = 20110300@student.hcmute.edu.vn
					String email = account.getUsername();
					req.setAttribute("email", email);

					// lấy đề tài theo chuyên ngành
					List<TopicModel> topics = new ArrayList<TopicModel>();
					topics = topicDao.findTopicByEmail(email);

					// tìm danh sách topicdetail theo topicid

					for (TopicModel topic : topics) {
						List<TopicDetailsModel> topicdetails = new ArrayList<TopicDetailsModel>();
						topicdetails = topicDetailsDao.findTopicDetailByTopicId(topic.getTopicId());
						topic.setQuantityRegister(topicdetails.size());
						for (TopicDetailsModel topicdetail : topicdetails) {
							if (topicdetail.getStudentId() == studentsDao.findStudentByEmail(email).getStudentId()) {
								req.setAttribute("equal", 1);
							}

						}
					}

					req.setAttribute("topics", topics);
					RequestDispatcher dispatcher = req.getRequestDispatcher("/views/sinhvien/list-topics-register.jsp");
					dispatcher.forward(req, resp);
				}
			} else {
				req.setAttribute("message", "Không nằm trong thời gian đăng ký");
				req.getRequestDispatcher("/views/teacher/error.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("message", "Không nằm trong thời gian đăng ký");
			req.getRequestDispatcher("/views/teacher/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
