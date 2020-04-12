package sakref.yohan.mareu.ui.meeting_list;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import sakref.yohan.mareu.R;
import sakref.yohan.mareu.events.DeleteMeetingEvent;
import sakref.yohan.mareu.model.Meeting;
import sakref.yohan.mareu.service.MeetingApiService;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingViewHolder> {
    private static final String TAG = "MeetingAdapter";

    private List<Meeting> mMeetingList;

    MeetingApiService mMeetingApiService;

    public MeetingAdapter(List<Meeting> meetingList){
        mMeetingList = meetingList;
    }


    @NonNull
    @Override
    public MeetingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeetingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_meeting, parent, false));
    }

    public void updateData(List<Meeting> viewModels){
        mMeetingList = viewModels;
        notifyDataSetChanged();

    }

    public void removeItem(int position){
        mMeetingList.remove(position);
        notifyItemRemoved(position);
        Log.d(TAG, "removeItem() called with: position = [" + position + "]");
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingViewHolder holder, int position) {

        holder.bind(mMeetingList.get(position));

        holder.mReunionDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
                //EventBus.getDefault().post(new DeleteMeetingEvent(mMeetingList.get(position)));
            }
        });



    }

    @Override
    public int getItemCount() {
        return mMeetingList.size();
    }




}
