package main;

public class User extends Welcome {
	User() {
		System.out.print("Enter User Name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter User Password: ");
		String pw = sc.nextLine();
		
		if(name.equals("User") && pw.equals("user!@#")) {
			userWelcome();			
		} else {
			System.out.println("Invalid username and password");
			new User();
		}
	}
	
	private void userWelcome() {
		switch(userWelcomeOption()) {
			case 1: ; break;
			case 2: ; break;
			case 3: ; break;
			case 4: ; break;
			case 5: ; break;
			case 6: ; break;
			case 7: welcome(); break;
		}
	}
}
