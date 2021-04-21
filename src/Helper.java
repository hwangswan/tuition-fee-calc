/**
 * Helper implementation
 *
 * Code by @trhgquan - https://github.com/trhgquan
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
     */
    public static Semester.Course scanCourse(String inputLine) {
      String[] currentLineData = inputLine.split(",", 3);
      
      Semester.Course course = new Semester.Course(currentLineData[0], Integer.parseInt(currentLineData[1]), Integer.parseInt(currentLineData[2]));

      return course;
    }

    /**
     * This method return a list of Semester.Course read from a CSV file.
     *
     * @param  String
     * @return Semester.Course[]
     */
    public static Semester.Course[] scanCourseList(String inputFileName) {
      List<Semester.Course> builder = new ArrayList<Semester.Course>();

      try {
        File reader = new File(inputFileName);
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNextLine()) {
          Semester.Course newCourse = scanCourse(scanner.nextLine());

          builder.add(newCourse);
        }

        scanner.close();
      } catch (FileNotFoundException e) {
        System.out.println("Error happened!");

        e.printStackTrace();
      }

      return builder.toArray(new Semester.Course[0]);
    }

    /**
     * This method return a Semester scanned from a CSV file.
     *
     * @param  String
     * @return Semester
     */
    public static Semester scanSemester(String fileName) {
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
     */
    public static void toFile(String outputFileName, Semester semester) {
      Semester.Course[] courseList = semester.courseList();
      
      try {
        FileWriter writer = new FileWriter(outputFileName);

        // Print the file's header.
        writer.write("Course name,Credits,Fee\n");

        // Print each course in that semester.
        for (int i = 0; i < courseList.length; ++i) {
          writer.write(courseList[i].toCSVString());
          writer.write("\n");
        }

        // Print the course's total tuition fee.
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
