package sakref.yohan.mareu.model;

import android.graphics.Color;

public class Meeting {

    /** Identifier */
    private Integer id;

    /** Subject of the meeting */
    private String subject;

    /** Date of the meeting */
    private String date;

    /** hour of the meeting */
    private String time;

    /** Room of the meeting */
    private String room;

    /**Participant of the meeting*/
    private String participants;

    public Meeting(Integer id, String subject, String date, String time, String room, String participants){
        this.id = id;
        this.subject = subject;
        this.date = date;
        this.time = time;
        this.room = room;
        this.participants = participants;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }
}
