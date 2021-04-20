/**
 * Definition of a Semester.
 *
 * Code by @trhgquan - https://github.com/trhgquan
 */

package Semester;

public class Semester {
  final static int oneCreditCost = 265000;
  
  /**
   * Definition of a Course
   */
  public static class Course {
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

    public int tuitionFee() {
      return (2 * _labCredit + _classCredit) * oneCreditCost;
    }

    public String toCSVString() {
      StringBuilder builder = new StringBuilder();

      builder.append(_name);
      builder.append(",");
      builder.append(totalCredit());
      builder.append(",");
      builder.append(tuitionFee());

      return builder.toString();
    }
  }

  // Private properties.
  private Semester.Course[] _courseList;
  private int _semesterTuitionFee;
  private int _semesterTuitionCredits;

  // Constructor
  public Semester(Semester.Course[] courseList) {
    _courseList = courseList;

    for (int i = 0; i < courseList.length; ++i) {
      _semesterTuitionFee     += courseList[i].tuitionFee();
      _semesterTuitionCredits += courseList[i].totalCredit();
    }
  }

  public Semester.Course[] courseList() {
    return _courseList;
  }

  public String toCSVString() {
    StringBuilder builder = new StringBuilder();

    builder.append("#");
    builder.append(",");
    builder.append(_semesterTuitionCredits);
    builder.append(",");
    builder.append(_semesterTuitionFee);

    return builder.toString();
  }
}
