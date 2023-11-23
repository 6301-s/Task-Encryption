import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Encryption {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "encrypted_output.txt";
        int shiftKey = 3; // You can change this value for a different encryption algorithm

        try {
            // Read the content of the input file
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            reader.close();

            // Encrypt the content
            String encryptedContent = encrypt(content.toString(), shiftKey);

            // Write the encrypted content to the output file
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(encryptedContent);
            writer.close();
            

            System.out.println("Encryption completed. Encrypted content written to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String input, int shiftKey) {
        StringBuilder encryptedText = new StringBuilder();

        for (char character : input.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = (Character.isUpperCase(character)) ? 'A' : 'a';
                encryptedText.append((char) ((character - base + shiftKey) % 26 + base));
            } else {
                encryptedText.append(character);
            }
        }

        return encryptedText.toString();
    }
}
