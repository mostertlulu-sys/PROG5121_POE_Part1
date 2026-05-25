import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login authSystem = new Login();
        ChatManager chatSystem = new ChatManager(authSystem, 50); // Room for 50 messages

        System.out.println("=== WELCOME TO THE CHAT APPLICATION SYSTEM ===");
        
        // --- Quick Mock Registration for Demonstration ---
        // Simulating that a user logs in successfully first
        authSystem.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith", "+27838968976");
        System.out.println("System Logged In As: Kyle Smith\n");

        boolean keepingAppOpen = true;

        while (keepingAppOpen) {
            System.out.println("\nSelect a Chat Feature Option:");
            System.out.println("1) Send a New Text Message");
            System.out.println("2) View Detailed Chat Report");
            System.out.println("3) Simulate Status Updates (Mark Read/Received)");
            System.out.println("4) Exit Application");
            System.out.print("Enter choice: ");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter recipient cell number (e.g., +27838968976): ");
                    String cell = input.nextLine();
                    System.out.print("Type your message content: ");
                    String text = input.nextLine();
                    
                    String sendOutput = chatSystem.handleSendMessage(text, cell);
                    System.out.println("\n>>> " + sendOutput);
                    break;

                case "2":
                    System.out.println("\n" + chatSystem.getChatReport());
                    break;

                case "3":
                    System.out.println("\n" + chatSystem.getChatReport());
                    if (chatSystem.getMessageCount() == 0) break;
                    
                    System.out.print("Enter Message ID to update status: ");
                    int id = Integer.parseInt(input.nextLine());
                    System.out.print("Has it been delivered? (true/false): ");
                    boolean delivered = Boolean.parseBoolean(input.nextLine());
                    System.out.print("Has it been opened and read? (true/false): ");
                    boolean read = Boolean.parseBoolean(input.nextLine());

                    boolean updated = chatSystem.updateMessageStatus(id, delivered, read);
                    if (updated) {
                        System.out.println("\n>>> Message tick indicators updated cleanly!");
                    } else {
                        System.out.println("\n>>> Invalid Message ID selected.");
                    }
                    break;

                case "4":
                    System.out.println("\nThank you for using the Chat Console Application. Goodbye!");
                    keepingAppOpen = false;
                    break;

                default:
                    System.out.println("\nInvalid selection choice. Please choose 1, 2, 3, or 4.");
            }
        }
        input.close();
    }
}