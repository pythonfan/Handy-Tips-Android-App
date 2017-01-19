package com.example.dbandnot.listeners;

import java.util.List;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dbandnot.data.RssItem;

/**
 * Class implements a list listener
 * 
 * @author ITCuties
 *
 */
public class ListListener implements OnItemClickListener {

	// List item's reference
	List<RssItem> listItems;
	// Calling activity reference
	Activity activity;
	
	public ListListener(List<RssItem> aListItems, Activity anActivity) {
		listItems = aListItems;
		activity  = anActivity;
	}
	
	/**
	 * Start a browser with url from the rss item.
	 */
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(listItems.get(pos).getLink()));
	
		activity.startActivity(i);
		
	}
	/*
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
	    Uri uri;
	    String stringuri;
	    stringuri = (Uri.parse(listItems.get(pos).getLink())).toString();

	    Intent i = new Intent(activity, Browser2.class);
	    i.putExtra(EXTRA_MESSAGE, stringuri);

	    activity.startActivity(i);              
	}*/
	
/*public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

        LinearLayout linearLayout = (LinearLayout)arg1;
        TextView textView = (TextView)linearLayout.findViewById(R.id.eBooksTitle);
        startActivity(new Intent(MainActivity.this, EbookDescriptionActivity.class)
        .putExtra("link_to_load", textView.getTag().toString()));
}*/
	
	
	
}
