package test;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import android.util.Log;

import com.example.lesson4.MyDbHelper;

public class Test extends AndroidTestCase {

	public void testDbOpen() {

		// 构造方法
		MyDbHelper db = new MyDbHelper(getContext(), "stu.db", null, 1);

		// 如果是创建数据库，则执行onCreate方法
		// 如果是打开数据库，则不执行onCreate方法
		SQLiteDatabase cmd = db.getWritableDatabase();

	}

	public void testAdd() {
		// 构造方法
		MyDbHelper db = new MyDbHelper(getContext(), "stu.db", null, 1);
		SQLiteDatabase cmd = db.getWritableDatabase();

		for (int i = 0; i < 10; i++) {
			String sql = "insert into stuinfo values(null, 'ANiu" + i
					+ "', '男')";
			cmd.execSQL(sql);
		}

	}

	// 查询

	public void testFind() {

		// 构造方法
		MyDbHelper db = new MyDbHelper(getContext(), "stu.db", null, 1);
		SQLiteDatabase cmd = db.getWritableDatabase();

		
		Cursor cursor = cmd.rawQuery("select * from stuinfo", null);
		
		while(cursor.moveToNext()){
			
			int id = cursor.getInt(0);
			String name = cursor.getString(1);
			String sex = cursor.getString(2);

			Log.i("test", id+"  "+name+"  "+sex);
		}
		cursor.close();
		cmd.close();
		db.close();
		
	}

}
