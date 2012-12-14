package com.elsinga.sample.proguard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

public class MainActivity extends FragmentActivity
{

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Log.e("Sample Proguard", "This shouldn't show up when I obfuscate because I've removed logging!");

    if (null == savedInstanceState)
    {
      FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
      /*
       * Make sure to save fragments, they're often loaded dynamically
       */
      Fragment fragment = new SensorListFragment();
      transaction.add(R.id.fragment_container, fragment);
      transaction.commit();
    }
  }

  /*
   * Keep the names of native methods!
   * If it changes, the NDK won't be able
   * to find your method
   */
  public native void doSomething();

  /*
   * proguard will remove android:onclick methods
   * because they're never called in your java!
   */
  public void goBackButtonClicked(View v)
  {
    getSupportFragmentManager().popBackStack();
  }

}
