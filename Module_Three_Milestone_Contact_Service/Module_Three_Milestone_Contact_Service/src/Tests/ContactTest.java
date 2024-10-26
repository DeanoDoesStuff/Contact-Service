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
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }
    
    @Test
    public void testNullContactID() {
    	assertThrows(IllegalArgumentException.class, () -> {
    		new Contact(null, "John", "Doe", "1234567890", "123 Main St");
    	});
    }
    
    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678", "JohnNameTooLong", "Doe", "1234567890", "123 Main St");
        });
    }
    
    @Test
    public void testNullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678", null, "Doe", "1234567890", "123 Main St");
        });
    }
    
    @Test
    public void testInvalidLastName() {
    	assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("12345678", "John", "DoeNameToolLong", "1234567890", "123 Main St");
    	});
    }
    
    @Test
    public void testNullLastName() {
    	assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("12345678", "John", null, "1234567890", "123 Main St");
    	});
    }
    
    @Test
    public void testInvalidNumberBig() {
    	assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("12345678", "John", "Doe", "1234567890123456789", "123 Main St");
    	});
    }
    
    @Test
    public void testNullNumber() {
    	assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("12345678", "John", "Doe", null, "123 Main St");
    	});
    }
    
    @Test
    public void testInvalidAddress() {
    	assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("12345678", "John", "Doe", "1234567890", "123456789123456789123456789 Main St");
    	});
    }
    
    @Test
    public void testNullAddress() {
    	assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("12345678", "John", "Doe", "1234567890", null);
    	});
    }
    
    // Test the setter methods
    
    @Test
    void testSetFirstNameValid() {
        Contact contact = new Contact("12345678", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("James");
        assertEquals("James", contact.getFirstName());
    }
    
    @Test
    void testSetLastNameValid() {
        Contact contact = new Contact("12345678", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Dane");
        assertEquals("Dane", contact.getLastName());
    }
    
    @Test
    void testSetNumberValid() {
        Contact contact = new Contact("12345678", "John", "Doe", "1234567890", "123 Main St");
        contact.setNumber("1234567891");
        assertEquals("1234567891", contact.getNumber());
    }
    
    @Test
    void testSetAddressValid() {
        Contact contact = new Contact("12345678", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("321 Main St");
        assertEquals("321 Main St", contact.getAddress());
    }
}






















