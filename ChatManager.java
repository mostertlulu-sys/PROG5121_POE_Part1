public class ChatManager {
    
    // Arrays to hold messaging details up to a fixed limit
    private Message[] messageStorage;
    private int messageCount;
    private Login loginSystem; // Link back to Part 1 for cell validation

    public ChatManager(Login loginSystem, int maxCapacity) {
        this.messageStorage = new Message[maxCapacity];
        this.messageCount = 0;
        this.loginSystem = loginSystem;
    }

    /**
     * Captures and saves a new message after validating the cell number format.
     */
    public String handleSendMessage(String text, String targetCell) {
        // Tie back to Part 1 validation rule!
        if (!loginSystem.checkCellPhoneNumber(targetCell)) {
            return "Failed to send: Recipient cell phone number formatting is invalid.";
        }

        if (messageCount >= messageStorage.length) {
            return "Failed to send: Chat history storage limit reached.";
        }

        // Create and store the new message object
        Message newMessage = new Message(text, targetCell);
        messageStorage[messageCount] = newMessage;
        messageCount++;

        return "Message successfully captured and sent.";
    }

    /**
     * Simulates updating a message status (e.g., recipient opens the message).
     */
    public boolean updateMessageStatus(int index, boolean received, boolean read) {
        if (index >= 0 && index < messageCount) {
            messageStorage[index].setReceived(received);
            messageStorage[index].setRead(read);
            return true;
        }
        return false;
    }

    /**
     * Compiles a readable history report of all sent messages for the console menu.
     */
    public String getChatReport() {
        if (messageCount == 0) {
            return "No messages captured yet.";
        }

        StringBuilder report = new StringBuilder("--- CHAT DATA REPORT ---\n");
        for (int i = 0; i < messageCount; i++) {
            Message msg = messageStorage[i];
            report.append(String.format("ID: %d | To: %s | Status: %s\nText: \"%s\"\n-----------------------\n",
                    i, msg.getRecipientCellNumber(), msg.getStatusString(), msg.getMessagePayload()));
        }
        return report.toString();
    }

    // Getter for testing purposes
    public int getMessageCount() {
        return messageCount;
    }
    
    public Message getMessageAt(int index) {
        if (index >= 0 && index < messageCount) {
            return messageStorage[index];
        }
        return null;
    }
}