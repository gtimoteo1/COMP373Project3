package models;
import java.util.*;

public class Room {
    String roomID; // will be composed of building code and room number. Example: Cuneo 313 -> 001313 if Cuneo has building code 001
	int roomNumber;
	int capacity;
	boolean inUse;
	boolean inMaintenance;
	ArrayList<RoomObserver> observers;

	public Room(Building building, int capacity, int roomNumber){
		this.roomID = String.valueOf(building.buildingID).concat(String.valueOf(roomNumber));
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.inUse = false;
		this.inMaintenance = false;
		this.observers = new ArrayList<RoomObserver>();
	}

	public int getRoomNumber() { return this.roomNumber; }

	public boolean getUse() { return this.inUse; }
	public boolean getMaintenance() { return this.inMaintenance; }

	public void setUse(Boolean bool) { 
		this.inUse = bool;
		this.notifyObservers("inUse");
	}
	public void setMaintenance(Boolean bool) { 
		this.inUse = bool;
		this.notifyObservers("inMaintenance");
	}

	public void addObserver(){
		this.observers.add(new RoomObserver());
	}

	public void removeObserver(RoomObserver o){
		this.observers.remove(o);
	}

	public void printObservers(){
		for (RoomObserver o: this.observers){
			System.out.println(o);
		}
	}

	public void notifyObservers(String attribute){
		for(RoomObserver o: this.observers) {
			o.update("Set attribute ".concat(attribute));
		}
	}
}
