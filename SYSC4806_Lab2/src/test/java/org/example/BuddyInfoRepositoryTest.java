package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class BuddyInfoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BuddyInfoRepository buddies;

    @Test
    public void testFindByPhoneNumber() {
        BuddyInfo buddy = new BuddyInfo("Kaden", "123");
        entityManager.persist(buddy);

        List<BuddyInfo> findByPhoneNumber = buddies.findByPhoneNumber(buddy.getPhoneNumber());

        assertThat(findByPhoneNumber).extracting(BuddyInfo::getPhoneNumber).containsOnly(buddy.getPhoneNumber());
    }

    @Test
    public void testFindByName() {
        BuddyInfo buddyInfo = new BuddyInfo("Josh", "987");
        entityManager.persist(buddyInfo);

        List<BuddyInfo> findByName = buddies.findByName(buddyInfo.getName());

        assertThat(findByName).extracting(BuddyInfo::getName).containsOnly(buddyInfo.getName());
    }

    @Test
    public void testFindById() {
        BuddyInfo buddyInfo = new BuddyInfo("Matt", "024");
        entityManager.persist(buddyInfo);

        Optional<BuddyInfo> found = buddies.findById(buddyInfo.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getId()).isEqualTo(buddyInfo.getId());
    }
}