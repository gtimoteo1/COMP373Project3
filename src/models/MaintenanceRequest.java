package models;

import java.util.Date;

import views.FacilityInterface;

public class MaintenanceRequest extends Maintenance {
    boolean accepted = false;

    public MaintenanceRequest(GeneralFacility facility, String details, double cost, Date date, double dur, Room room) {
        super(facility, details, cost, date, dur, room);
    }

    public Maintenance scheduleMaintenance() {
        accepted = true;
        return this;
    }

    public boolean isAccepted() { return this.accepted; }

    @Override
    public String toString() {
        if (accepted == false) {
            return "Request Information = \n" + "Accepted = false" + ", Facility = " + facility +
                    ", Details = " + details + ", Room = " + room;
        } else { return "Request Information = \n" + "Accepted = true, " + super.toString() ; }
    }

    public String getDetails() { return this.details; }

    public Date getDate() { return this.date; }

    public double getDuration() { return this.duration; }

    public Room getRoom() { return this.room; }
}