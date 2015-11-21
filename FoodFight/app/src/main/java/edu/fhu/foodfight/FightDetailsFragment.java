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


/**
 * A simple {@link Fragment} subclass.
 */
public class FightDetailsFragment extends Fragment {

    public FightDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fight_details, null);
        CircleImageView userProfileImageView = (CircleImageView)v.findViewById(R.id.user_image_view);
        userProfileImageView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Fragment fragment;
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                fragment = new ProfileFragment();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }

        });

        CircleImageView opponentProfileImageView = (CircleImageView)v.findViewById(R.id.opponent_image_view);
        opponentProfileImageView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Fragment fragment;
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                fragment = new ProfileFragment();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }

        });

        ImageView userBreakfastImageView = (ImageView)v.findViewById(R.id.user_breakfast_image_view);
        userBreakfastImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                fragment = new MealDetailsFragment();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        });

        ImageView opponentBreakfastImageView = (ImageView)v.findViewById(R.id.opponent_breakfast_image_view);
        opponentBreakfastImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                fragment = new MealDetailsFragment();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        });

        ImageView userLunchImageView = (ImageView)v.findViewById(R.id.user_lunch_image_view);
        userLunchImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                fragment = new MealDetailsFragment();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        });

        ImageView opponentLunchImageView = (ImageView)v.findViewById(R.id.opponent_lunch_image_view);
        opponentLunchImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                fragment = new MealDetailsFragment();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        });

        ImageView userDinnerImageView = (ImageView)v.findViewById(R.id.user_dinner_image_view);
        userDinnerImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                fragment = new MealDetailsFragment();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        });

        ImageView opponentDinnerImageView = (ImageView)v.findViewById(R.id.opponent_dinner_image_view);
        opponentDinnerImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                fragment = new MealDetailsFragment();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        });

        return v;
    }

}
