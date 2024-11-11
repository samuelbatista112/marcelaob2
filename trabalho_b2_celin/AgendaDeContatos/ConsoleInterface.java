import java.util.Scanner;

public class ConsoleInterface {
    private ContactManager manager;
    private Scanner scanner;

    public ConsoleInterface(ContactManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Listar Contatos");
            System.out.println("3 - Remover Contato");
            System.out.println("4 - Sair");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consome o newline

            switch (choice) {
                case 1:
                    System.out.println("Digite o nome:");
                    String name = scanner.nextLine();
                    System.out.println("Digite o telefone:");
                    String phone = scanner.nextLine();
                    manager.addContact(name, phone);
                    break;
                case 2:
                    for (Contact contact : manager.getContacts()) {
                        System.out.println(contact);
                    }
                    break;
                case 3:
                    System.out.println("Digite o nome do contato a remover:");
                    String nameToRemove = scanner.nextLine();
                    manager.removeContact(nameToRemove);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
