package edu.fhu.foodfight;

/**
 * Created by jesse on 11/8/15.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class FightsAdapter extends ArrayAdapter<Fight> {

    FightsAdapter(Context context, Fight[] fights) {
        super(context, R.layout.custom_fight_row, fights);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater fightInflater = LayoutInflater.from(getContext());

        View fightView = fightInflater.inflate(R.layout.custom_fight_row, parent, false);

        Fight fightItem = getItem(position);

        TextView opponentName = (TextView) fightView.findViewById(R.id.opponentName);
        TextView score = (TextView) fightView.findViewById(R.id.score);
        TextView mealCount = (TextView) fightView.findViewById(R.id.mealCount);
        TextView timeRemaining = (TextView) fightView.findViewById(R.id.timeRemaining);
        ImageView opponentImage = (ImageView) fightView.findViewById(R.id.opponentImage);

        opponentName.setText("Ron Weasley");
        score.setText("78 - 68");
        mealCount.setText("1/3");
        timeRemaining.setText("19 hours");
        opponentImage.setImageResource(R.drawable.nopic);

        return fightView;
    }
}
