package emailAdminApp;

import java.util.Scanner;

public class Email {
	 
	//private - only accessible through class methods
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength = 8;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "Boeing.com";
	
	//constructor
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email created for: " + this.firstName + " " + this.lastName);
		
		//call method for department
		this.department = setDepartment();
//		System.out.println("Department: " +  department);
		
		//call method for random password
		this.password = randomPassword(defaultPasswordLength);
//		System.out.println("Password: " + password);
		
		//combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "."+ companySuffix;
//		System.out.println("Your email: " + email);
	}
	
	//ask for department 
	private String setDepartment() {
		System.out.print("\nDepartment Codes:\n1.Sales\n2.Development\n3.Accounting\n4.None\n\nEnter department code");
		Scanner input = new Scanner(System.in);
		int deptChoice = input.nextInt();
		if (deptChoice == 1) { 
			return "Sales";
		} else if (deptChoice == 2) {
			return "Developement";
		} else if (deptChoice == 3) {
			return "Accounting";
		} else {
			return "";
		}
	}
	
	//generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//set mailbox capacity
	public void setMailboxCapcity(int capacity) {
		this.mailboxCapacity = capacity; 
	}
	
	//set alternate email
	public void SetAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//set new password
	public void changePassword(String password) {
		this.password = password;
	}
	
	//get mailbox capacity
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	//get alternate email
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	//get password
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "\nName: " + firstName + " " + lastName +
				"\nCompany Email: " + email +
				"\nPasword: " + password +
				"\nMailbox Capacity: " + mailboxCapacity + "mb";
	}

}
