package Dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import Dao.ISignUpDao;
import Models.SignUpModel;

public class SignUpDaoImpl extends DBConnection implements ISignUpDao{
	@Override
	public void insert(SignUpModel signup) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO SignUp(startTime,endTime,role) VALUES (?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, signup.getStartTime());
			ps.setDate(2, signup.getEndTime());
			ps.setBoolean(3, signup.getRole());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void edit(SignUpModel signup) {
		String sql = "UPDATE  signup SET signupName=?, gender=?, birth=? email=?, phone=? WHERE signupId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, signup.getsignupName());
//			ps.setBoolean(2, signup.getGender());
//			ps.setDate(3, signup.getBirth());
//			ps.setInt(6, signup.getsignupId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM signup WHERE signupId = ?";
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
	public SignUpModel get(int id) {
		String sql = "select  startTime, signUpId,startTime,endTime,role,\r\n"
				+ "YEAR(startTime) as yStart, MONTH(startTime) as mStart, DAY(startTime) as dStart,\r\n"
				+ "YEAR(endTime) as yEnd, MONTH(endTime) as mEnd, DAY(endTime) as dEnd\r\n"
				+ "from SignUp\r\n"
				+ "where YEAR(startTime)  =?\r\n"
				+ "ORDER BY SignUp.startTime desc ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SignUpModel signup = new SignUpModel();
				signup.setSignUpId(rs.getInt("signupId"));
				signup.setStartTime(rs.getDate("startTime"));
				signup.setEndTime(rs.getDate("endTime"));
				signup.setRole(rs.getBoolean("role"));
				signup.setdEnd(rs.getInt("dEnd"));
				signup.setyEnd(rs.getInt("yEnd"));
				signup.setmEnd(rs.getInt("mEnd"));
				signup.setdStart(rs.getInt("dStart"));
				signup.setyStart(rs.getInt("yStart"));
				signup.setmStart(rs.getInt("mStart"));				
				return signup;
//				SignUpModel signup = new SignUpModel();
//				signup.setSignUpId(rs.getInt("signupId"));
//				signup.setStartTime(rs.getTimestamp("startTime"));
//				signup.setEndTime(rs.getTimestamp("endTime"));
//				signup.setRole(rs.getBoolean("role"));
//				signup.setdEnd(rs.getInt("dEnd"));
//				signup.setyEnd(rs.getInt("yEnd"));
//				signup.setmEnd(rs.getInt("mEnd"));
//				signup.setdStart(rs.getInt("dStart"));
//				signup.setyStart(rs.getInt("yStart"));
//				signup.setmStart(rs.getInt("mStart"));
				
//				return signup;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	
	
	}

	@Override
	public List<SignUpModel> getAll() {
		List<SignUpModel> signups= new ArrayList<SignUpModel>();
		String sql = "select signUpId,startTime,endTime,role , \r\n"
				+ "YEAR(startTime) as yStart, MONTH(startTime) as mStart, DAY(startTime) as dStart,\r\n"
				+ "YEAR(endTime) as yEnd, MONTH(endTime) as mEnd, DAY(endTime) as dEnd\r\n"
				+ "from signup\r\n";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
//				SignUpModel signup = new SignUpModel();
//				
//				signup.setSignUpId(rs.getInt("signupId"));
//				signup.setStartTime(rs.getTimestamp("startTime"));
//				signup.setEndTime(rs.getTimestamp("endTime"));
//				signup.setRole(rs.getBoolean("role"));
//				signup.setdEnd(rs.getInt("dEnd"));
//				signup.setyEnd(rs.getInt("yEnd"));
//				signup.setmEnd(rs.getInt("mEnd"));
//				signup.setdStart(rs.getInt("dStart"));
//				signup.setyStart(rs.getInt("yStart"));
//				signup.setmStart(rs.getInt("mStart"));
//				
//				
//				
//				signups.add(signup);
				SignUpModel signup = new SignUpModel();
				signup.setSignUpId(rs.getInt("signupId"));
				signup.setStartTime(rs.getDate("startTime"));
				signup.setEndTime(rs.getDate("endTime"));
				signup.setRole(rs.getBoolean("role"));
				signup.setdEnd(rs.getInt("dEnd"));
				signup.setyEnd(rs.getInt("yEnd"));
				signup.setmEnd(rs.getInt("mEnd"));
				signup.setdStart(rs.getInt("dStart"));
				signup.setyStart(rs.getInt("yStart"));
				signup.setmStart(rs.getInt("mStart"));
				
				
				
				signups.add(signup);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return signups;
	}

	@Override
	public SignUpModel findById(int id) {
		String sql = "SELECT * FROM signup WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SignUpModel signup = new SignUpModel();

//				signuper.setsignupId(rs.getInt("signupId"));
//				signuper.setsignupName(rs.getString(id));
//				signuper.setsignupId(rs.getInt("signupId"));
//				signuper.setCreatedAt(rs.getDate("createdAt"));
//				signuper.setPrice(rs.getBigDecimal("price"));
				
				return signup;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public SignUpModel getTop() {
		String sql = "select top(1) startTime, signUpId,startTime,endTime,role , \r\n"
				+ "YEAR(startTime) as yStart, MONTH(startTime) as mStart, DAY(startTime) as dStart,\r\n"
				+ "YEAR(endTime) as yEnd, MONTH(endTime) as mEnd, DAY(endTime) as dEnd\r\n"
				+ "from SignUp\r\n"
				+ "ORDER BY SignUp.startTime desc ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SignUpModel signup = new SignUpModel();
//				signuper.setsignupId(rs.getInt("signupId"));
//				signuper.setsignupName(rs.getString(id));
//				signuper.setsignupId(rs.getInt("signupId"));
//				signuper.setBoolean(3, signup.getBoolean());
//				signuper.setCreatedAt(rs.getDate("createdAt"));
//				signuper.setPrice(rs.getBigDecimal("price"));
				
//				signup.setSignUpId(rs.getInt("signupId"));
//				signup.setStartTime(rs.getTimestamp("startTime"));
//				signup.setEndTime(rs.getTimestamp("endTime"));
//				signup.setRole(rs.getBoolean("role"));
//				signup.setdEnd(rs.getInt("dEnd"));
//				signup.setyEnd(rs.getInt("yEnd"));
//				signup.setmEnd(rs.getInt("mEnd"));
//				signup.setdStart(rs.getInt("dStart"));
//				signup.setyStart(rs.getInt("yStart"));
//				signup.setmStart(rs.getInt("mStart"));
//				return signup;
				signup.setSignUpId(rs.getInt("signupId"));
				signup.setStartTime(rs.getDate("startTime"));
				signup.setEndTime(rs.getDate("endTime"));
				signup.setRole(rs.getBoolean("role"));
				signup.setdEnd(rs.getInt("dEnd"));
				signup.setyEnd(rs.getInt("yEnd"));
				signup.setmEnd(rs.getInt("mEnd"));
				signup.setdStart(rs.getInt("dStart"));
				signup.setyStart(rs.getInt("yStart"));
				signup.setmStart(rs.getInt("mStart"));
				return signup;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public SignUpModel getLast() {
		SignUpModel signup = null;
		String sql = "SELECT Top 1 * FROM signup ORDER BY signUpId DESC ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int signUpId = rs.getInt("signUpId");
				Date startTime= rs.getDate("startTime");
				Date endTime = rs.getDate("endTime");
				Boolean role = rs.getBoolean("role");
				signup = new SignUpModel(signUpId,startTime,endTime,role);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return signup;
	}
	
}
