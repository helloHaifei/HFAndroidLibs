package com.zhf.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

public class FileUtil {

	/**
	 * 从raw中读文件
	 * @return
	 */
	public String getFromRaw(Context context, int rawResource) {
		try {
			InputStreamReader inputReader = new InputStreamReader(context
					.getResources().openRawResource(rawResource));
			BufferedReader bufReader = new BufferedReader(inputReader);
			String line = "";
			String Result = "";
			while ((line = bufReader.readLine()) != null)
				Result += line;
			return Result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 从assets读取
	 */
	public String getFromAssets(Context context, String fileName) {
		try {
			InputStreamReader inputReader = new InputStreamReader(context
					.getResources().getAssets().open(fileName));
			BufferedReader bufReader = new BufferedReader(inputReader);
			String line = "";
			String Result = "";
			while ((line = bufReader.readLine()) != null)
				Result += line;
			return Result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	/**
	 * 从相册得到的url转换为SD卡中图片路径
	 */
	public static String getPath(Context context,Uri uri) {
		/*if(AbStrUtil.isEmpty(uri.getAuthority())){
			return null;
		}*/
		String[] projection = { MediaStore.Images.Media.DATA };
		Cursor cursor = ((Activity) context).managedQuery(uri, projection, null, null, null);
		int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		String path = cursor.getString(column_index);
		return path;
	}
}
