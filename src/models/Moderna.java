package models;

import views.FacilityInterface;

public class Moderna extends Vaccine {

    public Moderna(FacilityInterface productionFacility, FacilityInterface testFacility) {
        super(productionFacility, testFacility);
    }

    @Override
    public void produce() {

    }

    @Override
    public void test() {

    }
}
