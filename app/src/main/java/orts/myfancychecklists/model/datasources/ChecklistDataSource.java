package orts.myfancychecklists.model.datasources;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import orts.myfancychecklists.model.entities.Checklist;

/**
 * Created by Orts on 12/04/2015.
 */
public class ChecklistDataSource extends BaseDataSource<Checklist> {
    final String COLUMN_ID = "id";
    final String COLUMN_NAME = "name";
    final String COLUMN_NOTES = "notes";
    final String COLUMN_ITEMS = "item_list";
    final String COLUMN_COLOR = "color";
    final String COLUMN_ALARMS = "alarms";
    final String COLUMN_LISTING = "cards";
    final String DATABASE_NAME = "Checklists";
    private final String [] allColumns = {COLUMN_ID, COLUMN_NAME, COLUMN_NOTES, COLUMN_ITEMS};
    private SQLiteDatabase mDatabase;


    public ChecklistDataSource(SQLiteDatabase database) {
        super("Checklist");
        if (database == null) {
            throw new IllegalStateException("Database must not be null");
        }

        mDatabase = database;

        createTableIfNotExists();
    }

    protected void createTableIfNotExists() {
        String createChecklistsTable = "CREATE TABLE IF NOT EXISTS " + DATABASE_NAME
                + "("+ COLUMN_ID+" integer primary key autoincrement,"
                + COLUMN_NAME+ " TEXT NOT NULL,"
                + COLUMN_NOTES+ " TEXT,"
                + COLUMN_ITEMS+ " INTEGER"
                + ");";
        Log.d("MyFancyChecklists", createChecklistsTable);
        mDatabase.execSQL(createChecklistsTable);
    }

    @Override
    public void insert(Checklist entity) {
        if (entity.name == null) {
            throw new IllegalStateException(DATABASE_NAME +" name must not be null");
        }

        String statement = "INSERT INTO " + DATABASE_NAME
                + " VALUES (null,'" + entity.name + "','" + entity.notes + "',0);";
        mDatabase.execSQL(statement);
    }

    @Override
    public ArrayList<Checklist> getByData() {
        return null;
    }

    @Override
    public ArrayList<Checklist> getByExample() {
        return null;
    }

    @Override
    public ArrayList<Checklist> getAll() {
        ArrayList<Checklist> checklists = new ArrayList<Checklist>();

        Cursor cursor = mDatabase.query(DATABASE_NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Checklist checklist = cursorToShoppingList(cursor);
            checklists.add(checklist);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();

        return checklists;
    }

    private Checklist cursorToShoppingList(Cursor cursor) {
        Checklist checklist = new Checklist(cursor.getString(1), cursor.getString(2));
        checklist.id = cursor.getInt(0);
        //TODO: Uncomment this when ready
        //shoppingList.items = cursor.getInt(3);
        return checklist;
    }
}
