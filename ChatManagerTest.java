import org.junit.jupiter.api.Test;

public class ChatManagerTest {

    @Test
    public void testSuccessfulMessageCapture() {
        Login login = new Login();
        ChatManager manager = new ChatManager(login, 5);
        
        // Pass a fully formatted, valid cell number
        String outcome = manager.handleSendMessage("Hello world!", "+27838968976");
        
        assertEquals("Message successfully captured and sent.", outcome);
        assertEquals(1, manager.getMessageCount());
        assertNotNull(manager.getMessageAt(0));
    }

    @Test
    public void testFailedMessageCaptureInvalidCell() {
        Login login = new Login();
        ChatManager manager = new ChatManager(login, 5);
        
        // Pass an incorrectly formatted mobile number
        String outcome = manager.handleSendMessage("Hey there", "083123");
        
        assertTrue(outcome.contains("Failed to send"));
        assertEquals(0, manager.getMessageCount());
    }

    private void assertEquals(String message_successfully_captured_and_sent) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertNotNull(Message messageAt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertTrue(boolean contains) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}