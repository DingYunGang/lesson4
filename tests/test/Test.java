package test;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import android.util.Log;

import com.example.lesson4.MyDbHelper;

public class Test extends AndroidTestCase {

	public void testDbOpen() {

		// ���췽��
		MyDbHelper db = new MyDbHelper(getContext(), "stu.db", null, 1);

		// ����Ǵ������ݿ⣬��ִ��onCreate����
		// ����Ǵ����ݿ⣬��ִ��onCreate����
		SQLiteDatabase cmd = db.getWritableDatabase();

	}

	public void testAdd() {
		// ���췽��
		MyDbHelper db = new MyDbHelper(getContext(), "stu.db", null, 1);
		SQLiteDatabase cmd = db.getWritableDatabase();

		for (int i = 0; i < 10; i++) {
			String sql = "insert into stuinfo values(null, 'ANiu" + i
					+ "', '��')";
			cmd.execSQL(sql);
		}

	}

	// ��ѯ

	public void testFind() {

		// ���췽��
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
