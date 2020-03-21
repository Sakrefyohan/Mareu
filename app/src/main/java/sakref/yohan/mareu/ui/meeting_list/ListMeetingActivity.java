package sakref.yohan.mareu.ui.meeting_list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sakref.yohan.mareu.R;
import sakref.yohan.mareu.di.DI;
import sakref.yohan.mareu.model.Meeting;
import sakref.yohan.mareu.service.MeetingApiService;
import sakref.yohan.mareu.ui.meeting_details.DetailsListMeeting;

import static sakref.yohan.mareu.ui.meeting_details.DetailsListMeeting.CREATE_REUNION;

public class ListMeetingActivity extends AppCompatActivity {


    private static final int MEETING_DETAILS = 1;

    @BindView(R.id.activity_meeting_list_add_meeting)
    FloatingActionButton mFloatingActionButton;

    @BindView(R.id.activity_meeting_list_recyclerview)
    RecyclerView mRecyclerView;

    MeetingApiService mMeetingApiService;

    //TODO : initList() -- S'inspirer du projet precedent
    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_list);
        ButterKnife.bind(this);
        mMeetingApiService = DI.getNewInstanceApiService();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MEETING_DETAILS) {
            if (resultCode == ListMeetingActivity.RESULT_OK) {
                Meeting result = (Meeting) data.getSerializableExtra(CREATE_REUNION);
                mMeetingApiService.addMeeting(result);
            }

        }
    }

    //TODO : TRIE =/= FILTRE
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

    @OnClick(R.id.activity_meeting_list_add_meeting)
    public void onShowDetails() {

        Intent intent = new Intent(this, DetailsListMeeting.class);
        startActivityForResult(intent, MEETING_DETAILS);

    }
}
