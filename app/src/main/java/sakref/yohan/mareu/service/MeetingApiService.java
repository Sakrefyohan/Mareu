package sakref.yohan.mareu.service;

import java.util.List;

import sakref.yohan.mareu.model.Meeting;
import sakref.yohan.mareu.model.Room;

public interface MeetingApiService {

    List<Meeting> getMeeting();



    void addMeeting (Meeting meeting);

    void deleteMeeting (Meeting meeting);

    List<Meeting> getFilteredMeeting(Room room, String date);

    List<Room> getRoom();


}
