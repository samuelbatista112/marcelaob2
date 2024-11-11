import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(String name, String phone) {
        contacts.add(new Contact(name, phone));
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void removeContact(String name) {
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
    }
}
