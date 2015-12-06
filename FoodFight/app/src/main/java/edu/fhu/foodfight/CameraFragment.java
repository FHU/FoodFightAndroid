package edu.fhu.foodfight;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.content.BroadcastReceiver;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import android.widget.CompoundButton;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View.OnTouchListener;
import android.content.Intent;
import android.content.ContextWrapper;


import android.provider.MediaStore;
import android.net.Uri;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


    ImageButton imageButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View myInflatedView = inflater.inflate(R.layout.fragment_camera, container, false);
//
        final RelativeLayout cameraLayout = (RelativeLayout) myInflatedView.findViewById(R.id.cameraRelativeLayout);

        final EditText myTextBox = (EditText) myInflatedView.findViewById(R.id.editText);
        myTextBox.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    cameraLayout.setVisibility(View.GONE);
                } else {
                    cameraLayout.setVisibility(View.VISIBLE);
                }
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

        imageButton = (ImageButton) myInflatedView.findViewById(R.id.imageButton);

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

    private String mCurrentPhotoPath;
    static final int REQUEST_TAKE_PHOTO = 1;

    private void dispatchTakePictureIntent() {
        Log.i("2","2");
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                Log.i("Error: ", ex.toString());
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
        Log.i("4","4");
    }
    private File createImageFile() throws IOException {
        // Create an image file name
        Log.i("3","3");
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }
}

