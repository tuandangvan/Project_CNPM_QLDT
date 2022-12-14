package Dao;

import java.util.List;

import Models.AdminsModel;

public interface IAdminsDao {
	void insert(AdminsModel account);

	void edit(AdminsModel account);

	void delete(int id);

	AdminsModel get(int id);

	List<AdminsModel> getAll();

	AdminsModel findById(int id);
}
