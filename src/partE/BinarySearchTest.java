package partE;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest
{

  @Test
  public void test1()
    throws Exception
  {
    for (int s = 1; s < 32; s++)
      {
        int[] testArr = new int[s]; // create a test array
        for (int i = 0; i < s; i++)
          {
            testArr[i] = 2 * i;
          } // for(i)
        for (int x = 0; x < s; x++)
          {
            assertEquals(x, BinarySearch.binarySearch(2 * x, testArr));
            // check if value 2*i is in position i
            try
              {
                BinarySearch.binarySearch(2 * x + 1, testArr);
                BinarySearch.binarySearch(-1, testArr);
                fail("Exception not thrown");
             // Make sure that odd values and -1 are not in the array
              } // try
            catch (Exception e)
              {
                // success
              } // catch
          } // for(x)
      } // for(s)
  } // test1()

} // BinarySearchTest
