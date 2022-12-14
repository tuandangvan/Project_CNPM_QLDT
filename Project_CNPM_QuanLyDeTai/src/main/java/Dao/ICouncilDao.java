package Dao;

import java.util.List;

import Models.CouncilModel;

public interface ICouncilDao {

	void insert(CouncilModel council);

	void edit(CouncilModel council);

	void delete(int id);

	CouncilModel get(int id);

	List<CouncilModel> getAll();

	CouncilModel findById(int id);

}
