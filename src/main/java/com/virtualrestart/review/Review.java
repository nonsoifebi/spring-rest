package com.virtualrestart.review;

import com.virtualrestart.core.BaseEntity;
import com.virtualrestart.course.Course;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by nonso on 28/06/16.
 */

@Entity
public class Review extends BaseEntity {

    private int ratings;
    private String description;



    @ManyToOne
    private Course course;

    protected Review(){
        super();
    }

    public Review(int ratings, String description) {
        this.ratings = ratings;
        this.description = description;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
