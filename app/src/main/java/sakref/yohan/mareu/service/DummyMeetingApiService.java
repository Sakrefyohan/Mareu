package sakref.yohan.mareu.service;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sakref.yohan.mareu.R;
import sakref.yohan.mareu.model.Meeting;
import sakref.yohan.mareu.model.Room;
import sakref.yohan.mareu.ui.meeting_list.ListMeetingActivity;

public class DummyMeetingApiService implements MeetingApiService {
    private static final String TAG = "DummyMeetingApiService";
    private List<Meeting> mMeetingList = new ArrayList<>();

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
    public List<Meeting> getFilteredMeeting(String date, String salle) {


        List<Meeting> mFilteredMeeting = new ArrayList<>();

        for(int i = 0; i < mMeetingList.size(); i++){
            if (date.equals(mMeetingList.get(i).getDate()) && salle.equals(mMeetingList.get(i).getRoom().getName())){
                    //Filtre par date & room
                    mFilteredMeeting.add(mMeetingList.get(i));
                }else if (date.equals(mMeetingList.get(i).getDate()) && salle.equals("Aucune Salle")){
                    //Filtre par date
                    mFilteredMeeting.add(mMeetingList.get(i));
                }else if (date.equals("") && salle.equals(mMeetingList.get(i).getRoom().getName())){
                    //Filtre par room
                    mFilteredMeeting.add(mMeetingList.get(i));
                }else if (date.equals("") && salle.equals("Aucune Salle")) {
                    //Reset filtre
                    mFilteredMeeting.add(mMeetingList.get(i));
                }
            }

        return mFilteredMeeting;
    }
}