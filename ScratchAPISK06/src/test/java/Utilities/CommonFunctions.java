package Utilities;

import java.util.Random;

public class CommonFunctions {
	
	private static final String DOMAIN = "@gmail.com";
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static String getRandomEmail() {
        Random random = new Random();
        StringBuilder emailId = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int index = random.nextInt(CHARACTERS.length());
            emailId.append(CHARACTERS.charAt(index));
        }

        return emailId.toString() + DOMAIN;
    }
	

}
