package Odev5.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import Odev5.dataAccess.abstracts.UserDao;
import Odev5.entities.concretes.User;

public class UserInMemoryDao implements UserDao {
	
	List<String> emailList = new ArrayList<String>();
	List<User> userList = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		
		this.userList.add(user);
		this.emailList.add(user.getEmail());
		System.out.println("Kullanýcý baþarýyla sisteme eklendi: " + user.getFirstName() + " " + user.getLastName());
		
	}

	@Override
	public List<String> getMailList() {
		return this.emailList;
	}

	@Override
	public List<User> getAllUsers() {
		return this.userList;
	}
}
