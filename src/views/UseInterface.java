package views;

import models.GeneralFacility;
import models.Room;

import java.util.Date;

public interface UseInterface {
    public boolean isInUseDuringInterval(); // A method to check if a room/facility is in use
    public boolean assignFacilityToUse(GeneralFacility facility); // Assigning a facility to whether or not it is in use
    public float calcUsageRate(); // used to find how often/how much a facility/room/building is used.
    //helper methods
    public String getDetails();// gets details about the use
    public double getDuration();//gets the duration of the facility in use
    public Room getRoom(); //gets the room in use.
    public Date getDate(); //gets the date of usage for the facility
}