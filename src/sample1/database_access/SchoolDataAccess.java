/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample1.database_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sample1.main.Main;
import sample1.model.School;
import sample1.model.School_Class;

/**
 *
 * @author sajeevan
 */
public class SchoolDataAccess {

    public static List<School> readAllSchoolDetails() {
                
//        refer https://www.w3schools.com/java/java_files_read.asp

        List<School> list_schools = new ArrayList<>();

        //        getting the current location
        String current_path = System.getProperty("user.dir");
      //  System.out.println(current_path);

//        loading the txt files to the project
        File file_schools = new File("assets\\schools.txt");
        File file_classes = new File("assets\\classes.txt");

        try {

//            creating scanners in order to read the files.. can use input streams straightaway as well..
//used scanners because it is easy with all the methods given in this class
            Scanner scanner = new Scanner(file_schools);

            scanner.nextLine();   //this line is added to read the first line (column names)
            //and to ignore it since we dont need that

//            read schools' data
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
//                System.out.println(data);

//                splitting the line from the character '|'
                String[] cellData = data.split("\\|");                  //here we put \\| because | is a meta-character in the 
                                                                          //Java regex API, therefore we have to escape it
                                                                          
//                                                            https://stackoverflow.com/questions/22217176/split-function-for-not-working
              

//                putting those data into the model object
                School school = new School(Integer.parseInt(cellData[0]), cellData[1], cellData[2], cellData[3]);
 //               System.out.println(school.getId()+" "+school.getName()+" "+school.getCity());
 //               System.out.println(school);
                list_schools.add(school);
            }
            
 //           System.out.println(list_schools);

            scanner.close();

            scanner = new Scanner(file_classes);

            scanner.nextLine();

//            reading classes' data
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
//                System.out.println(data);

                String[] cellData = data.split("\\|");
                School_Class school_Class = new School_Class(Integer.parseInt(cellData[0]),
                        cellData[1], Integer.parseInt(cellData[2]), cellData[3], cellData[4]);

//                adding class details to relevel school objects in the school list, depending on the school_id
                for (School list_school : list_schools) {
                    if (list_school.getId() == school_Class.getSchool_id()) {
                        list_school.getClasses().add(school_Class);
                        break;
                    }
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list_schools;
    }

}
