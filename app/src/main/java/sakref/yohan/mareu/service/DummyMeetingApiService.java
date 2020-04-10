package sakref.yohan.mareu.service;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sakref.yohan.mareu.model.Meeting;
import sakref.yohan.mareu.model.Room;
import sakref.yohan.mareu.ui.meeting_list.ListMeetingActivity;

public class DummyMeetingApiService implements MeetingApiService {
    private static final String TAG = "DummyMeetingApiService";
    private List<Meeting> mMeetingList = new ArrayList<>();
    private List<Meeting> mFilteredMeeting = new ArrayList<>();
    private List<Room> mRoomList = new ArrayList<>();

    @Override
    public List<Meeting> getMeeting() {
        return mMeetingList;
    }

    @Override
    public void addMeeting(Meeting meeting) {
        mMeetingList.add(meeting);
    }

    @Override
    public void deleteMeeting(Meeting meeting) {
        mMeetingList.remove(meeting);
    }

    @Override
    public List<Meeting> getFilteredMeeting(String date, String salle, Boolean dateIsClicked) {

        //TODO : Create the filter
    /**
        Log.d(TAG, "getFilteredMeeting: dateIsClicked [" + dateIsClicked +"]");
        if (!dateIsClicked){

            for(int i = 0; i < mMeetingList.size(); i++){
                getMeeting();
            }

        }
    */
        return null;
    }
}