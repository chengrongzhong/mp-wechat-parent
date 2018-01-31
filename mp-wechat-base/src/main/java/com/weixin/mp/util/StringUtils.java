package com.weixin.mp.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class StringUtils {

	public static String arrayToDelimitedString(Object[] arr, String delim) {
		if (arr == null || arr.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) {
				sb.append(delim);
			}
			sb.append(arr[i]);
		}
		return sb.toString();
	}

	public static String getLocalIp(){
		try {
			InetAddress res = InetAddress.getLocalHost();
			String ip = res.getHostAddress();
			return ip;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}

//	public static void main(String[] args){
//		System.out.println(StringUtils.getLocalIp());
//	}
}
