package com.example.dbandnot;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dbandnot.data.RssItem;
import com.example.dbandnot.listeners.ListListener;
import com.example.dbandnot.util.RssReader;

public class WebActivity extends Activity{
	// A reference to the local object
		private WebActivity local;
		
		/** 
		 * This method creates main application view
		 */
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			// Set view
			setContentView(R.layout.web_disp);

			// Set reference to this activity
			local = WebActivity.this;
			
			final String catrec= getIntent().getStringExtra("catselected");
			String websiteaddr=getcatstr(catrec);
			
			GetRSSDataTask task = new GetRSSDataTask();
			
			// Start download RSS task
			task.execute(websiteaddr);
			
			// Debug the thread name
			Log.d("ITCRssReader", Thread.currentThread().getName());
		
		
		}
		@Override
		public void onBackPressed()
		{
			
			Intent backint = new Intent(this, MainActivity.class);
			startActivity(backint);
	 		  finish();
		}
		String getcatstr(String cat)
		{
			if(cat.equals("Health"))
				return ("http://www.health.com/health/diet-fitness/feed");
			else if(cat.equals("Beauty"))
				return ("http://www.health.com/health/beauty-style/feed/");
			else if(cat.equals("Proverbs"))
				return ("http://feeds.feedburner.com/phrasemixlessons");
			else if(cat.equals("Inspirational Quotes"))
				return ("http://feeds.feedburner.com/brainyquote/QUOTEBR");
			else 
				return ("http://blog.evernote.com/feed/");
			
		}
		
		private class GetRSSDataTask extends AsyncTask<String, Void, List<RssItem> > {
			@Override
			protected List<RssItem> doInBackground(String... urls) {
				
				// Debug the task thread name
				Log.d("ITCRssReader", Thread.currentThread().getName());
				
				try {
					// Create RSS reader
					RssReader rssReader = new RssReader(urls[0]);
				
					// Parse RSS, get items
					return rssReader.getItems();
				
				} catch (Exception e) {
					Log.e("ITCRssReader", e.getMessage());
				}
				
				return null;
			}
			
			@Override
			protected void onPostExecute(List<RssItem> result) {
				
				// Get a ListView from main view
				ListView itcItems = (ListView) findViewById(R.id.listbuttons);
							
				// Create a list adapter
				ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(local,android.R.layout.simple_list_item_1, result);
				// Set list adapter for the ListView
				itcItems.setAdapter(adapter);
							
				// Set list view item click listener
				itcItems.setOnItemClickListener(new ListListener(result, local));
			}
			
			
		}
		
		

	
}
