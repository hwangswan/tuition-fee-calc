/**
 * Definition of a Semester.
 *
 * @author trhgquan - https://github.com/trhgquan
 */

package Semester;

/**
 * This class is all about a Semester and its courses.
 *
 * @author trhgquan - https://github.com/trhgquan
 */
public class Semester {
  /**
   * Definition of a Course
   *
   * @author trhquan - https://github.com/trhgquan
   */
  public static class Course {
    private String _name;
    private int    _classCredit;
    private int    _labCredit;

    /**
     * This method return the course's name.
     *
     * @return String
     */
    public String name() {
      return _name;
    }

    /**
     * This method return the course's class credit.
     *
     * @return int
     */
    public int classCredit() {
      return _classCredit;
    }

    /**
     * This method return the course's lab credit.
     *
     * @return int
     */
    public int labCredit() {
      return _labCredit;
    }

    /**
     * Constructor for Course.
     *
     * @param  String
     * @param  int
     * @param  int
     */
    public Course(String name, int classCredit, int labCredit) {
      _name        = name;
      _classCredit = classCredit;
      _labCredit   = labCredit;
    }

    /**
     * This method return the course's total credits.
     *
     * @return int
     */
    public int totalCredit() {
      return _classCredit + _labCredit;
    }

    /**
     * This method return the course's tuition fee.
     *
     * @return int
     */
    public int tuitionFee() {
      return (_labCredit * Semester._labCost) +
             (_classCredit * Semester._classCost);
    }

    /**
     * This method convert the course to a CSV string.
     *
     * @return String
     */
    public String toCSVString() {
      StringBuilder builder = new StringBuilder();

      builder.append(_name);
      builder.append(", ");
      builder.append(totalCredit());
      builder.append(", ");
      builder.append(tuitionFee());

      return builder.toString();
    }
  }

  /**
   * Private properties of the Semester.
   *
   */
  private static int _classCost;
  private static int _labCost;
  private Semester.Course[] _courseList;

  /**
   * Semester's constructor.
   *
   * @param  Semester.Course[]
   */
  public Semester(Semester.Course[] courseList) {
    _courseList = courseList;
  }

  /**
   * Set class cost.
   *
   * @param  int
   */
  public void setClassCost(int classCost) {
    _classCost = classCost;
  }

  /**
   * Set lab cost.
   *
   * @param  int
   */
  public void setLabCost(int labCost) {
    _labCost = labCost;
  }

  /**
   * This method will return all courses in a semester.
   *
   * @return Semester.Course[]
   */
  public Semester.Course[] courseList() {
    return _courseList;
  }

  /**
   * Return total credits
   *
   * @return int
   */
  public int totalCredit() {
    int credits = 0;

    for (int i = 0; i < _courseList.length; ++i) {
      credits += _courseList[i].totalCredit();
    }

    return credits;
  }

  /**
   * Return tuition fee.
   *
   * @return int
   */
  public int tuitionFee() {
    int fees = 0;

    for (int i = 0; i < _courseList.length; ++i) {
      fees += _courseList[i].tuitionFee();
    }

    return fees;
  }

  /**
   * This method will convert a semester total fee to a CSV string.
   *
   * @return String
   */
  public String toCSVString() {
    StringBuilder builder = new StringBuilder();

    builder.append("Total");
    builder.append(", ");
    builder.append(totalCredit());
    builder.append(", ");
    builder.append(tuitionFee());

    return builder.toString();
  }
}
