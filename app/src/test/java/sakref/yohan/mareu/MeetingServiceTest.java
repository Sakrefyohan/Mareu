package sakref.yohan.mareu;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import sakref.yohan.mareu.di.DI;
import sakref.yohan.mareu.model.Meeting;
import sakref.yohan.mareu.model.Room;
import sakref.yohan.mareu.service.MeetingApiService;

import static org.junit.Assert.*;

/**
 * Unit test on Meeting service
 */
@RunWith(JUnit4.class)
public class MeetingServiceTest{

    private MeetingApiService meetingApiService;

    @Before
    public void setup(){meetingApiService = DI.getNewInstanceApiService();}

    @Test
    public void CreateMeetingWithSuccess(){
        Room room = new Room("Hydrogene",1);
        List<String> participants = new ArrayList<>();
        List<Meeting> meetings = meetingApiService.getMeeting();
        participants.add("a@a.fr");
        participants.add("b@a.fr");
        participants.add("c@a.fr");
        participants.add("test@test.fr");
        Meeting meeting = new Meeting("Ceci est un test de réunion", "02/03/1998","10:53" ,room,participants);
        meetings.add(meeting);
        assertEquals(1, meetingApiService.getMeeting().size());
    }

    @Test
    public void DeleteMeetingWithSuccess() {
        Room room = new Room("Hydrogene",1);
        List<String> participants = new ArrayList<>();
        List<Meeting> meetings = meetingApiService.getMeeting();
        participants.add("a@a.fr");
        participants.add("b@a.fr");
        participants.add("c@a.fr");
        participants.add("test@test.fr");
        Meeting meeting = new Meeting("Ceci est un test de réunion", "02/03/2021","10:53" ,room,participants);
        Meeting meeting1 = new Meeting("Deuxieme Reunion", "03/04/2020","11:53" ,room,participants);
        meetings.add(meeting);
        meetings.add(meeting1);
        //Adding 2 meeting in the list of meeting and deleting one
        meetingApiService.deleteMeeting(meetingApiService.getMeeting().get(0));
        assertEquals(1, meetingApiService.getMeeting().size());
    }

    @Test
    public void FilterMeetingWithSuccess() {
        Room roomHydrogene = new Room("Hydrogene",1);
        Room roomHelium = new Room("Helium",2);
        Room roomBeryllium = new Room("Beryllium",4);

        List<String> participants = new ArrayList<>();
        participants.add("a@a.fr");
        participants.add("b@a.fr");
        participants.add("c@a.fr");
        participants.add("test@test.fr");

        Meeting meeting = new Meeting("Ceci est un test de réunion", "02/03/2021","10:53" ,roomBeryllium,participants);
        Meeting meeting1 = new Meeting("Deuxieme Reunion", "02/03/2020","11:12" ,roomHydrogene,participants);
        Meeting meeting2 = new Meeting("troisieme Reunion", "04/04/2020","12:20" ,roomHelium,participants);
        Meeting meeting3 = new Meeting("quatrieme Reunion", "05/04/2020","13:40" ,roomHydrogene,participants);
        Meeting meeting4 = new Meeting("cinquieme Reunion", "05/04/2020","16:50" ,roomHydrogene,participants);
        meetingApiService.addMeeting(meeting);
        meetingApiService.addMeeting(meeting1);
        meetingApiService.addMeeting(meeting2);
        meetingApiService.addMeeting(meeting3);
        meetingApiService.addMeeting(meeting4);

        meetingApiService.getMeeting();

        assertEquals(2, meetingApiService.getFilteredMeeting("05/04/2020","Aucune Salle").size());
    }
}
