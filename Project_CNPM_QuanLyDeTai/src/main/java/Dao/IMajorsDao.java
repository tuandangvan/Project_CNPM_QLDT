package Dao;

import java.util.List;

import Models.MajorsModel;

public interface IMajorsDao {

	void insert(MajorsModel majors);

	void edit(MajorsModel majors);

	void delete(int id);

	MajorsModel get(int id);

	List<MajorsModel> getAll();

	MajorsModel findById(int id);



}
