package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    private AddressBook addressBook;
    private BuddyInfo buddy1;
    private BuddyInfo buddy2;

    @BeforeEach
    void setUp() {
        addressBook = new AddressBook();
        buddy1 = new BuddyInfo("Bob", "123-456-7890");
        buddy2 = new BuddyInfo("Timmy", "123-123-1234");
    }

    @Test
    void addBuddy() {
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        assertEquals(buddy1, addressBook.getBuddy(0));
        assertEquals(buddy2, addressBook.getBuddy(1));
    }

    @Test
    void updateBuddy() {
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        addressBook.updateBuddy(buddy1, "Bobby", "098-765-4321");
        assertEquals(buddy1, addressBook.getBuddy(0));
        assertEquals("Bobby", buddy1.getName());
        assertEquals("098-765-4321", buddy1.getPhoneNumber());
        assertEquals(buddy2, addressBook.getBuddy(1));
        assertEquals("Timmy", buddy2.getName());
        assertEquals("123-123-1234", buddy2.getPhoneNumber());
    }

    @Test
    void removeBuddy() {
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        addressBook.removeBuddy(0);
        assertEquals(buddy2, addressBook.getBuddy(0));
    }
}