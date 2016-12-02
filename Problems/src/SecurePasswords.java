import java.util.Scanner;

/**
 * Created by wap5053 on 12/2/16.
 * Secure passwords contest programming problem.
 */
public class SecurePasswords {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int numPasswords = scanner.nextInt();
		for (int i = 0; i < numPasswords; i ++){
			String testPassword = scanner.nextLine();
			if (testPassword.length() < 8){notSecure(testPassword);}
			else if (testPassword.length() > 24){notSecure(testPassword);}
			else if (!testPassword.contains(/*a lower case letter*/)){notSecure(testPassword);}
			else if (!testPassword.contains(/*an upper case letter*/)){notSecure(testPassword);}
			else if (!testPassword.contains((/*a digit or a special character*/))){notSecure();}
			else{secure(testPassword);
		}
	}

	public static void notSecure(String s){
		System.out.println(s + " - not secure.");
	}

	public static void secure(String s){
		System.out.println(s + " - secure.");
	}
}
