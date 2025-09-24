import java.util.ArrayList;
import java.util.List;

public class BuddyInfo {

    private String name;
    private String address;
    private String phone_number;

    public BuddyInfo(String name, String address, String phone_number) {
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        BuddyInfo buddy = new BuddyInfo("Bob", "100 Rideau Crescent", "123-456-7890");
        System.out.println("Hello" + buddy.getName());
    }
}

