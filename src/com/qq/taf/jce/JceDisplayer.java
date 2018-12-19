package com.qq.taf.jce;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class JceDisplayer
{
  private StringBuilder sb;
  private int _level = 0;
  
  private void ps(String fieldName)
  {
    for (int i = 0; i < this._level; i++) {
      this.sb.append('\t');
    }
    if (fieldName != null) {
      this.sb.append(fieldName).append(": ");
    }
  }
  
  public JceDisplayer(StringBuilder sb, int level)
  {
    this.sb = sb;
    this._level = level;
  }
  
  public JceDisplayer(StringBuilder sb)
  {
    this.sb = sb;
  }
  
  public JceDisplayer display(boolean b, String fieldName)
  {
    ps(fieldName);
    this.sb.append(b ? 'T' : 'F').append('\n');
    return this;
  }
  
  public JceDisplayer displaySimple(boolean b, boolean bSep)
  {
    this.sb.append(b ? 'T' : 'F');
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(byte n, String fieldName)
  {
    ps(fieldName);
    this.sb.append(n).append('\n');
    return this;
  }
  
  public JceDisplayer displaySimple(byte n, boolean bSep)
  {
    this.sb.append(n);
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(char n, String fieldName)
  {
    ps(fieldName);
    this.sb.append(n).append('\n');
    return this;
  }
  
  public JceDisplayer displaySimple(char n, boolean bSep)
  {
    this.sb.append(n);
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(short n, String fieldName)
  {
    ps(fieldName);
    this.sb.append(n).append('\n');
    return this;
  }
  
  public JceDisplayer displaySimple(short n, boolean bSep)
  {
    this.sb.append(n);
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(int n, String fieldName)
  {
    ps(fieldName);
    this.sb.append(n).append('\n');
    return this;
  }
  
  public JceDisplayer displaySimple(int n, boolean bSep)
  {
    this.sb.append(n);
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(long n, String fieldName)
  {
    ps(fieldName);
    this.sb.append(n).append('\n');
    return this;
  }
  
  public JceDisplayer displaySimple(long n, boolean bSep)
  {
    this.sb.append(n);
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(float n, String fieldName)
  {
    ps(fieldName);
    this.sb.append(n).append('\n');
    return this;
  }
  
  public JceDisplayer displaySimple(float n, boolean bSep)
  {
    this.sb.append(n);
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(double n, String fieldName)
  {
    ps(fieldName);
    this.sb.append(n).append('\n');
    return this;
  }
  
  public JceDisplayer displaySimple(double n, boolean bSep)
  {
    this.sb.append(n);
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(String s, String fieldName)
  {
    ps(fieldName);
    if (s == null) {
      this.sb.append("null").append('\n');
    } else {
      this.sb.append(s).append('\n');
    }
    return this;
  }
  
  public JceDisplayer displaySimple(String s, boolean bSep)
  {
    if (s == null) {
      this.sb.append("null");
    } else {
      this.sb.append(s);
    }
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(byte[] v, String fieldName)
  {
    ps(fieldName);
    if (v == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (v.length == 0)
    {
      this.sb.append(v.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(v.length).append(", [").append('\n');
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 1);
    byte[] arrayOfByte;
    int j = (arrayOfByte = v).length;
    for (int i = 0; i < j; i++)
    {
      byte o = arrayOfByte[i];
      jd.display(o, null);
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer displaySimple(byte[] v, boolean bSep)
  {
    if ((v == null) || (v.length == 0))
    {
      if (bSep) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append(HexUtil.bytes2HexStr(v));
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(char[] v, String fieldName)
  {
    ps(fieldName);
    if (v == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (v.length == 0)
    {
      this.sb.append(v.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(v.length).append(", [").append('\n');
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 1);
    char[] arrayOfChar;
    int j = (arrayOfChar = v).length;
    for (int i = 0; i < j; i++)
    {
      char o = arrayOfChar[i];
      jd.display(o, null);
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer displaySimple(char[] v, boolean bSep)
  {
    if ((v == null) || (v.length == 0))
    {
      if (bSep) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append(new String(v));
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(short[] v, String fieldName)
  {
    ps(fieldName);
    if (v == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (v.length == 0)
    {
      this.sb.append(v.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(v.length).append(", [").append('\n');
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 1);
    short[] arrayOfShort;
    int j = (arrayOfShort = v).length;
    for (int i = 0; i < j; i++)
    {
      short o = arrayOfShort[i];
      jd.display(o, null);
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer displaySimple(short[] v, boolean bSep)
  {
    if ((v == null) || (v.length == 0))
    {
      this.sb.append("[]");
      if (bSep) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append("[");
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 1);
    for (int i = 0; i < v.length; i++)
    {
      short o = v[i];
      if (i != 0) {
        this.sb.append("|");
      }
      jd.displaySimple(o, false);
    }
    this.sb.append("]");
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(int[] v, String fieldName)
  {
    ps(fieldName);
    if (v == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (v.length == 0)
    {
      this.sb.append(v.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(v.length).append(", [").append('\n');
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 1);
    int[] arrayOfInt;
    int j = (arrayOfInt = v).length;
    for (int i = 0; i < j; i++)
    {
      int o = arrayOfInt[i];
      jd.display(o, null);
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer displaySimple(int[] v, boolean bSep)
  {
    if ((v == null) || (v.length == 0))
    {
      this.sb.append("[]");
      if (bSep) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append("[");
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 1);
    for (int i = 0; i < v.length; i++)
    {
      int o = v[i];
      if (i != 0) {
        this.sb.append("|");
      }
      jd.displaySimple(o, false);
    }
    this.sb.append("]");
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(long[] v, String fieldName)
  {
    ps(fieldName);
    if (v == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (v.length == 0)
    {
      this.sb.append(v.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(v.length).append(", [").append('\n');
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 1);
    long[] arrayOfLong;
    int j = (arrayOfLong = v).length;
    for (int i = 0; i < j; i++)
    {
      long o = arrayOfLong[i];
      jd.display(o, null);
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer displaySimple(long[] v, boolean bSep)
  {
    if ((v == null) || (v.length == 0))
    {
      this.sb.append("[]");
      if (bSep) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append("[");
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 1);
    for (int i = 0; i < v.length; i++)
    {
      long o = v[i];
      if (i != 0) {
        this.sb.append("|");
      }
      jd.displaySimple(o, false);
    }
    this.sb.append("]");
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(float[] v, String fieldName)
  {
    ps(fieldName);
    if (v == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (v.length == 0)
    {
      this.sb.append(v.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(v.length).append(", [").append('\n');
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 1);
    float[] arrayOfFloat;
    int j = (arrayOfFloat = v).length;
    for (int i = 0; i < j; i++)
    {
      float o = arrayOfFloat[i];
      jd.display(o, null);
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer displaySimple(float[] v, boolean bSep)
  {
    if ((v == null) || (v.length == 0))
    {
      this.sb.append("[]");
      if (bSep) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append("[");
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 1);
    for (int i = 0; i < v.length; i++)
    {
      float o = v[i];
      if (i != 0) {
        this.sb.append("|");
      }
      jd.displaySimple(o, false);
    }
    this.sb.append("]");
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public JceDisplayer display(double[] v, String fieldName)
  {
    ps(fieldName);
    if (v == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (v.length == 0)
    {
      this.sb.append(v.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(v.length).append(", [").append('\n');
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 1);
    double[] arrayOfDouble;
    int j = (arrayOfDouble = v).length;
    for (int i = 0; i < j; i++)
    {
      double o = arrayOfDouble[i];
      jd.display(o, null);
    }
    display(']', null);
    return this;
  }
  
  public JceDisplayer displaySimple(double[] v, boolean bSep)
  {
    if ((v == null) || (v.length == 0))
    {
      this.sb.append("[]");
      if (bSep) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append("[");
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 1);
    for (int i = 0; i < v.length; i++)
    {
      double o = v[i];
      if (i != 0) {
        this.sb.append("|");
      }
      jd.displaySimple(o, false);
    }
    this.sb.append("[");
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public <K, V> JceDisplayer display(Map<K, V> m, String fieldName)
  {
    ps(fieldName);
    if (m == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (m.isEmpty())
    {
      this.sb.append(m.size()).append(", {}").append('\n');
      return this;
    }
    this.sb.append(m.size()).append(", {").append('\n');
    JceDisplayer jd1 = new JceDisplayer(this.sb, this._level + 1);
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 2);
    for (Map.Entry<K, V> en : m.entrySet())
    {
      jd1.display('(', null);
      jd.display(en.getKey(), null);
      jd.display(en.getValue(), null);
      jd1.display(')', null);
    }
    display('}', null);
    return this;
  }
  
  public <K, V> JceDisplayer displaySimple(Map<K, V> m, boolean bSep)
  {
    if ((m == null) || (m.isEmpty()))
    {
      this.sb.append("{}");
      if (bSep) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append("{");
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 2);
    boolean first = true;
    for (Map.Entry<K, V> en : m.entrySet())
    {
      if (!first) {
        this.sb.append(",");
      }
      jd.displaySimple(en.getKey(), true);
      jd.displaySimple(en.getValue(), false);
      first = false;
    }
    this.sb.append("}");
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public <T> JceDisplayer display(T[] v, String fieldName)
  {
    ps(fieldName);
    if (v == null)
    {
      this.sb.append("null").append('\n');
      return this;
    }
    if (v.length == 0)
    {
      this.sb.append(v.length).append(", []").append('\n');
      return this;
    }
    this.sb.append(v.length).append(", [").append('\n');
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 1);
    T[] arrayOfObject;
    int j = (arrayOfObject = v).length;
    for (int i = 0; i < j; i++)
    {
      T o = arrayOfObject[i];
      jd.display(o, null);
    }
    display(']', null);
    return this;
  }
  
  public <T> JceDisplayer displaySimple(T[] v, boolean bSep)
  {
    if ((v == null) || (v.length == 0))
    {
      this.sb.append("[]");
      if (bSep) {
        this.sb.append("|");
      }
      return this;
    }
    this.sb.append("[");
    JceDisplayer jd = new JceDisplayer(this.sb, this._level + 1);
    for (int i = 0; i < v.length; i++)
    {
      T o = v[i];
      if (i != 0) {
        this.sb.append("|");
      }
      jd.displaySimple(o, false);
    }
    this.sb.append("]");
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public <T> JceDisplayer display(Collection<T> v, String fieldName)
  {
    if (v == null)
    {
      ps(fieldName);
      this.sb.append("null").append('\t');
      return this;
    }
    return display(v.toArray(), fieldName);
  }
  
  public <T> JceDisplayer displaySimple(Collection<T> v, boolean bSep)
  {
    if (v == null)
    {
      this.sb.append("[]");
      if (bSep) {
        this.sb.append("|");
      }
      return this;
    }
    return displaySimple(v.toArray(), bSep);
  }
  
  public <T> JceDisplayer display(T o, String fieldName)
  {
    if (o == null) {
      this.sb.append("null").append('\n');
    } else if ((o instanceof Byte)) {
      display(((Byte)o).byteValue(), fieldName);
    } else if ((o instanceof Boolean)) {
      display(((Boolean)o).booleanValue(), fieldName);
    } else if ((o instanceof Short)) {
      display(((Short)o).shortValue(), fieldName);
    } else if ((o instanceof Integer)) {
      display(((Integer)o).intValue(), fieldName);
    } else if ((o instanceof Long)) {
      display(((Long)o).longValue(), fieldName);
    } else if ((o instanceof Float)) {
      display(((Float)o).floatValue(), fieldName);
    } else if ((o instanceof Double)) {
      display(((Double)o).doubleValue(), fieldName);
    } else if ((o instanceof String)) {
      display((String)o, fieldName);
    } else if ((o instanceof Map)) {
      display((Map)o, fieldName);
    } else if ((o instanceof List)) {
      display((List)o, fieldName);
    } else if ((o instanceof JceStruct)) {
      display((JceStruct)o, fieldName);
    } else if ((o instanceof byte[])) {
      display((byte[])o, fieldName);
    } else if ((o instanceof boolean[])) {
      display((boolean[])o, fieldName);
    } else if ((o instanceof short[])) {
      display((short[])o, fieldName);
    } else if ((o instanceof int[])) {
      display((int[])o, fieldName);
    } else if ((o instanceof long[])) {
      display((long[])o, fieldName);
    } else if ((o instanceof float[])) {
      display((float[])o, fieldName);
    } else if ((o instanceof double[])) {
      display((double[])o, fieldName);
    } else if (o.getClass().isArray()) {
      display((Object[])o, fieldName);
    } else {
      throw new JceEncodeException("write object error: unsupport type.");
    }
    return this;
  }
  
  public <T> JceDisplayer displaySimple(T o, boolean bSep)
  {
    if (o == null) {
      this.sb.append("null").append('\n');
    } else if ((o instanceof Byte)) {
      displaySimple(((Byte)o).byteValue(), bSep);
    } else if ((o instanceof Boolean)) {
      displaySimple(((Boolean)o).booleanValue(), bSep);
    } else if ((o instanceof Short)) {
      displaySimple(((Short)o).shortValue(), bSep);
    } else if ((o instanceof Integer)) {
      displaySimple(((Integer)o).intValue(), bSep);
    } else if ((o instanceof Long)) {
      displaySimple(((Long)o).longValue(), bSep);
    } else if ((o instanceof Float)) {
      displaySimple(((Float)o).floatValue(), bSep);
    } else if ((o instanceof Double)) {
      displaySimple(((Double)o).doubleValue(), bSep);
    } else if ((o instanceof String)) {
      displaySimple((String)o, bSep);
    } else if ((o instanceof Map)) {
      displaySimple((Map)o, bSep);
    } else if ((o instanceof List)) {
      displaySimple((List)o, bSep);
    } else if ((o instanceof JceStruct)) {
      displaySimple((JceStruct)o, bSep);
    } else if ((o instanceof byte[])) {
      displaySimple((byte[])o, bSep);
    } else if ((o instanceof boolean[])) {
      displaySimple((boolean[])o, bSep);
    } else if ((o instanceof short[])) {
      displaySimple((short[])o, bSep);
    } else if ((o instanceof int[])) {
      displaySimple((int[])o, bSep);
    } else if ((o instanceof long[])) {
      displaySimple((long[])o, bSep);
    } else if ((o instanceof float[])) {
      displaySimple((float[])o, bSep);
    } else if ((o instanceof double[])) {
      displaySimple((double[])o, bSep);
    } else if (o.getClass().isArray()) {
      displaySimple((Object[])o, bSep);
    } else {
      throw new JceEncodeException("write object error: unsupport type.");
    }
    return this;
  }
  
  public JceDisplayer display(JceStruct v, String fieldName)
  {
    display('{', fieldName);
    if (v == null) {
      this.sb.append('\t').append("null");
    } else {
      v.display(this.sb, this._level + 1);
    }
    display('}', null);
    return this;
  }
  
  public JceDisplayer displaySimple(JceStruct v, boolean bSep)
  {
    this.sb.append("{");
    if (v == null) {
      this.sb.append('\t').append("null");
    } else {
      v.displaySimple(this.sb, this._level + 1);
    }
    this.sb.append("}");
    if (bSep) {
      this.sb.append("|");
    }
    return this;
  }
  
  public static void main(String[] args)
  {
    StringBuilder sb = new StringBuilder();
    sb.append(1.2D);
    System.out.println(sb.toString());
  }
}
