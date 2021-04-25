package models;

import views.FacilityInterface;

public class Pfizer extends Vaccine {

    public Pfizer(FacilityInterface productionFacility, FacilityInterface testFacility) {
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
        return 95.0;
    }
}
