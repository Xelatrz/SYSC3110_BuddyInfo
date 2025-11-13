import javax.swing.*;
import java.io.*;

public class AddressBook extends DefaultListModel<BuddyInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public AddressBook importAddressBook(String fileName) throws IOException {
        AddressBook addressBook = new AddressBook();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                addressBook.addBuddy(BuddyInfo.importBuddyInfo(line));
            }
            return addressBook;
        }
    }

    public void serializeAddressBook(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
        }
    }

    public static AddressBook deserializeAddressBook(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (AddressBook) ois.readObject();
        }
    }
}