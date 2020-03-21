package sakref.yohan.mareu.ui.meeting_list;

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

    @BindView(R.id.reunion_subject)
    TextView mReunionName;

    @BindView(R.id.reunion_time)
    TextView mReunionTime;

    @BindView(R.id.reunion_room)
    TextView mReunionRoom;

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
        mReunionName.setText(meeting.getSubject());
        mReunionTime.setText(meeting.getTime());
        mReunionRoom.setText((CharSequence) meeting.getRoom());
        mReunionParticipants.setText(meeting.getParticipants().toString());
        mRoomColor.setColorFilter(ContextCompat.getColor(itemView.getContext(), meeting.getRoom().getColor()));

    }
}
