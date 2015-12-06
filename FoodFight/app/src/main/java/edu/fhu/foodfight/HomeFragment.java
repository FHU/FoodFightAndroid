package edu.fhu.foodfight;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import edu.fhu.foodfight.dummy.DummyContent;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);


        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
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

    FightsAdapter fightsListAdapter;
    ExpandableListView fightsListView;
    List<String> fightSections;
    HashMap<String, List<Fight>> fightSectionChildData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View homeView = inflater.inflate(R.layout.fragment_home, container, false);


        FloatingActionButton fab = (FloatingActionButton) homeView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newFight();
            }
        });

//        FightsAdapter fightAdapter = new FightsAdapter(this.getActivity(), DummyContent.Fights );
//        FightsAdapter finishedFightsAdapter = new FightsAdapter(this.getActivity(), DummyContent.Fights);
//        ExpandableListView fightListView = (ListView) homeView.findViewById(R.id.currentfights);
//        ListView finishedFightsListView = (ListView) homeView.findViewById(R.id.finishedFights);
//        fightListView.setAdapter(fightAdapter);
//        finishedFightsListView.setAdapter(fightAdapter);

        fightsListView = (ExpandableListView) homeView.findViewById(R.id.fightsExpandableListView);

        fightSections = new ArrayList<String>();
        fightSections.add("Current Fights");
        fightSections.add("Finished Fights");

        fightSectionChildData = new HashMap<String, List<Fight>>();
        fightSectionChildData.put(fightSections.get(0), DummyContent.getCurrentFights());
        fightSectionChildData.put(fightSections.get(1), DummyContent.getFinishedFights());


        fightsListAdapter = new FightsAdapter(getActivity().getApplicationContext(), fightSections, fightSectionChildData);

        fightsListView.setAdapter(fightsListAdapter);

        return homeView;
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

    public void newFight() {
        Fragment fragment;
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        fragment = new FightDetailsFragment();
        ft.add(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void viewFight(Fight fightItem) {
        Fragment fragment;
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        fragment = FightDetailsFragment.newInstance(fightItem.id);


        ft.replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit();
    }

}
