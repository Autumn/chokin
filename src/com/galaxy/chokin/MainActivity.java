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
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;

public class MainActivity extends Activity {

  private static final String FIRST_OPEN_KEY = "firstOpen";
  SharedPreferences prefs = null; 
  int notifId = 1;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (prefs == null)
       prefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());

    setContentView(R.layout.main);
    
    Notification notif = new Notification.BigTextStyle(
        new Notification.Builder(this).setContentTitle("test").setContentText("test").setOngoing(true).setSmallIcon(R.drawable.ic_stat_notif)
        .addAction(R.drawable.ic_stat_notif, "Add Purchase", PendingIntent.getActivity(this.getApplicationContext(), 0, new Intent(this, FloatingFragment.class), 0))).build();
    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    mNotificationManager.notify(notifId, notif);

    //

    if (!prefs.getBoolean(FIRST_OPEN_KEY, false)) {
      findViewById(R.id.first_open_layout).setVisibility(View.VISIBLE);
      findViewById(R.id.pager).setVisibility(View.GONE);
    } else {
      findViewById(R.id.first_open_layout).setVisibility(View.GONE);
      findViewById(R.id.pager).setVisibility(View.VISIBLE);
      fillData();
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
      fillData();
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

  public void fillData() {

  }
  

}
