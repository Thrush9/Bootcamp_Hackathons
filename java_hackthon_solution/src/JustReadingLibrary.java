
import java.util.Scanner;

import com.stackroute.LibraryService.AdminService;
import com.stackroute.LibraryService.MemberService;
import com.stackroute.LibraryService.iAdminService;
import com.stackroute.LibraryService.iMemberService;
import com.stackroute.model.BorrowedBookInfo;
import com.stackroute.model.MemberAccount;


public class JustReadingLibrary {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		  System.out.println("\n1.New User \n2.Existing User \n3.Admin User"); 
		  int choice = scan.nextInt(); 
		  choiceSelection(choice);
	}

	private static void choiceSelection(int choice) {
		if (choice == 1)
			registrationForm();
		else if (choice == 2)
			memberLoginProcess();
		else if (choice == 3)
			adminLoginProcess();
	}

	private static void adminLoginProcess() {
		iAdminService adminService = new AdminService();

		int ans = 0;
		while (ans == 0) {
			System.out.println(
					"\n1 - Lend Books \n2 - Collect Dues");
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter Member Account No.");
				int mno = scan.nextInt();
				System.out.println("Enter Book No");
				int bno = scan.nextInt();
				System.out.println("Enter Start Date");
				String start = scan.next();
				adminService.lendBooks(mno,bno,start);
				//adminService.lendBooks(mno,bno,start);
				System.out.println("Book Lended Succesfully");
				break;
			case 2:
				System.out.println("Enter Member Account No.");
				int pno = scan.nextInt();
				long payDue = adminService.getDueAmount(pno);
				System.out.println("Total Dues : " + payDue);
				if(payDue != 0) {
				System.out.println("Enter Amount");
				int amt = scan.nextInt();
				adminService.payDueAmount(pno, amt);
				System.out.println("Payed Dues Successfully");
				}
				break;
			default:
				break;
			}

			System.out.println("\nWant to continue 0-yes , 1 -no");
			ans = scan.nextInt();
		}
		scan.close();
	}

	private static void memberLoginProcess() {
		iMemberService memberService = new MemberService();
		int ans = 0;
		while (ans == 0) {
			System.out.println(
					"\n1 - Borrow Books \n2 - Return Books \n3 - Pay  Dues \n4 - Account Details");
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter Member Account No.");
				int mno = scan.nextInt();
				System.out.println("Enter Book No");
				int bno = scan.nextInt();
				System.out.println("Enter Start Date");
				String start = scan.next();
				BorrowedBookInfo[] addbb = memberService.borrowBooks(mno,bno,start);
				System.out.println("Book Borrowed Succesfully\n");
				for (BorrowedBookInfo borrowedBookInfo : addbb) {
					System.out.println(borrowedBookInfo);
				}
				break;
			case 2:
				System.out.println("Enter Member Account No.");
				int rno = scan.nextInt();
				System.out.println("Enter Book No");
				int rbno = scan.nextInt();
				System.out.println("Enter End Date");
				String rend = scan.next();
				long due = memberService.returnBookDue(rno,rbno,rend);
				BorrowedBookInfo[] deletebb = memberService.returnBooks(rno,rbno);
				System.out.println("Due Amount : " + due);
				System.out.println("Book Returned Succesfully\n");
				for (BorrowedBookInfo borrowedBookInfo : deletebb) {
					System.out.println(borrowedBookInfo);
				}
				break;
			case 3:
				System.out.println("Enter Member Account No.");
				int pno = scan.nextInt();
				long payDue = memberService.getDueAmount(pno);
				System.out.println("Total Dues : " + payDue);
				if(payDue != 0) {
				System.out.println("Enter Amount");
				int amt = scan.nextInt();
				memberService.payDueAmount(pno, amt);
				System.out.println("Payed Dues Successfully");
				}
				break;
			case 4:
				 System.out.println("Enter Member Account No.");
				 int mano = scan.nextInt();
			     MemberAccount acct =memberService.getAccountDetails(mano);
			     System.out.println(acct);
			    break;
			default:
				break;
			}

			System.out.println("\nWant to continue 0-yes , 1 -no");
			ans = scan.nextInt();
		}
            scan.close();
	}

	private static void registrationForm() {
		iMemberService registerService = new MemberService();
		System.out.println("Enter Customer Name");
		String addname = scan.next();
		System.out.println("Enter Door No.");
		int addNo = scan.nextInt();
		System.out.println("Enter Street Name");
		String addst = scan.next();
		System.out.println("Enter City");
		String addctiy = scan.next();
		System.out.println("Enter State");
		String addstate = scan.next();
		System.out.println("Enter Pincode");
		long addpin = scan.nextLong();
		int acctNo = registerService.openAccount(addname, addNo, addst, addctiy, addstate, addpin);
		System.out.println("Account Created Sucessfully");
		System.out.println("Account No: " + acctNo);
 
		//memberLoginProcess();
	}

}
