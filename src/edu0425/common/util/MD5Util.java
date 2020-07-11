package edu0425.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

public class MD5Util {

	public static String textToMD5U16(String plainText) {
		String result = null;
		if (StringUtils.isBlank(plainText)) {
			return null;
		} else {
			result = textToMD5L32(plainText);
			result = result.toUpperCase().substring(8,24);
		}

		return result;
	}

	public static String textToMD5L32(String plainText) {
		String result = null;
		if (StringUtils.isBlank(plainText)) {
			return null;
		} else {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] btInput = plainText.getBytes();
				md.update(btInput);
				byte[] btResult = md.digest();
				StringBuilder sb = new StringBuilder();
				for (byte b : btResult) {
					int bt = b & 0xff;
					if (bt < 16) {
						sb.append(0);
					}
					sb.append(Integer.toHexString(bt));
				}
				result = sb.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
	public static void main(String[] args) {
		System.out.println(textToMD5L32("admin"));
		System.out.println(textToMD5U16("admin"));
	}
}
