package partC;

/**
 * Skip lists of strings, stored alphabetically.
 */

/*
 * Citation: Skip Lists: A Probabilistic Alternative to Balanced Trees by
 * William Pugh Skip list (Java) http://en.literateprograms.org/Skip_list_(Java)
 */

public class SkipListOfStrings
    implements
      SetOfStrings
{
  public static final double P = 0.5;
  public static final int maxLevel = 16;

  skipListNode head = new skipListNode(null, maxLevel);
  int level = 0;

  // +--------+------------------------------------------------------
  // | Helper |
  // +--------+
  /**
   * A helper to assign level for node
   */
  public int randomLevel()
  {
    int lvl = (int) (Math.log(1. - Math.random()) / Math.log(1. - P));
    return Math.min(lvl, maxLevel);
  } // randomlevel()

  // +--------+------------------------------------------------------
  // | Method |
  // +--------+
  @Override
  public boolean contains(String str)
  {
    skipListNode s = head;
    for (int i = level; i >= 0; i--)
      {
        while (s.next[i] != null && s.next[i].data.compareTo(str) < 0)
          {
            s = s.next[i];
            // if the str is not found, then go to the next one (if exists)
          } // while
      } // for(i)

    s = s.next[0];
    return s != null && s.data.equals(str);
  } // contains(String)

  @Override
  public void add(String str)
  {
    skipListNode s = head;
    skipListNode[] newSkip = new skipListNode[maxLevel + 1];

    for (int i = level; i >= 0; i--)
      {
        while (s.next[i] != null && s.next[i].data.compareTo(str) < 0)
          {
            s = s.next[i];
            // if the str is not found, then go to the next one (if exists)
          } // while
        newSkip[i] = s;
      } // for(i)
    s = s.next[0];

    if (s == null || s.data.equals(str))
      {
        int lvl = this.randomLevel();
        // use randomLevel to assign level for this node

        if (lvl > level)
          {
            for (int i = level + 1; i <= lvl; i++)
              {
                newSkip[i] = head;
              } // for(i)
            level = lvl;
          } // if

        s = new skipListNode(str, lvl); // a new node
        for (int c = 0; c <= lvl; c++)
          {
            s.next[c] = newSkip[c].next[c];
            newSkip[c].next[c] = s;
          } // for(c)
      } // if
  }// add(String)

  @Override
  public void remove(String str)
  {
    skipListNode s = head;
    skipListNode[] newSkip = new skipListNode[maxLevel + 1];

    for (int i = level; i >= 0; i--)
      {
        while (s.next[i] != null && s.next[i].data.compareTo(str) < 0)
          {
            s = s.next[i];
          } // while
        newSkip[i] = s;
      } // for(i)
    s = s.next[0];

    if (s.data.equals(str)) // if the node is found
      {
        for (int i = 0; i <= level; i++)
          {
            if (newSkip[i].next[i] != s)
              break;
            newSkip[i].next[i] = s.next[i];
          } // for(i)
        while (level > 0 && this.head.next[level] == null)
          {
            level--; // decrease the level
          } // while
      } // if
  } // remove(String)

} // class SkipListOfStrings
