package com.galaxy.chokin;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.app.Activity;

public class DatabaseHelper extends SQLiteOpenHelper {
  private static final String DATABASE_NAME = "chokin.db";
  private static final int SCHEMA = 1;
  private static DatabaseHelper singelton = null;
  private Context ctxt = null;

  static final String TABLE = "purchases";
  static final String DATETIME = "purchaseDateTime";
  static final String VALUE = "purchaseValue";

  synchronized static DatabaseHelper getInstance(Context ctxt) {
    if (singelton == null) {
      singelton = new DatabaseHelper(ctxt.getApplicationContext());
    }
    return singelton;
  }

  private DatabaseHelper(Context ctxt) {
    super(ctxt, DATABASE_NAME, null, SCHEMA);
    this.ctxt = ctxt;
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    try {
      db.beginTransaction();
      db.execSQL("CREATE TABLE purchases (_id INTEGER PRIMARY KEY AUTOINCREMENT, purchaseDateTime long not null, purchaseValue real not null);");
      db.setTransactionSuccessful();
    } finally {
      db.endTransaction();
    }
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  
  }
}
