package com.zhf.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

public class UriUtil {

	/**
	 * 
	 * @param uri
	 * @return
	 */
	public static String getList(Activity context, Uri uri){
		//string  myImageUrl = "content://media/external/images/media/***";  
		//Uri uri = Uri.parse(myImageUrl);  
		  
		String[] proj = { MediaStore.Images.Media.DATA };     
		Cursor actualimagecursor = context.managedQuery(uri,proj,null,null,null);    
		int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);     
		actualimagecursor.moveToFirst();     
		  
		String img_path = actualimagecursor.getString(actual_image_column_index);    
		//File file = new File(img_path);  
		//Uri fileUri = Uri.fromFile(file);  
		return img_path;
	}
	
	/*public static Uri getUri(String filePath){
	
		Uri uri =  Uri.encodedPath(filePath);
		return uri;
	}*/
}
