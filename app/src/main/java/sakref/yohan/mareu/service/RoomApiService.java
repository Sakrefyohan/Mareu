package sakref.yohan.mareu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sakref.yohan.mareu.R;
import sakref.yohan.mareu.model.Room;

public abstract class RoomApiService {

    public static List<Room> DUMMY_ROOMS = Arrays.asList(
            new Room("Beryllium", R.color.colorRoomBeryllium),
            new Room("Boron",R.color.colorRoomBoron),
            new Room("Carbon",R.color.colorRoomCarbon),
            new Room("Fluorine",R.color.colorRoomFluorine),
            new Room("Helium",R.color.colorRoomHelium),
            new Room("Hydrogen",R.color.colorRoomHydrogen),
            new Room("Lithium",R.color.colorRoomLithium),
            new Room("Neon",R.color.colorRoomNeon),
            new Room("Nitrogen",R.color.colorRoomNitrogen),
            new Room("Oxygen",R.color.colorRoomOxygen)
    );

    static List<Room> generateRoom() {
        return new ArrayList<>(DUMMY_ROOMS);
    }
}
