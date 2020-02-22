package com.netcracker.validator.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String LastName;
    private String groupId;
    private List<Subject> subjects = new ArrayList<>();
    private float average;

    public String getFirstName() {
        return firstName;
    }
    @XmlAttribute(name="firstname")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }
    @XmlAttribute(name="lastname")
    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGroupId() {
        return groupId;
    }
    @XmlAttribute(name="groupnumber")
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public List<Subject> getSubjects() {
        return subjects;
    }
    @XmlElement(name="subject")
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    public float getAverage() {
        return average;
    }
    @XmlElement(name="average")
    public void setAverage(float average) {
        this.average = average;
    }
}
