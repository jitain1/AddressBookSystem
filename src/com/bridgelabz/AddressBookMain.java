package com.bridgelabz;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);

	static HashMap<String, AddressBook> allAddressbook = new HashMap<>();

	private static int mainMenu() {
		System.out.println("\n" + "************* Main Menu *************");
		System.out.println("1.Add New AdressBook" + "     " + "2.AddContacts");
		System.out.println("3.Edit Contact Details" + "     " + "4.Delete contact");
		System.out.println("5.Show AdressBook details");
		int choice = sc.nextInt();

		return choice;
	}

	public static void main(String[] args) {
		boolean flag = true;
		while (flag) {
			isEmptyAllAdressbook();
			int choice = mainMenu();

			switch (choice) {
			case 1:
				createAddressbook();
				break;

			case 2:
				System.out.println("Enter the name of the Adressbook in which you want to add contacts : ");
				String addressBookName = sc.next();
				
				if (checkAdressbookPresent(addressBookName)) {
					System.out.println("How many contacts do you want to add in " + addressBookName + " : ");
					int num = sc.nextInt();
					if (num <= 0)
						System.out.println("Invalid Input!!!");
					else {
						for (int i = 0; i < num; i++) {
							addContact(addressBookName);
						}
					}
				} else 
					addresssbookNotPresent(addressBookName);
				break;

			case 3:
				System.out.println("Enter the name of the Adressbook in which you want to edit contact : ");
				String addressBookName1 = sc.next();
				if (checkAdressbookPresent(addressBookName1))
					editContact(addressBookName1);
				else 
					addresssbookNotPresent(addressBookName1);
				break;

			case 4:
				System.out.println("Enter the name of the Adressbook in which you want to delete contact : ");
				String addressBookName2 = sc.next();
				if (checkAdressbookPresent(addressBookName2))
					deleteContact(addressBookName2);
				else 
					addresssbookNotPresent(addressBookName2);
				break;

			case 5:
				System.out.println("Enter the name of the Adressbook which you want to show: ");
				String addressBookName3 = sc.next();
				if (checkAdressbookPresent(addressBookName3))
					System.out.println(allAddressbook.get(addressBookName3));
				else 
					addresssbookNotPresent(addressBookName3);
				break;

			default:
				System.out.println("Invalid input.");
				break;
			}
		}

	}

	private static void addresssbookNotPresent(String addresssBookName) {
		System.out.println("No AdressBook present with name " + addresssBookName
				+ ". Below Adressbooks present currently: ");
		System.out.println(allAddressbook.keySet());
		
	}

	private static void isEmptyAllAdressbook() {
		if (allAddressbook.size() == 0) {
			System.out.println("There is no AdressBook present till now. Please add an Adressbook now to start.");
			createAddressbook();
		}
	}

	private static void addContact(String bookName) {
		AddressBook addressBook = allAddressbook.get(bookName);
		addressBook.addContactDetails();
	}

	private static void editContact(String bookName) {
		AddressBook addressBook = allAddressbook.get(bookName);
		addressBook.editContactDetails();
	}

	private static void deleteContact(String bookName) {
		AddressBook addressBook = allAddressbook.get(bookName);
		addressBook.deleteContact();
	}

	private static void createAddressbook() {
		System.out.println("Enter the name of the AdressBook : ");
		String name = sc.next();
		allAddressbook.put(name, new AddressBook());
		System.out.println("Adressbook created successfully.");
	}

	private static boolean checkAdressbookPresent(String name) {
		for (int i = 0; i < allAddressbook.size(); i++) {
			if (allAddressbook.containsKey(name))
				return true;
		}
		return false;
	}
}