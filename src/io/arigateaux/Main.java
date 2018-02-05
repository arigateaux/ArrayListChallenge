package io.arigateaux;

import java.util.Scanner;

public class Main {

    public static boolean isRunning = true;
    public static Scanner scanner = new Scanner(System.in);

    public static MobilePhone myPhone = new MobilePhone("1234567890");
    public static Contact contact;
    public static String name;
    public static String number;

    public static void main(String[] args) {

        while (isRunning) {
            new GUI();
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                // show contacts
                case 1:
                    myPhone.showContacts();
                    break;
                // add contact
                case 2:
                    System.out.println("Enter the name of your contact: ");
                    name = scanner.nextLine();
                    System.out.println("Enter the number of your contact: ");
                    number = scanner.nextLine();
                    contact = new Contact(name, number);
                    if (myPhone.addNewContact(contact)) {
                        System.out.println(name + " added to contact list.");
                    }
                    break;
                // update contact
                case 3:

                    break;
                // remove contact
                case 4:
                    System.out.println("Enter the name of your contact: ");
                    name = scanner.nextLine();
                    
                    contact = new Contact(name, number);
                    if (myPhone.addNewContact(contact)) {
                        System.out.println(name + " added to contact list.");
                    }
                    break;
                // search contact
                case 5:

                    break;
                // exit loop
                case 6:
                    isRunning = false;
                default:
                    break;
            }
        }

    }
}
