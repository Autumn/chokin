package com.galaxy.chokin;

import android.view.View;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;

public class FirstOpenFragment extends Fragment implements View.OnClickListener {
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View result = inflater.inflate(R.layout.first_open_fragment, container, false);
    result.findViewById(R.id.first_open_button).setOnClickListener(this);
    return result;
  }

  @Override
  public void onClick(View v) {
    startActivity(new Intent(getActivity(), SetupActivity.class));
  }
}
