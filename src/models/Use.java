package models;

import java.util.ArrayList;
import java.util.Date;

import views.UseInterface;

public class Use implements UseInterface {
    GeneralFacility facility;
    String details;
    Date date; 
    double duration; 
    Room room;
    boolean inUse = false;

    public Use(String details, Date date, double duration, Room room, GeneralFacility facility) {
        inUse = true;
        this.details = details;
        this.facility = facility; 
        this.date = date; 
        this.duration = duration; 
        this.room = room;
    }

    public boolean isInUseDuringInterval() { return inUse; } //returns if facility is in use

    // Assigning a facility to whether or not it is in use
    public boolean assignFacilityToUse(GeneralFacility facility) {
        this.facility = facility;
        inUse = true;
        return inUse;
    }

    public float calcUsageRate() {
        // calculates the proportion of when a facility is in use to when it is open
        // assumes a facility is open 8 hours a day (9-5)
        double totalDuration = 0;
        ArrayList<Use> uses = this.facility.actualUsage;
        for (Use u: uses){
            totalDuration += u.duration;
        }
        double rate = totalDuration/(8.0*uses.size());
        return (float)rate;
    }

//Helper Methods for Use
    public String getDetails() { return this.details; }
    public Date getDate() { return this.date; }
    public double getDuration() { return this.duration; }
    public Room getRoom() { return this.room; }

}