package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import Connection.DBConnection;
import Dao.IMajorsDao;
import Models.MajorsModel;

public class MajorsDaoImpl extends DBConnection implements IMajorsDao{
	@Override
	public void insert(MajorsModel majors) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO majors(majorsName,gender,birth,email,phone) VALUES (?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
//			ps.setString(1, majors.getmajorsName());
//			ps.setBoolean(2, majors.getGender());
//			ps.setDate(3, majors.getBirth());
//			ps.setInt(6, majors.getmajorsId());
			
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void edit(MajorsModel majors) {
		String sql = "UPDATE  majors SET majorsName=?, gender=?, birth=? email=?, phone=? WHERE majorsId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, majors.getmajorsName());
//			ps.setBoolean(2, majors.getGender());
//			ps.setDate(3, majors.getBirth());
//			ps.setInt(6, majors.getmajorsId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM majors WHERE majorsId = ?";
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
	public MajorsModel get(int id) {

		String sql = "SELECT * FROM majors WHERE majorId = ? ";
		MajorsModel major = null;

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int majorId = rs.getInt("majorId");
			    String majorName  = rs.getString("majorName");
				major = new MajorsModel(majorId,majorName);
				return major;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return major;

	}

	@Override
	public List<MajorsModel> getAll() {
		List<MajorsModel> majors= new ArrayList<MajorsModel>();
		String sql = "SELECT * FROM majors";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MajorsModel major = new MajorsModel();
				
				major.setMajorId(rs.getInt("majorsId"));
				major.setMajorName(rs.getString("majorName"));
				majors.add(major);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return majors;
	}

	@Override
	public MajorsModel findById(int id) {
		String sql = "SELECT * FROM majors WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MajorsModel majors = new MajorsModel();

//				majorser.setmajorsId(rs.getInt("majorsId"));
//				majorser.setmajorsName(rs.getString(id));
//				majorser.setmajorsId(rs.getInt("majorsId"));
//				majorser.setCreatedAt(rs.getDate("createdAt"));
//				majorser.setPrice(rs.getBigDecimal("price"));
				
				return majors;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
