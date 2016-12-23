package com.example.lesson4;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ZMainActivity extends Activity {

	EditText et_name;
	EditText pwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zmain);
		
		et_name = (EditText) findViewById(R.id.et_name);
		pwd = (EditText) findViewById(R.id.pwd);
		
	}
	
	public void sa(View view)
	{
		String name = et_name.getText().toString();
	
		String p = pwd.getText().toString();

		MyDbHelper db = new MyDbHelper(this, "stu.db", null, 1);
		SQLiteDatabase cmd = db.getWritableDatabase();

		String sql = "insert into stuinfo values(null, '"+name+"', '"+p+"')";
		cmd.execSQL(sql);
		
		Toast.makeText(this, "±£´æ³É¹¦", Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zmain, menu);
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
