package edu.fhu.foodfight;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.graphics.*;
import java.util.*;
import android.app.FragmentTransaction;
import android.app.Fragment;


import edu.fhu.foodfight.dummy.DummyContent;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "currentUser";
    private static final String ARG_PARAM2 = "currentMeal";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private User user;


    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            user = DummyContent.UsersMap.get(mParam1);
        }


        final Fragment fragment = new MealDetailsFragment();
        final FragmentTransaction ft = getFragmentManager().beginTransaction();

        String userName = user.username;
        String firstName = user.userFirstName;
        String lastName = user.userLastName;
        String imageURL = user.imageURL;
        String gamesPlayed = Integer.toString(user.numberOfFinishedFights);
        String wins = Integer.toString(user.numberOfWins);
        String averageScore = Integer.toString(user.averageScore);
        String averageBreakfastScore = Integer.toString(user.averageScoreForBreakfast);
        String averageLunchScore = Integer.toString(user.averageScoreForLunch);
        String averageDinnerScore = Integer.toString(user.averageScoreForDinner);
        String level = Integer.toString(user.level);
        String points = Integer.toString(user.points);

        List<Meal> meals = DummyContent.Meals;

        View myInflatedView = inflater.inflate(R.layout.fragment_profile, container,false);

        TextView name = (TextView) myInflatedView.findViewById(R.id.profileName);
        ImageView image = (ImageView) myInflatedView.findViewById(R.id.profileImage);
        ImageView bestMealBreakfastImage = (ImageView) myInflatedView.findViewById(R.id.bestMealBreakfast);
        ImageView bestMealLunchImage = (ImageView) myInflatedView.findViewById(R.id.bestMealLunch);
        ImageView bestMealDinnerImage = (ImageView) myInflatedView.findViewById(R.id.bestMealDinner);

        ImageView worstMealBreakfastImage = (ImageView) myInflatedView.findViewById(R.id.worstMealBreakfast);
        ImageView worstMealLunchImage = (ImageView) myInflatedView.findViewById(R.id.worstMealLunch);
        ImageView worstMealDinnerImage = (ImageView) myInflatedView.findViewById(R.id.worstMealDinner);


        TextView gamesPlayedText = (TextView) myInflatedView.findViewById(R.id.gamesPlayedText);
        TextView winsText = (TextView) myInflatedView.findViewById(R.id.winsText);
        TextView averageScoreText = (TextView) myInflatedView.findViewById(R.id.averageScoreText);
        TextView averageBreakfastScoreText = (TextView) myInflatedView.findViewById(R.id.averageBreakfastScoreText);
        TextView averageLunchScoreText = (TextView) myInflatedView.findViewById(R.id.averageLunchScoreText);
        TextView averageDinnerScoreText = (TextView) myInflatedView.findViewById(R.id.averageDinnerScoreText);
        TextView levelText = (TextView) myInflatedView.findViewById(R.id.levelText);
        TextView pointsText = (TextView) myInflatedView.findViewById(R.id.pointsText);


        gamesPlayedText.setText(gamesPlayed);
        winsText.setText(wins);
        averageScoreText.setText(averageScore);
        averageBreakfastScoreText.setText(averageBreakfastScore);
        averageLunchScoreText.setText(averageLunchScore);
        averageDinnerScoreText.setText(averageDinnerScore);
        levelText.setText(level);
        pointsText.setText(points);

        new ImageDownloader(image).execute(imageURL);
        new ImageDownloader(bestMealBreakfastImage).execute(meals.get(0).imageURL);
        new ImageDownloader(bestMealLunchImage).execute(meals.get(1).imageURL);
        new ImageDownloader(bestMealDinnerImage).execute(meals.get(2).imageURL);

        new ImageDownloader(worstMealBreakfastImage).execute(meals.get(3).imageURL);
        new ImageDownloader(worstMealLunchImage).execute(meals.get(4).imageURL);
        new ImageDownloader(worstMealDinnerImage).execute(meals.get(5).imageURL);

        name.setText(firstName + " " + lastName);

        bestMealBreakfastImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ft.replace(R.id.content_frame, fragment);

                Bundle args = new Bundle();
                args.putString(ARG_PARAM2, "1");
                fragment.setArguments(args);

                ft.commit();

            }
        });

        bestMealLunchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft.replace(R.id.content_frame, fragment);

                Bundle args = new Bundle();
                args.putString(ARG_PARAM2, "2");
                fragment.setArguments(args);

                ft.commit();
            }
        });

        bestMealDinnerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft.replace(R.id.content_frame, fragment);

                Bundle args = new Bundle();
                args.putString(ARG_PARAM2, "3");
                fragment.setArguments(args);

                ft.commit();
            }
        });

        worstMealBreakfastImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft.replace(R.id.content_frame, fragment);

                Bundle args = new Bundle();
                args.putString(ARG_PARAM2, "4");
                fragment.setArguments(args);

                ft.commit();
            }
        });

        worstMealLunchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft.replace(R.id.content_frame, fragment);

                Bundle args = new Bundle();
                args.putString(ARG_PARAM2, "5");
                fragment.setArguments(args);

                ft.commit();
            }
        });

        worstMealDinnerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft.replace(R.id.content_frame, fragment);

                Bundle args = new Bundle();
                args.putString(ARG_PARAM2, "6");
                fragment.setArguments(args);

                ft.commit();
            }
        });

        return myInflatedView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
