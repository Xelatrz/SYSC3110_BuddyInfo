public class BuddyInfo {

    private String name;
    private String address;
    private String phoneNumber;

    public BuddyInfo(String name, String address, String phone_number) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phone_number;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return name + "#" + address + "#" + phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuddyInfo)) return false;
        BuddyInfo buddy = (BuddyInfo) o;
        return name.equals(buddy.name) && address.equals(buddy.address) && phoneNumber.equals(buddy.phoneNumber);
    }

    public static BuddyInfo importBuddyInfo(String line) {
        String[] parts = line.split("#");
        return new BuddyInfo(parts[0], parts[1], parts[2]);
    }
}

