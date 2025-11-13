import javax.swing.*;
import java.io.*;

public class AddressBook extends DefaultListModel<BuddyInfo> implements Serializable {

    public void addBuddy(BuddyInfo buddyInfo) {
        if (buddyInfo != null) {
            addElement(buddyInfo);
        }
    }

    public void removeBuddy(BuddyInfo buddyInfo) {
        removeElement(buddyInfo);
    }

    public void save(String fileName) {
        String data = "";
        for (int i = 0; i < this.size(); i++) {
            data += this.getElementAt(i).toString() + "\n";
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(data);
            System.out.println("Text saved successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AddressBook importAddressBook(String filePath) throws IOException {
        AddressBook addressBook = new AddressBook();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                addressBook.addBuddy(BuddyInfo.importBuddyInfo(line));
            }
            return addressBook;
        }
    }
}