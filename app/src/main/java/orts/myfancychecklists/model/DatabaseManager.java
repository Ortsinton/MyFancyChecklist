package orts.myfancychecklists.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import orts.myfancychecklists.model.datasources.ChecklistDataSource;

/**
 * Created by Orts on 11/04/2015.
 */
public final class DatabaseManager extends SQLiteOpenHelper {
    private final String SHOPPING_LIST_TABLE_NAME = "Checklists";
    private static final int DB_VERSION = 1;

    private static SQLiteDatabase mDatabase;
    private static DatabaseManager mManager;

    public static ChecklistDataSource checklistDataSource;

    public static DatabaseManager getInstance(Context c) {
        if (mManager == null) {
            mManager = new DatabaseManager(c, DB_VERSION);
        }

        return mManager;
    }

    private DatabaseManager(Context context, int version) {
        super(context, "MyFancyChecklistsDb", null, version);

        checklistDataSource = new ChecklistDataSource(getWritableDatabase());
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        mDatabase = database;
        Log.d("MyFancyChecklists", "database created at " + mDatabase.getPath());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseManager.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");

        mDatabase.execSQL("DROP TABLE IF EXISTS " + SHOPPING_LIST_TABLE_NAME);

        onCreate(db);
    }
}
