import javax.swing.*;
import java.awt.*;

public class AddressBookGUI {
    private JFrame frame;
    private JList<BuddyInfo> buddyList;
    private AddressBook addressBook;

    public AddressBookGUI() {
        addressBook = new AddressBook();
        frame = new JFrame("Address Book");
        buddyList = new JList<>(addressBook);
        JScrollPane scrollPane = new JScrollPane(buddyList);
        frame.add(scrollPane);

        JMenuBar menuBar = new JMenuBar();

        JMenu addressBookMenu = new JMenu("AddressBook");
        JMenuItem newAddressBookItem = new JMenuItem("New AddressBook");
        newAddressBookItem.addActionListener(e -> addressBook.clear());
        addressBookMenu.add(newAddressBookItem);

        JMenu buddyMenu = new JMenu("BuddyInfo");
        JMenuItem addBuddyItem = new JMenuItem("Add Buddy");
        addBuddyItem.addActionListener(e -> addBuddy());
        JMenuItem removeBuddyItem = new JMenuItem("Remove Buddy");
        removeBuddyItem.addActionListener(e -> removeBuddy());

        buddyMenu.add(addBuddyItem);
        buddyMenu.add(removeBuddyItem);

        menuBar.add(addressBookMenu);
        menuBar.add(buddyMenu);
        frame.setJMenuBar(menuBar);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addBuddy() {
        String name = JOptionPane.showInputDialog(frame, "Enter Name:");
        String address = JOptionPane.showInputDialog(frame, "Enter Address:");
        String phoneNumber = JOptionPane.showInputDialog(frame, "Enter Phone Number:");

        if (name != null && address != null && phoneNumber != null) {
            addressBook.addBuddy(new BuddyInfo(name, address, phoneNumber));
        }
    }

    private void removeBuddy() {
        BuddyInfo removedBuddy = buddyList.getSelectedValue();
        if (removedBuddy != null) {
            addressBook.removeBuddy(removedBuddy);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a buddy to remove");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddressBookGUI();
            }
        });
    }
}
