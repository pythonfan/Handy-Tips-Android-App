package com.example.dbandnot;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dbandnot.ShakeDetector.OnShakeListener;



public class DispTip extends Activity{

	String tip;
	
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private ShakeDetector mShakeDetector;
	private SQLiteDatabase ourdb;
	
	WebView webView;
	int tipnum=0;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.disp_tip);
		
		final String catrec= getIntent().getStringExtra("catselected");
		final String tipsel= getIntent().getStringExtra("tipsel");
		Log.v("dbandnot","Got: catrec="+catrec+" tipsel: "+tipsel);
		if(!tipsel.equals("0"))
		{
			tipnum=Integer.parseInt(tipsel);
		    Log.v("dbandnot","Changing tipsel: catrec="+catrec+" tipsel: "+tipsel);  
		}
		int categ=getcatnum(catrec);
		
	DbRet dbretobj= new DbRet(DispTip.this, null, null, 0);
	ourdb = dbretobj.getReadableDatabase();
	
	tip= getResult(ourdb,categ);
	
	TextView tipstr = (TextView)findViewById(R.id.tip);
	tipstr.setText(tip);
	
	 Button nxt= (Button)findViewById(R.id.nxtButton);
     nxt.setOnClickListener(new View.OnClickListener() {
   	  public void onClick(View v)
   	  {
   		  Intent dispnxt= new Intent(DispTip.this, DispTip.class).putExtra("catselected",catrec);
   		  dispnxt.putExtra("tipsel", "0");
   		  startActivity(dispnxt);
   		  finish();
   	  }

     });
     

	mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    mShakeDetector = new ShakeDetector();
    mShakeDetector.setOnShakeListener(new OnShakeListener() {

          @Override
          public void onShake(int count) {
              /*
               * The following method, "handleShakeEvent(count):" is a stub //
               * method you would use to setup whatever you want done once the
               * device has been shook.
               */
	
        	  Intent dispnxt= new Intent(DispTip.this, DispTip.class);
       		  startActivity(dispnxt);
       		  finish();          }
      });
      
	}
	
	//////////
	@SuppressLint("NewApi") @Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.action_bar_main_menu, menu);
	    MenuItem item = menu.findItem(R.id.menu_item_share);

	    ShareActionProvider myShareActionProvider = (ShareActionProvider) item.getActionProvider();

	    Intent myIntent = new Intent();
	    myIntent.setAction(Intent.ACTION_SEND);
	    myIntent.putExtra(Intent.EXTRA_TEXT, tip);
	    myIntent.setType("text/plain");

	    myShareActionProvider.setShareIntent(myIntent);

	    return true;

	}

	/////////

	public String getResult(SQLiteDatabase db, int catnum)
	{
		if(tipnum==0)
		tipnum= randInt(1,8);
	    
		String name = null;
	    try
	    {
	        Cursor c = null;
	        //Toast t= Toast.makeText(this, "Received: "+catnum+" "+tipnum, Toast.LENGTH_LONG);
	        //t.show();
	        c = db.rawQuery("select * from tips WHERE cat ="+catnum+" AND tipid= "+tipnum+";", null);
	        c.moveToFirst();
	        name = c.getString(c.getColumnIndex("tip"));
	        c.close();
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    return name; 
	}
	public static int randInt(int min, int max) {

	    // Usually this should be a field rather than a method variable so
	    // that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	int getcatnum(String cat)
	{
		if(cat.equals("Health"))
			return 1;
		else if(cat.equals("Beauty"))
			return 2;
		else if(cat.equals("Proverbs"))
			return 3;
		else if(cat.equals("Inspirational Quotes"))
			return 4;
		else 
			return 5;
		
	}
	
	/*
	protected void onResume()
	  {
	          super.onResume();
	          // Add the following line to register the Session Manager Listener onResume
	          mSensorManager.registerListener((SensorEventListener) mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
	   }
	   
	  protected void onPause()
	  {
	          // Add the following line to unregister the Sensor Manager onPause
	          mSensorManager.unregisterListener((SensorListener) mShakeDetector);
	          super.onPause();
	   }

	*/
	
	 
	@Override
	public void onBackPressed()
	{
		ourdb.close();
		Intent backint = new Intent(this, MainActivity.class);
		startActivity(backint);
 		  finish();
	}
}
