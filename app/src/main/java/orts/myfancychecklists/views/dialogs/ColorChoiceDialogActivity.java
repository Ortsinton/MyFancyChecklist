package orts.myfancychecklists.views.dialogs;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import orts.myfancychecklists.R;
import orts.myfancychecklists.model.entities.Checklist;
import orts.myfancychecklists.views.widgets.ItemListFragment;

/**
 * Created by Orts on 25/04/2015.
 */
public class ColorChoiceDialogActivity extends FragmentActivity {
    private int mSelectedIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSelectedIndex = 0;

        setContentView(R.layout.color_choice_dialog);

        final ItemListFragment colorList = (ItemListFragment) getSupportFragmentManager().findFragmentById(R.id.color_list);
        colorList.setGridMode(4);
        final ColorListAdapter adapter = new ColorListAdapter();
        colorList.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_list_form_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ColorListAdapter extends RecyclerView.Adapter {

        ArrayList<Checklist> mChecklists;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ColorViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public LinearLayout mColorBox;
            public LinearLayout mColorBoxContainer;

            public ColorViewHolder(View v) {
                super(v);
                mColorBox = (LinearLayout)v.findViewById(R.id.color_box);
                mColorBoxContainer = (LinearLayout)v.findViewById(R.id.color_box_container);
            }
        }

        ColorListAdapter(){
            super();

            //retrieveDataList();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.color_item, parent, false);

            ColorViewHolder vh = new ColorViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            //TODO: set the color of the colorbox
        }

        @Override
        public int getItemCount() {
            //TODO: return the number of colors
            return 10;
        }

        public void retrieveDataList() {
            //TODO: get the color list
        }
    }
}
