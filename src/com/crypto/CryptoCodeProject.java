package com.crypto;

/**
 * @author Sefik Ilkin Serengil
 * 
 */

import java.lang.reflect.Method;
import java.util.Arrays;

public class CryptoCodeProject {
	
	public static void main(String[] args) throws Exception{
		
		String path = "C:\\crypto\\encrypted"; //source of encrypted file
		String classname = "CoreClass"; //name of encrypted file
		
		String algorithm = "AES";
		
		byte[] key = {75, 110, -45, -61, 101, -103, -26, -25, 55, -70, 19, 51, 66, -91, -35, 19}; //128 bit key
		
		EncryptedClassLoader myClassLoader = new EncryptedClassLoader();
		Class dynamicClass = myClassLoader.findClass(path, classname, algorithm, key);
		
		Method m = dynamicClass.getMethod("main", String[].class);
		m.invoke(null, new Object[] {null});
		
	}

}
