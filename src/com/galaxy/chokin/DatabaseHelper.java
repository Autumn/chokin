package com.galaxy.chokin;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.app.Activity;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
  private static final String DATABASE_NAME = "chokin.db";
  private static final int SCHEMA = 1;
  private static DatabaseHelper singelton = null;
  private Context ctxt = null;

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
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  
  }
}
