package sakref.yohan.mareu.service;

import java.util.ArrayList;
import java.util.List;

import sakref.yohan.mareu.model.Meeting;
import sakref.yohan.mareu.model.Room;

public class DummyMeetingApiService implements MeetingApiService {

    private List<Meeting> mMeetingList = new ArrayList<>();
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
    public List<Meeting> getFilteredMeeting(String date, String salle) {

        //TODO : Create the filter
        //if ()

        return null;
    }
}