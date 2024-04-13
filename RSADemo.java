//give the input as java RSADemo <number>
import java.math.BigInteger;
import java.security.SecureRandom;

public class RSADemo {
    private final static BigInteger ONE = new BigInteger("1");
    private final static SecureRandom RANDOM = new SecureRandom();
    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;

    // Generate an N-bit (roughly) public and private key
    RSADemo(int bitLength) {
        if (bitLength <= 0) {
            throw new IllegalArgumentException("Bit length must be positive");
        }
        
        BigInteger p = BigInteger.probablePrime(bitLength / 2, RANDOM);
        BigInteger q = BigInteger.probablePrime(bitLength / 2, RANDOM);

        BigInteger phi = (p.subtract(ONE)).multiply(q.subtract(ONE));
        
        modulus = p.multiply(q);
        publicKey = new BigInteger("65537"); // Common value in practice (2^16 + 1)
        privateKey = publicKey.modInverse(phi);
    }

    BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, modulus);
    }

    BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(privateKey, modulus);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Public Key: ").append(publicKey).append("\n");
        sb.append("Private Key: ").append(privateKey).append("\n");
        sb.append("Modulus: ").append(modulus);
        return sb.toString();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java RSADemo <bit_length>");
            return;
        }
        
        try {
            int bitLength = Integer.parseInt(args[0]);
            RSADemo rsa = new RSADemo(bitLength);
            System.out.println(rsa);

            BigInteger message = new BigInteger("8");
            BigInteger encrypted = rsa.encrypt(message);
            BigInteger decrypted = rsa.decrypt(encrypted);

            System.out.println("Message: " + message);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
        } catch (NumberFormatException e) {
            System.out.println("Invalid bit length. Please provide a valid positive integer.");
        } catch (ArithmeticException e) {
            System.out.println("Error occurred during key generation: " + e.getMessage());
        }
    }
}
