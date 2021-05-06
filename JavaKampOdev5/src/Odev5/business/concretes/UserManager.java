package Odev5.business.concretes;

import Odev5.business.abstracts.ControlService;
import Odev5.business.abstracts.UserService;
import Odev5.business.abstracts.VerifyService;
import Odev5.dataAccess.abstracts.UserDao;
import Odev5.entities.concretes.User;

public class UserManager implements UserService {
	
	UserDao userDao;
	ControlService controlService;
	VerifyService verifyService;
	
	public UserManager(UserDao userDao, ControlService controlService, VerifyService verifyService) 
	{
		this.userDao = userDao;
		this.controlService = controlService;
		this.verifyService = verifyService;
	}

	@Override
	public void signIn(String email, String password) {
		boolean isFound = false;
		if(userDao.getAllUsers() != null) {
			for(User tempUser :  userDao.getAllUsers()) {
				if(tempUser.getEmail() == email && tempUser.getPassword() == password) {	
					isFound = true;
					if(!tempUser.isStatus()) {
						System.out.println("Giri� ba�ar�yla sa�land�!");
						tempUser.setStatus(true);
					} else {
						System.out.println("Giri� daha �nce ger�ekle�ti!");
					}
				}
			}
			if(!isFound) {
				System.out.println("Email veya parola hatal�!");
			}
		} else {
			System.out.println("Sistemde �uan kullan�c� bulunmamaktad�r.");
		}
	}

	@Override
	public void signOut(String email, String password) {
		boolean isFound = false;
		for(User tempUser :  userDao.getAllUsers()) {
			if(tempUser.getEmail() == email && tempUser.getPassword() == password) {
				isFound = true;
				if(tempUser.isStatus()) {
					System.out.println("��k�� ba�ar�yla sa�land�!");
					tempUser.setStatus(false);
				}
				else {
					System.out.println("Kullan�c� hen�z giri� yapmad�!");
				}
			}
		}
		if(!isFound) {
			System.out.println("Email veya parola hatal�!");
		}
	}

	@Override
	public void register(User user) {
		if(this.controlService.checkInformations(user,this.userDao.getMailList())) {
			if(this.verifyService.verifyProcess()) {
				System.out.println("Kay�t ba�ar�yla ger�ekle�ti!");
				this.userDao.add(user);
			} else {
				System.out.println("Hatal� Kod!"); 
			}
		} else {
			System.out.println("Hatal� Bilgi!");
		}
	}
}
