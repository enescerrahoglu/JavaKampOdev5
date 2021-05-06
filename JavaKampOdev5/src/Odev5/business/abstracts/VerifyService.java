package Odev5.business.abstracts;

public interface VerifyService {
	public boolean verifyProcess();
	public void generateVerifyCode();
	public void sendVerifyCode();
	public boolean checkVerifyCode();
}
