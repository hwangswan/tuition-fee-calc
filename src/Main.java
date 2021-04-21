/**
 * Simple program to calculate tuition fee in a semester.
 *
 * @author trhgquan - https://github.com/trhgquan
 */

import Semester.*;
import Helper.*;

class Main {
  public static void main(String args[]) {
    if (args.length != 2) {
      System.out.println("Wrong number of arguments!");
    }
    
    else {
      try {
        String inputFile = args[0];
        String outputFile = args[1];

        Semester newSemester = Helper.Input.scanSemester(inputFile);
    
        Helper.Output.toFile(outputFile, newSemester);
      }

      catch (Exception e) {
        System.out.println("Error occured. Watch the stack trace to resolve:");

        e.printStackTrace();
      }
    }
  }
}

