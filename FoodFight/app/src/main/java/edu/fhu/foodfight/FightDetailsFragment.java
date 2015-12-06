package edu.fhu.foodfight;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;

import edu.fhu.foodfight.dummy.DummyContent;


/**
 * A simple {@link Fragment} subclass.
 */
public class FightDetailsFragment extends Fragment {

    private Fight mFight;

    // args used for this fragment
    private static final String ARG_FIGHT = "FIGHT";

    // args used to pass to other fragments
    private static final String ARG_USER = "currentUser";

    private static User currentUser = DummyContent.CurrentUser;
    private static User opponent;
    private static ArrayList<Meal> userMeals;
    private static ArrayList<Meal> opponentMeals;
    private static Meal userBreakfast;
    private static Meal userLunch;
    private static Meal userDinner;
    private static Meal opponentBreakfast;
    private static Meal opponentLunch;
    private static Meal opponentDinner;

    public FightDetailsFragment() {
        // Required empty public constructor
    }

    public static FightDetailsFragment newInstance(String fightKey) {
        FightDetailsFragment fragment = new FightDetailsFragment();
        Bundle args = new Bundle();
        args.putString( ARG_FIGHT, fightKey );
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String fightKey = getArguments().getString(ARG_FIGHT);
            mFight = DummyContent.FightsMap.get(fightKey);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        currentUser = DummyContent.CurrentUser;
        opponent = null;
        userMeals = new ArrayList<Meal>();
        opponentMeals = new ArrayList<Meal>();
        userBreakfast = null;
        userLunch = null;
        userDinner = null;
        opponentBreakfast = null;
        opponentLunch = null;
        opponentDinner = null;

        if (currentUser.username == mFight.userId) {
            opponent = DummyContent.UsersMap.get(mFight.opponentId);
            userMeals = mFight.userMeals;
            opponentMeals = mFight.opponentMeals;

        } else {
            opponent = DummyContent.UsersMap.get(mFight.userId);
            userMeals = mFight.opponentMeals;
            opponentMeals = mFight.userMeals;
        }

        for (Meal meal : userMeals) {
            switch (meal.mealType) {
                case BREAKFAST:
                    userBreakfast = meal;
                    break;
                case LUNCH:
                    userLunch = meal;
                    break;
                case DINNER:
                    userDinner = meal;
                default:
                    break;
            }
        }

        for (Meal meal : opponentMeals) {
            switch (meal.mealType) {
                case BREAKFAST:
                    opponentBreakfast = meal;
                    break;
                case LUNCH:
                    opponentLunch = meal;
                    break;
                case DINNER:
                    opponentDinner = meal;
                default:
                    break;
            }
        }

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fight_details, null);

        TextView userFirstName = (TextView)v.findViewById(R.id.user_first_name_text_view);
        userFirstName.setText(currentUser.userFirstName);

        TextView opponentFirstName = (TextView)v.findViewById(R.id.opponent_first_name_text_view);
        opponentFirstName.setText(opponent.userFirstName);

        CircleImageView userProfileImageView = (CircleImageView)v.findViewById(R.id.user_image_view);
        new ImageDownloader(userProfileImageView).execute(currentUser.imageURL);
        userProfileImageView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Fragment fragment;
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                fragment = new ProfileFragment();
                ft.replace(R.id.content_frame, fragment);

                Bundle args = new Bundle();
                args.putString(ARG_USER, currentUser.username);
                fragment.setArguments(args);

                ft.commit();
            }

        });

        CircleImageView opponentProfileImageView = (CircleImageView)v.findViewById(R.id.opponent_image_view);
        new ImageDownloader(opponentProfileImageView).execute(opponent.imageURL);
        opponentProfileImageView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Fragment fragment;
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                fragment = new ProfileFragment();
                ft.replace(R.id.content_frame, fragment);

                Bundle args = new Bundle();
                args.putString(ARG_USER, opponent.username);
                fragment.setArguments(args);

                ft.commit();
            }

        });

        ImageView userBreakfastImageView = (ImageView)v.findViewById(R.id.user_breakfast_image_view);
        if (userBreakfast != null) {
            new ImageDownloader(userBreakfastImageView).execute(userBreakfast.imageURL);
        }
        userBreakfastImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment;
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                if (userBreakfast != null) {
                    fragment = new MealDetailsFragment();
                } else {
                    fragment = new CameraFragment();
                }

                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        });

        ImageView opponentBreakfastImageView = (ImageView)v.findViewById(R.id.opponent_breakfast_image_view);
        if (opponentBreakfast != null) {
            new ImageDownloader(opponentBreakfastImageView).execute(opponentBreakfast.imageURL);
        }
        opponentBreakfastImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opponentBreakfast != null) {
                    Fragment fragment;
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    fragment = new MealDetailsFragment();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }
            }
        });

        ImageView userLunchImageView = (ImageView)v.findViewById(R.id.user_lunch_image_view);
        if (userLunch != null) {
            new ImageDownloader(userLunchImageView).execute(userLunch.imageURL);
        }
        userLunchImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                if (userLunch != null) {
                    fragment = new MealDetailsFragment();
                } else {
                    fragment = new CameraFragment();
                }

                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        });

        ImageView opponentLunchImageView = (ImageView)v.findViewById(R.id.opponent_lunch_image_view);
        if (opponentLunch != null) {
            new ImageDownloader(opponentLunchImageView).execute(opponentLunch.imageURL);
        }
        opponentLunchImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opponentLunch != null) {
                    Fragment fragment;
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    fragment = new MealDetailsFragment();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }
            }
        });

        ImageView userDinnerImageView = (ImageView)v.findViewById(R.id.user_dinner_image_view);
        if (userDinner != null) {
            new ImageDownloader(userDinnerImageView).execute(userDinner.imageURL);
        }
        userDinnerImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                if (userDinner != null) {
                    fragment = new MealDetailsFragment();
                } else {
                    fragment = new CameraFragment();
                }

                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        });

        ImageView opponentDinnerImageView = (ImageView)v.findViewById(R.id.opponent_dinner_image_view);
        if (opponentDinner != null) {
            new ImageDownloader(opponentDinnerImageView).execute(opponentDinner.imageURL);
        }
        opponentDinnerImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opponentDinner != null) {
                    Fragment fragment;
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    fragment = new MealDetailsFragment();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }
            }
        });

        return v;
    }

}
