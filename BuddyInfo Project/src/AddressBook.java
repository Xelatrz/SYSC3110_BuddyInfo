import java.util.ArrayList;
//test commit
public class AddressBook {

    private ArrayList<BuddyInfo> buddyList;

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
            buddyList.remove(index);
        }
        return null;
    }

    public static void main(String[] args) {
        BuddyInfo buddy = new BuddyInfo("Tom", "Carleton", "613");
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy);
        addressBook.removeBuddy(0);
        System.out.println("Address Books");
    }
}
