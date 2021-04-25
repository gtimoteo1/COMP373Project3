package models;

import views.FacilityInterface;

public class Moderna extends Vaccine {

    public Moderna(FacilityInterface productionFacility, FacilityInterface testFacility) {
        super(productionFacility, testFacility);
    }

    @Override
    public void produce() {
        productionFacility.output();
    }

    @Override
    public void test() {
        testFacility.output();
    }

    @Override
    public double getEffectivenessRate() {
        return 94.1;
    }
}
