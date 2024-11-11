import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingInterface extends JFrame {
    private ContactManager manager;
    private JTextArea contactsDisplay;

    public SwingInterface(ContactManager manager) {
        this.manager = manager;
        this.contactsDisplay = new JTextArea(10, 30);

        setTitle("Agenda de Contatos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JTextField nameField = new JTextField(20);
        JTextField phoneField = new JTextField(20);

        JButton addButton = new JButton("Adicionar Contato");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.addContact(nameField.getText(), phoneField.getText());
                nameField.setText("");
                phoneField.setText("");
                updateContactsDisplay();
            }
        });

        JButton removeButton = new JButton("Remover Contato");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.removeContact(nameField.getText());
                updateContactsDisplay();
            }
        });

        add(new JLabel("Nome:"));
        add(nameField);
        add(new JLabel("Telefone:"));
        add(phoneField);
        add(addButton);
        add(removeButton);
        add(new JScrollPane(contactsDisplay));

        updateContactsDisplay();
    }

    private void updateContactsDisplay() {
        StringBuilder displayText = new StringBuilder();
        for (Contact contact : manager.getContacts()) {
            displayText.append(contact).append("\n");
        }
        contactsDisplay.setText(displayText.toString());
    }
}
