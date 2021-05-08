/**
 * Helper implementation
 *
 * @author trhgquan - https://github.com/trhgquan
 */

package Helper;

import java.util.*;
import java.io.*;

import Semester.*;

/**
 * This class provides some helper functions
 * in order to help developers output to a CSV file / input from a CSV file.
 *
 * @author trhgquan - https://github.com/trhgquan
 */
public class Helper {
  /**
   * This class is all about input.
   *
   */
  public static class Input {
    /**
     * This method return a Semester.Course object from a CSV line.
     *
     * @param  String
     * @return Semester.Course
     * @throws Exception
     */
    public static Semester.Course scanCourse(String inputLine) throws Exception {
      String[] currentLineData = inputLine.split(",", 3);

      // Added string.trim(), since numbers in .csv can have spaces before & after.
      Semester.Course course = new Semester.Course(currentLineData[0],
                                                   Integer.parseInt(currentLineData[1].trim()),
                                                   Integer.parseInt(currentLineData[2].trim()));

      return course;
    }

    /**
     * This method return a list of Semester.Course read from a CSV file.
     *
     * @param  String
     * @return Semester.Course[]
     * @throws Exception
     */
    public static Semester.Course[] scanCourseList(String inputFileName) throws Exception {
      List<Semester.Course> builder = new ArrayList<Semester.Course>();

      // Create a new file reader.
      File reader = new File(inputFileName);

      // Create a new file scanner.
      Scanner scanner = new Scanner(reader);

      // Scan through lines.
      while (scanner.hasNextLine()) {
        Semester.Course newCourse = scanCourse(scanner.nextLine());

        builder.add(newCourse);
      }

      // Close the scanner
      scanner.close();

      // Return the array. Notice that we must initialise the array with new Semester.Course.
      return builder.toArray(new Semester.Course[0]);
    }

    /**
     * This method return a Semester scanned from a CSV file.
     *
     * @param  String
     * @return Semester
     * @throws Exception
     */
    public static Semester scanSemester(String fileName) throws Exception {
      Semester.Course[] courseList = scanCourseList(fileName);

      Semester semester = new Semester(courseList);

      return semester;
    }
  }
  
  /**
   * This class is all about output.
   *
   */
  public static class Output {
    /**
     * This method print the Semester to a CSV file.
     *
     * @param  String
     * @param  Semester
     * @throws Exception
     */
    public static void toFile(String outputFileName, Semester semester) throws Exception {
      Semester.Course[] courseList = semester.courseList();
      
      // Create a new file writer.
      FileWriter writer = new FileWriter(outputFileName);

      // Print the file's header.
      writer.write("Course name, Credits, Fee\n");

      // Print each course in that semester.
      for (int i = 0; i < courseList.length; ++i) {
        writer.write(courseList[i].toCSVString());
        writer.write("\n");
      }

      // Print the course's total tuition fee.
      writer.write(semester.toCSVString());

      // Close the file writer. 
      writer.close();

      // Notice the user.
      System.out.println(outputFileName + " created!");
    } 
  }
}
