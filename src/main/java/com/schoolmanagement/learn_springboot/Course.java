package com.schoolmanagement.learn_springboot;

public class Course {

    private long id;
    private String course;
    private String name;

    public Course(long id, String course, String name) {
        super();
        this.id = id;
        this.course = course;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course='" + course + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
