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

		User user1 = new User("Enes", "Cerrahoðlu", "enescerrahoglu1@gmail.com", "test987"); // Tüm bilgiler doðru
		
		User user2 = new User("Engin", "Demiroð", "engindemirog", "test987"); // Hatalý mail adresi
		
		User user3 = new User("E", "C", "test@gmail.com", "test987"); // Kýsa isim ve soyisim
		
		User user4 = new User("Derin", "Deniz", "derindeniz@gmail.com", "test"); // Kýsa parola
		
		User user5 = new User("Enes", "Cerrahoðlu", "enescerrahoglu1@gmail.com", "test987");
		
		User user6 = new User("saitfaik@gmail.com", "test123", new GoogleAccountAdapter());
		user6.setFirstName("Sait Faik");
		user6.setLastName("Abasýyanýk");
		
		User user7 = new User("Namýk", "Kemal", "namikkemal@mail.com", "test123");
		
		
		
		
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
		
		userManager.signIn("enescerrahoglu1@gmail.com", "test987"); // Giriþ baþarýlý
		System.out.println("\n");
		userManager.signIn("enescerrahoglu1@gmail.com", "test987"); // Daha önce giriþ yapýldý
		System.out.println("*******************************************************************");
		
		userManager.signOut("enescerrahoglu1@gmail.com", "test987"); // Çýkýþ baþarýlý
		System.out.println("*******************************************************************");
		
		userManager.signOut("enescerrahoglu1@gmail.com", "test987"); // Giriþ yapmadan çýkýþ yapmaya çalýþmak
	}
}
