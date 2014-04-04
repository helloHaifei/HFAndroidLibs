package com.haifei.util.log;

import java.io.File;


import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

/**
 * 
 * @author haifei.zhang
 * @date 2013-8-1
 */
public class AppInfoLog {
	
	public static String TAG ="AppInfoLog" ;

	@SuppressWarnings("deprecation")
	public static  long getAvailableInternalMemorySize() {
		File path = Environment.getDataDirectory();
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long availableBlocks = stat.getAvailableBlocks();
		return availableBlocks * blockSize;
	}

	// 这个是手机内存的总空间大小

	@SuppressWarnings("deprecation")
	public static  long getTotalInternalMemorySize() {
		File path = Environment.getDataDirectory();
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long totalBlocks = stat.getBlockCount();
		return totalBlocks * blockSize;
	}
	
	/*public static int printMemorySize() {
		//return printMemorySize(MyApplication.getAppContext());
	}
*/
	public static int printMemorySize(Context context) {
		ActivityManager activityManager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		int memorySize = activityManager.getMemoryClass();
		IWLog.d(TAG, "application can use memory size is:" + memorySize);
		return memorySize;
	}

	
}
