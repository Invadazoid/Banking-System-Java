import java.util.Scanner;

public class Bank {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int userInput;
		int size = 0;
		double[] accountBalances = new double[500];
		String[] accountName = new String[250];
		for(;true;) {
			System.out.println("\nBANK ADMIN MENU:\n");
			System.out.println("(1) Add customer to the bank");
			System.out.println("(2) Change customer name");
			System.out.println("(3) Check account balance");
			System.out.println("(4) Modify account balance");
			System.out.println("(5) Summary of all accounts");
			System.out.println("(-1) Quit");
			System.out.print("\nPlease enter a menu option: ");
			
			userInput = sc.nextInt();
			
			if(userInput == 1) {
				System.out.println("\nBank Add Customer Menu:");
				System.out.print("\nEnter account holder name: ");
				sc.nextLine();
				String name = sc.nextLine();
				accountName[size] = name;
				System.out.print("\nEnter account balance: ");
				double balance = sc.nextDouble();
				accountBalances[size] = balance;
				System.out.print("\nCustomer ID is: " + size);
				System.out.print("\nCustomer name is: " + accountName[size]);
				System.out.print("\nAccount Balance is: " + accountBalances[size] + "\n");
				size += 1;
			}
						
			else if(userInput == 2) {
				System.out.println("\nBank Change Name Menu:");
				System.out.print("\nEnter Customer ID to change name: ");
				int index = sc.nextInt();
				System.out.print("\nEnter Customer's new name: ");
				sc.nextLine();
				accountName[index] = sc.nextLine();
				System.out.print("\nCustomer Name changed to: " + accountName[index] + "\n");
			}
					
			else if(userInput == 3) {
				System.out.println("\nBank Check Balance Menu:");
				System.out.print("\nEnter Customer ID to check balance: ");
				int index = sc.nextInt();
				double balance = accountBalances[index];
				System.out.print("\n" + accountName[index] + "'s Account Balance is $" + balance + "\n");
			}
						
			else if(userInput == 4) {
				System.out.println("\nBank Modify Balance Menu:");
				System.out.print("\nEnter Customer ID to modify balance: ");
				int index = sc.nextInt();
				for(;true;) {
					System.out.print("\n\n1. Deposit\n2. Withdraw\n0. Previous Menu\n\nEnter your choice: ");
					int ch = sc.nextInt();
					if(ch==1) {
						System.out.print("Enter amount to deposit: ");
						int dep = sc.nextInt();
						accountBalances[index] += dep;
						System.out.println("\nDeposit successful!");
					}
					else if(ch==2) {
						System.out.print("Enter amount to withdraw: ");
						int wit = sc.nextInt();
						accountBalances[index] -= wit;
						System.out.println("\nWithdrawal successful!");
					}
					else if(ch==0) {
						break;
					}
					else {
						System.out.println("\nERROR: Invalid input!");
					}
				}
				System.out.println("\n\n" + accountName[index] + "'s Account Balance is $" + accountBalances[index]);
			}
					
			else if(userInput == 5) {
				System.out.println("\nBank All Customer Summary Menu: ");
				double total = 0;
				for(int i = 0; i < size; i++) {
					total += accountBalances[i];
					System.out.println(accountName[i] + " has $" + accountBalances[i] + " in their account");	
				}
				System.out.println("In total, there is $" + total + " in the bank");
			}
			
			else if(userInput == -1) {
				System.out.println("\nTHANK YOU FOR USING THE BANK.\nHAVE A GOOD DAY!\n");
				System.exit(-1);
			}
		
			else {
				System.out.println("\nERROR: Invalid input!");
			}
		}
	}
}
