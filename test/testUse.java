import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import models.Building;
import models.Facility;
import models.GeneralFacility;
import models.Room;
import models.Use;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testUse {
    private Use usage;

    @BeforeEach
    public void setUp() {
        usage = new Use(
                "Faucet Maintenance", new Date(), 100.00, new Room(new Building(2,
                "building 2", "address 2"), 2, 202),
                new GeneralFacility(1, "facility 1", "address 1"));
    }

    @Test
    @DisplayName("Testing assignFacilityToUse")
    public void testAssignFacilityToUse(){
        assertEquals(false, usage.isInUseDuringInterval());
        usage.assignFacilityToUse(new GeneralFacility(1, "facility 1", "address 1"));
        assertEquals(true, usage.isInUseDuringInterval());
    }

    @Test
    @DisplayName("Testing calcUsageRate")
    public void testCalcUsageRate(){
        usage = new Use(
                "Faucet Maintenance", new Date(), 100.00, new Room(new Building(2,
                "building 2", "address 2"), 2, 202),
                new GeneralFacility(1, "facility 1", "address 1"));
        assertEquals(8.0, usage.calcUsageRate());
    }

}