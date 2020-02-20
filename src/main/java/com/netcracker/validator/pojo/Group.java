package com.netcracker.validator.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Group {
    private List<Student> students = new ArrayList<>();
    @XmlElement(name="student")
    public void setStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Group{" +
                "students=" + students +
                '}';
    }
}
