/**
 * Simple program to calculate tuition fee in a semester.
 *
 * Code by @trhgquan - https://github.com/trhgquan
 */
import java.io.*;
import java.util.*;

import Semester.*;
import Helper.*;

class Main {
  public static void main(String args[]) {
    if (args.length != 2) {
      System.out.println("Wrong number of arguments!");
    }
    
    else {
      String inputFile = args[0];
      String outputFile = args[1];

      Semester newSemester = Helper.Input.scanSemester(inputFile);
    
      Helper.Output.printToFile(outputFile, newSemester);
    }
  }
}

