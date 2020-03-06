package sakref.yohan.mareu.ui.meeting_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakref.yohan.mareu.R;
import sakref.yohan.mareu.model.Meeting;

public class MeetingViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_list_name)
    TextView mItemListNameReunion;


    public MeetingViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);


    }

    public void bind(Meeting meeting) {
        mItemListNameReunion.setText(meeting.getSubject());

    }
}
