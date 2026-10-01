package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger logger = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository buddyRepo, AddressBookRepository addressRepo) {
        return (args) -> {
            // save a few buddies
            buddyRepo.save(new BuddyInfo("Jack", "214"));
            buddyRepo.save(new BuddyInfo("Chloe", "463"));
            buddyRepo.save(new BuddyInfo("Kim", "312"));
            buddyRepo.save(new BuddyInfo("David", "236"));
            buddyRepo.save(new BuddyInfo("Michelle", "673"));

            // fetch all buddies
            logger.info("Buddies found with findAll():");
            logger.info("-------------------------------");
            buddyRepo.findAll().forEach(buddyInfo -> {
                logger.info(buddyInfo.toString());
            });
            logger.info("");

            // fetch an individual buddy by ID
            BuddyInfo buddyInfo = buddyRepo.findById(1L);
            logger.info("Buddy found with findById(1L):");
            logger.info("--------------------------------");
            logger.info(buddyInfo.toString());
            logger.info("");

            // fetch buddies by phone number
            logger.info("Buddy found with findByPhoneNumber('463'):");
            logger.info("--------------------------------------------");
            buddyRepo.findByPhoneNumber("463").forEach(buddy -> {
                logger.info(buddy.toString());
            });
            logger.info("");


            // save new address book
            AddressBook addressBook = new AddressBook();
            addressBook.addBuddy(new BuddyInfo("Tom", "542"));
            addressBook.addBuddy(new BuddyInfo("Billy", "907"));
            addressBook.addBuddy(new BuddyInfo("Sarah", "184"));
            addressRepo.save(addressBook);

            // fetch all address books
            logger.info("Address books found with findAll():");
            logger.info("-------------------------------");
            addressRepo.findAll().forEach(book -> {
                logger.info(book.toString());
            });
            logger.info("");

            //fetch an individual address book by ID
            AddressBook book = addressRepo.findById(1L);
            logger.info("Address book found with findById(1L):");
            logger.info("--------------------------------");
            logger.info(book.toString());
            logger.info("");
        };
    }
}
