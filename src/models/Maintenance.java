package models;

import java.util.Date;

import views.MaintenanceInterface;

public class Maintenance implements MaintenanceInterface {
    GeneralFacility facility;
    String details;
    double cost;
    double duration; // will be measured in units of hours
    Room room;
    Date date;
    boolean completed;

    // default constructor
    public Maintenance() {
        this.details = "No details available";
        this.completed = false;
        this.cost = 0.00;
        this.facility = new GeneralFacility(0, "Facility 0", "Default details");
        this.duration = 0;
        this.room = new Room(new Building(0, "Building 0", "0000 Default Street"), 0,000);
        this.date = new Date();
    }

    public Maintenance(GeneralFacility facility, String details, double cost, Date date, double dur, Room room) {
        this.facility = facility; this.details = details; this.duration = dur; this.room = room; this.date = date;
        this.cost = dur * 15.0;
        this.completed = false;
    }

    @Override
    public double getMaintenanceCost() { return this.cost; }

    public void setCompleted() { this.completed = true; };

    @Override
    public boolean isCompleted() { return this.completed; }

    @Override
    public String toString() {
        return "Facility + " + this.facility + ", Description = " + this.details + ", " +
                "Date accepted = " + this.date + ", Duration = " + this.duration +
                ", Room Number = " + this.room + ", Completed = " + this.completed;
    }

    @Override
    public Maintenance listMaintenance() { return this; }

    // make Inspection into inner class
    public class Inspection {
        boolean passed;

        public Inspection() { this.passed = true; }

        public void passInspection() { this.passed = true; }

        public void failInspection() { this.passed = false;}

        public boolean passed() { return this.passed; }
    }
}