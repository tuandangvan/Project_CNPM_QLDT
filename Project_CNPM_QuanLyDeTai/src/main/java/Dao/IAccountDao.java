package Dao;

import java.util.List;

import Models.AccountModel;

public interface IAccountDao {

	void insert(AccountModel account);

	void edit(AccountModel account);

	void delete(int id);

	AccountModel get(int id);

	List<AccountModel> getAll();

	AccountModel findById(int id);

}
