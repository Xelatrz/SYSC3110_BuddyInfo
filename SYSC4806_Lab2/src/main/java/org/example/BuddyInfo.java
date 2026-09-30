package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
