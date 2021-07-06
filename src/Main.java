/**
 * Simple program to calculate tuition fee in a semester.
 *
 * @author trhgquan - https://github.com/trhgquan
 */

import Semester.*;
import Helper.*;

class Main {
  /**
   * Main driver for the program.
   *
   * @param  String[]
   */
  public static void main(String args[]) {
    try {
      // Get files from parameter.
      String inputFile  = args[0];
      String outputFile = args[1];

      // Create a new Semester.
      Semester newSemester = Helper.Input.scanSemester(inputFile);

      // Set class cost from Config.
      newSemester.setClassCost(Integer.parseInt(
                                      Helper.Config
                                      .getInstance()
                                      .load("tuition-fee-calc.class")));

      // Set lab cost from Config.
      newSemester.setLabCost(Integer.parseInt(
                                    Helper.Config
                                    .getInstance()
                                    .load("tuition-fee-calc.lab")));

      // Print Semester cost to file.
      Helper.Output.toFile(outputFile, newSemester);
    }

    catch (Exception e) {
      System.out.println("Error occurred: " + e.getMessage());

      e.printStackTrace();
    }
  }
}
