package com.zhf.util;

public class StringUtil {

	public static boolean isValid(String str) {
		if (str == null || str.length() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		} else {
			return false;
		}
	}
}