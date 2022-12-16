package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import Connection.DBConnection;
import Dao.IStudentsDao;
import Models.StudentsModel;

public class StudentsDaoImpl extends DBConnection implements IStudentsDao{
	@Override
	public void insert(StudentsModel students) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO students(studentsName,gender,birth,email,phone) VALUES (?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
//			ps.setString(1, students.getstudentsName());
//			ps.setBoolean(2, students.getGender());
//			ps.setDate(3, students.getBirth());
//			ps.setInt(6, students.getstudentsId());
			
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void edit(StudentsModel students) {
		String sql = "UPDATE Students SET studentName = ?, gender = ?, birth = ?, \r\n"
				+ "phone = ?, address = ?\r\n"
				+ "WHERE studentId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, students.getStudentName());
			ps.setBoolean(2, students.getGender());
			ps.setDate(3, students.getBirth());
			ps.setString(4, students.getPhone());
			ps.setString(5, students.getAddress());
			
			ps.setInt(6, students.getStudentId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM students WHERE studentsId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public StudentsModel get(int id) {
		String sql = "SELECT * FROM students WHERE username = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentsModel major = new StudentsModel();
//				studentser.setstudentsId(rs.getInt("studentsId"));
//				studentser.setstudentsName(rs.getString(id));
//				studentser.setstudentsId(rs.getInt("studentsId"));
//				studentser.setBoolean(3, signup.getBoolean());
//				studentser.setCreatedAt(rs.getDate("createdAt"));
//				studentser.setPrice(rs.getBigDecimal("price"));
		
				return major;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StudentsModel> getAll() {
		List<StudentsModel> students= new ArrayList<StudentsModel>();
		String sql = "SELECT * FROM students";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentsModel major = new StudentsModel();
				
//				studentser.setstudentsId(rs.getInt("studentsId"));
//				studentser.setstudentsName(rs.getString(id));
//				studentser.setstudentsId(rs.getInt("studentsId"));
//				studentser.setBoolean(3, signup.getBoolean());
//				studentser.setCreatedAt(rs.getDate("createdAt"));
//				studentser.setPrice(rs.getBigDecimal("price"));
				
				students.add(major);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public StudentsModel findById(int id) {
		String sql = "SELECT * FROM students WHERE studentId = ? ";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentsModel student = new StudentsModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getBoolean(3),
						rs.getDate(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8));
				return student;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<StudentsModel> getListSearh(String key, int idPage) {
		List<StudentsModel> students= new ArrayList<StudentsModel>();
		String sql = "DECLARE @value nvarchar(50)\r\n"
				+ "set @value= N'%"+key+"%'\r\n"
				+ "select distinct Students.studentId, Students.studentName, Students.phone, Students.email,\r\n"
				+ "(select Majors.majorName from Majors where Majors.majorId = Students.majorId) as majorName,\r\n"
				+ "(select Topic.topicName from Topic, TopicDetails\r\n"
				+ "where TopicDetails.studentId = Students.studentId and TopicDetails.topicId=Topic.topicId) as topicName\r\n"
				+ "from Students, Majors\r\n"
				+ "where Students.studentName like @value or Students.studentId  like @value \r\n"
				+ "or Students.phone like @value or majorName  like @value\r\n"
				+ "ORDER BY Students.studentId\r\n"
				+ "OFFSET (?-1)*10 ROWS\r\n"
				+ "FETCH FIRST 10 ROWS ONLY";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idPage);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentsModel student = new StudentsModel();
				
				student.setStudentId(rs.getInt("studentId"));
				student.setStudentName(rs.getString("studentName"));
				student.setPhone(rs.getString("phone"));
				student.setEmail(rs.getString("email"));
				
				student.setTopicName(rs.getString("topicName"));
				student.setMajorName(rs.getString("majorName"));

				
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public StudentsModel findStudentByEmail(String email) {
		String sql = "SELECT * FROM students WHERE email = ? ";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentsModel student = new StudentsModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getBoolean(3),
						rs.getDate(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8));
				return student;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
	
