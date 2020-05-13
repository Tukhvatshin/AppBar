package com.example.appbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_save_notes) {
            Toast.makeText(MainActivity.this, R.string.openSvNote, Toast.LENGTH_LONG).show();
            Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(intentNotes);
            return true;
        }
        if (id == R.id.action_check_box) {
            Toast.makeText(MainActivity.this, R.string.openChkBox, Toast.LENGTH_LONG).show();
            Intent intentCheckBox = new Intent(MainActivity.this, CheckBoxActivity.class);
            startActivity(intentCheckBox);
            return true;
        }
        if (id == R.id.action_spinner) {
            Toast.makeText(MainActivity.this, R.string.openSpn, Toast.LENGTH_LONG).show();
            Intent intentSpinner = new Intent(MainActivity.this, SpinnerActivity.class);
            startActivity(intentSpinner);
            return true;
        }
        if (id == R.id.action_calendar_view) {
            Toast.makeText(MainActivity.this, R.string.openClndr, Toast.LENGTH_LONG).show();
            Intent intentCalendar = new Intent(MainActivity.this, CalendarActivity.class);
            startActivity(intentCalendar);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

}
