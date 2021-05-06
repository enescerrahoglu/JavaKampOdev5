package Odev5.dataAccess.abstracts;

import java.util.List;

import Odev5.entities.concretes.User;

public interface UserDao {
	void add(User user);
	List<String> getMailList();
	List<User> getAllUsers();
}
