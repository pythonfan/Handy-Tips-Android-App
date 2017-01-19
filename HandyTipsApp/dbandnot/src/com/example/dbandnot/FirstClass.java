package com.example.dbandnot;

import java.util.Calendar;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class FirstClass extends Activity{
	 private ScheduleClient scheduleClient;
	    // This is the date picker used to select the date for our notification
	    private DatePicker picker;
	    private TimePicker tpick;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_time);
		
		// Create a new service client and bind our activity to this service
  scheduleClient = new ScheduleClient(this);
  scheduleClient.doBindService();

  // Get a reference to our date picker
 // picker = (DatePicker) findViewById(R.id.datePicker);
  tpick = (TimePicker) findViewById(R.id.timePicker);
	}

	 public void onDateSelectedButtonClick(View v){
	        // Get the date from our datepicker
	        //int day = picker.getDayOfMonth();
	        //int month = picker.getMonth();
	        //int year = picker.getYear();
	        
	        tpick.clearFocus();
	        int hour= tpick.getCurrentHour();
	        int min= tpick.getCurrentMinute();
	        // Create a new calendar set to the date chosen
	        // we set the time to midnight (i.e. the first minute of that day)
	        Calendar c = Calendar.getInstance();
	        //c.set(year, month, day);
	        c.set(Calendar.HOUR_OF_DAY, hour);
	        c.set(Calendar.MINUTE, min);
	        c.set(Calendar.SECOND, 0);
	        // Ask our service to set an alarm for that date, this activity talks to the client that talks to the service
	        scheduleClient.setAlarmForNotification(c);
	        // Notify the user what they just did
	        Toast.makeText(this, "Notification set for: "+ hour +"/"+ min, Toast.LENGTH_SHORT).show();
	    }
	 
	 @Override
		public void onBackPressed()
		{
			
			Intent backint = new Intent(this, MainActivity.class);
			startActivity(backint);
	 		  finish();
		}


}
