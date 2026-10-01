package org.example;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddyList;

    public AddressBook() {
        buddyList = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddyInfo) {
        if (buddyInfo != null) {
            buddyList.add(buddyInfo);
        }
    }

    public BuddyInfo removeBuddy(int index) {
        if (index >= 0 && index < buddyList.size()) {
            return buddyList.remove(index);
        }
        return null;
    }

    public BuddyInfo getBuddy(int index) {
        if (index >= 0 && index < buddyList.size()) {
            return buddyList.get(index);
        }
        return null;
    }

    public void updateBuddy(BuddyInfo buddyInfo, String newName, String newPhoneNumber) {
        if  (buddyInfo != null) {
            buddyInfo.setName(newName);
            buddyInfo.setPhoneNumber(newPhoneNumber);
        }
    }

    public Long getId() {
        return id;
    }

    public List<BuddyInfo> getBuddyList() {
        return buddyList;
    }

    @Override
    public String toString() {
        return String.format("AddressBook[id=%d, numBuddies=%d]", id, buddyList.size());
    }

    public static void main(String[] args) {
        BuddyInfo buddy = new BuddyInfo("Bob", "123-456-7890");
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy);
        System.out.println(buddy.name);
        System.out.println(buddy.phoneNumber);
        System.out.println(addressBook.getBuddy(0));
        addressBook.updateBuddy(buddy, "Bobby", "098-765-4321");
        System.out.println(buddy.name);
        System.out.println(buddy.phoneNumber);
        System.out.println(addressBook.getBuddy(0));
        System.out.println("removed: " + addressBook.removeBuddy(0).name);
        System.out.println(addressBook.getBuddy(0));
    }
}
