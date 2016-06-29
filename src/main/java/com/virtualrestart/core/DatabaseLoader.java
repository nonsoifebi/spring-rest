package com.virtualrestart.core;

import com.virtualrestart.course.Course;
import com.virtualrestart.course.CourseRepository;
import com.virtualrestart.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by nonso on 28/06/16.
 */

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final CourseRepository courses;

    @Autowired
    public DatabaseLoader(CourseRepository courses) {
        this.courses = courses;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Course course = new Course("Spring Basics", "https://google.com");
        course.addReviews(new Review(3, "You ARE a dork"));
        courses.save(course);

        String[] templates = {
                "Up and Running with  %s",
                "%s Basics",
                "%s for Beginners",
                "%s for Neckbeards",
                "Under the hood: %s"
        };
        String[] buzzwords = {
                "Spring REST Data",
                "Java 9",
                "Scala",
                "Groovy",
                "Hibernate",
                "Spring HATEOAS"
        };

        List<Course> coursesList = new ArrayList<>();

        IntStream.range(0,100).forEach(i -> {
            String template = templates[i % templates.length];
            String buzzword = buzzwords[i % buzzwords.length];
            String title = String.format(template, buzzword);
            Course course1 = new Course(title, "https://google.com");
            course1.addReviews(new Review(i % 5, String.format("More %s please!!!", buzzword)));
            coursesList.add(course1);
        });
        courses.save(coursesList);

    }
}
