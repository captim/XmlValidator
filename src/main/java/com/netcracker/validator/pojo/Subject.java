package com.netcracker.validator.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Subject {
    private String title;
    private float mark;

    public String getTitle() {
        return title;
    }
    @XmlAttribute(name="title")
    public void setTitle(String title) {
        this.title = title;
    }

    public float getMark() {
        return mark;
    }
    @XmlAttribute(name="mark")
    public void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "title='" + title + '\'' +
                ", mark=" + mark +
                '}';
    }
}
