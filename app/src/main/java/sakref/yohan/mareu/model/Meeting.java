package sakref.yohan.mareu.model;

import android.graphics.drawable.Drawable;

import java.util.List;

public class Meeting {

    /**
     * Subject of the meeting
     */
    private String subject;

    /**
     * Date of the meeting
     */
    private String date;

    /**
     * hour of the meeting
     */
    private String time;

    /**
     * Room of the meeting
     */
    private Room room;

    /**
     * Participant of the meeting
     */
    private List<String> participants;

    public Meeting(String subject, String date, String time, Room room, List<String> participants) {
        this.subject = subject;
        this.date = date;
        this.time = time;
        this.room = room;
        this.participants = participants;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<String> getParticipants() {        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }
}
