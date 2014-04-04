package com.haifei.util.log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.os.Environment;
import android.util.Log;


/*
 * LOG模块
 *       
 * author: haifei.zhang
 * */
/**
 * @author  haifei.zhang
 */
public final class IWLog {

	private static Date date;
	private static SimpleDateFormat dateDf;
	
	private final static String baseTag = "";

	private static boolean logToFile = false; //设置是否输入到文件开关

	// private static String sdcardDir = "/mnt/sdcard";
	// private static String fileName = "";

	/**
	 */
	private static LogWriter mLogWriter;

	private IWLog() {

	}
	
	/*public static void i(String msg){
		StackTraceElement st = new Throwable().getStackTrace()[1];
		String tag = st.getClassName() ;
		msg = st.getMethodName()+ "()<" + st.getLineNumber() + ">" + msg;
		print('i', tag, msg);
		
	}*/
	public static void d(String msg) {
		d("",msg);
	}
	public static void d(String tag, String msg) {
		String t = baseTag + tag;
		print('d', t, msg);
	}
	public static void i(String msg) {
		i("",msg);
	}
	public static void i(String tag, String msg) {
		String t = baseTag + tag;
		print('i', t, msg);
	}
	
	public static void e(String msg) {
		e("",msg);
	}
	public static void e(String tag, String msg) {
		String t = baseTag + tag;
		print('e', t, msg);
	}
	public static void v(String tag, String msg) {
		String t = baseTag + tag;
		print('v', t, msg);
	}
	public static void w(String msg) {
		w("",msg);
	}
	public static void w(String tag, String msg) {
		String t = baseTag + tag;
		print('w', t, msg);
	}
	private static void print(char methodName, String tag, String msg) {

		//tag = getCurrentTime()+"-"+tag;

		if (logToFile) {
			writeToFile(methodName, tag, msg);

		} else {
			switch (methodName) {
			case 'd':
				Log.d(tag, msg);
				break;
			case 'e':
				Log.e(tag, msg);
				break;
			case 'i':
				Log.i(tag, msg);
				break;
			case 'v':
				Log.v(tag, msg);
				break;
			case 'w':
				Log.w(tag, msg);
				break;
			
			}
		}
	}

	private static void writeToFile(char methodName, String tag, String msg) {
		if (mLogWriter != null) {
			String log = tag +":"+ msg;
			try {
				mLogWriter.appendFile(log);
			} catch (IOException e) {
				e.printStackTrace();
				Log.e(baseTag,"error!!! write log file fail");
			}

		} else {
			/* 这里修改文件名*/
			SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd",Locale.CHINA);
			//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
			String fileName = "lottery-" + df.format(new Date()) + ".txt";
			try {
				File logf = new File(Environment.getExternalStorageDirectory()
						+ File.separator + fileName);
				mLogWriter = LogWriter.open(logf.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
				Log.e(baseTag,"error!!! create log file fail");
			}
		}

	}
	public static String getCurrentTime() {
		date = new Date();
		dateDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
		String dateStr = dateDf.format(date);
		return dateStr;
	}

}