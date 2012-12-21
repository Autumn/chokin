package com.galaxy.chokin;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.DialogFragment;
import android.os.Bundle;

public class FloatingActivity extends Activity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    FragmentManager ft = getFragmentManager();
    DialogFragment frag = FloatingFragment.newInstance();
    frag.show(ft, "dialog");
  }
}
