package Odev5.business.concretes;

import java.util.Random;
import java.util.Scanner;

import Odev5.business.abstracts.VerifyService;

public class VerifyManager implements VerifyService {

	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	String verifyCode = "";
	String inputVerifyCode;
	
	@Override
	public boolean verifyProcess() {
		this.generateVerifyCode();
		this.sendVerifyCode();
		
		if(this.checkVerifyCode()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void generateVerifyCode() {
		Random random = new Random();
		int code = random.nextInt(999999);
		String mycode = String.format("%06d", code);
		this.verifyCode = mycode;
	}

	@Override
	public void sendVerifyCode() {
		System.out.println("Dogrulama kodunuz: " + verifyCode);
		System.out.print("Lütfen doðrulama kodunuzu girin : ");
		this.inputVerifyCode = scanner.next();
	}

	@Override
	public boolean checkVerifyCode() {
		if(this.verifyCode.equals(inputVerifyCode)) {		
			this.inputVerifyCode = "";
			this.verifyCode = "";
			return true;
		}else {
			return false;
		}
	}
	private static String verifyCodeGenerator() {
		Random random = new Random();
		int code = random.nextInt(999999);
		
		return String.format("%06d", code);
	}
}
