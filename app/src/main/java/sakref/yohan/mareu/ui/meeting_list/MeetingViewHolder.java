package sakref.yohan.mareu.ui.meeting_list;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakref.yohan.mareu.R;
import sakref.yohan.mareu.model.Meeting;


public class MeetingViewHolder extends RecyclerView.ViewHolder {

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
        mReunionName.setText(meeting.getSubject()+ " - " + meeting.getTime() + " - " + meeting.getRoom().getName());
        //TODO : List in string
        mReunionParticipants.setText(meeting.getParticipants().toString());
        mRoomColor.setBackgroundTintList(ColorStateList.valueOf(meeting.getRoom().getColor()));


    }
}
