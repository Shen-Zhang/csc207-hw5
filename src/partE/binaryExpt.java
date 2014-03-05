package partE;

public class binaryExpt
{

  public static void main (String[] args) throws Exception
  {
    
    int[] arr = {1,2,3,5,7,10,12,19};
    int a = BinarySearch.binarySearch(12, arr);
    System.out.println("index of: 12 in " + a);
    int c = BinarySearch.binarySearch(0, arr);
    System.out.println("index of: 0 in " + c);
    int b = BinarySearch.binarySearch(20, arr);
    System.out.println("index of: 20 in " + b);
    
    
  }
}
