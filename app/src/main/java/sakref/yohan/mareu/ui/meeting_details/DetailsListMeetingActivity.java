package sakref.yohan.mareu.ui.meeting_details;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sakref.yohan.mareu.R;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import sakref.yohan.mareu.model.Meeting;
import sakref.yohan.mareu.model.Room;
import sakref.yohan.mareu.ui.meeting_list.ListMeetingActivity;

public class DetailsListMeetingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "DetailsListMeetingActivity";

    public static final String CREATE_REUNION = "0";

    @BindView(R.id.details_subject)
    TextInputEditText mSubject;

    @BindView(R.id.details_date)
    TextInputEditText mDatePicker;

    @BindView(R.id.details_time)
    TextInputEditText mTimePicker;

    @BindView(R.id.details_spinner)
    Spinner mSpinner;

    @BindView(R.id.details_people)
    TextInputEditText mPeople;

    @BindView(R.id.details_chipGroup)
    ChipGroup mChipGroup;

    final Calendar myCalendar = Calendar.getInstance();
    private CharSequence emailChip;

    List<String> Participants = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_details);
        ButterKnife.bind(this);
        setTitle("");



        /*
         * Code for the spinner
         * Here we fill the spinner with the list we have created on String.xml
         * (@param mSpinner)
         */
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.Room, android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapterSpinner);
        mSpinner.setOnItemSelectedListener(this);

        /*
         * Code for the ChipGroup
         * Here are some check if the email is good or no.
         */


        mPeople.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    String peopleNewChip = mPeople.getText().toString();
                    Chip peopleChip = new Chip(DetailsListMeetingActivity.this);

                    if (isValid(peopleNewChip)) {
                        peopleChip.setText(peopleNewChip);
                        peopleChip.setCloseIconVisible(true);
                        mChipGroup.addView(peopleChip);
                        Participants.add(peopleNewChip);
                        Log.d(TAG, "onKey: Size Participants " + Participants.size());
                        Log.d(TAG, "onKey: adding peopleChip = " + peopleNewChip);
                        mPeople.setText("");
                    } else {
                        mPeople.setText(peopleNewChip);
                        Toast.makeText(DetailsListMeetingActivity.this, getText(R.string.chip_invalid_mail) + " : " + peopleNewChip, Toast.LENGTH_SHORT).show();
                    }

                    peopleChip.setOnCloseIconClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mChipGroup.removeView(peopleChip);
                            Participants.remove(peopleNewChip);
                            Log.d(TAG, "onClickDelete: Deleting -->  " + peopleNewChip);
                            Log.d(TAG, "onClickDelete: Deleting --> Participants size =  " + Participants.size());
                        }
                    });

                    return true;

                }
                return false;
            }

            private boolean isValid(String email) {
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                        "[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                        "A-Z]{2,7}$";
                Pattern pat = Pattern.compile(emailRegex);
                if (email == null)
                    return false;
                return pat.matcher(email).matches();
            }
        });

        /*
         * Code for the time picker
         */

        mTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mCurrentTime = Calendar.getInstance();
                int hour = mCurrentTime.get(Calendar.HOUR_OF_DAY) ;
                int minute = mCurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePickerDialogue = new TimePickerDialog(DetailsListMeetingActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                        if(selectedHour<10){
                            if(selectedMinute<10) {
                                mTimePicker.setText("0" + selectedHour + " : " + "0" + selectedMinute);
                            }else {mTimePicker.setText("0" + selectedHour + " : " + selectedMinute);}
                        }else if (selectedMinute<10){
                            mTimePicker.setText(selectedHour + " : " + "0" + selectedMinute);
                        }else {mTimePicker.setText(selectedHour + " : " + selectedMinute);}


                        //TODO : Concatener avec un zero si >10 -- DONE
                    }
                }, hour, minute, true);
                mTimePickerDialogue.setTitle(getString(R.string.Picker_title_hour));
                mTimePickerDialogue.show();
            }
        });
        /*
          Code for the date picker
          define first myCalendar as Final
          and bind the view on for the button to pop-up the picker
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
                new DatePickerDialog(DetailsListMeetingActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
        mDatePicker.setText(sdf.format(myCalendar.getTime()));
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @OnClick(R.id.create_reunion_button)
    public void onCreateReunion() {
        Intent createReunion = new Intent();


        String meetingSubject = mSubject.getText().toString();
        String meetingDate = myCalendar.getTime().toString();
        String meetingTime = mTimePicker.getText().toString();
        String roomRoom = mSpinner.getSelectedItem().toString();
        int roomColor = getResources().getIntArray(R.array.RoomColor)[mSpinner.getSelectedItemPosition()];

        if (meetingSubject.equals("")) {
            Toast.makeText(DetailsListMeetingActivity.this, "Veuillez definir un sujet de reunion", Toast.LENGTH_SHORT).show();
        } else if (meetingDate.equals("")) {
            Toast.makeText(DetailsListMeetingActivity.this, "Veuillez definir une date de réunion", Toast.LENGTH_SHORT).show();
        } else if (meetingTime.equals("")) {
            Toast.makeText(DetailsListMeetingActivity.this, "Veuillez definir une heure de réunion", Toast.LENGTH_SHORT).show();
        } else if (Participants.isEmpty()) {
            Toast.makeText(DetailsListMeetingActivity.this, "Veuillez remplir des participants", Toast.LENGTH_SHORT).show();
        } else {
            Room selectedRoom = new Room(roomRoom, roomColor);
            Meeting meeting = new Meeting(meetingSubject, meetingDate, meetingTime, selectedRoom, Participants);
            createReunion.putExtra(CREATE_REUNION, meeting);
            setResult(ListMeetingActivity.RESULT_OK, createReunion);
            Log.d(TAG, "onCreateReunion() = " + meeting + "date : [ " + meetingDate + " ] heure : " + meetingTime);
            finish();
        }
    }
}
