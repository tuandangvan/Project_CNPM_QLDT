package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import Connection.DBConnection;
import Dao.ITeachersDao;
import Models.TeachersModel;

public class TeachersDaoImpl extends DBConnection implements ITeachersDao{
	@Override
	public void insert(TeachersModel teacher) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO teachers(teacherName,gender,birth,email,phone,majorId) VALUES (?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
						
			ps.setString(1, teacher.getTeacherName());
			ps.setBoolean(2, teacher.getGender());
			ps.setDate(3, teacher.getBirth());
			ps.setString(4, teacher.getEmail());
			ps.setString(5, teacher.getPhone());
			ps.setInt(6, teacher.getMajorId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void edit(TeachersModel teachers) {

		String sql = "UPDATE  teachers SET teacherName=?, gender=?, birth=?, phone=? WHERE email=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, teachers.getTeacherName());
			ps.setBoolean(2, teachers.getGender());
			ps.setDate(3, teachers.getBirth());
			ps.setString(4, teachers.getPhone());
			ps.setString(5, teachers.getEmail());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM teachers WHERE teachersId = ?";
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
	public TeachersModel get(int id) {
		String sql = "SELECT * FROM teachers WHERE username = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TeachersModel major = new TeachersModel();
//				teacherser.setteachersId(rs.getInt("teachersId"));
//				teacherser.setteachersName(rs.getString(id));
//				teacherser.setteachersId(rs.getInt("teachersId"));
//				teacherser.setBoolean(3, signup.getBoolean());
//				teacherser.setCreatedAt(rs.getDate("createdAt"));
//				teacherser.setPrice(rs.getBigDecimal("price"));
		
				return major;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TeachersModel> getAll() {
		List<TeachersModel> teachers= new ArrayList<TeachersModel>();
		String sql = "SELECT * FROM teachers";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TeachersModel major = new TeachersModel();
				
//				teacherser.setteachersId(rs.getInt("teachersId"));
//				teacherser.setteachersName(rs.getString(id));
//				teacherser.setteachersId(rs.getInt("teachersId"));
//				teacherser.setBoolean(3, signup.getBoolean());
//				teacherser.setCreatedAt(rs.getDate("createdAt"));
//				teacherser.setPrice(rs.getBigDecimal("price"));
				
				teachers.add(major);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}

	@Override
	public TeachersModel findById(int id) {
		String sql = "SELECT * FROM teachers WHERE teacherId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TeachersModel teacher = new TeachersModel();

				teacher.setTeacherId(rs.getInt("teacherId"));
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setGender(rs.getBoolean("gender"));
				teacher.setBirth(rs.getDate("birth"));
				teacher.setEmail(rs.getString("email"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setMajorId(rs.getInt("majorId"));
				
				return teacher;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public TeachersModel getByUser(String user) {
		String sql = "SELECT * FROM teachers WHERE email = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int teacherId = rs.getInt("teacherId");
			    String teacherName = rs.getString("teacherName");
			    Boolean gender = rs.getBoolean("gender");
			    Date birth  = rs.getDate("birth");;
			    String email = rs.getString("email");
			    String phone = rs.getString("phone");
				int majorId = rs.getInt("majorId");
				
				return new TeachersModel(teacherId,teacherName,gender,birth,email,phone,majorId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<TeachersModel> getAllTeacherCouncil(int teacherId) {
		List<TeachersModel> teachers= new ArrayList<TeachersModel>();
		String sql = "SELECT Teachers.teacherId, Teachers.teacherName, Teachers.email, Teachers.phone, Majors.majorName\r\n"
				+ "FROM Teachers, Majors \r\n"
				+ "Where Teachers.majorId = Majors.majorId";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TeachersModel teacher = new TeachersModel();
				
				if(rs.getInt("teacherId") != teacherId) {
					teacher.setTeacherId(rs.getInt("teacherId"));
					teacher.setTeacherName(rs.getString("teacherName"));
					teacher.setEmail(rs.getString("email"));
					teacher.setPhone(rs.getString("phone"));
					teacher.setMajorName(rs.getString("majorName"));
					
					teachers.add(teacher);
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}
	
	@Override
	public List<TeachersModel> getAllTeacherByTopicId(int topicId) {
		List<TeachersModel> teachers= new ArrayList<TeachersModel>();
		String sql = "Select Teachers.teacherId, Teachers.teacherName, Teachers.email, Teachers.gender, Teachers.majorId, "
				+ "Teachers.phone from Council, CouncilDetails, Teachers\r\n"
				+ "where CouncilDetails.CouncilId=Council.id and CouncilDetails.teacherId=Teachers.teacherId\r\n"
				+ "and Council.topicId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, topicId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TeachersModel teacher = new TeachersModel();
					teacher.setTeacherId(rs.getInt("teacherId"));
					teacher.setTeacherName(rs.getString("teacherName"));
					teacher.setEmail(rs.getString("email"));
					teacher.setPhone(rs.getString("phone"));
					teacher.setGender(rs.getBoolean("gender"));
					teacher.setMajorId(rs.getInt("majorID"));
					
					teachers.add(teacher);
				}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}
	
	@Override
	public void editByAdmin(TeachersModel teachers) {

		String sql = "UPDATE  teachers SET teacherName=?, gender=?, birth=?, phone=?, majorId=? WHERE teacherId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, teachers.getTeacherName());
			ps.setBoolean(2, teachers.getGender());
			ps.setDate(3, teachers.getBirth());
			ps.setString(4, teachers.getPhone());
			ps.setInt(5, teachers.getMajorId());
			ps.setInt(6, teachers.getTeacherId());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<TeachersModel> getAllByAdmin(){
		List<TeachersModel> teachers = new ArrayList<TeachersModel>();
		String sql = "SELECT teacherId, teacherName, gender, birth, email, phone, Majors.majorName\r\n"
				+ "FROM Teachers, Majors\r\n"
				+ "where Teachers.majorId = Majors.majorId";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TeachersModel teacher = new TeachersModel();
				
				teacher.setTeacherId(rs.getInt(1));
				teacher.setTeacherName(rs.getString(2));
				teacher.setGender(rs.getBoolean(3));
				teacher.setBirth(rs.getDate(4));
				teacher.setEmail(rs.getString(5));
				teacher.setPhone(rs.getString(6));
				teacher.setMajorName(rs.getString(7));
				
				teachers.add(teacher);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}
	
}
