package com.jenzz.staticlauncher.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jenzz on 15/02/15.
 */
public class MainActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);
  }

  @OnClick(R.id.activity_a) void onClickActivityA() {
    ActivityALauncher.startActivity(this);
  }

  @OnClick(R.id.activity_b) void onClickActivityb() {
    ActivityBLauncher.startActivity(this);
  }
}