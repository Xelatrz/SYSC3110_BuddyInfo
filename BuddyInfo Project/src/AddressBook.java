import javax.swing.DefaultListModel;

public class AddressBook extends DefaultListModel<BuddyInfo> {

    public void addBuddy(BuddyInfo buddyInfo) {
        if (buddyInfo != null) {
            addElement(buddyInfo);
        }
    }

    public void removeBuddy(BuddyInfo buddyInfo) {
        removeElement(buddyInfo);
    }
}