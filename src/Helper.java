/**
 * Helper implementation
 *
 * Code by @trhgquan - https://github.com/trhgquan
 */

package Helper;

import java.util.*;
import java.io.*;

import Semester.*;

public class Helper {
  /**
   * This class helps input data.
   */
  public static class Input {
    public static Semester.Course scanCourse(String inputLine) {
      String[] currentLineData = inputLine.split(",", 3);
      
      Semester.Course course = new Semester.Course(currentLineData[0], Integer.parseInt(currentLineData[1]), Integer.parseInt(currentLineData[2]));

      return course;
    }

    public static Semester.Course[] scanCourseList(String inputFileName) {
      List<Semester.Course> builder = new ArrayList<Semester.Course>();

      try {
        File reader = new File(inputFileName);
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNextLine()) {
          // Get 3 field only.
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

    public static Semester scanSemester(String fileName) {
      Semester.Course[] courseList = scanCourseList(fileName);

      Semester semester = new Semester(courseList);

      return semester;
    }
  }
  
  /**
   * This class helps output data.
   */
  public static class Output { 
    public static void toFile(String outputFileName, Semester semester) {
      Semester.Course[] courseList = semester.courseList();
      
      try {
        FileWriter writer = new FileWriter(outputFileName);
        writer.write("Course name,Credits,Fee\n");

        for (int i = 0; i < courseList.length; ++i) {
          writer.write(courseList[i].toCSVString());
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
