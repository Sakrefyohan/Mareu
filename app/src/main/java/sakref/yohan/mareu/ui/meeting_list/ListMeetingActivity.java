package sakref.yohan.mareu.ui.meeting_list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
//import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sakref.yohan.mareu.R;
import sakref.yohan.mareu.di.DI;
import sakref.yohan.mareu.model.Meeting;
import sakref.yohan.mareu.service.MeetingApiService;
import sakref.yohan.mareu.ui.dialog.FilterDialogFragment;
import sakref.yohan.mareu.ui.meeting_details.DetailsListMeeting;

import static sakref.yohan.mareu.ui.meeting_details.DetailsListMeeting.CREATE_REUNION;

public class ListMeetingActivity extends AppCompatActivity {
    private static final String TAG = "onCreate";

    private static final int MEETING_DETAILS = 1;

    @BindView(R.id.activity_meeting_list_add_meeting)
    FloatingActionButton mFloatingActionButton;

    @BindView(R.id.activity_meeting_list_recyclerview)
    RecyclerView mRecyclerView;

    MeetingApiService mMeetingApiService;

    MeetingAdapter mMeetingAdapter;



    //TODO : initList() -- S'inspirer du projet precedent



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_list);
        ButterKnife.bind(this);
        Log.d(TAG, "onCreate: ");
        mMeetingApiService = DI.getNewInstanceApiService();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMeetingAdapter = new MeetingAdapter(mMeetingApiService.getMeeting());
        mRecyclerView.setAdapter(mMeetingAdapter);
     }

    @Override
    protected void onResume() {
        super.onResume();
        mMeetingAdapter.updateData(mMeetingApiService.getMeeting());
        Log.d(TAG, "onResume: " + mMeetingApiService.getMeeting().size());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MEETING_DETAILS) {
            if (resultCode == ListMeetingActivity.RESULT_OK) {
                Meeting meeting = (Meeting) data.getSerializableExtra(CREATE_REUNION);
                mMeetingApiService.addMeeting(meeting);
                Log.d(TAG, "onActivityResult: Nom de la room = " + meeting.getRoom());
                Log.d(TAG, "onActivityResult: Nom de la room = " + meeting.getRoom().getName());
                Log.d(TAG, "onActivityResult: Couleur de la room = " + meeting.getRoom().getColor());
                Log.d(TAG, "onActivityResult : " + mMeetingApiService.getMeeting().size());


            }

        }
    }


    //TODO : TRIE =/= FILTRE

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_menu_button_filter:
                FilterDialogFragment mFilterDialogFragment = new FilterDialogFragment();

                mFilterDialogFragment.show(getSupportFragmentManager(), "Filter");

                return true;


            default:
                return super.onOptionsItemSelected(item);

        }


    }

    @OnClick(R.id.activity_meeting_list_add_meeting)
    public void onShowDetails() {

        Intent intent = new Intent(this, DetailsListMeeting.class);
        startActivityForResult(intent, MEETING_DETAILS);

    }
}
