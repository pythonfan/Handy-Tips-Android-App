package com.example.dbandnot;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public Spinner spinnerob;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		DbRet dbretobj= new DbRet(MainActivity.this, null, null, 0);
		SQLiteDatabase ourdb = dbretobj.getReadableDatabase();
		/*
		String tip= getResult(ourdb);
		Toast t= Toast.makeText(getApplicationContext(), "Retrieved this: "+tip, Toast.LENGTH_LONG);
		t.show();
		
		*/
		Button setting= (Button)findViewById(R.id.selectButton);
	      setting.setOnClickListener(new View.OnClickListener() {
	    	  public void onClick(View v)
	    	  {
	    		  Intent settime= new Intent(MainActivity.this, FirstClass.class);
	    		  startActivity(settime);
	    		  finish();
	    	  }

	      });
	      
	      spinnerob = (Spinner) findViewById(R.id.category);
	   
	  
	   
	   
	      
	      Button go= (Button)findViewById(R.id.goButton);
	      go.setOnClickListener(new View.OnClickListener() {
	    	  public void onClick(View v)
	    	  {
	    		  String catsel= spinnerob.getSelectedItem().toString();
	    		  Intent disptip= new Intent(MainActivity.this, DispTip.class);
	    		  disptip.putExtra("catselected", catsel);
	    		  disptip.putExtra("tipsel", "0");
	    		  startActivity(disptip);
	    		  finish();
	    	  }

	      });
	      
	      Button webget= (Button)findViewById(R.id.webget);
	      webget.setOnClickListener(new View.OnClickListener() {
	    	  public void onClick(View v)
	    	  {
	    		  String catsel= spinnerob.getSelectedItem().toString();
	    		  Intent disptip= new Intent(MainActivity.this, WebActivity.class).putExtra("catselected", catsel);
	    		  startActivity(disptip);
	    		  finish();
	    	  }

	      });
	    	
	}

	

	
	

	

}
