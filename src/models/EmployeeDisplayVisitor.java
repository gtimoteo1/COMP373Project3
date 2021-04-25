package models;

import views.Employee;
import views.EmployeeVisitor;

//This is to create a concrete visitor implementing the above class.

abstract class EmployeeDisplayVisitor implements EmployeeVisitor {

    public void visit(LabTech tech) {
        System.out.println("Displaying Employee.");
    }
}
