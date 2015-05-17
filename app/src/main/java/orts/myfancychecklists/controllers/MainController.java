package orts.myfancychecklists.controllers;

import android.content.Context;

import java.util.ArrayList;

import orts.myfancychecklists.model.entities.Checklist;
import orts.myfancychecklists.views.MainActivity;
import orts.myfancychecklists.model.DatabaseManager;

/**
 * Created by Orts on 12/04/2015.
 */
public class MainController {

    private DatabaseManager mDbManager;
    private MainActivity mView;

    public MainController(Context c) {
        mDbManager = DatabaseManager.getInstance(c);
        mView = (MainActivity)c;
    }

    //Input

    public Checklist createChecklist(String name, String notes) {
        Checklist ret = new Checklist(name, notes);

        mDbManager.checklistDataSource.insert(ret);

        return ret;
    }

    public ArrayList<Checklist> getChecklists() {
        return mDbManager.checklistDataSource.getAll();
    }

    //Output
}
