package edu.fhu.foodfight;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.fhu.foodfight.dummy.DummyContent;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MealDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */

public class MealDetailsFragment extends Fragment {

//    private OnFragmentInteractionListener mListener;
    private Meal mMeal;
    private static final String ARG_MEAL = "currentMeal";
    public MealDetailsFragment() {
        // Required empty public constructor
    }

    public static MealDetailsFragment newInstance(String mealKey) {
        MealDetailsFragment fragment = new MealDetailsFragment();
        Bundle args = new Bundle();
        args.putString( ARG_MEAL, mealKey );
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mealKey = getArguments().getString(ARG_MEAL);
            mMeal = DummyContent.MealsMap.get(mealKey);
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_meal_details, null);


        TextView description = (TextView) v.findViewById(R.id.descriptionText);
        TextView mealType = (TextView) v.findViewById(R.id.mealTypeText);
        ImageView ImageView = (ImageView) v.findViewById(R.id.meal_image);

        if (mMeal != null) {
            new ImageDownloader(ImageView).execute(mMeal.imageURL);

            description.setText(mMeal.description);

            switch (mMeal.mealType) {
                case BREAKFAST:
                    mealType.setText("BREAKFAST");
                    break;
                case LUNCH:
                    mealType.setText("LUNCH");
                    break;
                case DINNER:
                    mealType.setText("DINNER");
                default:
                    break;

            }
        }

        return v;

    }


//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p/>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
