package com.crypto;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ClassEncryption {
	
	public static void main(String[] args) throws Exception{
		String path = "C:\\crypto";
		String classname = "CoreClass";
		String algorithm = "AES";
		byte[] key = {75, 110, -45, -61, 101, -103, -26, -25, 55, -70, 19, 51, 66, -91, -35, 19}; //128 bit key
		
		/*
		//activate this block to generate random key
		KeyGenerator generator = KeyGenerator.getInstance(algorithm);
		generator.init(128); //generate 128 bit key
		SecretKey secretKey = generator.generateKey();
		byte[] key = secretKey.getEncoded();
		*/
		
		System.out.println(Arrays.toString(key));
		encrypt(path, classname, algorithm, key);
	}
	
	public static void encrypt(String path, String classname, String algorithm, byte[] key) throws Exception{
		Path file = Paths.get(path+"\\"+classname+".class");
		byte[] content = Files.readAllBytes(file);
		Cipher encryption = Cipher.getInstance(algorithm);
		encryption.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, 0, key.length, algorithm));
		byte[] encryptedContent = encryption.doFinal(content);
		writeToFile(path, classname, encryptedContent);
	}
	
	public static void writeToFile(String path, String filename, byte[] content) throws Exception{
		FileOutputStream out = new FileOutputStream(path+"\\encrypted\\"+filename+".class");
		out.write(content);
		out.close();
	}

}
