package sakref.yohan.mareu.ui.meeting_details;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sakref.yohan.mareu.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import sakref.yohan.mareu.R;
import sakref.yohan.mareu.model.Meeting;

public class DetailsListMeeting extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private static final String CREATE_REUNION = "0";

    @BindView(R.id.details_subject)
    TextView mSubject;

    @BindView(R.id.details_date)
    EditText mDatePicker;

    @BindView(R.id.details_time)
    EditText mTimePicker;

    @BindView(R.id.details_spinner)
    Spinner mSpinner;

    @BindView(R.id.details_people)
    EditText mPeople;

    @BindView(R.id.details_chipGroup)
    ChipGroup mChipGroup;

    //@BindView(R.id.create_reunion_button)
    //Button mCreateReunion;

    //TODO: Finish to initialise all item - DONE
    //TODO: Add check for email (check not empty)

    final Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_details);
        ButterKnife.bind(this);

        /**
         * Code for the spinner
         * Here we fill the spinner with the list we have created on String
         */
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.Room, android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapterSpinner);
        mSpinner.setOnItemSelectedListener(this);

        /**
         * Code for the time picker
         */

        mTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mCurrentTime = Calendar.getInstance();
                int hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mCurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePickerDialogue;
                mTimePickerDialogue = new TimePickerDialog(DetailsListMeeting.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        mTimePicker.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                mTimePickerDialogue.setTitle("Select Time");
                mTimePickerDialogue.show();
            }
        });


        /**
         * Code for the date picker
         * define first myCalendar as Final
         * and bind the view on for the button to pop-up the picker
         */
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        mDatePicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Auto-generated method stub
                new DatePickerDialog(DetailsListMeeting.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        mDatePicker.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_menu_button_filter_item1:
                String text1 = getString(R.string.toolbar_menu_button_filter_item1);
                Toast.makeText(this, text1, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.toolbar_menu_button_filter_item2:
                String text2 = getString(R.string.toolbar_menu_button_filter_item2);
                Toast.makeText(this, text2, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.toolbar_menu_button_filter_item3:
                String text3 = getString(R.string.toolbar_menu_button_filter_item3);
                Toast.makeText(this, text3, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.toolbar_menu_button_filter_item4:
                String text4 = getString(R.string.toolbar_menu_button_filter_item4);
                Toast.makeText(this, text4, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //TODO: Get all item from the activity
    @OnClick(R.id.create_reunion_button)
    public void onCreateReunion() {
        Intent createReunion = new Intent();
        List<String> Participants = new ArrayList<>();
        Meeting meeting = new Meeting(mSubject.getText().toString(), myCalendar.getTime().toString(), mTimePicker.getText().toString(), mSpinner.getSelectedItem().toString() , Participants);
        createReunion.putExtra(CREATE_REUNION, "");
        //TODO: Create the meeting
    }


}
