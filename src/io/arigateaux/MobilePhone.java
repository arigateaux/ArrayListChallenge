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
        if (findContact(contact.getName()) != null) {
            System.out.println("Contact already on file.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    public Contact findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return contact;
            }
        }
        return null;
    }

    public boolean removeContact(Contact contact) {
        if (findContact(contact.getName()) != null) {
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

    public void showContact(Contact contact) {
        System.out.println(contact.getName() + " " + contact.getNumber());
    }

}
