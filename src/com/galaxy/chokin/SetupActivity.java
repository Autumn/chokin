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

public class SetupActivity extends Activity {
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
    BigDecimal totalMoney;
    BigDecimal goalMoney;
    BigDecimal weeklySpend;
    String payDay;
    String weekStart;

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
      // save values
      // setup main activity
    }
  }

}
