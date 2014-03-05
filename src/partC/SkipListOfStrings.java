package partC;

/**
 * Skip lists of strings, stored alphabetically.
 */

public class SkipListOfStrings
    implements
      SetOfStrings
{
  public static final double P = 0.5;
  public static final int maxLevel = 16;

  // +--------+------------------------------------------------------
  // | Helper |
  // +--------+
  public int randomLevel()
  {
    int lvl = (int) (Math.log(1. - Math.random()) / Math.log(1. - P));
    return Math.min(lvl, maxLevel);
  }

  skipListNode head = new skipListNode(null, maxLevel);
  int level = 0;

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
          } // while
      } // for(i)
    s = s.next[0];
    return s != null && s.data.equals(str);

  }

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
          } // while
        newSkip[i] = s;
      } // for(i)
    s = s.next[0];

    if (s == null || s.data.equals(str))
      {
        int lvl = this.randomLevel();

        if (lvl > level)
          {
            for (int i = level + 1; i <= lvl; i++)
              {
                newSkip[i] = head;
              }
            level = lvl;
          }

        s = new skipListNode(str, lvl);
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

    if (s.data.equals(str))
      {
        for (int i = 0; i <= level; i++)
          {
            if (newSkip[i].next[i] != s)
              break;
            newSkip[i].next[i] = s.next[i];
          } // for(i)
        while (level > 0 && this.head.next[level] == null)
          {
            level--;
          } // while
      } // if

  }
} // class SkipListOfStrings
