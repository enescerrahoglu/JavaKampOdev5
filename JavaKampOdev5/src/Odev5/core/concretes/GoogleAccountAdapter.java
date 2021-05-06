package Odev5.core.concretes;

import Odev5.accounts.GoogleAccount;
import Odev5.core.abstracts.AccountService;

public class GoogleAccountAdapter implements AccountService {

	@Override
	public void signUpSocialAccounts(String email, String password) {
		GoogleAccount googleAccount = new GoogleAccount();
		googleAccount.signUpWithGoogle(email, password);
	}

}
