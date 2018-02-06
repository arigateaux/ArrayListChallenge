package io.arigateaux;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public void updateContact(Contact oldContact, Contact newContact) {
        int oldContactPosition = findContact(oldContact);
        if (oldContactPosition < 0)
            System.out.println(oldContact.getName() + " could not be found.");
        myContacts.set(oldContactPosition, newContact);
        System.out.println(oldContact.getName() + " replaced with " + newContact.getName());
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) >= 0) {
            System.out.println("Contact already on file.");
            return false;
        }
        System.out.println(contact.getName() + " added to contact list.\n");
        myContacts.add(contact);
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private boolean findContact(String contactName) {
        for (Contact contact : myContacts) {
            if (contact.getName().equals(contactName))
                return true;
        }
        return false;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public boolean removeContact(Contact contact) {
        if (findContact(contact.getName())) {
            System.out.println(contact.getName() + " was deleted.");
            myContacts.remove(contact);
            return true;
        }
        return false;
    }

    public void showContacts() {
        for (Contact contact : myContacts) {
            showContact(contact);
        }
    }

    public String showContact(Contact contact) {
        return contact.getName() + " " + contact.getNumber();

    }

}
