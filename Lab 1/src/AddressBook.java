import java.util.ArrayList;
import

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
        BuddyInfo buddy = new BuddyInfo("Tom", "Carleton", "613");
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy);
        addressBook.removeBuddy(buddy);
        System.out.println("Address Books");
    }
}
