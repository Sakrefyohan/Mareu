package sakref.yohan.mareu.ui.meeting_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;

import android.os.Bundle;
import android.widget.TextView;
//import android.widget.Toolbar;



import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakref.yohan.mareu.R;

public class ListMeetingActivity extends AppCompatActivity {

    //@BindView(R.id.toolbar)
    //Toolbar mToolbar;

    //@BindView(R.id.activity_meeting_list_add_meeting)
    //FloatingActionButton mFloatingActionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_list);
        ButterKnife.bind(this);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);



    }




}
