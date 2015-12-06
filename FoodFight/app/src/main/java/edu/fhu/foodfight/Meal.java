package edu.fhu.foodfight;

import android.media.Image;
import java.util.Date;

public class Meal {
    // attributes
    public String id;

    public String imageURL;
    public int score;
    public String description;
    public MealType mealType;
    private Date submissionDate;

    // methods

    public Meal(String id, int score, MealType mealType, Date submissionDate, String url, String description) {
        this.id = id;
        this.score = score;
        this.mealType = mealType;
        this.submissionDate = submissionDate;
        this.imageURL = url;
        this.description = description;
    }
}
