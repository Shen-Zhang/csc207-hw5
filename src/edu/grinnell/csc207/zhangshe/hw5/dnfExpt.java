package edu.grinnell.csc207.zhangshe.hw5;

public class dnfExpt
{
  public static void main(String[] args)
    throws Exception
  {
    SimpleStringSizeClassifier x = new SimpleStringSizeClassifier();

    String[] strArr =
        { "12345", "s", "dsadsadasdadas", "dsadsadsad", "sd", "67890", "dsa" };

    DutchNationalFlag.dnf(strArr, x);

    for (int i = 0; i < strArr.length; i++)
      {
        System.out.print(strArr[i] + " ");
      }

  } // man
} // class dnfExpt
