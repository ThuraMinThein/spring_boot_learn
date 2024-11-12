package com.schoolmanagement.learn_springboot;

import org.apache.logging.log4j.message.Message;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class Courses {

    @GetMapping()
    public List<Course> GetCourses() {
        return Arrays.asList(
                new Course(1, "NestJs", "Someone"),
                new Course(2, "Spring Boot", "Me")
        );
    }

    @PostMapping()
    public String Post(
        @RequestBody String body
            ) {
        return body;
    }

}
