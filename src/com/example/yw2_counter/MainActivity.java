package com.example.yw2_counter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
	Button add;
	Button minus;
	Button reset;
	TextView counts;
	int count;
	protected static final String FILENAME = "file.sav";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		add = (Button)findViewById(R.id.buttonPlus);
		minus = (Button)findViewById(R.id.buttonMimus);
		reset = (Button)findViewById(R.id.buttonReset);
		counts = (TextView)findViewById(R.id.counterWindow);
		
		add.setOnClickListener(this);
		minus.setOnClickListener(this);
		reset.setOnClickListener(this);
		
		counts.setTextSize(70);
	}
	
	// load count from file
	protected void onStart() {
		super.onStart();
		count = loadFromFile();
		counts.setText(Integer.toString(count));
		counts.setGravity(Gravity.CENTER);
	}
	
	// actual implementation on counter
	@Override
	public void onClick(View view) {
		if (view == add) {
			count++;
			counts.setText(Integer.toString(count));
			counts.setGravity(Gravity.CENTER);
		}
		if (view == minus) {
			if (count != 0){
				count--;
				counts.setText(Integer.toString(count));
				counts.setGravity(Gravity.CENTER);
			} else {
				count = 0;
			}
			
		}if (view == reset) {
			count = 0;
			counts.setText(Integer.toString(count));
			counts.setGravity(Gravity.CENTER);
		}
		saveInFile(count);
	}
	
	// load function
	protected int loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			count = fis.read();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//save function
	protected void saveInFile(int count2) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			fos.write(count2);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// implement the action bar
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
	        case R.id.action_newCounter:
	            openNewCounter();
	            return true;
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

	private void openNewCounter() {
		// TODO Auto-generated method stub
		Intent intent = new Intent (this,EnterName.class);
		startActivity(intent);
	}
	
}
