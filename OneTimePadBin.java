import java.util.Scanner;

public class OneTimePadBin {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Plain Text:");
        String word = sc.nextLine();
        System.out.println("The Plain Text word is:" + word);
        System.out.println("Enter Key word:");
        String key = sc.nextLine();
        System.out.println("The key word is:" + key);
        String binaryWord = BinaryXOR.wordToBinary(word);
        String binaryKey = BinaryXOR.wordToBinary(key);
        System.out.println("Word in Binary :" + binaryWord);
        System.out.println("Key in Binary :" + binaryKey);
        while (binaryKey.length() < binaryWord.length()) {
            binaryKey += binaryKey;
        }
        String resultBinary = BinaryXOR.XorBinaryStrings(binaryWord, binaryKey);
        System.out.println("Result in Xor:" + resultBinary);
    }
}

class BinaryXOR {
    public static String wordToBinary(String word) {
        StringBuilder binaryString = new StringBuilder();
        for (char c : word.toCharArray()) {
            String binary = Integer.toBinaryString((int) c); // Cast char to int for ASCII value
            binaryString.append(String.format("%8s", binary).replace(' ', '0'));
        }
        return binaryString.toString();
    }

    public static String XorBinaryStrings(String bin1, String bin2) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < bin1.length(); i++) {
            result.append(bin1.charAt(i) ^ bin2.charAt(i));
        }
        return result.toString();
    }
}

 
 