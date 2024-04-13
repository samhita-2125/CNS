import java.util.Scanner;

public class OneTimePad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Plain Text: ");
        String plainText = scanner.nextLine();
        System.out.print("Enter Key: ");
        String key = scanner.nextLine();

        String cipherText = encrypt(plainText, key);
        System.out.println("Cipher Text: " + cipherText);

        String decryptedText = decrypt(cipherText, key);
        System.out.println("Decrypted Text: " + decryptedText);
    }

    private static String encrypt(String plainText, String key) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            int encryptedChar = (plainText.charAt(i) + key.charAt(i % key.length())) % 128;
            encryptedText.append((char) encryptedChar);
        }
        return encryptedText.toString();
    }

    private static String decrypt(String cipherText, String key) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            int decryptedChar = (cipherText.charAt(i) - key.charAt(i % key.length()) + 128) % 128;
            decryptedText.append((char) decryptedChar);
        }
        return decryptedText.toString();
    }
}
