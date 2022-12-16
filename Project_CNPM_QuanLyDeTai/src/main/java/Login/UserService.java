package Login;

import Models.AccountModel;

public interface UserService {
	AccountModel login(String username, String password);
	AccountModel get(String username);
}
