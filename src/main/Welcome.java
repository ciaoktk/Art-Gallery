package main;

import java.util.Scanner;

public class Welcome {
	Scanner sc = new Scanner(System.in);
	Check check = new Check();
	private String option = "";
	
	private int welcomeOption() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("                                           Welcome To Art Gallery                                            ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1. Admin");
		System.out.println("2. User");
		System.out.println("3. Exit");
		boolean status = false;
		while(!status) {
			try {
				System.out.print("Choose option: ");
				option = sc.nextLine();
				
				if(check.checkWelcomeOption(option))
					status = true;
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return Integer.parseInt(option);
	}
	
	protected int adminWelcomeOption() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("                                                Welcome Admin                                                ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1. Add new artist");
		System.out.println("2. Update artist information");
		System.out.println("3. Delete artist");
		System.out.println("4. Add new art");
		System.out.println("5. Delete art");
		System.out.println("6. View orders");
		System.out.println("7. View artists' sales");
		System.out.println("8. Log out");
		boolean status = false;
		while(!status) {
			try {
				System.out.print("Choose option: ");
				option = sc.nextLine();
				
				if(check.checkAdminOption(option))
					status = true;
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return Integer.parseInt(option);	
	}
	
	protected int userWelcomeOption() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("                                                Welcome User                                                 ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1. View Sorted Art");
		System.out.println("2. Search art by artist name");
		System.out.println("3. Add new order");
		System.out.println("4. Cancel order");
		System.out.println("5. View orders");
		System.out.println("6. View total Payment");
		System.out.println("7. Log out");
		boolean status = false;
		while(!status) {
			try {
				System.out.print("Choose option: ");
				option = sc.nextLine();
				
				if(check.checkUserOption(option))
					status = true;
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return Integer.parseInt(option);	
	}
	
	public void welcome() {
		switch(welcomeOption()) {
			case 1: new Admin(); break;
			case 2: new User(); break;
			case 3: System.exit(0);
		}
	}
}
