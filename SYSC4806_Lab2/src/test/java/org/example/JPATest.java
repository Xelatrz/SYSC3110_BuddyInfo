package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JPATest {

    @Test
    public void buddyInfoJPATest() {

        BuddyInfo buddy1 = new BuddyInfo();
        buddy1.setId(1);
        buddy1.setName("Jeremy");

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setId(2);
        buddy2.setName("Ben");


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(buddy1);
        em.persist(buddy2);

        tx.commit();


        Query q = em.createQuery("SELECT b FROM BuddyInfo b ORDER BY b.id");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of buddies\n----------------");

        for (BuddyInfo b : results) {
            System.out.println(b.getName() + " (id=" + b.getId() + ")");
        }


        assertEquals(2, results.size());
        assertEquals("Jeremy", results.get(0).getName());
        assertEquals(1, results.get(0).getId());
        assertEquals("Ben", results.get(1).getName());
        assertEquals(2, results.get(1).getId());


        em.close();
        emf.close();
    }

    @Test
    public void addressBookJPATest() {

        BuddyInfo buddy1 = new BuddyInfo();
        buddy1.setId(1);
        buddy1.setName("Jeremy");

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setId(2);
        buddy2.setName("Ben");

        AddressBook addressBook = new AddressBook();
        addressBook.setId(1);
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(buddy1);
        em.persist(buddy2);
        em.persist(addressBook);

        tx.commit();


        Query q = em.createQuery("SELECT a FROM AddressBook a");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("\nList of address books\n----------------------");

        for (AddressBook a : results) {
            System.out.println("AddressBook (id=" + a.getId() + ")");

            for (BuddyInfo buddy : a.getBuddyList()) {
                System.out.println("\t" + buddy.getName() + " (id=" + buddy.getId() + ")");
            }
        }


        assertEquals(1, results.size());
        AddressBook result = results.get(0);
        assertEquals(1, result.getId());

        ArrayList<BuddyInfo> resultBuddies = result.getBuddyList();
        assertEquals(2, resultBuddies.size());
        assertEquals("Jeremy", resultBuddies.get(0).getName());
        assertEquals(1, resultBuddies.get(0).getId());
        assertEquals("Ben", resultBuddies.get(1).getName());
        assertEquals(2, resultBuddies.get(1).getId());


        em.close();
        emf.close();
    }

    @Test
    public void addressBookJPATestBonus() {

        BuddyInfo buddy1 = new BuddyInfo();
        buddy1.setId(1);
        buddy1.setName("Jeremy");

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setId(2);
        buddy2.setName("Ben");

        AddressBook addressBook = new AddressBook();
        addressBook.setId(1);
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(addressBook);

        tx.commit();


        Query q = em.createQuery("SELECT a FROM AddressBook a");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("\nList of address books\n----------------------");

        for (AddressBook a : results) {
            System.out.println("AddressBook (id=" + a.getId() + ")");

            for (BuddyInfo buddy : a.getBuddyList()) {
                System.out.println("\t" + buddy.getName() + " (id=" + buddy.getId() + ")");
            }
        }


        assertEquals(1, results.size());
        AddressBook result = results.get(0);
        assertEquals(1, result.getId());

        ArrayList<BuddyInfo> resultBuddies = result.getBuddyList();
        assertEquals(2, resultBuddies.size());
        assertEquals("Jeremy", resultBuddies.get(0).getName());
        assertEquals(1, resultBuddies.get(0).getId());
        assertEquals("Ben", resultBuddies.get(1).getName());
        assertEquals(2, resultBuddies.get(1).getId());


        em.close();
        emf.close();
    }
}
