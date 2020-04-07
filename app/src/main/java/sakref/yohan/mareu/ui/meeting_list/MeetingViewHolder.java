package sakref.yohan.mareu.ui.meeting_list;

import android.content.res.ColorStateList;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakref.yohan.mareu.R;
import sakref.yohan.mareu.model.Meeting;

import static android.content.ContentValues.TAG;


public class MeetingViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "MeetingViewHolder";

    /*Creating one Textview for all the subject + name + time*/
    @BindView(R.id.reunion_subject)
    TextView mReunionName;

    @BindView(R.id.reunion_participants)
    TextView mReunionParticipants;

    @BindView(R.id.reunion_color)
    ImageView mRoomColor;

    @BindView(R.id.reunion_delete)
    ImageButton mReunionDelete;


    public MeetingViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Meeting meeting) {
        mReunionName.setText(meeting.getSubject() +"..."+ " - " + meeting.getTime() + " - " + meeting.getRoom().getName());
        String delim= " ; ";
        String listParticipant = TextUtils.join(delim, meeting.getParticipants());
        Log.d(TAG, "bind: meeting.getParticipants = " + meeting.getParticipants().size());
        Log.d(TAG, "bind: meeting.getParticipants = " + listParticipant);
        Log.d(TAG, "bind: meeting.getParticipants = " + meeting.getParticipants().toString());
        mReunionParticipants.setText(listParticipant);
        mRoomColor.setBackgroundTintList(ColorStateList.valueOf(meeting.getRoom().getColor()));


    }

}
