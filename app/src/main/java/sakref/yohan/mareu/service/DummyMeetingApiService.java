package sakref.yohan.mareu.service;

import java.util.List;

import sakref.yohan.mareu.model.Meeting;
import sakref.yohan.mareu.model.Room;

public class DummyMeetingApiService implements MeetingApiService {



    @Override
    public List<Meeting> getMeeting() {
        return null;
    }

    @Override
    public void addMeeting(Meeting meeting) {

    }

    @Override
    public void deleteMeeting(Meeting meeting) {

    }

    @Override
    public List<Meeting> getFilteredMeeting(String date, String room) {
        return null;
    }

    @Override
    public List<Room> getRoom() {
        return null;
    }
}
