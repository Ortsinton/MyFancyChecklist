package orts.myfancychecklists.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import orts.myfancychecklists.R;
import orts.myfancychecklists.controllers.MainController;
import orts.myfancychecklists.model.entities.Checklist;
import orts.myfancychecklists.views.widgets.ItemListFragment;


public class MainActivity extends FragmentActivity {

    private MainController mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mController = new MainController(this);

        setContentView(R.layout.activity_main);

        final ItemListFragment checklistList = (ItemListFragment) getSupportFragmentManager().findFragmentById(R.id.checklist_list);
        checklistList.setLinearLayoutMode();

        final ChecklistListAdapter adapter = new ChecklistListAdapter();
        checklistList.setAdapter(adapter);

        ImageButton addButton = (ImageButton) findViewById(R.id.add_button);
        final Context c = this;
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(c,NewListFormActivity.class);
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private class ChecklistListAdapter extends RecyclerView.Adapter {

        ArrayList<Checklist> mChecklists;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class CheckListViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mName;
            public TextView mComment;

            public CheckListViewHolder(View v) {
                super(v);
                mName = (TextView)v.findViewById(R.id.item_name);
                mComment = (TextView)v.findViewById(R.id.item_comment);
            }
        }

        ChecklistListAdapter(){
            super();

            retrieveDataList();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.checklist_item, parent, false);

            CheckListViewHolder vh = new CheckListViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((CheckListViewHolder)viewHolder).mName.setText(mChecklists.get(i).name);
            ((CheckListViewHolder)viewHolder).mComment.setText(mChecklists.get(i).notes);
        }

        @Override
        public int getItemCount() {
            return mChecklists.size();
        }

        public void retrieveDataList() {
            mChecklists = mController.getChecklists();

            for (Checklist sl : mChecklists) {
                Log.d("MyFancyChecklists","-----> " + sl.id + " - " + sl.name);
            }
        }

        public void addData() {
            retrieveDataList();
            notifyDataSetChanged();
        }
    }
}
