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
    private int level;
    public Image profilePicture;

    private Fight[] currentFights;

    private Fight[] finishedFights;

    private Meal[] bestMeals;

    private Meal[] worstMeals;

    private int numberOfFinishedFights;

    private int numberOfWins;

    private int numberOfLosses;

    private int numberOfTies;

    private int averageScoreForMealType;

    private int totalScore;

    private int totalScoreForMonth;

    private int totalScoreForWeek;

    public User(String username, String firstname, String lastname, Image picture, int currentLevel) {
        this.username = username;
        this.userFirstName = firstname;
        this.userLastName = lastname;
        this.profilePicture = picture;
        this.level = currentLevel;
    }
}
