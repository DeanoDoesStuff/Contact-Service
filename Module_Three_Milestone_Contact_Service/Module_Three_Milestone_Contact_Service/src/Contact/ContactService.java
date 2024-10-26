package Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    // Create a list for contacts to be stored as final so the id cannot be modified
    private final List<Contact> contactList = new ArrayList<>();
    
    // Adds a new contact
    public void addContact(Contact contact) {
        if (contact != null && getContact(contact.getContactID()) == null) {
            contactList.add(contact);
        } else {
            throw new IllegalArgumentException("Contact already exists or is null");
        }
    }
    
    // Deletes a contact by Unique ID
    public void deleteContact(String contactID) {
        Contact contact = getContact(contactID);
        if (contact != null) {
            contactList.remove(contact);
        } else {
            throw new IllegalArgumentException("Contact with ID not found");
        }
    }
    
    // Updates a contact by Unique ID
    public void updateContact(String contactID, String firstName, String lastName, String number, String address) {
        Contact contact = getContact(contactID);
        if (contact != null) {
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setNumber(number);
            contact.setAddress(address);
        } else {
            throw new IllegalArgumentException("Contact with ID not found");
        }
    }
    
    // Helper method that finds a contact by a unique ID
    private Contact getContact(String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                return contact;
            }
        }
        return null;
    }
}
