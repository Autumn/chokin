package com.galaxy.chokin;

import android.app.Activity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Intent;
import android.content.Context;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.View;

public class MainActivity extends Activity {

  private static final String FIRST_OPEN_KEY = "firstOpen";
  SharedPreferences prefs = null; 

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (prefs == null)
       prefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());

    setContentView(R.layout.main);

    if (!prefs.getBoolean(FIRST_OPEN_KEY, false)) {
      findViewById(R.id.first_open_layout).setVisibility(View.VISIBLE);
      findViewById(R.id.pager).setVisibility(View.GONE);
    } else {
      findViewById(R.id.first_open_layout).setVisibility(View.GONE);
      findViewById(R.id.pager).setVisibility(View.VISIBLE);
    }

    checkFirstOpen();
  }

  @Override
  public void onResume() {
    super.onResume();
    if (!prefs.getBoolean(FIRST_OPEN_KEY, false)) {
      findViewById(R.id.first_open_layout).setVisibility(View.VISIBLE);
      findViewById(R.id.pager).setVisibility(View.GONE);
    } else {
      findViewById(R.id.first_open_layout).setVisibility(View.GONE);
      findViewById(R.id.pager).setVisibility(View.VISIBLE);
    }
  }

  public void checkFirstOpen() {
    Context ctxt = this;
    if (!prefs.getBoolean(FIRST_OPEN_KEY, false)) {
      startActivity(new Intent(this, SetupActivity.class)); 
    }
  }
  
  public void openSettings(View v) {
    startActivity(new Intent(this, SetupActivity.class)); 
  }
  

}
