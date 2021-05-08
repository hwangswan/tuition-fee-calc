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
   * Cost of one credit.
   * 
   */
  final static int oneCreditCost = 265000;
  
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
      return (2 * _labCredit + _classCredit) * oneCreditCost;
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
  private Semester.Course[] _courseList;
  private int _semesterTuitionFee;
  private int _semesterTuitionCredits;

  /**
   * Semester's constructor.
   *
   * @param  Semester.Course[]
   */
  public Semester(Semester.Course[] courseList) {
    _courseList = courseList;

    for (int i = 0; i < courseList.length; ++i) {
      _semesterTuitionFee     += courseList[i].tuitionFee();
      _semesterTuitionCredits += courseList[i].totalCredit();
    }
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
   * This method will convert a semester total fee to a CSV string.
   *
   * @return String
   */
  public String toCSVString() {
    StringBuilder builder = new StringBuilder();

    builder.append("#");
    builder.append(", ");
    builder.append(_semesterTuitionCredits);
    builder.append(", ");
    builder.append(_semesterTuitionFee);

    return builder.toString();
  }
}
