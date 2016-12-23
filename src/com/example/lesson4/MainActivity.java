package com.example.lesson4;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText et_name;
	EditText pwd;
	

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et_name = (EditText) findViewById(R.id.et_name);
		pwd = (EditText) findViewById(R.id.pwd);
		
		 
	
		
	}
	
public void reg1(View view){
	
	
	Intent inten1 = new Intent();
	inten1.setClass(MainActivity.this, ZMainActivity.class);
	startActivity(inten1);
}
	
	public void save(View view) {
		String name = et_name.getText().toString();
		String p = pwd.getText().toString();
		MyDbHelper db = new MyDbHelper(this, "stu.db", null, 1);
		SQLiteDatabase cmd = db.getWritableDatabase();
		String sql = "select * from stuinfo where name='"+name+"' and p='"+p+"'";
		Cursor cursor = cmd.rawQuery(sql, null);
		if (cursor.moveToNext()) {
			
			Intent intent2 = new Intent();
			intent2.setClass(MainActivity.this, DActivity.class);
			startActivity(intent2);
		} else {
			Toast.makeText(this, "用户名和密码错误", Toast.LENGTH_LONG).show();
		}
		cursor.close();

	}


	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
