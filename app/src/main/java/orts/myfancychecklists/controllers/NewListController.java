package orts.myfancychecklists.controllers;

import android.content.Context;

import orts.myfancychecklists.model.DatabaseManager;
import orts.myfancychecklists.model.entities.Checklist;
import orts.myfancychecklists.views.NewListFormActivity;

/**
 * Created by Orts on 24/04/2015.
 */
public class NewListController {

    NewListFormActivity mView;
    DatabaseManager mDbManager;
    Checklist mChecklist;

    public NewListController(Context c) {
        mDbManager = DatabaseManager.getInstance(c);
        mView = (NewListFormActivity)c;
    }

    public void viewStarted(String name, String comment) {
        if (mChecklist == null) {
            mChecklist = new Checklist(name,comment);
        }
        else {
            mChecklist.name = name;
            mChecklist.notes = comment;
        }
    }
}
