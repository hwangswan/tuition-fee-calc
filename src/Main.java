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
      String inputFile  = args[0];
      String outputFile = args[1];

      Semester newSemester = Helper.Input.scanSemester(inputFile);
  
      Helper.Output.toFile(outputFile, newSemester);
    }

    catch (Exception e) {
      System.out.println("Error occurred: " + e.getMessage());

      e.printStackTrace();
    }
  }
}
