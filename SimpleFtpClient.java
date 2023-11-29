import java.io.*;
import java.net.Socket;

public class SimpleFtpClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("ftp.example.com", 21);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Log in
            writer.println("USER username");
            writer.println("PASS password");

            // Request file
            writer.println("RETR filename");

            // Receive and save the file
            BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream("downloaded_file.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("226")) { // Check for end of file transfer
                    break;
                }
                fileOut.write(line.getBytes());
            }

            // Close resources
            fileOut.close();
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
