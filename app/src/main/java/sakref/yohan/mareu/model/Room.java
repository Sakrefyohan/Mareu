package sakref.yohan.mareu.model;

import android.graphics.drawable.Drawable;

public class Room {

    /** Subject of the meeting */
    private String name;

    /** Date of the meeting */
    private int color;

    public Room(String name, int color){
        this.name = name;
        this.color = color;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
