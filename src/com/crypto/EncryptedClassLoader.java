package com.crypto;

/**
 * @author Sefik Ilkin Serengil
 * 
 */

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptedClassLoader extends ClassLoader{
	
	public Class findClass(String path, String name, String algorithm, byte[] key) throws Exception{
		byte[] b = loadClassData(path, name, algorithm, key);
        return defineClass(name, b, 0, b.length);
    }
	
	private byte[] loadClassData(String path, String name, String algorithm, byte[] key) throws Exception {
		Path file = Paths.get(path+"\\"+name+".class");
		byte[] encryptedContent = Files.readAllBytes(file);
		//System.out.println(new String(encryptedContent));
		
		Cipher decryption = Cipher.getInstance(algorithm);
		decryption.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, 0, key.length, algorithm));
		byte[] decryptedContent = decryption.doFinal(encryptedContent);
		//System.out.println(new String(decryptedContent));
		
		return decryptedContent;
    }
}
