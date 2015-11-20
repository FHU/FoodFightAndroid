package edu.fhu.foodfight;

/**
 * Created by Elijah on 11/19/15.
 */

    import android.os.Bundle;
    import android.support.v4.app.Fragment;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.view.Menu;

    public class MealDetailFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle
                                         savedInstanceState) {
            // Inflate the layout for this fragment
            View view =  inflater.inflate(R.layout.fragment_mealdetail,
                    container, false);
            return view;
        }


    }
