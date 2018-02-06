package io.arigateaux;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;
    private boolean isRunning = false;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public void startupPhone() {
        System.out.println("Phone starting up...");
        isRunning = true;
    }

    public void shutdownPhone() {
        System.out.println("Phone shutting down...");
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean addContact(Contact contact) {
        if (findContact(contact) >= 0) {
            System.out.println("Contact already on file.");
            return false;
        }
        System.out.println(contact.getName() + " added to contact list.\n");
        myContacts.add(contact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        String contactName = contact.getName();
        if (findContact(contactName) >= 0) {
            System.out.println(contact.getName() + " was deleted.");
            myContacts.remove(contact);
            return true;
        }
        return false;
    }

    public void updateContact(Contact oldContact, Contact newContact) {
        int oldContactPosition = findContact(oldContact);
        if (oldContactPosition < 0)
            System.out.println(oldContact.getName() + " could not be found.");
        myContacts.set(oldContactPosition, newContact);
        System.out.println(oldContact.getName() + " replaced with " + newContact.getName());
    }

    public void showContacts() {
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " " + contact.getNumber());
        }
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(contactName))
                return i;
        }
        return -1;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String contactName) {
        int contactPosition = findContact(contactName);
        if (findContact(contactName) >= 0) {
            return myContacts.get(contactPosition);
        }
        return null;
    }
}
