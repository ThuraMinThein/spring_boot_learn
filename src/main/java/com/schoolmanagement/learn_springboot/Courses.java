package com.schoolmanagement.learn_springboot;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class Courses {

    @RequestMapping("courses")
    public List<Course> GetCourses() {
        return Arrays.asList(
                new Course(1, "NestJs", "Someone"),
                new Course(2, "Spring Boot", "Me")
        );
    }

}
