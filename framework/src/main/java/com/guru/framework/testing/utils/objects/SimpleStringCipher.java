package com.guru.framework.testing.utils.objects;



import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
/**
 * A simple text cipher to encrypt/decrypt a string using AES encryption.
 */
public class SimpleStringCipher {
 private static final Logger logger = Logger.getLogger(SimpleStringCipher.class.getName());
	
 private static byte[] linebreak = {}; // Remove Base64 encoder default linebreak
 private static String secret = "iaMnoTshar13my73"; // secret key length must be 16
 private static SecretKey key;
 private static Cipher cipher;
 private static Base64 coder;

 static {
 try {
     key = new SecretKeySpec(secret.getBytes(), "AES");
     cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", "SunJCE");
     coder = new Base64(32,linebreak,true);
 } catch (Throwable t) {
	 logger.log(Level.SEVERE, t.getMessage());
 }
 }

 public static synchronized String encrypt(final String plainText) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        final byte[] cipherText = cipher.doFinal(plainText.getBytes());
        return  new String(coder.encode(cipherText));
 }

 public static synchronized String decrypt(final String codedText) throws Exception {
	 final  byte[] encypted = coder.decode(codedText.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, key);
        final byte[] decrypted = cipher.doFinal(encypted);  
        return new String(decrypted);
 }
 
 public static void main(final String[] args) throws Exception {
	 final String encrypted = encrypt("odms_user3");
	System.out.println("Encrypted:" + encrypted);
	System.out.println("Decrypted: " + decrypt(encrypted));
 }

}