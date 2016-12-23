package com.example.lesson4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * �������������
 * 1���ܹ��������ݿ⣬�������ݿ�
 * 2���ܹ�������
 * 3���ܹ�ȥִ��SQL���
 * @author lq
 *
 */
public class MyDbHelper extends SQLiteOpenHelper {

	
	/**
	 * 
	 * @param context:����
	 * @param name:���ݿ������
	 * @param factory:null
	 * @param version:���ݿ�İ汾��
	 * 
	 * ������ݿ�û���򴴽�һ������������
	 */
	public MyDbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		Log.i("test", "���췽��");
		
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		Log.i("test", "��������");
		
		
		//�������λ��
//		String sql ="create table stuinfo(_id integer primary key autoincrement, _name,_sex)";
		String sql ="create table stuinfo(_id integer primary key autoincrement, name varchar2, p varchar2)";
		
		arg0.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		Log.i("test", "��������");
		
	}
	
	

}
