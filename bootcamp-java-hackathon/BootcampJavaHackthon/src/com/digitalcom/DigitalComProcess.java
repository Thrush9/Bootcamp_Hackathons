package com.digitalcom;

import java.util.Scanner;

import com.digitalcom.service.Inter_Validate;
import com.digitalcom.service.UserService;
import com.digitalcom.service.iUserService;
import com.digitalcom.service.userRegistrationService;

public class DigitalComProcess {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("\n1.New UserRegistration \n2.Existing User");
		int choice = scan.nextInt();
		choiceSelection(choice);
	}

	private static void choiceSelection(int choice) {
		if (choice == 1)
			registrationForm();
		else if (choice == 2)
			userLoginProcess();

	}

	private static void registrationForm() {
		Inter_Validate registerService = new userRegistrationService();
		System.out.println("Enter User Name");
		String name = scan.next();
		System.out.println("Enter User Password");
		String password = scan.next();
		System.out.println("Enter UserType");
		String type = scan.next();
		registerService.addUser(name, password, type);
		System.out.println("User Created Sucessfully");

		System.out.println("\nDo u wish to contine?");
		System.out.println("1.New UserRegistration \n2.User Login \n3.Exit");
		int choice = scan.nextInt();
		choiceSelection(choice);
	}

	private static void userLoginProcess() {
		Inter_Validate registerService = new userRegistrationService();

		System.out.println("Enter User Name");
		String name = scan.next();
		System.out.println("Enter User Password");
		String password = scan.next();
		System.out.println("Enter UserType");
		String type = scan.next();
		boolean checkuser = registerService.IsAuthenticated(name, password, type);

		if (checkuser) {
			System.out.println("User Credentials Verified Sucessfully");
			iUserService userService = new UserService();

			int ans = 0;
			while (ans == 0) {
				if (type.equals("user")) {
					System.out.println(
							"\n1 - List all Games \n2 - search using game name \n3 - search using game author \n4 - view Basket");
				} else {
					System.out.println(
							"\n1 - List all Games \n2 - search using game name \n3 - search using game author \n4 - view Basket \n5 - view Reports");
				}
				int choice = scan.nextInt();

				switch (choice) {
				case 1:
					userService.viewAll();
					break;
				case 2:
					System.out.println("Enter Game Name");
					String gamename = scan.next();
					String resultauthor = userService.gameSearch(gamename);
					System.out.println("Game Author: " + resultauthor);
					break;
				case 3:
					System.out.println("Enter Author Name");
					String authorname = scan.next();
					String resultgame = userService.authorSearch(authorname);
					System.out.println("Game Name: " + resultgame);
					break;
				case 4:
					userService.viewBasket();
					break;
				case 5:

					break;
				default:
					break;
				}

				System.out.println("\nWant to continue 0-yes , 1 -no");
				ans = scan.nextInt();
			}
		} else {
			System.out.println("User Credentials not Valid");
		}
		scan.close();
	}

}
