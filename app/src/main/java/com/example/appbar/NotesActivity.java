package com.example.appbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotesActivity extends AppCompatActivity {
    private EditText mInputNote;
    private Button mBtnSaveNote;
    private SharedPreferences myNoteSharedPref;
    private static String NOTE_TEXT = "note_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        initViews();
        getDateFromSharedPref();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_check_box) {
            Toast.makeText(NotesActivity.this, R.string.openChkBox, Toast.LENGTH_LONG).show();
            Intent intentCheckBox = new Intent(NotesActivity.this, CheckBoxActivity.class);
            startActivity(intentCheckBox);
            return true;
        }
        if (id == R.id.action_spinner) {
            Toast.makeText(NotesActivity.this, R.string.openSpn, Toast.LENGTH_LONG).show();
            Intent intentSpinner = new Intent(NotesActivity.this, SpinnerActivity.class);
            startActivity(intentSpinner);
            return true;
        }
        if (id == R.id.action_calendar_view) {
            Toast.makeText(NotesActivity.this, R.string.openClndr, Toast.LENGTH_LONG).show();
            Intent intentCalendar = new Intent(NotesActivity.this, CalendarActivity.class);
            startActivity(intentCalendar);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    private void initViews() {
        mInputNote = findViewById(R.id.inputNote);
        mBtnSaveNote = findViewById(R.id.btnSaveNote);

        myNoteSharedPref = getSharedPreferences(getString(R.string.MyNote), MODE_PRIVATE);

        mBtnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
                String noteTxt = mInputNote.getText().toString();
                myEditor.putString(NOTE_TEXT, noteTxt);
                myEditor.apply();
                Toast.makeText(NotesActivity.this, getString(R.string.Savetxt) + mInputNote.getText().toString() + getString(R.string.savetxt_1), Toast.LENGTH_LONG).show();
                mInputNote.getText().clear();
            }
        });
    }
    private void getDateFromSharedPref(){
        String noteTxt = myNoteSharedPref.getString(NOTE_TEXT, "");
        mInputNote.setText(noteTxt);
    }
}
