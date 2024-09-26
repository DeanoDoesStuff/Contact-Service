package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Contact.Contact;

class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
    }
    
    @Test
    public void testInvalidContactID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid contact ID", exception.getMessage());
    }
    
    @Test
    public void testNullContactID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid contact ID", exception.getMessage());
    }
    
    @Test
    public void testInvalidFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Johnathanan", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid first name", exception.getMessage());
    }
    
    @Test
    public void testNullFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid first name", exception.getMessage());
    }
    
    @Test
    public void testInvalidLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Johnathan", "DoeCervidae", "1234567890", "123 Main St");
        });
        assertEquals("Invalid last name", exception.getMessage());
    }
    
    @Test
    public void testInvalidNumberBig() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Johnathan", "Doe", "1234567890123", "123 Main St");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }
    
    @Test
    public void testInvalidNumberSmall() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Johnathan", "Doe", "1234567", "123 Main St");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }
    
    @Test
    public void testInvalidAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Johnathan", "Doe", "1234567890", "1234567890123456789012345678901234567890 Main St");
        });
        assertEquals("Invalid address", exception.getMessage());
    }

}
