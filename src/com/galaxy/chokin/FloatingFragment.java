package com.galaxy.chokin;

import android.os.Bundle;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

public class FloatingFragment extends DialogFragment {
  static FloatingFragment newInstance() {
    FloatingFragment f = new FloatingFragment();
    return f;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.floating_fragment, container, false);
    return v;
  }
}
