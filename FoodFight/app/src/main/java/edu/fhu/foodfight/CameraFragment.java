package edu.fhu.foodfight;


import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.CompoundButton;
import android.graphics.Color;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CameraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CameraFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public boolean tog1, tog2, tog3 = (boolean) false;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CameraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CameraFragment newInstance(String param1, String param2) {
        CameraFragment fragment = new CameraFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CameraFragment() {
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
        // Inflate the layout for this fragment

        Log.i("onCreatetog1: ", Boolean.toString(tog1));
        Log.i("onCreatetog2: ", Boolean.toString(tog2));
        Log.i("onCreatetog3: ", Boolean.toString(tog3));
        View myInflatedView = inflater.inflate(R.layout.fragment_camera, container, false);
//
//        RelativeLayout cameraLayout = (RelativeLayout) myInflatedView.findViewById(R.id.cameraRelativeLayout);
//        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) cameraLayout.getLayoutParams();
//        params.height = params.width;
//        Log.i("get messured width", Integer.toString(cameraLayout.getWidth()));
//        Log.i("params.width", Integer.toString(params.width));
//        Log.i("params.height", Integer.toString(params.height));
//        WindowManager.LayoutParams wlp = new WindowManager.LayoutParams();
//        Log.i("windows", Integer.toString((wlp.width)));
//        cameraLayout.postInvalidate();


        final ToggleButton toggle1 = (ToggleButton) myInflatedView.findViewById(R.id.toggleButton1);
        toggle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!tog2 && !tog3) {
                    if (isChecked) {
                        toggle1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        toggle1.setTextColor(Color.parseColor("#FFFFFF"));
                        tog1 = true;
                    } else {
                        toggle1.setBackgroundResource(R.drawable.rectangle_without_circle_small);
                        toggle1.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tog1 = false;
                    }
                } else {
                    toggle1.setChecked(!isChecked);
                }
                Log.i("tog1: ", Boolean.toString(tog1));
            }
        });


        final ToggleButton toggle2 = (ToggleButton) myInflatedView.findViewById(R.id.toggleButton2);
        toggle2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!tog1 && !tog3) {
                    if (isChecked) {
                        toggle2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        toggle2.setTextColor(Color.parseColor("#FFFFFF"));
                        tog2 = true;
                    } else {
                        toggle2.setBackgroundResource(R.drawable.rectangle_without_circle_small);
                        toggle2.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tog2 = false;
                    }
                } else {
                    toggle2.setChecked(!isChecked);
                }
                Log.i("tog2: ", Boolean.toString(tog2));
            }

        });

        final ToggleButton toggle3 = (ToggleButton) myInflatedView.findViewById(R.id.toggleButton3);
        toggle3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!tog1 && !tog2) {
                    if (isChecked) {
                        toggle3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        toggle3.setTextColor(Color.parseColor("#FFFFFF"));
                        tog3 = true;
                    } else {
                        toggle3.setBackgroundResource(R.drawable.rectangle_without_circle_small);
                        toggle3.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tog3 = false;
                    }
                    Log.i("tog3: ", Boolean.toString(tog3));
                } else {
                    toggle3.setChecked(!isChecked);
                }
            }

        });


        return myInflatedView;

    }


}
