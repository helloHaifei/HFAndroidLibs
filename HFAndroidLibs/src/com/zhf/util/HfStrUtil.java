package com.zhf.util;

import java.util.ArrayList;
import java.util.List;

public class HfStrUtil {

	/**
	 * 将字符串源，转换成List
	 * @param source 字符串
	 * @param s 分隔符
	 * @return ArrayList<String> 
	 */
	public static ArrayList<String> getList(String source,String s){
		String[] arr = source.split(s);
		ArrayList<String> list = new ArrayList<String>();
		for (String string : arr) {
			list.add(string);
		}
		return list;
	}
}
