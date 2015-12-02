package edu.fhu.foodfight;

import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;

/**
 * Created by jesse on 11/7/15.
 */
public class Fight  {
    // attributes

    public String id;

    public String userId;
    public String opponentId = "";

    public Date startDate = new Date();
    public Date endDate = new Date();

    public String currentMeal = "BREAKFAST";

    public ArrayList<Meal> userMeals = new ArrayList<Meal>();
    public ArrayList<Meal> opponentMeals= new ArrayList<Meal>();

    public int numberOfMeals = 3;

    public Boolean isFightFinished() {
        if (endDate.getTime() - startDate.getTime() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public StringBuilder str_timeRemaining() {
        long difference = endDate.getTime() - startDate.getTime();

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = difference / daysInMilli;
        difference = difference % daysInMilli;

        long elapsedHours = difference / hoursInMilli;
        difference = difference % hoursInMilli;

        long elapsedMinutes = difference / minutesInMilli;
        difference = difference % minutesInMilli;

        long elapsedSeconds = difference / secondsInMilli;

        return new StringBuilder()
                .append(elapsedDays).append(" days ")
                .append(elapsedHours).append(" hours ")
                .append(elapsedMinutes).append("minutes ");
    }

    public String getCurrentMeal() {
        return currentMeal;
    }

    public void setCurrentMeal(String meal) {
       this.currentMeal = meal;
    }

    public Fight(Date startDate, Date endDate, String userId, String opponentId, String fightId ) {
        this.id = fightId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = userId;
        this.opponentId = opponentId;
    }
}
