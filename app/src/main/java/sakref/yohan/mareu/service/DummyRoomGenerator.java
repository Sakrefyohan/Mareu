package sakref.yohan.mareu.service;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import sakref.yohan.mareu.model.Room;



public abstract class DummyRoomGenerator {

    public static List<Room> DUMMY_ROOMS = Arrays.asList(

            new Room("Hydrogene", "Fushia"),
            new Room("Helium", "Rouge"),
            new Room("Lithium", "Orange"),
            new Room("Beryllium", "Jaune"),
            new Room("Bore", "Vert citron"),
            new Room("Carbon", "Vert Claire"),
            new Room("Azote", "Vert Kaki"),
            new Room("Oxygene", "Bleu Claire"),
            new Room("Fluor", "Bleu Foncé"),
            new Room("Neon", "Violet")


    );

    static List<Room> generateRooms(){
        return new ArrayList<>(DUMMY_ROOMS);
    }

}
