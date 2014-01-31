package com.example.yw2_counter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterName extends Activity {
	public EditText editName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_name);
		editName = (EditText) findViewById(R.id.edit_message);
		Button save = (Button) findViewById(R.id.button_save);
		save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String counterName = editName.getText().toString();
				saveInFile(counterName);
				finish();
			}
		});

	}
	
	protected static final String FILENAME1 = "file1.sav";

	protected void saveInFile(String counterName) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = openFileOutput(FILENAME1,
					Context.MODE_PRIVATE);
			fos.write(new String(counterName + "\n").getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_list:
	            openList();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	private void openList() {
		// TODO Auto-generated method stub
		Intent intent = new Intent (this,CounterList.class);
		startActivity(intent);
	}

}
