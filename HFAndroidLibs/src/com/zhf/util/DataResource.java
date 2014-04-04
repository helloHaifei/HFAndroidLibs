package com.zhf.util;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;

/**
 * 数据和 resource数据的中间类
 * 
 * @author fei
 * 
 */
public class DataResource {

	static List<ResModel> list;
	static String[] nameArr;
	static int[] valueArr;
	
	static DataResource mDataResource;
	
	//static Context context;
	
	public static DataResource getInstance(Context context,int resArrayName, int resArrayValue){
		if(mDataResource == null){
			mDataResource = new DataResource(context);
		}
	
		nameArr = context.getResources().getStringArray(resArrayName);

		valueArr = context.getResources().getIntArray(resArrayValue);
		
		list.clear();
		for (int i = 0; i < nameArr.length; i++) {
			list.add(new ResModel(nameArr[i], valueArr[i], i));
		}

		return mDataResource;
	}

	/**
	 * 
	 * @param resArrayName
	 *            R.array.
	 * @param resArrayValue
	 *            R.array.
	 */
	public DataResource(Context context) {

		list = new ArrayList<DataResource.ResModel>();
	}
	
	/**
	 * 根据名字取值
	 * @param name
	 * @return
	 */
	public int getValue(String name){
		for (int i = 0; i<list.size(); i++) {
			if(name.equals(list.get(i).name)){
				return i;
			}
		}
		return -1;
	}
	/**
	 * 根据值取名字
	 * @param value
	 * @return
	 */
	public String getName(int value){
		for (int i = 0; i<list.size(); i++) {
			if(value == list.get(i).value){
				return list.get(i).name;
			}
		}
		return "";
	}
	
	public List<ResModel> getResModelList() {
		return list;
	}

	public String[] getNameArr() {
		return nameArr;
	}

	public int[] getValueArr() {
		return valueArr;
	}
	
	public static class ResModel {
		public String name;
		public int value;
		public int position;

		public ResModel(String name, int value, int position) {
			this.name = name;
			this.value = value;
			this.position = position;
		}
	}
	
	
}
