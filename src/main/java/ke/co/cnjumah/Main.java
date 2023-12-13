package ke.co.cnjumah;

import java.io.IOException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
       Cipher cipher = new Cipher();
       String message = "";
       String readText = "";
       String decryptMessage = "";
       int encryptionKey = 0;
       int decryptionKey = 0;
       int OperationMode = 0;

       System.out.println("Cipher Text Encryption / Decryption System");

       //message = cipher.getMessage();
       //encryptionKey = cipher.getEncryptionKey();
       //decryptMessage = cipher.getDecryptionMessage();
       //decryptionKey = cipher.getEncryptionKey();

       System.out.println("Select Operation " +"1"+ " For Encryption : " +"2"+ " For Message Decryption : " +"3"+ " Read From Text FILE and Encrypt : ");
       Scanner OpMode = new Scanner(System.in);
       OperationMode = OpMode.nextInt();

        if(OperationMode == 1) {
            message = cipher.getMessage();
            encryptionKey = cipher.getEncryptionKey();
            System.out.println("Ciphered Text Value : " + cipher.encrypt(message,encryptionKey));
        } else if(OperationMode == 2) {
            decryptMessage = cipher.getDecryptionMessage();
            decryptionKey = cipher.getDecryptionKey();
            System.out.print("Decrypted Message Value : " + cipher.decrypt(decryptMessage,decryptionKey));

        } else if (OperationMode == 3){
            encryptionKey = cipher.getEncryptionKey();
            readText = cipher.readFromTextFile();
            System.out.println("The File Contents : " + readText);
            System.out.println(("The Encrypted Text from FILE is : " + cipher.encrypt(readText,encryptionKey)));

        }
        else {
            System.out.println("Operation Selected is INVALID!!!!");

        }

    }
}