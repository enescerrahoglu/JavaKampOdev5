package Odev5;

import Odev5.business.abstracts.UserService;
import Odev5.business.concretes.ControlManager;
import Odev5.business.concretes.UserManager;
import Odev5.business.concretes.VerifyManager;
import Odev5.core.concretes.GoogleAccountAdapter;
import Odev5.dataAccess.concretes.UserInMemoryDao;
import Odev5.entities.concretes.User;

public class Main {
	
	public static void main(String[] args) {

		User user1 = new User("Enes", "Cerraho�lu", "enescerrahoglu1@gmail.com", "test987"); // T�m bilgiler do�ru
		
		User user2 = new User("Engin", "Demiro�", "engindemirog", "test987"); // Hatal� mail adresi
		
		User user3 = new User("E", "C", "test@gmail.com", "test987"); // K�sa isim ve soyisim
		
		User user4 = new User("Derin", "Deniz", "derindeniz@gmail.com", "test"); // K�sa parola
		
		User user5 = new User("Enes", "Cerraho�lu", "enescerrahoglu1@gmail.com", "test987");
		
		User user6 = new User("saitfaik@gmail.com", "test123", new GoogleAccountAdapter());
		user6.setFirstName("Sait Faik");
		user6.setLastName("Abas�yan�k");
		
		User user7 = new User("Nam�k", "Kemal", "namikkemal@mail.com", "test123");
		
		
		
		
		UserService userManager = new UserManager(new UserInMemoryDao(), new ControlManager(), new VerifyManager());
		
		userManager.register(user1);
		System.out.println("*******************************************************************");
		
		userManager.register(user2);
		System.out.println("*******************************************************************");
		
		userManager.register(user3);
		System.out.println("*******************************************************************");
		
		userManager.register(user4);
		System.out.println("*******************************************************************");
		
		userManager.register(user5);
		System.out.println("*******************************************************************");
		
		userManager.register(user6);
		System.out.println("*******************************************************************");
		
		userManager.register(user7);
		System.out.println("*******************************************************************");
		
		userManager.signIn("enescerrahoglu1@gmail.com", "test987"); // Giri� ba�ar�l�
		System.out.println("\n");
		userManager.signIn("enescerrahoglu1@gmail.com", "test987"); // Daha �nce giri� yap�ld�
		System.out.println("*******************************************************************");
		
		userManager.signOut("enescerrahoglu1@gmail.com", "test987"); // ��k�� ba�ar�l�
		System.out.println("*******************************************************************");
		
		userManager.signOut("enescerrahoglu1@gmail.com", "test987"); // Giri� yapmadan ��k�� yapmaya �al��mak
	}
}
