package models;

import views.Employee;
import views.EmployeeVisitor;

//This creates  a concrete class that is extending the class.

abstract class LabTech implements Employee {
    Employee tech;
    String name;
    int ID;

    public LabTech(){
        this.name  = "Tech 1";
        this.ID = 001;
    }

    @Override
    public void accept(EmployeeVisitor employeeVisitor) {
        tech.accept(employeeVisitor);
        employeeVisitor.visit(this);
    }
}
