/**
 * Definition of a Course.
 *
 * Code by @trhgquan - https://github.com/trhgquan
 */

package Course;

public class Course {
  private String _name;
  private int    _classCredit;
  private int    _labCredit;

  // Getter
  public String name() {
    return _name;
  }

  public int classCredit() {
    return _classCredit;
  }

  public int labCredit() {
    return _labCredit;
  }

  // Constructor
  public Course(String name, int classCredit, int labCredit) {
    _name        = name;
    _classCredit = classCredit;
    _labCredit   = labCredit;
  }

  public int totalCredit() {
    return _classCredit + _labCredit;
  }
}
