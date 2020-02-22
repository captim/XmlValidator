package com.netcracker.validator.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="group")
public class Group {
    private List<Student> students = new ArrayList<>();
    public List<Student> getStudents() {
        return students;
    }
    @XmlElement(name="student")
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
