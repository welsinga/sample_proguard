package com.elsinga.sample.proguard;

import java.util.List;

import android.app.Activity;
import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SensorAdapter extends BaseAdapter
{

  private final Activity _activity;
  List<Sensor>           _sensors;

  public SensorAdapter(Activity activity)
  {
    _activity = activity;
    _sensors = ((SensorManager) _activity.getSystemService(Service.SENSOR_SERVICE)).getSensorList(Sensor.TYPE_ALL);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent)
  {
    TextView v = new TextView(_activity);

    v.setText(_sensors.get(position).getName());
    v.setTextSize(22);
    v.setPadding(Util.getXPixels(_activity, 5), Util.getYPixels(_activity, 2), Util.getXPixels(_activity, 5), Util.getYPixels(_activity, 2));

    return v;
  }

  @Override
  public long getItemId(int position)
  {
    return position;
  }

  @Override
  public Object getItem(int position)
  {
    return _sensors.get(position);
  }

  @Override
  public int getCount()
  {
    return _sensors.size();
  }
}
