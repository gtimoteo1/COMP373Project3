import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import models.Building;
import models.Facility;
import models.GeneralFacility;
import models.MaintenanceRequest;
import models.Room;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMaintenanceRequest {
    private MaintenanceRequest mr;

    @BeforeEach
    public void setUp() {
        mr = new MaintenanceRequest(new GeneralFacility(1, "facility 1", "address 1"),
                "leaky faucet", 100.00, new Date(), 20.0, new Room(new Building(2,
                "building 2", "address 2"), 2, 202));
    }

    @AfterEach
    public void tearDown() {
        mr = null;
    }

    @Test
    @DisplayName("Testing scheduleMaintenance")
    public void testScheduleMaintenance() {
        assertEquals(false, mr.isAccepted());
        mr.scheduleMaintenance();
        assertEquals(true, mr.isAccepted());
    }
}