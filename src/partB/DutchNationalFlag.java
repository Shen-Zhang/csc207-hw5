package partB;

public class DutchNationalFlag
{

  /**
   * Rearrange vals so that red values precede white values and white values
   * precede blue values.
   * 
   * @post Exist P and Q, 0 <= P <= Q <= vals.length, s.t. For all i, 0 <= i <
   *       P, classifier.classify(vals[i]) < 0 For all i, P <= w < Q,
   *       classifier.classify(vals[i]) == 0 For all i, Q <= i < vals.length,
   *       classifier.classify(vals[i]) > 0 Values have neither been added to
   *       nor removed from vals; the new vals is a permutation of the original.
   */
  public static void dnf(String[] vals, StringClassifier classifier)
  {
    int lb = 0;
    int hb = vals.length - 1;
    int mid = 0;

    while (mid <= hb)
      {
        int color = classifier.classify(vals[mid]);

        if (color < 0)
          {
            String temp = vals[mid];
            vals[mid] = vals[lb];
            vals[lb] = temp;
            lb++;
            mid++;
          } // red
        else if (color == 0)
          {

            mid++;
          } // white
        else
          {

            String temp = vals[mid];
            vals[mid] = vals[hb];
            vals[hb] = temp;
            hb--;
          } // blue
      } // while
  } // dnf(String[], StringClassifier)

} // class DutchNationalFlag