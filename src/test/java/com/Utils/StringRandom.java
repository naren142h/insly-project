package src.test.java.com.Utils;

import java.util.Random;

public class StringRandom {

	public StringRandom() {
		super();
	}

	public static String retrunRandomGmail() {
		String SALTCHARS = "abcdefghijklmnopqrstuwxyz";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr + "@gmail.com";
	}

	public static String generateRandomPassword() {
		String SALTCHARS = "abcdefghijklmnopqrstuwxyz123456789";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}
}
