package partE;

public class BinarySearch
{

  /**
   * Search for val in values, return the index of an instance of val.
   * 
   * @param val
   *          An integer we're searching for
   * @param values
   *          A sorted array of integers
   * @result index, an integer
   * @throws Exception
   *           If there is no i s.t. values[i] == val
   * @pre values is sorted in increasing order. That is, values[i] < values[i+1]
   *      for all reasonable i.
   * @post values[index] == val
   */
  public static int binarySearch(int i, int[] vals)
    throws Exception
  {
    int lb = 0;
    int ub = vals.length-1;
    int index = -1;

    while (lb <= ub)
      {
        int mid = (lb + ub) / 2;

        if (vals[mid] == i)
          {
            return index = mid;
          } // if
        else if (vals[mid] < i)
          {
            lb = mid + 1;
          } // if
        else if (vals[mid] > i)
          {
            ub = mid - 1;
          } // if
      } // while
    if (lb > ub)
      {
        throw new Exception("The value doesn't exist in the array.");
      } // if
    return index;

  } // binarySearch
}
