import java.rmi.server.RemoteServer;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Maintenance extends Reservation {
    String details;
    boolean completed;
    float cost;
    Facility facility;

    public Maintenance(Facility facility, String details, int cost, Date date, LocalTime dur, Room room) {
        super(date, dur, room, facility);
        this.facility = facility; this.details = details; this.cost = (dur.getHour() + dur.getMinute()/60) * 15;
        completed = false;
    }

    public int getMaintenanceCost() { return cost; }

    public boolean isCompleted() { return completed; }

    public String toString() {
        return "Facility + " + facility + ", Description = " + details + ", " +
                "Date accepted = " + date + ", Duration = " + duration +
                ", Room Number = " + room + ", Completed = " + completed;
    }
}