package com.example.lesson4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * 该类的作用有三
 * 1、能够创建数据库，升级数据库
 * 2、能够创建表
 * 3、能够去执行SQL语句
 * @author lq
 *
 */
public class MyDbHelper extends SQLiteOpenHelper {

	
	/**
	 * 
	 * @param context:环境
	 * @param name:数据库的名称
	 * @param factory:null
	 * @param version:数据库的版本号
	 * 
	 * 如果数据库没有则创建一个，如果有则打开
	 */
	public MyDbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		Log.i("test", "构造方法");
		
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		Log.i("test", "创建方法");
		
		
		//建立表的位置
//		String sql ="create table stuinfo(_id integer primary key autoincrement, _name,_sex)";
		String sql ="create table stuinfo(_id integer primary key autoincrement, name varchar2, p varchar2)";
		
		arg0.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		Log.i("test", "升级方法");
		
	}
	
	

}
