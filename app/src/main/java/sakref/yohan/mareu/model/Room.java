package sakref.yohan.mareu.model;

public class Room {

    /** Identifier */
    private Integer id;

    /** Subject of the meeting */
    private String name;

    /** Date of the meeting */
    private String color;

    public Room(Integer id, String name, String color){
        this.id = id;
        this.name = name;
        this.color = color;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
