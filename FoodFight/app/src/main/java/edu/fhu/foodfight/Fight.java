package edu.fhu.foodfight;

import java.util.Date;
import java.util.Dictionary;

/**
 * Created by jesse on 11/7/15.
 */
public class Fight {
    // attributes

    public Date startDate = new Date();
    public Date endDate = new Date();

    public String meId = "";
    public String rivalId = "";

    public String currentMeal = "BREAKFAST";

    public int numberOfMeals = 0;

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

    public Fight(Date startDate, Date endDate, String thisId, String rivalId, int numberOfMeals ) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.meId = thisId;
        this.rivalId = rivalId;
        this.numberOfMeals = numberOfMeals;
    }
}
