/**
 * Definition of a Semester.
 *
 * Code by @trhgquan - https://github.com/trhgquan
 */

package Semester;

import TuitionFee.*;

public class Semester {
  // Change this.
  private int oneCreditFee = 265000;

  // Private properties.
  private TuitionFee[] _tuitionFeeList;
  private int _semesterTuitionFee;
  private int _semesterTuitionCredits;

  // Constructor
  public Semester(TuitionFee[] tuitionFeeList) {
    _tuitionFeeList = tuitionFeeList;

    for (int i = 0; i < tuitionFeeList.length; ++i) {
      _semesterTuitionFee     += tuitionFeeList[i].calculate() * oneCreditFee;
      _semesterTuitionCredits += tuitionFeeList[i].totalCredit();
    }
  }

  public TuitionFee[] tuitionFeeList() {
    return _tuitionFeeList;
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