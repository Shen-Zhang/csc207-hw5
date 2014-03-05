package partC;

public class skipExpt
{
  public static void main(String[] args)
  {

    SkipListOfStrings ss = new SkipListOfStrings();
    System.out.println(ss);

    ss.add("a");
    ss.add("bb");
    ss.add("ccc");
    ss.add("dddd");
    ss.add("eeeee");
    
    

    if (ss.contains("a"))
      {
        System.out.println("a is in the list");
      }
    if (ss.contains("b"))
      {
        System.out.println("b is in the list");
      }
    if (ss.contains("ccc"))
      {
        System.out.println("ccc is in the list");
      }
    if (ss.contains("dddd"))
      {
        System.out.println("dddd is in the list");
      }
    if (ss.contains("eeeee"))
      {
        System.out.println("eeeee is in the list");
      }

    System.out.println(ss);

    ss.remove("a");

    if (!ss.contains("a"))
      {
        System.out.println("a has been deleted");
      }
  }
}
