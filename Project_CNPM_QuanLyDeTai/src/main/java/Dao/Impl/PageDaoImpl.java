package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.DBConnection;
import Dao.IPageDao;
import Models.PageModel;


public class PageDaoImpl extends DBConnection implements IPageDao {
	public PageModel PageStudent(String key)
	{
		String sql = "DECLARE @value nvarchar(50)\r\n"
				+ "set @value= N'%"+key+"%'\r\n"
				+ "select COUNT  (distinct Students.studentId)/10+1 as count,\r\n"
				+ "COUNT (distinct Students.studentId) as element\r\n"
				+ "from Students, Majors\r\n"
				+ "where Students.studentName like @value or Students.studentId  like @value \r\n"
				+ "or Students.phone  like @value or majorName  like @value";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PageModel page = new PageModel();
				page.setPage(rs.getInt("count"));
				page.setElement(rs.getInt("element"));
				return page;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public PageModel PageTeacher(String key)
	{
		String sql = "DECLARE @value nvarchar(50)\r\n"
				+ "set @value= N'%"+key+"%'\r\n"
				+ "select COUNT ( distinct Teachers.teacherId)/10+1 as count\r\n"
				+ "COUNT (distinct Teachers.teacherId) as element\r\n"
				+ "from Teachers\r\n"
				+ "where Teachers.teacherName like @value \r\n"
				+ "or Teachers.teacherId like @value or Teachers.phone  like @value\r\n"
				+ "or Teachers.email  like @value";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PageModel page = new PageModel();
				page.setPage(rs.getInt("count"));
				page.setElement(rs.getInt("element"));
				return page;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public PageModel PageTopic(String key)
	{
		String sql = "DECLARE @value nvarchar(50)\r\n"
				+ "set @value= N'%CNTT%'\r\n"
				+ "select COUNT (distinct Topic.topicId)/10+1 as count\r\n"
				+ "COUNT (distinct Topic.topicId) as element\r\n"
				+ "from Topic, Teachers\r\n"
				+ "where Topic.topicName like @value or teacherName like @value";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PageModel page = new PageModel();
				page.setPage(rs.getInt("count"));
				page.setElement(rs.getInt("element"));
				return page;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
