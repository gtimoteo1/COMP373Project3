package models;

import views.Employee;
import views.EmployeeVisitor;

//This is to create a concrete visitor implementing the above class.

public class EmployeeDisplayVisitor implements EmployeeVisitor {
    @Override
    public void visit(Employee employee) {
        System.out.println("Displaying Employee.");
    }
}
