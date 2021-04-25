import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import models.*;

public class testFacilityManager {
    
    private FacilityManager fm;
    private Room r;
    private Building b;
    private GeneralFacility f;
    private MaintenanceRequest mr; 
    private Maintenance.Inspection i;

    @BeforeAll
    public void setUp() throws Exception{
        fm = new FacilityManager();
        f = new GeneralFacility(1, "LUC WTC", "Water Tower Campus");
        b = new Building(1, "Schreiber", "51 E. Pearson St, Chicago, IL 60622");
        r = new Room(b, 20, 603);
        mr = new MaintenanceRequest(f, "Pipe burst", 25.00, new Date(20201, 01, 01), 1.0, r);
        i = mr.new Inspection();
    }

    @Test
    @DisplayName("Testing addNewFacility")
    public void testAddNewFacility(){
        fm.addNewFacility(f);
        assertEquals(1, fm.listFacilities().size());
    }

    @Test
    @DisplayName("Testing listFacilities")
    public void testListFacilities(){
        assertEquals(1, fm.listFacilities().size());
    }

    @Test
    @DisplayName("Testing listActualUsage")
    public void testListActualUsage(){
        fm.listFacilities().get(0).addUse(new Use("Meeting", new Date(2021, 01, 01), 2.5, r, f));
        assertEquals(1, fm.listActualUsage().size());
    }

    @Test
    @DisplayName("Testing listInspections")
    public void testListInspections(){
        fm.listFacilities().get(0).makeFacilityMaintRequest(mr);
        assertEquals(1, fm.listActualUsage().size());
    }

    @Test
    @DisplayName("Testing listAllFacilityProblems")
    public void testListAllFacilityProblems(){
        //should be a maint request from an earlier test
        assertEquals(1, fm.listAllFacilityProblems().size());        
    }
}
