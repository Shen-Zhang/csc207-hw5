package partC;

public class skipListNode
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  String data;
  skipListNode next[]; // an array of forward pointers 

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  
  public skipListNode(String str, int level)
  {
    this.data = str;
    this.next = new skipListNode[level+1];
  } // skipListNode(String, int)
  
  
} // class skipListNode
