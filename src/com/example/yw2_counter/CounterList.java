package com.example.yw2_counter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class CounterList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter_list);
	}
	
	TextView countersView;
	protected static final String FILENAME2 = "file1.sav";
	
	protected String[] loadFromFile() {
		ArrayList<String> counters = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME2);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				counters.add(line);
				line = in.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return counters.toArray(new String[counters.size()]);
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
	        case R.id.action_newCounter:
	            openNewCounter();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	private void openNewCounter() {
		// TODO Auto-generated method stub
		Intent intent = new Intent (this,EnterName.class);
		startActivity(intent);
	}

}
