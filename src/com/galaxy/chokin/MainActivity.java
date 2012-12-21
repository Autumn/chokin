package com.galaxy.chokin;

import android.app.Activity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Intent;

public class MainActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    checkFirstOpen();
  }

  public void checkFirstOpen() {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    if (!prefs.getBoolean("firstOpen", false)) {
      startActivity(new Intent(this, SetupActivity.class)); 
    }
  }
  

}
