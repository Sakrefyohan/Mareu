package sakref.yohan.mareu.ui.meeting_list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import sakref.yohan.mareu.R;
import sakref.yohan.mareu.model.Meeting;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingViewHolder> {

    private List<Meeting> mMeetingList;

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
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingViewHolder holder, int position) {

        holder.bind(mMeetingList.get(position));

    }

    @Override
    public int getItemCount() {
        return mMeetingList.size();
    }




}
