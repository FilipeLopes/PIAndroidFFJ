package br.com.pizza.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
 
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

	private static String dbName  = "pizza1.db";
	private static String sql     = "CREATE TABLE [sabor] " +
			"([id] INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
			"[sabor] String(40), " +
			"[preco] String(40));";
		
	private static int    version = 1;
	
	public DB(Context ctx) {
		super(ctx, dbName, null, version);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

	

}
