package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public String name;
    public String phoneNumber;

    public BuddyInfo() {}

    public BuddyInfo(String name, String phone_number) {
        this.name = name;
        this.phoneNumber = phone_number;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("BuddyInfo[id=%d, name='%s', phoneNumber='%s']", id, name, phoneNumber);
    }
}
