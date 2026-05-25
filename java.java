public class Message {
    
    // Core attributes required by the assignment brief
    private String messagePayload;
    private String recipientCellNumber;
    private boolean isSent;
    private boolean isReceived;
    private boolean isRead;

    /**
     * Constructor to create a brand-new message object.
     * By default, a newly sent message has left the device (isSent = true),
     * but hasn't reached the target or been read yet.
     */
    public Message(String messagePayload, String recipientCellNumber) {
        this.messagePayload = messagePayload;
        this.recipientCellNumber = recipientCellNumber;
        this.isSent = true;         // Single grey tick equivalent
        this.isReceived = false;    // Double grey tick equivalent
        this.isRead = false;        // Double blue tick equivalent
    }

    // --- Getters and Setters ---
    
    public String getMessagePayload() {
        return messagePayload;
    }

    public String getRecipientCellNumber() {
        return recipientCellNumber;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        this.isSent = sent;
    }

    public boolean isReceived() {
        return isReceived;
    }

    public void setReceived(boolean received) {
        this.isReceived = received;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        this.isRead = read;
    }

    /**
     * Helper method to return a user-friendly text representation of the ticks.
     */
    public String getStatusString() {
        if (isRead) {
            return "READ (✓✓ - Blue)";
        } else if (isReceived) {
            return "RECEIVED (✓✓ - Grey)";
        } else if (isSent) {
            return "SENT (✓ - Grey)";
        }
        return "PENDING";
    }
}