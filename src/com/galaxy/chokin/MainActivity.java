package com.galaxy.chokin;

import android.app.Activity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Intent;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentPagerAdapter;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.util.Log;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

  private static final String FIRST_OPEN_KEY = "firstOpen";
  SharedPreferences prefs = null; 
  int notifId = 1;

  ViewPager pager;
  static final int NUM_PAGES = 3;
  static final int MIDDLE_PAGE = 1;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    pager = new ViewPager(this);
    pager.setId(R.id.pager);
    pager.setAdapter(new PageFragmentAdapter(getSupportFragmentManager()));
    pager.setCurrentItem(MIDDLE_PAGE);
    setContentView(pager);

    if (prefs == null)
       prefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());

    
    Notification notif = new Notification.BigTextStyle(
        new Notification.Builder(this).setContentTitle("test").setContentText("test").setOngoing(true).setSmallIcon(R.drawable.ic_stat_notif)
        .addAction(R.drawable.ic_stat_notif, "Add Purchase", PendingIntent.getActivity(this.getApplicationContext(), 0, new Intent(this, FloatingFragment.class), 0))).build();
    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    mNotificationManager.notify(notifId, notif);

    //

    if (!prefs.getBoolean(FIRST_OPEN_KEY, false)) {

    } else {

      fillData();
    }

    checkFirstOpen();
  }

  @Override
  public void onResume() {
    super.onResume();
    if (!prefs.getBoolean(FIRST_OPEN_KEY, false)) {
    } else {
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

  
  public static class PageFragmentAdapter extends FragmentPagerAdapter {

    public PageFragmentAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public int getCount() {
      return NUM_PAGES;
    }

    @Override
    public Fragment getItem(int position) {
      // return the fragments required for each page
      Log.d("uguu", "creating fragment");
      return new MainFragment();
    }
  }

}
