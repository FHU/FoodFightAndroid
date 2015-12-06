package edu.fhu.foodfight;

import android.media.Image;
import java.util.Date;

/**
 * Created by jesse on 11/7/15.
 */

public class User {
    // attributes
    public String username;
    private Date joinDate;
    public String userFirstName;
    public String userLastName;
    private Meal[] meals;
    private Fight[] fights;
    public int level;
    public int points;
    public String imageURL;

    private Fight[] currentFights;

    private Fight[] finishedFights;

    private Meal[] bestMeals;

    private Meal[] worstMeals;

    public int numberOfFinishedFights;

    public int numberOfWins;

    private int numberOfLosses;

    private int numberOfTies;

    public int averageScore;

    public int averageScoreForBreakfast;

    public int averageScoreForLunch;

    public int averageScoreForDinner;

    private int totalScore;

    private int totalScoreForMonth;

    private int totalScoreForWeek;

    public User(String username, String firstname, String lastname, String picture, int currentLevel, int finishedFights, int wins, int averageScore, int averageScoreForBreakfast, int averageScoreForLunch, int averageScoreForDinner, int level, int points) {
        this.username = username;
        this.userFirstName = firstname;
        this.userLastName = lastname;
        this.imageURL = picture;
        this.level = currentLevel;
        this.numberOfFinishedFights = finishedFights;
        this.numberOfWins = wins;
        this.averageScore = averageScore;
        this.averageScoreForBreakfast = averageScoreForBreakfast;
        this.averageScoreForLunch = averageScoreForLunch;
        this.averageScoreForDinner = averageScoreForDinner;
        this.level = level;
        this.points = points;
    }
}
