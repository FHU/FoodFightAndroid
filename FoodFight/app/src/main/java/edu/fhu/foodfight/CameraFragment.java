package edu.fhu.foodfight;


import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import android.widget.EditText;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View.OnTouchListener;
import android.content.Intent;
import android.provider.MediaStore;
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

        View myInflatedView = inflater.inflate(R.layout.fragment_camera, container, false);
//
        final RelativeLayout cameraLayout = (RelativeLayout) myInflatedView.findViewById(R.id.cameraRelativeLayout);
        //FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) cameraLayout.getLayoutParams();
//        params.height = params.width;
//        Log.i("get messured width", Integer.toString(cameraLayout.getWidth()));
//        Log.i("params.width", Integer.toString(params.width));
//        Log.i("params.height", Integer.toString(params.height));
//        WindowManager.LayoutParams wlp = new WindowManager.LayoutParams();
//        Log.i("windows", Integer.toString((wlp.width)));
//        cameraLayout.postInvalidate();


        final EditText myTextBox = (EditText) myInflatedView.findViewById(R.id.editText);
        myTextBox.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                }
            }

        });
        myTextBox.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });

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
                } else {
                    toggle3.setChecked(!isChecked);
                }
            }

        });

        final ImageButton imageButton = (ImageButton) myInflatedView.findViewById(R.id.imageButton);

        imageButton.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){

                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchTakePictureIntent();
                }

                return false;
            }
        });

        Button myBtn = (Button) myInflatedView.findViewById(R.id.submitButton);
        myBtn.requestFocus();

        return myInflatedView;

    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//        }
    }

}
