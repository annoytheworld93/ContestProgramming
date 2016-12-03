import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wap5053 on 12/2/16.
 * Secure passwords contest programming problem.
 */
public class SecurePasswords {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int numPasswords = scanner.nextInt();
		for (int i = 0; i < numPasswords; i ++){
			String testPassword = scanner.next();
			boolean isAtLeast8 = testPassword.length() >= 8; //Checks to see if it least 8 characters
			boolean isNoMoreThan24 = testPassword.length() <= 24; //Checks to see if it less than 25 characters
			boolean hasUpperCase = !testPassword.equals(testPassword.toUpperCase());
			boolean hasLowerCase = !testPassword.equals(testPassword.toLowerCase());
			Pattern p = Pattern.compile("[^A-Za-z]");
			Matcher m = p.matcher(testPassword);
			boolean hasSpecial = m.find();

			if (isAtLeast8 && hasUpperCase && isNoMoreThan24 && hasLowerCase && hasSpecial){
				secure(testPassword);
			}
			else {
				notSecure(testPassword);
			}
		}
	}

	public static void notSecure(String s){
		System.out.println(s + " - not secure.");
	}

	public static void secure(String s){ System.out.println(s + " - secure.");

	}
}
