/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
/**
 *
 * @author admin
 */
public class Human {
    private int ID;
    private String Name;
    private Date dob;
    private boolean Gender;
    private HumanType type;

    public Human() {
    }

    public Human(int ID, String Name, Date dob, boolean Gender, HumanType type) {
        this.ID = ID;
        this.Name = Name;
        this.dob = dob;
        this.Gender = Gender;
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public HumanType getType() {
        return type;
    }

    public void setType(HumanType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Human{" + "ID=" + ID + ", Name=" + Name + ", dob=" + dob + ", Gender=" + Gender + ", type=" + type + '}';
    }

    
    
    
}
