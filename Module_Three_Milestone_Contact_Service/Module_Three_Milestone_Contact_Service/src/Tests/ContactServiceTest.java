package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Contact.Contact;
import Contact.ContactService;

class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertNotNull(contactService, "The contact should be added successfully");
    }

    @Test
    public void testAddDuplicateContact() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact);
        });
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("123");
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("123");
        });
    }

    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("999");
        });
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateContact("123", "Jane", "Smith", "0987654321", "456 Erie St");
        
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getNumber());
        assertEquals("456 Erie St", contact.getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("999", "Jane", "Smith", "0987654321", "456 Erie St");
        });
    }
}
