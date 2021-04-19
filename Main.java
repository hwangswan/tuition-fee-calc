/**
 * Simple program to calculate tuition fee in a semester.
 *
 * Code by @trhgquan - https://github.com/trhgquan
 */
import java.io.*;
import java.util.*;

import Course.*;
import TuitionFee.*;
import Semester.*;

class Main {
  public static void main(String args[]) {
    // Create new file.
    Scanner scanner = new Scanner(System.in);

    System.out.println("Nhap tong so mon hoc ky nay:");
    int n = scanner.nextInt();
    scanner.nextLine();

    TuitionFee[] tuitionFeeList = new TuitionFee[n];

    for (int i = 0; i < n; ++i) {
      System.out.println("===  #" + (i + 1) + " ===");
      System.out.println("Nhap ten mon hoc:");
      String courseName = scanner.nextLine();

      System.out.println("Nhap so tin chi ly thuyet:");
      int courseClassCredit = scanner.nextInt();
      scanner.nextLine();

      System.out.println("Nhap so tin chi thuc hanh:");
      int courseLabCredit = scanner.nextInt();
      scanner.nextLine();

      Course newCourse = new Course(courseName, courseClassCredit, courseLabCredit);
      tuitionFeeList[i] = new TuitionFee(newCourse);
    }

    Semester semester = new Semester(tuitionFeeList);

    resultHelper.printToFile(semester);
  }
}

class resultHelper {
  final static String outputFileName = "tuition-fee.csv";
  
  public static void printToFile(Semester semester) {
    TuitionFee[] TuitionFeeList = semester.tuitionFeeList();
    try {
      FileWriter writer = new FileWriter(outputFileName);
      writer.write("Course name,Credits,Fee\n");

      for (int i = 0; i < TuitionFeeList.length; ++i) {
        writer.write(TuitionFeeList[i].toString());
        writer.write("\n");
      }

      writer.write(semester.toString());
      
      writer.close();
    } catch (IOException e) {
      System.out.println("Error happened!");
      e.printStackTrace();
    }
  }
}

