package ke.co.cnjumah;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Cipher {

    private String message;
    private int  encryptionKey;
    private int input;
    private String strInput;

    private String readFile;
    private int  decryptionKey;
    private String decryptionMessage;
    public static final  String alpha = "abcdefghijklmnopqrstuvwxyz";

    public String encrypt (String message, int encryptionKey) {
         message = message.toLowerCase();
         String cipherText = "";

        for (int i = 0; i < message.length(); i++) {
            int charPosition = alpha.indexOf(message.charAt(i));
            int keyVal = (encryptionKey + charPosition) % 26;
            char replaceVal = alpha.charAt(keyVal);
            cipherText = cipherText + replaceVal;
        }
        return cipherText;

    }

    public String decrypt (String decryptionMessage, int decryptionKey) {
        decryptionMessage = decryptionMessage.toLowerCase();
        String deCipheredText = "";

        for (int i = 0; i < decryptionMessage.length(); i++) {
            int charPosition = alpha.indexOf(decryptionMessage.charAt(i));
            int keyVal = (charPosition - decryptionKey) % 26;
            if (keyVal < 0) {
                keyVal = alpha.length() + keyVal;
            }
            char replaceVal = alpha.charAt(keyVal);
            deCipheredText = deCipheredText + replaceVal;
        }
        return deCipheredText;


    }

    public String getMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String to Encrypt : ");
        if(sc.hasNext("[A-Za-z]*")) {
            strInput = sc.next();
            message = strInput;
        }else {
             System.out.println("ONLY STRING CHARACTERS ACCEPTED!!! ");
             getMessage();
        }
        //break;
       //message = strInput;
        return message;
    }

    public int getEncryptionKey() {
        Scanner scKey = new Scanner(System.in);
        System.out.println("Enter Key to use in Encryption : ");
        if (scKey.hasNextInt()) {
            input = scKey.nextInt();
            if (input < 0 || input > 25) {
                System.out.println("Please Enter Values Between 1 AND 25 ONLY!!!");
                getEncryptionKey();
            } else {
                encryptionKey = input;
            }

        }else {
            System.out.println("Only Integer VALUES ACCEPTED!!!!");
            }
        return encryptionKey;
    }

    public String getDecryptionMessage() {
        Scanner scDec = new Scanner(System.in);
        System.out.println("Enter String to Decrypt : ");
        decryptionMessage = scDec.next();
        return decryptionMessage;
    }

    public int getDecryptionKey() {
        Scanner scDeKey = new Scanner(System.in);
        System.out.println("Enter Key to use in Decryption : ");
        decryptionKey = scDeKey.nextInt();
        return decryptionKey;
    }

    public String readFromTextFile() throws IOException {
        File myFile = new File("/home/cjuma/JAVA/projects/week-1/src/main/resources/textFile.txt");
        Scanner scRead = new Scanner(myFile);
        while (scRead.hasNextLine()) {
            readFile = scRead.nextLine();
        }
        return readFile;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setEncryptionKey(int encryptionKey) {
        this.encryptionKey = encryptionKey;
    }
}
