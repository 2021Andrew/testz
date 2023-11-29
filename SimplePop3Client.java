import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SimplePop3Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("pop.gmail.com", 995)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Read the welcome message
            readResponse(reader);

            // Send user and password
            sendCommand(writer, "USER your_email@gmail.com");
            readResponse(reader);

            sendCommand(writer, "PASS your_password");
            readResponse(reader);

            // List messages
            sendCommand(writer, "LIST");
            readResponse(reader);

            // Retrieve a specific message (replace MESSAGE_NUMBER with the actual message number)
            sendCommand(writer, "RETR MESSAGE_NUMBER");
            readResponse(reader);

            // Quit
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

    private static void readResponse(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Received: " + line);
            if (line.equals(".")) {
                break;
            }
        }
    }
}
