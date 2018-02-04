package io.arigateaux;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already on file.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    public int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            myContacts.remove(contact);
            return true;
        }
        System.out.println("Contact not on file");
        return false;
    }

    public void showContacts() {
        for (Contact contact : myContacts) {
            System.out.printf("%s (%s)\n\n", contact.getName(), contact.getNumber());
        }
    }

}
