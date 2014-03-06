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
    int k = n;
    double a = x;
    /* 
     * loop invariant:
     * x^n = rslt * a^k
     */
    
    while (k > 0)
      if (k % 2 == 0)
        {
          k = k / 2;
          a = a * a;
        } // if
      else
        {
          rslt = rslt * a;
          k = k - 1;
        } // else
    return rslt;
  } // expt(double, int)
} // class Exponentiation
