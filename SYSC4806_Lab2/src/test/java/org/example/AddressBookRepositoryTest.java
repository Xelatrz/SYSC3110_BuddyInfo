package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;

@DataJpaTest
class AddressBookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AddressBookRepository addressBooks;

    @Test
    public void testFindById() {
        AddressBook addressBook = new AddressBook();
        entityManager.persist(addressBook);

        Optional<AddressBook> found = addressBooks.findById(addressBook.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getId()).isEqualTo(addressBook.getId());
    }

    @Test
    public void testAddedBuddies() {
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(new BuddyInfo("Kaden", "123"));
        addressBook.addBuddy(new BuddyInfo("Josh", "987"));
        entityManager.persist(addressBook);

        Optional<AddressBook> found = addressBooks.findById(addressBook.getId());
        
        assertThat(found).isPresent();
        assertThat(found.get().getBuddyList().size()).isEqualTo(2);
        assertThat(found.get().getBuddyList().get(0).getName()).isEqualTo("Kaden");
        assertThat(found.get().getBuddyList().get(1).getName()).isEqualTo("Josh");
    }
}