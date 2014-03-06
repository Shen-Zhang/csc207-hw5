package partB;

public class dnfExpt
{
  public static void main(String[] args)
    throws Exception
  {
    SimpleStringSizeClassifier x = new SimpleStringSizeClassifier();
    ClassifyStringsByFirstCharacter y = new ClassifyStringsByFirstCharacter();
    
    String[] strArr =
        { "12345", "s", "dsadsadasdadas", "dsadsadsad", "sd", "67890", "dsa" };

    DutchNationalFlag.dnf(strArr, x);

    for (int i = 0; i < strArr.length; i++)
      {
        System.out.print(strArr[i] + " ");
      } // for(i)
    System.out.println("");
    
    String[] strY =
      { "12345", "s", "Dsadsadasdadas", "dsadsadsad", "Dd", "67890", "dsa" };
    
    DutchNationalFlag.dnf(strY, y);
    for (int i = 0; i < strY.length; i++)
      {
        System.out.print(strY[i] + " ");
      } // (for i)
    
    
  } // main
} // class dnfExpt
