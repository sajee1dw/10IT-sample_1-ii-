/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample1.main;

import sample1.database_access.SchoolDataAccess;
import java.util.Collections;
import java.util.List;
import sample1.model.School;
import sample1.model.School_Class;

/**
 *
 * @author sajeevan
 */
public class Main {

    public static void main(String[] args) {

//        getting all the details in the text files to the object 'school_details'
        List<School> school_details = SchoolDataAccess.readAllSchoolDetails();

//        sort the data in alphabetical order
        sortData(school_details);

//        printing the details in the given format
        printData(school_details);

    }

    private static void sortData(List<School> school_details) {

//        refer https://www.techiedelight.com/sort-list-of-objects-using-comparator-java/

//  sorting school records
//        System.out.println(school_details);
        Collections.sort(school_details, School.nameComparator);

//  iterating through school records
        for (School school_detail : school_details) {
            List<School_Class> classes = school_detail.getClasses();
//            System.out.println(classes);

            //        sorting class records inside school objects
            Collections.sort(classes, School_Class.nameComparator);
        }

    }

    private static void printData(List<School> school_details) {
//        System.out.println("\n\n\n");
        for (School school_detail : school_details) {
            System.out.println(school_detail + "\n");

            List<School_Class> classes = school_detail.getClasses();
            if (classes.size() > 0) {
                for (int grade = 1; grade <= 6; grade++) {

                    String grade_string = "\tGrade " + grade + "\n";
                    boolean hasClass = false;

                    for (School_Class school_Class : classes) {
                        if (school_Class.getGrade() == grade) {
                            hasClass = true;
                            String class_string = "\t\t" + school_Class.getClass_name() + " from " + school_Class.getStart_date() + " , " + school_Class.getDuration() + "\n";
                            grade_string += class_string;
                        }
                    }
                    if (hasClass) {
                        System.out.println(grade_string);
                    }
                }
            }
            System.out.println("\n\n\n");
        }
    }
}
