import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.beans.IndexedPropertyChangeEvent;
import java.util.Date;

import models.Building;
import models.Facility;
import models.GeneralFacility;
import models.Maintenance;
import models.Room;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMaintenance {
    private Maintenance m;
    private Maintenance.Inspection i;

    @BeforeEach
    public void setUp() {

        m = new Maintenance(new GeneralFacility(1, "facility 1",
                "address 1"), "Leaky faucet", 100.00, new Date(),
                20.0, new Room(new Building(2, "building 2",
                "address 2"), 2, 202));
        i = m.new Inspection();
    }

    @AfterEach
    public void tearDown() {
        m = null;
        i = null;
    }

    @Test
    @DisplayName("Testing getMaintenanceCost")
    public void testGetMaintenanceCost() {
        assertEquals(300.00, m.getMaintenanceCost());
    }

    @Test
    @DisplayName("Testing testIsCompleted")
    public void testIsCompleted() {
        assertEquals(false,m.isCompleted());
        m.setCompleted();
        assertEquals(true, m.isCompleted());
    }

    /* Inspection test */

    @Test
    @DisplayName("Testing pass/fail inspection")
    public void testPassFailInspection() {
       i.failInspection();
       assertEquals(false, i.passed());
       i.passInspection();
       assertEquals(true, i.passed());
    }
}