package partD;
public class Exponentiation
{
  /**
   * Compute x^n.
   * 
   * @pre n >= 1.
   */
  public static double expt(double x, int n)
  {
    /* when n = 0 or 1, it's easy to get the answer. */
    if (n == 0)
      return 1;
    if (n == 1)
      return x;

    
    double rslt = 1;
    while (n > 0)
      {
        if ((n & 1) == 1) 
          rslt *= x;

        x *= x;
        n >>= 1;
      }
    return rslt;
  } // expt(double, int)
}
