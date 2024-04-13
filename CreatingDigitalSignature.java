import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Scanner;
import java.io.*;
public class CreatingDigitalSignature {
 public static void main(String args[]) throws Exception {
 //Accepting text from user
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter some text");
 String msg = sc.nextLine();
 
 //Creating KeyPair generator object
 KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
 
 //Initializing the key pair generator
 keyPairGen.initialize(2048);
 
 //Generate the pair of keys
 KeyPair pair = keyPairGen.generateKeyPair();
 
 //Getting the private key from the key pair
 PrivateKey privKey = pair.getPrivate();
 PublicKey pubKey = pair.getPublic();
 System.out.println(privKey);
 System.out.println(pubKey);
 
 //Creating a Signature object
 Signature sign = Signature.getInstance("SHA256withDSA");
 
 //Initialize the signature
 sign.initSign(privKey);
 byte[] bytes = "msg".getBytes();
 
 //Adding data to the signature
 sign.update(bytes);
 
 //Calculating the signature
 byte[] signature = sign.sign();
 
 //Printing Signature to console
 for(int i=0;i<signature.length;i++)
System.out.print(" "+signature[i]);
System.out.println();
 
//Initializing the signature verification
 sign.initVerify(pair.getPublic());
 sign.update(bytes);
 
 //Verifying the signature
 boolean bool = sign.verify(signature);
 
 if(bool) {
 System.out.println("Signature verified"); 
 } else {
 System.out.println("Signature failed");
 }
 }
}
