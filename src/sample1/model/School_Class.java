/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample1.model;

import java.util.Comparator;

/**
 *
 * @author sajeevan
 */
public class School_Class {

    private String class_name;
    private int grade;
    private String start_date;
    private String duration;
    private int school_id;

    public School_Class(int school_id, String class_name, int grade, String start_date, String duration) {
        this.class_name = class_name;
        this.grade = grade;
        this.start_date = start_date;
        this.duration = duration;
        this.school_id = school_id;
    }

    public School_Class() {
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    /**
     * @return the class_name
     */
    public String getClass_name() {
        return class_name;
    }

    /**
     * @param class_name the class_name to set
     */
    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    /**
     * @return the grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * @return the start_date
     */
    public String getStart_date() {
        return start_date;
    }

    /**
     * @param start_date the start_date to set
     */
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public static Comparator<School_Class> nameComparator =  new Comparator<School_Class>() {
        @Override
        public int compare(School_Class o1, School_Class o2) {
            return (int) (o1.getClass_name()).compareTo(o2.getClass_name());
        }
    };
}
