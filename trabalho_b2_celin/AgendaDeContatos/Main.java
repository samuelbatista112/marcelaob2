public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();

        if (args.length > 0 && args[0].equals("console")) {
            ConsoleInterface console = new ConsoleInterface(manager);
            console.start();
        } else {
            SwingInterface gui = new SwingInterface(manager);
            gui.setVisible(true);
        }
    }
}
