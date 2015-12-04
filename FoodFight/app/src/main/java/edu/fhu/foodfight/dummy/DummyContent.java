package edu.fhu.foodfight.dummy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.media.Image;

import edu.fhu.foodfight.Fight;
import edu.fhu.foodfight.Meal;
import edu.fhu.foodfight.MealType;
import edu.fhu.foodfight.User;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    public static User CurrentUser;

    /**
     * An array items
     */
    public static List<User> Users = new ArrayList<User>();
    public static List<Fight> Fights = new ArrayList<Fight>();
    public static List<Meal> Meals = new ArrayList<Meal>();


    /**
     * A map of items, by ID.
     */
    public static Map<String, User> UsersMap = new HashMap<String, User>();
    public static Map<String, Fight> FightsMap = new HashMap<String, Fight>();
    public static Map<String, Meal> MealsMap = new HashMap<String, Meal>();

    static {
        // Add 3 sample items.
        addUser(new User("Harry", "Harry", "Potter", "http://cdn.playbuzz.com/cdn/05612ae3-0911-4e51-8ff5-0c5b1b580cbf/5c212545-2724-4231-9805-82e931028689.jpg", 40));
        addUser(new User("Hermione", "Hermione", "Granger", "https://flavorwire.files.wordpress.com/2015/09/harry-potter-top-10-hermione-granger-moments-hermione-granger-358045.jpg", 30));
        addUser(new User("Ron", "Ron", "Weasley", "http://cdn.collider.com/wp-content/uploads/2015/07/ron-weasley.jpg", 32));
        addUser(new User("Snape", "Severus", "Snape", "http://media1.s-nbcnews.com/i/newscms/2015_24/620026/severus-snape-alan-rickman-hary-potter-2-today-tease-150608_a331468573cda45156990ab430cfadcb.jpg", 7));


        Meal meal1 = new Meal("1", 87, MealType.BREAKFAST, new Date(), "https://www.parentmap.com/c/51b0d6be/images/food/breakfast_for_dinner.jpg");
        Meal meal2 = new Meal("2", 56, MealType.LUNCH, new Date(), "http://newyork.seriouseats.com/images/20120221-baobq-specials-1.jpg");
        Meal meal3 = new Meal("3", 42, MealType.DINNER, new Date(), "http://www.ziadiner.com/wp-content/uploads/Restaurant-Santa-Fe-Zia-Diner-Lunch-Dinner-Menu-Dishes-Zia-Diner-Event-Calendar-a.jpg");
        Meal meal4 = new Meal("4", 23, MealType.BREAKFAST, new Date(2015, 2, 24), "http://i.huffpost.com/gen/1062480/images/o-QUICK-BREAKFAST-RECIPES-facebook.jpg");
        Meal meal5 = new Meal("5", 1, MealType.LUNCH, new Date(2015, 2, 24), "http://honestcooking.com/wp-content/uploads/2011/05/Schoollunch.jpg");
        Meal meal6 = new Meal("6", 99, MealType.DINNER, new Date(2015, 2, 24), "http://allears.net/dining/images/menu_item_image_68.jpg");

        List<Meal> meals1 = new ArrayList<Meal>();
        meals1.add(meal1);
        meals1.add(meal2);
        meals1.add(meal3);

        List<Meal> meals2 = new ArrayList<Meal>();
        meals2.add(meal4);
        meals2.add(meal5);
        meals2.add(meal6);

        addMeal(meal1);
        addMeal(meal2);
        addMeal(meal3);
        addMeal(meal4);
        addMeal(meal5);
        addMeal(meal6);

        Fight harryRon = new Fight(new Date(), new Date(), "Harry", "Ron", "harryRon");
        harryRon.userMeals.addAll(meals1);
        harryRon.opponentMeals.addAll(meals2);
        addFight(harryRon);

        Fight harryHermione = new Fight(new Date(), new Date(), "Harry", "Hermione", "harryHermione");
        harryRon.userMeals.addAll(meals1);
        harryRon.opponentMeals.addAll(meals2);
        addFight(harryHermione);

        Fight harrySnape =new Fight(new Date(), new Date(), "Harry", "Snape" ,"harrySnape" );
        harrySnape.userMeals.addAll(meals1);
        harrySnape.opponentMeals.addAll(meals2);
        addFight(harrySnape);

        //set current user to first user in array
        CurrentUser = Users.get(0);
    }

    private static void addUser(User user) {
        Users.add(user);
        UsersMap.put(user.username, user);
    }

    private static void addFight(Fight fight) {
        Fights.add(fight);
        FightsMap.put(fight.userId, fight);
    }

    private static void addMeal(Meal meal) {
        Meals.add(meal);
        MealsMap.put(meal.id, meal);
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;

        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
