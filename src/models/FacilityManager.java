package models;

import java.util.ArrayList;

import views.FacilityInterface;

public class FacilityManager {
    ArrayList<GeneralFacility> facilities;

    public FacilityManager(){
        this.facilities = new ArrayList<GeneralFacility>();
    }
    // note: changed from getFacilities() to listFacilities()
    public ArrayList<GeneralFacility> listFacilities(){
        return this.facilities;
    }

    public ArrayList<GeneralFacility> addNewFacility(GeneralFacility newFacility){
        this.facilities.add(newFacility);
        return facilities;
    }

    public void removeFacility(GeneralFacility facility){ this.facilities.remove(facility); }

    // Returns an ArrayList with all Use objects across all facilities
    public ArrayList<Use> listActualUsage() {
        ArrayList<Use> allActualUsage = new ArrayList<Use>();
        for (GeneralFacility f : this.facilities) {
            for (Use u : f.actualUsage ) { allActualUsage.add(u); }
        }
        return allActualUsage;
    }

    // Lists all inspections across all facilities
    public ArrayList<Maintenance.Inspection> listInspections() {
        ArrayList<Maintenance.Inspection> allInspection = new ArrayList<Maintenance.Inspection>();
        for (GeneralFacility f : this.facilities) {
            for (Maintenance.Inspection i : f.inspections ) { allInspection.add(i); }
        }
        return allInspection;
    }

    // List all MaintenanceRequest objects where completed == False
    public ArrayList<MaintenanceRequest> listAllFacilityProblems() {
        ArrayList<MaintenanceRequest> allProblems = new ArrayList<MaintenanceRequest>();
        for (GeneralFacility f : this.facilities) {
            for (MaintenanceRequest mr : f.requestedMaintenance ) {
                if (!(mr.isCompleted())) { allProblems.add(mr); }
            }
        }
        return allProblems;
    }
}