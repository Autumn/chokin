package com.galaxy.chokin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import java.math.BigDecimal;
import android.content.Context;
import java.lang.CharSequence;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;

public class SetupActivity extends Activity {

  private static final String TOTAL_SAVED_KEY = "totalSaved";
  private static final String GOAL_SAVE_KEY = "goalSave";
  private static final String WEEKLY_SPEND_KEY = "weeklySpend";
  private static final String PAY_DAY_KEY = "payDay";
  private static final String WEEK_START_KEY = "weekStart";
  private static final String FIRST_OPEN_KEY = "firstOpen";
  private static final String PREFS_NAME = "setupPrefs";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.setup);
    
    Spinner spinner = (Spinner) findViewById(R.id.setup_weekstart_choice);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.days_of_week, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
    spinner = (Spinner) findViewById(R.id.setup_payday_choice);
    spinner.setAdapter(adapter);

  }

  public void finishSetup(View v) {
    TextView totalInput = (TextView) findViewById(R.id.setup_total_edit);
    TextView goalInput = (TextView) findViewById(R.id.setup_goal_edit);
    TextView weeklyInput = (TextView) findViewById(R.id.setup_weekly_edit);
    Spinner payDayInput = (Spinner) findViewById(R.id.setup_payday_choice);
    Spinner weekStartInput = (Spinner) findViewById(R.id.setup_weekstart_choice);

    if (totalInput.getText().toString().equals("") || goalInput.getText().toString().equals("") || weeklyInput.getText().toString().equals("")) {
      Context context = getApplicationContext();
      CharSequence text = getResources().getString(R.string.setup_incomplete_notif);
      int duration = Toast.LENGTH_SHORT;

      Toast toast = Toast.makeText(context, text, duration);
      toast.show();
    } else {
      Context ctxt = this;
      SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctxt.getApplicationContext());
      SharedPreferences.Editor editor = prefs.edit();
      editor.putString(TOTAL_SAVED_KEY, totalInput.getText().toString());
      editor.putString(GOAL_SAVE_KEY, goalInput.getText().toString());
      editor.putString(WEEKLY_SPEND_KEY, weeklyInput.getText().toString());
      editor.putString(PAY_DAY_KEY, payDayInput.getSelectedItem().toString());
      editor.putString(WEEK_START_KEY, weekStartInput.getSelectedItem().toString());
      editor.putBoolean(FIRST_OPEN_KEY, true);
      while (!editor.commit());
      // ideal: open a splash confirming initial settings have been entered, then direct to the main activity
      finish();
    }
  }

}
