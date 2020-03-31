/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample1.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author sajeevan
 */
public class School {
    private int id;
    private String name;
    private String city;
    private String phone;
    private List<School_Class> classes = new ArrayList<>();

    public School(int id, String name, String city, String phone) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.phone = phone;
    }

    public School() {
    }

    
    
    public List<School_Class> getClasses() {
        return classes;
    }

    public void setClasses(List<School_Class> classes) {
        this.classes = classes;
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public static Comparator<School> nameComparator =  new Comparator<School>() {
        @Override
        public int compare(School o1, School o2) {
            return (int) (o1.getName()).compareTo(o2.getName());
        }
    };

    @Override
    public String toString() {
        return name + ", " + city ;
    }
    
    
    
}
