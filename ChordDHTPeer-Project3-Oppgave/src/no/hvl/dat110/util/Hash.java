package no.hvl.dat110.util;

/**
 * project 3
 * @author Kjetil Berg, Kristoffer Vågstøl and Lars Erik Birkeland
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) {
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		// we use MD5 with 128 bits digest
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException("MD5 does not exist");
		}

		// compute the hash of the input 'entity'
		byte[] bytes = entity.getBytes(StandardCharsets.UTF_8);
		byte[] hashedBytes = md.digest(bytes);

		// convert the hash into hex format
		String bytesToHex = toHex(hashedBytes); // BUT WHY?

		// convert the hex into BigInteger
		hashint = new BigInteger(bytesToHex, 16);

		// return the BigInteger
		return hashint;
	}
	
	public static BigInteger addressSize() {
		// Task: compute the address size of MD5
		// get the digest length
		// compute the number of bits = digest length * 8
		int length = bitSize();

		// compute the address size = 2 ^ number of bits
		// return the address size
		return BigInteger.valueOf(2).pow(length);
	}
	
	public static int bitSize() {
		// find the digest length
		// int digestlen = 128;
		
		return 128*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
