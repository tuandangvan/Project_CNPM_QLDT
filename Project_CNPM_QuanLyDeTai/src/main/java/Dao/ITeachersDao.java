package Dao;

import java.util.List;

import Models.TeachersModel;

public interface ITeachersDao {

	void insert(TeachersModel teachers);

	void edit(TeachersModel teachers);

	void delete(int id);

	TeachersModel get(int id);

	List<TeachersModel> getAll();

	TeachersModel findById(int id);
	
	List<TeachersModel> getListSearh(String key , int idPage);

	TeachersModel getByUser(String user);

	List<TeachersModel> getAllTeacherCouncil(int teacherId);

}
