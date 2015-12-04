package edu.fhu.foodfight;

import android.media.Image;
import java.util.Date;

public class Meal {
    // attributes
    public String id;

    public String imageURL;
    private int score;
    private String description;
    private MealType mealType;
    private Date submissionDate;

    // methods

    public Meal(String id, int score, MealType mealType, Date submissionDate) {
        this.id = id;
        this.score = score;
        this.mealType = mealType;
        this.submissionDate = submissionDate;
    }
}
