/**
 * Calculate tuition fee of a course.
 *
 * Code by @trhgquan - https://github.com/trhgquan
 */

package TuitionFee;

import Course.*;

public class TuitionFee {
  private Course _course;

  public TuitionFee(Course course) {
    _course = course;  
  }

  public int calculate() {
    return (_course.classCredit() + 2 * _course.labCredit());
  }

  public int totalCredit() {
    return _course.totalCredit();
  }

  public String toCSVString() {
    StringBuilder builder = new StringBuilder();

    builder.append(_course.name());
    builder.append(",");
    builder.append(_course.totalCredit());
    builder.append(",");
    builder.append(calculate());

    return builder.toString();
  }
}
