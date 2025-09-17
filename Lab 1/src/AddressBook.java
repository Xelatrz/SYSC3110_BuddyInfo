import java.util.ArrayList;

public class AddressBook {

    private BuddyInfo buddyInfo;
    private ArrayList<BuddyInfo> buddyList

    public AddressBook() {
        ArrayList<BuddyInfo> buddyList = new ArrayList<BuddyInfo>();
    }
    public void addBuddy(BuddyInfo buddyInfo) {
        buddyList.add(buddyInfo);
    }

    public void removeBuddy(BuddyInfo buddyInfo) {
        buddyList.remove(buddyInfo);
    }

    public static void main(String[] args) {
        System.out.println("Address Book");
    }
}
