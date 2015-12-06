package edu.fhu.foodfight;

/**
 * Created by jesse on 11/8/15.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import edu.fhu.foodfight.dummy.DummyContent;

public class FightsAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<Fight>> _listDataChild;
    private static User currentUser = DummyContent.CurrentUser;
    private static User opponent;

    public FightsAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<Fight>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader; /* name of section */
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final Fight childFight = (Fight) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.custom_fight_row, null);
        }

        CircleImageView userProfileImageView = (CircleImageView) convertView
                .findViewById(R.id.opponentImage);

        opponent = DummyContent.UsersMap.get(childFight.opponentId);

        new ImageDownloader(userProfileImageView).execute(opponent.imageURL);

        TextView opponentName = (TextView) convertView
                .findViewById(R.id.opponentName);

        TextView score = (TextView) convertView
                .findViewById(R.id.score);

        TextView numberOfMeals = (TextView) convertView
                .findViewById(R.id.mealCount);

        TextView timeRemaining = (TextView) convertView
                .findViewById(R.id.timeRemaining);

        opponentName.setText(childFight.opponentId);
        score.setText(childFight.userScore + " - " + childFight.opponentScore);
        numberOfMeals.setText(childFight.numberOfMeals + "/3 meals");
        timeRemaining.setText(childFight.str_timeRemaining());

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.fragment_home_fights_list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
