package views;

import java.util.ArrayList;
import models.*;

public interface FacilityInterface  {
    public static ArrayList<Building> buildings = new ArrayList<Building>();
    ArrayList<MaintenanceRequest> requestedMaintenance = new ArrayList<MaintenanceRequest>(); // all MaintenanceRequest objects
    ArrayList<Use> actualUsage = new ArrayList<Use>(); // all use objects
    ArrayList<Maintenance.Inspection> inspections = new ArrayList<Maintenance.Inspection>(); // all inspection objects

    public int output(); // returns amount of entities processed/created/etc a day
    public String getFacilityInformation(); // returns details for a facility
    public int requestAvailableCapacity(); // returns available capacity for a facility
    public void addFacilityDetails(String details);
    public boolean vacateFacility();
    public double calcMaintenanceCostForFacility();
    public float calcProblemRateForFacility();
    public int calcDownTimeForFacility();
    public ArrayList<Maintenance> listFacilityProblems();
    public boolean makeFacilityMaintRequest(MaintenanceRequest mr);
    public ArrayList<MaintenanceRequest> listMaintRequests();
}