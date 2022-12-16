package Login;

import Dao.IAccountDao;
import Dao.Impl.AccountDaoImpl;
import Models.AccountModel;
public class UserServiceImpl implements UserService {
	IAccountDao acc = new AccountDaoImpl();
	public AccountModel login(String username, String password) {
		AccountModel user = this.get(username);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}
	public AccountModel get(String username) {
		return acc.get(username);
	}
}
