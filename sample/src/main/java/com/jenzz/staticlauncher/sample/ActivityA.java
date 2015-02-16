package com.jenzz.staticlauncher.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.jenzz.staticlauncher.StaticLauncher;

/**
 * Created by jenzz on 15/02/15.
 */
@StaticLauncher
public class ActivityA extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
}