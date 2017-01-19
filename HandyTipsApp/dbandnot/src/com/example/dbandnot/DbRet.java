package com.example.dbandnot;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbRet extends SQLiteOpenHelper{
	public DbRet(Context context, String name, CursorFactory factory,
			int version) {
		super(context, dbname, factory, ver);
		// TODO Auto-generated constructor stub
	}
	public static final String dbname = "tips.db";
	public static final  int ver = 5;
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		String sql= "CREATE TABLE tips(tipid int, cat int, tip VARCHAR(100));";
	    db.execSQL(sql);
	    /*
	     * 1. Health
	     * 2. Beauty
	     * 3. Proverbs
	     * 4. Inspirational quotes
	     * 5. Smart phone tips
	     */
	    String inssql ="INSERT INTO tips VALUES(1,1,' Dont skip breakfast.');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(2,1,'Take a Short Nap');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(3,1,'Eat lots of fruit and vegetables');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(4,1,'Avoid drinking tea and coffee immediately after meals.');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(5,1,'Apples help your body develop  resistance  against infections');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(6,1,'Almonds increase  blood flow to the brain');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(7,1,'Pineapples help fight arthritis.');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(8,1,'Watermelons helps control heart rate.');";
	    db.execSQL(inssql);
	    
	    
	    inssql ="INSERT INTO tips VALUES(1,2,'Eye Cream Is Great For Cuticles');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(2,2,'Avoid Overly Rosy Cheeks');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(3,2,'Dry Out Pimples');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(4,2,'Application of pure castor oil prevents wrinkles and softens the skin.');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(5,2,'Produce raw potato juice, apply on your face.It helps brighten skin and prevents wrinkle and acne.');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(6,2,'Garlic helps clear the skin,crushed garlic and add required amount of water, then apply to the skin.');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(7,2,'Take slice tomato piece and tomato pulp, rub on your face and neck area,leave for 15 minutes,wash off with normal water.');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(8,2,'Mix one tablespoon of honey and 2 tablespoons of cream. Apply this mixture on the face and wash off after a few minutes.');";
	    db.execSQL(inssql);
	    
	    
	    
	    inssql ="INSERT INTO tips VALUES(1,3,'An apple a day keeps the doctor away');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(2,3,'A bird in the hand is worth two in the bush');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(3,3,'A dog is a man s best friend');";
	    db.execSQL(inssql);  
	    inssql ="INSERT INTO tips VALUES(4,3,'The early bird catches the worm');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(5,3,'A rolling stone gathers no moss');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(6,3,'Birds of a feather flock together');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(7,3,'A bad workman blames his tools');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(8,3,'Dont count your chickens before they are hatched');";
	    db.execSQL(inssql);
	    
	    
	    
	    inssql ="INSERT INTO tips VALUES(1,4,' Life isnt about getting and having, its about giving and being. –Kevin Kruse');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(2,4,'Whatever the mind of man can conceive and believe, it can achieve. –Napoleon Hill');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(3,4,'Strive not to be a success, but rather to be of value. –Albert Einstein');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(4,4,'If you dream it, you can do it. -Walt Disney');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(5,4,'Never, never, never give up. -Winston Churchill');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(6,4,'Don’t wait. The time will never be just right. -Napolean Hill');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(7,4,'Everything you can imagine is real. -Pablo Picasso');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(8,4,'Do what you can, with what you have, where you are. -Theodore Roosevelt');";
	    db.execSQL(inssql);
	    
	    inssql ="INSERT INTO tips VALUES(1,5,'Back Up Your Photos');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(2,5,'Get Your Music from the Cloud');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(3,5,'Use Some Logic to Sort Your Home Screens');";
	    db.execSQL(inssql);    
	    inssql ="INSERT INTO tips VALUES(4,5,'To improve battery life, dim the screen, kill unnecessary background running apps and use battery saving apps.');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(5,5,'Android allows you to create icons on your home screen for contacts. To add one press and hold an empty space on your screen.');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(6,5,'Many Android phones have talk-to-type built into the keyboard. Tap the mic icon and just talk.');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(7,5,'Android allows you to view how much processing power each open app is using. Go to Settings > Running Services to view the list.');";
	    db.execSQL(inssql);
	    inssql ="INSERT INTO tips VALUES(8,5,'Hold down your phones Home button and a window will pop up with recently-opened apps.');";
	    db.execSQL(inssql);
	    
       
}
	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		String sql1= "DROP TABLE IF EXISTS tips";
		db.execSQL(sql1);
		this.onCreate(db);
		
	}
}
