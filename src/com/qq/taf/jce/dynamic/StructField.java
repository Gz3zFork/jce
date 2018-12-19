package com.qq.taf.jce.dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class StructField
  extends JceField
{
  private static final Comparator<JceField> tagComp = new Comparator<JceField>()
  {
    public int compare(JceField o1, JceField o2)
    {
      return o1.getTag() - o2.getTag();
    }
  };
  private JceField[] data;
  
  StructField(JceField[] data, int tag)
  {
    super(tag);
    this.data = data;
  }
  
  public JceField[] get()
  {
    return this.data;
  }
  
  public boolean setByTag(int tag, JceField field)
  {
    int n = Arrays.binarySearch(this.data, JceField.createZero(tag), tagComp);
    if (n >= 0)
    {
      this.data[n] = field;
      return true;
    }
    int p = -n - 1;
    JceField[] rs = new JceField[this.data.length + 1];
    for (int i = 0; i < p; i++) {
      rs[i] = this.data[i];
    }
    rs[p] = field;
    for (int i = p; i < this.data.length; i++) {
      rs[(i + 1)] = this.data[i];
    }
    return false;
  }
  
  public JceField getFieldByTag(int tag)
  {
    int n = Arrays.binarySearch(this.data, JceField.createZero(tag), tagComp);
    return n >= 0 ? this.data[n] : null;
  }
}
