import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SimpleSmtpClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("smtp.gmail.com", 587)) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            InputStreamReader reader = new InputStreamReader(socket.getInputStream());

            // Read the welcome message
            readResponse(reader);

            // Send EHLO
            sendCommand(writer, "EHLO localhost");
            readResponse(reader);

            // Start TLS
            sendCommand(writer, "STARTTLS");
            readResponse(reader);

            // Establish TLS connection
            // (In a real-world scenario, you would need to enable SSL/TLS and handle certificate validation)
            socket.close();
            Socket securedSocket = new Socket("smtp.gmail.com", 587);
            writer = new BufferedWriter(new OutputStreamWriter(securedSocket.getOutputStream()));
            reader = new InputStreamReader(securedSocket.getInputStream());

            // EHLO again after starting TLS
            sendCommand(writer, "EHLO localhost");
            readResponse(reader);

            // Authenticate and send email
            sendCommand(writer, "AUTH LOGIN");
            readResponse(reader);

            // Replace BASE64_ENCODED_USERNAME and BASE64_ENCODED_PASSWORD with actual values
            sendCommand(writer, "BASE64_ENCODED_USERNAME");
            readResponse(reader);

            sendCommand(writer, "BASE64_ENCODED_PASSWORD");
            readResponse(reader);

            // Send mail
            sendCommand(writer, "MAIL FROM:<your_email@gmail.com>");
            readResponse(reader);

            sendCommand(writer, "RCPT TO:<recipient_email@example.com>");
            readResponse(reader);

            sendCommand(writer, "DATA");
            readResponse(reader);

            sendCommand(writer, "Subject: Test Email\r\n\r\nHello, this is a test email.\r\n.");
            readResponse(reader);

            // Close the connection
            sendCommand(writer, "QUIT");
            readResponse(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendCommand(BufferedWriter writer, String command) throws IOException {
        System.out.println("Sending: " + command);
        writer.write(command + "\r\n");
        writer.flush();
    }

    private static void readResponse(InputStreamReader reader) throws IOException {
        char[] buffer = new char[1024];
        int bytesRead = reader.read(buffer);
        System.out.println("Received: " + new String(buffer, 0, bytesRead));
    }
}
