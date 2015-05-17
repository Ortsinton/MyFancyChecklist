package orts.myfancychecklists.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import orts.myfancychecklists.R;
import orts.myfancychecklists.controllers.NewListController;
import orts.myfancychecklists.views.dialogs.ColorChoiceDialogActivity;

/**
 * Created by Orts on 24/04/2015.
 */
public class NewListFormActivity extends FragmentActivity {

    NewListController mController;
    private int mColor;
    private boolean mIsListingAsListChosen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mController = new NewListController(this);
        mColor = Color.rgb(00,96,88);
        mIsListingAsListChosen = true;

        setContentView(R.layout.new_list_form);
        final Context context = this;
        EditText titleTextView = (EditText)findViewById(R.id.checklist_name_field);
        EditText descriptionTextView = (EditText)findViewById(R.id.checklist_description_field);

        //titleTextView.selectAll();

        View.OnFocusChangeListener focusChangeListener= new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    EditText view = (EditText) v;
                    view.selectAll();
                }
            }
        };
        titleTextView.setOnFocusChangeListener(focusChangeListener);
        descriptionTextView.setOnFocusChangeListener(focusChangeListener);

        LinearLayout colorSetting = (LinearLayout)findViewById(R.id.color_setting);
        colorSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ColorChoiceDialogActivity.class);
                startActivity(i);
            }
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
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
}
