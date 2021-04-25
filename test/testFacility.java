import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import models.Building;
import models.GeneralFacility;
import models.MaintenanceRequest;
import models.Room;

public class testFacility {

    private GeneralFacility facility;
    private Building building;
    private Room room;

    @BeforeAll
    public void setUp() throws Exception{
        facility = new GeneralFacility(1, "LUC", "Chicago's Jesuit University");
        building = new Building(1, "Mundelein", "1032 W.Sheridan Rd, Chicago, IL, 60626");
        room = new Room(building, 45, 311);
    }

    @Test
    @DisplayName("Testing getFacilityInformation")
    public void testGetFacilityInformation(){
        assertTrue(facility.getFacilityInformation() instanceof String);
    }

    @Test
    @DisplayName("Testing requestAvailableCapacity")
    public void testRequestAvailableCapacity(){
        assertEquals(45, facility.requestAvailableCapacity());
    }

    @Test
    @DisplayName("Testing addFacilityDetails")
    public void testAddFacilityDetails() {
        facility.addFacilityDetails(new String("foo"));
        assertTrue(facility.getDetails().contains("foo"));
    }

    @Test
    @DisplayName("Testing vacateFacility")
    public void testVacateFacility() {
        assertTrue(facility.vacateFacility());
        assertEquals(0, facility.listFacilityProblems().size());
    }

    @Test
    @DisplayName("Testing calcMaintenanceCostForFacility")
    public void testCalcMaintenanceCostForFacility(){
        facility.makeFacilityMaintRequest(new MaintenanceRequest(facility, "Leaky facuet", 35.00, new Date(2021, 01, 01), 1.5, room));
        assertEquals(35.0, facility.calcMaintenanceCostForFacility());
    }

    @Test
    @DisplayName("Testing calcProblemRateForFacility")
    public void testCalcProblemRateForFacility(){
        facility.makeFacilityMaintRequest(new MaintenanceRequest(facility, "Leaky facuet", 35, new Date(2021, 01, 01), 1.5, room));
        assertEquals(1.0, facility.calcProblemRateForFacility());
    }

    @Test
    @DisplayName("Testing listFacilityProblems")
    public void testListFacilityProblems(){
        assertEquals(2, facility.listFacilityProblems().size());
    }

    @Test
    @DisplayName("Testing makeFacilityMaintRequest")
    public void testMakeFacilityMaintRequest(){
        assertTrue(facility.makeFacilityMaintRequest(new MaintenanceRequest(facility, "Leaky facuet", 35, new Date(2021, 01, 01), 1.5, room)));
    }

    @Test
    @DisplayName("Testing listMaintRequests")
    public void testListMaintRequests(){
        //should have 3 maint requests by now
        assertEquals(3, facility.listMaintRequests());
    }
}