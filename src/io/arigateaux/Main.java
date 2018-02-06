package io.arigateaux;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static MobilePhone myPhone = new MobilePhone("1234567890");
    public static Contact contact;
    public static String name;
    public static String number;
    public static GUI gui = new GUI();
    public static boolean isRunning = myPhone.isRunning();

    public static void main(String[] args) {
        myPhone.startupPhone();
        while (!isRunning) {
            gui.showMenu();
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                //exit loop
                case 0:
                    myPhone.shutdownPhone();
                    break;
                // show contacts
                case 1:
                    showContacts();
                    break;
                // add contact
                case 2:
                    addContact();
                    break;
                // update contact
                case 3:
                    updateContact();
                    break;
                // remove contact
                case 4:
                    removeContact();
                    break;
                // search contact
                case 5:
                    searchContact();
                    break;
                default:
                    break;
            }
        }
    }

    public static void showContacts() {
        myPhone.showContacts();
    }

    public static void addContact() {
        System.out.println("Enter the name of your contact: ");
        name = scanner.nextLine();
        System.out.println("Enter the number of your contact: ");
        number = scanner.nextLine();
        contact = new Contact(name, number);

        if (myPhone.queryContact(contact.getName()) != null) {
            System.out.println("Contact already on file.");
        }
        System.out.println(contact.getName() + " added to contact list.\n");
        myPhone.addContact(contact);
    }

    public static void updateContact() {
        System.out.println("Enter the name of your contact: ");
        name = scanner.nextLine();
        Contact oldContact = myPhone.queryContact(name);
        System.out.println("Enter the new name: ");
        name = scanner.next();
        System.out.println("Enter the new phone number: ");
        number = scanner.nextLine();
        Contact newContact = new Contact(name, number);
        myPhone.updateContact(oldContact, newContact);
    }

    public static void removeContact() {
        System.out.println("Enter the name of your contact: ");
        name = scanner.nextLine();
        contact = myPhone.queryContact(name);
        myPhone.removeContact(contact);
    }

    public static void searchContact() {
        System.out.println("Enter the name of the contact you wish to search: ");
        name = scanner.nextLine();
        contact = myPhone.queryContact(name);
        System.out.println("Name: " + contact.getName() + " Phone Number: " + contact.getNumber());
    }
}