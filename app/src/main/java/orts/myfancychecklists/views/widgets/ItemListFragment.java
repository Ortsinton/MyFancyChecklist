package orts.myfancychecklists.views.widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import orts.myfancychecklists.R;

/**
 * Created by Orts on 06/04/2015.
 */
public class ItemListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.d("MyFancyChecklists","-----ItemListFragment:onCreateView");
        View view = inflater.inflate(R.layout.item_list, container);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        return view;

    }

    public void setGridMode(int columns) {
        if (mLayoutManager != null) {
            return;
        }
        mLayoutManager = new GridLayoutManager(getActivity(),columns);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    public void setLinearLayoutMode() {
        if (mLayoutManager != null) {
            return;
        }

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        mAdapter = adapter;
        mRecyclerView.setAdapter(mAdapter);
    }
}
