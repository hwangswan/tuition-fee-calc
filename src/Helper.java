/**
 * Helper implementation
 *
 * Code by @trhgquan - https://github.com/trhgquan
 */

package Helper;

import java.util.*;
import java.io.*;

import Course.*;
import TuitionFee.*;
import Semester.*;

public class Helper {
  /**
   * This class helps input data.
   */
  public static class Input {
    public static Course scanCourse(String inputLine) {
      String[] currentLineData = inputLine.split(",", 3);
      
      Course course = new Course(currentLineData[0], Integer.parseInt(currentLineData[1]), Integer.parseInt(currentLineData[2]));

      return course;
    }

    public static TuitionFee[] scanTuitionFeeList(String inputFileName) {
      List<TuitionFee> builder = new ArrayList<TuitionFee>();

      try {
        File reader = new File(inputFileName);
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNextLine()) {
          // Get 3 field only.
          Course newCourse = scanCourse(scanner.nextLine());

          TuitionFee newCourseFee = new TuitionFee(newCourse);

          builder.add(newCourseFee);
        }

        scanner.close();
      } catch (FileNotFoundException e) {
        System.out.println("Error happened!");
        e.printStackTrace();
      }

      return builder.toArray(new TuitionFee[0]);
    }

    public static Semester scanSemester(String fileName) {
      TuitionFee[] tuitionFeeList = scanTuitionFeeList(fileName);

      Semester semester = new Semester(tuitionFeeList);

      return semester;
    }
  }
  
  /**
   * This class helps output data.
   */
  public static class Output { 
    public static void printToFile(String outputFileName, Semester semester) {
      TuitionFee[] TuitionFeeList = semester.tuitionFeeList();
      try {
        FileWriter writer = new FileWriter(outputFileName);
        writer.write("Course name,Credits,Fee\n");

        for (int i = 0; i < TuitionFeeList.length; ++i) {
          writer.write(TuitionFeeList[i].toCSVString());
          writer.write("\n");
        }

        writer.write(semester.toCSVString());
        
        writer.close();

        System.out.println(outputFileName + " created!");
      } catch (IOException e) {
        System.out.println("Error happened!");
        e.printStackTrace();
      }
    } 
  }
}
