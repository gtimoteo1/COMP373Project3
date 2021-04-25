package models;

import views.FacilityInterface;

abstract class Vaccine {
    protected FacilityInterface productionFacility;
    protected FacilityInterface testFacility;

    protected Vaccine(FacilityInterface pf, FacilityInterface tf) {
        this.productionFacility = pf;
        this.testFacility = tf;
    }

    abstract public void produce();

    abstract public void test();

    abstract public double getEffectivenessRate();
}
