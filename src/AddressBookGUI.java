import javax.swing.*;
import java.awt.*;
import java.io.*;

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

        JMenuItem exportAddressBookItem = new JMenuItem("Export");
        exportAddressBookItem.addActionListener(e -> handleExport());
        addressBookMenu.add(exportAddressBookItem);

        JMenuItem importAddressBookItem = new JMenuItem("Import");
        importAddressBookItem.addActionListener(e -> handleImport());
        addressBookMenu.add(importAddressBookItem);

        JMenu buddyMenu = new JMenu("BuddyInfo");

        JMenuItem addBuddyItem = new JMenuItem("Add Buddy");
        addBuddyItem.addActionListener(e -> addBuddy());
        buddyMenu.add(addBuddyItem);

        JMenuItem removeBuddyItem = new JMenuItem("Remove Buddy");
        removeBuddyItem.addActionListener(e -> removeBuddy());
        buddyMenu.add(removeBuddyItem);

        menuBar.add(addressBookMenu);
        menuBar.add(buddyMenu);
        frame.setJMenuBar(menuBar);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void handleExport() {
        String input = JOptionPane.showInputDialog(frame, "Enter the file name: ", JOptionPane.QUESTION_MESSAGE);
        if (input != null) {
            String fileName = input + ".txt";
            addressBook.save(fileName);
        }
    }

    private void handleImport() {
        String input = JOptionPane.showInputDialog(frame, "Enter the file name: ", JOptionPane.QUESTION_MESSAGE);
        if (input != null) {
            String fileName = input + ".txt";
            try {
                AddressBook importedAddressBook = addressBook.importAddressBook(fileName);
                this.addressBook = importedAddressBook;
                buddyList.setModel(this.addressBook);
                for (int i = 0; i < addressBook.size(); i++) {
                    System.out.println(addressBook.getElementAt(i).toString());
                }
            } catch (IOException E) {
                JOptionPane.showMessageDialog(frame, E.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
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
