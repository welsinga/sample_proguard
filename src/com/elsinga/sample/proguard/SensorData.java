package com.elsinga.sample.proguard;

import java.io.Serializable;

public class SensorData implements Serializable
{

  private static final long serialVersionUID = 1L;

  public String             name;
  public String             vendor;
  public int                version;
  public float              range;
  public float              power;
  public int                type;
}
