import javax.swing.*;
import java.io.*;
import java.util.*;

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
        try (FileOutputStream fos = new FileOutputStream("addressBook.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
            System.out.println("File saved successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String data = "";
        for (int i = 0; i < this.size(); i++) {
            data += this.getElementAt(i).toString();
        }

        try (FileWriter fw = new FileWriter(fileName); BufferedWriter bw = new BufferedWriter(fw)) {
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
            ArrayList<String> dataList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                addressBook.addBuddy(BuddyInfo.importBuddyInfo(line));
            }
            return addressBook;
        }
    }
}